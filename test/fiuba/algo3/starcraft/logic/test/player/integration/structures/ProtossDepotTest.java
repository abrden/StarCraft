package fiuba.algo3.starcraft.logic.test.player.integration.structures;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.starcraft.logic.player.Player;
import fiuba.algo3.starcraft.logic.player.Resources;
import fiuba.algo3.starcraft.logic.structures.Depot;
import fiuba.algo3.starcraft.logic.structures.builders.ProtossBuilder;
import fiuba.algo3.starcraft.logic.structures.exceptions.InsufficientResources;
import fiuba.algo3.starcraft.logic.structures.exceptions.MissingStructureRequired;
import fiuba.algo3.starcraft.logic.structures.exceptions.TemplateNotFound;
import fiuba.algo3.starcraft.logic.templates.structures.protoss.PilonTemplate;

public class ProtossDepotTest {
	
	@Test
	public void testPopulationQuotais5With1Pilon() throws InsufficientResources, MissingStructureRequired, TemplateNotFound {
		Resources initialResources = new Resources(200,0);
		Player player = new Player(null, null, new ProtossBuilder(), null, initialResources);
		
		player.newStructureWithName("Pilon", null);
		/* Pilon tarda 5 turnos en hacerse, al sexto estara listo para utilizar */
		for(int i = 0; i < 6; i++) player.newTurn();
		
		assertEquals(player.populationQuota(), 5);
	}

	@Test
	public void testPopulationQuotais10With2Pilon() throws InsufficientResources, MissingStructureRequired, TemplateNotFound {
		Resources initialResources = new Resources(200,0);
		Player player = new Player(null, null, new ProtossBuilder(), null, initialResources);
		
		player.newStructureWithName("Pilon", null);
		player.newStructureWithName("Pilon", null);
		for(int i = 0; i < 6; i++) player.newTurn();
		
		assertEquals(player.populationQuota(), 10);
	}
	
	@Test
	public void testPopulationQuotais10With2PilonIndependentlyOfTurns() throws InsufficientResources, MissingStructureRequired, TemplateNotFound {
		Resources initialResources = new Resources(200,0);
		Player player = new Player(null, null, new ProtossBuilder(), null, initialResources);
		
		player.newStructureWithName("Pilon", null);
		player.newStructureWithName("Pilon", null);
		for(int i = 0; i < 6; i++) player.newTurn();
		
		for(int i = 0; i < 46; i++) player.newTurn();
		
		assertEquals(player.populationQuota(), 10);		
	}

	@Test
	public void testPopulationQuotais10With2PilonsAnd5IfOneIsDestroyed() throws InsufficientResources, MissingStructureRequired, TemplateNotFound {
		Resources initialResources = new Resources(200,0);
		Player player = new Player(null, null, new ProtossBuilder(), null, initialResources);
		
		player.newStructureWithName("Pilon", null);
		for(int i = 0; i < 6; i++) player.newTurn();
		assertEquals(player.populationQuota(), 5);	
		
		/* Creo un pilon afuera para mantener su referencia */
		PilonTemplate templatePilon = new PilonTemplate();
		Depot pilon = templatePilon.create(null);
		player.pays(100,0);
		player.receiveNewStructure(pilon);
		player.newTurn();
		assertEquals(player.populationQuota(), 10);
		
		pilon.reduceLife(600);
		player.newTurn();
		assertEquals(player.populationQuota(), 5);		
	}
	
	@Test
	public void testPopulationQuotais200With300Pilons() throws InsufficientResources, MissingStructureRequired, TemplateNotFound {
		Resources initialResources = new Resources(30000,0);
		Player player = new Player(null, null, new ProtossBuilder(), null, initialResources);
		
		for(int j = 0; j < 300; j++) {
			player.newStructureWithName("Pilon", null);
			for(int i = 0; i < 6; i++) player.newTurn();	
		}
		
		player.newTurn();
		assertEquals(player.populationQuota(), 200);		
	}	
}
