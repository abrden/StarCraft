package fiuba.algo3.starcraft.integration.units;

import static org.junit.Assert.assertEquals;

import fiuba.algo3.starcraft.logic.structures.exceptions.*;
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
import fiuba.algo3.starcraft.logic.templates.structures.protoss.PuertoEstelarProtossTemplate;
import fiuba.algo3.starcraft.logic.units.Unit;

public class ScoutTest {
	Map map;
	Point position;
	Point position2;
	Resources initialResources;
	Player player;
	@Before
	public void before() {
		initialResources = new Resources(700,300);
		map = new Map(1000, null);
		position = new Point(54,70);
		position2 = new Point(10,70);
		player = new Player(null, null, new ProtossBuilder(), position, initialResources, map);
	}
	
	@Test
	public void testScoutCreationWith1Pilon1Acceso1PuertoAnd300M150G() throws InsufficientResources, QuotaExceeded, TemplateNotFound, MissingStructureRequired, ConstructionNotFinished, NoResourcesToExtract, ConstructorIsDead {
		player.newStructureWithName("Pilon", position);
		for(int i = 0; i < 6; i++) player.newTurn();
		player.newStructureWithName("Acceso", position);
		for(int i = 0; i < 9; i++) player.newTurn();
		
		
		player.pays(150, 150);
		ConstructionStructure puerto = new PuertoEstelarProtossTemplate().create(position);
		player.receiveNewStructure(puerto);
		
		Construction<Unit> construction = puerto.create("Scout", position2, player.getResources(), player.currentPopulation(), player.populationQuota());
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
