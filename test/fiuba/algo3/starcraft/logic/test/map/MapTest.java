package fiuba.algo3.starcraft.logic.test.map;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import fiuba.algo3.starcraft.logic.map.Map;
import fiuba.algo3.starcraft.logic.map.Parcel;
import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.map.exceptions.NoResourcesToExtract;
import fiuba.algo3.starcraft.logic.templates.units.terran.MarineTemplate;
import fiuba.algo3.starcraft.logic.units.MuggleUnit;
import fiuba.algo3.starcraft.logic.units.exceptions.StepsLimitExceeded;

public class MapTest {
	Map map = new Map(10000, null);
	@Test
	public void testMapInitialicesWithParcels() {
		Point point = new Point(25,25);
		Parcel parcel = map.getParcelContainingPoint(point);
		assertTrue(parcel.containsPoint(point));
	}
	
	@Test
	public void testMapDeterminesWhetherAPointIsInsideARadiousOfOtherPoint() {
		assertTrue(map.isPointInsideRadiousOfPivotePoint(new Point(0,0), 10, new Point(1,0)));
	}
	
	@Test 
	public void testMapReturnsParcelsInsideARect() {
		ArrayList<Parcel> parcels = map.getParcelsContainedInARect(new Point(25, 25), 100);
		Parcel interiorParcel = map.getParcelContainingPoint(new Point(50,50));
		assertTrue(parcels.contains(interiorParcel) && (parcels.size() == 100));
	}
	@Test
	public void testMapIsResetedAndHasNoMinerals() throws NoResourcesToExtract {
		map = new Map(10000, null);
		for (Parcel parcel : map.getParcelsContainedInARect(new Point(0,0), 1000))
			assertEquals(parcel.getLandForExplotation().extractResource(), null);
		assertTrue(true);
	}
	
	@Test
	public void testMapMovesAMarineMoreThanTheAmmountPerTurn() throws StepsLimitExceeded {
		map = new Map(1000, null);
		
		MuggleUnit marine = new MarineTemplate().create(new Point(75, 0));
		
		map.moveUnitToDestination(marine, new Point(200, 0));
		
		double finalX = 75 + marine.getStepsPerTurn();
				
		assertTrue(marine.getPosition().getX() <= finalX);
	}
	
	@Test
	public void testMapMovesAMarineToTheLimbo() {
		map = new Map(1000, null);
		
		MuggleUnit marine = new MarineTemplate().create(new Point(75, 0));
		
		map.moveToLimbo(marine);
		
		assertTrue(marine.getPosition().getX() == 10000 && marine.getPosition().getY() == 10000);
	}
	
	
}
