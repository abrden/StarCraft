package fiuba.algo3.starcraft.logic.test.player;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.starcraft.logic.map.Map;
import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.map.exceptions.NoResourcesToExtract;
import fiuba.algo3.starcraft.logic.player.Player;
import fiuba.algo3.starcraft.logic.player.Resources;
import fiuba.algo3.starcraft.logic.structures.builders.ProtossBuilder;
import fiuba.algo3.starcraft.logic.structures.builders.TerranBuilder;
import fiuba.algo3.starcraft.logic.structures.exceptions.InsufficientResources;
import fiuba.algo3.starcraft.logic.structures.exceptions.MissingStructureRequired;
import fiuba.algo3.starcraft.logic.structures.exceptions.TemplateNotFound;

public class PlayerTest {
	Map map;
	Point position;
	@Before
	public void before() {
		map = new Map(1000);
		position = new Point(54,70);
	}
	
	@Test
	public void testPlayerStartsWithPopulation0() {
<<<<<<< HEAD
		Player player = new Player(null, null, null, null, null, null);
=======
		Player player = new Player(null, null, null, null, null, map);
>>>>>>> 824aaf7355d45cd0f5838133b0fed5b3b78765f8
		
		assertEquals(player.currentPopulation(), 0);
	}
	
	@Test
	public void testPlayerStartsWithPopulationSpace0() {
<<<<<<< HEAD
		Player player = new Player(null, null, null, null, null, null);
=======
		Player player = new Player(null, null, null, null, null, map);
>>>>>>> 824aaf7355d45cd0f5838133b0fed5b3b78765f8
		
		assertEquals(player.populationSpace(), 0);
	}
	
	@Test
	public void testPlayerStartsWithPopulationQuota0() {
<<<<<<< HEAD
		Player player = new Player(null, null, null, null, null, null);
=======
		Player player = new Player(null, null, null, null, null, map);
>>>>>>> 824aaf7355d45cd0f5838133b0fed5b3b78765f8
		
		assertEquals(player.populationQuota(), 0);
	}
		
	@Test
	public void testPlayerGains200MAnd100MLeavesPlayerWithThoseResources() {
<<<<<<< HEAD
		Player player = new Player(null, null, null, null, new Resources(0,0), null);
=======
		Player player = new Player(null, null, null, null, new Resources(0,0), map);
>>>>>>> 824aaf7355d45cd0f5838133b0fed5b3b78765f8
		
		player.gains(200, 100);
		
		assertEquals(player.getMineral(), 200);
		assertEquals(player.getGas(), 100);
	}
	
	@Test
<<<<<<< HEAD
	public void testTerranPlayerPopulationQuotaIncreasesTo5IfHeBuilds1Deposito() throws MissingStructureRequired, InsufficientResources, TemplateNotFound {
		Player player = new Player(null, null, new TerranBuilder(), null, new Resources(100,0), null);

		player.newStructureWithName("Deposito Suministro", null);
=======
	public void testTerranPlayerPopulationQuotaIncreasesTo5IfHeBuilds1Deposito() throws MissingStructureRequired, InsufficientResources, TemplateNotFound, NoResourcesToExtract {
		Player player = new Player(null, null, new TerranBuilder(), null, new Resources(100,0), map);
		
		player.newStructureWithName("Deposito Suministro", position);
>>>>>>> 824aaf7355d45cd0f5838133b0fed5b3b78765f8
		for(int i = 0; i < 7; i++)  player.newTurn();
		
		assertEquals(player.populationQuota(), 5);
	}
	
	@Test
<<<<<<< HEAD
	public void testProtossPlayerPopulationQuotaIncreasesTo5IfHeBuilds1Pilon() throws MissingStructureRequired, InsufficientResources, TemplateNotFound {
<<<<<<< HEAD
		Player player = new Player(null, null, ProtossBuilder.getInstance(), null, new Resources(100,0), null);
=======
		Player player = new Player(null, null, new ProtossBuilder(), null, new Resources(100,0));
>>>>>>> 60e498f1e7e1aa5a87dcdeb177fa693c0e02424f
=======
	public void testProtossPlayerPopulationQuotaIncreasesTo5IfHeBuilds1Pilon() throws MissingStructureRequired, InsufficientResources, TemplateNotFound, NoResourcesToExtract {
		Player player = new Player(null, null, new ProtossBuilder(), null, new Resources(100,0), map);
>>>>>>> 824aaf7355d45cd0f5838133b0fed5b3b78765f8
		
		player.newStructureWithName("Pilon", position);
		for(int i = 0; i < 6; i++)  player.newTurn();
		
		assertEquals(player.populationQuota(), 5);
	}
	
}
