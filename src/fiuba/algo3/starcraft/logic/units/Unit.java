package fiuba.algo3.starcraft.logic.units;

import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.templates.qualities.Life;
import fiuba.algo3.starcraft.logic.units.exceptions.StepsLimitExceeded;

public abstract class Unit {
	
	protected final String name;
	protected final int vision;
	protected final int populationQuota;
	protected Life life;
	protected Point position;
	protected final int stepsPerTurn;
	
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

	public int getHealth() {
		return this.life.getHealth();
	}
	
	private boolean iCanGetThere(Point destination) throws StepsLimitExceeded {
		double distance = Math.sqrt((destination.getX()*destination.getX()) + (destination.getY()*destination.getY()));
		
		if (distance < stepsPerTurn) return true;
		else throw new StepsLimitExceeded();
	}
	
	public void setPosition(Point destination) throws StepsLimitExceeded {
		if (this.iCanGetThere(destination)) this.position = destination;
	}
	
	public abstract void update();

}
