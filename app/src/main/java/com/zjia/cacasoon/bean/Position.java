package com.zjia.cacasoon.bean;

import com.zjia.cacasoon.util.GameData;

/**
 * Created by ZJIA on 2017/5/18 0018.
 */

public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getMapX () {
        return GameData.CARD_WIDTH / 2 + x * GameData.CARD_WIDTH;
    }
    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }
    public int getMapY() {
        return GameData.CARD_HIGHT/2 + y * GameData.CARD_HIGHT;
    }
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (x != position.x) return false;
        return y == position.y;

    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
