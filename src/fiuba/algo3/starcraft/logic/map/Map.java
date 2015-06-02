package fiuba.algo3.starcraft.logic.map;

import java.util.ArrayList;

import fiuba.algo3.starcraft.logic.structures.Structure;

public class Map {
	final double PARCEL_SIDE = 10;

	private ArrayList<Parcel> parcels = new ArrayList<Parcel>();
	private double side;
	// FIXME: New efficient representation of map
	private ArrayList<ArrayList> column = new ArrayList<ArrayList>();
	private ArrayList<Parcel> row = new ArrayList<Parcel>();
	
	public Map(double side) {
		this.side = side;
		createMatrix(side/PARCEL_SIDE);
		createParcels(side/PARCEL_SIDE);
	}
	
	private void createMatrix (double numberOfParcels){
		for (int x = 0 ; x < numberOfParcels ; x++) {
			column.add(new ArrayList<Parcel>());
		}
	}
	
	private void createParcels(double numberOfParcels) {
		for (int x = 0 ; x < numberOfParcels ; x ++) {
			for (int y = 0 ; y < numberOfParcels ; y ++) {
				Parcel parcel = new Parcel(new Point(x * PARCEL_SIDE,y * PARCEL_SIDE),PARCEL_SIDE);
				parcel.setSurface(LandType.land);
				
				ArrayList<Parcel> row = column.get(x);
				row.add(parcel);
				
				//parcels.add(parcel);
			}
		}
	}
	
	public Parcel getParcelContainingPoint(Point point) throws IndexOutOfBoundsException{
		return (Parcel) column.get((int)(point.getX() / PARCEL_SIDE)).get((int)(point.getY() / PARCEL_SIDE));
		
		/*for (Parcel parcel: parcels) {
			if (parcel.containsPoint(point)) {
				return parcel;
			}
		}
		throw new IndexOutOfBoundsException();*/
	}
	
	public ArrayList<Parcel> getParcelsContainedInARect(Point point, int side) {
		ArrayList<Parcel> parcels = new ArrayList<Parcel>();
		
		for (int x = (int)point.getX() ; x < (int)point.getX() + side ; x += PARCEL_SIDE) {
			for (int y = (int)point.getY() ; y < (int)point.getY() + side ; y += PARCEL_SIDE) {	
				Parcel parcel = getParcelContainingPoint(new Point(x,y));
				parcels.add(parcel);
			}
		}
		
		return parcels;
	}
	
	public boolean isPointInsideRadiousOfPivotePoint(Point pivotePoint, double radious, Point otherPoint) {
		return (pivotePoint.distance(otherPoint)) <= radious;
	}
}
