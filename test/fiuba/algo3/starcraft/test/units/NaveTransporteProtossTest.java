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
import fiuba.algo3.starcraft.logic.templates.structures.protoss.PuertoEstelarProtossTemplate;
import fiuba.algo3.starcraft.logic.units.Unit;

public class NaveTransporteProtossTest {

	@Test
	public void testNaveCreationWith1Pilon1Acceso1PuertoAnd200M() throws InsufficientResources, QuotaExceeded, TemplateNotFound {
		Resources initialResources = new Resources(600,150);
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
		
		Construction construction =  puerto.create("Nave Transporte", player.getResources(), player.populationSpace());
		while(!construction.itsFinished()) {
			construction.lowerRelease();
		}
		Unit nave = (Unit) construction.gather();
		player.newUnit(nave);
		
		assertEquals(player.getMineral(), 0);
		assertEquals(player.getGas(), 0);
		assertEquals(player.currentPopulation(), 2);
	}

}
