package fiuba.algo3.starcraft.test.structures.construction;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.starcraft.logic.player.Resources;
import fiuba.algo3.starcraft.logic.structures.ConstructionStructure;
import fiuba.algo3.starcraft.logic.structures.InsufficientResources;
import fiuba.algo3.starcraft.logic.structures.QuotaExceeded;
import fiuba.algo3.starcraft.logic.templates.AccesoTemplate;
import fiuba.algo3.starcraft.logic.templates.ArchivosTemplariosTemplate;
import fiuba.algo3.starcraft.logic.templates.BarracaTemplate;
import fiuba.algo3.starcraft.logic.templates.FabricaTemplate;
import fiuba.algo3.starcraft.logic.templates.PuertoEstelarProtossTemplate;
import fiuba.algo3.starcraft.logic.templates.PuertoEstelarTerranTemplate;
import fiuba.algo3.starcraft.logic.templates.TemplateID;
import fiuba.algo3.starcraft.logic.units.Unit;

public class UnitCreationTest {

	//Por el momento, pruebo que la unidad deseada es la creada segun su precio, su vida y su suministro.
	@Test
	public void testCreateWithMarineTemplateReturnsMarine() throws QuotaExceeded, InsufficientResources {
		Resources resources = new Resources(50,0);
		ConstructionStructure barraca = BarracaTemplate.getInstance().create();
		
		Unit marine = barraca.createUnit(TemplateID.MarineTemplate, resources, 1);
		marine.reduceLife(40);
		
		assertTrue(!marine.itsAlive());
	}
	
	@Test
	public void testCreateWithGolliatTemplateReturnsGolliat() throws QuotaExceeded, InsufficientResources {
		Resources resources = new Resources(100,50);
		ConstructionStructure fabrica = FabricaTemplate.getInstance().create();
		
		Unit golliat = fabrica.createUnit(TemplateID.GolliatTemplate, resources, 2);
		golliat.reduceLife(125);
		
		assertTrue(!golliat.itsAlive());
	}
	
	@Test
	public void testCreateWithEspectroTemplateReturnsEspectro() throws QuotaExceeded, InsufficientResources {
		Resources resources = new Resources(150,100);
		ConstructionStructure puerto = PuertoEstelarTerranTemplate.getInstance().create();
		
		Unit espectro = puerto.createUnit(TemplateID.EspectroTemplate, resources, 2);
		espectro.reduceLife(120);
		
		assertTrue(!espectro.itsAlive());
	}
	
	@Test
	public void testCreateWithNaveCienciaTemplateReturnsNaveCiencia() throws QuotaExceeded, InsufficientResources {
		Resources resources = new Resources(100,225);
		ConstructionStructure puerto = PuertoEstelarTerranTemplate.getInstance().create();
		
		Unit nave = puerto.createUnit(TemplateID.NaveCienciaTemplate, resources, 2);
		nave.reduceLife(200);
		
		assertTrue(!nave.itsAlive());
	}
	
	@Test
	public void testCreateWithNaveTerranTemplateReturnsNaveTerran() throws QuotaExceeded, InsufficientResources {
		Resources resources = new Resources(100,100);
		ConstructionStructure puerto = PuertoEstelarTerranTemplate.getInstance().create();
		
		Unit nave = puerto.createUnit(TemplateID.NaveTransporteTerranTemplate, resources, 2);
		nave.reduceLife(150);
		
		assertTrue(!nave.itsAlive());
	}
	
	@Test
	public void testCreateWithZealotTemplateReturnsZealot() throws QuotaExceeded, InsufficientResources {
		Resources resources = new Resources(100,0);
		ConstructionStructure acceso = AccesoTemplate.getInstance().create();
		
		Unit zealot = acceso.createUnit(TemplateID.ZealotTemplate, resources, 2);
		zealot.reduceLife(160);
		
		assertTrue(!zealot.itsAlive());
	}
	
	@Test
	public void testCreateWithDragonTemplateReturnsDragon() throws QuotaExceeded, InsufficientResources {
		Resources resources = new Resources(125,50);
		ConstructionStructure acceso = AccesoTemplate.getInstance().create();
		
		Unit dragon = acceso.createUnit(TemplateID.DragonTemplate, resources, 2);
		dragon.reduceLife(180);
		
		assertTrue(!dragon.itsAlive());
	}
	
	@Test
	public void testCreateWithScoutTemplateReturnsScout() throws QuotaExceeded, InsufficientResources {
		Resources resources = new Resources(300,150);
		ConstructionStructure puerto = PuertoEstelarProtossTemplate.getInstance().create();
		
		Unit scout = puerto.createUnit(TemplateID.ScoutTemplate, resources, 3);
		scout.reduceLife(250);
		
		assertTrue(!scout.itsAlive());
	}
	
	@Test
	public void testCreateWithNaveProtossTemplateReturnsNaveProtoss() throws QuotaExceeded, InsufficientResources {
		Resources resources = new Resources(200,0);
		ConstructionStructure puerto = PuertoEstelarProtossTemplate.getInstance().create();
		
		Unit nave = puerto.createUnit(TemplateID.NaveTransporteProtossTemplate, resources, 2);
		nave.reduceLife(140);
		
		assertTrue(!nave.itsAlive());
	}
	
	@Test
	public void testCreateWithAltoTemplarioTemplateReturnsAltoTemplario() throws QuotaExceeded, InsufficientResources {
		Resources resources = new Resources(50,150);
		ConstructionStructure archivos = ArchivosTemplariosTemplate.getInstance().create();
		
		Unit templario = archivos.createUnit(TemplateID.AltoTemplarioTemplate, resources, 2);
		templario.reduceLife(80);
		
		assertTrue(!templario.itsAlive());
	}
}
