package fiuba.algo3.starcraft.logic.templates.qualities;

import java.util.Collection;

import fiuba.algo3.starcraft.logic.units.Unit;

public class Power {

	private int cost;
	private int range;
	private Collection<Unit> affectedUnits;
	
	public Power(int cost, int range) {
		this.cost = cost;
		this.range = range;
	}
	
	public int getCost() {
		return cost;
	}
	
	public int getRange() {
		return range;
	}
	
	public void lockAfectedUnits(Collection<Unit> affected) {
		this.affectedUnits = affected;
	}
}
