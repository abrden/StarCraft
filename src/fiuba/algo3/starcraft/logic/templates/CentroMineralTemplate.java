package fiuba.algo3.starcraft.logic.templates;

import fiuba.algo3.starcraft.logic.structures.ExploitationStructure;

public class CentroMineralTemplate extends StructureTemplate {
	
	public CentroMineralTemplate() {
		value = new Value(50,0);
		constructionTime = 4;
		life = new Life(500);
	}
	
	public ExploitationStructure create() {
		// TODO: Resolver el tiempo que tarda en construirlo
		return new ExploitationStructure(life);
	}
}