package fiuba.algo3.starcraft.logic.structures;

import fiuba.algo3.starcraft.logic.player.Player;
import fiuba.algo3.starcraft.logic.templates.qualities.Life;

public class Depot extends Structure {
	
	private static final int POPULATION_QUOTA_INCREMENT = 5;
	
	public Depot(String name, Life life) {
		super(name, life);
	}

	public void update(Player player) {
		player.increasePopulationQuota(POPULATION_QUOTA_INCREMENT);
		life.regenerateShield();
	}
}
