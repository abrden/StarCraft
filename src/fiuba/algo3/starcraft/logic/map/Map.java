package fiuba.algo3.starcraft.logic.map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import fiuba.algo3.starcraft.game.StarCraft;
import fiuba.algo3.starcraft.logic.map.areas.LandType;
import fiuba.algo3.starcraft.logic.map.exceptions.NoResourcesToExtract;
import fiuba.algo3.starcraft.logic.map.resources.ExtractableType;
import fiuba.algo3.starcraft.logic.structures.Structure;
import fiuba.algo3.starcraft.logic.units.Transportable;
import fiuba.algo3.starcraft.logic.units.Unit;
import fiuba.algo3.starcraft.logic.units.exceptions.StepsLimitExceeded;

public class Map {

	public final double PARCEL_SIDE = 10;
	private StarCraft game;
	
	@SuppressWarnings("unused")
	private double side;
	@SuppressWarnings({"rawtypes"})
	private ArrayList<ArrayList> row = new ArrayList<ArrayList>();
	@SuppressWarnings("unused")
	private ArrayList<Parcel> columns = new ArrayList<Parcel>();
	
	public Map(double side, StarCraft game) {
		this.side = side;
		createMatrix(side/PARCEL_SIDE);
		createParcels(side/PARCEL_SIDE);
		this.game = game;
	}
	
	private void createMatrix (double numberOfParcels){
		for (int x = 0 ; x < numberOfParcels ; x++) {
			row.add(new ArrayList<Parcel>());
		}
	}
	
	private void createParcels(double numberOfParcels) {
		for (int x = 0 ; x < numberOfParcels ; x ++) {
			for (int y = 0 ; y < numberOfParcels ; y ++) {
				Parcel parcel = new Parcel(new Point(x * PARCEL_SIDE,y * PARCEL_SIDE),PARCEL_SIDE);
				parcel.setSurface(LandType.land);
				
				@SuppressWarnings("unchecked")
				ArrayList<Parcel> column = row.get(x);
				column.add(parcel);
			}
		}
	}
	
	public Parcel getParcelContainingPoint(Point point) throws IndexOutOfBoundsException{
		return (Parcel) row.get((int)(point.getX() / PARCEL_SIDE)).get((int)(point.getY() / PARCEL_SIDE));
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

	public void setUnit(Unit unit, Point position) {
		// TODO Implementar
	}
	
	public void setStructure(Structure structure, Point point) {
		Parcel parcel = this.getParcelContainingPoint(point);
		parcel.setStructure(structure);
	}

	public void resourceRequiredIsThere(Structure structure, Point position) throws NoResourcesToExtract {
		Parcel parcel = this.getParcelContainingPoint(position);
		ExtractableType resource = parcel.getLandForExplotation().extractResource();
		if (!structure.iCanExtract(resource)) throw new NoResourcesToExtract();
	}

	public void moveToLimbo(Transportable unit) {
		unit.setPosition(new Point(side * 10, side * 10));
	}
	
	public void moveUnitToDestination(Transportable transportable, Point position) throws StepsLimitExceeded {
		Point initialPoint = transportable.getPosition();
		Point finalPoint = position;
			
		Point direction = finalPoint.substract(initialPoint);
		Point diferentialDirection;
		
		if (finalPoint.distance(initialPoint) >= transportable.getStepsPerTurn()) {
			Point normalPoint = direction.divide(finalPoint.distance(initialPoint));		
			Point correctSizePoint = normalPoint.multiply(transportable.getStepsPerTurn());
						
			diferentialDirection = correctSizePoint.divide(1000);
		} else {
			diferentialDirection = direction.divide(1000);
		}
		
		Point pathPoint = initialPoint;
		//FIXME: 1000 hardcoded and is ammount of partitions o distance vector
		for (int i = 0; i < 1000 ; i ++) {
			Parcel parcelOfPath = this.getParcelContainingPoint(pathPoint);
				
			if (parcelOfPath.letPass(transportable)) {
				transportable.setPosition(pathPoint);
				pathPoint = pathPoint.add(diferentialDirection);
			} else break;
		}	
	}
	
	public List<Unit> unitsUnderInfluenceOfPower(final Point position, int range, Iterable<Unit> playerUnits) {
		if (range == 0) return this.searchUnitToClone(position, range, playerUnits);
		else return this.enemyUnitsInCircle(position, range, playerUnits);
	}
	
	private List<Unit> searchUnitToClone(final Point position, int range, Iterable<Unit> playerUnits) {
		return this.unitsInCircle(position, range, playerUnits).subList(0, 1);
	}
	
	//FIXME: lets try to implement canFly in unit, transportUnit can fly, thats a fact
	public List<Unit> enemyUnitsInCircle(final Point position, int range, Iterable<Unit> playerUnits /*, canFly*/) {
		return this.unitsInCircle(position, range, game.getEnemyUnits(playerUnits));
	}
	
	private List<Unit> unitsInCircle(final Point position, int range, Iterable<Unit> units/*, canFly*/) {
		
		ArrayList<Unit> unitsInCircle = new ArrayList<Unit>();
		for (Unit unit : units) {
			if (this.isPointInsideRadiousOfPivotePoint(position, range ==  0 ? range : 10, unit.getPosition())) {
				//if (unit.canFly == canFly) unitsInCircle.add(unit)
				unitsInCircle.add(unit);
			}
		}  
		
		// Sorting
		Collections.<Unit>sort(unitsInCircle, new Comparator<Unit>() {
				@Override
				public int compare(Unit unit1, Unit unit2) {
					return (int) (unit1.getPosition().distance(position) - unit2.getPosition().distance(position));
				}
		    });
		
		return unitsInCircle;
	}

	public void removeStructureFrom(Point position) {
		this.getParcelContainingPoint(position).setStructure(null);
	}

}
