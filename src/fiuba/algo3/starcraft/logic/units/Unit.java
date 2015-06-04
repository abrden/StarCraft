package fiuba.algo3.starcraft.logic.units;

import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.templates.qualities.Life;

public abstract class Unit {
	
	protected String name;
	protected int vision;
	protected int populationQuota;
	protected Life life;
	protected Point position;
	protected int stepsPerTurn;
	
	Unit(String name, Life life, int vision, int stepsPerTurn, int populationQuota) {
		this.name = name;
		this.life = life;
		this.vision = vision;
		this.stepsPerTurn = stepsPerTurn;
		this.populationQuota = populationQuota;
	}
	
	public void reduceLife(int damage) {
		life.reduce(damage);
	}

	public boolean itsAlive() {
		return (life.getHealth() > 0);
	}

	public int getStepsPerTurn() {
		return stepsPerTurn;
	}
	
	public int getPopulationQuota() {
		return this.populationQuota;
	}
	
	public int getVision() {
		return this.vision;
	}
	
	public int getShield() {
		return this.life.getShield();
	}
}
