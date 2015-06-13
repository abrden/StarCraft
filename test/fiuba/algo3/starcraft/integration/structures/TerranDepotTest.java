package fiuba.algo3.starcraft.integration.structures;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.starcraft.logic.map.Map;
import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.map.exceptions.NoResourcesToExtract;
import fiuba.algo3.starcraft.logic.player.Player;
import fiuba.algo3.starcraft.logic.player.Resources;
import fiuba.algo3.starcraft.logic.structures.Depot;
import fiuba.algo3.starcraft.logic.structures.builders.TerranBuilder;
import fiuba.algo3.starcraft.logic.structures.exceptions.InsufficientResources;
import fiuba.algo3.starcraft.logic.structures.exceptions.MissingStructureRequired;
import fiuba.algo3.starcraft.logic.structures.exceptions.TemplateNotFound;
import fiuba.algo3.starcraft.logic.templates.structures.terran.DepositoSuministroTemplate;

public class TerranDepotTest {
	Map map;
	Point position;
	Point position2;
	Resources initialResources;
	Player player;
	@Before
	public void before() {
		initialResources = new Resources(200,0);
		map = new Map(1000);
		position = new Point(54,70);
		position2 = new Point(10,70);
		player = new Player(null, null, new TerranBuilder(), position, initialResources, map);
	}
	
	@Test
	public void testPopulationQuotais5With1Deposito() throws InsufficientResources, MissingStructureRequired, TemplateNotFound, NoResourcesToExtract {
		player.newStructureWithName("Deposito Suministro", position);
		/* Deposito tarda 6 turnos en hacerse, al septimo estara listo para utilizar */
		for(int i = 0; i < 7; i++) player.newTurn();

		assertEquals(player.populationQuota(), 5);
	}

	@Test
	public void testPopulationQuotais10With2Deposito() throws InsufficientResources, MissingStructureRequired, TemplateNotFound, NoResourcesToExtract {
		player.newStructureWithName("Deposito Suministro", position);
		player.newStructureWithName("Deposito Suministro", position2);
		/* Deposito tarda 6 turnos en hacerse, al septimo estara listo para utilizar */
		for(int i = 0; i < 7; i++) player.newTurn();
		
		assertEquals(player.populationQuota(), 10);
	}
	
	@Test
	public void testPopulationQuotais10With2PilonIndependentlyOfTurns() throws InsufficientResources, MissingStructureRequired, TemplateNotFound, NoResourcesToExtract {
		player.newStructureWithName("Deposito Suministro", position);
		player.newStructureWithName("Deposito Suministro", position2);
		/* Deposito tarda 6 turnos en hacerse, al septimo estara listo para utilizar */
		for(int i = 0; i < 7; i++) player.newTurn();
		
		for(int i = 0; i < 46; i++) player.newTurn();
		
		assertEquals(player.populationQuota(), 10);		
	}

	@Test
	public void testPopulationQuotais0With2PilonsAnd0IfBothAreDestroyed() throws InsufficientResources {
		DepositoSuministroTemplate templateDepositoSuministro = new DepositoSuministroTemplate();
		
		Depot depot1 = templateDepositoSuministro.create(position);
		player.pays(100,0);
		player.receiveNewStructure(depot1);
		player.newTurn();
		assertEquals(player.populationQuota(), 5);		
		
		Depot depot2 = templateDepositoSuministro.create(position2);
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
