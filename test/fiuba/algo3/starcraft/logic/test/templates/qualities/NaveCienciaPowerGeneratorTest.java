package fiuba.algo3.starcraft.logic.test.templates.qualities;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.starcraft.logic.templates.qualities.EMP;
import fiuba.algo3.starcraft.logic.templates.qualities.NaveCienciaPowerGenerator;
import fiuba.algo3.starcraft.logic.templates.qualities.Radiacion;
import fiuba.algo3.starcraft.logic.units.exceptions.InsufficientEnergy;
import fiuba.algo3.starcraft.logic.units.exceptions.NonexistentPower;

public class NaveCienciaPowerGeneratorTest {

	@Test
	public void testGeneratePowerEMPReturnsObjectOfClassEMP() throws NonexistentPower, InsufficientEnergy {
		NaveCienciaPowerGenerator generator = new NaveCienciaPowerGenerator();
		
		assertEquals(generator.generatePower("EMP", 200).getClass(), EMP.class);
	}
	
	@Test
	public void testGeneratePowerRadiacionReturnsObjectOfClassRadiacion() throws NonexistentPower, InsufficientEnergy {
		NaveCienciaPowerGenerator generator = new NaveCienciaPowerGenerator();
		
		assertEquals(generator.generatePower("Radiacion", 200).getClass(), Radiacion.class);
	}

	@Test(expected = InsufficientEnergy.class)
	public void testGeneratePowerWithNoEnergyThrowsInsufficientEnergy() throws NonexistentPower, InsufficientEnergy {
		NaveCienciaPowerGenerator generator = new NaveCienciaPowerGenerator();
		
		generator.generatePower("Radiacion", 20);
	}
	
	@Test(expected = NonexistentPower.class)
	public void testGeneratePowerWithUnkownNameThrowsNonexixtentPower() throws NonexistentPower, InsufficientEnergy {
		NaveCienciaPowerGenerator generator = new NaveCienciaPowerGenerator();
		
		generator.generatePower("Carlos", 20);
	}
}
