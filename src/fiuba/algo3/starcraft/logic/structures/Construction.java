package fiuba.algo3.starcraft.logic.structures;

import fiuba.algo3.starcraft.logic.structures.exceptions.ConstructionNotFinished;

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

	public T gather() throws ConstructionNotFinished {
		if (this.itsFinished()) return construction;
		else throw new ConstructionNotFinished();
	}
}
