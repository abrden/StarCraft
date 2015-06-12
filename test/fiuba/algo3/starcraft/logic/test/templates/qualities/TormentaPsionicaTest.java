package fiuba.algo3.starcraft.logic.test.templates.qualities;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import fiuba.algo3.starcraft.logic.templates.qualities.TormentaPsionica;
import fiuba.algo3.starcraft.logic.templates.units.protoss.AltoTemplarioTemplate;
import fiuba.algo3.starcraft.logic.templates.units.protoss.ScoutTemplate;
import fiuba.algo3.starcraft.logic.templates.units.protoss.ZealotTemplate;
import fiuba.algo3.starcraft.logic.templates.units.terran.GolliatTemplate;
import fiuba.algo3.starcraft.logic.templates.units.terran.MarineTemplate;
import fiuba.algo3.starcraft.logic.templates.units.terran.NaveCienciaTemplate;
import fiuba.algo3.starcraft.logic.units.MagicalUnit;
import fiuba.algo3.starcraft.logic.units.MuggleUnit;
import fiuba.algo3.starcraft.logic.units.Unit;

public class TormentaPsionicaTest {

	@Test
	public void testTormentaIsntFinishedUntilItExecutes2Times() {
		MuggleUnit zealot = new ZealotTemplate().create(null);
		MuggleUnit scout = new ScoutTemplate().create(null);
		MagicalUnit templario = new AltoTemplarioTemplate().create(null);
		List<Unit> affected = new LinkedList<Unit>();
		affected.add(zealot);
		affected.add(scout);
		affected.add(templario);
		
		TormentaPsionica tormenta = new TormentaPsionica();
		tormenta.lockUnits(affected);
		tormenta.activate();
		tormenta.execute();
		
		assertTrue(!tormenta.itsFinished());
	}

	@Test
	public void testTormentaIsFinishedIfItExecutes2Times() {
		MuggleUnit zealot = new ZealotTemplate().create(null);
		MuggleUnit scout = new ScoutTemplate().create(null);
		MagicalUnit templario = new AltoTemplarioTemplate().create(null);
		List<Unit> affected = new LinkedList<Unit>();
		affected.add(zealot);
		affected.add(scout);
		affected.add(templario);
		
		TormentaPsionica tormenta = new TormentaPsionica();
		tormenta.lockUnits(affected);
		tormenta.activate();
		tormenta.execute();
		tormenta.execute();
		
		assertTrue(tormenta.itsFinished());
	}
	
	@Test
	public void testTormentaReducesLifeOfAffectedUnitsBy50Execution() {
		MuggleUnit marine = new MarineTemplate().create(null);
		MuggleUnit golliat = new GolliatTemplate().create(null);
		MagicalUnit nave = new NaveCienciaTemplate().create(null);
		List<Unit> affected = new LinkedList<Unit>();
		affected.add(marine);
		affected.add(nave);
		affected.add(golliat);
		assertEquals(marine.getHealth(), 40);
		assertEquals(golliat.getHealth(), 125);
		assertEquals(nave.getHealth(), 200);
		
		TormentaPsionica tormenta = new TormentaPsionica();
		tormenta.lockUnits(affected);
		tormenta.activate();
		tormenta.execute();
		
		assertEquals(marine.getHealth(), -10);
		assertEquals(nave.getHealth(), 150);
		assertEquals(golliat.getHealth(), 75);
	}

}
