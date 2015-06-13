package fiuba.algo3.starcraft.logic.structures;

import java.util.Collection;
import java.util.LinkedList;

import fiuba.algo3.starcraft.logic.player.Player;
import fiuba.algo3.starcraft.logic.structures.exceptions.ConstructionNotFinished;
import fiuba.algo3.starcraft.logic.units.Unit;

public class ConstructionQueue {

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
	
	private void lowerReleases() {
		for (Construction<Structure> construction : structures)
			construction.lowerRelease();
		for (Construction<Unit> construction : units)
			construction.lowerRelease();
	}
	
	private Collection<Unit> finishedUnits() {
		Collection<Unit> releases = new LinkedList<Unit>();
		for (Construction<Unit> construction : units)
			//if (construction.itsFinished())
			try {
				releases.add(construction.gather());
			} catch (ConstructionNotFinished e) {
				continue;
			}
		return releases;
	}
	
	private Collection<Structure> finishedStructures() {
		Collection<Structure> releases = new LinkedList<Structure>();
		for (Construction<Structure> construction : structures)
			//if (construction.itsFinished())
			try {
				releases.add(construction.gather());
			} catch (ConstructionNotFinished e) {
				continue;
			}
		return releases;
	}

	public void update(Player player) {
		for (Unit unit : this.finishedUnits())
			player.receiveNewUnit(unit);
		for (Structure structure : this.finishedStructures())
			player.receiveNewStructure(structure);
		
		this.lowerReleases();
	}
}
