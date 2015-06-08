package fiuba.algo3.starcraft.logic.units;

import fiuba.algo3.starcraft.logic.templates.qualities.Life;

public class Clon extends Unit {

	//private Unit clonado;
	
	public Clon(Unit unit) {
		super(unit.getName(), new Life(0, unit.getShield()), unit.getPosition(), unit.getVision(), unit.getStepsPerTurn(), 0);
		//this.clonado = unit;
	}

	public boolean itsAlive() {
		return (life.getShield() > 0);
	}
	
	public void update() {
		life.regenerateShield();
	}

	public void executeEMP() {
		life.destroyShield();
	}
}
