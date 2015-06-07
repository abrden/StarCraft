package fiuba.algo3.starcraft.logic.test.units;

import fiuba.algo3.starcraft.logic.templates.units.terran.GolliatTemplate;
import fiuba.algo3.starcraft.logic.units.Unit;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GolliatUnitaryTest {

    @Test
    public void testCreateGolliatAndReduce50HealthNowHealthEquals75(){
        Unit golliat = GolliatTemplate.getInstance().create();
        golliat.reduceLife(50);

        assertEquals(75, golliat.getHealth());
    }

    @Test
    public void testCreateGolliatAndReduce125HealthItIsDead(){
        Unit golliat = GolliatTemplate.getInstance().create();
        golliat.reduceLife(50);

        assertEquals(true, golliat.itsAlive());

    }
    @Test
    public void testCreateGolliatInPoint2And5ItCanMoveToXXX(){
        //Ver el tema de la posicion inical
    }
}


