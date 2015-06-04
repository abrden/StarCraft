package fiuba.algo3.starcraft.logic.templates.units.protoss;

import fiuba.algo3.starcraft.logic.templates.qualities.Attack;
import fiuba.algo3.starcraft.logic.templates.qualities.Damage;
import fiuba.algo3.starcraft.logic.templates.qualities.Life;
import fiuba.algo3.starcraft.logic.templates.qualities.Value;
import fiuba.algo3.starcraft.logic.templates.units.MuggleTemplate;
import fiuba.algo3.starcraft.logic.units.MuggleUnit;


public class ScoutTemplate extends MuggleTemplate {

	private static ScoutTemplate instance = new ScoutTemplate();

	private ScoutTemplate() {
		name = "Scout";
		value = new Value(300,150);
		constructionTime = 9;
		vision = 7;
		populationQuota = 3;
		health = 100;
		shield = 150;
		transportationQuota = 0;
		damage = new Damage(8,14);
		damageRange = 4;
		attack = new Attack(damage, damageRange);
		stepsPerTurn = 9;
	}

	public static ScoutTemplate getInstance(){
		return instance;
	}
	
	public MuggleUnit create() {
		return new MuggleUnit(name, new Life(health, shield), vision, stepsPerTurn, attack, transportationQuota, populationQuota);
	}
}
