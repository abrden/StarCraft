package fiuba.algo3.starcraft.integration.structures;

import static org.junit.Assert.*;

import fiuba.algo3.starcraft.logic.structures.exceptions.*;
import org.junit.Test;

import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.player.Resources;
import fiuba.algo3.starcraft.logic.structures.Construction;
import fiuba.algo3.starcraft.logic.structures.ConstructionStructure;
import fiuba.algo3.starcraft.logic.templates.structures.terran.BarracaTemplate;
import fiuba.algo3.starcraft.logic.templates.structures.terran.FabricaTemplate;
import fiuba.algo3.starcraft.logic.templates.structures.terran.PuertoEstelarTerranTemplate;
import fiuba.algo3.starcraft.logic.units.Unit;

public class TerranConstructionStructureTest {

	//Pruebo que la unidad creada es la deseada segun su valor, vida, suministro y tiempo de construccion.
	@Test
	public void testCreateWithMarineTemplateReturnsMarine() throws QuotaExceeded, InsufficientResources, TemplateNotFound, ConstructionNotFinished, ConstructorIsDead {
		Resources resources = new Resources(50,0); // Valor = 50M
		ConstructionStructure barraca = new BarracaTemplate().create(new Point(500,500));
		
		Construction<Unit> construction = barraca.create("Marine", new Point(500,500), resources, 0, 1); // Suministro = 1
		for(int i = 0; i < 3; i++) { // Tiempo de construccion = 3
			construction.lowerRelease();
		}
		Unit marine = construction.gather();
		marine.reduceLife(40); // Vida = 40
		
		assertTrue(!marine.itsAlive());
	}
	
	@Test
	public void testCreateWithGolliatTemplateReturnsGolliat() throws QuotaExceeded, InsufficientResources, TemplateNotFound, ConstructionNotFinished, ConstructorIsDead {
		Resources resources = new Resources(100,50);
		ConstructionStructure fabrica = new FabricaTemplate().create(new Point(500,500));
		
		Construction<Unit> construction = fabrica.create("Golliat", new Point(500,500), resources, 0, 2);
		for(int i = 0; i < 6; i++) {
			construction.lowerRelease();
		}
		Unit golliat = construction.gather();
		golliat.reduceLife(125);
		
		assertTrue(!golliat.itsAlive());
	}
	
	@Test
	public void testCreateWithEspectroTemplateReturnsEspectro() throws QuotaExceeded, InsufficientResources, TemplateNotFound, ConstructionNotFinished, ConstructorIsDead {
		Resources resources = new Resources(150,100);
		ConstructionStructure puerto = new PuertoEstelarTerranTemplate().create(new Point(500,500));
		
		Construction<Unit> construction = puerto.create("Espectro", new Point(500,500), resources, 0, 2);
		for(int i = 0; i < 8; i++) {
			construction.lowerRelease();
		}
		Unit espectro = construction.gather();
		espectro.reduceLife(120);
		
		assertTrue(!espectro.itsAlive());
	}
	
	@Test
	public void testCreateWithNaveCienciaTemplateReturnsNaveCiencia() throws QuotaExceeded, InsufficientResources, TemplateNotFound, ConstructionNotFinished, ConstructorIsDead {
		Resources resources = new Resources(100,225);
		ConstructionStructure puerto = new PuertoEstelarTerranTemplate().create(new Point(500,500));
		
		Construction<Unit> construction = puerto.create("Nave Ciencia", new Point(500,500), resources, 0, 2);
		for(int i = 0; i < 10; i++) {
			construction.lowerRelease();
		}
		Unit nave = construction.gather();
		nave.reduceLife(200);
		
		assertTrue(!nave.itsAlive());
	}
	
	@Test
	public void testCreateWithNaveTerranTemplateReturnsNaveTerran() throws QuotaExceeded, InsufficientResources, TemplateNotFound, ConstructionNotFinished, ConstructorIsDead {
		Resources resources = new Resources(100,100);
		ConstructionStructure puerto = new PuertoEstelarTerranTemplate().create(new Point(500,500));
		
		Construction<Unit> construction = puerto.create("Nave Transporte Terran", new Point(500,500), resources, 0, 2);
		for(int i = 0; i < 7; i++) {
			construction.lowerRelease();
		}
		Unit nave = construction.gather();
		nave.reduceLife(150);
		
		assertTrue(!nave.itsAlive());
	}
}
