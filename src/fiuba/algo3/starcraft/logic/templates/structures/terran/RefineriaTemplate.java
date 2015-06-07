package fiuba.algo3.starcraft.logic.templates.structures.terran;

import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.structures.GasExploiter;
import fiuba.algo3.starcraft.logic.templates.qualities.Life;
import fiuba.algo3.starcraft.logic.templates.qualities.Value;
import fiuba.algo3.starcraft.logic.templates.structures.StructureTemplate;


public class RefineriaTemplate extends StructureTemplate {
	
	private static RefineriaTemplate instance = new RefineriaTemplate();

	private RefineriaTemplate() {
		name = "Refineria";
		value = new Value(100,0);
		constructionTime = 6;
		health = 750;
	}
	
	public static RefineriaTemplate getInstance() {
		return instance;
	}
	
	public GasExploiter create(Point position) {
		return new GasExploiter(name, new Life(health), position);
	}

}
