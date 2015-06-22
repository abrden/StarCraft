package fiuba.algo3.starcraft.game;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.starcraft.logic.map.Map;
import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.map.ScenarioGenerator;
import fiuba.algo3.starcraft.logic.map.areas.LandType;
import fiuba.algo3.starcraft.logic.map.resources.ReservoirType;
import fiuba.algo3.starcraft.logic.player.Player;
import fiuba.algo3.starcraft.logic.player.Resources;
import fiuba.algo3.starcraft.logic.structures.builders.Builder;
import fiuba.algo3.starcraft.logic.structures.builders.ProtossBuilder;
import fiuba.algo3.starcraft.logic.structures.builders.TerranBuilder;
import fiuba.algo3.starcraft.logic.units.Unit;

public class StarCraft {
	
	//Eliminar luego de implementar mejora
	private Player player1;
	private Player player2; 
	public StarCraft() {}
	public void setGame(Player player1, Player player2, Map map) {
		this.player1 = player1;
		this.player2 = player2;
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
	private static final double AIR_DENSITY = 0.4;
	
	public StarCraft(List<PlayerSetup> playerSetups) {
		this.generateMap();
		
		int quantity = playerSetups.size();
		List<Point> bases = this.generateBases(quantity);
		
		int i = 0;
		for(PlayerSetup setup : playerSetups) {
			this.generatePlayer(setup, bases.get(i));
			i++;
		}
	}
	
	private void generateMap() {
		scenarioGenerator.assignSurfaceDistributionInRect(LandType.air, new Point(MAP_SIDE/2, MAP_SIDE/2), MAP_SIDE, AIR_DENSITY);
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
		Builder builder = (setup.getRace() == RaceType.terran ? new TerranBuilder() : new ProtossBuilder());
		
		players.add(new Player(setup.getName(), setup.getColor(), builder, base, new Resources(INITIAL_MINERAL, INITIAL_GAS), map));
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
