package fiuba.algo3.starcraft.logic.test.player;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.player.Player;
import fiuba.algo3.starcraft.logic.templates.units.terran.NaveCienciaTemplate;
import fiuba.algo3.starcraft.logic.units.MagicalUnit;
import fiuba.algo3.starcraft.logic.units.exceptions.InsufficientEnergy;
import fiuba.algo3.starcraft.logic.units.exceptions.NonexistentPower;

public class PowerUsageTest {

	@Test
	public void test() throws InsufficientEnergy, NonexistentPower {
		Player player = new Player(null, null, null, null, null);
		MagicalUnit nave = NaveCienciaTemplate.getInstance().create(null);
		player.receiveNewUnit(nave);
		
		Point position = new Point(1,1);
		//player.usePower(nave, "EMP", position);
		//TODO: implementar esta y otras pruebas con multiples poderes cuando este lo de santi
	}

}
