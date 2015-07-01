package fiuba.algo3.starcraft.logic.templates.units.terran;

import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.templates.qualities.Life;
import fiuba.algo3.starcraft.logic.templates.qualities.Value;
import fiuba.algo3.starcraft.logic.templates.units.TransportTemplate;
import fiuba.algo3.starcraft.logic.units.TransportUnit;

public class NaveTransporteTerranTemplate extends TransportTemplate {

	private static final String NAME = "Nave Transporte Terran";
	private static final Value VALUE = new Value(100,100);
	private static final int CONSTRUCTION_TIME = 7;
	private static final int VISION = 8000;
	private static final int POPULATION_QUOTA = 2;
	private static final int HEALTH = 150;
	private static final int CAPACITY = 8;
	private static final int STEPS_PER_TURN = 1000;

	public TransportUnit create(Point position) {
		return new TransportUnit(NAME, new Life(HEALTH), position, VISION,
				STEPS_PER_TURN, POPULATION_QUOTA, CAPACITY);
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
	
	public int getPopulationQuota() {
		return POPULATION_QUOTA;
	}

}