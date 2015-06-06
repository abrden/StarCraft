package fiuba.algo3.starcraft.logic.test.player.integration.structures;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.starcraft.logic.player.Player;
import fiuba.algo3.starcraft.logic.player.Resources;
import fiuba.algo3.starcraft.logic.structures.Depot;
import fiuba.algo3.starcraft.logic.structures.builders.TerranBuilder;
import fiuba.algo3.starcraft.logic.structures.exceptions.InsufficientResources;
import fiuba.algo3.starcraft.logic.structures.exceptions.MissingStructureRequired;
import fiuba.algo3.starcraft.logic.structures.exceptions.TemplateNotFound;
import fiuba.algo3.starcraft.logic.templates.structures.terran.DepositoSuministroTemplate;

public class TerranDepotTest {

	@Test
	public void testPopulationQuotais5With1Deposito() throws InsufficientResources, MissingStructureRequired, TemplateNotFound {
		Resources initialResources = new Resources(200,0);
		Player player = new Player(null, null, TerranBuilder.getInstance(), initialResources);
		
		player.newStructureWithName("Deposito Suministro");
		/* Deposito tarda 6 turnos en hacerse, al septimo estara listo para utilizar */
		for(int i = 0; i < 7; i++) player.newTurn();

		assertEquals(player.populationQuota(), 5);
	}

	@Test
	public void testPopulationQuotais10With2Deposito() throws InsufficientResources, MissingStructureRequired, TemplateNotFound {
		Resources initialResources = new Resources(200,0);
		Player player = new Player(null, null, TerranBuilder.getInstance(), initialResources);
		
		player.newStructureWithName("Deposito Suministro");
		player.newStructureWithName("Deposito Suministro");
		/* Deposito tarda 6 turnos en hacerse, al septimo estara listo para utilizar */
		for(int i = 0; i < 7; i++) player.newTurn();
		
		assertEquals(player.populationQuota(), 10);
	}
	
	@Test
	public void testPopulationQuotais10With2PilonIndependentlyOfTurns() throws InsufficientResources, MissingStructureRequired, TemplateNotFound {
		Resources initialResources = new Resources(200,0);
		Player player = new Player(null, null, TerranBuilder.getInstance(), initialResources);	
		player.newStructureWithName("Deposito Suministro");
		player.newStructureWithName("Deposito Suministro");
		/* Deposito tarda 6 turnos en hacerse, al septimo estara listo para utilizar */
		for(int i = 0; i < 7; i++) player.newTurn();
		
		for(int i = 0; i < 46; i++) player.newTurn();
		
		assertEquals(player.populationQuota(), 10);		
	}

	@Test
	public void testPopulationQuotais0With2PilonsAnd0IfBothAreDestroyed() throws InsufficientResources {
		Resources initialResources = new Resources(200,0);
		Player player = new Player(null, null, TerranBuilder.getInstance(), initialResources);
		DepositoSuministroTemplate templateDepositoSuministro =  DepositoSuministroTemplate.getInstance();
		
		Depot depot1 = templateDepositoSuministro.create();
		player.pays(100,0);
		player.receiveNewStructure(depot1);
		player.newTurn();
		assertEquals(player.populationQuota(), 5);		
		
		Depot depot2 = templateDepositoSuministro.create();
		player.pays(100,0);
		player.receiveNewStructure(depot2);
		player.newTurn();
		assertEquals(player.populationQuota(), 10);		
		
		depot1.reduceLife(500);
		depot2.reduceLife(500);
		player.newTurn();
		assertEquals(player.populationQuota(), 0);		
	}

}
