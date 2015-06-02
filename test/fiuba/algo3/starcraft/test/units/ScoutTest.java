package fiuba.algo3.starcraft.test.units;

import static org.junit.Assert.assertEquals;

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
import fiuba.algo3.starcraft.logic.templates.structures.protoss.PuertoEstelarProtossTemplate;
import fiuba.algo3.starcraft.logic.units.Unit;

public class ScoutTest {

	@Test
	public void testScoutCreationWith1Pilon1Acceso1PuertoAnd300M150G() throws InsufficientResources, QuotaExceeded, TemplateNotFound {
		Resources initialResources = new Resources(700,300);
		Player player = new Player(null, null, null, initialResources);
		player.pays(100, 0);
		Depot pilon = PilonTemplate.getInstance().create();
		player.newStructure(pilon);
		player.pays(150, 0);
		ConstructionStructure acceso = AccesoTemplate.getInstance().create();
		player.newStructure(acceso);
		player.pays(150, 150);
		ConstructionStructure puerto = PuertoEstelarProtossTemplate.getInstance().create();
		player.newStructure(puerto);
		
		Construction construction = puerto.create("Scout", player.getResources(), player.populationSpace());
		while(!construction.itsFinished()) {
			construction.lowerRelease();
		}
		Unit scout = (Unit) construction.gather();
		player.newUnit(scout);
		
		assertEquals(player.getMineral(), 0);
		assertEquals(player.getGas(), 0);
		assertEquals(player.currentPopulation(), 3);
	}

}
