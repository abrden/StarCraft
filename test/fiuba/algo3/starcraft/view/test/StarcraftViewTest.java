package fiuba.algo3.starcraft.view.test;

import fiuba.algo3.starcraft.logic.map.Map;
import fiuba.algo3.starcraft.view.MapView;
import fiuba.algo3.starcraft.view.StarcraftView;

public class StarcraftViewTest {

	public static void main(String[] args) {
		StarcraftView starcraftView = new StarcraftView();
		Map map = new Map(1000, null);
		MapView mapView = new MapView(map);
		starcraftView.setMapView(mapView);
	}

}
