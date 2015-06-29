package fiuba.algo3.starcraft.logic.map;

import fiuba.algo3.starcraft.game.ActionID;
import fiuba.algo3.starcraft.game.Actionable;
import fiuba.algo3.starcraft.game.Drawable;
import fiuba.algo3.starcraft.logic.map.areas.Air;
import fiuba.algo3.starcraft.logic.map.areas.Land;
import fiuba.algo3.starcraft.logic.map.areas.Surface;
import fiuba.algo3.starcraft.logic.map.resources.ReservoirType;
import fiuba.algo3.starcraft.logic.structures.Structure;
import fiuba.algo3.starcraft.logic.units.Unit;
import fiuba.algo3.starcraft.view.DrawableView;

public class Parcel implements Actionable, Drawable{
	
	private Point origin;
	private double side;
	private Structure structure;
	private DrawableView drawableView;
	private Surface surface = new Land();
	
	public Parcel(Point origin, double side) {
		this.origin = origin;
		this.side = side;
	}
	
	public Point getOrigin() {
		return origin;
	}

	public void setOrigin(Point origin) {
		this.origin = origin;
	}
	
	public void setStructure(Structure structure) {
		this.structure = structure;
		
		setDrawableView(drawableView);
	}
	
	public void setAirSurface() {
		surface = new Air();
	}
	
	public void setReservoir(ReservoirType reservoir) {
		surface = new Land(reservoir);
	}
	
	public boolean containsPoint(Point point) {
		boolean isInXRange = (point.getX() >= origin.getX()) && (point.getX() <= side + origin.getX());
		boolean isInYRange = (point.getY() >= origin.getY()) && (point.getY() <= side + origin.getY());
		return isInXRange && isInYRange;
	}
	
	public boolean letPass(Unit unit) {
		return (surface.letPass(unit) && (structure == null));
	}
	
	public Surface getLandForExplotation() {
		return surface;
	}

	public Structure getStructure() {
		return structure;
	}

	public Iterable<ActionID> getActions() {
		if (structure != null) {
			return this.structure.getActions();
		}
		return this.getLandForExplotation().getActions();
	}

	@Override
	public void setDrawableView(DrawableView drawableView) {
		this.drawableView = drawableView;
		
		if (structure != null) {
			this.structure.setDrawableView(drawableView);
		}else {
			this.getLandForExplotation().setDrawableView(drawableView);
		}
	}
}
