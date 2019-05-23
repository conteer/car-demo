package com.klz.code.park;


public class RectangleCarPark implements CarPark {

    private int minPositionX;

    private int maxPositionX;

    private int minPositionY;

    private int maxPositionY;

    public RectangleCarPark() {
        super();
    }

    public RectangleCarPark(int minPositionX, int maxPositionX, int minPositionY, int maxPositionY) {
        this.minPositionX = minPositionX;
        this.maxPositionX = maxPositionX;
        this.minPositionY = minPositionY;
        this.maxPositionY = maxPositionY;
    }

    @Override
    public int getMinPositionX() {
        return minPositionX;
    }

    public void setMinPositionX(int minPositionX) {
        this.minPositionX = minPositionX;
    }

    @Override
    public int getMaxPositionX() {
        return maxPositionX;
    }

    public void setMaxPositionX(int maxPositionX) {
        this.maxPositionX = maxPositionX;
    }

    @Override
    public int getMinPositionY() {
        return minPositionY;
    }

    public void setMinPositionY(int minPositionY) {
        this.minPositionY = minPositionY;
    }

    @Override
    public int getMaxPositionY() {
        return maxPositionY;
    }

    public void setMaxPositionY(int maxPositionY) {
        this.maxPositionY = maxPositionY;
    }
}
