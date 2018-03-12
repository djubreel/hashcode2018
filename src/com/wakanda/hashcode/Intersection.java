package com.wakanda.hashcode;

/**
 * Created by Jubril on 3/1/18.
 */
public class Intersection {
    private int x;
    private int y;

    public Intersection(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String toString() {
        return "[" + x + ", " + y + "]";
    }
}
