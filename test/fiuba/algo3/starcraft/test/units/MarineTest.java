package fiuba.algo3.starcraft.test.units;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.starcraft.logic.player.Player;
import fiuba.algo3.starcraft.logic.player.Resources;
import fiuba.algo3.starcraft.logic.structures.ConstructionStructure;
import fiuba.algo3.starcraft.logic.templates.BarracaTemplate;
import fiuba.algo3.starcraft.logic.units.Unit;

public class MarineTest {

	@Test
	public void test() {
		Resources initialResources = new Resources(200,0);
		Player player = new Player(initialResources);
		player.pays(150, 0);
		ConstructionStructure barraca = BarracaTemplate.getInstance().create();
		player.newStructure(barraca);
		
		Unit marine = barraca.make(1, player.getResources(), player.populationSpace());
		player.newUnit(marine);
		
		assertEquals(player.population(), 1);
	}

}
