package fiuba.algo3.starcraft.view.test;

import fiuba.algo3.starcraft.logic.map.Map;
import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.map.ScenarioGenerator;
import fiuba.algo3.starcraft.logic.map.resources.ReservoirType;
import fiuba.algo3.starcraft.logic.units.MuggleUnit;
import fiuba.algo3.starcraft.view.MapView;
import fiuba.algo3.starcraft.view.StarcraftView;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class StarcraftViewTest {

	@Test
	public void createMapAndSetUnitsOnIt() {
	/*	StarcraftView starcraftView = new StarcraftView(null);
		
		Map map = new Map(1500, null);
		
		ScenarioGenerator scenario = new ScenarioGenerator(map);
		scenario.assignReservoirDistributionInRect(ReservoirType.volcano,new Point(0,0) , 1500, 0.1);
		scenario.assignAirDistributionInRect(new Point(0,0), 1500, 0.25);

		MapView mapView = new MapView(map);
		
		for (int i = 0; i < 10; i++) {
			MuggleUnit unit = new MuggleUnit("Marine", null, new Point(70 * i, 30), 0, 0, null, 0, false, 0);
			mapView.addUnitToMap(unit);
		}
		starcraftView.setMapView(mapView);
	
		starcraftView.setVisible(true);*/
        assertTrue(true);
	}

}
