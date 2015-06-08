package fiuba.algo3.starcraft.logic.test.templates.qualities;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.starcraft.logic.templates.qualities.Shield;

public class ShieldTest {

	@Test
	public void testShieldRegeneratesBy20PerTurn() {
		Shield shield = new Shield(45);
		
		shield.destroy();
		
		shield.regenerate();
		assertEquals(shield.getShield(), 20);
		
		shield.regenerate();
		assertEquals(shield.getShield(), 40);
	}

	@Test
	public void testShieldRegeneratesToItsMaximum() {
		Shield shield = new Shield(49);

		shield.reduce(5);
		shield.regenerate();
		
		assertEquals(shield.getShield(), 49);
	}
}
