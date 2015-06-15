package fiuba.algo3.starcraft.logic.test.structures;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.structures.Depot;
import fiuba.algo3.starcraft.logic.templates.qualities.Life;

public class DepotTest {

	@Test
	public void testHavingADepotIncreasesPlayersPopulationQuotaBy5() {
		Depot depot = new Depot(null, new Life(100), new Point(500,500));
		
		assertEquals(depot.getPopulationQuotaIncrement(), 5);
	}

	@Test
	public void testDepotIsDeadWithLife100AndHarm100() {
		Depot depot = new Depot(null, new Life(100), new Point(500,500));
		
		depot.reduceLife(100);
		
		assertTrue(!depot.itsAlive());
	}
}
