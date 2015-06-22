package fiuba.algo3.starcraft.view;

import java.awt.Color;

import fiuba.algo3.starcraft.logic.units.Unit;

public class UnitView extends DrawableView {

	private static final long serialVersionUID = 1L;
	Unit unit;
	
	public UnitView(Unit unit) {
		this.unit = unit;
		unit.setDrawableView(this);
		setBounds((int)unit.getPosition().getX(), (int)unit.getPosition().getY(), 100, 100);
	}	
}
