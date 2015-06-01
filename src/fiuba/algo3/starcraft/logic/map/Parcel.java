package fiuba.algo3.starcraft.logic.map;

import fiuba.algo3.starcraft.logic.structures.Structure;
import fiuba.algo3.starcraft.logic.units.Transportable;

public class Parcel {
	
	private Point origin;
	private double side;
	private Structure structure;
	private Surface surface;
	
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
	}
	
	public void setSurface(LandType landType) {
		switch (landType) {
		case air : surface = new Air();
		case land : surface = new Land();
		}
	}
	
	public boolean containsPoint(Point point) {
		boolean isInXRange = (point.getX() >= origin.getX()) && (point.getX() <= side + origin.getX());
		boolean isInYRange = (point.getY() >= origin.getY()) && (point.getY() <= side + origin.getY());
		return isInXRange && isInYRange;
	}
	
	public boolean canPassThrough(Transportable unit) {
		return surface.canPassThrough(unit) && (structure == null || surface.canPassThrough(unit));
	}
}
