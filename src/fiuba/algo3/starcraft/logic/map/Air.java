package fiuba.algo3.starcraft.logic.map;

import fiuba.algo3.starcraft.logic.units.Transportable;

public class Air extends Surface {

	@Override
	public boolean letPass(Transportable unit) {
		return unit.canFly();
	}
	
}
