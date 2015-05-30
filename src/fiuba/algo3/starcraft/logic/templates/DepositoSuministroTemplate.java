package fiuba.algo3.starcraft.logic.templates;

import fiuba.algo3.starcraft.logic.structures.Depot;

public class DepositoSuministroTemplate extends StructureTemplate {

	public DepositoSuministroTemplate() {
		value = new Value(100,0);
		constructionTime = 6;
		life = new Life(500);
	}

	public Depot create() {
		//TODO: Resolver tiempo de construccion
		return new Depot(life);
	}
}
