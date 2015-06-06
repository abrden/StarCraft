package fiuba.algo3.starcraft.logic.test.structures;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.starcraft.logic.player.Construction;
import fiuba.algo3.starcraft.logic.player.Resources;
import fiuba.algo3.starcraft.logic.structures.ConstructionStructure;
import fiuba.algo3.starcraft.logic.structures.exceptions.InsufficientResources;
import fiuba.algo3.starcraft.logic.structures.exceptions.QuotaExceeded;
import fiuba.algo3.starcraft.logic.structures.exceptions.TemplateNotFound;
import fiuba.algo3.starcraft.logic.templates.structures.protoss.AccesoTemplate;
import fiuba.algo3.starcraft.logic.templates.structures.protoss.ArchivosTemplariosTemplate;
import fiuba.algo3.starcraft.logic.templates.structures.protoss.PuertoEstelarProtossTemplate;
import fiuba.algo3.starcraft.logic.units.Unit;

public class ProtossConstructionStructureTest {

	//Pruebo que la unidad creada es la deseada segun su valor, vida, suministro y tiempo de construccion.
	@Test
	public void testCreateWithZealotTemplateReturnsZealot() throws QuotaExceeded, InsufficientResources, TemplateNotFound {
		Resources resources = new Resources(100,0);
		ConstructionStructure acceso = AccesoTemplate.getInstance().create();
		
		Construction<Unit> construction = acceso.create("Zealot", resources, 0, 2);
		for(int i = 0; i < 4; i++) {
			construction.lowerRelease();
		}
		Unit zealot = (Unit) construction.gather();
		zealot.reduceLife(160);
		
		assertTrue(!zealot.itsAlive());
	}
	
	@Test
	public void testCreateWithDragonTemplateReturnsDragon() throws QuotaExceeded, InsufficientResources, TemplateNotFound {
		Resources resources = new Resources(125,50);
		ConstructionStructure acceso = AccesoTemplate.getInstance().create();
		
		Construction<Unit> construction = acceso.create("Dragon", resources, 0, 2);
		for(int i = 0; i < 6; i++) {
			construction.lowerRelease();
		}
		Unit dragon = (Unit) construction.gather();
		dragon.reduceLife(180);
		
		assertTrue(!dragon.itsAlive());
	}
	
	@Test
	public void testCreateWithScoutTemplateReturnsScout() throws QuotaExceeded, InsufficientResources, TemplateNotFound {
		Resources resources = new Resources(300,150);
		ConstructionStructure puerto = PuertoEstelarProtossTemplate.getInstance().create();
		
		Construction<Unit> construction = puerto.create("Scout", resources, 0, 3);
		for(int i = 0; i < 9; i++) {
			construction.lowerRelease();
		}
		Unit scout = (Unit) construction.gather();
		scout.reduceLife(250);
		
		assertTrue(!scout.itsAlive());
	}
	
	@Test
	public void testCreateWithNaveProtossTemplateReturnsNaveProtoss() throws QuotaExceeded, InsufficientResources, TemplateNotFound {
		Resources resources = new Resources(200,0);
		ConstructionStructure puerto = PuertoEstelarProtossTemplate.getInstance().create();
		
		Construction<Unit> construction = puerto.create("Nave Transporte", resources, 0, 2);
		for(int i = 0; i < 8; i++) {
			construction.lowerRelease();
		}
		Unit nave = (Unit) construction.gather();
		nave.reduceLife(140);
		
		assertTrue(!nave.itsAlive());
	}
	
	@Test
	public void testCreateWithAltoTemplarioTemplateReturnsAltoTemplario() throws QuotaExceeded, InsufficientResources, TemplateNotFound {
		Resources resources = new Resources(50,150);
		ConstructionStructure archivos = ArchivosTemplariosTemplate.getInstance().create();
		
		Construction<Unit> construction = archivos.create("Alto Templario", resources, 0, 2);
		for(int i = 0; i < 7; i++) {
			construction.lowerRelease();
		}
		Unit templario = (Unit) construction.gather();
		templario.reduceLife(80);
		
		assertTrue(!templario.itsAlive());
	}

}
