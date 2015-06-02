package fiuba.algo3.starcraft.logic.templates;

import fiuba.algo3.starcraft.logic.structures.GasExploiter;
import fiuba.algo3.starcraft.logic.structures.StructureID;

public class AsimiladorTemplate extends StructureTemplate {

	private static AsimiladorTemplate instance = new AsimiladorTemplate();

	private AsimiladorTemplate() {
		value = new Value(100,0);
		constructionTime = 6;
		health = 450;
		shield = 450;
	}
	
	public static AsimiladorTemplate getInstance() {
		return instance;
	}
	
	public GasExploiter create() {
		// TODO Solucionar tiempo de construccion
		return new GasExploiter(new Life(health, shield));
	}

	public StructureID getStructureId() {
		return StructureID.GasExploiter;
	}
}