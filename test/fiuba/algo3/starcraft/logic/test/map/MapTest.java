package fiuba.algo3.starcraft.logic.test.map;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.starcraft.logic.game.StarCraft;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.starcraft.logic.map.Map;
import fiuba.algo3.starcraft.logic.map.Parcel;
import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.map.exceptions.NoResourcesToExtract;
import fiuba.algo3.starcraft.logic.map.exceptions.UnitCantGetToDestination;
import fiuba.algo3.starcraft.logic.templates.units.terran.MarineTemplate;
import fiuba.algo3.starcraft.logic.units.MuggleUnit;
import fiuba.algo3.starcraft.logic.units.exceptions.StepsLimitExceeded;

public class MapTest {

	Map map;
	MuggleUnit marine;

	@Before
	public void before() {
		map = new Map(10000, null);
		marine = new MarineTemplate().create(new Point(75, 0));
	}

	@Test
	public void testMapInitialicesWithParcels() {
		Point point = new Point(25,25);
		Parcel parcel = map.getParcelContainingPoint(point);
		assertTrue(parcel.containsPoint(point));
	}
	
	@Test
	public void testMapDeterminesWhetherAPointIsInsideARadiousOfOtherPoint() {
		assertTrue(map.isPointInsideRadiousOfPivotePoint(new Point(0, 0), 10, new Point(1, 0)));
	}
	
	@Test 
	public void testMapReturnsParcelsInsideARect() {
		ArrayList<Parcel> parcels = map.getParcelsContainedInARect(new Point(25, 25), 100);
		Parcel interiorParcel = map.getParcelContainingPoint(new Point(50,50));
		
		assertTrue(parcels.contains(interiorParcel));
	}
	@Test
	public void testMapIsResetedAndHasNoMinerals() throws NoResourcesToExtract {
		for (Parcel parcel : map.getParcelsContainedInARect(new Point(0,0), 1000))
			assertEquals(parcel.getLandForExplotation().extractResource(), null);
		assertTrue(true);
	}
	
	@Test
	public void testMapMovesAMarineMoreThanTheAmmountPerTurn() throws StepsLimitExceeded, UnitCantGetToDestination {
		map.moveUnitToDestination(marine, new Point(200, 0));
		
		double finalX = 75 + marine.getStepsPerTurn() * 100;
				
		assertTrue(marine.getPosition().getX() <= finalX);
	}
	
	@Test
	public void testMapMovesAMarineToTheLimbo() {
		map.moveToLimbo(marine);
		
		assertEquals(marine.getPosition().getX() == 10000, marine.getPosition().getY() == 10000);
	}

    @Test
    public void testGetAdyacentParcels() {
        Point point = new Point(500,500);
        List<Parcel> list;
        list = map.getAdyacentParcels(point,100);
        assertEquals(list.size(),8);
    }
}
