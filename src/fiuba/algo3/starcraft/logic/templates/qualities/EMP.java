package fiuba.algo3.starcraft.logic.templates.qualities;

import fiuba.algo3.starcraft.logic.units.Unit;

public class EMP extends Power {

	private static final String NAME = "EMP";
	private static final int COST = 100;
	private static final int RANGE = 10;
	private boolean finished;
			
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
		finished = false;
	}
	
	public void execute(Unit unit) {
		unit.executeEMP();
		finished = true;
	}
	
	public boolean itsFinished() {
		return finished;
	}
	
}
