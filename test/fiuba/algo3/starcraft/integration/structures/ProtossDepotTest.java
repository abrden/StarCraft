package fiuba.algo3.starcraft.integration.structures;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.starcraft.logic.map.Map;
import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.map.exceptions.NoResourcesToExtract;
import fiuba.algo3.starcraft.logic.map.exceptions.StructureCannotBeSetHere;
import fiuba.algo3.starcraft.logic.player.Player;
import fiuba.algo3.starcraft.logic.player.Resources;
import fiuba.algo3.starcraft.logic.structures.Depot;
import fiuba.algo3.starcraft.logic.structures.builders.ProtossBuilder;
import fiuba.algo3.starcraft.logic.structures.exceptions.InsufficientResources;
import fiuba.algo3.starcraft.logic.structures.exceptions.MissingStructureRequired;
import fiuba.algo3.starcraft.logic.structures.exceptions.TemplateNotFound;
import fiuba.algo3.starcraft.logic.templates.structures.protoss.PilonTemplate;

public class ProtossDepotTest {
	Map map;
	Point position;
	Point position2;
	Resources initialResources;
	Player player;
	@Before
	public void before() {
		initialResources = new Resources(200,0);
		map = new Map(1000, null);
		position = new Point(54,70);
		position2 = new Point (270,340);
		player = new Player(null, null, new ProtossBuilder(), position, initialResources, map);
	}
	
	@Test
	public void testPopulationQuotais5With1Pilon() throws InsufficientResources, MissingStructureRequired, TemplateNotFound, NoResourcesToExtract, StructureCannotBeSetHere {
		player.newStructureWithName("Pilon", position);
		/* Pilon tarda 5 turnos en hacerse, al sexto estara listo para utilizar */
		for(int i = 0; i < 6; i++) player.newTurn();
		
		assertEquals(player.populationQuota(), 5);
	}

	@Test
	public void testPopulationQuotais10With2Pilon() throws InsufficientResources, MissingStructureRequired, TemplateNotFound, NoResourcesToExtract, StructureCannotBeSetHere {		
		player.newStructureWithName("Pilon", position);
		player.newStructureWithName("Pilon", position2);
		for(int i = 0; i < 6; i++) player.newTurn();
	
		assertEquals(player.populationQuota(), 10);
	}
	
	@Test
	public void testPopulationQuotais10With2PilonIndependentlyOfTurns() throws InsufficientResources, MissingStructureRequired, TemplateNotFound, NoResourcesToExtract, StructureCannotBeSetHere {
		player.newStructureWithName("Pilon", position);
		player.newStructureWithName("Pilon", position2);
		for(int i = 0; i < 6; i++) player.newTurn();
		
		for(int i = 0; i < 46; i++) player.newTurn();
		
		assertEquals(player.populationQuota(), 10);		
	}

	@Test
	public void testPopulationQuotais10With2PilonsAnd5IfOneIsDestroyed() throws InsufficientResources, MissingStructureRequired, TemplateNotFound, NoResourcesToExtract, StructureCannotBeSetHere {
		player.newStructureWithName("Pilon", position2);
		for(int i = 0; i < 6; i++) player.newTurn();
		assertEquals(player.populationQuota(), 5);	
		
		/* Creo un pilon afuera para mantener su referencia */
		PilonTemplate templatePilon = new PilonTemplate();
		Depot pilon = templatePilon.create(position);
		player.pays(100,0);
		player.receiveNewStructure(pilon);
		player.newTurn();
		assertEquals(player.populationQuota(), 10);
		
		pilon.reduceLife(600);
		player.newTurn();
		assertEquals(player.populationQuota(), 5);		
	}

}
