package fiuba.algo3.starcraft.logic.units;

import java.util.Collection;
import java.util.LinkedList;

import fiuba.algo3.starcraft.logic.templates.qualities.Life;
import fiuba.algo3.starcraft.logic.templates.qualities.Power;

public class MagicalUnit extends Unit implements Transportable {
	
	private int energy;
	private int maximumEnergy;
	private int energyGainPerTurn;
	private int transportationQuota;
	private Collection<Power> powers;
	
	public MagicalUnit(String name, Life life, int vision, int stepsPerTurn,
			Collection<Power> powers,
			int initialEnergy, int maximumEnergy, int energyGainPerTurn, 
			int transportationQuota, int populationQuota) {
		super(name, life, vision, stepsPerTurn, populationQuota);
		this.energy = initialEnergy;
		this.transportationQuota = transportationQuota;
		this.maximumEnergy = maximumEnergy;
		this.energyGainPerTurn = energyGainPerTurn;
		this.powers = powers;
	}

	public int getTransportQuota() {
		return transportationQuota;
	}
	
	public boolean canFly() {
		return (transportationQuota == 0);
	}
}
