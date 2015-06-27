package fiuba.algo3.starcraft.logic.templates.qualities;

import fiuba.algo3.starcraft.logic.units.exceptions.InsufficientEnergy;
import fiuba.algo3.starcraft.logic.units.exceptions.NonexistentPower;

public abstract class PowerGenerator {

	protected boolean enoughEnergyToGenerate(Power power, int energy) throws InsufficientEnergy {
		if (energy >= power.getCost()) return true;
		else throw new InsufficientEnergy();
	}
	
	public abstract Power generatePower(String name, int energy) throws NonexistentPower, InsufficientEnergy;

	public abstract String[] getPowerNames();
	
}
