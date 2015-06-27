package fiuba.algo3.starcraft.view;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JComponent;
import fiuba.algo3.starcraft.logic.map.Map;
import fiuba.algo3.starcraft.logic.map.Parcel;
import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.units.Unit;

public class MapView extends JComponent{
	
	private static final long serialVersionUID = 1L;
	
	Map map;
	ArrayList<ParcelView> parcelViews = new ArrayList<ParcelView>();
	ArrayList<UnitView> unitViews = new ArrayList<UnitView>();
	
	
	public MapView(Map map, ActionsView actionsView) {
		this.map = map;
		
		setBounds(0, 0, (int)map.getSide(), (int)map.getSide());
		generatParcelViews(map.getParcelsContainedInARect(new Point(0,0),map.getSide()), actionsView);
		setBackground(new Color(0,0,0));
	}
	
	private void generatParcelViews(ArrayList<Parcel> parcels, ActionsView actionsView) {
		parcelViews.removeAll(parcelViews);
		for (Parcel parcel : parcels) {
			ParcelView parcelView = new ParcelView(parcel, actionsView);
			addMouseListener(parcelView);
			add(parcelView);
			parcelViews.add(parcelView);
		}
	}
	
	private void updateParcelViews() {
		for (ParcelView parcelView : parcelViews) {
			//addMouseListener(parcelView);
			add(parcelView);
		}
	}
	
	private void updateUnitViews() {
		for (UnitView unitView : unitViews) {
			add(unitView);
		}
	}
	
	public void addUnitToMap(Unit unit) {
		this.removeAll();
		UnitView unitView = new UnitView(unit);
		unitViews.add(unitView);
		//addMouseListener(unitView);
		updateUnitViews();
		updateParcelViews();
	}
}