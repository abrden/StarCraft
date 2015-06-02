package fiuba.algo3.starcraft.test.units;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.starcraft.logic.player.Construction;
import fiuba.algo3.starcraft.logic.player.Player;
import fiuba.algo3.starcraft.logic.player.Resources;
import fiuba.algo3.starcraft.logic.structures.ConstructionStructure;
import fiuba.algo3.starcraft.logic.structures.Depot;
import fiuba.algo3.starcraft.logic.structures.InsufficientResources;
import fiuba.algo3.starcraft.logic.structures.QuotaExceeded;
import fiuba.algo3.starcraft.logic.structures.TemplateNotFound;
import fiuba.algo3.starcraft.logic.templates.AccesoTemplate;
import fiuba.algo3.starcraft.logic.templates.PilonTemplate;
import fiuba.algo3.starcraft.logic.units.Unit;

public class ZealotTest {

	@Test
	public void testZealotCreationWith1Pilon1AccesoAnd100M() throws InsufficientResources, QuotaExceeded, TemplateNotFound {
		Resources initialResources = new Resources(350,0);
		Player player = new Player(null, null, null, initialResources);
		player.pays(100, 0);
		Depot pilon = PilonTemplate.getInstance().create();
		player.newStructure(pilon);
		player.pays(150, 0);
		ConstructionStructure acceso = AccesoTemplate.getInstance().create();
		player.newStructure(acceso);
		
		Construction construction = acceso.create("Zealot", player.getResources(), player.populationSpace());
		while(!construction.itsFinished()) {
			construction.lowerRelease();
		}
		Unit zealot = (Unit) construction.gather();
		player.newUnit(zealot);
		
		assertEquals(player.currentPopulation(), 2);
	}
	
	@Test(expected = QuotaExceeded.class)
	public void testZealotCreationIsImpossibleWithoutPilon() throws InsufficientResources, QuotaExceeded, TemplateNotFound {
		Resources initialResources = new Resources(150,0);
		Player player = new Player(null, null, null, initialResources);
		player.pays(150, 0);
		ConstructionStructure acceso = AccesoTemplate.getInstance().create();
		player.newStructure(acceso);
		
		acceso.create("Zealot", player.getResources(), player.populationSpace());
	}

}
