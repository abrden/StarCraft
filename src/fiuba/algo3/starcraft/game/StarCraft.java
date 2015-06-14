package fiuba.algo3.starcraft.game;

import java.util.List;

import fiuba.algo3.starcraft.logic.map.Map;
import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.player.Player;
import fiuba.algo3.starcraft.logic.units.Unit;


public class StarCraft {
	public static StarCraft instance = new StarCraft();
	
	private Map map;
	private Player player1;
	private Player player2;
	
	public String toString() {
		return "" + player1 + player2;
	}
	
	public static void start() {
		
	}
	
	public void setPlayer1(Player player) {
		player1 = player;
	}
	
	public void setPlayer2(Player player) {
		player2 = player;
	}
	
	public void setMap(Map map) {
		this.map = map;
	}

	public static void main(String[] args) {
		start();
	}

	public static StarCraft getInstance() {
		return instance;
	}

	//TODO mover a Map
	public List<Unit> unitsInCircumference(final Point position, int range, Player player) {
		Player opponent = player == player1? player2 : player1;
		return map.unitsInCircumference(position, range, player.getUnits(), opponent.getUnits());
	}
}
