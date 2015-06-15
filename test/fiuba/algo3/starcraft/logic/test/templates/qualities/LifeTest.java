package fiuba.algo3.starcraft.logic.test.templates.qualities;

import fiuba.algo3.starcraft.logic.templates.qualities.Life;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LifeTest {

	Life life;

	@Before
	public void before() {
		life = new Life(100, 100);
	}

	@Test
	public void askingForShieldReturns0WhenNoShieldIsActive() {
		Life life = new Life(100);

		assertEquals(life.getShield(), 0);
	}

	@Test
	public void reducingLifeWhenShieldIsActiveWillReduceShieldFirst() {
		life.reduce(50);

		assertEquals(life.getHealth(),100);
	}

	@Test
	public void destroyingShieldLeavesItAt0() {
		life.destroyShield();

		assertEquals(life.getShield(), 0);
	}

	@Test
	public void reducingLifeWillFirstDestroyTheShieldThenReduceHealth(){
		life.reduce(120);

		assertEquals(life.getHealth(),80);
	}

	@Test
	public void shieldRegeneratesAfterBeingDestroyed() {
		life.reduce(150);
		life.regenerateShield();

		assertEquals(life.getShield(), 20);
	}
}
