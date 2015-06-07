package fiuba.algo3.starcraft.logic.templates.units;

import java.util.Collection;
import java.util.LinkedList;

import fiuba.algo3.starcraft.logic.templates.qualities.Power;

public abstract class MagicalTemplate extends UnitTemplate {
	
	protected int energyGainPerTurn;
	protected int initialEnergy;
	protected int maximumEnergy;
	protected Collection<Power> powers = new LinkedList<Power>();
	
	// Completar energia que se necesita para realizar poderes y habilidades, dano que infligen, etc
}
