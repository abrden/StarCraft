package fiuba.algo3.starcraft.logic.templates.qualities;

import fiuba.algo3.starcraft.logic.units.Unit;

public class TormentaPsionica extends Power {

	private static final String NAME = "Tormenta Psionica";
	private static final int DURATION = 2;
	private int turnsLeft;
	private static final int COST = 75;
	private static final int RANGE = 7;
	
	public String getName() {
		return NAME;
	}
	
	public int getCost() {
		return COST;
	}
	
	public int getRange() {
		return RANGE;
	}
	
	public void activate() {
		turnsLeft = DURATION;
	}
	
	public void execute(Unit unit) {
		unit.executeTormentaPsionica();
		turnsLeft -= 1;
	}
	
	public boolean itsFinished() {
		return (turnsLeft == 0);
	}
	
}
