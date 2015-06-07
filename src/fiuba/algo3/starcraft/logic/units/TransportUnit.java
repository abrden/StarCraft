package fiuba.algo3.starcraft.logic.units;

import java.util.Collection;
import java.util.LinkedList;

import fiuba.algo3.starcraft.logic.templates.qualities.Life;
import fiuba.algo3.starcraft.logic.units.exceptions.NoMoreSpaceInUnit;
import fiuba.algo3.starcraft.logic.units.exceptions.NoUnitToRemove;

public class TransportUnit extends Unit {
	
	private Collection<Transportable> passengers;
	private final int capacity;
	
	public TransportUnit(String name, Life life, int vision, int stepsPerTurn, int populationQuota, int capacity) {
		super(name, life, vision, stepsPerTurn, populationQuota);
		passengers = new LinkedList<Transportable>();
		this.capacity = capacity;
	}
		
	public void embark(Transportable unit) throws NoMoreSpaceInUnit {
		if (this.theresSpaceForPassenger(unit))
			passengers.add(unit);
		else
			throw new NoMoreSpaceInUnit();
	}

	public void disembark(Transportable unit) throws NoUnitToRemove {
		if (passengers.size() > 0)
			passengers.remove(unit);
		else
			throw new NoUnitToRemove();
	}

	private boolean theresSpaceForPassenger(Transportable unit) {
		return (this.freeSpace() >= unit.getTransportQuota());
	}
	
	public int freeSpace() {
		int spaceTaken = 0;
		for (Transportable unit : passengers)
			spaceTaken = spaceTaken + unit.getTransportQuota();
		return (capacity - spaceTaken);
	}
	
	public void update() {
		life.regenerateShield();
	}
}
