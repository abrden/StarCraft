package fiuba.algo3.starcraft.logic.player;

import java.util.Collection;
import java.util.LinkedList;

import fiuba.algo3.starcraft.logic.structures.Structure;
import fiuba.algo3.starcraft.logic.units.Unit;

public class ConstructionQueue {

	private Collection<Construction> structures;
	private Collection<Construction> units;
	
	public ConstructionQueue() {
		structures = new LinkedList<Construction>();
		units = new LinkedList<Construction>();
	}
	
	public void lowerReleases() {
		for (Construction construction : structures)
			construction.lowerRelease();
		for (Construction construction : units)
			construction.lowerRelease();
	}
	
	// TODO Implementar
	public Collection<Unit> gatherFinishedUnits() {
		return null;
	}
	
	public Collection<Structure> gatherFinishedStructures() {
		return null;
	}
}
