package fiuba.algo3.starcraft.logic.test.player.integration.units;

import static org.junit.Assert.*;

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
import fiuba.algo3.starcraft.logic.templates.structures.protoss.ArchivosTemplariosTemplate;
import fiuba.algo3.starcraft.logic.units.Unit;

public class AltoTemplarioTest {

	@Test
	public void testAltoTemplarioCreationWith1ArchivosTemplariosAnd50M150G() throws InsufficientResources, QuotaExceeded, TemplateNotFound, MissingStructureRequired, ConstructionNotFinished {
		Resources initialResources = new Resources(600,500);
		Player player = new Player(null, null, ProtossBuilder.getInstance(), null, initialResources);
		player.newStructureWithName("Pilon", null);
		for(int i = 0; i < 6; i++) player.newTurn();
		player.newStructureWithName("Acceso", null);
		for(int i = 0; i < 9; i++) player.newTurn();
		player.newStructureWithName("Puerto Estelar", null);
		for(int i = 0; i < 11; i++) player.newTurn();
		
		ConstructionStructure archivos = ArchivosTemplariosTemplate.getInstance().create(null);
		player.pays(150, 200);
		player.receiveNewStructure(archivos);
		
		Construction<Unit> construction = archivos.create("Alto Templario", null, player.getResources(), player.currentPopulation(), player.populationQuota());
		while(!construction.itsFinished()) {
			construction.lowerRelease();
		}
		Unit templario = construction.gather();
		player.receiveNewUnit(templario);
		
		assertEquals(player.currentPopulation(), 2);
	}

}
