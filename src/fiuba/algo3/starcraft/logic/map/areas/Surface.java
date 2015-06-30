package fiuba.algo3.starcraft.logic.map.areas;

import fiuba.algo3.starcraft.logic.game.Actionable;
import fiuba.algo3.starcraft.logic.game.Drawable;
import fiuba.algo3.starcraft.logic.map.Extractable;
import fiuba.algo3.starcraft.logic.units.Unit;


public abstract class Surface implements Extractable, Drawable, Actionable {
	
	public abstract boolean letPass(Unit unit);
	
	public boolean hasOwner() {
		return false;
	}
	
}
