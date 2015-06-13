package fiuba.algo3.starcraft.logic.templates.units.protoss;

import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.templates.qualities.Life;
import fiuba.algo3.starcraft.logic.templates.qualities.Value;
import fiuba.algo3.starcraft.logic.templates.units.TransportTemplate;
import fiuba.algo3.starcraft.logic.units.TransportUnit;

public class NaveTransporteProtossTemplate extends TransportTemplate {

	private static final String NAME = "Nave Transporte";
	private static final Value VALUE = new Value(200,0);
	private static final int CONSTRUCTION_TIME = 8;
	private static final int VISION = 8;
	private static final int POPULATION_QUOTA = 2;
	private static final int HEALTH = 80;
	private static final int SHIELD = 60;
	private static final int CAPACITY = 8;
	private static final int STEPS_PER_TURN = 8;
	
	public TransportUnit create(Point position) {
		return new TransportUnit(NAME, new Life(HEALTH, SHIELD), position, VISION,
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
	/*
    public NaveTransporteProtossTemplate() {
        name = "Nave Transporte";
        value = new Value(200,0);
        constructionTime = 8;
        vision = 8;
        populationQuota = 2;
        health = 80;
        shield = 60;
        capacity = 8;
        stepsPerTurn = 8;
    }

    public TransportUnit create(Point position) {
        return new TransportUnit(name, new Life(health, shield), position, vision, stepsPerTurn, populationQuota, capacity);
    }
    */
}