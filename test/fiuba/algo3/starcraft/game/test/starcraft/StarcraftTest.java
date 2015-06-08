package fiuba.algo3.starcraft.game.test.starcraft;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.starcraft.game.StarCraft;
import fiuba.algo3.starcraft.logic.player.Player;
import fiuba.algo3.starcraft.logic.player.Resources;
import fiuba.algo3.starcraft.logic.structures.Construction;
import fiuba.algo3.starcraft.logic.structures.ConstructionStructure;
import fiuba.algo3.starcraft.logic.structures.builders.TerranBuilder;
import fiuba.algo3.starcraft.logic.templates.structures.terran.BarracaTemplate;
import fiuba.algo3.starcraft.logic.units.Unit;

public class StarcraftTest {
	Player player1 = new Player(null, null, null, null, null);
	Player player2 = new Player(null, null, null, null, null);
		
	@Test
	public void test() {
		Resources initialResources = new Resources(300,0);
		Player player = new Player(null, null, TerranBuilder.getInstance(), null, initialResources);
		player.newStructureWithName("Deposito Suministro", null);
		for(int i = 0; i < 7; i++) player.newTurn();
		player.pays(150, 0);
		ConstructionStructure barraca = BarracaTemplate.getInstance().create(null);
		player.receiveNewStructure(barraca);
		
		Construction<Unit> construction = barraca.create("Marine", null, player.getResources(), player.currentPopulation(), player.populationQuota());
		while(!construction.itsFinished()) {
			construction.lowerRelease();
		}
		Unit marine = construction.gather();
		player.receiveNewUnit(marine);
		
		
		StarCraft.getInstance().unitsInCircumference(position, 0, player)
	}

}
