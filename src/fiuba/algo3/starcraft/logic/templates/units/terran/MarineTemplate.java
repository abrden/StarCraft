package fiuba.algo3.starcraft.logic.templates.units.terran;

import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.templates.qualities.Attack;
import fiuba.algo3.starcraft.logic.templates.qualities.Damage;
import fiuba.algo3.starcraft.logic.templates.qualities.Life;
import fiuba.algo3.starcraft.logic.templates.qualities.Value;
import fiuba.algo3.starcraft.logic.templates.units.MuggleTemplate;
import fiuba.algo3.starcraft.logic.units.MuggleUnit;

public class MarineTemplate extends MuggleTemplate {

	private static final String NAME = "Marine";
	private static final Value VALUE = new Value(50,0);
	private static final int CONSTRUCTION_TIME = 3;
	private static final int VISION = 7;
	private static final int POPULATION_QUOTA = 1;
	private static final int HEALTH = 40;
	private static final int TRANSPORTATION_QUOTA = 1;
	private static final Damage DAMAGE = new Damage(6,6);
	private static final int DAMAGE_RANGE = 4;
	private static final Attack ATTACK = new Attack(DAMAGE, DAMAGE_RANGE);
	private static final int STEPS_PER_TURN = 3;
	private static final boolean CAN_FLY = false;
	
	public MuggleUnit create(Point position) {
		return new MuggleUnit(NAME, new Life(HEALTH), position, VISION,
				STEPS_PER_TURN, ATTACK, TRANSPORTATION_QUOTA, CAN_FLY, POPULATION_QUOTA);
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
	public MarineTemplate() {
		name = "Marine";
		value = new Value(50,0);
		constructionTime = 3;
		vision = 7;
		populationQuota = 1;
		health = 40;
		transportationQuota = 1;
		damage = new Damage(6,6);
		damageRange = 4;
		attack = new Attack(damage, damageRange);
		stepsPerTurn = 3;
	}


	public MuggleUnit create(Point position) {
		return new MuggleUnit(name, new Life(health), position, vision, 
				stepsPerTurn, attack, transportationQuota, false, populationQuota);
	}
	*/
}
