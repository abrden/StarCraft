package fiuba.algo3.starcraft.logic.templates;

import fiuba.algo3.starcraft.logic.structures.Depot;

public class PilonTemplate extends StructureTemplate {
	
	public PilonTemplate() {
		value = new Value(100,0);
		constructionTime = 5;
		life = new Life(300,300);
	}

	public Depot create() {
		// TODO Resolver tiempo de construccion
		return new Depot(life);
	}
}
