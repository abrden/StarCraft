package fiuba.algo3.starcraft.logic.test.structures;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.starcraft.logic.structures.Depot;
import fiuba.algo3.starcraft.logic.templates.qualities.Life;

public class DepotTest {

	@Test
	public void testHavingADepotIncreasesPlayersPopulationQuotaBy5() {
		Depot depot = new Depot(null, new Life(100), null);
<<<<<<< HEAD
		Player player = new Player(null, null, null, null, null, null);
=======
>>>>>>> 60e498f1e7e1aa5a87dcdeb177fa693c0e02424f
		
		assertEquals(depot.getPopulationQuotaIncrement(), 5);
	}

	@Test
	public void testDepotIsDeadWithLife100AndHarm100() {
		Depot depot = new Depot(null, new Life(100), null);
		
		depot.reduceLife(100);
		
		assertTrue(!depot.itsAlive());
	}
}
