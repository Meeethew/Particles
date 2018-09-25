package com.meeethew.particles;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Particle {

    private Vector position;
    private  Vector velocity;
    private double radius;
    private Paint paint;
    private double lifeTime;
    RandomGenerator r = new RandomGenerator();

    public Particle(Vector position, Vector velocity) {
        setPosition(position);
        setVelocity(velocity);
        setRadius(50);
        setPaint(Color.BLUE);
        setLifeTime(r.generateDouble(0.1D, 100.0D));
    }

    public void setPosition(Vector position) {
        this.position = position;
    }

    public Vector getPosition() {
        return position;
    }

    public Vector getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector velocity) {
        this.velocity = velocity;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public Paint getPaint() {
        return paint;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }

    public double getLifeTime() {
        return lifeTime;
    }

    public void setLifeTime(double lifeTime) {
        this.lifeTime = lifeTime;
    }

    private double getHeightAndWidth(){
        return this.radius / 2;
    }

    public boolean isAlive(){
        return lifeTime > 0.0D;
    }

    public void update(){
        position.add(velocity);
        lifeTime -= 0.1D;
    }

    public void render(GraphicsContext g){
        g.setFill(paint);
        g.fillOval(position.getX(), position.getY(), getHeightAndWidth(),getHeightAndWidth());
    }


}
