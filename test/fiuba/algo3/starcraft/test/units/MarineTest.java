package fiuba.algo3.starcraft.test.units;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.starcraft.logic.player.Player;
import fiuba.algo3.starcraft.logic.player.Resources;
import fiuba.algo3.starcraft.logic.structures.ConstructionStructure;
import fiuba.algo3.starcraft.logic.structures.Depot;
import fiuba.algo3.starcraft.logic.structures.InsufficientResources;
import fiuba.algo3.starcraft.logic.structures.QuotaExceeded;
import fiuba.algo3.starcraft.logic.templates.BarracaTemplate;
import fiuba.algo3.starcraft.logic.templates.DepositoSuministroTemplate;
import fiuba.algo3.starcraft.logic.templates.TemplateID;
import fiuba.algo3.starcraft.logic.units.Unit;

public class MarineTest {

	@Test
	public void testMarineCreation() throws InsufficientResources, QuotaExceeded {
		Resources initialResources = new Resources(300,0);
		Player player = new Player(initialResources);
		player.pays(100, 0);
		Depot depot = DepositoSuministroTemplate.getInstance().create();
		player.newStructure(depot);
		player.pays(150, 0);
		ConstructionStructure barraca = BarracaTemplate.getInstance().create();
		player.newStructure(barraca);
		
		Unit marine = barraca.createUnit(TemplateID.MarineTemplate, player.getResources(), player.populationSpace());
		player.newUnit(marine);
		
		assertEquals(player.population(), 1);
	}

}
