package fiuba.algo3.starcraft.logic.structures;

import java.util.Collection;
import java.util.LinkedList;

import fiuba.algo3.starcraft.logic.player.Player;
import fiuba.algo3.starcraft.logic.structures.exceptions.ConstructionNotFinished;
import fiuba.algo3.starcraft.logic.structures.exceptions.ConstructorIsDead;
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

    private void getRidOfDeadConstructions(Collection<Construction> deadStructures) {
        for (Construction<Unit> construction : deadStructures)
            units.remove(construction);
    }
	private Collection<Unit> finishedUnits() {
		Collection<Unit> releases = new LinkedList<Unit>();
        Collection<Construction> deadStructure = new LinkedList<Construction>();
		for (Construction<Unit> construction : units)
			try {
				releases.add(construction.gather());
			} catch (ConstructionNotFinished e) {
				continue;
			} catch (ConstructorIsDead e) {
                deadStructure.add(construction);
            }

        this.getRidOfDeadConstructions(deadStructure);
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
			} catch (ConstructorIsDead e) {
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

	public boolean isEmpty() {
		return structures.size() == 0 && units.size() == 0;
	}
}
