package fiuba.algo3.starcraft.test.templates;

import fiuba.algo3.starcraft.logic.templates.units.protoss.DragonTemplate;

import org.junit.Assert;
import org.junit.Test;

public class SingletonTest {

    @Test
    public void cantCreateTwoInstancesOfATemplate(){
        DragonTemplate instanceA = DragonTemplate.getInstance();
        DragonTemplate instanceB = DragonTemplate.getInstance();

        Assert.assertEquals(instanceA, instanceB);
    }

}