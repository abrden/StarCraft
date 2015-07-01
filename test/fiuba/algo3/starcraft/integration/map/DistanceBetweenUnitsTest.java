package fiuba.algo3.starcraft.integration.map;


import fiuba.algo3.starcraft.logic.game.GameOver;
import fiuba.algo3.starcraft.logic.game.StarCraft;
import fiuba.algo3.starcraft.logic.map.Map;
import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.player.Player;
import fiuba.algo3.starcraft.logic.player.Resources;
import fiuba.algo3.starcraft.logic.structures.builders.ProtossBuilder;
import fiuba.algo3.starcraft.logic.structures.builders.TerranBuilder;
import fiuba.algo3.starcraft.logic.templates.units.protoss.ZealotTemplate;
import fiuba.algo3.starcraft.logic.templates.units.terran.MarineTemplate;
import fiuba.algo3.starcraft.logic.units.Unit;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;

import static junit.framework.TestCase.assertTrue;

public class DistanceBetweenUnitsTest {

    private StarCraft game;
    private Player player1,player2;
    private Unit marine, zealot;
    private Map map;
    private ArrayList list;

    @Before
    public void before() {
        game = new StarCraft();
        map = new Map(10000,game);
        player1 = new Player("carlos", Color.red,new TerranBuilder(),new Point(50,50),new Resources(999,999),map);
        player2 = new Player("raul", Color.red,new ProtossBuilder(),new Point(80,80),new Resources(999,999),map);
        game.setGame(player1,player2,map);

        list = new ArrayList();
        marine = new MarineTemplate().create(new Point(55,50));
        zealot = new ZealotTemplate().create(new Point(55,451));

    }

    @Test
    public void testZealotIsNotInsideMarineRadious() {
        player1.receiveNewUnit(marine);
        player2.receiveNewUnit(zealot);

        list = (ArrayList) map.enemyUnitsInCircle(marine.getPosition(),marine.getAttack().getRange(),player1.getUnits());
        assertTrue(list.size() == 0);
    }

    @Test
    public void testZealotIsInsideMarineRadious() {
        zealot = new ZealotTemplate().create(new Point(55,450));
        player1.receiveNewUnit(marine);
        player2.receiveNewUnit(zealot);

        list = (ArrayList) map.enemyUnitsInCircle(marine.getPosition(), marine.getAttack().getRange(),player1.getUnits());

        assertTrue(list.size() == 1);
    }

    @Test
    public void testZealotCanBeAttackedByMarine() throws GameOver {
        zealot = new ZealotTemplate().create(new Point(55,450));
        player1.receiveNewUnit(marine);
        player2.receiveNewUnit(zealot);

        game.nextTurn();

        assertTrue(zealot.getShield() != 60);
    }
}
