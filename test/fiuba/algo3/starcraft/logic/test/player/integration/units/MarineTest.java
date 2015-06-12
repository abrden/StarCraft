package fiuba.algo3.starcraft.logic.test.player.integration.units;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

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
import fiuba.algo3.starcraft.logic.templates.structures.terran.BarracaTemplate;
import fiuba.algo3.starcraft.logic.units.Unit;

public class MarineTest {

	@Test
	public void testMarineCreationWith1DepositoSuministro1BarracaAnd50M() throws InsufficientResources, QuotaExceeded, TemplateNotFound, MissingStructureRequired, ConstructionNotFinished {
		Resources initialResources = new Resources(300,0);
		Player player = new Player(null, null, TerranBuilder.getInstance(), null, initialResources, null);
		player.newStructureWithName("Deposito Suministro", null);
		for(int i = 0; i < 7; i++) player.newTurn();
		player.pays(150, 0);
		ConstructionStructure barraca = BarracaTemplate.getInstance().create(null);
		player.receiveNewStructure(barraca);
		
		Construction<Unit> construction = barraca.create("Marine", null, player.getResources(), player.currentPopulation(), player.populationQuota());
		while(!construction.itsFinished()) {
			construction.lowerRelease();
		}
		Unit marine = construction.gather();
		player.receiveNewUnit(marine);
		
		assertEquals(player.currentPopulation(), 1);
	}

	@Test
	public void test2MarineCreationWith1DepositoSuministro1BarracaAnd100M() throws InsufficientResources, QuotaExceeded, TemplateNotFound, MissingStructureRequired, ConstructionNotFinished {
		Resources initialResources = new Resources(400,0);
		Player player = new Player(null, null, TerranBuilder.getInstance(), null, initialResources, null);
		player.newStructureWithName("Deposito Suministro", null);
		for(int i = 0; i < 7; i++) player.newTurn();
		player.pays(150, 0);
		ConstructionStructure barraca = BarracaTemplate.getInstance().create(null);
		player.receiveNewStructure(barraca);
		
		Construction<Unit> construction = barraca.create("Marine", null, player.getResources(), player.currentPopulation(), player.populationQuota());
		while(!construction.itsFinished()) {
			construction.lowerRelease();
		}
		Unit marine = construction.gather();
		player.receiveNewUnit(marine);
		Construction<Unit> construction1 = barraca.create("Marine", null, player.getResources(), player.currentPopulation(), player.populationQuota());
		while(!construction1.itsFinished()) {
			construction1.lowerRelease();
		}
		Unit marine1 = construction1.gather();
		player.receiveNewUnit(marine1);
		
		assertEquals(player.currentPopulation(), 2);
	}
	
	@Test(expected = InsufficientResources.class)
	public void test2MarineCreationWith1DepositoSuministro1BarracaAnd50M() throws InsufficientResources, QuotaExceeded, TemplateNotFound, MissingStructureRequired, ConstructionNotFinished {
		Resources initialResources = new Resources(300,0);
		Player player = new Player(null, null, TerranBuilder.getInstance(), null, initialResources, null);
		player.newStructureWithName("Deposito Suministro", null);
		for(int i = 0; i < 7; i++) player.newTurn();
		player.pays(150, 0);
		ConstructionStructure barraca = BarracaTemplate.getInstance().create(null);
		player.receiveNewStructure(barraca);
		Construction<Unit> construction = barraca.create("Marine", null, player.getResources(), player.currentPopulation(), player.populationQuota());
		while(!construction.itsFinished()) {
			construction.lowerRelease();
		}
		Unit marine = construction.gather();
		player.receiveNewUnit(marine);
		
		Construction<Unit> construction1 = barraca.create("Marine", null, player.getResources(), player.currentPopulation(), player.populationQuota());
		while(!construction1.itsFinished()) {
			construction1.lowerRelease();
		}
		Unit marine1 = construction1.gather();
		player.receiveNewUnit(marine1);
	}
	
