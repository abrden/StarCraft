package fiuba.algo3.starcraft.logic.map;

import fiuba.algo3.starcraft.logic.units.Transportable;

public class Land extends Surface {

	@Override
	public boolean letPass(Transportable unit) {
		return true;
	}
	
}
