package fiuba.algo3.starcraft.logic.test.player;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.starcraft.game.StarCraft;
import fiuba.algo3.starcraft.logic.map.Map;
import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.player.Player;
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
	@Before
	public void before() {
		game = new StarCraft();
		map = new Map(1000);
		player1 = new Player(null, null, null, null, null, map);
		player2 = new Player(null, null, null, null, null, map);
		game.setPlayer1(player1);
		game.setPlayer2(player2);
		game.setMap(map);
	}
	
	@Test
	public void test() throws InsufficientEnergy, NonexistentPower {
		System.out.println(game);
		Point position = new Point(1,1);
		MuggleUnit dragon = new DragonTemplate().create(position);
		player2.receiveNewUnit(dragon);
		MagicalUnit nave = new NaveCienciaTemplate().create(new Point (1000,1000));
		player1.receiveNewUnit(nave);
		nave.update();
		nave.update();
		nave.update();
		nave.update();
		nave.update();
		nave.update();
		nave.update();
		nave.update();
		nave.update();
		nave.update();

		System.out.println(game);

		player1.usePower(nave, "EMP", position);

		assertEquals(dragon.getShield(), 0);
	}

}
