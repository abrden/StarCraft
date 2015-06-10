package fiuba.algo3.starcraft.logic.test.units;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.templates.qualities.Power;
import fiuba.algo3.starcraft.logic.templates.units.protoss.AltoTemplarioTemplate;
import fiuba.algo3.starcraft.logic.templates.units.protoss.ZealotTemplate;
import fiuba.algo3.starcraft.logic.templates.units.terran.NaveCienciaTemplate;
import fiuba.algo3.starcraft.logic.units.MagicalUnit;
import fiuba.algo3.starcraft.logic.units.MuggleUnit;
import fiuba.algo3.starcraft.logic.units.Unit;
import fiuba.algo3.starcraft.logic.units.exceptions.InsufficientEnergy;
import fiuba.algo3.starcraft.logic.units.exceptions.NonexistentPower;

public class NaveCienciaTest {

	@Test(expected = InsufficientEnergy.class)
	public void testGenerateEMPWithouttEnergyThrowsInsufficientEnergy() throws InsufficientEnergy, NonexistentPower {
		MagicalUnit nave = NaveCienciaTemplate.getInstance().create(new Point(1,2));
		
		nave.usePower("EMP");
	}
	
	@Test(expected = NonexistentPower.class)
	public void testGenerateUnknownPowerThrowsInsufficientEnergy() throws InsufficientEnergy, NonexistentPower {
		MagicalUnit nave = NaveCienciaTemplate.getInstance().create(new Point(1,2));
		
		nave.usePower("Hola");
	}	

	@Test(expected = InsufficientEnergy.class)
	public void testGeneratingEMPConsumesEnergy() throws InsufficientEnergy, NonexistentPower {
		MagicalUnit nave = NaveCienciaTemplate.getInstance().create(new Point(1,2));
		// Sumo 50 energia
		nave.update();
		nave.update();
		nave.update();
		nave.update();
		nave.update();
		
		nave.usePower("EMP");
		
		// No puedo generar otro sin mas energia
		nave.usePower("EMP");
	}
	
	@Test
	public void testGeneratingEMPDestroysProtossShield() throws InsufficientEnergy, NonexistentPower {
		MagicalUnit nave = NaveCienciaTemplate.getInstance().create(new Point(1,2));
		// Sumo 50 energia
		nave.update();
		nave.update();
		nave.update();
		nave.update();
		nave.update();
		Power emp = nave.usePower("EMP");
		MuggleUnit zealot = ZealotTemplate.getInstance().create(new Point(1,2));
		List<Unit> affected = new LinkedList<Unit>();
		affected.add(zealot);
		emp.lockUnits(affected);
		emp.activate();
		
		emp.execute();
		
		assertEquals(zealot.getShield(), 0);
	}
	
	@Test(expected = InsufficientEnergy.class)
	public void testGeneratingEMPDrainsAltoTemplariosEnergy() throws InsufficientEnergy, NonexistentPower {
		MagicalUnit nave = NaveCienciaTemplate.getInstance().create(new Point(1,2));
		// Sumo 50 energia
		nave.update();
		nave.update();
		nave.update();
		nave.update();
		nave.update();
		
		Power emp = nave.usePower("EMP");
		MagicalUnit naveAfectada = NaveCienciaTemplate.getInstance().create(new Point(1,2));
		MagicalUnit templario = AltoTemplarioTemplate.getInstance().create(new Point(1,2));
		List<Unit> affected = new LinkedList<Unit>();
		affected.add(templario);
		affected.add(naveAfectada);
		emp.lockUnits(affected);
		emp.activate();
	
		emp.execute();
		
		templario.usePower("Alucinacion");
	}

	@Test(expected = InsufficientEnergy.class)
	public void testGeneratingEMPDrainsOthersNaveCienciasEnergy() throws InsufficientEnergy, NonexistentPower {
		MagicalUnit nave = NaveCienciaTemplate.getInstance().create(new Point(1,2));
		// Sumo 50 energia
		nave.update();
		nave.update();
		nave.update();
		nave.update();
		nave.update();
		
		Power emp = nave.usePower("EMP");
		MagicalUnit naveAfectada = NaveCienciaTemplate.getInstance().create(new Point(1,2));
		MagicalUnit templario = AltoTemplarioTemplate.getInstance().create(new Point(1,2));
		List<Unit> affected = new LinkedList<Unit>();
		affected.add(templario);
		affected.add(naveAfectada);
		emp.lockUnits(affected);
		emp.activate();
	
		emp.execute();
		
		naveAfectada.usePower("EMP");
	}
	
}
