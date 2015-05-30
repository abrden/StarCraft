package fiuba.algo3.starcraft.logic.map;
import java.lang.Math;

public class Point {
	
	private double x;
	private double y;
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}
	
	public double distance(Point otherPoint) {
		double deltaX = this.x - otherPoint.getX();
		double deltaY = this.y - otherPoint.getY();
		
		return Math.sqrt((deltaX * deltaX) + (deltaY * deltaY));
	}
}
