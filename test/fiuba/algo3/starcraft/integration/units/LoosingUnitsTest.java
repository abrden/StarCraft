package fiuba.algo3.starcraft.integration.units;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.starcraft.logic.map.Map;
import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.map.exceptions.NoResourcesToExtract;
import fiuba.algo3.starcraft.logic.player.Player;
import fiuba.algo3.starcraft.logic.player.Resources;
import fiuba.algo3.starcraft.logic.structures.builders.ProtossBuilder;
import fiuba.algo3.starcraft.logic.structures.exceptions.InsufficientResources;
import fiuba.algo3.starcraft.logic.structures.exceptions.MissingStructureRequired;
import fiuba.algo3.starcraft.logic.structures.exceptions.TemplateNotFound;
import fiuba.algo3.starcraft.logic.templates.units.protoss.DragonTemplate;
import fiuba.algo3.starcraft.logic.units.MuggleUnit;

public class LoosingUnitsTest {

	Map map;
	Player player;
	Point position;
	MuggleUnit dragon;
	MuggleUnit zealot;
	@Before
	public void before() {
		position = new Point(23,54);
		map = new Map(1000);
		dragon = (new DragonTemplate()).create(position);
		zealot = (new DragonTemplate()).create(position);
		player = new Player(null, null, new ProtossBuilder(), null, new Resources(200,0), map);
	}
	
	@Test
	public void testLoosingSoleUnitDecreasesPopulationTo0() throws MissingStructureRequired, InsufficientResources, TemplateNotFound, NoResourcesToExtract {
		player.newStructureWithName("Pilon", position);
		for (int i = 0; i < 6; i++) player.newTurn();
		assertEquals(player.populationQuota(), 5);
		assertEquals(player.currentPopulation(), 0);
		assertEquals(player.populationSpace(), 5);
		player.receiveNewUnit(dragon);
		assertEquals(player.populationQuota(), 5);
		assertEquals(player.currentPopulation(), 2);
		assertEquals(player.populationSpace(), 3);
		
		dragon.reduceLife(1000000);
		player.newTurn();
		
		assertEquals(player.populationQuota(), 5);
		assertEquals(player.currentPopulation(), 0);
		assertEquals(player.populationSpace(), 5);
	}
	
	@Test
	public void testLoosingUnitDecreasesPopulation() throws MissingStructureRequired, InsufficientResources, TemplateNotFound, NoResourcesToExtract {
		player.newStructureWithName("Pilon", position);
		for (int i = 0; i < 6; i++) player.newTurn();
		assertEquals(player.populationQuota(), 5);
		assertEquals(player.currentPopulation(), 0);
		assertEquals(player.populationSpace(), 5);
		player.receiveNewUnit(dragon);
		player.receiveNewUnit(zealot);
		assertEquals(player.populationQuota(), 5);
		assertEquals(player.currentPopulation(), 4);
		assertEquals(player.populationSpace(), 1);
		
		zealot.reduceLife(1000000);
		player.newTurn();
		
		assertEquals(player.populationQuota(), 5);
		assertEquals(player.currentPopulation(), 2);
		assertEquals(player.populationSpace(), 3);
	}

}
