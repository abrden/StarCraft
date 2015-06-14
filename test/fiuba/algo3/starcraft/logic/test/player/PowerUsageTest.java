package fiuba.algo3.starcraft.logic.test.player;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.starcraft.game.StarCraft;
import fiuba.algo3.starcraft.logic.map.Map;
import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.player.Player;
import fiuba.algo3.starcraft.logic.structures.builders.ProtossBuilder;
import fiuba.algo3.starcraft.logic.structures.builders.TerranBuilder;
import fiuba.algo3.starcraft.logic.templates.units.protoss.AltoTemplarioTemplate;
import fiuba.algo3.starcraft.logic.templates.units.protoss.DragonTemplate;
import fiuba.algo3.starcraft.logic.templates.units.terran.NaveCienciaTemplate;
import fiuba.algo3.starcraft.logic.units.MagicalUnit;
import fiuba.algo3.starcraft.logic.units.MuggleUnit;
import fiuba.algo3.starcraft.logic.units.exceptions.InsufficientEnergy;
import fiuba.algo3.starcraft.logic.units.exceptions.NonexistentPower;

public class PowerUsageTest {
	
	StarCraft game;
	Map map;
	Player player1;
	Player player2;
	Point position;
	Point position2;
	MagicalUnit templario;
	MuggleUnit dragon;
	MagicalUnit nave;
	@Before
	public void before() {
		game = new StarCraft();
		map = new Map(1000, game);
		player1 = new Player(null, null, new TerranBuilder(), null, null, map);
		player2 = new Player(null, null, new ProtossBuilder(), null, null, map);
		game.setGame(player1, player2, map);
		
		position = new Point(1,1);
		position2 = new Point (1000,1000);
		templario = new AltoTemplarioTemplate().create(position);
		dragon = new DragonTemplate().create(position);
		nave = new NaveCienciaTemplate().create(position2);
	}
	
	@Test
	public void testEMPDestroysDragonsShield() throws InsufficientEnergy, NonexistentPower {
		player2.receiveNewUnit(dragon);
		player1.receiveNewUnit(nave);
		for (int i = 0; i < 5; i++) nave.update();
		
		player1.usePower(nave, "EMP", position);

		assertEquals(dragon.getShield(), 0);
	}
	
	@Test(expected = InsufficientEnergy.class)
	public void testEMPDrainsAltoTemplariosEnergy() throws InsufficientEnergy, NonexistentPower {
		player2.receiveNewUnit(templario);
		player1.receiveNewUnit(nave);
		for (int i = 0; i < 5; i++) nave.update();
		
		player1.usePower(nave, "EMP", position);

		player2.usePower(templario, "Tormenta Psionica", position2);
		assertTrue(false);
	}

}
