package fiuba.algo3.starcraft.test.units;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.starcraft.logic.player.Construction;
import fiuba.algo3.starcraft.logic.player.Player;
import fiuba.algo3.starcraft.logic.player.Resources;
import fiuba.algo3.starcraft.logic.structures.ConstructionStructure;
import fiuba.algo3.starcraft.logic.structures.Depot;
import fiuba.algo3.starcraft.logic.structures.InsufficientResources;
import fiuba.algo3.starcraft.logic.structures.QuotaExceeded;
import fiuba.algo3.starcraft.logic.structures.TemplateNotFound;
import fiuba.algo3.starcraft.logic.templates.BarracaTemplate;
import fiuba.algo3.starcraft.logic.templates.DepositoSuministroTemplate;
import fiuba.algo3.starcraft.logic.templates.FabricaTemplate;
import fiuba.algo3.starcraft.logic.units.Unit;

public class GolliatTest {

	@Test
	public void testGolliatCreationWith1DepositoSuministro1Barraca1FabricaAnd100M150G() throws InsufficientResources, QuotaExceeded, TemplateNotFound {
		Resources initialResources = new Resources(550,150);
		Player player = new Player(null, null, null, initialResources);
		player.pays(100, 0);
		Depot depot = DepositoSuministroTemplate.getInstance().create();
		player.newStructure(depot);
		player.pays(150, 0);
		ConstructionStructure barraca = BarracaTemplate.getInstance().create();
		player.newStructure(barraca);
		player.pays(200, 100);
		ConstructionStructure fabrica = FabricaTemplate.getInstance().create();
		player.newStructure(fabrica);
		
		Construction construction = fabrica.create("Golliat", player.getResources(), player.populationSpace());
		while(!construction.itsFinished()) {
			construction.lowerRelease();
		}
		Unit golliat = (Unit) construction.gather();
		player.newUnit(golliat);
		
		assertEquals(player.currentPopulation(), 2);
	}

	@Test(expected = QuotaExceeded.class)
	public void testCantCreateAThirdGolliatWith1Depot() throws InsufficientResources, QuotaExceeded, TemplateNotFound {
		Resources initialResources = new Resources(750,250);
		Player player = new Player(null, null, null, initialResources);
		player.pays(100, 0);
		Depot depot = DepositoSuministroTemplate.getInstance().create();
		player.newStructure(depot);
		player.pays(150, 0);
		ConstructionStructure barraca = BarracaTemplate.getInstance().create();
		player.newStructure(barraca);
		player.pays(200, 100);
		ConstructionStructure fabrica = FabricaTemplate.getInstance().create();
		player.newStructure(fabrica);

		for (int i = 0; i < 2; i++) {
			Construction construction = fabrica.create("Golliat", player.getResources(), player.populationSpace());
			while(!construction.itsFinished()) {
				construction.lowerRelease();
			}
			Unit golliat = (Unit) construction.gather();
			player.newUnit(golliat);
		}

		Construction construction = fabrica.create("Golliat", player.getResources(), player.populationSpace());
		while(!construction.itsFinished()) {
			construction.lowerRelease();
		}
		Unit golliat = (Unit) construction.gather();
		player.newUnit(golliat);
	}

	@Test
	public void test2GolliatCreationAnd1GolliatDeadLeavesPopulationAt1() throws InsufficientResources, QuotaExceeded, TemplateNotFound {
		Resources initialResources = new Resources(650,200);
		Player player = new Player(null, null, null, initialResources);
		player.pays(100, 0);
		Depot depot = DepositoSuministroTemplate.getInstance().create();
		player.newStructure(depot);
		player.pays(150, 0);
		ConstructionStructure barraca = BarracaTemplate.getInstance().create();
		player.newStructure(barraca);
		player.pays(200, 100);
		ConstructionStructure fabrica = FabricaTemplate.getInstance().create();
		player.newStructure(fabrica);
		Construction construction = fabrica.create("Golliat", player.getResources(), player.populationSpace());
		while(!construction.itsFinished()) {
			construction.lowerRelease();
		}
		Unit golliat1 = (Unit) construction.gather();
		player.newUnit(golliat1);
		Construction construction1 = fabrica.create("Golliat", player.getResources(), player.populationSpace());
		while(!construction1.itsFinished()) {
			construction1.lowerRelease();
		}
		Unit golliat2 = (Unit) construction1.gather();
		player.newUnit(golliat2);
		assertEquals(player.currentPopulation(), 4);
		
		golliat2.reduceLife(125);
		player.newTurn();
		
		assertEquals(player.currentPopulation(), 2);
	}

}

