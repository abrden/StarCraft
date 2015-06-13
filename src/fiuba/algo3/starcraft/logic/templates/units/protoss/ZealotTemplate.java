package fiuba.algo3.starcraft.logic.templates.units.protoss;

import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.templates.qualities.Attack;
import fiuba.algo3.starcraft.logic.templates.qualities.Damage;
import fiuba.algo3.starcraft.logic.templates.qualities.Life;
import fiuba.algo3.starcraft.logic.templates.qualities.Value;
import fiuba.algo3.starcraft.logic.templates.units.MuggleTemplate;
import fiuba.algo3.starcraft.logic.units.MuggleUnit;

public class ZealotTemplate extends MuggleTemplate {

	private static final String NAME = "Zealot";
	private static final Value VALUE = new Value(100,0);
	private static final int CONSTRUCTION_TIME = 4;
	private static final int VISION = 7;
	private static final int POPULATION_QUOTA = 2;
	private static final int HEALTH = 100;
	private static final int SHIELD = 60;
	private static final int TRANSPORTATION_QUOTA = 2;
	private static final Damage DAMAGE = new Damage(8,0);
	private static final int DAMAGE_RANGE = 1;
	private static final Attack ATTACK = new Attack(DAMAGE, DAMAGE_RANGE);
	private static final int STEPS_PER_TURN = 4;
	private static final boolean CAN_FLY = false;
	
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
	public ZealotTemplate() {
		name = "Zealot";
		value = new Value(100,0);
		constructionTime = 4;
		vision = 7;
		populationQuota = 2;
		health = 100;
		shield = 60;
		transportationQuota = 2;
		damage = new Damage(8,0);
		damageRange = 1;
		attack = new Attack(damage, damageRange);
		stepsPerTurn = 4;
	}

	public MuggleUnit create(Point position) {
		return new MuggleUnit(name, new Life(health, shield), position, vision,
				stepsPerTurn, attack, transportationQuota, false, populationQuota);
	}*/
}
