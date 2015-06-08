package fiuba.algo3.starcraft.logic.units;

import java.util.Collection;

import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.templates.qualities.Life;
import fiuba.algo3.starcraft.logic.templates.qualities.Power;
import fiuba.algo3.starcraft.logic.units.exceptions.InsufficientEnergy;

public class MagicalUnit extends Unit implements Transportable {
	
	private int energy;
	private final int  maximumEnergy;
	private final int energyGainPerTurn;
	private final int transportationQuota;
	private final Collection<Power> powers;
	
	public MagicalUnit(String name, Life life, Point position, int vision, int stepsPerTurn,
			Collection<Power> powers,
			int initialEnergy, int maximumEnergy, int energyGainPerTurn, 
			int transportationQuota, int populationQuota) {
		super(name, life, position, vision, stepsPerTurn, populationQuota);
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
	
	public void update() {
		// Gana energia del turno
		energy += energyGainPerTurn;
		if (energy > maximumEnergy) energy = maximumEnergy;
		
		// Regenera escudo
		life.regenerateShield();
	}

	public void executeEMP() {
		energy = 0;
	}

	private void giveUpEnergyForPower(Power power) throws InsufficientEnergy {
		if (energy < power.getCost()) throw new InsufficientEnergy();
		energy =- power.getCost();
	}
	
	public Power usePowerWithName(String name) throws InsufficientEnergy {
		for (Power power : powers)
			if(power.getName() == name) {
				this.giveUpEnergyForPower(power);
				return power;
			}
		return null;
	}
	
}
