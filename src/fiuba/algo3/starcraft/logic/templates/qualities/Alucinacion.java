package fiuba.algo3.starcraft.logic.templates.qualities;

import fiuba.algo3.starcraft.logic.units.Clone;
import fiuba.algo3.starcraft.logic.units.Unit;

public class Alucinacion extends Power implements Cloner {

	private static final int COST = 100;
	private static final int RANGE = 0;
	private Clone clone;
	
	public int getCost() {
		return COST;
	}
	
	public int getRange() {
		return RANGE;
	}
	
	public void activate() {
		clone = new Clone(affectedUnits.get(0)); //La unidad a clonar deberia del la unica en los afectados
	}
	
	public void execute(Unit unit) {
		return; //clone.update();
	}
	
	public boolean itsFinished() {
		return (!clone.itsAlive());
	}
	
	public Unit getClone() {
		return clone;
	}
}
