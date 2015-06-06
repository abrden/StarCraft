package fiuba.algo3.starcraft.logic.test.structures.builders;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.starcraft.logic.player.Resources;
import fiuba.algo3.starcraft.logic.structures.Construction;
import fiuba.algo3.starcraft.logic.structures.Structure;
import fiuba.algo3.starcraft.logic.structures.builders.ProtossBuilder;
import fiuba.algo3.starcraft.logic.structures.builders.TerranBuilder;
import fiuba.algo3.starcraft.logic.structures.exceptions.InsufficientResources;
import fiuba.algo3.starcraft.logic.structures.exceptions.MissingStructureRequired;
import fiuba.algo3.starcraft.logic.structures.exceptions.TemplateNotFound;

public class BuilderTest {

	@Test(expected = InsufficientResources.class)
	public void createStructureWithNoResourcesThrowsInsufficientResources() throws MissingStructureRequired, InsufficientResources, TemplateNotFound {
		TerranBuilder.getInstance().create("Deposito Suministro", new Resources(0,0), null);
	}
	
	@Test(expected = TemplateNotFound.class)
	public void createStructureWithMistakenNameTemplateNotFound() throws MissingStructureRequired, InsufficientResources, TemplateNotFound {
		TerranBuilder.getInstance().create("sdfihsofirwhoiw", new Resources(100,0), null);
	}

	public void createStructureReturnsConstruction() throws MissingStructureRequired, InsufficientResources, TemplateNotFound {
		Construction<Structure> construction = ProtossBuilder.getInstance().create("Pilon", new Resources(100,0), null);
	
		assertEquals(construction.getClass(), Construction.class);
	}
}
