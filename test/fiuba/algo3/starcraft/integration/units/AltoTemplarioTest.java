package fiuba.algo3.starcraft.integration.units;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.starcraft.logic.map.Map;
import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.map.exceptions.NoResourcesToExtract;
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
	Map map;
	Point position;
	Point position2;
	Resources initialResources;
	Player player;
	@Before
	public void before() {
		initialResources = new Resources(600,500);
		map = new Map(1000);
		position = new Point(54,70);
		position2 = new Point(10,70);
		player = new Player(null, null, new ProtossBuilder(), position, initialResources, map);
	}
	
	@Test
	public void testAltoTemplarioCreationWith1ArchivosTemplariosAnd50M150G() throws InsufficientResources, QuotaExceeded, TemplateNotFound, MissingStructureRequired, ConstructionNotFinished, NoResourcesToExtract {
		player.newStructureWithName("Pilon", position);
		for(int i = 0; i < 6; i++) player.newTurn();
		player.newStructureWithName("Acceso", position);
		for(int i = 0; i < 9; i++) player.newTurn();
		player.newStructureWithName("Puerto Estelar", position);
		for(int i = 0; i < 11; i++) player.newTurn();
		
		ConstructionStructure archivos = new ArchivosTemplariosTemplate().create(position2);
		player.pays(150, 200);
		player.receiveNewStructure(archivos);
		
		Construction<Unit> construction = archivos.create("Alto Templario", position2, player.getResources(), player.currentPopulation(), player.populationQuota());
		while(!construction.itsFinished()) {
			construction.lowerRelease();
		}
		Unit templario = construction.gather();
		player.receiveNewUnit(templario);
		
		assertEquals(player.currentPopulation(), 2);
	}

}
