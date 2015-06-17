package fiuba.algo3.starcraft.logic.test.map;


import fiuba.algo3.starcraft.logic.map.Point;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PointTest {

    Point point, pointNew;

    @Before
    public void before() {
        point = new Point(6,4);
    }

    @Test
    public void testAddANewPointToMyExistingOne() {
        pointNew = point.add(new Point(4,3));

        assertEquals(pointNew.getX() == 10, pointNew.getY() == 7);
    }

    @Test
    public void testSubstractANewPointToMyExistingOne() {
        pointNew = point.substract(new Point(2, 0));

        assertEquals(pointNew.getX() == 4, pointNew.getY() == 4);
    }

    @Test
    public void testMultiplyPointByScalar() {
        pointNew = point.multiply(6);

        assertEquals(pointNew.getX() == 36, pointNew.getY() == 24);
    }

    @Test
    public void testDividePointByScalar() {
        pointNew = point.divide(2);

        assertEquals(pointNew.getX() == 3, pointNew.getY() == 2);
    }

    @Test
    public void testDistanceBetweenTwoPoints() {
        pointNew = new Point(10,6);

        double distance = point.distance(pointNew);

        assertEquals(distance, 4,47);
    }

}
