package fiuba.algo3.starcraft.logic.units;

public class MuggleUnit extends Unit implements Transportable {
	
	private Attack attack;
	private boolean canFly;
	
	public void setCanFly(boolean canFly) {
		this.canFly = canFly;
	}
	
	public int getTransportQuota() {
		return -1; //TODO: Implementar esta redefinicion de Transportable
	}
	
	public boolean canFly() {
		return canFly;
	}

}
