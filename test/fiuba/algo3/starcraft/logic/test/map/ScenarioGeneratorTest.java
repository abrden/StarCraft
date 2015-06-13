package fiuba.algo3.starcraft.logic.test.map;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import fiuba.algo3.starcraft.logic.map.ExtractableType;
import fiuba.algo3.starcraft.logic.map.LandType;
import fiuba.algo3.starcraft.logic.map.Map;
import fiuba.algo3.starcraft.logic.map.NoResourcesToExtract;
import fiuba.algo3.starcraft.logic.map.Parcel;
import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.map.ScenarioGenerator;
import fiuba.algo3.starcraft.logic.templates.units.terran.MarineTemplate;
import fiuba.algo3.starcraft.logic.units.Transportable;

public class ScenarioGeneratorTest {
	Map map = new Map(1000);
	ScenarioGenerator scenario = new ScenarioGenerator(map);
	@Test	//ammountOfVolcanoInMap no tendria que ser un valor random cuando se usa una densidad != a 1.
	public void testScenarioGenerateRandomDistributionOfMineralsInARect() {
		scenario.assignSurfaceDistributionInRect(ExtractableType.volcano, new Point(0,0), 100, 1);
		
		int ammountOfVolcanoInMap = 0;
		ArrayList<Parcel> parcelsInRect = map.getParcelsContainedInARect(new Point(0,0), 100);
		
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
		map = new Map(1000);
		
		scenario = new ScenarioGenerator(map);
		
		scenario.assignSurfaceDistributionInRect(ExtractableType.volcano, new Point(0,0), 1000, 0.2);
		for (int i = 0 ; i < 1000/30 ; i++) {
			scenario.assignSurfaceDistributionInRect(LandType.air,new Point(485, 30 * i), 30, 1);
		}
		Parcel parcel = map.getParcelContainingPoint(new Point(500,500));

		Transportable marine = new MarineTemplate().create(null);
		
		assertTrue(!parcel.letPass(marine));
	}
}
