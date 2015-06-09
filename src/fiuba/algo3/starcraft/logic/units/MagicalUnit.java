package fiuba.algo3.starcraft.logic.units;

import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.templates.qualities.Life;
import fiuba.algo3.starcraft.logic.templates.qualities.Power;
import fiuba.algo3.starcraft.logic.templates.qualities.PowerGenerator;
import fiuba.algo3.starcraft.logic.units.exceptions.InsufficientEnergy;
import fiuba.algo3.starcraft.logic.units.exceptions.NonexistentPower;

public class MagicalUnit extends Unit implements Transportable {
	
	private int energy;
	private final int  maximumEnergy;
	private final int energyGainPerTurn;
	private final int transportationQuota;
	//private final Collection<Power> powers;
	private final PowerGenerator generator;
	
	public MagicalUnit(String name, Life life, Point position, int vision, int stepsPerTurn,
			PowerGenerator generator,
			int initialEnergy, int maximumEnergy, int energyGainPerTurn, 
			int transportationQuota, int populationQuota) {
		super(name, life, position, vision, stepsPerTurn, populationQuota);
		this.energy = initialEnergy;
		this.transportationQuota = transportationQuota;
		this.maximumEnergy = maximumEnergy;
		this.energyGainPerTurn = energyGainPerTurn;
		this.generator = generator;
		//this.powers = powers;
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

	private void drainEnergy() {
		energy = 0;
	}
	
	public void executeEMP() {
		this.drainEnergy();
	}

	/*
	private void giveUpEnergyForPower(Power power) throws InsufficientEnergy {
		if (energy < power.getCost()) throw new InsufficientEnergy();
		energy =- power.getCost();
	}
	*/
	
	public Power usePower(String name) throws InsufficientEnergy, NonexistentPower {
		Power power = generator.generatePower(name, energy);
		energy -= power.getCost();
		return power;
		/*
		for (Power power : powers)
			if(power.getName() == name) {
				this.giveUpEnergyForPower(power);
				return power;
			}
		return null;
		*/
	}
	
}
