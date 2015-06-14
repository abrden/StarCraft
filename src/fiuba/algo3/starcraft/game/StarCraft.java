package fiuba.algo3.starcraft.game;


import fiuba.algo3.starcraft.logic.map.Map;
import fiuba.algo3.starcraft.logic.player.Player;
import fiuba.algo3.starcraft.logic.units.Unit;


public class StarCraft {
	
	public Map map;
	private Player player1;
	private Player player2;
	
	public static void start() {}
	
	public void setGame(Player player1, Player player2, Map map) {
		this.player1 = player1;
		this.player2 = player2;
		this.map = map;
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

	public Iterable<Unit> getOpponentUnits(Iterable<Unit> playerUnits) {
		return playerUnits == player1.getUnits() ? player2.getUnits() : player1.getUnits();
	}
}
