package fiuba.algo3.starcraft.logic.test.structures;

import fiuba.algo3.starcraft.logic.map.Map;
import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.player.Player;
import fiuba.algo3.starcraft.logic.player.Resources;
import fiuba.algo3.starcraft.logic.structures.Construction;
import fiuba.algo3.starcraft.logic.structures.ConstructionQueue;
import fiuba.algo3.starcraft.logic.structures.Depot;
import fiuba.algo3.starcraft.logic.structures.Structure;
import fiuba.algo3.starcraft.logic.structures.builders.TerranBuilder;
import fiuba.algo3.starcraft.logic.templates.qualities.Life;
import fiuba.algo3.starcraft.logic.units.MuggleUnit;
import fiuba.algo3.starcraft.logic.units.Unit;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConstructionQueueTest {

	ConstructionQueue queue;
	Depot depot;
	MuggleUnit marine, golliat;

	Player player;

	//Todos los test son muy turbios, pero es la unica forma de "probar" que funciona

	@Before
	public void before() {
		queue = new ConstructionQueue();
		depot  = new Depot("Deposito Suministro",new Life(500),new Point(1,0));
		marine = new MuggleUnit("Marine", null, new Point(5,0), 0, 0, null, 0, false, 1);
		golliat = new MuggleUnit("Golliat", null, new Point(4,0), 0, 0, null, 0, false, 2);
		player = new Player("Pepe", null, new TerranBuilder(), new Point(0,0), new Resources(500,500),new Map(1000,null));
	}

	@Test
	public void testConstructionQueueUpdateGivesStructureWhenFinished() {

		queue.addStructure(new Construction<Structure>(depot, 6, null));

		for (int i = 0; i < 7; i++) {
			queue.update(player);
		}

		assertEquals(player.populationQuota(), 5);
	}

	@Test
	public void testConstructionQueueUpdateGivesUnitWhenFinished() {
		queue.addUnit(new Construction<Unit>(marine, 3, null));

		for (int i = 0; i < 4; i++) {
			queue.update(player);
		}

		assertEquals(player.currentPopulation(),1);
	}

	@Test
	public void testConstructionQueueWontGiveUnitUntilFinished() {
		queue.addUnit(new Construction<Unit>(marine, 3, null));

		queue.update(player);

		assertEquals(player.currentPopulation(),0);
	}

	@Test
	public void testConstructionQueueWontGiveStructureUntilFinished() {
		queue.addStructure(new Construction<Structure>(depot, 6, null));

		queue.update(player);

		assertEquals(player.populationQuota(),0);
	}

	@Test
	public void testConstructionQueueCanGiveMultipleStructuresInOneTurn() {
		for (int i = 0; i < 10; i++) {
			queue.addStructure(new Construction<Structure>(depot, 6, null));
		}

		for (int i = 0; i < 7; i++) {
			queue.update(player);
		}

		assertEquals(player.populationQuota(),50);
	}

	@Test
	public void testConstructionQueueCanGiveMultipleUnitsInOneTurn() {
		for (int i = 0; i < 10; i++) {
			queue.addUnit(new Construction<Unit>(marine, 3, null));
		}

		for (int i = 0; i < 4; i++) {
			queue.update(player);
		}

		assertEquals(player.currentPopulation(),10);
	}

	@Test
	public void testConstructionQueueCanGiveUnitsAndStructuresOnTheSameTurn() {
		queue.addUnit(new Construction<Unit>(golliat, 6, null));
		queue.addStructure(new Construction<Structure>(depot, 6, null));

		for (int i = 0; i < 7; i++) {
			queue.update(player);
		}

		assertEquals(player.populationQuota(),5);
		assertEquals(player.currentPopulation(),2);
	}
}
