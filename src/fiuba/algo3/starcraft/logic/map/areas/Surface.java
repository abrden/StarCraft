package fiuba.algo3.starcraft.logic.map.areas;

import fiuba.algo3.starcraft.logic.map.Extractable;
import fiuba.algo3.starcraft.logic.units.Transportable;

public abstract class Surface implements Extractable{
	public abstract boolean letPass(Transportable unit);
}
