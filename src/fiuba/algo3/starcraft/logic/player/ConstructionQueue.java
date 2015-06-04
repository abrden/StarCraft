package fiuba.algo3.starcraft.logic.player;

import java.util.Collection;
import java.util.LinkedList;

import fiuba.algo3.starcraft.logic.structures.Structure;
import fiuba.algo3.starcraft.logic.structures.Updatable;
import fiuba.algo3.starcraft.logic.units.Unit;

public class ConstructionQueue implements Updatable {

	private Collection<Construction<Structure>> structures;
	private Collection<Construction<Unit>> units;
	
	public ConstructionQueue() {
		structures = new LinkedList<Construction<Structure>>();
		units = new LinkedList<Construction<Unit>>();
	}
	
	public void addUnit(Construction<Unit> construction) {
		units.add(construction);
	}
	
	public void addStructure(Construction<Structure> construction) {
		structures.add(construction);
	}
	
	public void lowerReleases() {
		for (Construction<Structure> construction : structures)
			construction.lowerRelease();
		for (Construction<Unit> construction : units)
			construction.lowerRelease();
	}
	
	public Collection<Unit> gatherFinishedUnits() {
		Collection<Unit> releases = new LinkedList<Unit>();
		for (Construction<Unit> construction : units)
			if (construction.itsFinished())
				releases.add(construction.gather());
		return releases;
	}
	
	public Collection<Structure> gatherFinishedStructures() {
		Collection<Structure> releases = new LinkedList<Structure>();
		for (Construction<Structure> construction : structures)
			if (construction.itsFinished())
				releases.add(construction.gather());
		return releases;
	}

	public void update(Player player) {
		this.lowerReleases();	
	}
}
