package fiuba.algo3.starcraft.logic.test.units;


import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.templates.units.protoss.ZealotTemplate;
import fiuba.algo3.starcraft.logic.units.Unit;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ZealotTest {

    @Test
    public void testCreateZealotAndReduce50HealthNowShieldIs50AndHealth60() {
        Point position = new Point(1,1);
    	Unit zealot = ZealotTemplate.getInstance().create(position);

        zealot.reduceLife(50);

        assertEquals(zealot.getHealth()== 60,zealot.getShield() == 50);
    }

    @Test
    public void testDeal110DamageToZealotNowShieldIs0AndHealth50() {
        Unit zealot = ZealotTemplate.getInstance().create(null);

        zealot.reduceLife(110);

        assertEquals(zealot.getHealth()== 50,zealot.getShield() == 0);
    }

    @Test
    public void testDeal160DamageZealotIsNowDead() {
        Unit zealot = ZealotTemplate.getInstance().create(null);

        zealot.reduceLife(160);

        assertEquals(false, zealot.itsAlive());
    }

    @Test
    public void testDeal100DamageToZealotShieldIsNow0In5TurnsRegeneratesTo100() {
        Unit zealot = ZealotTemplate.getInstance().create(null);

        zealot.reduceLife(100);
        for (int i = 0; i < 5; i++)
            zealot.update();

        assertEquals(100, zealot.getShield());
    }
}
