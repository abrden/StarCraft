package fiuba.algo3.starcraft.integration.units;

import static org.junit.Assert.*;
import fiuba.algo3.starcraft.logic.structures.exceptions.*;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.starcraft.logic.map.Map;
import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.map.exceptions.NoResourcesToExtract;
import fiuba.algo3.starcraft.logic.map.exceptions.StructureCannotBeSetThere;
import fiuba.algo3.starcraft.logic.player.Player;
import fiuba.algo3.starcraft.logic.player.Resources;
import fiuba.algo3.starcraft.logic.structures.Construction;
import fiuba.algo3.starcraft.logic.structures.ConstructionStructure;
import fiuba.algo3.starcraft.logic.structures.builders.TerranBuilder;
import fiuba.algo3.starcraft.logic.templates.structures.terran.PuertoEstelarTerranTemplate;
import fiuba.algo3.starcraft.logic.units.Unit;

public class NaveCienciaTest {
	Map map;
	Point position;
	Point position2;
	Point position3;
	Point position4;
	Resources initialResources;
	Player player;
	@Before
	public void before() {
		initialResources = new Resources(700,425);
		map = new Map(1000, null);
		position = new Point(54,70);
		position2 = new Point(100,70);
		position3 = new Point (270,340);
		position4 = new Point (470,334);
		player = new Player(null, null, new TerranBuilder(), position, initialResources, map);
	}
	@Test
	public void testNeveCienciaCreationWith1PuertoEstelarAnd100M225G() throws QuotaExceeded, InsufficientResources, TemplateNotFound, MissingStructureRequired, ConstructionNotFinished, NoResourcesToExtract, ConstructorIsDead, StructureCannotBeSetThere {
		player.newStructureWithName("Deposito Suministro", position);
		for(int i = 0; i < 7; i++) player.newTurn();
		player.newStructureWithName("Barraca", position2);
		for(int i = 0; i < 13; i++) player.newTurn();
		player.newStructureWithName("Fabrica", position3);
		for(int i = 0; i < 13; i++) player.newTurn();
		
		player.pays(150, 100);
		ConstructionStructure puerto = new PuertoEstelarTerranTemplate().create(position4);
		player.receiveNewStructure(puerto);
		
		Construction<Unit> construction = puerto.create("Nave Ciencia", position, player.getResources(), player.currentPopulation(), player.populationQuota());
		while(!construction.itsFinished()) {
			construction.lowerRelease();
		}
		Unit nave = construction.gather();
		player.receiveNewUnit(nave);
		
		assertEquals(player.currentPopulation(), 2);
	}

}
