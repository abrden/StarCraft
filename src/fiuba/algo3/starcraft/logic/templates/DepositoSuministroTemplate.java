package fiuba.algo3.starcraft.logic.templates;

import fiuba.algo3.starcraft.logic.structures.Depot;

public class DepositoSuministroTemplate extends StructureTemplate {
	
	private static DepositoSuministroTemplate instance = new DepositoSuministroTemplate();

	private DepositoSuministroTemplate() {
		name = "Deposito Suministro";
		value = new Value(100,0);
		constructionTime = 6;
		health = 500;
	}

	public Depot create() {
		//TODO: Resolver tiempo de construccion
		return new Depot(name, new Life(health));
	}
	public static DepositoSuministroTemplate getInstance() {
		return instance;
	}

}
