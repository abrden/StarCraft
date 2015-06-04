package fiuba.algo3.starcraft.logic.units;

import java.util.Collection;
import java.util.LinkedList;

import fiuba.algo3.starcraft.logic.templates.qualities.Life;

public class TransportUnit extends Unit {
	
	private Collection<Unit> passengers;
	private int capacity;
	
	public TransportUnit(String name, Life life, int vision, int stepsPerTurn, int populationQuota, int capacity) {
		super(name, life, vision, stepsPerTurn, populationQuota);
		passengers = new LinkedList<Unit>();
		this.capacity = capacity;
	}
/*
	public void embark(Unit unit) {
		if (this.theresSpaceForPassenger(unit))
			passengers.add(unit);
	}
	
	private boolean theresSpaceForPassenger(Unit unit) {
		return (this.freeSpace() >= unit.getTransportQuota());
	}
	
	private int freeSpace() {
		int spaceTaken = 0;
		for (Unit unit : passengers)
			spaceTaken = spaceTaken + unit.getTransportQuota();
		return (capacity - spaceTaken);
	}
*/
}
