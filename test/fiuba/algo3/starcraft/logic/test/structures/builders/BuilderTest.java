package fiuba.algo3.starcraft.logic.test.structures.builders;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.starcraft.logic.map.Map;
import fiuba.algo3.starcraft.logic.map.NoResourcesToExtract;
import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.player.Resources;
import fiuba.algo3.starcraft.logic.structures.Construction;
import fiuba.algo3.starcraft.logic.structures.Structure;
import fiuba.algo3.starcraft.logic.structures.builders.ProtossBuilder;
import fiuba.algo3.starcraft.logic.structures.builders.TerranBuilder;
import fiuba.algo3.starcraft.logic.structures.exceptions.InsufficientResources;
import fiuba.algo3.starcraft.logic.structures.exceptions.MissingStructureRequired;
import fiuba.algo3.starcraft.logic.structures.exceptions.TemplateNotFound;

public class BuilderTest {
	Map map;
	Point position;
	Resources initialResources;
	@Before
	public void before() {
		initialResources = new Resources(200,0);
		map = new Map(1000);
		position = new Point(54,70);
	}
	
	@Test(expected = InsufficientResources.class)
	public void createStructureWithNoResourcesThrowsInsufficientResources() throws MissingStructureRequired, InsufficientResources, TemplateNotFound, NoResourcesToExtract {
		new TerranBuilder().create("Deposito Suministro", position, new Resources(0,0), null, map);
	}
	
	@Test(expected = TemplateNotFound.class)
	public void createStructureWithMistakenNameTemplateNotFound() throws MissingStructureRequired, InsufficientResources, TemplateNotFound, NoResourcesToExtract {
		new TerranBuilder().create("sdfihsofirwhoiw", position, initialResources, null, map);
	}

	@Test
	public void createStructureReturnsConstruction() throws MissingStructureRequired, InsufficientResources, TemplateNotFound, NoResourcesToExtract {
		Construction<Structure> construction = new ProtossBuilder().create("Pilon", position, initialResources, null, map);
		assertEquals(construction.getClass(), Construction.class);
	}
}
