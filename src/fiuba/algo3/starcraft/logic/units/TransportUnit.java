package fiuba.algo3.starcraft.logic.units;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import fiuba.algo3.starcraft.game.ActionID;
import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.templates.qualities.Life;
import fiuba.algo3.starcraft.logic.units.exceptions.NoMoreSpaceInUnit;
import fiuba.algo3.starcraft.logic.units.exceptions.NoUnitToRemove;
import fiuba.algo3.starcraft.logic.units.exceptions.StepsLimitExceeded;
import fiuba.algo3.starcraft.view.DrawableView;

public class TransportUnit extends Unit {
	
	private final Collection<Transportable> passengers;
	private final int capacity;

	public TransportUnit(String name, Life life, Point position, int vision, int stepsPerTurn, int populationQuota, int capacity) {
		super(name, life, position, vision, stepsPerTurn, populationQuota);
		passengers = new LinkedList<Transportable>();
		this.capacity = capacity;
	}
		
	public void embark(Transportable unit) throws NoMoreSpaceInUnit, StepsLimitExceeded {
		if (this.theresSpaceForPassenger(unit)) {
			passengers.add(unit);
		} else
			throw new NoMoreSpaceInUnit();
	}

	public void disembark(Transportable unit) throws NoUnitToRemove, StepsLimitExceeded {
		if (passengers.size() > 0) {
			passengers.remove(unit);
		} else
			throw new NoUnitToRemove();
	}

	private boolean theresSpaceForPassenger(Transportable unit) {
		return (this.freeSpace() >= unit.getTransportQuota());
	}
	
	public int freeSpace() {
		int spaceTaken = 0;
		for (Transportable unit : passengers)
			spaceTaken = spaceTaken + unit.getTransportQuota();
		return (capacity - spaceTaken);
	}

	public void update() {
		life.regenerateShield();
	}

    @Override
    public boolean canFly() {
        return true;
    }

    public void executeEMP() {
		life.destroyShield();
	}

	public void reduceLife(int damage) {
		life.reduce(damage);
		
		if (!this.itsAlive()) {
			for (Transportable unit : passengers)
				unit.killInFlight();
		}
	}

	public void setDrawableView(DrawableView drawableView) {
		// TODO Auto-generated method stub
		
	}
	
	public Iterable<ActionID> getActions() {
		List<ActionID> actions = new ArrayList<ActionID>();
		actions.add(ActionID.move);
		actions.add(ActionID.disembark);
		return actions;
	}
}
