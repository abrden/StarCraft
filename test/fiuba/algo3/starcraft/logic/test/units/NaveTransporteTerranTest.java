package fiuba.algo3.starcraft.logic.test.units;


import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.templates.units.terran.MarineTemplate;
import fiuba.algo3.starcraft.logic.templates.units.terran.NaveTransporteTerranTemplate;
import fiuba.algo3.starcraft.logic.units.TransportUnit;
import fiuba.algo3.starcraft.logic.units.Transportable;
import fiuba.algo3.starcraft.logic.units.Unit;
import static org.junit.Assert.assertEquals;
import fiuba.algo3.starcraft.logic.units.exceptions.NoMoreSpaceInUnit;
import fiuba.algo3.starcraft.logic.units.exceptions.NoUnitToRemove;
import fiuba.algo3.starcraft.logic.units.exceptions.StepsLimitExceeded;

import org.junit.Test;

public class NaveTransporteTerranTest {
    /*
    @Test
    public void testNaveTransporteTerranEmbarksMarineFreeSpaceDownTo7() throws NoMoreSpaceInUnit, StepsLimitExceeded{
        TransportUnit navetrans = new NaveTransporteTerranTemplate().create(null);
        Unit marine = new MarineTemplate().create(null);

        navetrans.embark((Transportable) marine);

        assertEquals(7, navetrans.freeSpace());
    }

    @Test
    public void testNaveTransporteTerranDisembarksMarineFreeSpaceBackTo8() throws NoMoreSpaceInUnit, NoUnitToRemove, StepsLimitExceeded {
        TransportUnit navetrans = new NaveTransporteTerranTemplate().create(null);
        Unit marine = new MarineTemplate().create(null);

        navetrans.embark((Transportable) marine);
        navetrans.disembark((Transportable) marine);

        assertEquals(8, navetrans.freeSpace());
    }
    @Test
    public void testNaveTransporteTerranEmbarks8MarinesNoFreeSpaceLeft() throws NoMoreSpaceInUnit, StepsLimitExceeded {
        TransportUnit navetrans = new NaveTransporteTerranTemplate().create(null);
        Unit marine = new MarineTemplate().create(null);

        for (int i = 0; i<8; i++)
            navetrans.embark((Transportable) marine);

        assertEquals(0, navetrans.freeSpace());
    }
    @Test(expected = NoMoreSpaceInUnit.class)
    public void testNaveTransporteTerranThrowsExceptionWhenTryingToEmbark9Marines() throws NoMoreSpaceInUnit, StepsLimitExceeded {
        TransportUnit navetrans = new NaveTransporteTerranTemplate().create(null);
        Unit marine = new MarineTemplate().create(null);

        for (int i = 0; i<9; i++)
            navetrans.embark((Transportable) marine);
    }
    @Test(expected = NoUnitToRemove.class)
    public void testNaveTransporteTerranThrowsExceptionWhenTryingToDisembarkWithoutUnitsIn() throws NoUnitToRemove, StepsLimitExceeded{
        TransportUnit navetrans = new NaveTransporteTerranTemplate().create(null);
        Unit marine = new MarineTemplate().create(null);

        navetrans.disembark((Transportable) marine);

    }
    */
}
