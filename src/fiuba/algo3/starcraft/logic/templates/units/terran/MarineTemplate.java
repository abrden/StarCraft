package fiuba.algo3.starcraft.logic.templates.units.terran;

import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.templates.qualities.Attack;
import fiuba.algo3.starcraft.logic.templates.qualities.Damage;
import fiuba.algo3.starcraft.logic.templates.qualities.Life;
import fiuba.algo3.starcraft.logic.templates.qualities.Value;
import fiuba.algo3.starcraft.logic.templates.units.MuggleTemplate;
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
		stepsPerTurn = 3;
	}

	public static MarineTemplate getInstance(){
		return instance;
	}

	public MuggleUnit create(Point position) {
		return new MuggleUnit(name, new Life(health), position, vision, 
				stepsPerTurn, attack, transportationQuota, false, populationQuota);
	}

}
