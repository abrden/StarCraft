package fiuba.algo3.starcraft.logic.templates.structures.protoss;

import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.structures.MineralExploiter;
import fiuba.algo3.starcraft.logic.templates.qualities.Life;
import fiuba.algo3.starcraft.logic.templates.qualities.Value;
import fiuba.algo3.starcraft.logic.templates.structures.StructureTemplate;


public class NexoMineralTemplate extends StructureTemplate {

	private static NexoMineralTemplate instance = new NexoMineralTemplate();

	private NexoMineralTemplate() {
		name = "Nexo Mineral";
		value = new Value(50,0);
		constructionTime = 4;
		health = 250;
		shield = 250;
	}
	
	public static NexoMineralTemplate getInstance() {
		return instance;
	}

	public MineralExploiter create(Point position) {
		return new MineralExploiter(name, new Life(health, shield), position);
	}

}
