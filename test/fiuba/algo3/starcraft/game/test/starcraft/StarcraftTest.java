package fiuba.algo3.starcraft.game.test.starcraft;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.starcraft.game.StarCraft;
import fiuba.algo3.starcraft.logic.map.LandType;
import fiuba.algo3.starcraft.logic.map.Map;
import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.map.ScenarioGenerator;
import fiuba.algo3.starcraft.logic.templates.units.terran.MarineTemplate;
import fiuba.algo3.starcraft.logic.units.MuggleUnit;
import fiuba.algo3.starcraft.logic.units.exceptions.StepsLimitExceeded;

public class StarcraftTest {
		
	StarCraft game = new StarCraft();
	
	@Test
	public void testStarCraftMovesAMarineInAMapFullOfLand() throws StepsLimitExceeded {
		Map currentMap = new Map(1000);
		game.setMap(currentMap);
		
		MuggleUnit marine = new MarineTemplate().create(new Point(20, 20));
		
		game.moveUnitToDestination(marine, new Point(500,32));
				
		assertTrue(marine.getPosition().getX() > 499 && marine.getPosition().getY() > 31);
	}
	
	@Test
	public void testStarcraftMovesAMarineInAMapWithGapsAndStopsMovingAfterGap() throws StepsLimitExceeded {
		Map currentMap = new Map(1000);
		ScenarioGenerator scenario = new ScenarioGenerator(currentMap);
		
		scenario.assignSurfaceDistributionInRect(LandType.air,new Point(50, 50),100, 1);
		game.setMap(currentMap);

		MuggleUnit marine = new MarineTemplate().create(new Point(75, 0));
		
		game.moveUnitToDestination(marine, new Point(75,500));
				
		assertTrue(marine.getPosition().getY() < 50);
	}

}
