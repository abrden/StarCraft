package fiuba.algo3.starcraft.integration.units;

import static org.junit.Assert.*;
import fiuba.algo3.starcraft.logic.structures.exceptions.*;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.starcraft.logic.map.Map;
import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.map.exceptions.NoResourcesToExtract;
import fiuba.algo3.starcraft.logic.map.exceptions.StructureCannotBeSetHere;
import fiuba.algo3.starcraft.logic.player.Player;
import fiuba.algo3.starcraft.logic.player.Resources;
import fiuba.algo3.starcraft.logic.structures.Construction;
import fiuba.algo3.starcraft.logic.structures.ConstructionStructure;
import fiuba.algo3.starcraft.logic.structures.builders.ProtossBuilder;
import fiuba.algo3.starcraft.logic.templates.structures.protoss.ArchivosTemplariosTemplate;
import fiuba.algo3.starcraft.logic.units.Unit;

public class AltoTemplarioTest {
	Map map;
	Point position;
	Point position2;
	Point position3;
	Point position4;
	Resources initialResources;
	Player player;
	@Before
	public void before() {
		initialResources = new Resources(600,500);
		map = new Map(1000, null);
		position = new Point(1,1);
		position2 = new Point (270,340);
		position3 = new Point (170,334);
		position4 = new Point (470,334);
		player = new Player(null, null, new ProtossBuilder(), position, initialResources, map);
	}
	
	@Test
	public void testAltoTemplarioCreationWith1ArchivosTemplariosAnd50M150G() throws InsufficientResources, QuotaExceeded, TemplateNotFound, MissingStructureRequired, ConstructionNotFinished, NoResourcesToExtract, ConstructorIsDead, StructureCannotBeSetHere {
		player.newStructureWithName("Pilon", position);
		for(int i = 0; i < 6; i++) player.newTurn();
		player.newStructureWithName("Acceso", position2);
		for(int i = 0; i < 9; i++) player.newTurn();
		player.newStructureWithName("Puerto Estelar Protoss", position3);
		for(int i = 0; i < 11; i++) player.newTurn();
		
		ConstructionStructure archivos = new ArchivosTemplariosTemplate().create(position4);
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
