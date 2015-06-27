package fiuba.algo3.starcraft.integration.units;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.starcraft.game.StarCraft;
import fiuba.algo3.starcraft.logic.map.Map;
import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.map.exceptions.NoResourcesToExtract;
import fiuba.algo3.starcraft.logic.map.resources.ReservoirType;
import fiuba.algo3.starcraft.logic.player.Player;
import fiuba.algo3.starcraft.logic.player.Resources;
import fiuba.algo3.starcraft.logic.structures.ConstructionStructure;
import fiuba.algo3.starcraft.logic.structures.builders.ProtossBuilder;
import fiuba.algo3.starcraft.logic.structures.builders.TerranBuilder;
import fiuba.algo3.starcraft.logic.structures.exceptions.InsufficientResources;
import fiuba.algo3.starcraft.logic.structures.exceptions.MissingStructureRequired;
import fiuba.algo3.starcraft.logic.structures.exceptions.QuotaExceeded;
import fiuba.algo3.starcraft.logic.structures.exceptions.TemplateNotFound;
import fiuba.algo3.starcraft.logic.units.Unit;

public class UnitCreationTest {

	Map map;
	Player player1;
	Player player2;
	Resources initialResources1;
	Resources initialResources2;
	Point base1;
	Point base2;
	
	Point position;
	Point position2;
	Point position3;
	Point position4;
	Point position5;
	Point position6;
	@Before
	public void before() {
		map = new Map(1000, null);
		initialResources1 = new Resources(200, 0);
		initialResources2 = new Resources(200, 0);
		base1 = new Point(200,200);
		base2 = new Point(800,800);
		player1 = new Player(null, null, new TerranBuilder(), base1, initialResources1, map);
		player2 = new Player(null, null, new ProtossBuilder(), base2, initialResources2, map);
		
		position = new Point(1,1);
		position2 = new Point (270,340);
		position3 = new Point (70,34);
		position4 = new Point (70,80);
		position5 = new Point (500,80);
		position6 = new Point (40,560);
	}
	
	@Test
	public void testMarineCreationWithBarraca() throws InsufficientResources, QuotaExceeded, TemplateNotFound, MissingStructureRequired, NoResourcesToExtract {
		player1.gains(10000,10000);
		player1.newStructureWithName("Deposito Suministro", position);
		for(int i = 0; i < 7; i++) {
			player2.newTurn();
			player1.newTurn();
		}
		player1.newStructureWithName("Barraca", position3);
		for(int i = 0; i < 13; i++) {
			player2.newTurn();
			player1.newTurn();
		}
		ConstructionStructure barraca = (ConstructionStructure) map.getParcelContainingPoint(position3).getStructure();
		
		player1.newUnitWithName("Marine", barraca);
		for(int i = 0; i < 13; i++) {
			player2.newTurn();
			player1.newTurn();
		}
		
		assertEquals(((LinkedList<Unit>) player1.getUnits()).peekFirst().getName(), "Marine");
	}
	
	@Test
	public void testNaveCienciaCreationWithPuerto() throws InsufficientResources, QuotaExceeded, TemplateNotFound, MissingStructureRequired, NoResourcesToExtract {
		player1.gains(10000,10000);
		player1.newStructureWithName("Deposito Suministro", position4);
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
		ConstructionStructure puerto = (ConstructionStructure) map.getParcelContainingPoint(position).getStructure();
		
		player1.newUnitWithName("Nave Ciencia", puerto);
		for(int i = 0; i < 11; i++) {
			player2.newTurn();
			player1.newTurn();
		}
		
		assertEquals(((LinkedList<Unit>) player1.getUnits()).peekFirst().getName(), "Nave Ciencia");
	}

	@Test(expected = QuotaExceeded.class)
	public void testCreationWithoutSpaceInPopulationThrowsException() throws InsufficientResources, QuotaExceeded, TemplateNotFound, MissingStructureRequired, NoResourcesToExtract {
		player1.newStructureWithName("Barraca", position3);
		for(int i = 0; i < 13; i++) {
			player2.newTurn();
			player1.newTurn();
		}
		ConstructionStructure barraca = (ConstructionStructure) map.getParcelContainingPoint(position3).getStructure();
		
		player1.newUnitWithName("Marine", barraca);
		assertTrue(false);
	}
	
