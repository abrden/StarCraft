package fiuba.algo3.starcraft.test.structures.construction;

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
import fiuba.algo3.starcraft.logic.templates.structures.terran.BarracaTemplate;
import fiuba.algo3.starcraft.logic.templates.structures.terran.FabricaTemplate;
import fiuba.algo3.starcraft.logic.templates.structures.terran.PuertoEstelarTerranTemplate;
import fiuba.algo3.starcraft.logic.units.Unit;

public class UnitCreationTest {

	//Por el momento, pruebo que la unidad deseada es la creada segun su precio, su vida y su suministro.
	@Test
	public void testCreateWithMarineTemplateReturnsMarine() throws QuotaExceeded, InsufficientResources, TemplateNotFound {
		Resources resources = new Resources(50,0);
		ConstructionStructure barraca = BarracaTemplate.getInstance().create();
		
		Construction construction = barraca.create("Marine", resources, 1);
		while(!construction.itsFinished()) {
			construction.lowerRelease();
		}
		Unit marine = (Unit) construction.gather();
		marine.reduceLife(40);
		
		assertTrue(!marine.itsAlive());
	}
	
	@Test
	public void testCreateWithGolliatTemplateReturnsGolliat() throws QuotaExceeded, InsufficientResources, TemplateNotFound {
		Resources resources = new Resources(100,50);
		ConstructionStructure fabrica = FabricaTemplate.getInstance().create();
		
		Construction construction = fabrica.create("Golliat", resources, 2);
		while(!construction.itsFinished()) {
			construction.lowerRelease();
		}
		Unit golliat = (Unit) construction.gather();
		golliat.reduceLife(125);
		
		assertTrue(!golliat.itsAlive());
	}
	
	@Test
	public void testCreateWithEspectroTemplateReturnsEspectro() throws QuotaExceeded, InsufficientResources, TemplateNotFound {
		Resources resources = new Resources(150,100);
		ConstructionStructure puerto = PuertoEstelarTerranTemplate.getInstance().create();
		
		Construction construction = puerto.create("Espectro", resources, 2);
		while(!construction.itsFinished()) {
			construction.lowerRelease();
		}
		Unit espectro = (Unit) construction.gather();
		espectro.reduceLife(120);
		
		assertTrue(!espectro.itsAlive());
	}
	
	@Test
	public void testCreateWithNaveCienciaTemplateReturnsNaveCiencia() throws QuotaExceeded, InsufficientResources, TemplateNotFound {
		Resources resources = new Resources(100,225);
		ConstructionStructure puerto = PuertoEstelarTerranTemplate.getInstance().create();
		
		Construction construction = puerto.create("Nave Ciencia", resources, 2);
		while(!construction.itsFinished()) {
			construction.lowerRelease();
		}
		Unit nave = (Unit) construction.gather();
		nave.reduceLife(200);
		
		assertTrue(!nave.itsAlive());
	}
	
	@Test
	public void testCreateWithNaveTerranTemplateReturnsNaveTerran() throws QuotaExceeded, InsufficientResources, TemplateNotFound {
		Resources resources = new Resources(100,100);
		ConstructionStructure puerto = PuertoEstelarTerranTemplate.getInstance().create();
		
		Construction construction = puerto.create("Nave Transporte", resources, 2);
		while(!construction.itsFinished()) {
			construction.lowerRelease();
		}
		Unit nave = (Unit) construction.gather();
		nave.reduceLife(150);
		
		assertTrue(!nave.itsAlive());
	}
	
	@Test
	public void testCreateWithZealotTemplateReturnsZealot() throws QuotaExceeded, InsufficientResources, TemplateNotFound {
		Resources resources = new Resources(100,0);
		ConstructionStructure acceso = AccesoTemplate.getInstance().create();
		
		Construction construction = acceso.create("Zealot", resources, 2);
		while(!construction.itsFinished()) {
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
		
		Construction construction = acceso.create("Dragon", resources, 2);
		while(!construction.itsFinished()) {
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
		
		Construction construction = puerto.create("Scout", resources, 3);
		while(!construction.itsFinished()) {
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
		
		Construction construction = puerto.create("Nave Transporte", resources, 2);
		while(!construction.itsFinished()) {
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
		
		Construction construction = archivos.create("Alto Templario", resources, 2);
		while(!construction.itsFinished()) {
			construction.lowerRelease();
		}
		Unit templario = (Unit) construction.gather();
		templario.reduceLife(80);
		
		assertTrue(!templario.itsAlive());
	}
}
