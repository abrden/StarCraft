package fiuba.algo3.starcraft.test;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.starcraft.logic.map.LandParcel;
import fiuba.algo3.starcraft.logic.map.Point;


public class ParcelTest {
	LandParcel landParcel = new LandParcel(new Point(0,0), 10);
	@Test
	public void testParcelRecognizesIfContainsAPointFromMap() {
		assertTrue(landParcel.containsPoint(new Point(5,5)));
		assertFalse(landParcel.containsPoint(new Point(11,5)));
	}

}
