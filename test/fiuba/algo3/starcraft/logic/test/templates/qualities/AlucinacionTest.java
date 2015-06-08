package fiuba.algo3.starcraft.logic.test.templates.qualities;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import fiuba.algo3.starcraft.logic.templates.qualities.Alucinacion;
import fiuba.algo3.starcraft.logic.templates.units.protoss.ZealotTemplate;
import fiuba.algo3.starcraft.logic.units.Unit;

public class AlucinacionTest {

	@Test
	public void testAlucinacionIsntOverUntilClonIsDead() {
		Alucinacion power = new Alucinacion();
		List<Unit> affected = new LinkedList<Unit>();
		Unit zealot = ZealotTemplate.getInstance().create(null);
		affected.add(zealot);
		
		power.lockUnits(affected);
		power.activate();
		
		assertEquals(power.itsFinished(), false);
	}

}
