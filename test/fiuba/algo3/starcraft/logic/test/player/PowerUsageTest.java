package fiuba.algo3.starcraft.logic.test.player;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.starcraft.logic.game.StarCraft;
import fiuba.algo3.starcraft.logic.map.Map;
import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.player.Player;
import fiuba.algo3.starcraft.logic.structures.builders.ProtossBuilder;
import fiuba.algo3.starcraft.logic.structures.builders.TerranBuilder;
import fiuba.algo3.starcraft.logic.templates.qualities.TormentaPsionica;
import fiuba.algo3.starcraft.logic.templates.units.protoss.AltoTemplarioTemplate;
import fiuba.algo3.starcraft.logic.templates.units.protoss.DragonTemplate;
import fiuba.algo3.starcraft.logic.templates.units.protoss.ZealotTemplate;
import fiuba.algo3.starcraft.logic.templates.units.terran.EspectroTemplate;
import fiuba.algo3.starcraft.logic.templates.units.terran.GolliatTemplate;
import fiuba.algo3.starcraft.logic.templates.units.terran.MarineTemplate;
import fiuba.algo3.starcraft.logic.templates.units.terran.NaveCienciaTemplate;
import fiuba.algo3.starcraft.logic.units.Clone;
import fiuba.algo3.starcraft.logic.units.MagicalUnit;
import fiuba.algo3.starcraft.logic.units.MuggleUnit;
import fiuba.algo3.starcraft.logic.units.Unit;
import fiuba.algo3.starcraft.logic.units.exceptions.InsufficientEnergy;
import fiuba.algo3.starcraft.logic.units.exceptions.NonexistentPower;

public class PowerUsageTest {

	StarCraft game;
	Map map;
	Player player1;
	Player player2;
	Point position;
	Point position2;
	Point position3;
	
	MagicalUnit templario;
	MuggleUnit dragon;
	MuggleUnit zealot;
	MagicalUnit nave;
	MuggleUnit marine;
	MuggleUnit golliat;
	MuggleUnit espectro;
	
	@Before
	public void before() {
		game = new StarCraft();
		map = new Map(1000, game);
		player1 = new Player(null, null, new TerranBuilder(), null, null, map);
		player2 = new Player(null, null, new ProtossBuilder(), null, null, map);

		game.setGame(player1,player2,map);
		position = new Point(1,1);
		position2 = new Point (270,340);
		position3 = new Point (70,34);
		
		templario = new AltoTemplarioTemplate().create(position);
		dragon = new DragonTemplate().create(position);
		zealot = new ZealotTemplate().create(position3);
		nave = new NaveCienciaTemplate().create(position2);
		marine = new MarineTemplate().create(position2);
		golliat = new GolliatTemplate().create(position2);
		espectro = new EspectroTemplate().create(position3);
	}
    
	@Test
	public void testEMPDestroysDragonsShield() throws InsufficientEnergy, NonexistentPower {
		player2.receiveNewUnit(dragon);
		player1.receiveNewUnit(nave);
		for (int i = 0; i < 5; i++) nave.update();
		
		player1.usePower(nave, "EMP", position);

		assertEquals(dragon.getShield(), 0);
	}
	
	@Test(expected = InsufficientEnergy.class)
	public void testEMPWastedNaveCienciasEnergy() throws InsufficientEnergy, NonexistentPower {
		player2.receiveNewUnit(templario);
		player1.receiveNewUnit(nave);
		for (int i = 0; i < 5; i++) nave.update();
		
		player1.usePower(nave, "EMP", position2);
		
		player1.usePower(nave, "EMP", position);
		assertTrue(false);
	}
	
	@Test(expected = InsufficientEnergy.class)
	public void testEMPDrainsAltoTemplariosEnergy() throws InsufficientEnergy, NonexistentPower {
		player2.receiveNewUnit(templario);
		player1.receiveNewUnit(nave);
		for (int i = 0; i < 5; i++) nave.update();
		
		player1.usePower(nave, "EMP", position);

		player2.usePower(templario, "Tormenta Psionica", position2);
		assertTrue(false);
	}
	
