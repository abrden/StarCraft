package fiuba.algo3.starcraft.logic.map;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.starcraft.game.ActionID;
import fiuba.algo3.starcraft.game.Actionable;
import fiuba.algo3.starcraft.logic.map.areas.Air;
import fiuba.algo3.starcraft.logic.map.areas.Land;
import fiuba.algo3.starcraft.logic.map.areas.Surface;
import fiuba.algo3.starcraft.logic.map.resources.ReservoirType;
import fiuba.algo3.starcraft.logic.structures.Structure;
import fiuba.algo3.starcraft.logic.units.Unit;

public class Parcel implements Actionable {
	
	private Point origin;
	private double side;
	private Structure structure;
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
		List<ActionID> actions = new ArrayList<ActionID>();
		actions.add(ActionID.build);
		return actions;
	}
}
