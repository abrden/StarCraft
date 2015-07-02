package fiuba.algo3.starcraft.integration.units;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.starcraft.logic.map.Map;
import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.player.Player;
import fiuba.algo3.starcraft.logic.player.Resources;
import fiuba.algo3.starcraft.logic.structures.builders.ProtossBuilder;
import fiuba.algo3.starcraft.logic.templates.units.protoss.AltoTemplarioTemplate;
import fiuba.algo3.starcraft.logic.templates.units.protoss.DragonTemplate;
import fiuba.algo3.starcraft.logic.templates.units.protoss.NaveTransporteProtossTemplate;
import fiuba.algo3.starcraft.logic.units.MagicalUnit;
import fiuba.algo3.starcraft.logic.units.MuggleUnit;
import fiuba.algo3.starcraft.logic.units.TransportUnit;

public class ProtossShieldTest {

	int regenerationRate = 1;
	Map map;
	Player player;
	Point position;
	MuggleUnit dragon;
	MagicalUnit templario;
	TransportUnit nave;
	@Before
	public void before() {
		position = new Point(23,54);
		map = new Map(1000, null);
		dragon = (new DragonTemplate()).create(position);
		templario = (new AltoTemplarioTemplate()).create(position);
		nave = (new NaveTransporteProtossTemplate()).create(position);
		player = new Player(null, null, new ProtossBuilder(), null, new Resources(200,0), map);
	}
	
	@Test
	public void testMuggleUnitShieldRegenerates() {
		player.receiveNewUnit(dragon);
		dragon.reduceLife(40);
		int shield = dragon.getShield();
		
		player.newTurn();
		
		assertEquals(dragon.getShield(), shield + regenerationRate);
	}

	@Test
	public void testMagicalUnitShieldRegenerates() {
		player.receiveNewUnit(templario);
		templario.reduceLife(40);
		int shield = templario.getShield();
		
		player.newTurn();
		
		assertEquals(templario.getShield(), shield + regenerationRate);
	}
	
	@Test
	public void testTransportUnitShieldRegenerates() {
		player.receiveNewUnit(nave);
		nave.reduceLife(40);
		int shield = nave.getShield();
		
		player.newTurn();
		
		assertEquals(nave.getShield(), shield + regenerationRate);
	}
	
	@Test
	public void testMuggleUnitShieldRegeneratesTilMax() {
		player.receiveNewUnit(dragon);
		dragon.reduceLife(40);
		
		for(int i = 0; i < 34; i++) player.newTurn();
		
		assertEquals(dragon.getShield(), 74);
	}
}
