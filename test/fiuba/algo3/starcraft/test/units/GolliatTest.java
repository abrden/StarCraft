package fiuba.algo3.starcraft.test.units;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.starcraft.logic.player.Construction;
import fiuba.algo3.starcraft.logic.player.Player;
import fiuba.algo3.starcraft.logic.player.Resources;
import fiuba.algo3.starcraft.logic.structures.ConstructionStructure;
import fiuba.algo3.starcraft.logic.structures.builders.TerranBuilder;
import fiuba.algo3.starcraft.logic.structures.exceptions.InsufficientResources;
import fiuba.algo3.starcraft.logic.structures.exceptions.MissingStructureRequired;
import fiuba.algo3.starcraft.logic.structures.exceptions.QuotaExceeded;
import fiuba.algo3.starcraft.logic.structures.exceptions.TemplateNotFound;
import fiuba.algo3.starcraft.logic.templates.structures.terran.FabricaTemplate;
import fiuba.algo3.starcraft.logic.units.Unit;

public class GolliatTest {

	@Test
	public void testGolliatCreationWith1DepositoSuministro1Barraca1FabricaAnd100M150G() throws InsufficientResources, QuotaExceeded, TemplateNotFound, MissingStructureRequired {
		Resources initialResources = new Resources(550,150);
		Player player = new Player(null, null, TerranBuilder.getInstance(), initialResources);
		player.newStructureWithName("Deposito Suministro");
		for(int i = 0; i < 7; i++) player.newTurn();
		player.newStructureWithName("Barraca");
		for(int i = 0; i < 13; i++) player.newTurn();
		
		player.pays(200, 100);
		ConstructionStructure fabrica = FabricaTemplate.getInstance().create();
		player.receiveNewStructure(fabrica);
		
		Construction<Unit> construction = fabrica.create("Golliat", player.getResources(), player.currentPopulation(), player.populationQuota());
		while(!construction.itsFinished()) {
			construction.lowerRelease();
		}
		Unit golliat = construction.gather();
		player.receiveNewUnit(golliat);
		
		assertEquals(player.currentPopulation(), 2);
	}

	@Test(expected = QuotaExceeded.class)
	public void testCantCreateAThirdGolliatWith1Depot() throws InsufficientResources, QuotaExceeded, TemplateNotFound, MissingStructureRequired {
		Resources initialResources = new Resources(750,250);
		Player player = new Player(null, null, TerranBuilder.getInstance(), initialResources);
		player.newStructureWithName("Deposito Suministro");
		for(int i = 0; i < 7; i++) player.newTurn();
		player.newStructureWithName("Barraca");
		for(int i = 0; i < 13; i++) player.newTurn();
		player.pays(200, 100);
		ConstructionStructure fabrica = FabricaTemplate.getInstance().create();
		player.receiveNewStructure(fabrica);

		for (int i = 0; i < 2; i++) {
			Construction<Unit> construction = fabrica.create("Golliat", player.getResources(), player.currentPopulation(), player.populationQuota());
			while(!construction.itsFinished()) {
				construction.lowerRelease();
			}
			Unit golliat = (Unit) construction.gather();
			player.receiveNewUnit(golliat);
		}

		Construction<Unit> construction = fabrica.create("Golliat", player.getResources(), player.currentPopulation(), player.populationQuota());
		while(!construction.itsFinished()) {
			construction.lowerRelease();
		}
		Unit golliat = (Unit) construction.gather();
		player.receiveNewUnit(golliat);
	}

	@Test
	public void test2GolliatCreationAnd1GolliatDeadLeavesPopulationAt1() throws InsufficientResources, QuotaExceeded, TemplateNotFound, MissingStructureRequired {
		Resources initialResources = new Resources(650,200);
		Player player = new Player(null, null, TerranBuilder.getInstance(), initialResources);
		player.newStructureWithName("Deposito Suministro");
		for(int i = 0; i < 7; i++) player.newTurn();
		player.newStructureWithName("Barraca");
		for(int i = 0; i < 13; i++) player.newTurn();
		player.pays(200, 100);
		ConstructionStructure fabrica = FabricaTemplate.getInstance().create();
		player.receiveNewStructure(fabrica);
		Construction<Unit> construction = fabrica.create("Golliat", player.getResources(), player.currentPopulation(), player.populationQuota());
		while(!construction.itsFinished()) {
			construction.lowerRelease();
		}
		Unit golliat1 = (Unit) construction.gather();
		player.receiveNewUnit(golliat1);
		Construction<Unit> construction1 = fabrica.create("Golliat", player.getResources(), player.currentPopulation(), player.populationQuota());
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

