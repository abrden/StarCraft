package fiuba.algo3.starcraft.integration.units;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.starcraft.logic.map.Map;
import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.map.exceptions.NoResourcesToExtract;
import fiuba.algo3.starcraft.logic.player.Player;
import fiuba.algo3.starcraft.logic.player.Resources;
import fiuba.algo3.starcraft.logic.structures.Construction;
import fiuba.algo3.starcraft.logic.structures.ConstructionStructure;
import fiuba.algo3.starcraft.logic.structures.builders.TerranBuilder;
import fiuba.algo3.starcraft.logic.structures.exceptions.ConstructionNotFinished;
import fiuba.algo3.starcraft.logic.structures.exceptions.InsufficientResources;
import fiuba.algo3.starcraft.logic.structures.exceptions.MissingStructureRequired;
import fiuba.algo3.starcraft.logic.structures.exceptions.QuotaExceeded;
import fiuba.algo3.starcraft.logic.structures.exceptions.TemplateNotFound;
import fiuba.algo3.starcraft.logic.templates.structures.terran.FabricaTemplate;
import fiuba.algo3.starcraft.logic.units.Unit;

public class GolliatTest {
	Map map;
	Point position;
	Point position2;
	Resources initialResources;
	Player player;
	@Before
	public void before() {
		initialResources = new Resources(750,250);
		map = new Map(1000);
		position = new Point(54,70);
		position2 = new Point(10,70);
		player = new Player(null, null, new TerranBuilder(), position, initialResources, map);
	}

