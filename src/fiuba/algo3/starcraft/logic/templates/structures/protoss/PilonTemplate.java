package fiuba.algo3.starcraft.logic.templates.structures.protoss;

import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.structures.Depot;
import fiuba.algo3.starcraft.logic.templates.qualities.Life;
import fiuba.algo3.starcraft.logic.templates.qualities.Value;
import fiuba.algo3.starcraft.logic.templates.structures.StructureTemplate;

public class PilonTemplate extends StructureTemplate {

	private static final String NAME = "Pilon";
	private static final Value VALUE = new Value(100,0);
	private static final int CONSTRUCTION_TIME = 5;
	private static final int HEALTH = 300;
	private static final int SHIELD = 300;
	
	public Depot create(Point position) {
		return new Depot(NAME, new Life(HEALTH, SHIELD), position);
	}
	
	public String getName() {
		return NAME;
	}

	public Value getValue() {
		return VALUE;
	}

	public int getConstructionTime() {
		return CONSTRUCTION_TIME;
	}

}
