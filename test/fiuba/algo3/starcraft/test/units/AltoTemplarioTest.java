package fiuba.algo3.starcraft.test.units;

import static org.junit.Assert.*;

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
import fiuba.algo3.starcraft.logic.templates.structures.protoss.ArchivosTemplariosTemplate;
import fiuba.algo3.starcraft.logic.units.Unit;

public class AltoTemplarioTest {

	@Test
	public void testAltoTemplarioCreationWith1ArchivosTemplariosAnd50M150G() throws InsufficientResources, QuotaExceeded, TemplateNotFound, MissingStructureRequired {
		Resources initialResources = new Resources(600,500);
		Player player = new Player(null, null, ProtossBuilder.getInstance(), initialResources);
		player.newStructureWithName("Pilon");
		for(int i = 0; i < 6; i++) player.newTurn();
		player.newStructureWithName("Acceso");
		for(int i = 0; i < 9; i++) player.newTurn();
		player.newStructureWithName("Puerto Estelar");
		for(int i = 0; i < 11; i++) player.newTurn();
		
		ConstructionStructure archivos = ArchivosTemplariosTemplate.getInstance().create();
		player.pays(150, 200);
		player.receiveNewStructure(archivos);
		
		Construction<Unit> construction = archivos.create("Alto Templario", player.getResources(), player.currentPopulation(), player.populationQuota());
		while(!construction.itsFinished()) {
			construction.lowerRelease();
		}
		Unit templario = construction.gather();
		player.receiveNewUnit(templario);
		
		assertEquals(player.currentPopulation(), 2);
	}

}
