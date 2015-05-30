package fiuba.algo3.starcraft.logic.templates;

import fiuba.algo3.starcraft.logic.structures.ExploitationStructure;

public class NexoMineralTemplate extends StructureTemplate {
	
	public NexoMineralTemplate() {
		value = new Value(50,0);
		constructionTime = 4;
		life = new Life(250,250);
	}
	
	public ExploitationStructure create() {
		// TODO: Resolver el tiempo que tarda en construirlo
		return new ExploitationStructure(life);
	}

}
