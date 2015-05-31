package fiuba.algo3.starcraft.logic.templates;

import fiuba.algo3.starcraft.logic.structures.ExploitationStructure;

public class RefineriaTemplate extends StructureTemplate {
	
	public RefineriaTemplate() {
		value = new Value(100,0);
		constructionTime = 6;
		life = new Life(750);
	}

	public ExploitationStructure create() {
		// TODO Resolver tiempo de construccion
		return new ExploitationStructure(life);
	}
}
