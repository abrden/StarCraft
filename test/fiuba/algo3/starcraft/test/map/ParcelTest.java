package fiuba.algo3.starcraft.test.map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.starcraft.logic.map.ExtractableType;
import fiuba.algo3.starcraft.logic.map.Land;
import fiuba.algo3.starcraft.logic.map.LandType;
import fiuba.algo3.starcraft.logic.map.NoResourcesToExtractException;
import fiuba.algo3.starcraft.logic.map.Parcel;
import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.templates.MarineTemplate;
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
		MuggleUnit marine = (MarineTemplate.getInstance()).create();

		assertFalse(parcel.letPass(marine));
	}
	
	@Test
	public void testParcelCanBuildABuildingIncideAParcel() {
		
	}
	
	@Test
	public void testParcelHasToDisablePassingThroughALandWithABuilding() {
	}
	
	@Test
	public void testParcelHasMinerals() {
		parcel.setSurface(ExtractableType.volcano);
		
		Land landWithVolcano = parcel.getLandForExplotation();
		try {
			assertTrue(landWithVolcano.extractResource().getValue() == 10);
		} catch (NoResourcesToExtractException e) {
			e.printStackTrace();
		}
	}
}
