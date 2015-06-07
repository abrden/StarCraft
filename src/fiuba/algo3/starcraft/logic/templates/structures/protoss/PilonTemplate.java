package fiuba.algo3.starcraft.logic.templates.structures.protoss;

import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.structures.Depot;
import fiuba.algo3.starcraft.logic.templates.qualities.Life;
import fiuba.algo3.starcraft.logic.templates.qualities.Value;
import fiuba.algo3.starcraft.logic.templates.structures.StructureTemplate;

public class PilonTemplate extends StructureTemplate {
	
	private static PilonTemplate instance = new PilonTemplate();

	private PilonTemplate() {
		name = "Pilon";
		value = new Value(100,0);
		constructionTime = 5;
		health = 300;
		shield = 300;
	}

	public static PilonTemplate getInstance() {
		return instance;
	}
	
	public Depot create(Point position) {
		return new Depot(name, new Life(health,shield), position);
	}

}
