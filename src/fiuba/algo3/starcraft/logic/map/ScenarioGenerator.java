package fiuba.algo3.starcraft.logic.map;

import java.util.Random;

import fiuba.algo3.starcraft.logic.structures.Structure;

public class ScenarioGenerator {
	private Map map;

	public ScenarioGenerator(Map map){
		this.map = map;
	}
	
	private Point getRandomPointInARect(Point origin, int side) {
		Random random = new Random();
		
		double randomX = (random.nextDouble() * side) + origin.getX();
		double randomY = (random.nextDouble() * side) + origin.getY();
		
		return new Point(randomX, randomY);
	}
	
	public void assignSurfaceDistributionInRect(LandType landType ,Point origin, int side, double dencity) {
		for (int i = 0 ; i < side*dencity/map.PARCEL_SIDE; i++){
			Point randomPointInRect = getRandomPointInARect(origin, side);
			Parcel parcel = map.getParcelContainingPoint(randomPointInRect);
			parcel.setSurface(landType);
		}
	}
	
	public void assignSurfaceDistributionInRect(ExtractableType extractableType,Point origin, int side, double dencity) {
		for (int i = 0 ; i < (side * side )*dencity/(map.PARCEL_SIDE * map.PARCEL_SIDE); i++){
			Point randomPointInRect = getRandomPointInARect(origin, side);
			Parcel parcel = map.getParcelContainingPoint(randomPointInRect);
			parcel.setSurface(extractableType);
		}
	}
	
	public void buildStructureInPoint(Structure structure, Point point) {
		Parcel parcel = map.getParcelContainingPoint(point);
		parcel.setStructure(structure);
	}
}
