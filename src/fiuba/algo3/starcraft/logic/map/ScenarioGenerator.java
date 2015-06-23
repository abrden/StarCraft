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
		// TODO Genera quantity puntos espejados que seran las bases de los jugadores
		return null;
	}
}
