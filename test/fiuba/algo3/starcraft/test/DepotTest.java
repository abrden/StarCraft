package fiuba.algo3.starcraft.test;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.starcraft.logic.structures.Depot;
import fiuba.algo3.starcraft.logic.templates.DepositoSuministroTemplate;
import fiuba.algo3.starcraft.logic.templates.PilonTemplate;

public class DepotTest {

	@Test
	public void testTerranDepotStartsEmpty() {
		DepositoSuministroTemplate template = new DepositoSuministroTemplate();
		Depot depot = template.create();
		assertTrue(depot.isEmpty());
	}
	
	@Test
	public void testProtossDepotStartsEmpty() {
		PilonTemplate template = new PilonTemplate();
		Depot depot = template.create();
		assertTrue(depot.isEmpty());
	}
	
}
