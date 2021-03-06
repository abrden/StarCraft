package fiuba.algo3.starcraft.logic.test.templates.qualities;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.templates.qualities.EMP;
import fiuba.algo3.starcraft.logic.templates.units.protoss.AltoTemplarioTemplate;
import fiuba.algo3.starcraft.logic.templates.units.protoss.ScoutTemplate;
import fiuba.algo3.starcraft.logic.templates.units.protoss.ZealotTemplate;
import fiuba.algo3.starcraft.logic.units.MagicalUnit;
import fiuba.algo3.starcraft.logic.units.MuggleUnit;
import fiuba.algo3.starcraft.logic.units.Unit;
import fiuba.algo3.starcraft.logic.units.exceptions.InsufficientEnergy;
import fiuba.algo3.starcraft.logic.units.exceptions.NonexistentPower;

public class EMPTest {

	Point position = new Point(1,1);
	
	@Test
	public void testEMPisntFinishedUntilActivatingAndExecuting() {
		MuggleUnit zealot = new ZealotTemplate().create(position);
		MuggleUnit scout = new ScoutTemplate().create(position);
		MagicalUnit templario = new AltoTemplarioTemplate().create(position);
		List<Unit> affected = new LinkedList<Unit>();
		affected.add(zealot);
		affected.add(scout);
		affected.add(templario);
		
		EMP emp = new EMP();
		emp.lockUnits(affected);
		
		assertTrue(!emp.itsFinished());
	}

	@Test
	public void testEMPDestroysShieldOfProtossMuggleUnits() {
		MuggleUnit zealot = new ZealotTemplate().create(position);
		MuggleUnit scout = new ScoutTemplate().create(position);
		List<Unit> affected = new LinkedList<Unit>();
		assertEquals(scout.getShield(), 100);
		assertEquals(zealot.getShield(), 60);
		
		affected.add(zealot);
		affected.add(scout);
		
		EMP emp = new EMP();
		emp.lockUnits(affected);
		emp.activate();
		emp.execute();
		
		assertTrue(emp.itsFinished());
		assertEquals(scout.getShield(), 0);
		assertEquals(zealot.getShield(), 0);
		}
	
	@Test(expected = InsufficientEnergy.class)
	public void testEMPDrainsEnergyOfProtossMagicalUnits() throws InsufficientEnergy, NonexistentPower {
		MagicalUnit templario1 = new AltoTemplarioTemplate().create(position);
		List<Unit> affected = new LinkedList<Unit>();
		
		for(int i = 0; i < 4; i++) templario1.update();
		
		affected.add(templario1);
		
		EMP emp = new EMP();
		emp.lockUnits(affected);
		emp.activate();
		emp.execute();
		
		assertTrue(emp.itsFinished());
		templario1.usePower("Alucinacion");
	}
}
