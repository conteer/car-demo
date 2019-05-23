package com.klz.code.car;

import com.klz.code.park.CarPark;
import com.klz.code.enums.MoveTypeEnum;
import com.klz.code.enums.OrientationEnum;
import com.klz.code.exceptions.RunOrientationException;

public interface Car {

    int getPositionX();

    int getPositionY();

    OrientationEnum getOrientation();

    /**
     * move one step
     */
    void move(MoveTypeEnum moveTypeEnm) throws RunOrientationException;

    /**
     * move many step
     */
    void move(MoveTypeEnum moveTypeEnm, int step) throws RunOrientationException;

    /**
     * move one step in car park
     */
    void move(MoveTypeEnum moveTypeEnm, CarPark carPark) throws RunOrientationException;

    /**
     * move many step in car park
     */
    void move(MoveTypeEnum moveTypeEnm, int step, CarPark carPark) throws RunOrientationException;
}
