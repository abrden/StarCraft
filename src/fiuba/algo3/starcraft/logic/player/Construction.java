package fiuba.algo3.starcraft.logic.player;

public class Construction<T> {

	private T construction;
	private int releaseIn;
	
	public Construction(T constructed, int releaseTurn) {
		this.construction = constructed;
		this.releaseIn = releaseTurn;
	}
	
	public void lowerRelease() {
		releaseIn -= 1;
	}
	
	public boolean itsFinished() {
		return (releaseIn == 0);
	}

	public T gather() {
		return construction;
	}
}
