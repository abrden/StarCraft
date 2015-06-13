package fiuba.algo3.starcraft.logic.map;

public class Volcano implements Extractable {

	@Override
	public ExtractableType extractResource() {
		return ExtractableType.gas;
	}
	 
}
