package fiuba.algo3.starcraft.logic.units;

public class MagicalUnit extends Unit implements Transportable {
	
	private int energy;
	private int maximumEnergy;
	private int energyGainPerTurn;

	public int getTransportQuota() {
		return -1; //TODO: Implementar esta redefinicion de Transportable
	}
}
