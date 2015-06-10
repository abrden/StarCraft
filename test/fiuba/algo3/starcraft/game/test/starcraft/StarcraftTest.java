package fiuba.algo3.starcraft.game.test.starcraft;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.starcraft.game.StarCraft;
import fiuba.algo3.starcraft.logic.map.Map;
import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.templates.units.terran.MarineTemplate;
import fiuba.algo3.starcraft.logic.units.MuggleUnit;
import fiuba.algo3.starcraft.logic.units.exceptions.StepsLimitExceeded;

public class StarcraftTest {
		
	StarCraft game = StarCraft.getInstance();
	
	@Test
	public void testStarCraftMovesAMarineInAMapFullOfLand() throws StepsLimitExceeded {
		Map currentMap = new Map(1000);
		game.setMap(currentMap);
		
		MuggleUnit marine = MarineTemplate.getInstance().create(new Point(20,20));
		
		game.moveUnitToDestination(marine, new Point(500,32));
		
		System.out.println("x : " + marine.getPosition().getX() + " y :" + marine.getPosition().getY());
		
		assertTrue(marine.getPosition().getX() > 499 && marine.getPosition().getY() > 31);
		
	}

}
