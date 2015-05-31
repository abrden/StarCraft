package fiuba.algo3.starcraft.logic.player;

import java.util.Collection;
import java.util.LinkedList;

import fiuba.algo3.starcraft.logic.structures.Structure;
import fiuba.algo3.starcraft.logic.structures.StructureID;

public class Player {
	
	private Resources resources;
	private Collection<Structure> structures;
	
	private static final int resourcesProducedPerTurn = 10;
	private static final int populationBonusPerDepot = 5;
	//private static final int populationMaximum = 200;
	
	public Player(Resources initialResources) {
		resources = initialResources;
		structures = new LinkedList<Structure>();
		
	}
	
	public int getMineral() {
		return resources.getMineral();
	}

	public int getGas() {
		return resources.getGas();
	}
	
	public void newTurn() {
		//Cada estructura de explotacion junta +10 de su recurso
		this.gains(mineralExploitationStructuresQuantity() * resourcesProducedPerTurn, gasExploitationStructuresQuantity() * resourcesProducedPerTurn);
		//Itera entre sus estructuras y pierde la referencia de las muertas
		this.getRidOfDeadStructures();
	}
	
	private void getRidOfDeadStructures() {
		LinkedList<Structure> dead = new LinkedList<Structure>();
		for (Structure structure : structures)
			if (!structure.itsAlive())
				dead.add(structure);
		for (Structure structure : dead) 
			structures.remove(structure);
		}
	
	public int populationQuota() {
		return (this.depotQuantity() * populationBonusPerDepot);
	}
	
	//TODO: Implementar estos 3 metodos
	private int mineralExploitationStructuresQuantity() {
		return 1;
	}
	
	private int gasExploitationStructuresQuantity() {
		return 2;
	}
	
	private LinkedList<Structure> getDepots() {
		LinkedList<Structure> depots = new LinkedList<Structure>();
		for (Structure structure : structures) {
			if (structure.getId() == StructureID.Depot)
				depots.add(structure);
		}
		return depots;
	}
	
	private int depotQuantity() {
		return (this.getDepots()).size();
	}

	public void gains(int mineral, int gas) {
		resources.add(mineral, gas);
	}
	
	public void pays(int mineral, int gas) {
		resources.remove(mineral, gas);
	}

	public void newStructure(Structure structure) {
		structures.add(structure);
	}
}
