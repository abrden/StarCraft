package fiuba.algo3.starcraft.logic.units;

import fiuba.algo3.starcraft.logic.templates.Attack;
import fiuba.algo3.starcraft.logic.templates.Life;

public class MuggleUnit extends Unit implements Transportable {
	
	private Attack attack;
	private int transportationQuota;
	
	public MuggleUnit(Life life, int vision, Attack attack,
			int transportationQuota, int populationQuota) {
		this.life = life;
		this.vision = vision;
		this.attack = attack;
		this.populationQuota = populationQuota;
		this.transportationQuota = transportationQuota; 
	}
	
	public int getTransportQuota() {
		return transportationQuota;
	}
	
	public boolean canFly() {
		return (transportationQuota == 0);
	}

}
