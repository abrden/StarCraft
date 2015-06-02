package fiuba.algo3.starcraft.test.units;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.starcraft.logic.player.Construction;
import fiuba.algo3.starcraft.logic.player.Player;
import fiuba.algo3.starcraft.logic.player.Resources;
import fiuba.algo3.starcraft.logic.structures.ConstructionStructure;
import fiuba.algo3.starcraft.logic.structures.Depot;
import fiuba.algo3.starcraft.logic.structures.exceptions.InsufficientResources;
import fiuba.algo3.starcraft.logic.structures.exceptions.QuotaExceeded;
import fiuba.algo3.starcraft.logic.structures.exceptions.TemplateNotFound;
import fiuba.algo3.starcraft.logic.templates.structures.terran.BarracaTemplate;
import fiuba.algo3.starcraft.logic.templates.structures.terran.DepositoSuministroTemplate;
import fiuba.algo3.starcraft.logic.templates.structures.terran.FabricaTemplate;
import fiuba.algo3.starcraft.logic.templates.structures.terran.PuertoEstelarTerranTemplate;
import fiuba.algo3.starcraft.logic.units.Unit;

public class NaveCienciaTest {

	@Test
	public void testNeveCienciaCreationWith1PuertoEstelarAnd100M225G() throws QuotaExceeded, InsufficientResources, TemplateNotFound {
		Resources initialResources = new Resources(700,425);
		Player player = new Player(null, null, null, initialResources);
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
		
		Construction construction = puerto.create("Nave Ciencia", player.getResources(), player.populationSpace());
		while(!construction.itsFinished()) {
			construction.lowerRelease();
		}
		Unit nave = (Unit) construction.gather();
		player.newUnit(nave);
		
		assertEquals(player.currentPopulation(), 2);
	}

}
