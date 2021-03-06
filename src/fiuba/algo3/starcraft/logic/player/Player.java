package fiuba.algo3.starcraft.logic.player;

import java.awt.Color;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import fiuba.algo3.starcraft.logic.game.Actionable;
import fiuba.algo3.starcraft.logic.map.Map;
import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.map.exceptions.NoReachableTransport;
import fiuba.algo3.starcraft.logic.map.exceptions.NoResourcesToExtract;
import fiuba.algo3.starcraft.logic.map.exceptions.StructureCannotBeSetHere;
import fiuba.algo3.starcraft.logic.map.exceptions.UnitCannotBeSetHere;
import fiuba.algo3.starcraft.logic.map.exceptions.UnitCantGetToDestination;
import fiuba.algo3.starcraft.logic.structures.ConstructionQueue;
import fiuba.algo3.starcraft.logic.structures.ConstructionStructure;
import fiuba.algo3.starcraft.logic.structures.Structure;
import fiuba.algo3.starcraft.logic.structures.builders.Builder;
import fiuba.algo3.starcraft.logic.structures.exceptions.InsufficientResources;
import fiuba.algo3.starcraft.logic.structures.exceptions.MissingStructureRequired;
import fiuba.algo3.starcraft.logic.structures.exceptions.QuotaExceeded;
import fiuba.algo3.starcraft.logic.structures.exceptions.TemplateNotFound;
import fiuba.algo3.starcraft.logic.templates.qualities.Cloner;
import fiuba.algo3.starcraft.logic.templates.qualities.Power;
import fiuba.algo3.starcraft.logic.units.MagicalUnit;
import fiuba.algo3.starcraft.logic.units.MuggleUnit;
import fiuba.algo3.starcraft.logic.units.TransportUnit;
import fiuba.algo3.starcraft.logic.units.Transportable;
import fiuba.algo3.starcraft.logic.units.Unit;
import fiuba.algo3.starcraft.logic.units.exceptions.*;

public class Player {
	
	private Builder builder;
	private Color color;
	private String name;
	private Resources resources;
	private Point base;
	private Collection<Structure> structures;
	private Collection<Unit> units;
	private ConstructionQueue constructionQueue;
	private Collection<Power> activePowers;
	private Map map;

	private static final int POPULATION_QUOTA_MAXIMUM = 200;

    public Player(String name, Color color, Builder builder, Point base, Resources initialResources, Map map) {
		this.name = name;
		this.color = color;
		this.builder = builder;
		this.base = base;
		this.resources = initialResources;
		this.structures = new LinkedList<Structure>();
		this.units = new LinkedList<Unit>();
		this.constructionQueue = new ConstructionQueue();
		this.activePowers = new LinkedList<Power>();
		this.map = map;
	}

	public String getName() {
		return name;
	}

	public Color getColor() {
		return color;
	}

	public int getMineral() {
		return resources.getMineral();
	}

	public int getGas() {
		return resources.getGas();
	}

	public Resources getResources() {
		return resources;
	}

	public Builder getBuilder() {
		return builder;
	}

    public String getRace() {
        return builder.getRace();
    }

	public void newTurn() {
		this.update();
	}

	public Iterable<Unit> getUnits() {
		return units;
	}

    public Iterable<Structure> getStructures() {
        return structures;
    }

	public int numberOfUnits() {
		return units.size();
	}

	public int numberOfStructures() {
		return structures.size();
	}

	private void update() {
		// Pierde referencia a Units y Structures muertas
		this.getRidOfDeadUnits();
		this.getRidOfDeadStructures();

		// Recolecta las nuevas Units y Structures y disminuye la release de las que siguen en construccion
		constructionQueue.update(this);

		// Sus estructuras le dan los recursos recolectados
		for (Structure structure : structures)
			structure.getResources(this);

		// Regeneracion de escudos y ganancia de energia en MagicalUnits
		for (Structure structure : structures)
			structure.update();

        //ataque automatico al inicio de cada turno
		for (Unit unit : units){
            if (unit.getAttack() != null){
                this.attack((MuggleUnit) unit);
            }
            unit.update();
        }

		// Actualizacion de poderes
		Collection<Power> finishedPowers = new LinkedList<Power>();
		for (Power power : activePowers) {
			if (!power.itsFinished()) {
				power.execute();
			} else finishedPowers.add(power);
		}
		for (Power power : finishedPowers)
			activePowers.remove(power);

        //Unidades caminan hasta el punto indicado en turnos anteriores
        for (Unit unit : units) {
            if (!unit.getPosition().isSamePoint(unit.getDestination()) && !unit.getPosition().isSamePoint(map.getLimbo())) {
                try {
                    this.move(unit, unit.getDestination());
				} catch (UnitCantGetToDestination | UnitAlreadyMovedThisTurn e) {

				}
            }
        }
	}

	private void getRidOfDeadUnits() {
		LinkedList<Unit> dead = new LinkedList<Unit>();
		for (Unit unit : units)
			if (!unit.itsAlive()){
                dead.add(unit);
            }
		for (Unit unit : dead)
			units.remove(unit);
	}

