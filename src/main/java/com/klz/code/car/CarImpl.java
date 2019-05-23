package com.klz.code.car;

import com.klz.code.enums.MoveTypeEnum;
import com.klz.code.enums.OrientationEnum;
import com.klz.code.exceptions.RunOrientationException;
import com.klz.code.park.CarPark;


public class CarImpl implements Car {
    private int positionX;
    private int positionY;
    private OrientationEnum orientation;

    public CarImpl() {
    }

    public CarImpl(int positionX, int positionY, OrientationEnum orientation) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.orientation = orientation;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public void setOrientation(OrientationEnum orientation) {
        this.orientation = orientation;
    }

    @Override
    public int getPositionX() {
        return positionX;
    }

    @Override
    public int getPositionY() {
        return positionY;
    }

    @Override
    public OrientationEnum getOrientation() {
        return orientation;
    }

    @Override
    public void move(MoveTypeEnum moveTypeEnm) throws RunOrientationException {
        move(moveTypeEnm, 1);
    }

    @Override
    public void move(MoveTypeEnum moveTypeEnm, int step) throws RunOrientationException {
        move(moveTypeEnm, step, null);
    }

    @Override
    public void move(MoveTypeEnum moveTypeEnm, CarPark carPark) throws RunOrientationException {
        move(moveTypeEnm, 1, carPark);
    }

    @Override
    public void move(MoveTypeEnum moveTypeEnm, int step, CarPark carPark) throws RunOrientationException {
        if (MoveTypeEnum.FORWARD.equals(moveTypeEnm)) {
            moveStraight(carPark, orientation, step);
        } else {
            moveTurn(moveTypeEnm, step);
        }
    }

    private void moveStraight(CarPark carPark, OrientationEnum orientationEnum, int step) throws RunOrientationException {
        switch (orientationEnum) {
            case EAST:
                positionX = positionX + step;
                break;
            case WEST:
                positionX = positionX - step;
                break;
            case SOUTH:
                positionY = positionY - step;
                break;
            case NORTH:
                positionY = positionY + step;
                break;
        }
        if (carPark != null) {
            checkPosition(carPark);
        }
    }

    private void checkPosition(CarPark carPark) throws RunOrientationException {
        boolean isExceed = false;
        if (positionX < carPark.getMinPositionX()) {
            positionX = carPark.getMinPositionX();
            isExceed = true;
        } else if (positionX > carPark.getMaxPositionX()) {
            positionX = carPark.getMaxPositionX();
            isExceed = true;
        }else if (positionY < carPark.getMinPositionY()) {
            positionY = carPark.getMinPositionY();
            isExceed = true;
        }else if (positionY > carPark.getMaxPositionY()) {
            positionY = carPark.getMaxPositionY();
            isExceed = true;
        }
        if (isExceed) {
            throw new RunOrientationException("can not run out of car park.");
        }
    }

    private void moveTurn(MoveTypeEnum moveTypeEnum, int step) {
        for (int i = 0 ; i < step; i++) {
            moveTurnOne(moveTypeEnum);
        }
    }
    private void moveTurnOne(MoveTypeEnum moveTypeEnum) {
        if (moveTypeEnum.equals(MoveTypeEnum.FORWARD)) {
            return;
        }
        OrientationEnum runOrientation = null;
        switch (orientation) {
            case EAST:
                runOrientation = moveTypeEnum.equals(MoveTypeEnum.CLOCKWISE) ? OrientationEnum.SOUTH : OrientationEnum.NORTH;
                break;
            case WEST:
                runOrientation = moveTypeEnum.equals(MoveTypeEnum.CLOCKWISE) ? OrientationEnum.NORTH : OrientationEnum.SOUTH;
                break;
            case SOUTH:
                runOrientation = moveTypeEnum.equals(MoveTypeEnum.CLOCKWISE) ? OrientationEnum.WEST: OrientationEnum.EAST;
                break;
            case NORTH:
                runOrientation = moveTypeEnum.equals(MoveTypeEnum.CLOCKWISE) ? OrientationEnum.EAST: OrientationEnum.WEST;
        }
        orientation = runOrientation;
    }

}
