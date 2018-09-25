package com.meeethew.display;

import com.meeethew.particles.*;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Display extends Application {

    private RandomGenerator r = new RandomGenerator();
    private GraphicsContext g;
    private List<Particle> particles = new ArrayList<>();
    private Emitter emitter = new FireEmitter();
    private Vector position;
    private Vector velocity;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(createContent(600, 600)));
        initSetup();
        primaryStage.setTitle("Particle Systems Demo");
        primaryStage.show();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                onUpdate();
            }
        };
        timer.start();
    }

    private Parent createContent(double prefWidth, double prefHeight) {
        Pane root = new Pane();
        root.setPrefSize(prefWidth, prefHeight);

        Canvas canvas = new Canvas(prefWidth, prefHeight);
        g = canvas.getGraphicsContext2D();

        root.getChildren().add(canvas);

        return root;

    }

    private void initSetup() {

        particles.addAll(emitter.emit(position = new Vector(r.generateDouble(50.0D, 550.0D),
                r.generateDouble(50.0D, 550.0D)), velocity = new Vector(r.generateDouble(-3.0D, 3.0D),
                r.generateDouble(-3.0D, 3.0D))));

    }

    private void onUpdate() {

        g.setFill(Color.WHITE);
        g.fillRect(0, 0, 600, 600);

        for (Iterator<Particle> it = particles.iterator(); it.hasNext(); ) {
            Particle p = it.next();
            p.update();

            if (!p.isAlive()) {
                it.remove();
                continue;
            }

            if ((p.getPosition().getX() > (600 - p.getRadius() / 2)) || (p.getPosition().getX() < 0)) {
                velocity.setX(velocity.getX() * -1);
            }

            if ((p.getPosition().getY() > (600 - p.getRadius() / 2)) || (p.getPosition().getY() < 0)) {
                velocity.setY(velocity.getY() * -1);
            }

            p.render(g);
        }

    }
}
