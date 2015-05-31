package fiuba.algo3.starcraft.logic.templates;

import fiuba.algo3.starcraft.logic.structures.ExploitationStructure;

public class NexoMineralTemplate extends StructureTemplate {

	public static NexoMineralTemplate instance = new NexoMineralTemplate();

	private NexoMineralTemplate() {
		value = new Value(50,0);
		constructionTime = 4;
		health = 250;
		shield = 250;
	}
	
	public static NexoMineralTemplate getInstance() {
		return instance;
	}

	public ExploitationStructure create() {
		// TODO: Resolver el tiempo que tarda en construirlo
		return new ExploitationStructure(new Life(health, shield));
	}

}
