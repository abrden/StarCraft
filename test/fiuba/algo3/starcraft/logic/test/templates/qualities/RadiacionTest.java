package fiuba.algo3.starcraft.logic.test.templates.qualities;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import fiuba.algo3.starcraft.logic.templates.qualities.Radiacion;
import fiuba.algo3.starcraft.logic.templates.units.protoss.AltoTemplarioTemplate;
import fiuba.algo3.starcraft.logic.templates.units.protoss.ScoutTemplate;
import fiuba.algo3.starcraft.logic.templates.units.protoss.ZealotTemplate;
import fiuba.algo3.starcraft.logic.units.MagicalUnit;
import fiuba.algo3.starcraft.logic.units.MuggleUnit;
import fiuba.algo3.starcraft.logic.units.Unit;

public class RadiacionTest {

	@Test
	public void testRadiacionisntFinishedUntilTargetIsDead() {
		MuggleUnit zealot = new ZealotTemplate().create(null);
		MuggleUnit scout = new ScoutTemplate().create(null);
		MagicalUnit templario = new AltoTemplarioTemplate().create(null);
		List<Unit> affected = new LinkedList<Unit>();
		affected.add(zealot);
		affected.add(scout);
		affected.add(templario);
		
		Radiacion radiacion = new Radiacion();
		radiacion.lockUnits(affected);
		radiacion.activate();
		radiacion.execute();
		
		scout.reduceLife(1000000);
		templario.reduceLife(1000000);
		assertTrue(zealot.itsAlive());
		assertTrue(!radiacion.itsFinished());
	}

	@Test
	public void testRadiacionReducesLifeOfAffectedUnitsBy40PerTurn() {
		MuggleUnit zealot = new ZealotTemplate().create(null);
		MuggleUnit scout = new ScoutTemplate().create(null);
		MagicalUnit templario = new AltoTemplarioTemplate().create(null);
		List<Unit> affected = new LinkedList<Unit>();
		affected.add(zealot);
		affected.add(scout);
		affected.add(templario);
		assertEquals(scout.getHealth() + scout.getShield(), 250);
		assertEquals(zealot.getHealth() + zealot.getShield(), 160);
		assertEquals(templario.getHealth() + templario.getShield(), 80);
		
		Radiacion radiacion = new Radiacion();
		radiacion.lockUnits(affected);
		radiacion.activate();
		radiacion.execute();
		
		assertEquals(templario.getHealth() + templario.getShield(), 40);
		assertEquals(scout.getHealth() + scout.getShield(), 210);
		assertEquals(zealot.getHealth() + zealot.getShield(), 120);
		}

}
