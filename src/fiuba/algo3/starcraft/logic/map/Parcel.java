package fiuba.algo3.starcraft.logic.map;

public class Parcel {
	private Point origin;
	private double side;
	
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
	
	public boolean containsPoint(Point point) {
		boolean isInXRange = (point.getX() >= origin.getX()) && (point.getX() <= side + origin.getX());
		boolean isInYRange = (point.getY() >= origin.getY()) && (point.getY() <= side + origin.getY());
		return isInXRange && isInYRange;
	}
}
