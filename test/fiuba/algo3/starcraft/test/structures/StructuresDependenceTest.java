package fiuba.algo3.starcraft.test.structures;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.LinkedList;

import org.junit.Test;

import fiuba.algo3.starcraft.logic.player.Resources;
import fiuba.algo3.starcraft.logic.structures.InsufficientResources;
import fiuba.algo3.starcraft.logic.structures.MissingStructureRequired;
import fiuba.algo3.starcraft.logic.structures.ProtossBuilder;
import fiuba.algo3.starcraft.logic.structures.Structure;
import fiuba.algo3.starcraft.logic.structures.TerranBuilder;
import fiuba.algo3.starcraft.logic.templates.AccesoTemplate;
import fiuba.algo3.starcraft.logic.templates.BarracaTemplate;
import fiuba.algo3.starcraft.logic.templates.FabricaTemplate;
import fiuba.algo3.starcraft.logic.templates.PuertoEstelarProtossTemplate;

public class StructuresDependenceTest {

	@Test(expected = MissingStructureRequired.class)
	public void testFabricaCantBeBuiltWithoutBarraca() throws InsufficientResources, MissingStructureRequired {
		Resources initialResources = new Resources(300,100);
		Collection<Structure> built = new LinkedList<Structure>();
		built.add(TerranBuilder.getInstance().create("Deposito Suministro", initialResources, new LinkedList<Structure>()));
		
		TerranBuilder.getInstance().create("Fabrica", initialResources, built);
	}

	@Test(expected = MissingStructureRequired.class)
	public void testPuertoEstelarCantBeBuiltWithFabricaAndNoBarraca() throws InsufficientResources, MissingStructureRequired {
		Resources initialResources = new Resources(150,100);
		Collection<Structure> built = new LinkedList<Structure>();
		built.add(FabricaTemplate.getInstance().create());
		
		TerranBuilder.getInstance().create("Puerto Estelar", initialResources, built);
	}
	
	@Test
	public void testPuertoEstelarNeedsFabricaAndBarraca() throws InsufficientResources, MissingStructureRequired {
		Resources initialResources = new Resources(150,100);
		Collection<Structure> built = new LinkedList<Structure>();
		built.add(BarracaTemplate.getInstance().create());
		built.add(FabricaTemplate.getInstance().create());
		
		Structure structure = TerranBuilder.getInstance().create("Puerto Estelar", initialResources, built);
		
		assertEquals(structure.getName(), "Puerto Estelar");
		assertEquals(initialResources.getMineral(), 0);
		assertEquals(initialResources.getGas(), 0);
	}
	
	@Test
	public void testFabricaNeedsBarraca() throws InsufficientResources, MissingStructureRequired {
		Resources initialResources = new Resources(200,100);
		Collection<Structure> built = new LinkedList<Structure>();
		built.add(BarracaTemplate.getInstance().create());
		
		Structure structure = TerranBuilder.getInstance().create("Fabrica", initialResources, built);
		
		assertEquals(structure.getName(), "Fabrica");
	}
	
	@Test(expected = MissingStructureRequired.class)
	public void testPuertoEstelarCantBeBuiltWithoutAcceso() throws InsufficientResources, MissingStructureRequired {
		Resources initialResources = new Resources(250,150);
		Collection<Structure> built = new LinkedList<Structure>();
		built.add(ProtossBuilder.getInstance().create("Pilon", initialResources, new LinkedList<Structure>()));
		
		TerranBuilder.getInstance().create("Puerto Estelar", initialResources, built);
	}

	@Test(expected = MissingStructureRequired.class)
	public void testArchivosTemplariosCantBeBuiltWithPuertoEstelarAndNoAcceso() throws InsufficientResources, MissingStructureRequired {
		Resources initialResources = new Resources(150,200);
		Collection<Structure> built = new LinkedList<Structure>();
		built.add(PuertoEstelarProtossTemplate.getInstance().create());
		
		ProtossBuilder.getInstance().create("Archivos Templarios", initialResources, built);
	}
	
	@Test
	public void testArchivosTemplariosNeedsPuertoEstelarAndAcceso() throws InsufficientResources, MissingStructureRequired {
		Resources initialResources = new Resources(150,200);
		Collection<Structure> built = new LinkedList<Structure>();
		built.add(AccesoTemplate.getInstance().create());
		built.add(PuertoEstelarProtossTemplate.getInstance().create());
		
		Structure structure = ProtossBuilder.getInstance().create("Archivos Templarios", initialResources, built);
		
		assertEquals(structure.getName(), "Archivos Templarios");
	}
	
	@Test
	public void testPuertoEstelarNeedsAcceso() throws InsufficientResources, MissingStructureRequired {
		Resources initialResources = new Resources(150,150);
		Collection<Structure> built = new LinkedList<Structure>();
		built.add(AccesoTemplate.getInstance().create());
		
		Structure structure = ProtossBuilder.getInstance().create("Puerto Estelar", initialResources, built);
		
		assertEquals(structure.getName(), "Puerto Estelar");
		assertEquals(initialResources.getMineral(), 0);
		assertEquals(initialResources.getGas(), 0);
	}
}
