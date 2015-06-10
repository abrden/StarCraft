package fiuba.algo3.starcraft.logic.test.map;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import fiuba.algo3.starcraft.logic.map.Map;
import fiuba.algo3.starcraft.logic.map.NoResourcesToExtract;
import fiuba.algo3.starcraft.logic.map.Parcel;
import fiuba.algo3.starcraft.logic.map.Point;

public class MapTest {
	Map map = new Map(10000);
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
	public void testMapIsResetedAndHasNoMinerals() {
		map = new Map(10000);
		for (Parcel parcel : map.getParcelsContainedInARect(new Point(0,0), 1000)) {
			try {
				parcel.getLandForExplotation().extractResource();
				assertTrue(false);
			} catch (NoResourcesToExtract e){
			}
		}
		assertTrue(true);
	}
	
}
