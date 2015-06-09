package fiuba.algo3.starcraft.logic.templates.qualities;

import java.util.List;

import fiuba.algo3.starcraft.logic.units.Unit;

public abstract class Power {

	protected List<Unit> affectedUnits;
	
	public void lockUnits(List<Unit> affected) {
		this.affectedUnits = affected;
	}
	
	public abstract int getCost();

	public abstract int getRange();
	
	public abstract void activate();
	
	public abstract void execute(Unit unit);
	
	public abstract boolean itsFinished();

	public void execute() {
		for (Unit unit : affectedUnits) {
			this.execute(unit);
		}
	}

}
