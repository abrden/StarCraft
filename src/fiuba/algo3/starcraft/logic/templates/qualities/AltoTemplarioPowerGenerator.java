package fiuba.algo3.starcraft.logic.templates.qualities;

import fiuba.algo3.starcraft.logic.units.exceptions.InsufficientEnergy;
import fiuba.algo3.starcraft.logic.units.exceptions.NonexistentPower;

public class AltoTemplarioPowerGenerator extends PowerGenerator {
	
	public Power generatePower(String name, int energy) throws NonexistentPower, InsufficientEnergy {
		Power power;
		switch (name) {
			case "Alucinacion":  
				power = new Alucinacion();
				break;
			case "Tormenta Psionica":
				power = new TormentaPsionica();
				break;
			default:
				throw new NonexistentPower();
		}
		enoughEnergyToGenerate(power, energy);
		return power;
	}

	public String[] getPowerNames() {
		String[] powers = {"Alucinacion", "Tormenta Psionica"};
		return powers;
	}

}
