package fiuba.algo3.starcraft.logic.templates.qualities;

import fiuba.algo3.starcraft.logic.units.Unit;

public class TormentaPsionica extends Power {

	private static final int DURATION = 2;
	private int executionsLeft;
	private static final int COST = 75;
	private static final int RANGE = 500;
	public static final int DAMAGE = 50;
	
	public int getCost() {
		return COST;
	}
	
	public int getRange() {
		return RANGE;
	}
	
	public void activate() {
		executionsLeft = DURATION * affectedUnits.size();
	}
	
	public void execute(Unit unit) {
		unit.executeTormentaPsionica();
		executionsLeft -= 1;
	}
	
	public boolean itsFinished() {
		return (executionsLeft == 0);
	}
	
}
