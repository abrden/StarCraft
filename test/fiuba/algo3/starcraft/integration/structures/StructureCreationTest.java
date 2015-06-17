package fiuba.algo3.starcraft.integration.structures;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.starcraft.game.StarCraft;
import fiuba.algo3.starcraft.logic.map.Map;
import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.map.exceptions.NoResourcesToExtract;
import fiuba.algo3.starcraft.logic.map.resources.ReservoirType;
import fiuba.algo3.starcraft.logic.player.Player;
import fiuba.algo3.starcraft.logic.player.Resources;
import fiuba.algo3.starcraft.logic.structures.builders.ProtossBuilder;
import fiuba.algo3.starcraft.logic.structures.builders.TerranBuilder;
import fiuba.algo3.starcraft.logic.structures.exceptions.InsufficientResources;
import fiuba.algo3.starcraft.logic.structures.exceptions.MissingStructureRequired;
import fiuba.algo3.starcraft.logic.structures.exceptions.TemplateNotFound;

public class StructureCreationTest {

	StarCraft game;
	Map map;
	Player player1;
	Player player2;
	Resources initialResources1;
	Resources initialResources2;
	
	Point position;
	Point position2;
	Point position3;
	@Before
	public void before() {
		game = new StarCraft();
		map = new Map(1000, game);
		initialResources1 = new Resources(200, 0);
		initialResources2 = new Resources(200, 0);
		player1 = new Player(null, null, new TerranBuilder(), null, initialResources1, map);
		player2 = new Player(null, null, new ProtossBuilder(), null, initialResources2, map);
		game.setGame(player1, player2, map);
		
		position = new Point(1,1);
		position2 = new Point (270,340);
		position3 = new Point (70,34);
	}
	
	@Test
	public void testCreatingNewStructureSetsItInParcelContainingPoint() throws MissingStructureRequired, InsufficientResources, TemplateNotFound, NoResourcesToExtract {
		player1.newStructureWithName("Deposito Suministro", position);
		for(int i = 0; i < 7; i++) {
			player2.newTurn();
			player1.newTurn();
		}

		assertEquals(map.getParcelContainingPoint(position).getStructure().getName(), "Deposito Suministro");
	}
	
	@Test(expected = NoResourcesToExtract.class)
	public void testCreatingMineralExploiterInLandWithNoMineralThrowsException() throws MissingStructureRequired, InsufficientResources, TemplateNotFound, NoResourcesToExtract {
		player1.newStructureWithName("Centro Mineral", position);
	}

	@Test(expected = NoResourcesToExtract.class)
	public void testCreatingGasExploiterInLandWithNoVolcanoThrowsException() throws MissingStructureRequired, InsufficientResources, TemplateNotFound, NoResourcesToExtract {
		player2.newStructureWithName("Asimilador", position);
	}

	@Test
	public void testCreatingGasExploiterInLandWithVolcano() throws MissingStructureRequired, InsufficientResources, TemplateNotFound, NoResourcesToExtract {
		map.getParcelContainingPoint(position).setSurface(ReservoirType.volcano);
		player1.newStructureWithName("Refineria", position);
		for(int i = 0; i < 7; i++) {
			player2.newTurn();
			player1.newTurn();
		}

		assertEquals(map.getParcelContainingPoint(position).getStructure().getName(), "Refineria");
	}
	
	@Test
	public void testCreatingMineralExploiterInLandWithMine() throws MissingStructureRequired, InsufficientResources, TemplateNotFound, NoResourcesToExtract {
		map.getParcelContainingPoint(position).setSurface(ReservoirType.mine);
		player2.newStructureWithName("Nexo Mineral", position);
		for(int i = 0; i < 5; i++) {
			player1.newTurn();
			player2.newTurn();
		}

		assertEquals(map.getParcelContainingPoint(position).getStructure().getName(), "Nexo Mineral");
	}
	
