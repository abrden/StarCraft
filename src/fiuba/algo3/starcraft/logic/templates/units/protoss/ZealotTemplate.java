package fiuba.algo3.starcraft.logic.templates.units.protoss;

import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.templates.qualities.Attack;
import fiuba.algo3.starcraft.logic.templates.qualities.Damage;
import fiuba.algo3.starcraft.logic.templates.qualities.Life;
import fiuba.algo3.starcraft.logic.templates.qualities.Value;
import fiuba.algo3.starcraft.logic.templates.units.MuggleTemplate;
import fiuba.algo3.starcraft.logic.units.MuggleUnit;

public class ZealotTemplate extends MuggleTemplate {

	private static ZealotTemplate instance = new ZealotTemplate();

	private ZealotTemplate() {
		name = "Zealot";
		value = new Value(100,0);
		constructionTime = 4;
		vision = 7;
		populationQuota = 2;
		health = 60;
		shield = 100;
		transportationQuota = 2;
		damage = new Damage(8,0);
		damageRange = 1;
		attack = new Attack(damage, damageRange);
		stepsPerTurn = 4;
	}

	public static ZealotTemplate getInstance(){
		return instance;
	}

	public MuggleUnit create(Point position) {
		return new MuggleUnit(name, new Life(health, shield), position, vision, stepsPerTurn, attack, transportationQuota, populationQuota);
	}
}