	private void getRidOfDeadStructures() {
		LinkedList<Structure> dead = new LinkedList<Structure>();
		for (Structure structure : structures)
			if (!structure.itsAlive())
				dead.add(structure);
        for (Structure structure : dead) {
			map.removeStructureFrom(structure.getPosition());
			structures.remove(structure);
		}
	}

	public boolean constructionQueueIsEmpty() {
		return constructionQueue.isEmpty();
	}
	public int populationSpace() {
		return (this.populationQuota() - this.currentPopulation());
	}

	public int currentPopulation() {
		int population = 0;
		for (Unit unit : units)
			population = population + unit.getPopulationQuota();
		return population;
	}

	public int populationQuota() {
		int populationQuota = 0;
		for (Structure structure : structures)
			populationQuota += structure.getPopulationQuotaIncrement();
		if (populationQuota > POPULATION_QUOTA_MAXIMUM) return POPULATION_QUOTA_MAXIMUM;
		else return populationQuota;
	}

	public void gains(int mineral, int gas) {
		resources.add(mineral, gas);
	}

	public void pays(int mineral, int gas) throws InsufficientResources {
		resources.remove(mineral, gas);
	}

	public void newUnitWithName(String name, ConstructionStructure structure) throws InsufficientResources, QuotaExceeded, TemplateNotFound {
		constructionQueue.addUnit(structure.create(name, structure.getPosition(), resources, this.currentPopulation(), this.populationQuota()));
	}

	public void newStructureWithName(String name, Point position) throws MissingStructureRequired, InsufficientResources, TemplateNotFound, NoResourcesToExtract, StructureCannotBeSetHere {
        if (map.getParcelContainingPoint(position).getStructure() != null) throw new StructureCannotBeSetHere();
        if (map.structureInConstruction(position)) throw new StructureCannotBeSetHere();
		constructionQueue.addStructure(builder.create(name, position, resources, structures, map));
        map.getParcelContainingPoint(position).setConstruction();
        map.addStructureInConstruction(position);
	}

    public void receiveNewUnit(Unit unit) {
        if (!map.getParcelContainingPoint(unit.getPosition()).letPass(unit))
            map.getPositionNearStructure(unit);
        unit.setColor(this.getColor());
		units.add(unit);
		try {
			unit.addToMapView(this.map.getMapView());
		} catch (Exception e) {

		}
	}

	public void receiveNewStructure(Structure structure) {
		map.setStructure(structure, structure.getPosition());
        map.removeStructureInConstruction(structure.getPosition());
		structures.add(structure);
	}
	
	public void move(Unit unit, Point destination) throws UnitCantGetToDestination, UnitAlreadyMovedThisTurn {
        if (unit.getMovedThisTurn()) throw new UnitAlreadyMovedThisTurn();
        unit.setDestination(destination);
		map.moveUnitToDestination(unit, destination);
        unit.setMovedThisTurn(true);
	}
	
	public void attack(MuggleUnit unit) {
		List<Unit> opponentUnits = map.enemyUnitsInCircle(unit.getPosition(), unit.getAttackRange(), this.getUnits());
        if (opponentUnits.size() > 0) {
			Unit closestUnit = opponentUnits.get(0);
			if (closestUnit.canFly()) {
				closestUnit.reduceLife(unit.getAttackSpaceDamage());
			} else {
				closestUnit.reduceLife(unit.getAttackLandDamage());
			}
            return;
		}
        //si no hay unidades busca estructuras
        List<Structure> opponentStructures = map.enemyStructuresInCircle(unit.getPosition(), unit.getAttackRange(), this.getStructures());
        if (opponentStructures.size() > 0) {
            Structure closestStructure = opponentStructures.get(0);
            closestStructure.reduceLife(unit.getAttackLandDamage());
        }
	}
	
	public void usePower(MagicalUnit unit, String name, Point position) throws InsufficientEnergy, NonexistentPower {
		Power power = unit.usePower(name);
		power.lockUnits(map.unitsUnderInfluenceOfPower(position, power.getRange(), this.getUnits()));
	
		power.activate();
		power.execute();
		if (power instanceof Cloner) 
			for (Unit clone : ((Cloner) power).getClones())
				this.receiveNewUnit(clone);
		if (!power.itsFinished()) activePowers.add(power);
    }
	
	private TransportUnit nearestTransportInUnitRange(Transportable unit) throws NoReachableTransport {
		return map.transportUnitsInCircle(unit.getPosition(), unit.getStepsPerTurn() * (int)map.PARCEL_SIDE , units).get(0);
	}
	
	public void embark(Transportable unit) throws NoMoreSpaceInUnit, StepsLimitExceeded, NoReachableTransport {
		this.nearestTransportInUnitRange(unit).embark(unit);
		map.moveToLimbo(unit);
	}

	public void disembark(TransportUnit transport, Transportable unit) throws NoUnitToRemove, StepsLimitExceeded, UnitCannotBeSetHere {
        map.setUnit((Unit) unit, transport.getPosition());
        ((Unit) unit).setDestination(unit.getPosition());
		transport.disembark(unit);
	}

	public boolean actionableIsMine(Actionable actionable) {
		if (units.contains(actionable)) {
			return true;
		}
		if (structures.contains(actionable)) {
			return true;
		}
		return false;
	}
}
