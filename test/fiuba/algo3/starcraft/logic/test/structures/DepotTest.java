package fiuba.algo3.starcraft.logic.test.structures;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.starcraft.logic.player.Player;
import fiuba.algo3.starcraft.logic.structures.Depot;
import fiuba.algo3.starcraft.logic.templates.qualities.Life;

public class DepotTest {

	@Test
	public void testUpdateIncreasesPlayersPopulationQuotaBy5() {
		Depot depot = new Depot(null, new Life(100), null);
		Player player = new Player(null, null, null, null, null);
		
		depot.update(player);
		
		assertEquals(player.populationQuota(), 5);
	}

	@Test
	public void testDepotIsDeadWithLife100AndHarm100() {
		Depot depot = new Depot(null, new Life(100), null);
		
		depot.reduceLife(100);
		
		assertTrue(!depot.itsAlive());
	}
}
