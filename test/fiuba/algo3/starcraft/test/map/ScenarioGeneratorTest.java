package fiuba.algo3.starcraft.test.map;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import fiuba.algo3.starcraft.logic.map.ExtractableType;
import fiuba.algo3.starcraft.logic.map.Map;
import fiuba.algo3.starcraft.logic.map.NoResourcesToExtractException;
import fiuba.algo3.starcraft.logic.map.Parcel;
import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.map.ScenarioGenerator;

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
			} catch (NoResourcesToExtractException e) {
				
			}
		}
		assertTrue(ammountOfVolcanoInMap == 100);
	}
	/*
	@Test
	public void testScenarioIsBuiltWithTwoBuildingsMineralsAndAnIsland() {
		
	}
	*/
	
	
	

}
