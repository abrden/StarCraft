package fiuba.algo3.starcraft.game;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.starcraft.logic.map.Map;
import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.map.ScenarioGenerator;
import fiuba.algo3.starcraft.logic.map.resources.ReservoirType;
import fiuba.algo3.starcraft.logic.player.Player;
import fiuba.algo3.starcraft.logic.player.Resources;
import fiuba.algo3.starcraft.logic.units.Unit;
import fiuba.algo3.starcraft.view.StartupView;

public class StarCraft {
	
	//Eliminar luego de implementar mejora
	private Player player1;
	private Player player2; 
	public void setGame(Player player1, Player player2, Map map) {
		this.player1 = player1;
		this.player2 = player2;
		this.map = map;
	}
	
	public Map map = new Map(MAP_SIDE, this);
	private List<Player> players = new ArrayList<Player>();
	
	private ScenarioGenerator scenarioGenerator = new ScenarioGenerator(map);
	private StartupView startupView;
	private static final int INITIAL_MINERAL = 200;
	private static final int INITIAL_GAS = 0;
	private static final int MAP_SIDE = 1000;
	private static final int BASE_SIDE = 30;
	private static final double RESERVOIR_DENSITY = 0.2;
	
	
	public void gameSetup() {
		this.generateMap();
		int quantity = startupView.playersQuantity();
		List<Point> bases = this.generateBases(quantity);
		
		for (int i = 1; i <= quantity; i++) {
			int playerNumber = i;
			PlayerSetup setup = startupView.playerSetup(playerNumber);
			while (true) {
				try {
					checkPlayerSetup(setup);
					break;
				} catch (NameIsTaken | ColorIsTaken e) {
					setup = startupView.newPlayerSetupDueToError(e.getMessage(), playerNumber);
				}
			}
			this.generatePlayer(setup, bases.get(playerNumber));
		}
	}
	
	private boolean checkPlayerSetup(PlayerSetup setup) throws NameIsTaken, ColorIsTaken {
		for (Player player : players) {
			if (player.getName() == setup.getName())
				throw new NameIsTaken();
			if (player.getColor() == setup.getColor())
				throw new ColorIsTaken();
		} 
		return true;
	}
	
	private void generateMap() {
		//scenarioGenerator.assignSurfaceDistributionInRect(LandType.land, origin, side, density);
		//scenarioGenerator.assignSurfaceDistributionInRect(LandType.air, origin, side, density);
		//el mapa se inicia con todo tierra, todo aire???
	}
	
	private List<Point> generateBases(int quantity) {
		List<Point> bases = scenarioGenerator.generateBases(quantity);
		
		for (Point base : bases) {
			scenarioGenerator.assignSurfaceDistributionInRect(ReservoirType.mine, base, BASE_SIDE, RESERVOIR_DENSITY);
			scenarioGenerator.assignSurfaceDistributionInRect(ReservoirType.volcano, base, BASE_SIDE, RESERVOIR_DENSITY);
		}
		
		return bases;
	}
	
	private void generatePlayer(PlayerSetup setup, Point base) {
		players.add(new Player(setup.getName(), setup.getColor(), setup.getBuilder(), base, new Resources(INITIAL_MINERAL, INITIAL_GAS), map));
	}

	public Iterable<Unit> getEnemyUnits(Iterable<Unit> playerUnits) {
		return playerUnits == player1.getUnits() ? player2.getUnits() : player1.getUnits();
	}
	
	public static void start() {
		
	}
	
	public static void main(String[] args) {
		start();
	}
}
