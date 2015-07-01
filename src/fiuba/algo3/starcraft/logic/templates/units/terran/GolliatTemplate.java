package fiuba.algo3.starcraft.logic.templates.units.terran;

import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.templates.qualities.Attack;
import fiuba.algo3.starcraft.logic.templates.qualities.Damage;
import fiuba.algo3.starcraft.logic.templates.qualities.Life;
import fiuba.algo3.starcraft.logic.templates.qualities.Value;
import fiuba.algo3.starcraft.logic.templates.units.MuggleTemplate;
import fiuba.algo3.starcraft.logic.units.MuggleUnit;


public class GolliatTemplate extends MuggleTemplate {
	
	private static final String NAME = "Golliat";
	private static final Value VALUE = new Value(100,50);
	private static final int CONSTRUCTION_TIME = 6;
	private static final int VISION = 800;
	private static final int POPULATION_QUOTA = 2;
	private static final int HEALTH = 125;
	private static final int TRANSPORTATION_QUOTA = 2;
	private static final Damage DAMAGE = new Damage(12,10);
	private static final int DAMAGE_RANGE = 600;
	private static final Attack ATTACK = new Attack(DAMAGE, DAMAGE_RANGE);
	private static final int STEPS_PER_TURN = 160;
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
}
