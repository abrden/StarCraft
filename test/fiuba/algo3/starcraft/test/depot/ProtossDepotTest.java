package fiuba.algo3.starcraft.test.depot;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.starcraft.logic.player.Player;
import fiuba.algo3.starcraft.logic.player.Resources;
import fiuba.algo3.starcraft.logic.structures.Depot;
import fiuba.algo3.starcraft.logic.structures.InsufficientResources;
import fiuba.algo3.starcraft.logic.templates.PilonTemplate;

public class ProtossDepotTest {

	@Test
	public void testPopulationQuotais5With1Pilon() throws InsufficientResources {
		Resources initialResources = new Resources(200,0);
		Player player = new Player(initialResources);
		PilonTemplate templatePilon = PilonTemplate.getInstance();
		Depot pilon = templatePilon.create();
		
		player.pays(100,0);
		player.newStructure(pilon);
		
		assertEquals(player.populationQuota(), 5);
	}

	@Test
	public void testPopulationQuotais10With2Pilon() throws InsufficientResources {
		Resources initialResources = new Resources(200,0);
		Player player = new Player(initialResources);
		PilonTemplate templatePilon = PilonTemplate.getInstance();
		
		for(int i = 0; i < 2; i++) {
			Depot pilon = templatePilon.create();
			player.pays(100,0);
			player.newStructure(pilon);
		}
		
		assertEquals(player.populationQuota(), 10);
	}
	
	@Test
	public void testPopulationQuotais10With2PilonIndependentlyOfTurns() throws InsufficientResources {
		Resources initialResources = new Resources(200,0);
		Player player = new Player(initialResources);
		PilonTemplate templatePilon = PilonTemplate.getInstance();
		for(int i = 0; i < 2; i++) {
			Depot pilon = templatePilon.create();
			player.pays(100,0);
			player.newStructure(pilon);
		}
		
		for(int i = 0; i < 46; i++) player.newTurn();
		
		assertEquals(player.populationQuota(), 10);		
	}

	@Test
	public void testPopulationQuotais10With2PilonsAnd5IfOneIsDestroyed() throws InsufficientResources {
		Resources initialResources = new Resources(200,0);
		Player player = new Player(initialResources);
		PilonTemplate templatePilon = PilonTemplate.getInstance();
		Depot pilon1 = templatePilon.create();
		player.pays(100,0);
		player.newStructure(pilon1);
		Depot pilon2 = templatePilon.create();
		player.pays(100,0);
		player.newStructure(pilon2);
		
		pilon2.reduceLife(600);
		player.newTurn();
		
		assertEquals(player.populationQuota(), 5);		
	}
	
}
