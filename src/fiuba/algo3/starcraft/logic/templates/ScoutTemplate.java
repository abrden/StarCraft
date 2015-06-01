package fiuba.algo3.starcraft.logic.templates;

import fiuba.algo3.starcraft.logic.units.MuggleUnit;


public class ScoutTemplate extends MuggleTemplate {

	private static ScoutTemplate instance = new ScoutTemplate();

	private ScoutTemplate() {
		value = new Value(300,150);
		constructionTime = 9;
		vision = 7;
		populationQuota = 3;
		health = 100;
		shield = 150;
		transportationQuota = 0;
		damage = new Damage(8,14);
		damageRange = 4;
	}

	public static ScoutTemplate getInstance(){
		return instance;
	}
	
	public MuggleUnit create() {
		return new MuggleUnit(new Life(health), vision, attack, transportationQuota, populationQuota);
	}

	public TemplateID getId() {
		return TemplateID.ScoutTemplate;
	}
}
