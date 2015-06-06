package fiuba.algo3.starcraft.logic.player;

import java.awt.Color;
import java.util.Collection;
import java.util.LinkedList;

import fiuba.algo3.starcraft.logic.structures.ConstructionQueue;
import fiuba.algo3.starcraft.logic.structures.ConstructionStructure;
import fiuba.algo3.starcraft.logic.structures.Structure;
import fiuba.algo3.starcraft.logic.structures.builders.Builder;
import fiuba.algo3.starcraft.logic.structures.exceptions.InsufficientResources;
import fiuba.algo3.starcraft.logic.structures.exceptions.MissingStructureRequired;
import fiuba.algo3.starcraft.logic.structures.exceptions.QuotaExceeded;
import fiuba.algo3.starcraft.logic.structures.exceptions.TemplateNotFound;
import fiuba.algo3.starcraft.logic.units.Unit;

public class Player {
	
	private Builder builder;
	private Color color;
	private String name;
	private Resources resources;
	private Collection<Structure> structures;
	private Collection<Unit> units;
	private ConstructionQueue constructionQueue;
	private int populationQuota;
	
	public Player(String name, Color color, Builder builder, Resources initialResources) {
		this.name = name;
		this.color = color;
		this.builder = builder;
		this.resources = initialResources;
		this.structures = new LinkedList<Structure>();
		this.units = new LinkedList<Unit>();
		this.constructionQueue = new ConstructionQueue();
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
		
		//Visitar cola de construccion
		//this.updateConstructionQueue();
		
		//Itera entre sus units y pierde la referencia de las muertas
		//this.getRidOfDeadUnits();
		//Itera entre sus estructuras y pierde la referencia de las muertas
		//this.getRidOfDeadStructures();
		
		//Cada estructura de explotacion junta +10 de su recurso
		//this.gains(mineralExploitationStructuresQuantity() * resourcesProducedPerTurn, gasExploitationStructuresQuantity() * resourcesProducedPerTurn);
	}

	private void update() {
		// Pierde referencia a Units y Structures muertas
		this.getRidOfDeadUnits();
		this.getRidOfDeadStructures();
		
		// Recolecta las nuevas Units y Structures y disminuye la release de las que siguen en construccion
		constructionQueue.update(this);
		
		// Sus estructuras le dan los recursos recolectados y redefinen su cupa poblacional
		populationQuota = 0;
		for (Structure structure : structures)
			structure.update(this);
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
	
	/*
	private void updateConstructionQueue() {
		// Gather finished constructions
		structures.addAll(constructionQueue.finishedStructures());
		units.addAll(constructionQueue.finishedUnits());
		
		// Lower releases
		constructionQueue.lowerReleases();
	}
	*/
	
	public int populationSpace() {
		return (populationQuota - this.currentPopulation());
	}
	
	public int currentPopulation() {
		int population = 0;
		for (Unit unit : units)
			population = population + unit.getPopulationQuota();
		return population;
	}
	
	public int populationQuota() {
		return populationQuota;
	}
	
	/*
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
	*/

	public void gains(int mineral, int gas) {
		resources.add(mineral, gas);
	}
	
	// TODO ver si se usa solo en pruebas
	public void pays(int mineral, int gas) throws InsufficientResources {
		resources.remove(mineral, gas);
	}

	public void newUnitWithName(String name, ConstructionStructure structure) throws InsufficientResources, QuotaExceeded, TemplateNotFound {
		constructionQueue.addUnit(structure.create(name, resources, this.currentPopulation(), populationQuota));
	}
	
	public void newStructureWithName(String name) throws MissingStructureRequired, InsufficientResources, TemplateNotFound {
		constructionQueue.addStructure(builder.create(name, resources, structures));
	}
	
	public void receiveNewUnit(Unit unit) {
		units.add(unit);
	}

	public void receiveNewStructure(Structure structure) {
		structures.add(structure);
	}

	public void increasePopulationQuota(int populationQuotaIncrement) {
		populationQuota += 5;
	}

}
