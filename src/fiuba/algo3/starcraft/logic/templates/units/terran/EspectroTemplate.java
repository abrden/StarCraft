package fiuba.algo3.starcraft.logic.templates.units.terran;

import fiuba.algo3.starcraft.logic.templates.qualities.Attack;
import fiuba.algo3.starcraft.logic.templates.qualities.Damage;
import fiuba.algo3.starcraft.logic.templates.qualities.Life;
import fiuba.algo3.starcraft.logic.templates.qualities.Value;
import fiuba.algo3.starcraft.logic.templates.units.MuggleTemplate;
import fiuba.algo3.starcraft.logic.units.MuggleUnit;


public class EspectroTemplate extends MuggleTemplate {

	private static EspectroTemplate instance = new EspectroTemplate();

	private EspectroTemplate() {
		name = "Espectro";
		value = new Value(150,100);
		constructionTime = 8;
		vision = 7;
		populationQuota = 2;
		health = 120;
		transportationQuota = 0;
		damage = new Damage(8,20);
		damageRange = 5;
		attack = new Attack(damage, damageRange);
	}

	public static EspectroTemplate getInstance(){
		return instance;
	}

	public MuggleUnit create() {
		return new MuggleUnit(name, new Life(health), vision, attack, transportationQuota, populationQuota);
	}
}
