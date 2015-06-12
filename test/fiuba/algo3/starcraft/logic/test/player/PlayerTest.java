package fiuba.algo3.starcraft.logic.test.player;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.starcraft.logic.player.Player;
import fiuba.algo3.starcraft.logic.player.Resources;
import fiuba.algo3.starcraft.logic.structures.builders.ProtossBuilder;
import fiuba.algo3.starcraft.logic.structures.builders.TerranBuilder;
import fiuba.algo3.starcraft.logic.structures.exceptions.InsufficientResources;
import fiuba.algo3.starcraft.logic.structures.exceptions.MissingStructureRequired;
import fiuba.algo3.starcraft.logic.structures.exceptions.TemplateNotFound;

public class PlayerTest {

	@Test
	public void testPlayerStartsWithPopulation0() {
		Player player = new Player(null, null, null, null, null);
		
		assertEquals(player.currentPopulation(), 0);
	}
	
	@Test
	public void testPlayerStartsWithPopulationSpace0() {
		Player player = new Player(null, null, null, null, null);
		
		assertEquals(player.populationSpace(), 0);
	}
	
	@Test
	public void testPlayerStartsWithPopulationQuota0() {
		Player player = new Player(null, null, null, null, null);
		
		assertEquals(player.populationQuota(), 0);
	}
		
	@Test
	public void testPlayerGains200MAnd100MLeavesPlayerWithThoseResources() {
		Player player = new Player(null, null, null, null, new Resources(0,0));
		
		player.gains(200, 100);
		
		assertEquals(player.getMineral(), 200);
		assertEquals(player.getGas(), 100);
	}
	
	@Test
	public void testTerranPlayerPopulationQuotaIncreasesTo5IfHeBuilds1Deposito() throws MissingStructureRequired, InsufficientResources, TemplateNotFound {
		Player player = new Player(null, null, new TerranBuilder(), null, new Resources(100,0));
		
		player.newStructureWithName("Deposito Suministro", null);
		for(int i = 0; i < 7; i++)  player.newTurn();
		
		assertEquals(player.populationQuota(), 5);
	}
	
	@Test
	public void testProtossPlayerPopulationQuotaIncreasesTo5IfHeBuilds1Pilon() throws MissingStructureRequired, InsufficientResources, TemplateNotFound {
		Player player = new Player(null, null, new ProtossBuilder(), null, new Resources(100,0));
		
		player.newStructureWithName("Pilon", null);
		for(int i = 0; i < 6; i++)  player.newTurn();
		
		assertEquals(player.populationQuota(), 5);
	}
	
}
