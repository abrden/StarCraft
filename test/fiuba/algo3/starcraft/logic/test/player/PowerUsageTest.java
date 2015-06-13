package fiuba.algo3.starcraft.logic.test.player;

import static org.junit.Assert.*;

import org.junit.Test;

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

	@Test
	public void test() throws InsufficientEnergy, NonexistentPower {
<<<<<<< HEAD
		Player player = new Player(null, null, null, null, null, null);
		MagicalUnit nave = NaveCienciaTemplate.getInstance().create(null);
=======
		Map map = new Map(1000);
		Point position = new Point(1,1);
		MuggleUnit dragon = new DragonTemplate().create(position);
		map.setUnit(dragon, dragon.getPosition());
		
		Player player = new Player(null, null, null, null, null);
		MagicalUnit nave = new NaveCienciaTemplate().create(null);
>>>>>>> 60e498f1e7e1aa5a87dcdeb177fa693c0e02424f
		player.receiveNewUnit(nave);
		nave.update();
		nave.update();
		nave.update();
		nave.update();
	
		//player.usePower(nave, "EMP", position);
		
		//TODO: implementar esta y otras pruebas con multiples poderes cuando este lo de santi
	}

}
