package fiuba.algo3.starcraft.logic.units;

public class MuggleUnit extends Unit implements Transportable {
	
	private Attack attack;
	
	public int getTransportQuota() {
		return -1; //TODO: Implementar esta redefinicion de Transportable
	}

}
