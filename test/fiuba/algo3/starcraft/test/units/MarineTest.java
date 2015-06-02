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
import fiuba.algo3.starcraft.logic.units.Unit;

public class MarineTest {

	@Test
	public void testMarineCreationWith1DepositoSuministro1BarracaAnd50M() throws InsufficientResources, QuotaExceeded {
		Resources initialResources = new Resources(300,0);
		Player player = new Player(null, null, null, initialResources);
		player.pays(100, 0);
		Depot depot = DepositoSuministroTemplate.getInstance().create();
		player.newStructure(depot);
		player.pays(150, 0);
		ConstructionStructure barraca = BarracaTemplate.getInstance().create();
		player.newStructure(barraca);
		
		Unit marine = barraca.createUnit("Marine", player.getResources(), player.populationSpace());
		player.newUnit(marine);
		
		assertEquals(player.currentPopulation(), 1);
	}

	@Test
	public void test2MarineCreationWith1DepositoSuministro1BarracaAnd100M() throws InsufficientResources, QuotaExceeded {
		Resources initialResources = new Resources(400,0);
		Player player = new Player(null, null, null, initialResources);
		player.pays(100, 0);
		Depot depot = DepositoSuministroTemplate.getInstance().create();
		player.newStructure(depot);
		player.pays(150, 0);
		ConstructionStructure barraca = BarracaTemplate.getInstance().create();
		player.newStructure(barraca);
		
		Unit marine1 = barraca.createUnit("Marine", player.getResources(), player.populationSpace());
		player.newUnit(marine1);
		Unit marine2 = barraca.createUnit("Marine", player.getResources(), player.populationSpace());
		player.newUnit(marine2);
		
		assertEquals(player.currentPopulation(), 2);
	}
	
	@Test(expected = InsufficientResources.class)
	public void test2MarineCreationWith1DepositoSuministro1BarracaAnd50M() throws InsufficientResources, QuotaExceeded {
		Resources initialResources = new Resources(300,0);
		Player player = new Player(null, null, null, initialResources);
		player.pays(100, 0);
		Depot depot = DepositoSuministroTemplate.getInstance().create();
		player.newStructure(depot);
		player.pays(150, 0);
		ConstructionStructure barraca = BarracaTemplate.getInstance().create();
		player.newStructure(barraca);
		Unit marine1 = barraca.createUnit("Marine", player.getResources(), player.populationSpace());
		player.newUnit(marine1);
		
		Unit marine2 = barraca.createUnit("Marine", player.getResources(), player.populationSpace());
		player.newUnit(marine2);
	}
	
	@Test(expected = QuotaExceeded.class)
	public void testMarineCreationWith1BarracaAnd50M() throws InsufficientResources, QuotaExceeded {
		Resources initialResources = new Resources(200,0);
		Player player = new Player(null, null, null, initialResources);
		player.pays(150, 0);
		ConstructionStructure barraca = BarracaTemplate.getInstance().create();
		player.newStructure(barraca);
		
		Unit marine1 = barraca.createUnit("Marine", player.getResources(), player.populationSpace());
		player.newUnit(marine1);
		
		assertEquals(player.currentPopulation(), 2);
	}
	
	@Test
	public void test2MarineCreationAnd1MarineDeadLeavesPopulationAt1() throws InsufficientResources, QuotaExceeded {
		Resources initialResources = new Resources(400,0);
		Player player = new Player(null, null, null, initialResources);
		player.pays(100, 0);
		Depot depot = DepositoSuministroTemplate.getInstance().create();
		player.newStructure(depot);
		player.pays(150, 0);
		ConstructionStructure barraca = BarracaTemplate.getInstance().create();
		player.newStructure(barraca);
		Unit marine1 = barraca.createUnit("Marine", player.getResources(), player.populationSpace());
		player.newUnit(marine1);
		Unit marine2 = barraca.createUnit("Marine", player.getResources(), player.populationSpace());
		player.newUnit(marine2);
		assertEquals(player.currentPopulation(), 2);
		
		marine2.reduceLife(40);
		player.newTurn();
		
		assertEquals(player.currentPopulation(), 1);
	}
	
	@Test
	public void test4MarineCreationAnd4MarineDeadLeavesPopulationAt0() throws InsufficientResources, QuotaExceeded {
		Resources initialResources = new Resources(100000,0);
		Player player = new Player(null, null, null, initialResources);
		player.pays(100, 0);
		Depot depot = DepositoSuministroTemplate.getInstance().create();
		player.newStructure(depot);
		player.pays(150, 0);
		ConstructionStructure barraca = BarracaTemplate.getInstance().create();
		player.newStructure(barraca);

		for (int i = 0; i < 4; i++) {
			Unit marine = barraca.createUnit("Marine", player.getResources(), player.populationSpace());
			player.newUnit(marine);
			
			assertEquals(player.currentPopulation(), 1);
			marine.reduceLife(40);
			player.newTurn();
		}
		
		assertEquals(player.currentPopulation(), 0);
	}
	
	@Test
	public void test7MarineCreationAnd49TurnsLeavesPopulationAt7() throws InsufficientResources, QuotaExceeded {
		Resources initialResources = new Resources(100000,0);
		Player player = new Player(null, null, null, initialResources);
		player.pays(100, 0);
		Depot depot1 = DepositoSuministroTemplate.getInstance().create();
		player.newStructure(depot1);
		player.pays(100, 0);
		Depot depot2 = DepositoSuministroTemplate.getInstance().create();
		player.newStructure(depot2);
		player.pays(150, 0);
		ConstructionStructure barraca = BarracaTemplate.getInstance().create();
		player.newStructure(barraca);
		for (int i = 0; i < 7; i++) {
			Unit marine = barraca.createUnit("Marine", player.getResources(), player.populationSpace());
			player.newUnit(marine);
			assertEquals(player.currentPopulation(), i + 1);
		}
		
		assertEquals(player.currentPopulation(), 7);
	}
}
