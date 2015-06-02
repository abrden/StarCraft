package fiuba.algo3.starcraft.test.units;

import static org.junit.Assert.*;

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
import fiuba.algo3.starcraft.logic.templates.ArchivosTemplariosTemplate;
import fiuba.algo3.starcraft.logic.templates.PilonTemplate;
import fiuba.algo3.starcraft.logic.templates.PuertoEstelarProtossTemplate;
import fiuba.algo3.starcraft.logic.units.Unit;

public class AltoTemplarioTest {

	@Test
	public void testAltoTemplarioCreationWith1ArchivosTemplariosAnd50M150G() throws InsufficientResources, QuotaExceeded, TemplateNotFound {
		Resources initialResources = new Resources(600,500);
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
		player.pays(150, 200);
		ConstructionStructure archivos = ArchivosTemplariosTemplate.getInstance().create();
		player.newStructure(puerto);
		
		Construction construction = archivos.create("Alto Templario", player.getResources(), player.populationSpace());
		while(!construction.itsFinished()) {
			construction.lowerRelease();
		}
		Unit templario = (Unit) construction.gather();
		player.newUnit(templario);
		
		assertEquals(player.currentPopulation(), 2);
	}

}
