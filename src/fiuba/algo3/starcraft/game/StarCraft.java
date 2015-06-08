package fiuba.algo3.starcraft.game;

import java.util.Collection;

import fiuba.algo3.starcraft.logic.map.Map;
import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.player.Player;
import fiuba.algo3.starcraft.logic.units.Unit;

public class StarCraft {

	public static StarCraft instance = new StarCraft();
	
	private Map map;
	private Player player1;
	private Player player2;
	
	public static void start() {
		// TODO Implementar
	}

	public static void main(String[] args) {
		start();
	}

	public static StarCraft getInstance() {
		return instance;
	}

	public Collection<Unit> unitsInCircumference(Point position, int range) {
		// TODO a implementar
		return null;
	}

}
