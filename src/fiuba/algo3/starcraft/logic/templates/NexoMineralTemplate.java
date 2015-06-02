package fiuba.algo3.starcraft.logic.templates;

import fiuba.algo3.starcraft.logic.structures.MineralExploiter;


public class NexoMineralTemplate extends StructureTemplate {

	private static NexoMineralTemplate instance = new NexoMineralTemplate();

	private NexoMineralTemplate() {
		name = "NexoMineral";
		value = new Value(50,0);
		constructionTime = 4;
		health = 250;
		shield = 250;
	}
	
	public static NexoMineralTemplate getInstance() {
		return instance;
	}

	public MineralExploiter create() {
		// TODO: Resolver el tiempo que tarda en construirlo
		return new MineralExploiter(new Life(health, shield));
	}

}
