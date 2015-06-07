package fiuba.algo3.starcraft.logic.test.structures.builders;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.LinkedList;

import org.junit.Test;

import fiuba.algo3.starcraft.logic.player.Resources;
import fiuba.algo3.starcraft.logic.structures.Construction;
import fiuba.algo3.starcraft.logic.structures.Structure;
import fiuba.algo3.starcraft.logic.structures.builders.ProtossBuilder;
import fiuba.algo3.starcraft.logic.structures.builders.TerranBuilder;
import fiuba.algo3.starcraft.logic.structures.exceptions.ConstructionNotFinished;
import fiuba.algo3.starcraft.logic.structures.exceptions.InsufficientResources;
import fiuba.algo3.starcraft.logic.structures.exceptions.MissingStructureRequired;
import fiuba.algo3.starcraft.logic.structures.exceptions.TemplateNotFound;
import fiuba.algo3.starcraft.logic.templates.structures.protoss.AccesoTemplate;
import fiuba.algo3.starcraft.logic.templates.structures.protoss.PilonTemplate;
import fiuba.algo3.starcraft.logic.templates.structures.protoss.PuertoEstelarProtossTemplate;
import fiuba.algo3.starcraft.logic.templates.structures.terran.BarracaTemplate;
import fiuba.algo3.starcraft.logic.templates.structures.terran.DepositoSuministroTemplate;
import fiuba.algo3.starcraft.logic.templates.structures.terran.FabricaTemplate;

public class StructuresDependenceTest {

	@Test(expected = MissingStructureRequired.class)
	public void testFabricaCantBeBuiltWithoutBarraca() throws InsufficientResources, MissingStructureRequired, TemplateNotFound {
		Resources initialResources = new Resources(300,100);
		Collection<Structure> built = new LinkedList<Structure>();
		built.add(DepositoSuministroTemplate.getInstance().create(null));
		
		TerranBuilder.getInstance().create("Fabrica", null, initialResources, built);
	}

	@Test(expected = MissingStructureRequired.class)
	public void testPuertoEstelarCantBeBuiltWithFabricaAndNoBarraca() throws InsufficientResources, MissingStructureRequired, TemplateNotFound {
		Resources initialResources = new Resources(150,100);
		Collection<Structure> built = new LinkedList<Structure>();
		built.add(FabricaTemplate.getInstance().create(null));
		
		TerranBuilder.getInstance().create("Puerto Estelar", null, initialResources, built);
	}
	
	@Test
	public void testPuertoEstelarNeedsFabricaAndBarraca() throws InsufficientResources, MissingStructureRequired, TemplateNotFound, ConstructionNotFinished {
		Resources initialResources = new Resources(150,100);
		Collection<Structure> built = new LinkedList<Structure>();
		built.add(BarracaTemplate.getInstance().create(null));
		built.add(FabricaTemplate.getInstance().create(null));
		
		Construction<Structure> construction = TerranBuilder.getInstance().create("Puerto Estelar", null, initialResources, built);
		while(!construction.itsFinished()) {
			construction.lowerRelease();
		}
		
		assertEquals((construction.gather()).getName(), "Puerto Estelar");
		assertEquals(initialResources.getMineral(), 0);
		assertEquals(initialResources.getGas(), 0);
	}
	
	@Test
	public void testFabricaNeedsBarraca() throws InsufficientResources, MissingStructureRequired, TemplateNotFound, ConstructionNotFinished {
		Resources initialResources = new Resources(200,100);
		Collection<Structure> built = new LinkedList<Structure>();
		built.add(BarracaTemplate.getInstance().create(null));
		
		Construction<Structure> construction = TerranBuilder.getInstance().create("Fabrica", null, initialResources, built);
		while(!construction.itsFinished()) {
			construction.lowerRelease();
		}
		
		assertEquals((construction.gather()).getName(), "Fabrica");
	}
	
	@Test(expected = MissingStructureRequired.class)
	public void testPuertoEstelarCantBeBuiltWithoutAcceso() throws InsufficientResources, MissingStructureRequired, TemplateNotFound {
		Resources initialResources = new Resources(250,150);
		Collection<Structure> built = new LinkedList<Structure>();
		built.add(PilonTemplate.getInstance().create(null));
		
		TerranBuilder.getInstance().create("Puerto Estelar", null, initialResources, built);
	}

	@Test(expected = MissingStructureRequired.class)
	public void testArchivosTemplariosCantBeBuiltWithPuertoEstelarAndNoAcceso() throws InsufficientResources, MissingStructureRequired, TemplateNotFound {
		Resources initialResources = new Resources(150,200);
		Collection<Structure> built = new LinkedList<Structure>();
		built.add(PuertoEstelarProtossTemplate.getInstance().create(null));
		
		ProtossBuilder.getInstance().create("Archivos Templarios", null, initialResources, built);
	}
	
	@Test
	public void testArchivosTemplariosNeedsPuertoEstelarAndAcceso() throws InsufficientResources, MissingStructureRequired, TemplateNotFound, ConstructionNotFinished {
		Resources initialResources = new Resources(150,200);
		Collection<Structure> built = new LinkedList<Structure>();
		built.add(AccesoTemplate.getInstance().create(null));
		built.add(PuertoEstelarProtossTemplate.getInstance().create(null));
		
		Construction<Structure> construction = ProtossBuilder.getInstance().create("Archivos Templarios", null, initialResources, built);
		while(!construction.itsFinished()) {
			construction.lowerRelease();
		}
		
		assertEquals((construction.gather()).getName(), "Archivos Templarios");
	}
	
	@Test
	public void testPuertoEstelarNeedsAcceso() throws InsufficientResources, MissingStructureRequired, TemplateNotFound, ConstructionNotFinished {
		Resources initialResources = new Resources(150,150);
		Collection<Structure> built = new LinkedList<Structure>();
		built.add(AccesoTemplate.getInstance().create(null));
		
		Construction<Structure> construction = ProtossBuilder.getInstance().create("Puerto Estelar", null, initialResources, built);
		while(!construction.itsFinished()) {
			construction.lowerRelease();
		}
		
		assertEquals((construction.gather()).getName(), "Puerto Estelar");
		assertEquals(initialResources.getMineral(), 0);
		assertEquals(initialResources.getGas(), 0);
	}
}
