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
import fiuba.algo3.starcraft.logic.templates.FabricaTemplate;
import fiuba.algo3.starcraft.logic.templates.PuertoEstelarTerranTemplate;
import fiuba.algo3.starcraft.logic.templates.TemplateID;
import fiuba.algo3.starcraft.logic.units.Unit;

public class EspectroTest {

	@Test
	public void testEspectroCreationWith1PuertoEstelarAnd150M100G() throws InsufficientResources, QuotaExceeded {
		Resources initialResources = new Resources(750,300);
		Player player = new Player(initialResources);
		player.pays(100, 0);
		Depot depot = DepositoSuministroTemplate.getInstance().create();
		player.newStructure(depot);
		player.pays(150, 0);
		ConstructionStructure barraca = BarracaTemplate.getInstance().create();
		player.newStructure(barraca);
		player.pays(200, 100);
		ConstructionStructure fabrica = FabricaTemplate.getInstance().create();
		player.newStructure(fabrica);
		player.pays(150, 100);
		ConstructionStructure puerto = PuertoEstelarTerranTemplate.getInstance().create();
		player.newStructure(puerto);
		
		Unit espectro = puerto.createUnit(TemplateID.EspectroTemplate, player.getResources(), player.populationSpace());
		player.newUnit(espectro);
		
		assertEquals(player.currentPopulation(), 2);
	}

}
