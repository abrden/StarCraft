package fiuba.algo3.starcraft.logic.templates.structures.terran;

import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.structures.Depot;
import fiuba.algo3.starcraft.logic.templates.qualities.Life;
import fiuba.algo3.starcraft.logic.templates.qualities.Value;
import fiuba.algo3.starcraft.logic.templates.structures.StructureTemplate;

public class DepositoSuministroTemplate extends StructureTemplate {

	private static final String NAME = "Deposito Suministro";
	private static final Value VALUE = new Value(100,0);
	private static final int CONSTRUCTION_TIME = 6;
	private static final int HEALTH = 500;
	
	public Depot create(Point position) {
		return new Depot(NAME, new Life(HEALTH), position);
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
