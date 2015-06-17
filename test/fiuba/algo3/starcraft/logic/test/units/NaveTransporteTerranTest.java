package fiuba.algo3.starcraft.logic.test.units;

import fiuba.algo3.starcraft.logic.map.Map;
import fiuba.algo3.starcraft.logic.map.Parcel;
import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.map.areas.LandType;
import fiuba.algo3.starcraft.logic.map.exceptions.UnitCanotBeSetHere;
import fiuba.algo3.starcraft.logic.player.Player;
import fiuba.algo3.starcraft.logic.structures.builders.TerranBuilder;
import fiuba.algo3.starcraft.logic.templates.units.terran.MarineTemplate;
import fiuba.algo3.starcraft.logic.templates.units.terran.NaveTransporteTerranTemplate;
import fiuba.algo3.starcraft.logic.units.TransportUnit;
import fiuba.algo3.starcraft.logic.units.Transportable;
import fiuba.algo3.starcraft.logic.units.Unit;
import static org.junit.Assert.assertEquals;
import fiuba.algo3.starcraft.logic.units.exceptions.NoMoreSpaceInUnit;
import fiuba.algo3.starcraft.logic.units.exceptions.NoUnitToRemove;
import fiuba.algo3.starcraft.logic.units.exceptions.StepsLimitExceeded;

import org.junit.Before;
import org.junit.Test;

public class NaveTransporteTerranTest {
    TransportUnit navetrans;
    Unit marine;

    @Before
    public void before() {
        navetrans = new NaveTransporteTerranTemplate().create(new Point(500,500));
        marine = new MarineTemplate().create(new Point(500,500));
    }

    @Test
    public void testNaveTransporteTerranEmbarksMarineFreeSpaceDownTo7() throws NoMoreSpaceInUnit, StepsLimitExceeded{
        navetrans.embark((Transportable) marine);

        assertEquals(7, navetrans.freeSpace());
    }

    @Test
    public void testNaveTransporteTerranDisembarksMarineFreeSpaceBackTo8() throws NoMoreSpaceInUnit, NoUnitToRemove, StepsLimitExceeded {
        navetrans.embark((Transportable) marine);
        navetrans.disembark((Transportable) marine);

        assertEquals(8, navetrans.freeSpace());
    }

    @Test
    public void testNaveTransporteTerranEmbarks8MarinesNoFreeSpaceLeft() throws NoMoreSpaceInUnit, StepsLimitExceeded {
        for (int i = 0; i<8; i++)
            navetrans.embark((Transportable) marine);

        assertEquals(0, navetrans.freeSpace());
    }

    @Test(expected = NoMoreSpaceInUnit.class)
    public void testNaveTransporteTerranThrowsExceptionWhenTryingToEmbark9Marines() throws NoMoreSpaceInUnit, StepsLimitExceeded {
        for (int i = 0; i<9; i++)
            navetrans.embark((Transportable) marine);
    }

    @Test(expected = NoUnitToRemove.class)
    public void testNaveTransporteTerranThrowsExceptionWhenTryingToDisembarkWithoutUnitsIn() throws NoUnitToRemove, StepsLimitExceeded{
        navetrans.disembark((Transportable) marine);
    }

    @Test
    public void testNaveTransporteTerranEmbarksAndDisembarksUnitsInTheSamePlace() throws StepsLimitExceeded, NoMoreSpaceInUnit, NoUnitToRemove {
        navetrans.embark((Transportable) marine);
        navetrans.disembark((Transportable) marine);

        assertEquals(marine.getPosition().getX() == navetrans.getPosition().getX(), marine.getPosition().getY() == navetrans.getPosition().getY());
    }

    @Test
    public void testNaveTransporteTerranEmbarksUnitMovesAndDisembarksUnitIsOnTheSamePointAsTheShip() throws StepsLimitExceeded, NoMoreSpaceInUnit, NoUnitToRemove {
        navetrans.embark((Transportable) marine);
        navetrans.disembark((Transportable) marine);

        navetrans.setPosition(new Point(510, 510));

        assertEquals(marine.getPosition().getX() == navetrans.getPosition().getX(), marine.getPosition().getY() == navetrans.getPosition().getY());
    }

    @Test(expected = UnitCanotBeSetHere.class)
    public void testNaveTransporteTerranCantDisembarkANonFlyingUnitInSpace() throws StepsLimitExceeded, NoUnitToRemove, NoMoreSpaceInUnit, UnitCanotBeSetHere {
        Map map = new Map(1000,null);
        Parcel parcel = map.getParcelContainingPoint(new Point(495,495));
        parcel.setSurface(LandType.air);
        Player player = new Player("pepe", null, new TerranBuilder(), new Point(300,300), null, map);

        player.embark(navetrans, (Transportable) marine);
        player.move(navetrans, new Point(495, 495));

        player.disembark(navetrans, (Transportable) marine);
    }
}
