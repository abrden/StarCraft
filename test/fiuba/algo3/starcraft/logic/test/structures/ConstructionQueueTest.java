package fiuba.algo3.starcraft.logic.test.structures;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.structures.Construction;
import fiuba.algo3.starcraft.logic.structures.ConstructionQueue;
import fiuba.algo3.starcraft.logic.structures.Depot;
import fiuba.algo3.starcraft.logic.structures.Structure;
import fiuba.algo3.starcraft.logic.units.MuggleUnit;
import fiuba.algo3.starcraft.logic.units.Unit;

public class ConstructionQueueTest {

	@Test
	public void testConstructionQueueUpdateLowersTheReleaseOfConstructionsUntilFinished() {
		ConstructionQueue queue = new ConstructionQueue();
		queue.addStructure(new Construction<Structure>(new Depot(null, null, new Point(500,500)), 5));
		queue.addUnit(new Construction<Unit>(new MuggleUnit(null, null, new Point(500,500), 0, 0, null, 0, false, 1), 5));
		//TODO: Completar
	}

	@Test
	public void testConstructionQueueUpdateGivesStructureWhenFinished() {
		ConstructionQueue queue = new ConstructionQueue();
		queue.addStructure(new Construction<Structure>(new Depot(null, null, new Point(500,500)), 5));
		//TODO: Completar
	}
	
	@Test
	public void testConstructionQueueUpdateGivesUnitWhenFinished() {
		ConstructionQueue queue = new ConstructionQueue();
		queue.addUnit(new Construction<Unit>(new MuggleUnit(null, null, new Point(500,500), 0, 0, null, 0, false, 1), 5));
		//TODO: Completar
	}
}
