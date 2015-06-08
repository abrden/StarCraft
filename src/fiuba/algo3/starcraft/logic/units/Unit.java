package fiuba.algo3.starcraft.logic.units;

import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.templates.qualities.Life;
import fiuba.algo3.starcraft.logic.units.exceptions.StepsLimitExceeded;

public abstract class Unit {
	
	protected final String name;
	protected final int vision;
	protected final int populationQuota;
	protected final Life life;
	protected Point position;
	protected final int stepsPerTurn;
	
	Unit(String name, Life life, Point position, int vision, int stepsPerTurn, int populationQuota) {
		this.name = name;
		this.life = life;
		this.position = position;
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
		return populationQuota;
	}
	
	public String getName() {
		return name;
	}
	
	public int getVision() {
		return vision;
	}
	
	public int getShield() {
		return life.getShield();
	}

	public int getHealth() {
		return life.getHealth();
	}
	
	private boolean iCanGetThere(Point destination) throws StepsLimitExceeded {
		double distance = position.distance(destination);
		
		if (distance < stepsPerTurn) return true;
		else throw new StepsLimitExceeded();
	}
	
	public void setPosition(Point destination) throws StepsLimitExceeded {
		if (this.iCanGetThere(destination)) this.position = destination;
	}
	
	public abstract void update();

	public Point getPosition() {
		return position;
	}

	// TODO Emprolijar estos metodos de poderes, sacar hardcodeos etc
	public void executeTormentaPsionica() {
		this.reduceLife(50);
	}

	public abstract void executeEMP();

	public void executeRadiacion() {
		this.reduceLife(40);
	}

}
