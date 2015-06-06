package fiuba.algo3.starcraft.logic.units;

import fiuba.algo3.starcraft.logic.templates.qualities.Attack;
import fiuba.algo3.starcraft.logic.templates.qualities.Life;

public class MuggleUnit extends Unit implements Transportable {
	
	private final Attack attack;
	private final int transportationQuota;
	
	public MuggleUnit(String name, Life life, int vision, int stepsPerTurn,Attack attack, 
			int transportationQuota, int populationQuota) {
		super(name, life, vision, stepsPerTurn, populationQuota);
			this.attack = attack;
			this.transportationQuota = transportationQuota; 
	}
		
	public int getTransportQuota() {
		return transportationQuota;
	}
	
	public boolean canFly() {
		return (transportationQuota == 0);
	}
	
	public int getAttackRange() {
		return attack.getRange();
	}
	
	public int getAttackLandDamage() {
		return attack.getLandDamage();
	}
	
	public int getAttackSpaceDamage() {
		return attack.getSpaceDamage();
	}
}