	@Test
	public void testItsPossibleToCreateNonExploiterStructureInLandWithReservoir() throws MissingStructureRequired, InsufficientResources, TemplateNotFound, NoResourcesToExtract {
		map.getParcelContainingPoint(position).setSurface(ReservoirType.mine);
		player2.newStructureWithName("Pilon", position);
		for(int i = 0; i < 7; i++) {
			player1.newTurn();
			player2.newTurn();
		}

		assertEquals(map.getParcelContainingPoint(position).getStructure().getName(), "Pilon");
	}
	
	@Test
	public void testCreatingNewConstructionStructureSetsItInParcelContainingPoint() throws MissingStructureRequired, InsufficientResources, TemplateNotFound, NoResourcesToExtract {
		player2.gains(1000,1000);
		player2.newStructureWithName("Acceso", position2);
		for(int i = 0; i < 9; i++) {
			player1.newTurn();
			player2.newTurn();
		}
		player2.newStructureWithName("Puerto Estelar", position);
		for(int i = 0; i < 12; i++) {
			player1.newTurn();
			player2.newTurn();
		}

		assertEquals(map.getParcelContainingPoint(position).getStructure().getName(), "Puerto Estelar");
	}
	
	@Test
	public void testCreatingPuertoEstelarHavingPreviousConstructionsSetsItInParcelContainingPoint() throws MissingStructureRequired, InsufficientResources, TemplateNotFound, NoResourcesToExtract {
		player1.gains(1000,1000);
		player1.newStructureWithName("Barraca", position3);
		for(int i = 0; i < 13; i++) {
			player2.newTurn();
			player1.newTurn();
		}
		player1.newStructureWithName("Fabrica", position2);
		for(int i = 0; i < 13; i++) {
			player2.newTurn();
			player1.newTurn();
		}
		
		player1.newStructureWithName("Puerto Estelar", position);
		for(int i = 0; i < 11; i++) {
			player2.newTurn();
			player1.newTurn();
		}

		assertEquals(map.getParcelContainingPoint(position).getStructure().getName(), "Puerto Estelar");
	}
	
	@Test(expected = MissingStructureRequired.class)
	public void testCreatingPuertoEstelarWithoutPreviousConstructionsThrowsException() throws MissingStructureRequired, InsufficientResources, TemplateNotFound, NoResourcesToExtract {
		player1.gains(1000,1000);
		player1.newStructureWithName("Barraca", position3);
		for(int i = 0; i < 13; i++) {
			player2.newTurn();
			player1.newTurn();
		}
		
		player1.newStructureWithName("Puerto Estelar", position);
		assertTrue(false);
	}

	@Test
	public void testMineralExploiterAndGasExploiterProduceEnoughResourcesToBuildStructure() throws MissingStructureRequired, InsufficientResources, TemplateNotFound, NoResourcesToExtract {
		map.getParcelContainingPoint(position3).setSurface(ReservoirType.mine);
		player2.newStructureWithName("Nexo Mineral", position3);
		for(int i = 0; i < 5; i++) {
			player1.newTurn();
			player2.newTurn();
		}
		
		//Necesita 100M
		for(int i = 0; i < 5; i++) {
			player1.newTurn();
			player2.newTurn();
		}
		
		player2.newStructureWithName("Acceso", position);
		for(int i = 0; i < 9; i++) {
			player1.newTurn();
			player2.newTurn();
		}
		
		assertEquals(map.getParcelContainingPoint(position).getStructure().getName(), "Acceso");
	}
	
	@Test(expected = InsufficientResources.class)
	public void testCreatingStructureWithoutResourcesThrowsException() throws MissingStructureRequired, InsufficientResources, TemplateNotFound, NoResourcesToExtract {
		map.getParcelContainingPoint(position3).setSurface(ReservoirType.volcano);
		player2.newStructureWithName("Asimilador", position3);
		
		player2.newStructureWithName("Acceso", position);
		assertTrue(false);
	}
}
