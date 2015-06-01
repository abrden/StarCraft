package fiuba.algo3.starcraft.logic.units;

import java.util.Collection;
import java.util.LinkedList;

import fiuba.algo3.starcraft.logic.templates.Life;

public class TransportUnit extends Unit {
	
	private Collection<Unit> passengers;
	private int capacity;
	
	public TransportUnit(Life life, int vision, int populationQuota, int capacity) {
		super(life, vision, populationQuota);
		passengers = new LinkedList<Unit>();
		this.capacity = capacity;
	}

}
