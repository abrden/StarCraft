package fiuba.algo3.starcraft.logic.templates;

import fiuba.algo3.starcraft.logic.units.MuggleUnit;

public class MarineTemplate extends MuggleTemplate {

	private static MarineTemplate instance = new MarineTemplate();
	
	private MarineTemplate() {
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
	}

	public static MarineTemplate getInstance(){
		return instance;
	}

	public MuggleUnit create() {
		return new MuggleUnit(name, new Life(health), vision, attack, transportationQuota, populationQuota);
	}

}
