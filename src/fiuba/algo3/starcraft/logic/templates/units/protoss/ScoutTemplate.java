package fiuba.algo3.starcraft.logic.templates.units.protoss;

import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.templates.qualities.Attack;
import fiuba.algo3.starcraft.logic.templates.qualities.Damage;
import fiuba.algo3.starcraft.logic.templates.qualities.Life;
import fiuba.algo3.starcraft.logic.templates.qualities.Value;
import fiuba.algo3.starcraft.logic.templates.units.MuggleTemplate;
import fiuba.algo3.starcraft.logic.units.MuggleUnit;


public class ScoutTemplate extends MuggleTemplate {

	private static final String NAME = "Scout";
	private static final Value VALUE = new Value(300,150);
	private static final int CONSTRUCTION_TIME = 9;
	private static final int VISION = 7;
	private static final int POPULATION_QUOTA = 3;
	private static final int HEALTH = 150;
	private static final int SHIELD = 100;
	private static final int TRANSPORTATION_QUOTA = 0;
	private static final Damage DAMAGE = new Damage(8,14);
	private static final int DAMAGE_RANGE = 4;
	private static final Attack ATTACK = new Attack(DAMAGE, DAMAGE_RANGE);
	private static final int STEPS_PER_TURN = 9;
	private static final boolean CAN_FLY = true;
	
	public MuggleUnit create(Point position) {
		return new MuggleUnit(NAME, new Life(HEALTH, SHIELD), position, VISION,
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
	public ScoutTemplate() {
		name = "Scout";
		value = new Value(300,150);
		constructionTime = 9;
		vision = 7;
		populationQuota = 3;
		health = 150;
		shield = 100;
		transportationQuota = 0;
		damage = new Damage(8,14);
		damageRange = 4;
		attack = new Attack(damage, damageRange);
		stepsPerTurn = 9;
	}

	public MuggleUnit create(Point position) {
		return new MuggleUnit(name, new Life(health, shield), position, vision,
				stepsPerTurn, attack, transportationQuota, true, populationQuota);
	}
	*/
}
