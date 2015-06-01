package fiuba.algo3.starcraft.test.structures;

//import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.starcraft.logic.player.Player;
import fiuba.algo3.starcraft.logic.player.Resources;
import fiuba.algo3.starcraft.logic.structures.ConstructionStructure;
import fiuba.algo3.starcraft.logic.structures.InsufficientResources;
import fiuba.algo3.starcraft.logic.templates.FabricaTemplate;

public class StructuresDependence {

	@Test(expected = Exception.class)
	public void testFactoryNeedsBarraca() throws InsufficientResources {
		Resources initialResources = new Resources(450,150);
		Player player = new Player(initialResources);
		player.pays(200, 100);
		ConstructionStructure fabrica = FabricaTemplate.getInstance().create();
		player.newStructure(fabrica);
	}

}
