package fiuba.algo3.starcraft.logic.structures;

import java.security.InvalidParameterException;

import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.player.Player;
import fiuba.algo3.starcraft.logic.player.Updatable;
import fiuba.algo3.starcraft.logic.templates.qualities.Life;

public abstract class Structure implements Updatable {
	
	protected Point position;
	protected Life life;
	protected String name;
	
	Structure(String name, Life life, Point position) {
		//if (position == null) throw new InvalidParameterException();
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
}
