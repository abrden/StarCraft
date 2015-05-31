package fiuba.algo3.starcraft.logic.templates;

import fiuba.algo3.starcraft.logic.structures.ExploitationStructure;

public class AsimiladorTemplate extends StructureTemplate {

	public static AsimiladorTemplate instance = new AsimiladorTemplate();

	private AsimiladorTemplate() {
		value = new Value(100,0);
		constructionTime = 6;
		life = new Life(450,450);
	}
	
	public static AsimiladorTemplate getInstance() {
		return instance;
	}
	
	public ExploitationStructure create() {
		// TODO Solucionar tiempo de construccion
		return new ExploitationStructure(life);
	}
}
