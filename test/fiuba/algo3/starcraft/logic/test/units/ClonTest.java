package fiuba.algo3.starcraft.logic.test.units;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.starcraft.logic.templates.units.protoss.ZealotTemplate;
import fiuba.algo3.starcraft.logic.units.Clon;
import fiuba.algo3.starcraft.logic.units.Unit;

public class ClonTest {

	@Test
	public void testCloneBornsAlive() {
		Unit zealot = ZealotTemplate.getInstance().create(null);
		Clon clon = new Clon(zealot);
		
		assertTrue(clon.itsAlive());
	}

}