	@Test(expected = QuotaExceeded.class)
	public void testMarineCreationWith1BarracaAnd50M() throws InsufficientResources, QuotaExceeded, TemplateNotFound, ConstructionNotFinished {
		Resources initialResources = new Resources(200,0);
		Player player = new Player(null, null, null, null, initialResources, null);
		player.pays(150, 0);
		ConstructionStructure barraca = BarracaTemplate.getInstance().create(null);
		player.receiveNewStructure(barraca);
		
		Construction<Unit> construction = barraca.create("Marine", null, player.getResources(), player.currentPopulation(), player.populationQuota());
		while(!construction.itsFinished()) {
			construction.lowerRelease();
		}
		Unit marine = construction.gather();
		player.receiveNewUnit(marine);
		
		assertEquals(player.currentPopulation(), 2);
	}
	
	@Test
	public void test2MarineCreationAnd1MarineDeadLeavesPopulationAt1() throws InsufficientResources, QuotaExceeded, TemplateNotFound, MissingStructureRequired, ConstructionNotFinished {
		Resources initialResources = new Resources(400,0);
		Player player = new Player(null, null, TerranBuilder.getInstance(), null, initialResources, null);
		player.newStructureWithName("Deposito Suministro", null);
		for(int i = 0; i < 7; i++) player.newTurn();
		player.pays(150, 0);
		ConstructionStructure barraca = BarracaTemplate.getInstance().create(null);
		player.receiveNewStructure(barraca);
		Construction<Unit> construction = barraca.create("Marine", null, player.getResources(), player.currentPopulation(), player.populationQuota());
		while(!construction.itsFinished()) {
			construction.lowerRelease();
		}
		Unit marine = construction.gather();
		player.receiveNewUnit(marine);
		Construction<Unit> construction1 = barraca.create("Marine", null, player.getResources(), player.currentPopulation(), player.populationQuota());
		while(!construction1.itsFinished()) {
			construction1.lowerRelease();
		}
		Unit marine1 = construction1.gather();
		player.receiveNewUnit(marine1);
		assertEquals(player.currentPopulation(), 2);
		
		marine1.reduceLife(40);
		player.newTurn();
		
		assertEquals(player.currentPopulation(), 1);
	}
	
	@Test
	public void test4MarineCreationAnd4MarineDeadLeavesPopulationAt0() throws InsufficientResources, QuotaExceeded, TemplateNotFound, MissingStructureRequired, ConstructionNotFinished {
		Resources initialResources = new Resources(100000,0);
		Player player = new Player(null, null, TerranBuilder.getInstance(), null, initialResources, null);
		player.newStructureWithName("Deposito Suministro", null);
		for(int i = 0; i < 7; i++) player.newTurn();
		player.pays(150, 0);
		ConstructionStructure barraca = BarracaTemplate.getInstance().create(null);
		player.receiveNewStructure(barraca);

		for (int i = 0; i < 4; i++) {
			Construction<Unit> construction = barraca.create("Marine", null, player.getResources(), player.currentPopulation(), player.populationQuota());
			while(!construction.itsFinished()) {
				construction.lowerRelease();
			}
			Unit marine = construction.gather();
			player.receiveNewUnit(marine);
			
			assertEquals(player.currentPopulation(), 1);
			marine.reduceLife(40);
			player.newTurn();
		}
		
		assertEquals(player.currentPopulation(), 0);
	}
	
	@Test
	public void test7MarineCreationAnd49TurnsLeavesPopulationAt7() throws InsufficientResources, QuotaExceeded, TemplateNotFound, MissingStructureRequired, ConstructionNotFinished {
		Resources initialResources = new Resources(100000,0);
		Player player = new Player(null, null, TerranBuilder.getInstance(), null, initialResources, null);
		player.newStructureWithName("Deposito Suministro", null);
		for(int i = 0; i < 7; i++) player.newTurn();
		player.newStructureWithName("Deposito Suministro", null);
		for(int i = 0; i < 7; i++) player.newTurn();
		player.pays(150, 0);
		ConstructionStructure barraca = BarracaTemplate.getInstance().create(null);
		player.receiveNewStructure(barraca);
		for (int i = 0; i < 7; i++) {
			Construction<Unit> construction = barraca.create("Marine", null, player.getResources(), player.currentPopulation(), player.populationQuota());
			while(!construction.itsFinished()) {
				construction.lowerRelease();
			}
			Unit marine = construction.gather();
			player.receiveNewUnit(marine);
			assertEquals(player.currentPopulation(), i + 1);
		}
		
		assertEquals(player.currentPopulation(), 7);
	}
}
