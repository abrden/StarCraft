package fiuba.algo3.starcraft.logic.test.player.integration.units;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.starcraft.logic.player.Player;
import fiuba.algo3.starcraft.logic.player.Resources;
import fiuba.algo3.starcraft.logic.structures.Construction;
import fiuba.algo3.starcraft.logic.structures.ConstructionStructure;
import fiuba.algo3.starcraft.logic.structures.builders.ProtossBuilder;
import fiuba.algo3.starcraft.logic.structures.exceptions.ConstructionNotFinished;
import fiuba.algo3.starcraft.logic.structures.exceptions.InsufficientResources;
import fiuba.algo3.starcraft.logic.structures.exceptions.MissingStructureRequired;
import fiuba.algo3.starcraft.logic.structures.exceptions.QuotaExceeded;
import fiuba.algo3.starcraft.logic.structures.exceptions.TemplateNotFound;
import fiuba.algo3.starcraft.logic.templates.structures.protoss.PuertoEstelarProtossTemplate;
import fiuba.algo3.starcraft.logic.units.Unit;

public class ScoutTest {

	@Test
	public void testScoutCreationWith1Pilon1Acceso1PuertoAnd300M150G() throws InsufficientResources, QuotaExceeded, TemplateNotFound, MissingStructureRequired, ConstructionNotFinished {
		Resources initialResources = new Resources(700,300);
<<<<<<< HEAD
		Player player = new Player(null, null, ProtossBuilder.getInstance(), null, initialResources, null);
=======
		Player player = new Player(null, null, new ProtossBuilder(), null, initialResources);
>>>>>>> 60e498f1e7e1aa5a87dcdeb177fa693c0e02424f
		player.newStructureWithName("Pilon", null);
		for(int i = 0; i < 6; i++) player.newTurn();
		player.newStructureWithName("Acceso", null);
		for(int i = 0; i < 9; i++) player.newTurn();
		
		
		player.pays(150, 150);
		ConstructionStructure puerto = new PuertoEstelarProtossTemplate().create(null);
		player.receiveNewStructure(puerto);
		
		Construction<Unit> construction = puerto.create("Scout", null, player.getResources(), player.currentPopulation(), player.populationQuota());
		while(!construction.itsFinished()) {
			construction.lowerRelease();
		}
		Unit scout = construction.gather();
		player.receiveNewUnit(scout);
		
		assertEquals(player.getMineral(), 0);
		assertEquals(player.getGas(), 0);
		assertEquals(player.currentPopulation(), 3);
	}

}
