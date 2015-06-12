package fiuba.algo3.starcraft.logic.templates.units.terran;

import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.templates.qualities.Life;
import fiuba.algo3.starcraft.logic.templates.qualities.NaveCienciaPowerGenerator;
import fiuba.algo3.starcraft.logic.templates.qualities.Value;
import fiuba.algo3.starcraft.logic.templates.units.MagicalTemplate;
import fiuba.algo3.starcraft.logic.units.MagicalUnit;

public class NaveCienciaTemplate extends MagicalTemplate {
	
	private static final String NAME = "Nave Ciencia";
	private static final Value VALUE = new Value(100,225);
	private static final int CONSTRUCTION_TIME = 10;
	private static final int VISION = 10;
	private static final int POPULATION_QUOTA = 2;
	private static final int HEALTH = 200;
	private static final int INITIAL_ENERGY = 50;
	private static final int MAXIMUM_ENERGY = 200;
	private static final int ENERGY_GAIN_PER_TURN = 10;
	private static final int TRANSPORTATION_QUOTA = 0;
	private static final int STEPS_PER_TURN = 10;
	private static final boolean CAN_FLY = true;
	
	public MagicalUnit create(Point position) {
		return new MagicalUnit(NAME, new Life(HEALTH), position, 
				VISION, STEPS_PER_TURN, new NaveCienciaPowerGenerator(), 
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
	public NaveCienciaTemplate() {
		name = "Nave Ciencia";
		value = new Value(100, 225);
		constructionTime = 10;
		health = 200;
		vision = 10;
		initialEnergy = 50;
		maximumEnergy = 200;
		energyGainPerTurn = 10;
		transportationQuota = 0;
		populationQuota = 2;
		stepsPerTurn = 10;
	}

	public MagicalUnit create(Point position) {
		return new MagicalUnit(name, new Life(health), position,
				vision, stepsPerTurn, new NaveCienciaPowerGenerator(), 
				initialEnergy, maximumEnergy, energyGainPerTurn, 
				transportationQuota, true, populationQuota);
	}
	 */
}
