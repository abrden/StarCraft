package fiuba.algo3.starcraft.game;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.starcraft.logic.map.Map;
import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.map.ScenarioGenerator;
import fiuba.algo3.starcraft.logic.map.resources.ReservoirType;
import fiuba.algo3.starcraft.logic.player.Player;
import fiuba.algo3.starcraft.logic.player.Resources;
import fiuba.algo3.starcraft.logic.structures.builders.Builder;
import fiuba.algo3.starcraft.logic.structures.builders.ProtossBuilder;
import fiuba.algo3.starcraft.logic.structures.builders.TerranBuilder;
import fiuba.algo3.starcraft.logic.units.Unit;

public class StarCraft {


	//TODO Eliminar luego de implementar mejora
	public StarCraft() {}
	public void setGame(Player player1, Player player2, Map map) {
		players.add(player1);
		players.add(player2);
		this.map = map;
	}

	public Map map = new Map(MAP_SIDE, this);
	private List<Player> players = new ArrayList<Player>();
	
	private ScenarioGenerator scenarioGenerator = new ScenarioGenerator(map);
	private static final int INITIAL_MINERAL = 200;
	private static final int INITIAL_GAS = 0;
	private static final int MAP_SIDE = 1000;
	private static final int BASE_SIDE = 30;
	private static final double RESERVOIR_DENSITY = 0.2;
	private static final double AIR_DENSITY = 0.1;
	private Player activePlayer;
	
	public StarCraft(List<PlayerSetup> playerSetups) {
		//TODO A JSON FILE GENERATES THE MAP INSTEAD OF SCENARIOGENERATOR
		this.generateMap();
		
		int quantity = playerSetups.size();
		List<Point> bases = this.generateBases(quantity);
		//
		int i = 0;
		for(PlayerSetup setup : playerSetups) {
			this.generatePlayer(setup, bases.get(i));
			i++;
		}
	}
	
	private void generateMap() {
		scenarioGenerator.assignAirDistributionInRect(new Point(0, 0), MAP_SIDE, AIR_DENSITY);
	}
	
	private List<Point> generateBases(int quantity) {
		List<Point> bases = scenarioGenerator.generateBases(quantity);
		
		for (Point base : bases) {
			scenarioGenerator.assignReservoirDistributionInRect(ReservoirType.mine, base, BASE_SIDE, RESERVOIR_DENSITY);
			scenarioGenerator.assignReservoirDistributionInRect(ReservoirType.volcano, base, BASE_SIDE, RESERVOIR_DENSITY);
		}
		
		return bases;
	}
	
	private void generatePlayer(PlayerSetup setup, Point base) {
		Builder builder = (setup.getRace() == RaceType.terran ? new TerranBuilder() : new ProtossBuilder());
		
		players.add(new Player(setup.getName(), setup.getColor(), builder, base, new Resources(INITIAL_MINERAL, INITIAL_GAS), map));
	}

	public Iterable<Unit> getEnemyUnits(Iterable<Unit> playerUnits) {
		List<Unit> enemyUnits = new ArrayList<Unit>();
		for (Player player : players) {
			if (playerUnits == player.getUnits())
				continue;
			for (Unit unit : player.getUnits())
				enemyUnits.add(unit);
		}
		return enemyUnits;
	}

	private void getRidOfLoosers() {
		List<Player> loosers = new ArrayList<Player>();
		for (Player player : players) {
			if ((player.getMineral() < 100) && (player.getGas() < 100) && (player.numberOfUnits() == 0) && (player.numberOfStructures() == 0) && (player.constructionQueueIsEmpty())) {
				loosers.add(player);
			}
		}
		players.removeAll(loosers);
	}

	public Player getActivePlayer() {
		return activePlayer;
	}

	public void gameOver(Player winner) {
		//DO STUFF
	}

	public void nextTurn() {
		this.getRidOfLoosers();
		if (players.size() == 1)
			this.gameOver(players.get(0));
		int index = players.indexOf(activePlayer);
		if (index == players.size() - 1)
			activePlayer = players.get(0);
		else
			activePlayer = players.get(index + 1);

		activePlayer.newTurn();
	}

	public void start() {
		activePlayer  = players.get(0);
	}

}
