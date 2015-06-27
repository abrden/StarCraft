package fiuba.algo3.starcraft.game.test.starcraft;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.starcraft.game.StarCraft;
import fiuba.algo3.starcraft.logic.map.Map;
import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.map.ScenarioGenerator;
import fiuba.algo3.starcraft.logic.templates.units.terran.MarineTemplate;
import fiuba.algo3.starcraft.logic.units.MuggleUnit;
import fiuba.algo3.starcraft.logic.units.exceptions.StepsLimitExceeded;

public class StarcraftTest {
		
	//StarCraft game = new StarCraft();
	
	@Test
	public void testStarcraftMovesAMarineInAMapWithGapsAndStopsMovingAfterGap() throws StepsLimitExceeded {
		/*Map currentMap = new Map(1000, game);
		ScenarioGenerator scenario = new ScenarioGenerator(currentMap);
		
		scenario.assignAirDistributionInRect(new Point(50, 50),100,1);
		game.setGame(null, null, currentMap);

		MuggleUnit marine = new MarineTemplate().create(new Point(75, 0));
		
		currentMap.moveUnitToDestination(marine, new Point(75,500));
				
		assertTrue(marine.getPosition().getY() < 50);*/
	}

}
