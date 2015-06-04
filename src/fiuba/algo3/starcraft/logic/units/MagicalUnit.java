package fiuba.algo3.starcraft.logic.units;

import fiuba.algo3.starcraft.logic.templates.qualities.Life;

public class MagicalUnit extends Unit implements Transportable {
	
	private int energy;
	private int maximumEnergy;
	private int energyGainPerTurn;
	private int transportationQuota;
	
	public MagicalUnit(String name, Life life, int vision, int stepsPerTurn,
			int initialEnergy, int maximumEnergy, int energyGainPerTurn, 
			int transportationQuota, int populationQuota) {
		super(name, life, vision, stepsPerTurn, populationQuota);
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
