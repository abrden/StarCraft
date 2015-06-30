package fiuba.algo3.starcraft.logic.test.map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import fiuba.algo3.starcraft.logic.map.Map;
import fiuba.algo3.starcraft.logic.structures.Depot;
import fiuba.algo3.starcraft.logic.templates.qualities.Life;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.starcraft.logic.map.Parcel;
import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.map.areas.Surface;
import fiuba.algo3.starcraft.logic.map.exceptions.NoResourcesToExtract;
import fiuba.algo3.starcraft.logic.map.resources.ExtractableType;
import fiuba.algo3.starcraft.logic.map.resources.ReservoirType;
import fiuba.algo3.starcraft.logic.templates.units.terran.MarineTemplate;
import fiuba.algo3.starcraft.logic.units.MuggleUnit;


public class ParcelTest {

	Parcel parcel;
	Map map;
	Depot depot;

	@Before
	public void before() {
		map = new Map(1000,null);
        parcel = map.getParcelContainingPoint(new Point(0,0));
		depot = new Depot("Deposito Suministro", new Life(500), new Point(2,5));
	}

	@Test
	public void testParcelRecognizesIfContainsAPointFromMap() {
		assertTrue(parcel.containsPoint(new Point(5,5)));
		assertFalse(parcel.containsPoint(new Point(101,55)));
	}

	@Test 
	public void testParcelHasToDisablePassingThroughALandUnitWhenIsOfAirType() {
		parcel.setAirSurface();
		MuggleUnit marine = (new MarineTemplate()).create(new Point(500,500));

		assertFalse(parcel.letPass(marine));
	}
	
	@Test
	public void testParcelCanBuildABuildingInsideAParcel() {
		map.setStructure(depot, new Point(2,5));
		parcel = map.getParcelContainingPoint(new Point(5,5));

		assertEquals(parcel.getStructure(), depot);

	}
	
	@Test
	public void testParcelHasToDisablePassingThroughALandWithABuilding() {
        parcel.setStructure(depot);
        MuggleUnit marine = (new MarineTemplate()).create(new Point(500,500));
        assertTrue(!parcel.letPass(marine));
	}
	
	@Test
	public void testParcelHasMinerals() {
		parcel.setReservoir(ReservoirType.volcano);
		
		Surface landWithVolcano = parcel.getLandForExplotation();
		try {
			assertEquals(landWithVolcano.extractResource(), ExtractableType.gas);
		} catch (NoResourcesToExtract e) {
			e.printStackTrace();
		}
	}
}
