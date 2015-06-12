package fiuba.algo3.starcraft.logic.test.player.integration.units;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.starcraft.logic.player.Player;
import fiuba.algo3.starcraft.logic.player.Resources;
import fiuba.algo3.starcraft.logic.structures.Construction;
import fiuba.algo3.starcraft.logic.structures.ConstructionStructure;
import fiuba.algo3.starcraft.logic.structures.builders.TerranBuilder;
import fiuba.algo3.starcraft.logic.structures.exceptions.ConstructionNotFinished;
import fiuba.algo3.starcraft.logic.structures.exceptions.InsufficientResources;
import fiuba.algo3.starcraft.logic.structures.exceptions.MissingStructureRequired;
import fiuba.algo3.starcraft.logic.structures.exceptions.QuotaExceeded;
import fiuba.algo3.starcraft.logic.structures.exceptions.TemplateNotFound;
import fiuba.algo3.starcraft.logic.templates.structures.terran.PuertoEstelarTerranTemplate;
import fiuba.algo3.starcraft.logic.units.Unit;

public class NaveCienciaTest {

	@Test
	public void testNeveCienciaCreationWith1PuertoEstelarAnd100M225G() throws QuotaExceeded, InsufficientResources, TemplateNotFound, MissingStructureRequired, ConstructionNotFinished {
		Resources initialResources = new Resources(700,425);
		Player player = new Player(null, null, TerranBuilder.getInstance(), null, initialResources, null);
		player.newStructureWithName("Deposito Suministro", null);
		for(int i = 0; i < 7; i++) player.newTurn();
		player.newStructureWithName("Barraca", null);
		for(int i = 0; i < 13; i++) player.newTurn();
		player.newStructureWithName("Fabrica", null);
		for(int i = 0; i < 13; i++) player.newTurn();
		
		player.pays(150, 100);
		ConstructionStructure puerto = PuertoEstelarTerranTemplate.getInstance().create(null);
		player.receiveNewStructure(puerto);
		
		Construction<Unit> construction = puerto.create("Nave Ciencia", null, player.getResources(), player.currentPopulation(), player.populationQuota());
		while(!construction.itsFinished()) {
			construction.lowerRelease();
		}
		Unit nave = construction.gather();
		player.receiveNewUnit(nave);
		
		assertEquals(player.currentPopulation(), 2);
	}

}
