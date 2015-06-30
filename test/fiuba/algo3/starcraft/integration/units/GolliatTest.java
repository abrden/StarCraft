package fiuba.algo3.starcraft.integration.units;

import static org.junit.Assert.*;
import fiuba.algo3.starcraft.logic.structures.exceptions.*;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.starcraft.logic.map.Map;
import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.map.exceptions.NoResourcesToExtract;
import fiuba.algo3.starcraft.logic.map.exceptions.StructureCannotBeSetHere;
import fiuba.algo3.starcraft.logic.player.Player;
import fiuba.algo3.starcraft.logic.player.Resources;
import fiuba.algo3.starcraft.logic.structures.Construction;
import fiuba.algo3.starcraft.logic.structures.ConstructionStructure;
import fiuba.algo3.starcraft.logic.structures.builders.TerranBuilder;
import fiuba.algo3.starcraft.logic.templates.structures.terran.FabricaTemplate;
import fiuba.algo3.starcraft.logic.units.Unit;

public class GolliatTest {
	Map map;
	Point position;
	Point position2;
	Point position3;
	Point position4;
	Resources initialResources;
	Player player;
	@Before
	public void before() {
		initialResources = new Resources(750,250);
		map = new Map(1000, null);
		position = new Point(1,1);
		position2 = new Point (270,340);
		position3 = new Point (170,334);
		position4 = new Point (470,334);
		player = new Player(null, null, new TerranBuilder(), position, initialResources, map);
	}

	@Test
	public void testGolliatCreationWith1DepositoSuministro1Barraca1FabricaAnd100M150G() throws InsufficientResources, QuotaExceeded, TemplateNotFound, MissingStructureRequired, ConstructionNotFinished, NoResourcesToExtract, ConstructorIsDead, StructureCannotBeSetHere {
		player.newStructureWithName("Deposito Suministro", position);
		for(int i = 0; i < 7; i++) player.newTurn();
		player.newStructureWithName("Barraca", position2);
		for(int i = 0; i < 13; i++) player.newTurn();
		
		player.pays(200, 100);
		ConstructionStructure fabrica = new FabricaTemplate().create(position3);
		player.receiveNewStructure(fabrica);
		
		Construction<Unit> construction = fabrica.create("Golliat", position4, player.getResources(), player.currentPopulation(), player.populationQuota());
		while(!construction.itsFinished()) {
			construction.lowerRelease();
		}
		Unit golliat = construction.gather();
		player.receiveNewUnit(golliat);
		
		assertEquals(player.currentPopulation(), 2);
	}

	@Test(expected = QuotaExceeded.class)
	public void testCantCreateAThirdGolliatWith1Depot() throws InsufficientResources, QuotaExceeded, TemplateNotFound, MissingStructureRequired, ConstructionNotFinished, NoResourcesToExtract, ConstructorIsDead, StructureCannotBeSetHere {
		player.newStructureWithName("Deposito Suministro", position);
		for(int i = 0; i < 7; i++) player.newTurn();
		player.newStructureWithName("Barraca", position2);
		for(int i = 0; i < 13; i++) player.newTurn();
		
		player.pays(200, 100);
		ConstructionStructure fabrica = new FabricaTemplate().create(position3);
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
	public void test2GolliatCreationAnd1GolliatDeadLeavesPopulationAt1() throws InsufficientResources, QuotaExceeded, TemplateNotFound, MissingStructureRequired, ConstructionNotFinished, NoResourcesToExtract, ConstructorIsDead, StructureCannotBeSetHere {
		player.newStructureWithName("Deposito Suministro", position);
		for(int i = 0; i < 7; i++) player.newTurn();
		player.newStructureWithName("Barraca", position2);
		for(int i = 0; i < 13; i++) player.newTurn();
		player.pays(200, 100);
		ConstructionStructure fabrica = new FabricaTemplate().create(position3);
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

