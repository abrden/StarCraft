package fiuba.algo3.starcraft.logic.map;

import java.util.ArrayList;

import fiuba.algo3.starcraft.logic.structures.Structure;

public class Map {
	final double PARCEL_SIDE = 10;

	private ArrayList<Parcel> parcels = new ArrayList<Parcel>();	
	private double side;
	
	public Map(double side) {
		this.side = side;
		createParcels(side/PARCEL_SIDE);
	}
	
	private void createParcels(double numberOfParcels) {
		for (int x = 0 ; x < numberOfParcels ; x ++) {
			for (int y = 0 ; y < numberOfParcels ; y ++) {
				System.out.println("estaParcel se hace con X :" + x * PARCEL_SIDE  + " Y : " + y * PARCEL_SIDE + " y lado : " + PARCEL_SIDE);
				Parcel parcel = new Parcel(new Point(x * PARCEL_SIDE,y * PARCEL_SIDE),PARCEL_SIDE);
				parcel.setSurface(LandType.land);
				parcels.add(parcel);
			}
		}

	}
	
	public Parcel getParcelContainingPoint(Point point) throws IndexOutOfBoundsException{
		for (Parcel parcel: parcels) {
			if (parcel.containsPoint(point)) {
				return parcel;
			}
		}
		throw new IndexOutOfBoundsException();
	}
	
	public boolean isPointInsideRadiousOfPivotePoint(Point pivotePoint, double radious, Point otherPoint) {
		return (pivotePoint.distance(otherPoint)) <= radious;
	}
	
	public void buildStructureInPoint(Structure structure, Point point) {
		Parcel parcel = getParcelContainingPoint(point);
		parcel.setStructure(structure);
	}
}
