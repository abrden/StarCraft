package fiuba.algo3.starcraft.logic.test.player;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.starcraft.logic.player.Resources;
import fiuba.algo3.starcraft.logic.structures.exceptions.InsufficientResources;

public class ResourcesTest {

	@Test
	public void testResourcesAreInitializedToValidState() {
		Resources resources = new Resources(200,0);
		
		assertEquals(resources.getMineral(), 200);
		assertEquals(resources.getGas(), 0);
	}
	
	@Test
	public void testAdd30MAnd74GIncreasesResourcesTo230MAnd74G() {
		Resources resources = new Resources(200,0);
		
		resources.add(30, 74);
		
		assertEquals(resources.getMineral(), 230);
		assertEquals(resources.getGas(), 74);
	}

	@Test
	public void testRemove50MAnd22GDecreasesResourcesTo150MAnd13G() throws InsufficientResources {
		Resources resources = new Resources(200,35);
		
		resources.remove(50, 22);
		
		assertEquals(resources.getMineral(), 150);
		assertEquals(resources.getGas(), 13);
	}
	
	@Test(expected = InsufficientResources.class)
	public void testRemoveMoreResourcesThanHadThrowsInsufficientResourcesException() throws InsufficientResources {
		Resources resources = new Resources(200,0);
		
		resources.remove(201, 1);
	}
}