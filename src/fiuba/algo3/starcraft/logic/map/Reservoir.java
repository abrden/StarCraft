package fiuba.algo3.starcraft.logic.map;

public class Reservoir implements Extractable {
	
	@Override
	public ExtractableType extractResource() {
		return ExtractableType.mineral;
	}
}
