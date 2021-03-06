package fiuba.algo3.starcraft.logic.units;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.starcraft.logic.game.ActionID;
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
	private final boolean canFly;
	private final PowerGenerator generator;
	
	public MagicalUnit(String name, Life life, Point position, int vision, int stepsPerTurn,
			PowerGenerator generator,
			int initialEnergy, int maximumEnergy, int energyGainPerTurn, 
			int transportationQuota, boolean canFly, int populationQuota) {
		super(name, life, position, vision, stepsPerTurn, populationQuota);
		this.energy = initialEnergy;
		this.transportationQuota = transportationQuota;
		this.canFly = canFly;
		this.maximumEnergy = maximumEnergy;
		this.energyGainPerTurn = energyGainPerTurn;
		this.generator = generator;
	}

	public int getTransportQuota() {
		return transportationQuota;
	}
	
	public boolean canFly() {
		return canFly;
	}
	
	public void update() {
		// Gana energia del turno
        movedThisTurn = false;
		energy += energyGainPerTurn;
		if (energy > maximumEnergy) energy = maximumEnergy;
		
		// Regenera escudo
		life.regenerateShield();
	}
	
	public void executeEMP() {
		energy = 0;
	}

	public Power usePower(String name) throws InsufficientEnergy, NonexistentPower {
		Power power = generator.generatePower(name, energy);
		energy -= power.getCost();
		return power;
	}

	public void killInFlight() {
		life.drain();
	}
	
	public Iterable<ActionID> getActions() {
		List<ActionID> actions = new ArrayList<ActionID>();
		actions.add(ActionID.move);
		actions.add(ActionID.embark);
		actions.add(ActionID.power);
		return actions;
	}

	public String[] getPowerNames() {
		return generator.getPowerNames();
	}

}
