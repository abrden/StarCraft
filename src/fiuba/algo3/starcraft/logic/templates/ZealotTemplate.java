package fiuba.algo3.starcraft.logic.templates;

import fiuba.algo3.starcraft.logic.units.MuggleUnit;

public class ZealotTemplate extends MuggleTemplate {

	private static ZealotTemplate instance = new ZealotTemplate();

	private ZealotTemplate() {
		value = new Value(100,0);
		constructionTime = 4;
		vision = 7;
		populationQuota = 2;
		health = 60;
		shield = 100;
		transportationQuota = 2;
		damage = new Damage(8,0);
		damageRange = 1;
	}

	public static ZealotTemplate getInstance(){
		return instance;
	}

	public MuggleUnit create() {
		return new MuggleUnit(new Life(health, shield), vision, attack, transportationQuota, populationQuota);
	}
}
