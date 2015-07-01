package fiuba.algo3.starcraft.logic.test.templates.qualities;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.starcraft.logic.templates.qualities.Shield;

public class ShieldTest {

	@Test
	public void testShieldRegeneratesBy1PerTurn() {
		Shield shield = new Shield(45);
		
		shield.destroy();
		
		shield.regenerate();
		assertEquals(shield.getShield(), 1);
		
		shield.regenerate();
		assertEquals(shield.getShield(), 2);
	}

	@Test
	public void testShieldRegeneratesToItsMaximum() {
		Shield shield = new Shield(50);

		shield.reduce(5);
		shield.regenerate();
		
		assertEquals(shield.getShield(), 46);
	}
}
