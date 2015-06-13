package fiuba.algo3.starcraft.logic.test.templates.qualities;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.starcraft.logic.templates.qualities.AltoTemplarioPowerGenerator;
import fiuba.algo3.starcraft.logic.templates.qualities.Alucinacion;
import fiuba.algo3.starcraft.logic.templates.qualities.TormentaPsionica;
import fiuba.algo3.starcraft.logic.units.exceptions.InsufficientEnergy;
import fiuba.algo3.starcraft.logic.units.exceptions.NonexistentPower;

public class AltoTemplarioPowerGeneratorTest {

	@Test
	public void testGeneratePowerTormentaPsionicaReturnsObjectOfClassTormentaPsionica() throws NonexistentPower, InsufficientEnergy {
		AltoTemplarioPowerGenerator generator = new AltoTemplarioPowerGenerator();
		
		assertEquals(generator.generatePower("Tormenta Psionica", 200).getClass(), TormentaPsionica.class);
	}
	
	@Test
	public void testGeneratePowerRadiacionReturnsObjectOfClassRadiacion() throws NonexistentPower, InsufficientEnergy {
		AltoTemplarioPowerGenerator generator = new AltoTemplarioPowerGenerator();
		
		assertEquals(generator.generatePower("Alucinacion", 200).getClass(), Alucinacion.class);
	}

	@Test(expected = InsufficientEnergy.class)
	public void testGeneratePowerWithNoEnergyThrowsInsufficientEnergy() throws NonexistentPower, InsufficientEnergy {
		AltoTemplarioPowerGenerator generator = new AltoTemplarioPowerGenerator();
		
		generator.generatePower("Tormenta Psionica", 20);
	}
	
	@Test(expected = NonexistentPower.class)
	public void testGeneratePowerWithUnkownNameThrowsNonexixtentPower() throws NonexistentPower, InsufficientEnergy {
		AltoTemplarioPowerGenerator generator = new AltoTemplarioPowerGenerator();
		
		generator.generatePower("Carlos", 200);
	}

}
