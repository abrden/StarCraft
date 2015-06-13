package fiuba.algo3.starcraft.logic.map.resources;

import fiuba.algo3.starcraft.logic.map.Extractable;

public class Volcano implements Extractable {

	@Override
	public ExtractableType extractResource() {
		return ExtractableType.gas;
	}
	 
}