	@Test(expected = InsufficientResources.class)
	public void testCreationWithoutResourcesThrowsException() throws InsufficientResources, QuotaExceeded, TemplateNotFound, MissingStructureRequired, NoResourcesToExtract {
		player1.gains(100,0);
		player1.newStructureWithName("Deposito Suministro", position4);
		player1.newStructureWithName("Barraca", position3);
		for(int i = 0; i < 13; i++) {
			player2.newTurn();
			player1.newTurn();
		}
		ConstructionStructure barraca = (ConstructionStructure) map.getParcelContainingPoint(position3).getStructure();
		
		player1.newUnitWithName("Marine", barraca);
		player1.newUnitWithName("Marine", barraca);
		assertTrue(false);
	}
	
	@Test
	public void testNaveCreationWithPuerto() throws InsufficientResources, QuotaExceeded, TemplateNotFound, MissingStructureRequired, NoResourcesToExtract {
		player2.gains(10000,10000);
		player2.newStructureWithName("Pilon", position4);
		player2.newStructureWithName("Acceso", position3);
		for(int i = 0; i < 13; i++) {
			player1.newTurn();
			player2.newTurn();
		}
		player2.newStructureWithName("Puerto Estelar", position);
		for(int i = 0; i < 11; i++) {
			player1.newTurn();
			player2.newTurn();
		}
		ConstructionStructure puerto = (ConstructionStructure) map.getParcelContainingPoint(position).getStructure();
		
		player2.newUnitWithName("Nave Transporte", puerto);
		for(int i = 0; i < 11; i++) {
			player1.newTurn();
			player2.newTurn();
		}
		
		assertEquals(((LinkedList<Unit>) player2.getUnits()).peekFirst().getName(), "Nave Transporte");
	}
	
	@Test
	public void testAltoTemplarioCreationWithCollectedResources() throws InsufficientResources, QuotaExceeded, TemplateNotFound, MissingStructureRequired, NoResourcesToExtract {
		map.getParcelContainingPoint(position).setReservoir(ReservoirType.mine);
		map.getParcelContainingPoint(position2).setReservoir(ReservoirType.volcano);
		player2.newStructureWithName("Asimilador", position2);
		player2.newStructureWithName("Nexo Mineral", position);
		for(int i = 0; i < 7; i++) {
			player1.newTurn();
			player2.newTurn();
		}
		
		//Recolecta recursos
		for(int i = 0; i < 3; i++) {
			player1.newTurn();
			player2.newTurn();
		}
		
		player2.newStructureWithName("Pilon", position3);
		for(int i = 0; i < 6; i++) {
			player1.newTurn();
			player2.newTurn();
		}
		
		//Recolecta recursos
		for(int i = 0; i < 15; i++) {
			player1.newTurn();
			player2.newTurn();
		}
				
		player2.newStructureWithName("Acceso", position4);
		for(int i = 0; i < 9; i++) {
			player1.newTurn();
			player2.newTurn();
		}
		player2.newStructureWithName("Puerto Estelar", position5);
		for(int i = 0; i < 11; i++) {
			player1.newTurn();
			player2.newTurn();
		}
		
		//Recolecta recursos
		for(int i = 0; i < 3; i++) {
			player1.newTurn();
			player2.newTurn();
		}
		
		player2.newStructureWithName("Archivos Templarios", position6);
		for(int i = 0; i < 10; i++) {
			player1.newTurn();
			player2.newTurn();
		}
		
		ConstructionStructure archivos = (ConstructionStructure) map.getParcelContainingPoint(position6).getStructure();
		player2.newUnitWithName("Alto Templario", archivos);
		for(int i = 0; i < 11; i++) {
			player1.newTurn();
			player2.newTurn();
		}
		
		assertEquals(((LinkedList<Unit>) player2.getUnits()).peekFirst().getName(), "Alto Templario");
	}
}
