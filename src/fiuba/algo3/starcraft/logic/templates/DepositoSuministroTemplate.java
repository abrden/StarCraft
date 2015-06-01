package fiuba.algo3.starcraft.logic.templates;

import fiuba.algo3.starcraft.logic.structures.Depot;
import fiuba.algo3.starcraft.logic.structures.StructureID;

public class DepositoSuministroTemplate extends StructureTemplate {
	
	private static DepositoSuministroTemplate instance = new DepositoSuministroTemplate();

	private DepositoSuministroTemplate() {
		value = new Value(100,0);
		constructionTime = 6;
		health = 500;
	}

	public Depot create() {
		//TODO: Resolver tiempo de construccion
		return new Depot(new Life(health));
	}
	public static DepositoSuministroTemplate getInstance() {
		return instance;
	}

}
