package fiuba.algo3.starcraft.logic.map;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fiuba.algo3.starcraft.logic.map.resources.ReservoirType;

public class ScenarioGenerator {
	private Map map;

	public ScenarioGenerator(Map map){
		this.map = map;
	}
	
	private List<Parcel> chosenParcelsToDecorateIn(Point origin ,int side, double density) {
		ArrayList<Parcel> chosenParcels = new ArrayList<Parcel>();
		
		ArrayList<Parcel> parcelsInRect = map.getParcelsContainedInARect(origin, side);
		Random random = new Random();
		for (int i = 0 ; i < (side * side)*density/(map.PARCEL_SIDE * map.PARCEL_SIDE); i++) {
			
			int randomIndex = random.nextInt(parcelsInRect.size());
			Parcel chosenParcel = parcelsInRect.get(randomIndex);
			
			chosenParcels.add(chosenParcel);
			
			parcelsInRect.remove(randomIndex);
		}
		
		return chosenParcels;
	}
	
	public void assignAirDistributionInRect(Point origin ,int side, double density) {
		for (Parcel parcel : this.chosenParcelsToDecorateIn(origin, side, density))
			parcel.setAirSurface();
	}
	
	public void assignReservoirDistributionInRect(ReservoirType reservoir, Point origin, int side, double density) {
		for (Parcel parcel : this.chosenParcelsToDecorateIn(origin, side, density))
			parcel.setReservoir(reservoir);
	}
	
	/*
	//FIXME: repetition of code due to separation of landType and extractableType
	public void assignAirDistributionInRect(Point origin ,int side, double density) {
		ArrayList<Parcel> parcelsInRect = map.getParcelsContainedInARect(origin, side);
		Random random = new Random();
		for (int i = 0 ; i < (side * side)*density/(map.PARCEL_SIDE * map.PARCEL_SIDE); i++){
			int randomIndex = random.nextInt(parcelsInRect.size());
			Parcel chosenParcel = parcelsInRect.get(randomIndex);
			
			chosenParcel.setAirSurface();
			
			parcelsInRect.remove(randomIndex);
		}
	}
	
	public void assignSurfaceDistributionInRect(ReservoirType reservoir,Point origin, int side, double density) {
		ArrayList<Parcel> parcelsInRect = map.getParcelsContainedInARect(origin, side);
		Random random = new Random();
		for (int i = 0 ; i < (side * side )*density/(map.PARCEL_SIDE * map.PARCEL_SIDE); i++){
			int randomIndex = random.nextInt(parcelsInRect.size());
			Parcel chosenParcel = parcelsInRect.get(randomIndex);
			chosenParcel.setReservoir(reservoir);
			parcelsInRect.remove(randomIndex);
		}
	}
	*/
	
	public List<Point> generateBases(int quantity) {
		Point center = new Point(this.map.getSide() / 2, this.map.getSide() / 2);
		double radious = (map.getSide() / 2) - 10;
		double angle = 2 * Math.PI / quantity;
		Point currentRotationPoint = new Point(radious, 0);
		
		ArrayList<Point> bases = new ArrayList<Point>();
		
		bases.add(currentRotationPoint.add(center));
		
		for (int i = 0 ; i < quantity - 1; i++) {
			double newX = (currentRotationPoint.getX() * Math.cos(angle)) - (currentRotationPoint.getY() * Math.sin(angle));
			double newY = (currentRotationPoint.getX() * Math.sin(angle)) + (currentRotationPoint.getY() * Math.cos(angle));
			currentRotationPoint = new Point(newX, newY);
			
			bases.add(currentRotationPoint.add(center));
		}
		
		return bases;
	}
}
 
