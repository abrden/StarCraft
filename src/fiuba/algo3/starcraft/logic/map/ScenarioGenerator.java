package fiuba.algo3.starcraft.logic.map;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fiuba.algo3.starcraft.logic.map.areas.LandType;
import fiuba.algo3.starcraft.logic.map.resources.ReservoirType;
import fiuba.algo3.starcraft.logic.structures.Structure;

public class ScenarioGenerator {
	private Map map;

	public ScenarioGenerator(Map map){
		this.map = map;
	}
	
	//FIXME: repetition of code due to separation of landType and extractableType
	public void assignSurfaceDistributionInRect(LandType landType ,Point origin, int side, double density) {
		ArrayList<Parcel> parcelsInRect = map.getParcelsContainedInARect(origin, side);
		Random random = new Random();
		for (int i = 0 ; i < (side * side)*density/(map.PARCEL_SIDE * map.PARCEL_SIDE); i++){
			int randomIndex = random.nextInt(parcelsInRect.size());
			Parcel chosenParcel = parcelsInRect.get(randomIndex);
			chosenParcel.setSurface(landType);
			parcelsInRect.remove(randomIndex);
		}
	}
	
	public void assignSurfaceDistributionInRect(ReservoirType reservoir,Point origin, int side, double density) {
		ArrayList<Parcel> parcelsInRect = map.getParcelsContainedInARect(origin, side);
		Random random = new Random();
		for (int i = 0 ; i < (side * side )*density/(map.PARCEL_SIDE * map.PARCEL_SIDE); i++){
			int randomIndex = random.nextInt(parcelsInRect.size());
			Parcel chosenParcel = parcelsInRect.get(randomIndex);
			chosenParcel.setSurface(reservoir);
			parcelsInRect.remove(randomIndex);
		}
	}
	
	//TODO Quien usa esto? 
	public void buildStructureInPoint(Structure structure, Point point) {
		map.setStructure(structure, point);
	}

	public List<Point> generateBases(int quantity) {
		// TODO Genera quantity puntos espejados que seran las bases de los jugadores
		return null;
	}
}
