package fiuba.algo3.starcraft.integration.structures;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.starcraft.logic.map.Map;
import fiuba.algo3.starcraft.logic.map.Parcel;
import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.map.areas.LandType;
import fiuba.algo3.starcraft.logic.map.exceptions.NoResourcesToExtract;
import fiuba.algo3.starcraft.logic.map.resources.ReservoirType;
import fiuba.algo3.starcraft.logic.player.Player;
import fiuba.algo3.starcraft.logic.player.Resources;
import fiuba.algo3.starcraft.logic.structures.Construction;
import fiuba.algo3.starcraft.logic.structures.ConstructionStructure;
import fiuba.algo3.starcraft.logic.structures.builders.ProtossBuilder;
import fiuba.algo3.starcraft.logic.structures.exceptions.ConstructionNotFinished;
import fiuba.algo3.starcraft.logic.structures.exceptions.InsufficientResources;
import fiuba.algo3.starcraft.logic.structures.exceptions.MissingStructureRequired;
import fiuba.algo3.starcraft.logic.structures.exceptions.QuotaExceeded;
import fiuba.algo3.starcraft.logic.structures.exceptions.TemplateNotFound;
import fiuba.algo3.starcraft.logic.templates.structures.protoss.AccesoTemplate;
import fiuba.algo3.starcraft.logic.templates.structures.protoss.ArchivosTemplariosTemplate;
import fiuba.algo3.starcraft.logic.templates.structures.protoss.PuertoEstelarProtossTemplate;
import fiuba.algo3.starcraft.logic.units.Unit;

public class ProtossConstructionStructureTest {
	Map map;
	Point position;
	Point position2;
	Resources initialResources;
	Player player;
	@Before
	public void before() {
		initialResources = new Resources(200,0);
		map = new Map(1000, null);
		position = new Point(54,70);
		position2 = new Point(10,70);
		player = new Player(null, null, new ProtossBuilder(), position, initialResources, map);
	}
	
	@Test
	public void testAccesoCanBeConstructedInParcelWithVolcano() throws InsufficientResources, MissingStructureRequired, TemplateNotFound, NoResourcesToExtract {
		Parcel parcel = map.getParcelContainingPoint(position);
		parcel.setSurface(LandType.land);
		parcel.setSurface(ReservoirType.volcano);
		
		player.newStructureWithName("Acceso", position);
		for(int i = 0; i < 9; i++) player.newTurn();
		
		assertEquals(parcel.getStructure().getName(), "Acceso");
	}
	
	@Test
	public void testAccesoCanBeConstructedInParcelWithMine() throws InsufficientResources, MissingStructureRequired, TemplateNotFound, NoResourcesToExtract {
		Parcel parcel = map.getParcelContainingPoint(position);
		parcel.setSurface(LandType.land);
		parcel.setSurface(ReservoirType.mine);
		
		player.newStructureWithName("Acceso", position);
		for(int i = 0; i < 9; i++) player.newTurn();
		
		assertEquals(parcel.getStructure().getName(), "Acceso");
	}
	
	@Test
	public void testAccesoCanBeConstructedInParcelWithNoExtractableSurface() throws InsufficientResources, MissingStructureRequired, TemplateNotFound, NoResourcesToExtract {
		Parcel parcel = map.getParcelContainingPoint(position);
		parcel.setSurface(LandType.land);
		
		player.newStructureWithName("Acceso", position);
		for(int i = 0; i < 9; i++) player.newTurn();
		
		assertEquals(parcel.getStructure().getName(), "Acceso");
	}
	
	//Pruebo que la unidad creada es la deseada segun su valor, vida, suministro y tiempo de construccion.
	@Test
	public void testCreateWithZealotTemplateReturnsZealot() throws QuotaExceeded, InsufficientResources, TemplateNotFound, ConstructionNotFinished {
		Resources resources = new Resources(100,0);
		ConstructionStructure acceso = new AccesoTemplate().create(new Point(500,500));
		
		Construction<Unit> construction = acceso.create("Zealot", new Point(500,500), resources, 0, 2);
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
		ConstructionStructure acceso = new AccesoTemplate().create(new Point(500,500));
		
		Construction<Unit> construction = acceso.create("Dragon", new Point(500,500), resources, 0, 2);
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
		ConstructionStructure puerto = new PuertoEstelarProtossTemplate().create(new Point(500,500));
		
		Construction<Unit> construction = puerto.create("Scout", new Point(500,500), resources, 0, 3);
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
		ConstructionStructure puerto = new PuertoEstelarProtossTemplate().create(new Point(500,500));
		
		Construction<Unit> construction = puerto.create("Nave Transporte", new Point(500,500), resources, 0, 2);
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
		ConstructionStructure archivos = new ArchivosTemplariosTemplate().create(new Point(500,500));
		
		Construction<Unit> construction = archivos.create("Alto Templario", new Point(500,500), resources, 0, 2);
		for(int i = 0; i < 7; i++) {
			construction.lowerRelease();
		}
		Unit templario = construction.gather();
		templario.reduceLife(80);
		
		assertTrue(!templario.itsAlive());
	}

}
