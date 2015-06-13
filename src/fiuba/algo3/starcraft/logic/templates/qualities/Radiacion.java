package fiuba.algo3.starcraft.logic.templates.qualities;

import fiuba.algo3.starcraft.logic.units.Unit;

public class Radiacion extends Power {

	private static final int COST = 75;
	private static final int RANGE = 1;
	private Unit target;
	public static final int DAMAGE = 40;
	
	public int getCost() {
		return COST;
	}
	
	public int getRange() {
		return RANGE;
	}
	
	public void activate() {
		target = affectedUnits.get(0); //El target, la unidad mas cercana al punto que toco el jugador, debe ser la primera en la lista de afectados
	}
	
	public void execute(Unit unit) {
		unit.executeRadiacion();
	}
	
	public boolean itsFinished() {
		return (!target.itsAlive());
	}
	
}
