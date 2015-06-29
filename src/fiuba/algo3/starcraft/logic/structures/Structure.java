package fiuba.algo3.starcraft.logic.structures;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.starcraft.game.ActionID;
import fiuba.algo3.starcraft.game.Actionable;
import fiuba.algo3.starcraft.game.Drawable;
import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.map.resources.ExtractableType;
import fiuba.algo3.starcraft.logic.player.Player;
import fiuba.algo3.starcraft.logic.player.Updatable;
import fiuba.algo3.starcraft.logic.templates.qualities.Life;
import fiuba.algo3.starcraft.view.DrawableView;

public abstract class Structure implements Updatable, Actionable, Drawable {
	
	protected Point position;
	protected Life life;
	protected String name;
	
	Structure(String name, Life life, Point position) {
		if (position == null) throw new InvalidParameterException();
		this.name = name;
		this.life = life;
		this.position = position;
	}
	
	public boolean itsAlive() {
		return (life.getHealth() > 0);
	}
	
	public void reduceLife(int damage) {
		life.reduce(damage);
	}

	public String getName(){
		return this.name;
	}

	public int getPopulationQuotaIncrement() {
		return 0;
	}
	
	public void getResources(Player player) {
		return;
	}
	
	public boolean iCanBeBuiltOnTopOf(ExtractableType resource) {
		return true;
	}
	
	public Point getPosition() {
		return position;
	}
	
	public Iterable<ActionID> getActions() {
		List<ActionID> actions = new ArrayList<ActionID>();
		return actions;
	}

	public void setDrawableView(DrawableView drawableView) {
		System.out.println(name);
		drawableView.setImageName(name.concat("jpg"));
	}
}
