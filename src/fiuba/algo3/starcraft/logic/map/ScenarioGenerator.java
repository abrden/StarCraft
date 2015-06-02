package fiuba.algo3.starcraft.logic.map;

import java.util.Random;

public class ScenarioGenerator {
	private Map map;

	public ScenarioGenerator(Map map){
		this.map = map;
	}
	
	public void assignRandomResourcesDistributionInRect(Point origin, int side, double density) {
		Random random = new Random();
		
		for (int i = 0; i < density*side ; i++) { 
			int randomX = (int) (random.nextInt(side) + origin.getX());
			int randomY = (int) (random.nextInt(side) + origin.getY());
		
			boolean isWithVolcano = random.nextBoolean();
			Parcel parcel = map.getParcelContainingPoint(new Point(randomX,randomY));
			parcel.setSurface(isWithVolcano ? ExtractableType.volcano : ExtractableType.reservoir);
		}
	}
}
