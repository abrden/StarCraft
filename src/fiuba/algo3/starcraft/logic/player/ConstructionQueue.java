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
	
	public void addUnit(Construction construction) {
		units.add(construction);
	}
	
	public void addStructure(Construction construction) {
		structures.add(construction);
	}
	
	public void lowerReleases() {
		for (Construction construction : structures)
			construction.lowerRelease();
		for (Construction construction : units)
			construction.lowerRelease();
	}
	
	public Collection<Unit> gatherFinishedUnits() {
		Collection<Unit> releases = new LinkedList<Unit>();
		for (Construction construction : units)
			if (construction.itsFinished())
				releases.add((Unit) construction.gather());
		return releases;
	}
	
	public Collection<Structure> gatherFinishedStructures() {
		Collection<Structure> releases = new LinkedList<Structure>();
		for (Construction construction : structures)
			if (construction.itsFinished())
				releases.add((Structure) construction.gather());
		return releases;
	}
}
