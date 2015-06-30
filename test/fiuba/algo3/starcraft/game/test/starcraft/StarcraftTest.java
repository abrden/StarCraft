package fiuba.algo3.starcraft.game.test.starcraft;

import static org.junit.Assert.*;
import fiuba.algo3.starcraft.game.GameOver;
import fiuba.algo3.starcraft.game.PlayerSetup;
import fiuba.algo3.starcraft.logic.map.exceptions.NoResourcesToExtract;
import fiuba.algo3.starcraft.logic.map.exceptions.StructureCannotBeSetHere;
import fiuba.algo3.starcraft.logic.map.exceptions.UnitCantGetToDestination;
import fiuba.algo3.starcraft.logic.map.resources.ReservoirType;
import fiuba.algo3.starcraft.logic.player.Player;
import fiuba.algo3.starcraft.logic.structures.exceptions.InsufficientResources;
import fiuba.algo3.starcraft.logic.structures.exceptions.MissingStructureRequired;
import fiuba.algo3.starcraft.logic.structures.exceptions.TemplateNotFound;
import fiuba.algo3.starcraft.view.exceptions.NameIsTooShort;

import org.junit.Before;
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
	Map map;

	@Before
	public void before() throws NameIsTooShort {
		player_1 = new PlayerSetup("Roberto", "Blue", "Terran");
		player_2 = new PlayerSetup("Carlos", "Red", "Protoss");
		List<PlayerSetup> list = new ArrayList<PlayerSetup>();
		list.add(player_1);
		list.add(player_2);
		game = new StarCraft(list);
		map = game.getMap();
	}

	@Test
	public void testStarcraftCreatesMinesAfterManyTurnsResourcesIncrease() throws StepsLimitExceeded, NameIsTooShort, NoResourcesToExtract, InsufficientResources, TemplateNotFound, MissingStructureRequired, GameOver, StructureCannotBeSetHere {
		game.start();
		player1 = game.getActivePlayer();
		map.getParcelContainingPoint(new Point(150, 0)).setReservoir(ReservoirType.mine);
		player1.newStructureWithName("Centro Mineral", new Point(150, 0));
		game.nextTurn();
		player2 = game.getActivePlayer();
		map.getParcelContainingPoint(new Point(850, 950)).setReservoir(ReservoirType.mine);
		player2.newStructureWithName("Nexo Mineral", new Point(850, 950));
		for (int i = 0; i < 10; i++) {
			game.nextTurn();
		}
		assertTrue(1 == player1.numberOfStructures());
		for (int i = 0; i < 100; i++) {
			game.nextTurn();
		}
		assertEquals(player1.getMineral(), player2.getMineral());
		/*player1 = game.getActivePlayer();
		System.out.println(player1.getName());
		System.out.println(map.getParcelContainingPoint(new Point(0,0)).getLandForExplotation());
		player1.newStructureWithName("Barraca", new Point(0,150));
		game.nextTurn();
		player2 = game.getActivePlayer();
		System.out.println(player2.getName());
		player2.newStructureWithName("Pilon", new Point(950,950));
		for (int i = 0; i < 10; i++) {
			game.nextTurn();
		}
		System.out.println(player1.numberOfStructures());
		System.out.println(player2.numberOfStructures());*/
	}
	
	@Test
	public void testStarCraftMovesAMarineInAMapWithGapsAndStopsMovingAfterGap() throws StepsLimitExceeded {

		ScenarioGenerator scenario = new ScenarioGenerator(map);
		
		scenario.assignAirDistributionInRect(new Point(50, 50),100,1);
		game.setGame(null, null, map);

		MuggleUnit marine = new MarineTemplate().create(new Point(75, 0));
		
		try {
			map.moveUnitToDestination(marine, new Point(75,500));
		} catch (UnitCantGetToDestination e) {}
				
		assertTrue(marine.getPosition().getY() < 50);
	}

	@Test(expected = UnitCantGetToDestination.class)
	public void testMarineMovingInAMapWithGapsThrowsException() throws StepsLimitExceeded, UnitCantGetToDestination {

		ScenarioGenerator scenario = new ScenarioGenerator(map);
		
		scenario.assignAirDistributionInRect(new Point(50, 50),100,1);
		game.setGame(null, null, map);

		MuggleUnit marine = new MarineTemplate().create(new Point(75, 0));

		map.moveUnitToDestination(marine, new Point(75,500));
	}
}
