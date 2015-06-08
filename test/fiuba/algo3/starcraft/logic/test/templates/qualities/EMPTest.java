package fiuba.algo3.starcraft.logic.test.templates.qualities;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import fiuba.algo3.starcraft.logic.templates.qualities.EMP;
import fiuba.algo3.starcraft.logic.templates.units.protoss.AltoTemplarioTemplate;
import fiuba.algo3.starcraft.logic.templates.units.protoss.ScoutTemplate;
import fiuba.algo3.starcraft.logic.templates.units.protoss.ZealotTemplate;
import fiuba.algo3.starcraft.logic.units.MagicalUnit;
import fiuba.algo3.starcraft.logic.units.MuggleUnit;
import fiuba.algo3.starcraft.logic.units.Unit;
import fiuba.algo3.starcraft.logic.units.exceptions.InsufficientEnergy;

public class EMPTest {

	@Test
	public void testEMPisntFinishedUntilActivatingAndExecuting() {
		MuggleUnit zealot = ZealotTemplate.getInstance().create(null);
		MuggleUnit scout = ScoutTemplate.getInstance().create(null);
		MagicalUnit templario = AltoTemplarioTemplate.getInstance().create(null);
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
		MuggleUnit zealot = ZealotTemplate.getInstance().create(null);
		MuggleUnit scout = ScoutTemplate.getInstance().create(null);
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
	public void testEMPDrainsEnergyOfProtossMagicalUnits() throws InsufficientEnergy {
		MagicalUnit templario1 = AltoTemplarioTemplate.getInstance().create(null);
		List<Unit> affected = new LinkedList<Unit>();
		
		for(int i = 0; i < 4; i++) templario1.update();
		
		affected.add(templario1);
		
		EMP emp = new EMP();
		emp.lockUnits(affected);
		emp.activate();
		emp.execute();
		
		assertTrue(emp.itsFinished());
		templario1.usePowerWithName("Alucinacion");
	}
}
