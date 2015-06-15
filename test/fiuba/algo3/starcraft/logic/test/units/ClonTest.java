package fiuba.algo3.starcraft.logic.test.units;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.templates.units.protoss.ZealotTemplate;
import fiuba.algo3.starcraft.logic.units.Clone;
import fiuba.algo3.starcraft.logic.units.MuggleUnit;

public class ClonTest {
	
	@Test
	public void testCloneBornsAlive() {
		MuggleUnit zealot = new ZealotTemplate().create(new Point(500,500));
		Clone clon = new Clone(zealot);
		
		assertTrue(clon.itsAlive());
	}

}
