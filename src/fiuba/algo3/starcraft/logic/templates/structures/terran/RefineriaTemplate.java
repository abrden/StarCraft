package fiuba.algo3.starcraft.logic.templates.structures.terran;

import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.structures.GasExploiter;
import fiuba.algo3.starcraft.logic.templates.qualities.Life;
import fiuba.algo3.starcraft.logic.templates.qualities.Value;
import fiuba.algo3.starcraft.logic.templates.structures.StructureTemplate;

public class RefineriaTemplate extends StructureTemplate {

	private static final String NAME = "Refineria";
	private static final Value VALUE = new Value(100,0);
	private static final int CONSTRUCTION_TIME = 6;
	private static final int HEALTH = 750;
	
	public GasExploiter create(Point position) {
		return new GasExploiter(NAME, new Life(HEALTH), position);
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
