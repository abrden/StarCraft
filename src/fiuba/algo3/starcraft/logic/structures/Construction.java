package fiuba.algo3.starcraft.logic.structures;

import fiuba.algo3.starcraft.logic.structures.exceptions.ConstructionNotFinished;
import fiuba.algo3.starcraft.logic.structures.exceptions.ConstructorIsDead;

public class Construction<T> {

	private T construction;
	private int releaseIn;
    private ConstructionStructure motherStructure;
    private boolean released;
	
	public Construction(T constructed, int releaseTurn, ConstructionStructure structure) {
		this.construction = constructed;
		this.releaseIn = releaseTurn;
        this.motherStructure = structure;
        this.released = false;
	}
	
	public void lowerRelease() {
		releaseIn -= 1;
	}
	
	public boolean itsFinished() {
		return (releaseIn == 0);
	}

	public T gather() throws ConstructionNotFinished, ConstructorIsDead {
        if (motherStructure == null) {
        }
        else {
            if (!motherStructure.itsAlive())
            throw new ConstructorIsDead();
        }
		if (this.itsFinished()) {
            released = true;
            return construction;
        } else throw new ConstructionNotFinished();
	}

    public boolean isRealeased() {
        return released;
    }
}
