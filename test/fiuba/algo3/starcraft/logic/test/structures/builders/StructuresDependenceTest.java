package fiuba.algo3.starcraft.logic.test.structures.builders;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.starcraft.logic.map.Map;
import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.map.exceptions.NoResourcesToExtract;
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
	Map map;
	Point position;
	Point position2;
	@Before
	public void before() {
		map = new Map(1000);
		position = new Point(54,70);
		position2 = new Point(10,70);
	}
	
	@Test(expected = MissingStructureRequired.class)
	public void testFabricaCantBeBuiltWithoutBarraca() throws InsufficientResources, MissingStructureRequired, TemplateNotFound, NoResourcesToExtract {
		Resources initialResources = new Resources(300,100);
		Collection<Structure> built = new LinkedList<Structure>();
		built.add(new DepositoSuministroTemplate().create(position));
		
		new TerranBuilder().create("Fabrica", position2, initialResources, built, map);
	}

	@Test(expected = MissingStructureRequired.class)
	public void testPuertoEstelarCantBeBuiltWithFabricaAndNoBarraca() throws InsufficientResources, MissingStructureRequired, TemplateNotFound, NoResourcesToExtract {
		Resources initialResources = new Resources(150,100);
		Collection<Structure> built = new LinkedList<Structure>();
		built.add(new FabricaTemplate().create(position));
		
		new TerranBuilder().create("Puerto Estelar", position2, initialResources, built, map);
	}
	
	@Test
	public void testPuertoEstelarNeedsFabricaAndBarraca() throws InsufficientResources, MissingStructureRequired, TemplateNotFound, ConstructionNotFinished, NoResourcesToExtract {
		Resources initialResources = new Resources(150,100);
		Collection<Structure> built = new LinkedList<Structure>();
		built.add(new BarracaTemplate().create(position));
		built.add(new FabricaTemplate().create(position));
		
		Construction<Structure> construction = new TerranBuilder().create("Puerto Estelar", position2, initialResources, built, map);
		while(!construction.itsFinished()) {
			construction.lowerRelease();
		}
		
		assertEquals((construction.gather()).getName(), "Puerto Estelar");
		assertEquals(initialResources.getMineral(), 0);
		assertEquals(initialResources.getGas(), 0);
	}
	
	@Test
	public void testFabricaNeedsBarraca() throws InsufficientResources, MissingStructureRequired, TemplateNotFound, ConstructionNotFinished, NoResourcesToExtract {
		Resources initialResources = new Resources(200,100);
		Collection<Structure> built = new LinkedList<Structure>();
		built.add(new BarracaTemplate().create(position));
		
		Construction<Structure> construction = new TerranBuilder().create("Fabrica", position2, initialResources, built, map);
		while(!construction.itsFinished()) {
			construction.lowerRelease();
		}
		
		assertEquals((construction.gather()).getName(), "Fabrica");
	}
	
	@Test(expected = MissingStructureRequired.class)
	public void testPuertoEstelarCantBeBuiltWithoutAcceso() throws InsufficientResources, MissingStructureRequired, TemplateNotFound, NoResourcesToExtract {
		Resources initialResources = new Resources(250,150);
		Collection<Structure> built = new LinkedList<Structure>();
		built.add(new PilonTemplate().create(position));
		
		new TerranBuilder().create("Puerto Estelar", position2, initialResources, built, map);
	}

	@Test(expected = MissingStructureRequired.class)
	public void testArchivosTemplariosCantBeBuiltWithPuertoEstelarAndNoAcceso() throws InsufficientResources, MissingStructureRequired, TemplateNotFound, NoResourcesToExtract {
		Resources initialResources = new Resources(150,200);
		Collection<Structure> built = new LinkedList<Structure>();
		built.add(new PuertoEstelarProtossTemplate().create(position));
		
		new ProtossBuilder().create("Archivos Templarios", position2, initialResources, built, map);
	}
	
	@Test
	public void testArchivosTemplariosNeedsPuertoEstelarAndAcceso() throws InsufficientResources, MissingStructureRequired, TemplateNotFound, ConstructionNotFinished, NoResourcesToExtract {
		Resources initialResources = new Resources(150,200);
		Collection<Structure> built = new LinkedList<Structure>();
		built.add(new AccesoTemplate().create(position));
		built.add(new PuertoEstelarProtossTemplate().create(position));
		
		Construction<Structure> construction = new ProtossBuilder().create("Archivos Templarios", position2, initialResources, built, map);
		while(!construction.itsFinished()) {
			construction.lowerRelease();
		}
		
		assertEquals((construction.gather()).getName(), "Archivos Templarios");
	}
	
	@Test
	public void testPuertoEstelarNeedsAcceso() throws InsufficientResources, MissingStructureRequired, TemplateNotFound, ConstructionNotFinished, NoResourcesToExtract {
		Resources initialResources = new Resources(150,150);
		Collection<Structure> built = new LinkedList<Structure>();
		built.add(new AccesoTemplate().create(position));
		
		Construction<Structure> construction = new ProtossBuilder().create("Puerto Estelar", position2, initialResources, built, map);
		while(!construction.itsFinished()) {
			construction.lowerRelease();
		}
		
		assertEquals((construction.gather()).getName(), "Puerto Estelar");
		assertEquals(initialResources.getMineral(), 0);
		assertEquals(initialResources.getGas(), 0);
	}
}
