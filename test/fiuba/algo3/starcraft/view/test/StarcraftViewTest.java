package fiuba.algo3.starcraft.view.test;

import fiuba.algo3.starcraft.logic.map.Map;
import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.map.ScenarioGenerator;
import fiuba.algo3.starcraft.logic.map.areas.LandType;
import fiuba.algo3.starcraft.logic.map.resources.ReservoirType;
import fiuba.algo3.starcraft.view.MapView;
import fiuba.algo3.starcraft.view.StarcraftView;

public class StarcraftViewTest {

	public static void main(String[] args) {
		StarcraftView starcraftView = new StarcraftView();
		Map map = new Map(1500, null);
		starcraftView.setVisible(true);
		ScenarioGenerator scenario = new ScenarioGenerator(map);
		scenario.assignSurfaceDistributionInRect(ReservoirType.volcano,new Point(0,0) , 1500, 0.3);
		scenario.assignSurfaceDistributionInRect(LandType.air, new Point(0,0), 1500, 0.2);

		MapView mapView = new MapView(map);
		
		starcraftView.setMapView(mapView);
		
		starcraftView.setVisible(true);
	}
}
