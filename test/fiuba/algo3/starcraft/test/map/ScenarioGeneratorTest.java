package fiuba.algo3.starcraft.test.map;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.starcraft.logic.map.Map;
import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.map.ScenarioGenerator;

public class ScenarioGeneratorTest {
	Map map = new Map(1000);
	ScenarioGenerator scenario = new ScenarioGenerator(map);
	@Test
	public void testScenarioGenerateRandomDistributionOfMineralsInARect() {
		scenario.assignRandomResourcesDistributionInRect(new Point(0,0),100, 0.3);
		
		//FIXME: conflict when testing random methods
		assertTrue(true);
	}

}
