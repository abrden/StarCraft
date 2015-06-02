package fiuba.algo3.starcraft.test.units;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.starcraft.logic.player.Construction;
import fiuba.algo3.starcraft.logic.player.Player;
import fiuba.algo3.starcraft.logic.player.Resources;
import fiuba.algo3.starcraft.logic.structures.ConstructionStructure;
import fiuba.algo3.starcraft.logic.structures.Depot;
import fiuba.algo3.starcraft.logic.structures.exceptions.InsufficientResources;
import fiuba.algo3.starcraft.logic.structures.exceptions.QuotaExceeded;
import fiuba.algo3.starcraft.logic.structures.exceptions.TemplateNotFound;
import fiuba.algo3.starcraft.logic.templates.structures.protoss.AccesoTemplate;
import fiuba.algo3.starcraft.logic.templates.structures.protoss.PilonTemplate;
import fiuba.algo3.starcraft.logic.units.Unit;

public class DragonTest {

	@Test
	public void testDragonCreationWith1Pilon1AccesoAnd120M50G() throws InsufficientResources, QuotaExceeded, TemplateNotFound {
		Resources initialResources = new Resources(375,50);
		Player player = new Player(null, null, null, initialResources);
		player.pays(100, 0);
		Depot pilon = PilonTemplate.getInstance().create();
		player.newStructure(pilon);
		player.pays(150, 0);
		ConstructionStructure acceso = AccesoTemplate.getInstance().create();
		player.newStructure(acceso);
		
		Construction construction = acceso.create("Dragon", player.getResources(), player.populationSpace());
		while(!construction.itsFinished()) {
			construction.lowerRelease();
		}
		Unit dragon = (Unit) construction.gather();
		player.newUnit(dragon);
		assertEquals(player.getMineral(), 0);
		assertEquals(player.getGas(), 0);
		
		assertEquals(player.currentPopulation(), 2);
	}
}
