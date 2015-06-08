package fiuba.algo3.starcraft.logic.templates.qualities;

import fiuba.algo3.starcraft.logic.units.Clon;
import fiuba.algo3.starcraft.logic.units.Unit;

public class Alucinacion extends Power {

	private static final String NAME = "Alucinacion";
	private static final int COST = 100;
	private static final int RANGE = 0;
	private Clon clon;
	
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
		clon = new Clon(affectedUnits.get(0)); //La unidad a clonar deberia del la unica en los afectados
	}
	
	public void execute(Unit unit) {
		clon.update();
	}
	
	public boolean itsFinished() {
		return (!clon.itsAlive());
	}
}
