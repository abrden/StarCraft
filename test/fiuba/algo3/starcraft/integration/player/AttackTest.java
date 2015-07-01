package fiuba.algo3.starcraft.integration.player;


import fiuba.algo3.starcraft.logic.game.StarCraft;
import fiuba.algo3.starcraft.logic.map.*;
import fiuba.algo3.starcraft.logic.map.exceptions.NoReachableTransport;
import fiuba.algo3.starcraft.logic.player.Player;
import fiuba.algo3.starcraft.logic.player.Resources;
import fiuba.algo3.starcraft.logic.structures.builders.ProtossBuilder;
import fiuba.algo3.starcraft.logic.structures.builders.TerranBuilder;
import fiuba.algo3.starcraft.logic.templates.units.protoss.NaveTransporteProtossTemplate;
import fiuba.algo3.starcraft.logic.templates.units.protoss.ZealotTemplate;
import fiuba.algo3.starcraft.logic.templates.units.terran.EspectroTemplate;
import fiuba.algo3.starcraft.logic.templates.units.terran.MarineTemplate;
import fiuba.algo3.starcraft.logic.units.Transportable;
import fiuba.algo3.starcraft.logic.units.Unit;
import fiuba.algo3.starcraft.logic.units.exceptions.NoMoreSpaceInUnit;
import fiuba.algo3.starcraft.logic.units.exceptions.StepsLimitExceeded;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.starcraft.logic.map.Point;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AttackTest {

    private StarCraft game;
    private Player player1,player2;
    private Unit marine, zealot, espectro, naveProtoss;
    private Map map;

    @Before
    public void before() {
        game = new StarCraft();
        map = new Map(10000,game);
        player1 = new Player("carlos", Color.red,new TerranBuilder(),new Point(50,50),new Resources(999,999),map);
        player2 = new Player("raul", Color.red,new ProtossBuilder(),new Point(80,80),new Resources(999,999),map);
        game.setGame(player1,player2,map);

        marine = new MarineTemplate().create(new Point(55,50));
        zealot = new ZealotTemplate().create(new Point(55,450));
        espectro = new EspectroTemplate().create(new Point(55,445));
        naveProtoss = new NaveTransporteProtossTemplate().create(new Point(55,470));
    }

    @Test
    public void testMarineCanAttackZealotButZealotCant() {
        player1.receiveNewUnit(marine);
        player2.receiveNewUnit(zealot);

        player1.newTurn();
        player2.newTurn();

        assertEquals(marine.getHealth(), marine.getMaximumHealth());
        assertEquals(zealot.getShield(),zealot.getMaximumShield() - marine.getAttack().getLandDamage() + 1);
        //+1 por la regeneracion de escudo
    }

    @Test
    public void testZealotCantAttackAnEspectro() {
        player1.receiveNewUnit(espectro);
        player2.receiveNewUnit(zealot);

        player2.newTurn();

        assertEquals(espectro.getHealth(),espectro.getMaximumHealth());
    }

    @Test
    public void testEspectroCanKillZealotWithoutReceviengDamage() {
        player1.receiveNewUnit(espectro);
        player2.receiveNewUnit(zealot);

        for (int i = 0; i < 25; i++) {
            player1.newTurn();
            player2.newTurn();
        }

        assertTrue(!zealot.itsAlive());
        assertEquals(espectro.getHealth(), espectro.getMaximumHealth());
    }

    @Test
    public void testEspectroKillsANaveDeTransporteWithZealotOnBoardTheyBothDie() throws NoMoreSpaceInUnit, StepsLimitExceeded, NoReachableTransport {
        player1.receiveNewUnit(espectro);
        player2.receiveNewUnit(zealot);
        player2.receiveNewUnit(naveProtoss);

        player2.embark((Transportable) zealot);

        for (int i = 0; i < 8; i++) {
            player1.newTurn();
            player2.newTurn();
        }

        assertTrue(!zealot.itsAlive());
        assertTrue(!naveProtoss.itsAlive());
    }
}
