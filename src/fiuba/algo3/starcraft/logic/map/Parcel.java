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
		break;
		case land : surface = new Land();
		break;
		}
	}
	
	
	
	public void setSurface(ExtractableType extractableType) {
		surface = new Land(extractableType);
	}
	
	
	public boolean containsPoint(Point point) {
		boolean isInXRange = (point.getX() >= origin.getX()) && (point.getX() <= side + origin.getX());
		boolean isInYRange = (point.getY() >= origin.getY()) && (point.getY() <= side + origin.getY());
		return isInXRange && isInYRange;
	}
	
	public boolean letPass(Transportable unit) {
		//FIXME: Try to avoid if {} else {} blocks
		if (unit.canFly()) {
			return true;
		} else {
			return surface.letPass(unit) && (structure == null);
		}
	}
	public Surface getLandForExplotation() {
		return surface;
	}
}
