package fiuba.algo3.starcraft.view;

import java.awt.Canvas;

import fiuba.algo3.starcraft.logic.map.Parcel;

public class ParcelView extends Canvas{
	
	private static final long serialVersionUID = 1L;
	Parcel parcel;
	
	public ParcelView(Parcel parcel) {
		this.parcel = parcel;
	}
}
