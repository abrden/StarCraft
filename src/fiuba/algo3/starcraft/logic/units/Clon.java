package fiuba.algo3.starcraft.logic.units;

import fiuba.algo3.starcraft.logic.templates.qualities.Life;

public class Clon extends Unit {

	private Unit clonado;
	private Life life;
	
	Clon(Unit clonado, String name) {
		super(name, new Life(0, clonado.getShield()), clonado.getVision(), clonado.getStepsPerTurn(), 0);
		this.clonado = clonado;
	}

	public boolean itsAlive() {
		return (life.getShield() > 0);
	}

}
