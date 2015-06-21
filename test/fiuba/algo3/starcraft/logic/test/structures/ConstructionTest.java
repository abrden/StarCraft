package fiuba.algo3.starcraft.logic.test.structures;

import static org.junit.Assert.*;

import fiuba.algo3.starcraft.logic.structures.exceptions.ConstructorIsDead;
import org.junit.Test;

import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.structures.Construction;
import fiuba.algo3.starcraft.logic.structures.Depot;
import fiuba.algo3.starcraft.logic.structures.exceptions.ConstructionNotFinished;

public class ConstructionTest {

	@Test
	public void testLoweringRelease5TimesOnConstructionWithReleaseIn5TurnLeavesItFinished() {
		Construction<Depot> construction = new Construction<Depot>(new Depot(null, null, new Point(500,500)), 5, null);
		
		for(int i = 0; i < 5; i++) construction.lowerRelease();
		
		assertTrue(construction.itsFinished());
	}

	@Test
	public void testLoweringRelease5TimesOnConstructionWithReleaseIn5EnablesGathering() throws ConstructionNotFinished, ConstructorIsDead {
		Construction<Depot> construction = new Construction<Depot>(new Depot(null, null, new Point(500,500)), 5, null);
		
		for(int i = 0; i < 5; i++) construction.lowerRelease();
		
		assertEquals(construction.gather().getClass(), Depot.class);
	}
	
	@Test(expected = ConstructionNotFinished.class)
	public void testGatheringConstructionBeforeReleaseThrowsConstructionNotFinishedException() throws ConstructionNotFinished, ConstructorIsDead {
		Construction<Depot> construction = new Construction<Depot>(new Depot(null, null, new Point(500,500)), 5, null);
		
		construction.gather();
	}
	
}
