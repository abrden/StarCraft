package fiuba.algo3.starcraft.test.units;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.starcraft.logic.player.Player;
import fiuba.algo3.starcraft.logic.player.Resources;
import fiuba.algo3.starcraft.logic.structures.ConstructionStructure;
import fiuba.algo3.starcraft.logic.structures.Depot;
import fiuba.algo3.starcraft.logic.structures.InsufficientResources;
import fiuba.algo3.starcraft.logic.structures.QuotaExceeded;
import fiuba.algo3.starcraft.logic.templates.BarracaTemplate;
import fiuba.algo3.starcraft.logic.templates.DepositoSuministroTemplate;
import fiuba.algo3.starcraft.logic.templates.FabricaTemplate;
import fiuba.algo3.starcraft.logic.templates.TemplateID;
import fiuba.algo3.starcraft.logic.units.Unit;

public class GolliatTest {

	@Test
	public void testGolliatCreationWith1DepositoSuministro1Barraca1FabricaAnd100M150G() throws InsufficientResources, QuotaExceeded {
		Resources initialResources = new Resources(550,150);
		Player player = new Player(initialResources);
		player.pays(100, 0);
		Depot depot = DepositoSuministroTemplate.getInstance().create();
		player.newStructure(depot);
		player.pays(150, 0);
		ConstructionStructure barraca = BarracaTemplate.getInstance().create();
		player.newStructure(barraca);
		player.pays(200, 100);
		ConstructionStructure fabrica = FabricaTemplate.getInstance().create();
		player.newStructure(fabrica);
		
		Unit golliat = fabrica.createUnit(TemplateID.GolliatTemplate, player.getResources(), player.populationSpace());
		player.newUnit(golliat);
		
		assertEquals(player.population(), 1);
	}

	@Test
	public void test2GolliatCreationAnd1GolliatDeadLeavesPopulationAt1() throws InsufficientResources, QuotaExceeded {
		Resources initialResources = new Resources(650,200);
		Player player = new Player(initialResources);
		player.pays(100, 0);
		Depot depot = DepositoSuministroTemplate.getInstance().create();
		player.newStructure(depot);
		player.pays(150, 0);
		ConstructionStructure barraca = BarracaTemplate.getInstance().create();
		player.newStructure(barraca);
		player.pays(200, 100);
		ConstructionStructure fabrica = FabricaTemplate.getInstance().create();
		player.newStructure(fabrica);
		Unit golliat1 = fabrica.createUnit(TemplateID.GolliatTemplate, player.getResources(), player.populationSpace());
		player.newUnit(golliat1);
		Unit golliat2 = fabrica.createUnit(TemplateID.GolliatTemplate, player.getResources(), player.populationSpace());
		player.newUnit(golliat2);
		assertEquals(player.population(), 2);
		
		golliat2.reduceLife(125);
		player.newTurn();
		
		assertEquals(player.population(), 1);
	}
}

