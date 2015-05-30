package fiuba.algo3.starcraft.logic.units;

import fiuba.algo3.starcraft.logic.templates.Damage;

public class Attack {
	
	private Damage damage;
	private int range;
	
	Attack(Damage damage, int range) {
		this.damage = damage;
		this.range = range;
	}

}
