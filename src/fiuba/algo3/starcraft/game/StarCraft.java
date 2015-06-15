package fiuba.algo3.starcraft.game;


import fiuba.algo3.starcraft.logic.map.Map;
import fiuba.algo3.starcraft.logic.player.Player;
import fiuba.algo3.starcraft.logic.units.Unit;


public class StarCraft {
	
	public Map map;
	private Player player1;
	private Player player2;
	
	public static void start() {
		//TODO
		/*
		 * Preguntar a player1 su nombre, color y raza
		 * Verificar que el nombre tenga mas de 4 caracts
		 * Crear player1, darle un punto en el mapa "base"
		 * Preguntar a player2 su nombre, color y raza
		 * Verificar que el color no sea repetido, nombre con mas de 4 caracts.........
		 * Crear player2, darle un punto en el mapa "base"
		 * 
		 * Settear visibilidad de ambos, sus alrededores en el mapa estan nublados hasta que
		 * lo recorran con sus unidades
		 */
	}
	
	public void setGame(Player player1, Player player2, Map map) {
		this.player1 = player1;
		this.player2 = player2;
		this.map = map;
	}

	public Iterable<Unit> getEnemyUnits(Iterable<Unit> playerUnits) {
		return playerUnits == player1.getUnits() ? player2.getUnits() : player1.getUnits();
	}
	
	public static void main(String[] args) {
		start();
	}
}
