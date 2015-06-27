package fiuba.algo3.starcraft.logic.templates.qualities;

import fiuba.algo3.starcraft.logic.units.exceptions.InsufficientEnergy;
import fiuba.algo3.starcraft.logic.units.exceptions.NonexistentPower;

public class NaveCienciaPowerGenerator extends PowerGenerator {

	public Power generatePower(String name, int energy) throws NonexistentPower, InsufficientEnergy {
		Power power;
		switch (name) {
			case "EMP":  
				power = new EMP();
				break;
			case "Radiacion":
				power = new Radiacion();
				break;
			default:
				throw new NonexistentPower();
		}
		enoughEnergyToGenerate(power, energy);
		return power;
	}
	
	public String[] getPowerNames() {
		String[] powers = {"EMP", "Radiacion"};
		return powers;
	}
}
