package fiuba.algo3.starcraft.integration.player;

import fiuba.algo3.starcraft.logic.map.Map;
import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.map.exceptions.NoReachableTransport;
import fiuba.algo3.starcraft.logic.map.exceptions.UnitCanotBeSetHere;
import fiuba.algo3.starcraft.logic.player.Player;
import fiuba.algo3.starcraft.logic.player.Resources;
import fiuba.algo3.starcraft.logic.structures.builders.ProtossBuilder;
import fiuba.algo3.starcraft.logic.templates.units.protoss.DragonTemplate;
import fiuba.algo3.starcraft.logic.templates.units.protoss.NaveTransporteProtossTemplate;
import fiuba.algo3.starcraft.logic.templates.units.protoss.ScoutTemplate;
import fiuba.algo3.starcraft.logic.templates.units.protoss.ZealotTemplate;
import fiuba.algo3.starcraft.logic.units.MuggleUnit;
import fiuba.algo3.starcraft.logic.units.TransportUnit;
import fiuba.algo3.starcraft.logic.units.exceptions.NoMoreSpaceInUnit;
import fiuba.algo3.starcraft.logic.units.exceptions.NoUnitToRemove;
import fiuba.algo3.starcraft.logic.units.exceptions.StepsLimitExceeded;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TransportUnitTest {

    TransportUnit naveTransporte;
    MuggleUnit zealot, dragon, scout;
    Player player;
    Map map;
    Point spacePoint, move1Point, move2Point;

    @Before
    public void before() {
        map = new Map(1000,null);
        player = new Player("Pepe",null, new ProtossBuilder(),new Point(1,1), new Resources(9999,9999),map);
        zealot = new ZealotTemplate().create(new Point(2,2));
        dragon = new DragonTemplate().create(new Point(5,5));
        scout = new ScoutTemplate().create(new Point(3,3));
        naveTransporte = new NaveTransporteProtossTemplate().create(new Point(3,3));
        spacePoint = new Point(100,100);
        move1Point = new Point(150,150);
        move2Point = new Point(25,25);
    }

    @Test
    public void testNaveTransporteMovesToSpaceThenToLandAndDisembarksBothNonFlyingUnits() throws StepsLimitExceeded, NoMoreSpaceInUnit, UnitCanotBeSetHere, NoUnitToRemove, NoReachableTransport {
        map.getParcelContainingPoint(spacePoint).setAirSurface();
        player.receiveNewUnit(zealot);
        player.receiveNewUnit(dragon);
        player.receiveNewUnit(naveTransporte);

        player.embark(zealot);
        player.embark(dragon);

        player.move(naveTransporte,move1Point);
        for (int i = 0; i < 50; i++) {
            player.newTurn();
        }
        player.move(naveTransporte, move2Point);
        for (int i = 0; i < 50; i++) {
            player.newTurn();
        }

        player.disembark(naveTransporte, zealot);
        player.disembark(naveTransporte, dragon);

        assertTrue(dragon.getPosition().getX() == dragon.getPosition().getY());
        assertTrue(zealot.getPosition().getX() == zealot.getPosition().getY());
    }

    @Test
    public void testNaveTransporteMovesToSpaceDropsUnitThenMovesToLandAndDropsANonFlyingUnit() throws StepsLimitExceeded, NoMoreSpaceInUnit, UnitCanotBeSetHere, NoUnitToRemove, NoReachableTransport {
        map.getParcelContainingPoint(spacePoint).setAirSurface();
        player.receiveNewUnit(zealot);
        player.receiveNewUnit(scout);
        player.receiveNewUnit(naveTransporte);

        player.embark(zealot);
        player.embark(scout);

        player.move(naveTransporte, move1Point);
        for (int i = 0; i < 50; i++) {
            player.newTurn();
        }
        player.disembark(naveTransporte, scout);

        player.move(naveTransporte, move2Point);
        for (int i = 0; i < 50; i++) {
            player.newTurn();
        }

        player.disembark(naveTransporte, zealot);

        assertTrue(scout.getPosition().getX() == scout.getPosition().getY());
        assertTrue(zealot.getPosition().getX() == zealot.getPosition().getY());
    }

    @Test(expected = UnitCanotBeSetHere.class)
    public void testNaveTransporteMovesToSpaceDropsUnitAndThrowsException() throws StepsLimitExceeded, NoMoreSpaceInUnit, UnitCanotBeSetHere, NoUnitToRemove, NoReachableTransport {
        map.getParcelContainingPoint(spacePoint).setAirSurface();
        player.receiveNewUnit(zealot);
        player.receiveNewUnit(naveTransporte);

        player.embark(zealot);

        player.move(naveTransporte, move1Point);
        for (int i = 0; i < 100; i++) {
            player.newTurn();
        }

        player.disembark(naveTransporte, zealot);
    }
    
    @Test
    public void testIfNaveTransporteDiesAllOfTheirPassengersDie() throws StepsLimitExceeded, NoMoreSpaceInUnit, NoUnitToRemove, UnitCanotBeSetHere, NoReachableTransport {
        player.receiveNewUnit(zealot);
        player.receiveNewUnit(scout);
        player.receiveNewUnit(naveTransporte);

        player.embark(zealot);
        player.embark(scout);
        
        naveTransporte.reduceLife(1000000);
        assertTrue(!naveTransporte.itsAlive());
        
        assertTrue(!zealot.itsAlive());
        assertTrue(!scout.itsAlive());
    }
}
