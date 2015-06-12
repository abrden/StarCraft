package fiuba.algo3.starcraft.logic.templates.units.terran;

import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.templates.qualities.Attack;
import fiuba.algo3.starcraft.logic.templates.qualities.Damage;
import fiuba.algo3.starcraft.logic.templates.qualities.Life;
import fiuba.algo3.starcraft.logic.templates.qualities.Value;
import fiuba.algo3.starcraft.logic.templates.units.MuggleTemplate;
import fiuba.algo3.starcraft.logic.units.MuggleUnit;


public class GolliatTemplate extends MuggleTemplate {

	public GolliatTemplate() {
		name = "Golliat";
		value = new Value(100,50);
		constructionTime = 6;
		vision = 8;
		populationQuota = 2;
		health = 125;
		transportationQuota = 2;
		damage = new Damage(12,10);
		damageRange = 6;
		attack = new Attack(damage, damageRange);
		stepsPerTurn = 6;
	}

	public MuggleUnit create(Point position) {
		return new MuggleUnit(name, new Life(health), position, vision, 
				stepsPerTurn, attack, transportationQuota, false, populationQuota);
	}

}
