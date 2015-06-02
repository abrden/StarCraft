package fiuba.algo3.starcraft.logic.templates.units.protoss;

import fiuba.algo3.starcraft.logic.templates.qualities.Attack;
import fiuba.algo3.starcraft.logic.templates.qualities.Damage;
import fiuba.algo3.starcraft.logic.templates.qualities.Life;
import fiuba.algo3.starcraft.logic.templates.qualities.Value;
import fiuba.algo3.starcraft.logic.templates.units.MuggleTemplate;
import fiuba.algo3.starcraft.logic.units.MuggleUnit;


public class DragonTemplate extends MuggleTemplate {

	private static DragonTemplate instance = new DragonTemplate();

	private DragonTemplate() {
		name = "Dragon";
		value = new Value(125,50);
		constructionTime = 6;
		vision = 8;
		populationQuota = 2;
		health = 80;
		shield = 100;
		transportationQuota = 4;
		damage = new Damage(20,20);
		damageRange = 4;
		attack = new Attack(damage, damageRange);
	}

	public static DragonTemplate getInstance(){
		return instance;
	}

	public MuggleUnit create() {
		return new MuggleUnit(name, new Life(health, shield), vision, attack, transportationQuota, populationQuota);
	}
}
