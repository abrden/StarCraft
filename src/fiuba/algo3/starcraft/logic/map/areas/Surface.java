package fiuba.algo3.starcraft.logic.map.areas;

import fiuba.algo3.starcraft.logic.map.Extractable;
import fiuba.algo3.starcraft.logic.units.Unit;
import fiuba.algo3.starcraft.game.Drawable;


public abstract class Surface implements Extractable, Drawable {
	public abstract boolean letPass(Unit unit);
	
}
