package fiuba.algo3.starcraft.integration.player;

import fiuba.algo3.starcraft.logic.game.StarCraft;
import fiuba.algo3.starcraft.logic.map.Map;
import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.map.exceptions.UnitCantGetToDestination;
import fiuba.algo3.starcraft.logic.player.Player;
import fiuba.algo3.starcraft.logic.player.Resources;
import fiuba.algo3.starcraft.logic.structures.ConstructionStructure;
import fiuba.algo3.starcraft.logic.structures.builders.TerranBuilder;
import fiuba.algo3.starcraft.logic.templates.structures.terran.BarracaTemplate;
import fiuba.algo3.starcraft.logic.templates.units.terran.MarineTemplate;
import fiuba.algo3.starcraft.logic.units.MuggleUnit;
import fiuba.algo3.starcraft.logic.units.exceptions.StepsLimitExceeded;
import fiuba.algo3.starcraft.logic.units.exceptions.UnitAlreadyMovedThisTurn;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class MovementOfNonFlyingUnitsTest {

    StarCraft game;
    Player player,player2;
    Map map;
    MuggleUnit marine, marineAux;
    boolean xComp, yComp;

    @Before
    public void before() {
        game = new StarCraft();
        map = new Map(10000,game);
        player = new Player("Pepe",null,new TerranBuilder(),new Point(1,1),new Resources(9999,9999),map);
        player2 = new Player("Pep",null,new TerranBuilder(),new Point(50,50),new Resources(9999,9999),map);
        game.setGame(player,player2,map);
        marine = new MarineTemplate().create(new Point(5, 5));
    }
    
    @Test
    public void testMoveMarineFromPoint5_5ToPoint10_10() throws StepsLimitExceeded, UnitCantGetToDestination, UnitAlreadyMovedThisTurn {
        player.receiveNewUnit(marine);

        player.move(marine, new Point(10, 10));

        xComp = marine.getPosition().getX() == 10;
        yComp = marine.getPosition().getY() == 10;

        assertEquals(xComp, yComp);
    }

    @Test
    public void testMarineMovementStopsWhenItReachesItMaximumStepsPerTurn() throws StepsLimitExceeded, UnitCantGetToDestination, UnitAlreadyMovedThisTurn {
        player.receiveNewUnit(marine);

        player.move(marine, new Point(50, 50));

        xComp = marine.getPosition().getX() < 50;
        yComp = marine.getPosition().getY() < 50;

        assertEquals(xComp, yComp);
    }

    @Test
    public void testMarineCantMoveThroughSpace() throws StepsLimitExceeded, UnitAlreadyMovedThisTurn {
        map.getParcelContainingPoint(new Point(12,12)).setAirSurface();
        player.receiveNewUnit(marine);

        try {
			player.move(marine, new Point(12, 12));
		} catch (UnitCantGetToDestination e) {
			
		}

        xComp = marine.getPosition().getX() < 12;
        yComp = marine.getPosition().getY() < 12;

        assertEquals(xComp, yComp);
    }

    @Test
    public void testMarineCantMoveThroughAParcelWithAStructure() throws StepsLimitExceeded, UnitCantGetToDestination, UnitAlreadyMovedThisTurn {
        ConstructionStructure barraca = new BarracaTemplate().create(new Point(10,10));
        player.receiveNewStructure(barraca);
        player.receiveNewUnit(marine);

        try {
			player.move(marine, new Point(15, 15));
		} catch (UnitCantGetToDestination e) {
			
		}
        
        xComp = marine.getPosition().getX() < 10;
        yComp = marine.getPosition().getY() < 10;

        assertEquals(xComp, yComp);
    }

    @Test
    public void testTwoMarinesCanBeOnTheSamePoint() throws StepsLimitExceeded, UnitCantGetToDestination, UnitAlreadyMovedThisTurn {
        marineAux = new MarineTemplate().create(new Point(10,10));
        player.receiveNewUnit(marine);
        player.receiveNewUnit(marineAux);

        player.move(marineAux, new Point(5, 5));

        xComp = marine.getPosition().getX() == 5 && marineAux.getPosition().getX() == 5;
        yComp = marine.getPosition().getY() == 5 && marineAux.getPosition().getY() == 5;

        assertEquals(xComp, yComp);
    }
    @Test
    public void testMarineMovedToAFarAwayPointOnMapItTakesMultipleTurnsToGetThere() throws UnitCantGetToDestination, UnitAlreadyMovedThisTurn {
        Point destinationPoint = new Point(499,499);
        player.receiveNewUnit(marine);

        player.move(marine, destinationPoint);
        for (int i = 0; i < 49; i++) {
            player.newTurn();
        }

        assertTrue(marine.getPosition().isSamePoint(destinationPoint));
    }

    @Test
    public void testMarineMovedToAFarAwayPointWithSpaceItWillStopJustOutsideItsParcel() throws UnitCantGetToDestination, UnitAlreadyMovedThisTurn {
        Point destinationPoint = new Point(433,533);
        map.getParcelContainingPoint(destinationPoint).setAirSurface();
        player.receiveNewUnit(marine);

        try{
            player.move(marine, destinationPoint);
        }catch (UnitCantGetToDestination e){
        }

        for (int i = 0; i < 100; i++)
            player.newTurn();

        assertTrue(!marine.getPosition().isSamePoint(destinationPoint));
    }
}
