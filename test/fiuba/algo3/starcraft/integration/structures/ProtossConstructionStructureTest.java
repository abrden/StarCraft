package fiuba.algo3.starcraft.integration.structures;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.starcraft.logic.player.Resources;
import fiuba.algo3.starcraft.logic.structures.Construction;
import fiuba.algo3.starcraft.logic.structures.ConstructionStructure;
import fiuba.algo3.starcraft.logic.structures.exceptions.ConstructionNotFinished;
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
	public void testCreateWithZealotTemplateReturnsZealot() throws QuotaExceeded, InsufficientResources, TemplateNotFound, ConstructionNotFinished {
		Resources resources = new Resources(100,0);
		ConstructionStructure acceso = new AccesoTemplate().create(null);
		
		Construction<Unit> construction = acceso.create("Zealot", null, resources, 0, 2);
		for(int i = 0; i < 4; i++) {
			construction.lowerRelease();
		}
		Unit zealot = construction.gather();
		zealot.reduceLife(160);
		
		assertTrue(!zealot.itsAlive());
	}
	
	@Test
	public void testCreateWithDragonTemplateReturnsDragon() throws QuotaExceeded, InsufficientResources, TemplateNotFound, ConstructionNotFinished {
		Resources resources = new Resources(125,50);
		ConstructionStructure acceso = new AccesoTemplate().create(null);
		
		Construction<Unit> construction = acceso.create("Dragon", null, resources, 0, 2);
		for(int i = 0; i < 6; i++) {
			construction.lowerRelease();
		}
		Unit dragon = construction.gather();
		dragon.reduceLife(180);
		
		assertTrue(!dragon.itsAlive());
	}
	
	@Test
	public void testCreateWithScoutTemplateReturnsScout() throws QuotaExceeded, InsufficientResources, TemplateNotFound, ConstructionNotFinished {
		Resources resources = new Resources(300,150);
		ConstructionStructure puerto = new PuertoEstelarProtossTemplate().create(null);
		
		Construction<Unit> construction = puerto.create("Scout", null, resources, 0, 3);
		for(int i = 0; i < 9; i++) {
			construction.lowerRelease();
		}
		Unit scout = construction.gather();
		scout.reduceLife(250);
		
		assertTrue(!scout.itsAlive());
	}
	
	@Test
	public void testCreateWithNaveProtossTemplateReturnsNaveProtoss() throws QuotaExceeded, InsufficientResources, TemplateNotFound, ConstructionNotFinished {
		Resources resources = new Resources(200,0);
		ConstructionStructure puerto = new PuertoEstelarProtossTemplate().create(null);
		
		Construction<Unit> construction = puerto.create("Nave Transporte", null, resources, 0, 2);
		for(int i = 0; i < 8; i++) {
			construction.lowerRelease();
		}
		Unit nave = construction.gather();
		nave.reduceLife(140);
		
		assertTrue(!nave.itsAlive());
	}
	
	@Test
	public void testCreateWithAltoTemplarioTemplateReturnsAltoTemplario() throws QuotaExceeded, InsufficientResources, TemplateNotFound, ConstructionNotFinished {
		Resources resources = new Resources(50,150);
		ConstructionStructure archivos = new ArchivosTemplariosTemplate().create(null);
		
		Construction<Unit> construction = archivos.create("Alto Templario", null, resources, 0, 2);
		for(int i = 0; i < 7; i++) {
			construction.lowerRelease();
		}
		Unit templario = construction.gather();
		templario.reduceLife(80);
		
		assertTrue(!templario.itsAlive());
	}

}
