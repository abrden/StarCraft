package fiuba.algo3.starcraft.logic.player;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import fiuba.algo3.starcraft.logic.structures.Structure;

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
		Iterator<Structure> iterator = structures.iterator();
		Structure structure;
		while (iterator.hasNext()) {
			structure = iterator.next();
			if (!structure.itsAlive()) {
				structures.remove(structure);
			}
		}
	}
	
	public int populationQuota() {
		return (this.DepotQuantity() * populationBonusPerDepot);
	}
	
	//TODO: Implementar estos metodos
	private int mineralExploitationStructuresQuantity() {
		return 4;
	}
	
	private int gasExploitationStructuresQuantity() {
		return 2;
	}
	
	private int DepotQuantity() {
		return 1;
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