	@Test(expected = InsufficientEnergy.class)
	public void testEMPDrainsAffectedNaveCienciasEnergy() throws InsufficientEnergy, NonexistentPower {
		player2.receiveNewUnit(templario);
		player1.receiveNewUnit(nave);
		for (int i = 0; i < 5; i++) nave.update();
		MagicalUnit affectedNave = new NaveCienciaTemplate().create(position);
		player1.receiveNewUnit(affectedNave);
		
		player1.usePower(nave, "EMP", position);

		player1.usePower(affectedNave, "EMP", position2);
		assertTrue(false);
	}
	
	@Test
	public void testEMPDOutOfRangeDoesntHurtOpponentUnits() throws InsufficientEnergy, NonexistentPower {
		player2.receiveNewUnit(dragon);
		player2.receiveNewUnit(templario);
        player1.receiveNewUnit(nave);
        //int dragonInitialShield = dragon.getShield();

		for (int i = 0; i < 50; i++) templario.update();
		for (int i = 0; i < 50; i++) nave.update();

        player1.usePower(nave, "EMP", position3);

		assertEquals(dragon.getShield(), 0);
	}
	
	@Test
	public void testTormentaPsionicaLowersHealthOfOpponentUnits() throws InsufficientEnergy, NonexistentPower {
		player2.receiveNewUnit(templario);
		for (int i = 0; i < 5; i++) templario.update();
		player1.receiveNewUnit(marine);
		int initialMarineHealth = marine.getHealth();
		player1.receiveNewUnit(golliat);
		int initialGolliatHealth = golliat.getHealth();

		player2.usePower(templario, "Tormenta Psionica", position2);

		assertEquals(marine.getHealth(), initialMarineHealth - TormentaPsionica.DAMAGE);
		assertEquals(golliat.getHealth(), initialGolliatHealth - TormentaPsionica.DAMAGE);
	}
	
	@Test
	public void testTormentaPsionicaLowersHealthOfOpponentUnitsTwice() throws InsufficientEnergy, NonexistentPower {
		player2.receiveNewUnit(templario);
		for (int i = 0; i < 5; i++) templario.update();
		player1.receiveNewUnit(marine);
		int initialMarineHealth = marine.getHealth();

		player2.usePower(templario, "Tormenta Psionica", position2);
		for (int i = 0; i < 15; i++) player2.newTurn();
		
		assertEquals(marine.getHealth(), initialMarineHealth - (2*TormentaPsionica.DAMAGE));
	}
	
	@Test
	public void testEMPKillsCloneInstantly() throws InsufficientEnergy, NonexistentPower {
		Clone clone = new Clone(templario);
		player2.receiveNewUnit(clone);
		player1.receiveNewUnit(nave);
		for (int i = 0; i < 5; i++) nave.update();

		player1.usePower(nave, "EMP", position);
		
		assertTrue(!clone.itsAlive());
	}
	
	@Test
	public void testAlucinacionClonesPlayersUnit() throws InsufficientEnergy, NonexistentPower {
		player2.receiveNewUnit(templario);
		player2.receiveNewUnit(zealot);
		for (int i = 0; i < 5; i++) templario.update();
		player1.receiveNewUnit(espectro);

		player2.usePower(templario, "Alucinacion", position3);
		Unit clone = null;
		for (Unit unit : player2.getUnits())
			if (unit.getClass() == Clone.class)
				clone = unit;
		
		assertEquals(clone.getName(), "Zealot");
		assertEquals(clone.getShield(), 60);
		assertEquals(clone.getStepsPerTurn(), 350);
		assertEquals(clone.getVision(), 700);
	}

	@Test
	public void testAlucinacionGeneratesTwoClones() throws InsufficientEnergy, NonexistentPower {
		player2.receiveNewUnit(templario);
		player2.receiveNewUnit(zealot);
		for (int i = 0; i < 5; i++) templario.update();
		assertEquals(player2.numberOfUnits(), 2);
		player1.receiveNewUnit(espectro);

		player2.usePower(templario, "Alucinacion", position3);
		
		assertEquals(player2.numberOfUnits(), 4);
	}
}
