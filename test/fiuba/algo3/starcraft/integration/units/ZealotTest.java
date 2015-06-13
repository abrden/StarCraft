package fiuba.algo3.starcraft.integration.units;

import static org.junit.Assert.assertEquals;

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
import fiuba.algo3.starcraft.logic.templates.structures.protoss.AccesoTemplate;
import fiuba.algo3.starcraft.logic.units.Unit;

public class ZealotTest {
	Map map;
	Point position;
	Point position2;
	Resources initialResources;
	Player player;
	@Before
	public void before() {
		initialResources = new Resources(350,0);
		map = new Map(1000);
		position = new Point(54,70);
		position2 = new Point(10,70);
		player = new Player(null, null, new ProtossBuilder(), position, initialResources, map);
	}
	
	@Test
<<<<<<< HEAD:test/fiuba/algo3/starcraft/logic/test/player/integration/units/ZealotTest.java
	public void testZealotCreationWith1Pilon1AccesoAnd100M() throws InsufficientResources, QuotaExceeded, TemplateNotFound, MissingStructureRequired, ConstructionNotFinished {
		Resources initialResources = new Resources(350,0);
<<<<<<< HEAD
		Player player = new Player(null, null, ProtossBuilder.getInstance(), null, initialResources, null);
=======
		Player player = new Player(null, null, new ProtossBuilder(), null, initialResources);
>>>>>>> 60e498f1e7e1aa5a87dcdeb177fa693c0e02424f
		player.newStructureWithName("Pilon", null);
=======
	public void testZealotCreationWith1Pilon1AccesoAnd100M() throws InsufficientResources, QuotaExceeded, TemplateNotFound, MissingStructureRequired, ConstructionNotFinished, NoResourcesToExtract {
		player.newStructureWithName("Pilon", position);
>>>>>>> 824aaf7355d45cd0f5838133b0fed5b3b78765f8:test/fiuba/algo3/starcraft/integration/units/ZealotTest.java
		for(int i = 0; i < 6; i++) player.newTurn();
		
		player.pays(150, 0);
		ConstructionStructure acceso = new AccesoTemplate().create(position);
		player.receiveNewStructure(acceso);
		
		Construction<Unit> construction = acceso.create("Zealot", position2, player.getResources(), player.currentPopulation(), player.populationQuota());
		while(!construction.itsFinished()) {
			construction.lowerRelease();
		}
		Unit zealot = construction.gather();
		player.receiveNewUnit(zealot);
		
		assertEquals(player.currentPopulation(), 2);
	}
	
	@Test(expected = QuotaExceeded.class)
	public void testZealotCreationIsImpossibleWithoutPilon() throws InsufficientResources, QuotaExceeded, TemplateNotFound {
<<<<<<< HEAD:test/fiuba/algo3/starcraft/logic/test/player/integration/units/ZealotTest.java
		Resources initialResources = new Resources(150,0);
		Player player = new Player(null, null, null, null, initialResources, null);
=======
>>>>>>> 824aaf7355d45cd0f5838133b0fed5b3b78765f8:test/fiuba/algo3/starcraft/integration/units/ZealotTest.java
		player.pays(150, 0);
		ConstructionStructure acceso = new AccesoTemplate().create(position);
		player.receiveNewStructure(acceso);
		
		acceso.create("Zealot", position2, player.getResources(), player.currentPopulation(), player.populationQuota());
	}

}
