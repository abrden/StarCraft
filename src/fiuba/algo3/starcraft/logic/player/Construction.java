package fiuba.algo3.starcraft.logic.player;

public class Construction {

	private Object construction;
	private int releaseIn;
	
	public Construction(Object constructed, int releaseTurn) {
		this.construction = constructed;
		this.releaseIn = releaseTurn;
	}
	
	public void lowerRelease() {
		releaseIn -= 1;
	}
	
	public boolean itsFinished() {
		return (releaseIn == 0);
	}

	public Object gather() {
		return construction;
	}
}
