package fiuba.algo3.starcraft.logic.templates.structures.terran;

import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.structures.MineralExploiter;
import fiuba.algo3.starcraft.logic.templates.qualities.Life;
import fiuba.algo3.starcraft.logic.templates.qualities.Value;
import fiuba.algo3.starcraft.logic.templates.structures.StructureTemplate;

public class CentroMineralTemplate extends StructureTemplate {

	private static CentroMineralTemplate instance = new CentroMineralTemplate();

	private CentroMineralTemplate() {
		name = "Centro Mineral";
		value = new Value(50,0);
		constructionTime = 4;
		health = 500;
	}
	
	public static CentroMineralTemplate getInstance() {
		return instance;
	}
	
	public MineralExploiter create(Point position) {
		return new MineralExploiter(name, new Life(health), position);
	}

}