package fiuba.algo3.starcraft.integration.player;

import java.util.ArrayList;

import fiuba.algo3.starcraft.logic.game.PlayerSetup;
import fiuba.algo3.starcraft.logic.game.StarCraft;
import fiuba.algo3.starcraft.logic.map.Map;
import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.map.exceptions.UnitCantGetToDestination;
import fiuba.algo3.starcraft.logic.player.Player;
import fiuba.algo3.starcraft.logic.structures.ConstructionStructure;
import fiuba.algo3.starcraft.logic.templates.structures.terran.BarracaTemplate;
import fiuba.algo3.starcraft.logic.templates.units.terran.EspectroTemplate;
import fiuba.algo3.starcraft.logic.units.MuggleUnit;
import fiuba.algo3.starcraft.logic.units.exceptions.StepsLimitExceeded;
import fiuba.algo3.starcraft.logic.units.exceptions.UnitAlreadyMovedThisTurn;
import fiuba.algo3.starcraft.view.exceptions.NameIsTooShort;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovementOfFlyingUnitsTest {

    StarCraft game;
    Player player;
    Map map;
    MuggleUnit espectro, espectroAux;
    boolean xComp, yComp;

    @Before
    public void before() throws NameIsTooShort {
        ArrayList<PlayerSetup> playerSetups = new ArrayList<PlayerSetup>();
        playerSetups.add(new PlayerSetup("Pepe", "Red", "Terran"));
		playerSetups.add(new PlayerSetup("Pepes", "Blue", "Terran"));
		game = new StarCraft(playerSetups);
        game.start();
		espectro = new EspectroTemplate().create(new Point(5, 5));
        player = game.getActivePlayer();
        map = game.getMap();
    }
    
    @Test
    public void testMoveEspectroFromPoint5_5ToPoint10_10() throws StepsLimitExceeded, UnitCantGetToDestination, UnitAlreadyMovedThisTurn {
        player.receiveNewUnit(espectro);

        player.move(espectro, new Point(10, 10));

        xComp = espectro.getPosition().getX() == 10;
        yComp = espectro.getPosition().getY() == 10;

        assertEquals(xComp, yComp);
    }

    @Test
    public void testEspectroMovementStopsWhenItReachesItMaximumStepsPerTurn() throws StepsLimitExceeded, UnitCantGetToDestination, UnitAlreadyMovedThisTurn {
        player.receiveNewUnit(espectro);

        player.move(espectro, new Point(50, 50));

        xComp = espectro.getPosition().getX() < 50;
        yComp = espectro.getPosition().getY() < 50;

        assertEquals(xComp,yComp);
    }

    @Test
    public void testEspectroCanMoveThroughSpace() throws StepsLimitExceeded, UnitCantGetToDestination, UnitAlreadyMovedThisTurn {
        map.getParcelContainingPoint(new Point(12,12)).setAirSurface();
        player.receiveNewUnit(espectro);

        player.move(espectro, new Point(12, 12));

        xComp = espectro.getPosition().getX() == map.getParcelContainingPoint(new Point(12,12)).getOrigin().getX();
        yComp = espectro.getPosition().getY() == map.getParcelContainingPoint(new Point(12,12)).getOrigin().getY();

        assertEquals(xComp, yComp);
    }

    @Test
    public void testEspectroCanMoveThroughAParcelWithAStructure() throws StepsLimitExceeded, UnitCantGetToDestination, UnitAlreadyMovedThisTurn {
        ConstructionStructure barraca = new BarracaTemplate().create(new Point(10,10));
        player.receiveNewStructure(barraca);
        player.receiveNewUnit(espectro);

        player.move(espectro, new Point(15, 15));


        xComp = espectro.getPosition().getX() == 15;
        yComp = espectro.getPosition().getY() == 15;

        assertEquals(xComp, yComp);
    }

    @Test
    public void testTwoEspectrosCanBeOnTheSamePoint() throws StepsLimitExceeded, UnitCantGetToDestination, UnitAlreadyMovedThisTurn {
        espectroAux = new EspectroTemplate().create(new Point(10,10));
        player.receiveNewUnit(espectro);
        player.receiveNewUnit(espectroAux);

        player.move(espectroAux, new Point(5, 5));

        xComp = espectro.getPosition().getX() == 5 && espectroAux.getPosition().getX() == 5;
        yComp = espectro.getPosition().getY() == 5 && espectroAux.getPosition().getY() == 5;

        assertEquals(xComp, yComp);
    }
}
