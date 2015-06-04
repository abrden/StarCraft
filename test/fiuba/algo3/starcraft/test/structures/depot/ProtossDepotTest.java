package fiuba.algo3.starcraft.test.structures.depot;

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
		Player player = new Player(null, null, ProtossBuilder.getInstance(), initialResources);
		
		player.newStructureWithName("Pilon");
		/* Pilon tarda 5 turnos en hacerse, al sexto estara listo para utilizar */
		for(int i = 0; i < 6; i++) player.newTurn();
		
		assertEquals(player.populationQuota(), 5);
	}

	@Test
	public void testPopulationQuotais10With2Pilon() throws InsufficientResources, MissingStructureRequired, TemplateNotFound {
		Resources initialResources = new Resources(200,0);
		Player player = new Player(null, null, ProtossBuilder.getInstance(), initialResources);
		
		player.newStructureWithName("Pilon");
		player.newStructureWithName("Pilon");
		for(int i = 0; i < 6; i++) player.newTurn();
		
		assertEquals(player.populationQuota(), 10);
	}
	
	@Test
	public void testPopulationQuotais10With2PilonIndependentlyOfTurns() throws InsufficientResources, MissingStructureRequired, TemplateNotFound {
		Resources initialResources = new Resources(200,0);
		Player player = new Player(null, null, ProtossBuilder.getInstance(), initialResources);
		
		player.newStructureWithName("Pilon");
		player.newStructureWithName("Pilon");
		for(int i = 0; i < 6; i++) player.newTurn();
		
		for(int i = 0; i < 46; i++) player.newTurn();
		
		assertEquals(player.populationQuota(), 10);		
	}

	@Test
	public void testPopulationQuotais10With2PilonsAnd5IfOneIsDestroyed() throws InsufficientResources, MissingStructureRequired, TemplateNotFound {
		Resources initialResources = new Resources(200,0);
		Player player = new Player(null, null, ProtossBuilder.getInstance(), initialResources);
		
		player.newStructureWithName("Pilon");
		for(int i = 0; i < 6; i++) player.newTurn();
		assertEquals(player.populationQuota(), 5);	
		
		/* Creo un pilon afuera para mantener su referencia */
		PilonTemplate templatePilon = PilonTemplate.getInstance();
		Depot pilon = templatePilon.create();
		player.pays(100,0);
		player.receiveNewStructure(pilon);
		player.newTurn();
		assertEquals(player.populationQuota(), 10);
		
		pilon.reduceLife(600);
		player.newTurn();
		assertEquals(player.populationQuota(), 5);		
	}
	
}
