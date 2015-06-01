package fiuba.algo3.starcraft.logic.templates;

import fiuba.algo3.starcraft.logic.structures.MineralExploiter;
import fiuba.algo3.starcraft.logic.structures.StructureID;

public class CentroMineralTemplate extends StructureTemplate {

	private static CentroMineralTemplate instance = new CentroMineralTemplate();

	private CentroMineralTemplate() {
		value = new Value(50,0);
		constructionTime = 4;
		health = 500;
	}
	
	public static CentroMineralTemplate getInstance() {
		return instance;
	}
	
	public MineralExploiter create() {
		// TODO: Resolver el tiempo que tarda en construirlo
		return new MineralExploiter(new Life(health));
	}

}