package fiuba.algo3.starcraft.logic.map.resources;

import fiuba.algo3.starcraft.logic.map.Extractable;

public class Mine implements Extractable {

	public ExtractableType extractResource() {
		return ExtractableType.mineral;
	}
}
