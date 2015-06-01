package fiuba.algo3.starcraft.logic.templates;

import fiuba.algo3.starcraft.logic.structures.Depot;

public class PilonTemplate extends StructureTemplate {
	
	private static PilonTemplate instance = new PilonTemplate();

	private PilonTemplate() {
		value = new Value(100,0);
		constructionTime = 5;
		health = 300;
		shield = 300;
	}

	public static PilonTemplate getInstance() {
		return instance;
	}
	
	public Depot create() {
		// TODO Resolver tiempo de construccion
		return new Depot(new Life(health,shield));
	}

}
