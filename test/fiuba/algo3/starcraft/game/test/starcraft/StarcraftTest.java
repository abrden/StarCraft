package fiuba.algo3.starcraft.game.test.starcraft;

import static org.junit.Assert.*;

import fiuba.algo3.starcraft.game.PlayerSetup;
import fiuba.algo3.starcraft.logic.player.Player;
import fiuba.algo3.starcraft.view.exceptions.NameIsTooShort;
import org.junit.Test;

import fiuba.algo3.starcraft.game.StarCraft;
import fiuba.algo3.starcraft.logic.map.Map;
import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.map.ScenarioGenerator;
import fiuba.algo3.starcraft.logic.templates.units.terran.MarineTemplate;
import fiuba.algo3.starcraft.logic.units.MuggleUnit;
import fiuba.algo3.starcraft.logic.units.exceptions.StepsLimitExceeded;

import java.util.ArrayList;
import java.util.List;

public class StarcraftTest {
		
	StarCraft game;
	PlayerSetup player_1, player_2;
	Player player1, player2;
	@Test
	public void testStarcraftMovesAMarineInAMapWithGapsAndStopsMovingAfterGap() throws StepsLimitExceeded, NameIsTooShort {
		player_1 = new PlayerSetup("Roberto", "Blue", "Terran");
		player_2 = new PlayerSetup("Carlos", "Red", "Protoss");
		List<PlayerSetup> list = new ArrayList<PlayerSetup>();
		list.add(player_1);
		list.add(player_2);
		game = new StarCraft(list);
		game.start();
		player1 = game.getActivePlayer();
		game.nextTurn();
		assertTrue(0 == player1.numberOfUnits());
	}
}
