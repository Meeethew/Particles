package com.meeethew.particles;

public class Vector {

    double x;
    double y;

    public Vector(double x, double y){
        setX(x);
        setY(y);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void add(Vector vector){
        x += vector.getX();
        y += vector.getY();
    }
}
