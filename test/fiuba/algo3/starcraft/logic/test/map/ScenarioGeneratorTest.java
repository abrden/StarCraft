package fiuba.algo3.starcraft.logic.test.map;

import static org.junit.Assert.*;

import java.util.ArrayList;

import fiuba.algo3.starcraft.logic.units.MuggleUnit;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.starcraft.logic.map.Map;
import fiuba.algo3.starcraft.logic.map.Parcel;
import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.map.ScenarioGenerator;
import fiuba.algo3.starcraft.logic.map.exceptions.NoResourcesToExtract;
import fiuba.algo3.starcraft.logic.map.resources.ReservoirType;
import fiuba.algo3.starcraft.logic.templates.units.terran.MarineTemplate;
public class ScenarioGeneratorTest {

	Map map;
	ScenarioGenerator scenario;

	@Before
	public void before() {
		map = new Map(1000, null);
		scenario = new ScenarioGenerator(map);
	}

	@Test	//FIXME :ammountOfVolcanoInMap no tendria que ser un valor random cuando se usa una densidad != a 1.
	public void testScenarioGenerateRandomDistributionOfMineralsInARect() {

		scenario.assignReservoirDistributionInRect(ReservoirType.volcano, new Point(0,0), 100, 1);
11		
		int ammountOfVolcanoInMap = 0;
		ArrayList<Parcel> parcelsInRect = map.getParcelsContainedInARect(new Point(0,0), 1000);
		
		for (Parcel parcel : parcelsInRect) {
			try {
				parcel.getLandForExplotation().extractResource();
				ammountOfVolcanoInMap ++;
			} catch (NoResourcesToExtract e) {
				
			}
		}
		assertTrue(ammountOfVolcanoInMap == 100);
	}
	
	@Test
	public void testScenarioIsBuiltWithTwoBuildingsMineralsAndAnIsland() {
		
		scenario.assignReservoirDistributionInRect(ReservoirType.volcano, new Point(0,0), 1000, 0.2);
		
		scenario.assignReservoirDistributionInRect(ReservoirType.volcano, new Point(0,0), 30, 0.8);
		//Player player1 = new Player(null, null, null, new Point(10,10), null, map);
		
		scenario.assignReservoirDistributionInRect(ReservoirType.volcano, new Point(970,970), 30, 0.8);

		//Player player2 = new Player(null, null, null, new Point(990,990), null, map);

		for (int i = 0 ; i < 1000/30 ; i++) {
			scenario.assignAirDistributionInRect(new Point(485, 30 * i),30, 1);
		}
		Parcel parcel = map.getParcelContainingPoint(new Point(400,400));

		MuggleUnit marine = new MarineTemplate().create(new Point(1, 1));
		
		assertTrue(!parcel.letPass(marine));
	}
}
