package fiuba.algo3.starcraft.logic.units;

import java.util.Collection;
import java.util.LinkedList;

import fiuba.algo3.starcraft.logic.templates.qualities.Life;

public class TransportUnit extends Unit {
	
	private Collection<Transportable> passengers;
	private final int capacity;
	
	public TransportUnit(String name, Life life, int vision, int stepsPerTurn, int populationQuota, int capacity) {
		super(name, life, vision, stepsPerTurn, populationQuota);
		passengers = new LinkedList<Transportable>();
		this.capacity = capacity;
	}
		
	public void embark(Transportable unit) {
		if (this.theresSpaceForPassenger(unit))
			passengers.add(unit);
	}
	
	public void disembark(Transportable unit) {
		passengers.remove(unit);
	}
	
	private boolean theresSpaceForPassenger(Transportable unit) {
		return (this.freeSpace() >= unit.getTransportQuota());
	}
	
	private int freeSpace() {
		int spaceTaken = 0;
		for (Transportable unit : passengers)
			spaceTaken = spaceTaken + unit.getTransportQuota();
		return (capacity - spaceTaken);
	}
}
