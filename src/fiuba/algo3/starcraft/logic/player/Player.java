package fiuba.algo3.starcraft.logic.player;

import java.util.Collection;
import java.util.LinkedList;

import fiuba.algo3.starcraft.logic.structures.InsufficientResources;
import fiuba.algo3.starcraft.logic.structures.Structure;
import fiuba.algo3.starcraft.logic.structures.StructureID;
import fiuba.algo3.starcraft.logic.units.Unit;

public class Player {
	
	private Resources resources;
	private Collection<Structure> structures;
	private Collection<Unit> units;
	
	private static final int resourcesProducedPerTurn = 10;
	private static final int populationBonusPerDepot = 5;
	private static final int populationMaximum = 200;
	
	public Player(Resources initialResources) {
		resources = initialResources;
		structures = new LinkedList<Structure>();
		units = new LinkedList<Unit>();
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
		//Itera entre sus units y pierde la referencia de las muertas
		this.getRidOfDeadUnits();
		
		//Itera entre sus estructuras y pierde la referencia de las muertas
		this.getRidOfDeadStructures();
		
		//Cada estructura de explotacion junta +10 de su recurso
		this.gains(mineralExploitationStructuresQuantity() * resourcesProducedPerTurn, gasExploitationStructuresQuantity() * resourcesProducedPerTurn);
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
		int pop = 0;
		for (Unit unit : units)
			pop = pop + unit.getPopulationQuota();
		return pop;
	}
	
	public int populationQuota() {
		int populationQuota = (this.depotQuantity() * populationBonusPerDepot);
		if (populationQuota < populationMaximum) return populationQuota;
		else return populationMaximum;
	}
	
	private int mineralExploitationStructuresQuantity() {
		return (this.getMineralExploiters()).size();
	}
	
	private int gasExploitationStructuresQuantity() {
		return (this.getGasExploiters()).size();
	}
	
	private int depotQuantity() {
		return (this.getDepots()).size();
	}
	
	private LinkedList<Structure> getMineralExploiters() {
		return getStructuresWithID(StructureID.MineralExploiter);
	}
	
	private LinkedList<Structure> getGasExploiters() {
		return getStructuresWithID(StructureID.GasExploiter);
	}
	
	private LinkedList<Structure> getDepots() {
		return getStructuresWithID(StructureID.Depot);
	}
	
	private LinkedList<Structure> getStructuresWithID(StructureID id) {
		LinkedList<Structure> wanted = new LinkedList<Structure>();
		for (Structure structure : structures) {
			if (structure.getId() == id)
				wanted.add(structure);
		}
		return wanted;
	}

	public void gains(int mineral, int gas) {
		resources.add(mineral, gas);
	}
	
	public void pays(int mineral, int gas) throws InsufficientResources {
		resources.remove(mineral, gas);
	}

	/*
	idea loca
	private Builder getRaceBuilder() {
		//TODO: implementar este metodo
		return null;
	}
	
	public void newStructureWithID(StructureID id) {
		this.newStructure(this.getRaceBuilder().getTemplate(id).create());
	}
	*/
	
	public void newUnit(Unit unit) {
		units.add(unit);
	}
	
	public void newStructure(Structure structure) {
		structures.add(structure);
	}
}
