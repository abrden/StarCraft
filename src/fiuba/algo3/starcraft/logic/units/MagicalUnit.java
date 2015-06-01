package fiuba.algo3.starcraft.logic.units;

import fiuba.algo3.starcraft.logic.templates.Life;

public class MagicalUnit extends Unit implements Transportable {
	
	private int energy;
	private int maximumEnergy;
	private int energyGainPerTurn;
	private int transportationQuota;
	
	public MagicalUnit(Life life, int vision,
			int initialEnergy, int maximumEnergy, int energyGainPerTurn, 
			int transportationQuota, int populationQuota) {
		super(life, vision, populationQuota);
		this.energy = initialEnergy;
		this.transportationQuota = transportationQuota;
		this.maximumEnergy = maximumEnergy;
		this.energyGainPerTurn = energyGainPerTurn;
	}

	public int getTransportQuota() {
		return transportationQuota;
	}
	
	public boolean canFly() {
		return (transportationQuota == 0);
	}
}
