package fiuba.algo3.starcraft.test.depot;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.starcraft.logic.player.Player;
import fiuba.algo3.starcraft.logic.player.Resources;
import fiuba.algo3.starcraft.logic.structures.Depot;
import fiuba.algo3.starcraft.logic.templates.DepositoSuministroTemplate;

public class TerranDepotTest {

	@Test
	public void testPopulationQuotais5With1Pilon() {
		Resources initialResources = new Resources(200,0);
		Player player = new Player(initialResources);
		DepositoSuministroTemplate templateDepositoSuministro = new DepositoSuministroTemplate();
		Depot depot = templateDepositoSuministro.create();
		
		player.pays(100,0);
		player.newStructure(depot);
		
		assertEquals(player.populationQuota(), 5);
	}

	@Test
	public void testPopulationQuotais10With2Pilon() {
		Resources initialResources = new Resources(200,0);
		Player player = new Player(initialResources);
		DepositoSuministroTemplate templateDepositoSuministro = new DepositoSuministroTemplate();
		
		for(int i = 0; i < 2; i++) {
			Depot depot = templateDepositoSuministro.create();
			player.pays(100,0);
			player.newStructure(depot);
		}
		
		assertEquals(player.populationQuota(), 10);
	}
	
	@Test
	public void testPopulationQuotais10With2PilonIndependentlyOfTurns() {
		Resources initialResources = new Resources(200,0);
		Player player = new Player(initialResources);
		DepositoSuministroTemplate templateDepositoSuministro = new DepositoSuministroTemplate();
		for(int i = 0; i < 2; i++) {
			Depot depot = templateDepositoSuministro.create();
			player.pays(100,0);
			player.newStructure(depot);
		}
		
		for(int i = 0; i < 46; i++) player.newTurn();
		
		assertEquals(player.populationQuota(), 10);		
	}

	@Test
	public void testPopulationQuotais10With2PilonsAnd0IfBothAreDestroyed() {
		Resources initialResources = new Resources(200,0);
		Player player = new Player(initialResources);
		DepositoSuministroTemplate templateDepositoSuministro = new DepositoSuministroTemplate();
		Depot depot1 = templateDepositoSuministro.create();
		player.pays(100,0);
		player.newStructure(depot1);
		Depot depot2 = templateDepositoSuministro.create();
		player.pays(100,0);
		player.newStructure(depot2);
		
		depot1.reduceLife(500);
		depot2.reduceLife(500);
		player.newTurn();
		
		assertEquals(player.populationQuota(), 0);		
	}

}
