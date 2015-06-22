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
import fiuba.algo3.starcraft.logic.structures.builders.TerranBuilder;
import fiuba.algo3.starcraft.logic.templates.structures.terran.PuertoEstelarTerranTemplate;
import fiuba.algo3.starcraft.logic.units.Unit;

public class NaveTransporteTerranTest {
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
		player = new Player(null, null, new TerranBuilder(), position, initialResources, map);
	}
	
	@Test
	public void testNaveCreationWith1PuertoEstelarAnd150M100G() throws InsufficientResources, QuotaExceeded, TemplateNotFound, MissingStructureRequired, ConstructionNotFinished, NoResourcesToExtract, ConstructorIsDead {
		player.newStructureWithName("Deposito Suministro", position);
		for(int i = 0; i < 7; i++) player.newTurn();
		player.newStructureWithName("Barraca", position);
		for(int i = 0; i < 13; i++) player.newTurn();
		player.newStructureWithName("Fabrica", position);
		for(int i = 0; i < 13; i++) player.newTurn();
		
		player.pays(150, 100);
		ConstructionStructure puerto = new PuertoEstelarTerranTemplate().create(position);
		player.receiveNewStructure(puerto);
		
		Construction<Unit> construction = puerto.create("Nave Transporte", position2, player.getResources(), player.currentPopulation(), player.populationQuota());
		while(!construction.itsFinished()) {
			construction.lowerRelease();
		}
		Unit nave = construction.gather();
		player.receiveNewUnit(nave);

		assertEquals(player.currentPopulation(), 2);
	}
}
