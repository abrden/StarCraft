package fiuba.algo3.starcraft.integration.structures;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.starcraft.logic.map.Map;
import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.map.exceptions.NoResourcesToExtract;
import fiuba.algo3.starcraft.logic.player.Player;
import fiuba.algo3.starcraft.logic.player.Resources;
import fiuba.algo3.starcraft.logic.structures.Structure;
import fiuba.algo3.starcraft.logic.structures.builders.ProtossBuilder;
import fiuba.algo3.starcraft.logic.structures.exceptions.InsufficientResources;
import fiuba.algo3.starcraft.logic.structures.exceptions.MissingStructureRequired;
import fiuba.algo3.starcraft.logic.structures.exceptions.TemplateNotFound;
import fiuba.algo3.starcraft.logic.templates.structures.protoss.AccesoTemplate;

public class DeadStructureTest {

	Map map;
	Point position;
	Resources initialResources;
	Player player;
	@Before
	public void before() {
		initialResources = new Resources(200,0);
		map = new Map(1000, null);
		position = new Point(54,70);
		player = new Player(null, null, new ProtossBuilder(), position, initialResources, map);
	}
	
	@Test
	public void testDeadStructureDissapearsFromParcel() throws MissingStructureRequired, InsufficientResources, TemplateNotFound, NoResourcesToExtract {
		Structure structure = new AccesoTemplate().create(position);
		player.receiveNewStructure(structure);
		assertEquals(map.getParcelContainingPoint(position).getStructure(), structure);
		
		structure.reduceLife(1000000);
		player.newTurn();
		
		assertEquals(map.getParcelContainingPoint(position).getStructure(), null);
	}

}
