package fiuba.algo3.starcraft.logic.units;

import java.awt.*;
import java.security.InvalidParameterException;

import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.player.Updatable;
import fiuba.algo3.starcraft.logic.templates.qualities.*;
import fiuba.algo3.starcraft.view.DrawableView;
import fiuba.algo3.starcraft.view.MapView;
import fiuba.algo3.starcraft.game.ActionID;
import fiuba.algo3.starcraft.game.Actionable;
import fiuba.algo3.starcraft.game.Drawable;

public abstract class Unit implements Updatable, Drawable, Actionable {
	
	protected final String name;
	protected final int vision;
	protected final int populationQuota;
	protected final Life life;
	protected Point position;
    protected Point destination;
	protected final int stepsPerTurn;
    protected Color color;
	
    Unit(String name, Life life, Point position, int vision, int stepsPerTurn, int populationQuota) {
		if (position == null) throw new InvalidParameterException();
		this.name = name;
		this.life = life;
		this.position = position;
        this.destination = position;
		this.vision = vision;
		this.stepsPerTurn = stepsPerTurn;
		this.populationQuota = populationQuota;
        this.color = Color.black;
	}
    
    public void addToMapView(MapView mapView) {
    	mapView.addUnitToMap(this);
    }
	
	public void reduceLife(int damage) {
		life.reduce(damage);
	}

	public boolean itsAlive() {
		return (life.getHealth() > 0);
	}

	public int getStepsPerTurn() {
		return stepsPerTurn;
	}
	
	public int getPopulationQuota() {
		return populationQuota;
	}
	
	public String getName() {
		return name;
	}
	
	public int getVision() {
		return vision;
	}
	
	public int getShield() {
		return life.getShield();
	}

	public int getHealth() {
		return life.getHealth();
	}

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }

	public void setPosition(Point destination) {
		this.position = destination;
	}

    public void setDestination(Point destination) {
        this.destination = destination;
    }
	
	public abstract void update();

    public abstract boolean canFly();

	public Point getPosition() {
		return position;
	}

    public Point getDestination() {
        return destination;
    }

	public void executeTormentaPsionica() {
		this.reduceLife(TormentaPsionica.DAMAGE);
	}

	public abstract void executeEMP();

	public void executeRadiacion() {
		this.reduceLife(Radiacion.DAMAGE);
	}

	public abstract Iterable<ActionID> getActions();

	public Attack getAttack() {
		return null;
	}

	public boolean canCarryOtherUnits() {
		return false;
	}

	public int getMaximumHealth() {
		return life.getMaximumHealth();
	}

	public int getMaximumShield() {
		return life.getMaximumShield();
	}
	
	public void setDrawableView(DrawableView drawableView) {
		drawableView.setImageName("UnitView/".concat((this.getName().concat(".png"))));
	}
	
	public boolean hasOwner() {
		return true;
	}
}
