package fiuba.algo3.starcraft.logic.player;

import java.awt.Color;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import fiuba.algo3.starcraft.logic.map.Map;
import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.map.exceptions.NoResourcesToExtract;
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
import fiuba.algo3.starcraft.logic.units.exceptions.InsufficientEnergy;
import fiuba.algo3.starcraft.logic.units.exceptions.NoMoreSpaceInUnit;
import fiuba.algo3.starcraft.logic.units.exceptions.NoUnitToRemove;
import fiuba.algo3.starcraft.logic.units.exceptions.NonexistentPower;
import fiuba.algo3.starcraft.logic.units.exceptions.StepsLimitExceeded;

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
	
	public void newTurn() {
		this.update();
	}
	
	public Collection<Unit> getUnits() {
		return units;
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
		for (Unit unit : units)
			unit.update();
		
		// Actualizacion de poderes
		Collection<Power> finishedPowers = new LinkedList<Power>();
		for (Power power : activePowers) {
			if (!power.itsFinished()) {
				power.execute();
			} else finishedPowers.add(power);
		}
		for (Power power : finishedPowers)	
			activePowers.remove(power);
	}

	private void getRidOfDeadUnits() {
		LinkedList<Unit> dead = new LinkedList<Unit>();
		for (Unit unit : units)
			if (!unit.itsAlive())
				dead.add(unit);
		for (Unit unit : dead) 
			units.remove(unit);
	}
	
	private void getRidOfDeadStructures() {
		LinkedList<Structure> dead = new LinkedList<Structure>();
		for (Structure structure : structures)
			if (!structure.itsAlive())
				dead.add(structure);
		for (Structure structure : dead) 
			structures.remove(structure);
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
	
	// TODO ver si se usa solo en pruebas
	public void pays(int mineral, int gas) throws InsufficientResources {
		resources.remove(mineral, gas);
	}

	public void newUnitWithName(String name, ConstructionStructure structure) throws InsufficientResources, QuotaExceeded, TemplateNotFound {
		constructionQueue.addUnit(structure.create(name, base, resources, this.currentPopulation(), this.populationQuota()));
	}
	
	public void newStructureWithName(String name, Point position) throws MissingStructureRequired, InsufficientResources, TemplateNotFound, NoResourcesToExtract {
		constructionQueue.addStructure(builder.create(name, position, resources, structures, map));
	}
	
	public void receiveNewUnit(Unit unit) {
		units.add(unit);
	}

	public void receiveNewStructure(Structure structure) {
		map.setStructure(structure, structure.getPosition());
		structures.add(structure);
	}
	
	public void move(Transportable transportable, Point destination) throws StepsLimitExceeded {
		map.moveUnitToDestination(transportable, destination);
	}
	
	// FIXME solo saca dano de tierra!
	public void attack(MuggleUnit unit) {
		List<Unit> opponentUnits = map.unitsInCircumference(unit.getPosition(), unit.getAttackRange(), this.getUnits());
		//List<Unit> opponentUnits = StarCraft.getInstance().unitsInCircumference(unit.getPosition(), unit.getAttackRange(), this);
		
		if (opponentUnits.size() > 0) {
			Unit closestUnit = opponentUnits.get(0);
			closestUnit.reduceLife(unit.getAttackLandDamage());
		}
		/*
		Hacer algo asi pero no tan villero
		
		if (map.getParcelContainingPoint(closestUnit.getPosition()).getSurface() == land) 
			closestUnit.reduceLife(unit.getAttackLandDamage());
		else
			closestUnit.reduceLife(unit.getAttackSpaceDamage());
		*/
	}
	
	public void usePower(MagicalUnit unit, String name, Point position) throws InsufficientEnergy, NonexistentPower {
		Power power = unit.usePower(name);
		power.lockUnits(map.unitsInCircumference(position, power.getRange(), this.getUnits()));
		//power.lockUnits(StarCraft.getInstance().unitsInCircumference(position, power.getRange(), this));
		
		power.activate();
		power.execute();
		if (power instanceof Cloner) this.receiveNewUnit(((Cloner) power).getClone());
		if (!power.itsFinished()) activePowers.add(power);
	}
	
	public void embark(TransportUnit transport, Transportable unit) throws NoMoreSpaceInUnit, StepsLimitExceeded {
		transport.embark(unit);
		map.moveToLimbo(unit);
	}
	
	public void disembark(TransportUnit transport, Transportable unit) throws NoUnitToRemove, StepsLimitExceeded {
		transport.disembark(unit);
		unit.setPosition(transport.getPosition());
	}
}
