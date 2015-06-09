package fiuba.algo3.starcraft.logic.structures;

import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.player.Player;
import fiuba.algo3.starcraft.logic.templates.qualities.Life;

public class Depot extends Structure {
	
	private static final int POPULATION_QUOTA_INCREMENT = 5;
	private static final int POPULATION_QUOTA_MAXIMUM = 200;
	
	public Depot(String name, Life life, Point position) {
		super(name, life, position);
	}

	public void update(Player player) {
		if(player.populationQuota() != POPULATION_QUOTA_MAXIMUM)
			player.increasePopulationQuota(POPULATION_QUOTA_INCREMENT);
		life.regenerateShield();
	}
}
