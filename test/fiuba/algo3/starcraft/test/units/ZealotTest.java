package fiuba.algo3.starcraft.test.units;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.starcraft.logic.player.Construction;
import fiuba.algo3.starcraft.logic.player.Player;
import fiuba.algo3.starcraft.logic.player.Resources;
import fiuba.algo3.starcraft.logic.structures.ConstructionStructure;
import fiuba.algo3.starcraft.logic.structures.builders.ProtossBuilder;
import fiuba.algo3.starcraft.logic.structures.exceptions.InsufficientResources;
import fiuba.algo3.starcraft.logic.structures.exceptions.MissingStructureRequired;
import fiuba.algo3.starcraft.logic.structures.exceptions.QuotaExceeded;
import fiuba.algo3.starcraft.logic.structures.exceptions.TemplateNotFound;
import fiuba.algo3.starcraft.logic.templates.structures.protoss.AccesoTemplate;
import fiuba.algo3.starcraft.logic.units.Unit;

public class ZealotTest {

	@Test
	public void testZealotCreationWith1Pilon1AccesoAnd100M() throws InsufficientResources, QuotaExceeded, TemplateNotFound, MissingStructureRequired {
		Resources initialResources = new Resources(350,0);
		Player player = new Player(null, null, ProtossBuilder.getInstance(), initialResources);
		player.newStructureWithName("Pilon");
		for(int i = 0; i < 6; i++) player.newTurn();
		
		player.pays(150, 0);
		ConstructionStructure acceso = AccesoTemplate.getInstance().create();
		player.receiveNewStructure(acceso);
		
		Construction<Unit> construction = acceso.create("Zealot", player.getResources(), player.currentPopulation(), player.populationQuota());
		while(!construction.itsFinished()) {
			construction.lowerRelease();
		}
		Unit zealot = (Unit) construction.gather();
		player.receiveNewUnit(zealot);
		
		assertEquals(player.currentPopulation(), 2);
	}
	
	@Test(expected = QuotaExceeded.class)
	public void testZealotCreationIsImpossibleWithoutPilon() throws InsufficientResources, QuotaExceeded, TemplateNotFound {
		Resources initialResources = new Resources(150,0);
		Player player = new Player(null, null, null, initialResources);
		player.pays(150, 0);
		ConstructionStructure acceso = AccesoTemplate.getInstance().create();
		player.receiveNewStructure(acceso);
		
		acceso.create("Zealot", player.getResources(), player.currentPopulation(), player.populationQuota());
	}

}
