package fiuba.algo3.starcraft.test.units;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.starcraft.logic.player.Player;
import fiuba.algo3.starcraft.logic.player.Resources;
import fiuba.algo3.starcraft.logic.structures.ConstructionStructure;
import fiuba.algo3.starcraft.logic.structures.Depot;
import fiuba.algo3.starcraft.logic.structures.InsufficientResources;
import fiuba.algo3.starcraft.logic.structures.QuotaExceeded;
import fiuba.algo3.starcraft.logic.templates.AccesoTemplate;
import fiuba.algo3.starcraft.logic.templates.PilonTemplate;
import fiuba.algo3.starcraft.logic.templates.TemplateID;
import fiuba.algo3.starcraft.logic.units.Unit;

public class DragonTest {

	@Test
	public void testDragonCreationWith1Pilon1AccesoAnd120M50G() throws InsufficientResources, QuotaExceeded {
		Resources initialResources = new Resources(375,50);
		Player player = new Player(initialResources);
		player.pays(100, 0);
		Depot pilon = PilonTemplate.getInstance().create();
		player.newStructure(pilon);
		player.pays(150, 0);
		ConstructionStructure acceso = AccesoTemplate.getInstance().create();
		player.newStructure(acceso);
		
		Unit dragon = acceso.createUnit(TemplateID.DragonTemplate, player.getResources(), player.populationSpace());
		player.newUnit(dragon);
		assertEquals(player.getMineral(), 0);
		assertEquals(player.getGas(), 0);
		
		assertEquals(player.population(), 1);
	}

}