	@Test
<<<<<<< HEAD:test/fiuba/algo3/starcraft/logic/test/player/integration/units/GolliatTest.java
	public void testGolliatCreationWith1DepositoSuministro1Barraca1FabricaAnd100M150G() throws InsufficientResources, QuotaExceeded, TemplateNotFound, MissingStructureRequired, ConstructionNotFinished {
		Resources initialResources = new Resources(550,150);
<<<<<<< HEAD
		Player player = new Player(null, null, TerranBuilder.getInstance(), null, initialResources, null);
=======
		Player player = new Player(null, null, new TerranBuilder(), null, initialResources);
>>>>>>> 60e498f1e7e1aa5a87dcdeb177fa693c0e02424f
		player.newStructureWithName("Deposito Suministro", null);
=======
	public void testGolliatCreationWith1DepositoSuministro1Barraca1FabricaAnd100M150G() throws InsufficientResources, QuotaExceeded, TemplateNotFound, MissingStructureRequired, ConstructionNotFinished, NoResourcesToExtract {
		player.newStructureWithName("Deposito Suministro", position);
>>>>>>> 824aaf7355d45cd0f5838133b0fed5b3b78765f8:test/fiuba/algo3/starcraft/integration/units/GolliatTest.java
		for(int i = 0; i < 7; i++) player.newTurn();
		player.newStructureWithName("Barraca", position);
		for(int i = 0; i < 13; i++) player.newTurn();
		
		player.pays(200, 100);
		ConstructionStructure fabrica = new FabricaTemplate().create(position);
		player.receiveNewStructure(fabrica);
		
		Construction<Unit> construction = fabrica.create("Golliat", position2, player.getResources(), player.currentPopulation(), player.populationQuota());
		while(!construction.itsFinished()) {
			construction.lowerRelease();
		}
		Unit golliat = construction.gather();
		player.receiveNewUnit(golliat);
		
		assertEquals(player.currentPopulation(), 2);
	}

	@Test(expected = QuotaExceeded.class)
<<<<<<< HEAD:test/fiuba/algo3/starcraft/logic/test/player/integration/units/GolliatTest.java
	public void testCantCreateAThirdGolliatWith1Depot() throws InsufficientResources, QuotaExceeded, TemplateNotFound, MissingStructureRequired, ConstructionNotFinished {
		Resources initialResources = new Resources(750,250);
<<<<<<< HEAD
		Player player = new Player(null, null, TerranBuilder.getInstance(), null, initialResources, null);
=======
		Player player = new Player(null, null, new TerranBuilder(), null, initialResources);
>>>>>>> 60e498f1e7e1aa5a87dcdeb177fa693c0e02424f
		player.newStructureWithName("Deposito Suministro", null);
=======
	public void testCantCreateAThirdGolliatWith1Depot() throws InsufficientResources, QuotaExceeded, TemplateNotFound, MissingStructureRequired, ConstructionNotFinished, NoResourcesToExtract {
		player.newStructureWithName("Deposito Suministro", position);
>>>>>>> 824aaf7355d45cd0f5838133b0fed5b3b78765f8:test/fiuba/algo3/starcraft/integration/units/GolliatTest.java
		for(int i = 0; i < 7; i++) player.newTurn();
		player.newStructureWithName("Barraca", position);
		for(int i = 0; i < 13; i++) player.newTurn();
		
		player.pays(200, 100);
		ConstructionStructure fabrica = new FabricaTemplate().create(position);
		player.receiveNewStructure(fabrica);

		 for (int i = 0; i < 2; i++) {
			Construction<Unit> construction = fabrica.create("Golliat", position2, player.getResources(), player.currentPopulation(), player.populationQuota());
			while(!construction.itsFinished()) {
				construction.lowerRelease();
			}
			Unit golliat = construction.gather();
			player.receiveNewUnit(golliat);
		}
		fabrica.create("Golliat", null, player.getResources(), player.currentPopulation(), player.populationQuota());
	}

	@Test
<<<<<<< HEAD:test/fiuba/algo3/starcraft/logic/test/player/integration/units/GolliatTest.java
	public void test2GolliatCreationAnd1GolliatDeadLeavesPopulationAt1() throws InsufficientResources, QuotaExceeded, TemplateNotFound, MissingStructureRequired, ConstructionNotFinished {
		Resources initialResources = new Resources(650,200);
<<<<<<< HEAD
		Player player = new Player(null, null, TerranBuilder.getInstance(), null, initialResources, null);
=======
		Player player = new Player(null, null, new TerranBuilder(), null, initialResources);
>>>>>>> 60e498f1e7e1aa5a87dcdeb177fa693c0e02424f
		player.newStructureWithName("Deposito Suministro", null);
=======
	public void test2GolliatCreationAnd1GolliatDeadLeavesPopulationAt1() throws InsufficientResources, QuotaExceeded, TemplateNotFound, MissingStructureRequired, ConstructionNotFinished, NoResourcesToExtract {
		player.newStructureWithName("Deposito Suministro", position);
>>>>>>> 824aaf7355d45cd0f5838133b0fed5b3b78765f8:test/fiuba/algo3/starcraft/integration/units/GolliatTest.java
		for(int i = 0; i < 7; i++) player.newTurn();
		player.newStructureWithName("Barraca", position);
		for(int i = 0; i < 13; i++) player.newTurn();
		player.pays(200, 100);
		ConstructionStructure fabrica = new FabricaTemplate().create(position);
		player.receiveNewStructure(fabrica);
		Construction<Unit> construction = fabrica.create("Golliat", position2, player.getResources(), player.currentPopulation(), player.populationQuota());
		while(!construction.itsFinished()) {
			construction.lowerRelease();
		}
		Unit golliat1 = (Unit) construction.gather();
		player.receiveNewUnit(golliat1);
		Construction<Unit> construction1 = fabrica.create("Golliat", position, player.getResources(), player.currentPopulation(), player.populationQuota());
		while(!construction1.itsFinished()) {
			construction1.lowerRelease();
		}
		Unit golliat2 = (Unit) construction1.gather();
		player.receiveNewUnit(golliat2);
		assertEquals(player.currentPopulation(), 4);
		
		golliat2.reduceLife(125);
		player.newTurn();
		
		assertEquals(player.currentPopulation(), 2);
	}

}

