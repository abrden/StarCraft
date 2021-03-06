package fiuba.algo3.starcraft.logic.test.templates.qualities;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.templates.qualities.Alucinacion;
import fiuba.algo3.starcraft.logic.templates.units.protoss.DragonTemplate;
import fiuba.algo3.starcraft.logic.templates.units.protoss.ZealotTemplate;
import fiuba.algo3.starcraft.logic.units.Clone;
import fiuba.algo3.starcraft.logic.units.MuggleUnit;
import fiuba.algo3.starcraft.logic.units.Unit;

public class AlucinacionTest {

	Point position = new Point(1,1);
	
	@Test
	public void testAlucinacionIsntOverUntilClonIsDead() {
		Alucinacion power = new Alucinacion();
		List<Unit> affected = new LinkedList<Unit>();
		MuggleUnit zealot = new ZealotTemplate().create(position);
		affected.add(zealot);
		
		power.lockUnits(affected);
		power.activate();
		power.execute();
		
		assertTrue(!power.itsFinished());
	}

	@Test
	public void testAlucinacionIsOverIfClonIsDead() {
		Alucinacion power = new Alucinacion();
		List<Unit> affected = new LinkedList<Unit>();
		MuggleUnit zealot = new ZealotTemplate().create(position);
		affected.add(zealot);
		power.lockUnits(affected);
		power.activate();
		power.execute();
		
		Iterator<Unit> clones = power.getClones().iterator();
		Unit clone = clones.next();
		Unit clone2 = clones.next();
		assertTrue(clone != clone2);
		
		clone.reduceLife(10000000);
		clone2.reduceLife(10000000);
		
		assertTrue(power.itsFinished());
	}
	
	@Test
	public void testAlucinacionGeneratesAClone() {
		Alucinacion power = new Alucinacion();
		List<Unit> affected = new LinkedList<Unit>();
		MuggleUnit zealot = new ZealotTemplate().create(position);
		affected.add(zealot);
		power.lockUnits(affected);
		power.activate();
		power.execute();
		
		assertEquals(power.getClones().iterator().next().getClass(), Clone.class);
	}
	
	@Test
	public void testAlucinacionGeneratesCloneWithDragonSpecs() {
		Alucinacion power = new Alucinacion();
		List<Unit> affected = new LinkedList<Unit>();
		MuggleUnit dragon = new DragonTemplate().create(position);
		affected.add(dragon);
		power.lockUnits(affected);
		power.activate();
		power.execute();
		
		Unit clone = power.getClones().iterator().next();
		
		assertEquals(clone.getName(), "Dragon");
		assertEquals(clone.getShield(), 80);
		assertEquals(clone.getStepsPerTurn(), 230);
		assertEquals(clone.getVision(), 800);
	}
	
	@Test
	public void testAlucinacionGeneratesCloneWithNoHealth() {
		Alucinacion power = new Alucinacion();
		List<Unit> affected = new LinkedList<Unit>();
		MuggleUnit dragon = new DragonTemplate().create(position);
		affected.add(dragon);
		power.lockUnits(affected);
		power.activate();
		power.execute();
		
		Unit clone = power.getClones().iterator().next();
		
		assertEquals(clone.getHealth(), 0);
		}
	
	@Test
	public void testAlucinacionGeneratesCloneWithNoDamage() {
		Alucinacion power = new Alucinacion();
		List<Unit> affected = new LinkedList<Unit>();
		MuggleUnit dragon = new DragonTemplate().create(position);
		affected.add(dragon);
		power.lockUnits(affected);
		power.activate();
		power.execute();
		
		Clone clone = (Clone) power.getClones().iterator().next();
		
		assertEquals(clone.getAttackLandDamage(), 0);
		assertEquals(clone.getAttackSpaceDamage(), 0);
		}
	
}
