package fiuba.algo3.starcraft.logic.test.map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.starcraft.logic.map.ExtractableType;
import fiuba.algo3.starcraft.logic.map.LandType;
import fiuba.algo3.starcraft.logic.map.NoResourcesToExtract;
import fiuba.algo3.starcraft.logic.map.Parcel;
import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.map.Surface;
import fiuba.algo3.starcraft.logic.templates.units.terran.MarineTemplate;
import fiuba.algo3.starcraft.logic.units.MuggleUnit;


public class ParcelTest {
	Parcel parcel = new Parcel(new Point(0,0), 10);
	@Test
	public void testParcelRecognizesIfContainsAPointFromMap() {
		assertTrue(parcel.containsPoint(new Point(5,5)));
		assertFalse(parcel.containsPoint(new Point(11,5)));
	}

	@Test 
	public void testParcelHasToDisablePassingThroughALandUnitWhenIsOfAirType() {
		parcel.setSurface(LandType.air);
		MuggleUnit marine = (MarineTemplate.getInstance()).create(null);

		assertFalse(parcel.letPass(marine));
	}
	
	@Test
	// TODO Implementar
	public void testParcelCanBuildABuildingInsideAParcel() {
	}
	
	@Test
	// TODO Implementar
	public void testParcelHasToDisablePassingThroughALandWithABuilding() {
	}
	
	@Test
	public void testParcelHasMinerals() {
		parcel.setSurface(ExtractableType.volcano);
		
		Surface landWithVolcano = parcel.getLandForExplotation();
		try {
			assertTrue(landWithVolcano.extractResource().getValue() == 10);
		} catch (NoResourcesToExtract e) {
			e.printStackTrace();
		}
	}
}
