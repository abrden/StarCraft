package fiuba.algo3.starcraft.logic.templates.structures.terran;

import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.structures.MineralExploiter;
import fiuba.algo3.starcraft.logic.templates.qualities.Life;
import fiuba.algo3.starcraft.logic.templates.qualities.Value;
import fiuba.algo3.starcraft.logic.templates.structures.StructureTemplate;
public class CentroMineralTemplate extends StructureTemplate {

	private static final String NAME = "Centro Mineral";
	private static final Value VALUE = new Value(50,0);
	private static final int CONSTRUCTION_TIME = 4;
	private static final int HEALTH = 500;
	
	public MineralExploiter create(Point position) {
		return new MineralExploiter(NAME, new Life(HEALTH), position);
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