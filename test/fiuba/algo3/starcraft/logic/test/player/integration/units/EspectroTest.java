package fiuba.algo3.starcraft.logic.test.player.integration.units;

import static org.junit.Assert.*;

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
import fiuba.algo3.starcraft.logic.templates.structures.terran.PuertoEstelarTerranTemplate;
import fiuba.algo3.starcraft.logic.units.Unit;

public class EspectroTest {

	@Test
	public void testEspectroCreationWith1PuertoEstelarAnd150M100G() throws InsufficientResources, QuotaExceeded, TemplateNotFound, MissingStructureRequired, ConstructionNotFinished {
		Resources initialResources = new Resources(750,300);
		Player player = new Player(null, null, new TerranBuilder(), null, initialResources);
		player.newStructureWithName("Deposito Suministro", null);
		for(int i = 0; i < 7; i++) player.newTurn();
		player.newStructureWithName("Barraca", null);
		for(int i = 0; i < 13; i++) player.newTurn();
		player.newStructureWithName("Fabrica", null);
		for(int i = 0; i < 13; i++) player.newTurn();
		
		player.pays(150, 100);
		ConstructionStructure puerto = new PuertoEstelarTerranTemplate().create(null);
		player.receiveNewStructure(puerto);
		
		Construction<Unit> construction = puerto.create("Espectro", null, player.getResources(), player.currentPopulation(), player.populationQuota());
		while(!construction.itsFinished()) {
			construction.lowerRelease();
		}
		Unit espectro = (Unit) construction.gather();
		player.receiveNewUnit(espectro);
		
		assertEquals(player.currentPopulation(), 2);
	}

}
