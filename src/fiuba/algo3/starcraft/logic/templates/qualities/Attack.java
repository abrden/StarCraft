package fiuba.algo3.starcraft.logic.templates.qualities;

import fiuba.algo3.starcraft.logic.templates.qualities.Damage;

public class Attack {
	
	private Damage damage;
	private int range;
	
	public Attack(Damage damage, int range) {
		this.damage = damage;
		this.range = range;
	}

	public int getLandDamage() {
		return damage.getLandDamage();
	}
	
	public int getSpaceDamage() {
		return damage.getSpaceDamage();
	}
	
	public int getRange() {
		return range;
	}
}
