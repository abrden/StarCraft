package fiuba.algo3.starcraft.view;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;

import fiuba.algo3.starcraft.logic.map.Map;
import fiuba.algo3.starcraft.logic.map.Parcel;
import fiuba.algo3.starcraft.logic.map.Point;

public class MapView extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	Map map;
	
	public MapView(Map map) {
		this.map = map;
//		generatParcelViews(map.getParcelsContainedInARect(new Point(0,0),map.getSide()));
		setBackground(new Color(0,255,0));
	}
	
	//TODO implement method
	private void generatParcelViews(ArrayList<Parcel> parcels) {
		
	}
}