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
		map = new Map(1000, null);
		position = new Point(54,70);
		position2 = new Point(10,70);
		player = new Player(null, null, new ProtossBuilder(), position, initialResources, map);
	}
	
	@Test
	public void testZealotCreationWith1Pilon1AccesoAnd100M() throws InsufficientResources, QuotaExceeded, TemplateNotFound, MissingStructureRequired, ConstructionNotFinished, NoResourcesToExtract, ConstructorIsDead {
		player.newStructureWithName("Pilon", position);
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
		player.pays(150, 0);
		ConstructionStructure acceso = new AccesoTemplate().create(position);
		player.receiveNewStructure(acceso);
		
		acceso.create("Zealot", position2, player.getResources(), player.currentPopulation(), player.populationQuota());
	}

}
