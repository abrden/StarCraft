package fiuba.algo3.starcraft.game;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import fiuba.algo3.starcraft.logic.map.Map;
import fiuba.algo3.starcraft.logic.map.Parcel;
import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.player.Player;
import fiuba.algo3.starcraft.logic.units.Transportable;
import fiuba.algo3.starcraft.logic.units.Unit;
import fiuba.algo3.starcraft.logic.units.exceptions.StepsLimitExceeded;


public class StarCraft {
	public static StarCraft instance = new StarCraft();
	
	private Map map;
	private Player player1;
	private Player player2;
	
	public String toString() {
		return "" + player1 + player2;
	}
	
	public static void start() {
		
	}
	
	public void setPlayer1(Player player) {
		player1 = player;
	}
	
	public void setPlayer2(Player player) {
		player2 = player;
	}
	
	public void setMap(Map map) {
		this.map = map;
	}

	public static void main(String[] args) {
		start();
	}

	public static StarCraft getInstance() {
		return instance;
	}

	//TODO mover a Map
	public List<Unit> unitsInCircumference(final Point position, int range, Player player) {
		ArrayList<Unit> unitsInCircumference = new ArrayList<Unit>();
		Collection<Unit> opponentUnits = player == player1? player2.getUnits() : player1.getUnits();
		for (Unit opponentUnit : opponentUnits) {
			if (map.isPointInsideRadiousOfPivotePoint(position, range ==  0 ? range : 10, opponentUnit.getPosition())) {
				unitsInCircumference.add(opponentUnit);
			}
		}   
		//Sorting
		Collections.<Unit>sort(unitsInCircumference, new Comparator<Unit>() {
				@Override
				public int compare(Unit unit1, Unit unit2) {
					return (int) (unit1.getPosition().distance(position) - unit2.getPosition().distance(position));
				}
		    });
		return (range == 0) ? unitsInCircumference : unitsInCircumference.subList(0, 1);
	}
	
	//TODO mover a Map
	public void moveUnitToDestination(Transportable transportable, Point position) throws StepsLimitExceeded {
		Point initialPoint = transportable.getPosition();
		Point finalPoint = position;
		
		Point direction = finalPoint.substract(initialPoint);
		Point diferentialDirection = direction.divide(1000);
		
		Point pathPoint = initialPoint;
		
		//FIXME: 1000 hardcoded and is ammount of partitions o distance vector
		for (int i = 0; i < 1000 ; i ++) {
			Parcel parcelOfPath = map.getParcelContainingPoint(pathPoint);
			
			if (parcelOfPath.letPass(transportable)) {
				transportable.setPosition(pathPoint);
				pathPoint = pathPoint.add(diferentialDirection);
			} else {
				break;
			}	
		}
	}
}
