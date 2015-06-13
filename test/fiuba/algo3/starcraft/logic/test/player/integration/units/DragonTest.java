package fiuba.algo3.starcraft.logic.test.player.integration.units;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.starcraft.logic.map.Map;
import fiuba.algo3.starcraft.logic.map.NoResourcesToExtract;
import fiuba.algo3.starcraft.logic.map.Point;
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
import fiuba.algo3.starcraft.logic.templates.structures.protoss.AccesoTemplate;
import fiuba.algo3.starcraft.logic.units.Unit;

public class DragonTest {
	Map map;
	Point position;
	Point position2;
	Resources initialResources;
	Player player;
	@Before
	public void before() {
		initialResources = new Resources(375,50);
		map = new Map(1000);
		position = new Point(54,70);
		position2 = new Point(10,70);
		player = new Player(null, null, new ProtossBuilder(), position, initialResources, map);
	}

	@Test
	public void testDragonCreationWith1Pilon1AccesoAnd120M50G() throws InsufficientResources, QuotaExceeded, TemplateNotFound, MissingStructureRequired, ConstructionNotFinished, NoResourcesToExtract {
		player.newStructureWithName("Pilon", position);
		for(int i = 0; i < 6; i++) player.newTurn();
		
		player.pays(150, 0);
		ConstructionStructure acceso = new AccesoTemplate().create(position);
		player.receiveNewStructure(acceso);
		
		Construction<Unit> construction = acceso.create("Dragon", position2, player.getResources(), player.currentPopulation(), player.populationQuota());
		while(!construction.itsFinished()) {
			construction.lowerRelease();
		}
		Unit dragon = (Unit) construction.gather();
		player.receiveNewUnit(dragon);
		assertEquals(player.getMineral(), 0);
		assertEquals(player.getGas(), 0);
		assertEquals(player.currentPopulation(), 2);
	}
}
