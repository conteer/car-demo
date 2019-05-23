package com.klz.code.car;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import com.klz.code.enums.MoveTypeEnum;
import com.klz.code.enums.OrientationEnum;
import com.klz.code.exceptions.RunOrientationException;
import com.klz.code.park.CarPark;
import com.klz.code.park.RectangleCarPark;
import org.junit.*;


public class CarImplTest {

    private static CarPark carPark;
    @BeforeClass
    public static void init() {
        carPark = new RectangleCarPark(1, 4, 1, 4);
    }


    @Test
    public void testGetPositionAndOrientation() {
        Car car = new CarImpl(1, 2, OrientationEnum.EAST);
        assertSame(OrientationEnum.EAST, car.getOrientation());
        assertEquals(1, car.getPositionX());
        assertEquals(2, car.getPositionY());
    }

    /*
     * Given the Car is in position X = 1 and Y = 1 and facing North, when the Car turns clockwise,
     * then the Car is still in the same position but is now facing East
     */
    @Test
    public void testMoveInCarParkCondition1() throws RunOrientationException {
        Car car = new CarImpl(1, 1, OrientationEnum.NORTH);
        car.move(MoveTypeEnum.CLOCKWISE, carPark);
        assertEquals(1, car.getPositionX());
        assertEquals(1, car.getPositionY());
        assertSame(OrientationEnum.EAST, car.getOrientation());
    }

    /*
     * Given the Car is in position X = 1 and Y = 1 and facing North, when the Car moves forward,
     * then the Car is still facing North but is now in position X = 1 and Y = 2
     */
    @Test
    public void testMoveInCarParkCondition2() throws RunOrientationException {
        Car car = new CarImpl(1, 1, OrientationEnum.NORTH);
        car.move(MoveTypeEnum.FORWARD, carPark);
        assertEquals(1, car.getPositionX());
        assertEquals(2, car.getPositionY());
        assertSame(OrientationEnum.NORTH, car.getOrientation());
    }

    /*
     * Given the Car is in position X = 1 and Y = 1 and facing East,
     * when the Car moves forward, then the Car is still facing East but is now in position X = 2 and Y = 1
     */
    @Test
    public void testMoveInCarParkCondition3() throws RunOrientationException {
        Car car = new CarImpl(1, 1, OrientationEnum.EAST);
        car.move(MoveTypeEnum.FORWARD, carPark);
        assertEquals(2, car.getPositionX());
        assertEquals(1, car.getPositionY());
        assertSame(OrientationEnum.EAST, car.getOrientation());
    }

    /*
     * Given the Car is in position X = 1 and Y = 1 and facing West,
     * when the Car moves forward, then an exception is thrown
     */
    @Test(expected = RunOrientationException.class)
    public void testMoveInCarParkCondition4() throws RunOrientationException {
        Car car = new CarImpl(1, 1, OrientationEnum.WEST);
        car.move(MoveTypeEnum.FORWARD, carPark);
        assertEquals(1, car.getPositionX());
        assertEquals(1, car.getPositionY());
        assertSame(OrientationEnum.WEST, car.getOrientation());
    }

    /*
     * Given the Car is in position X = 1 and Y = 1 and facing East, when the Car moves forward twice,
     * then the Car is still facing East but is now in position X = 3 and Y = 1
     */
    @Test
    public void testMoveInCarParkCondition5() throws RunOrientationException {
        Car car = new CarImpl(1, 1, OrientationEnum.EAST);
        car.move(MoveTypeEnum.FORWARD, 2, carPark);
        assertEquals(3, car.getPositionX());
        assertEquals(1, car.getPositionY());
        assertSame(OrientationEnum.EAST, car.getOrientation());
    }


}
