package fiuba.algo3.starcraft.logic.structures;

import fiuba.algo3.starcraft.logic.game.Actionable;
import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.templates.qualities.Life;

public class Depot extends Structure implements Actionable {
	
	private static final int POPULATION_QUOTA_INCREMENT = 5;
	
	public Depot(String name, Life life, Point position) {
		super(name, life, position);
	}

	public void update() {
		life.regenerateShield();
	}
	
	public int getPopulationQuotaIncrement() {
		return POPULATION_QUOTA_INCREMENT;
	}
}
