package fiuba.algo3.starcraft.logic.structures;

import fiuba.algo3.starcraft.logic.player.Player;
import fiuba.algo3.starcraft.logic.templates.qualities.Life;

public class Depot extends Structure {
	
	private final int populationQuotaIncrement = 5;
	
	public Depot(String name, Life life) {
		super(name, life);
	}

	public StructureID getId() {
		return StructureID.Depot;
	}

	public void update(Player player) {
		player.increasePopulationQuota(populationQuotaIncrement);
	}
}
