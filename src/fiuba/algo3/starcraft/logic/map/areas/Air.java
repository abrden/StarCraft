package fiuba.algo3.starcraft.logic.map.areas;

import fiuba.algo3.starcraft.logic.map.exceptions.NoResourcesToExtract;
import fiuba.algo3.starcraft.logic.map.resources.ExtractableType;
import fiuba.algo3.starcraft.logic.units.Unit;

public class Air extends Surface {

	@Override
	public boolean letPass(Unit unit) {
		return unit.canFly();
	}

	@Override
	public ExtractableType extractResource() throws NoResourcesToExtract {
		throw new NoResourcesToExtract();
	}
}
