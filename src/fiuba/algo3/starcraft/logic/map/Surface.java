package fiuba.algo3.starcraft.logic.map;

import fiuba.algo3.starcraft.logic.units.Transportable;

public abstract class Surface implements Extractable{
	public abstract boolean letPass(Transportable unit);
}
