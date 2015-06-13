package fiuba.algo3.starcraft.logic.templates.units.protoss;

import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.templates.qualities.AltoTemplarioPowerGenerator;
import fiuba.algo3.starcraft.logic.templates.qualities.Life;
import fiuba.algo3.starcraft.logic.templates.qualities.Value;
import fiuba.algo3.starcraft.logic.templates.units.MagicalTemplate;
import fiuba.algo3.starcraft.logic.units.MagicalUnit;

public class AltoTemplarioTemplate extends MagicalTemplate {
	
	private static final String NAME = "Alto Templario";
	private static final Value VALUE = new Value(50,150);
	private static final int CONSTRUCTION_TIME = 7;
	private static final int VISION = 7;
	private static final int POPULATION_QUOTA = 2;
	private static final int HEALTH = 40;
	private static final int SHIELD = 40;
	private static final int INITIAL_ENERGY = 50;
	private static final int MAXIMUM_ENERGY = 200;
	private static final int ENERGY_GAIN_PER_TURN = 15;
	private static final int TRANSPORTATION_QUOTA = 4;
	private static final int STEPS_PER_TURN = 7;
	private static final boolean CAN_FLY = false;
	
	public MagicalUnit create(Point position) {
		return new MagicalUnit(NAME, new Life(HEALTH, SHIELD), position, 
				VISION, STEPS_PER_TURN, new AltoTemplarioPowerGenerator(), 
				INITIAL_ENERGY, MAXIMUM_ENERGY, ENERGY_GAIN_PER_TURN,
				TRANSPORTATION_QUOTA, CAN_FLY, POPULATION_QUOTA);
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
	public AltoTemplarioTemplate() {
		name = "Alto Templario";
		value = new Value(50, 150);
		constructionTime = 7;
		health = 40;
		shield = 40;
		vision = 7;
		initialEnergy = 50;
		maximumEnergy = 200;
		energyGainPerTurn = 15;
		transportationQuota = 2;
		populationQuota = 2;
		stepsPerTurn = 7;
	}

	public MagicalUnit create(Point position) {
		return new MagicalUnit(name, new Life(health, shield), position,
				vision, stepsPerTurn, new AltoTemplarioPowerGenerator(),
				initialEnergy, maximumEnergy, energyGainPerTurn, 
				transportationQuota, false, populationQuota);
	}
	*/
}
