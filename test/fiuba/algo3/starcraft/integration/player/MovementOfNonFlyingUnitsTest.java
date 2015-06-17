package fiuba.algo3.starcraft.integration.player;


import fiuba.algo3.starcraft.logic.map.Map;
import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.map.areas.LandType;
import fiuba.algo3.starcraft.logic.player.Player;
import fiuba.algo3.starcraft.logic.player.Resources;
import fiuba.algo3.starcraft.logic.structures.ConstructionStructure;
import fiuba.algo3.starcraft.logic.structures.builders.TerranBuilder;
import fiuba.algo3.starcraft.logic.templates.structures.terran.BarracaTemplate;
import fiuba.algo3.starcraft.logic.templates.units.terran.MarineTemplate;
import fiuba.algo3.starcraft.logic.units.MuggleUnit;
import fiuba.algo3.starcraft.logic.units.exceptions.StepsLimitExceeded;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class MovementOfNonFlyingUnitsTest {

    Player player;
    Map map;
    MuggleUnit marine, marineAux;
    boolean xComp, yComp;

    @Before
    public void before() {
        map = new Map(1000,null);
        player = new Player("Pepe",null,new TerranBuilder(),new Point(1,1),new Resources(9999,9999),map);
        marine = new MarineTemplate().create(new Point(5, 5));
    }

    @Test
    public void testMoveMarineFromPoint5_5ToPoint10_10() throws StepsLimitExceeded {
        player.receiveNewUnit(marine);

        player.move(marine, new Point(10, 10));

        xComp = marine.getPosition().getX() == 10;
        yComp = marine.getPosition().getY() == 10;

        assertEquals(xComp, yComp);
    }

    @Test
    public void testMarineMovementStopsWhenItReachesItMaximumStepsPerTurn() throws StepsLimitExceeded {
        player.receiveNewUnit(marine);

        player.move(marine, new Point(50, 50));

        xComp = marine.getPosition().getX() < 50;
        yComp = marine.getPosition().getY() < 50;

        assertEquals(xComp, yComp);
    }

    @Test
    public void testMarineCantMoveThroughSpace() throws StepsLimitExceeded {
        map.getParcelContainingPoint(new Point(12,12)).setSurface(LandType.air);
        player.receiveNewUnit(marine);

        player.move(marine, new Point(12, 12));

        xComp = marine.getPosition().getX() < 12;
        yComp = marine.getPosition().getY() < 12;

        assertEquals(xComp, yComp);
    }

    @Test
    public void testMarineCantMoveThroughAParcelWithAStructure() throws StepsLimitExceeded {
        ConstructionStructure barraca = new BarracaTemplate().create(new Point(10,10));
        player.receiveNewStructure(barraca);
        player.receiveNewUnit(marine);

        player.move(marine, new Point(15, 15));

        xComp = marine.getPosition().getX() < 10;
        yComp = marine.getPosition().getY() < 10;

        assertEquals(xComp, yComp);
    }

    @Test
    public void testTwoMarinesCanBeOnTheSamePoint() throws StepsLimitExceeded {
        marineAux = new MarineTemplate().create(new Point(10,10));
        player.receiveNewUnit(marine);
        player.receiveNewUnit(marineAux);

        player.move(marineAux, new Point(5,5));

        xComp = marine.getPosition().getX() == 5 && marineAux.getPosition().getX() == 5;
        yComp = marine.getPosition().getY() == 5 && marineAux.getPosition().getY() == 5;

        assertEquals(xComp, yComp);
    }
}
