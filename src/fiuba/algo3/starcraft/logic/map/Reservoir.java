package fiuba.algo3.starcraft.logic.map;

public class Reservoir implements Extractable {
	
	@Override
	public Resource extractResource() {
		return new Mineral();
	}
}
