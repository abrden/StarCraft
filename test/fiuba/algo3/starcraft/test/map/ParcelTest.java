package fiuba.algo3.starcraft.test.map;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.starcraft.logic.map.LandType;
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
		
		assertTrue(parcel.canPassThrough(marine));
	}

}
