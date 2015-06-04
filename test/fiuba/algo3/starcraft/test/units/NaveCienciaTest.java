package fiuba.algo3.starcraft.test.units;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.starcraft.logic.player.Construction;
import fiuba.algo3.starcraft.logic.player.Player;
import fiuba.algo3.starcraft.logic.player.Resources;
import fiuba.algo3.starcraft.logic.structures.ConstructionStructure;
import fiuba.algo3.starcraft.logic.structures.builders.TerranBuilder;
import fiuba.algo3.starcraft.logic.structures.exceptions.InsufficientResources;
import fiuba.algo3.starcraft.logic.structures.exceptions.MissingStructureRequired;
import fiuba.algo3.starcraft.logic.structures.exceptions.QuotaExceeded;
import fiuba.algo3.starcraft.logic.structures.exceptions.TemplateNotFound;
import fiuba.algo3.starcraft.logic.templates.structures.terran.PuertoEstelarTerranTemplate;
import fiuba.algo3.starcraft.logic.units.Unit;

public class NaveCienciaTest {

	@Test
	public void testNeveCienciaCreationWith1PuertoEstelarAnd100M225G() throws QuotaExceeded, InsufficientResources, TemplateNotFound, MissingStructureRequired {
		Resources initialResources = new Resources(700,425);
		Player player = new Player(null, null, TerranBuilder.getInstance(), initialResources);
		player.newStructureWithName("Deposito Suministro");
		for(int i = 0; i < 7; i++) player.newTurn();
		player.newStructureWithName("Barraca");
		for(int i = 0; i < 13; i++) player.newTurn();
		player.newStructureWithName("Fabrica");
		for(int i = 0; i < 13; i++) player.newTurn();
		
		player.pays(150, 100);
		ConstructionStructure puerto = PuertoEstelarTerranTemplate.getInstance().create();
		player.receiveNewStructure(puerto);
		
		Construction<Unit> construction = puerto.create("Nave Ciencia", player.getResources(), player.currentPopulation(), player.populationQuota());
		while(!construction.itsFinished()) {
			construction.lowerRelease();
		}
		Unit nave = construction.gather();
		player.receiveNewUnit(nave);
		
		assertEquals(player.currentPopulation(), 2);
	}

}
