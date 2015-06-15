package fiuba.algo3.starcraft.logic.test.units;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.templates.qualities.Cloner;
import fiuba.algo3.starcraft.logic.templates.qualities.Power;
import fiuba.algo3.starcraft.logic.templates.units.protoss.AltoTemplarioTemplate;
import fiuba.algo3.starcraft.logic.templates.units.protoss.DragonTemplate;
import fiuba.algo3.starcraft.logic.templates.units.terran.GolliatTemplate;
import fiuba.algo3.starcraft.logic.templates.units.terran.MarineTemplate;
import fiuba.algo3.starcraft.logic.units.Clone;
import fiuba.algo3.starcraft.logic.units.MagicalUnit;
import fiuba.algo3.starcraft.logic.units.MuggleUnit;
import fiuba.algo3.starcraft.logic.units.Unit;
import fiuba.algo3.starcraft.logic.units.exceptions.InsufficientEnergy;
import fiuba.algo3.starcraft.logic.units.exceptions.NonexistentPower;

public class AltoTemplarioTest {

	@Test
	public void testExecutingTormentaOneTimeLowersHealthBy50() throws InsufficientEnergy, NonexistentPower {
		MagicalUnit templario = new AltoTemplarioTemplate().create(new Point(1, 2));
		// Sumo energia
		templario.update();
		templario.update();
		templario.update();
		templario.update();
		Power tormenta = templario.usePower("Tormenta Psionica");
		MuggleUnit marine = new MarineTemplate().create(new Point(1, 2));
		MuggleUnit golliat = new GolliatTemplate().create(new Point(1, 2));
		int marinesInitialHealth = marine.getHealth();
		int golliatsInitialHealth = golliat.getHealth();
		List<Unit> affected = new LinkedList<Unit>();
		affected.add(marine);
		affected.add(golliat);
		tormenta.lockUnits(affected);
		tormenta.activate();
		
		tormenta.execute();
		
		assertEquals(marinesInitialHealth - 50, marine.getHealth());
		assertEquals(golliatsInitialHealth - 50, golliat.getHealth());
	}

	@Test
	public void testExecutingTormentaTwoTimesLowersHealthBy100() throws InsufficientEnergy, NonexistentPower {
		MagicalUnit templario = new AltoTemplarioTemplate().create(new Point(1, 2));
		// Sumo energia
		templario.update();
		templario.update();
		templario.update();
		templario.update();
		Power tormenta = templario.usePower("Tormenta Psionica");
		MuggleUnit marine = new MarineTemplate().create(new Point(1, 2));
		MuggleUnit golliat = new GolliatTemplate().create(new Point(1, 2));
		int marinesInitialHealth = marine.getHealth();
		int golliatsInitialHealth = golliat.getHealth();
		List<Unit> affected = new LinkedList<Unit>();
		affected.add(marine);
		affected.add(golliat);
		tormenta.lockUnits(affected);
		tormenta.activate();
		
		tormenta.execute();
		tormenta.execute();
		
		assertEquals(marinesInitialHealth - 100, marine.getHealth());
		assertEquals(golliatsInitialHealth - 100, golliat.getHealth());
	}

	@Test
	public void testTormentaItsFinishedAfterTwoExecutions() throws InsufficientEnergy, NonexistentPower {
		MagicalUnit templario = new AltoTemplarioTemplate().create(new Point(1, 2));
		// Sumo energia
		templario.update();
		templario.update();
		templario.update();
		templario.update();
		Power tormenta = templario.usePower("Tormenta Psionica");
		MuggleUnit marine = new MarineTemplate().create(new Point(1, 2));
		MuggleUnit golliat = new GolliatTemplate().create(new Point(1, 2));
		List<Unit> affected = new LinkedList<Unit>();
		affected.add(marine);
		affected.add(golliat);
		tormenta.lockUnits(affected);
		tormenta.activate();
		
		tormenta.execute();
		tormenta.execute();
		
		assertTrue(tormenta.itsFinished());
	}
	
	@Test
	public void testTormentaNOTFinishedAfterOneExecution() throws InsufficientEnergy, NonexistentPower {
		MagicalUnit templario = new AltoTemplarioTemplate().create(new Point(1, 2));
		// Sumo energia
		templario.update();
		templario.update();
		templario.update();
		templario.update();
		Power tormenta = templario.usePower("Tormenta Psionica");
		MuggleUnit marine = new MarineTemplate().create(new Point(1, 2));
		MuggleUnit golliat = new GolliatTemplate().create(new Point(1, 2));
		List<Unit> affected = new LinkedList<Unit>();
		affected.add(marine);
		affected.add(golliat);
		tormenta.lockUnits(affected);
		tormenta.activate();
		
		tormenta.execute();
		
		assertTrue(!tormenta.itsFinished());
	}
	
	@Test
	public void testAlucinacionCreatesClone() throws InsufficientEnergy, NonexistentPower {
		MagicalUnit templario = new AltoTemplarioTemplate().create(new Point(1, 2));
		// Sumo energia
		templario.update();
		templario.update();
		templario.update();
		templario.update();
		Power clonacion = templario.usePower("Alucinacion");
		MuggleUnit dragon = new DragonTemplate().create(new Point(1, 2));
		List<Unit> affected = new LinkedList<Unit>();
		affected.add(dragon);
		clonacion.lockUnits(affected);
		clonacion.activate();
		clonacion.execute();
		
		assertEquals(((Cloner) clonacion).getClones().get(0).getClass(), Clone.class);
		
	}
	
	@Test
	public void testAlucinacionCreatesCloneWith0Health() throws InsufficientEnergy, NonexistentPower {
		MagicalUnit templario = new AltoTemplarioTemplate().create(new Point(1, 2));
		// Sumo energia
		templario.update();
		templario.update();
		templario.update();
		templario.update();
		Power clonacion = templario.usePower("Alucinacion");
		MuggleUnit dragon = new DragonTemplate().create(new Point(1, 2));
		List<Unit> affected = new LinkedList<Unit>();
		affected.add(dragon);
		clonacion.lockUnits(affected);
		clonacion.activate();
		clonacion.execute();
		
		Unit clone = ((Cloner) clonacion).getClones().get(0);
		
		assertEquals(clone.getHealth(), 0);
	}

	@Test
	public void testAlucinacionCreatesCloneWithSameShieldAsUnitCloned() throws InsufficientEnergy, NonexistentPower {
		MagicalUnit templario = new AltoTemplarioTemplate().create(new Point(1, 2));
		// Sumo energia
		templario.update();
		templario.update();
		templario.update();
		templario.update();
		Power clonacion = templario.usePower("Alucinacion");
		MuggleUnit dragon = new DragonTemplate().create(new Point(1, 2));
		List<Unit> affected = new LinkedList<Unit>();
		affected.add(dragon);
		clonacion.lockUnits(affected);
		clonacion.activate();
		clonacion.execute();
		
		Unit clone = ((Cloner) clonacion).getClones().get(0);
		
		assertEquals(clone.getShield(), 80);
	}
}
