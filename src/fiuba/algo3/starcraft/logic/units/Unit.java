package fiuba.algo3.starcraft.logic.units;

import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.templates.Life;

public abstract class Unit {
	
	protected int vision;
	protected int populationQuota; //suministro
	protected Life life;
	protected Point position;
	
	Unit(Life life, int vision, int populationQuota) {
		this.life = life;
		this.vision = vision;
		this.populationQuota = populationQuota;
	}
	
	public void reduceLife(int damage) {
		life.reduce(damage);
	}

	public boolean itsAlive() {
		return (life.getHealth() > 0);
	}

	public int getPopulationQuota() {
		return this.populationQuota;
	}
}
