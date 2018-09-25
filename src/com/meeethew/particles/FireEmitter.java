package com.meeethew.particles;

import javafx.scene.paint.Paint;

import java.util.ArrayList;
import java.util.List;

public class FireEmitter extends Emitter {

    @Override
    public List<Particle> emit(Vector position, Vector velocity) {
        List<Particle> particles = new ArrayList<>();

        int numParticles = 1;
        for (int i = 0; i < numParticles; i++) {
            Particle p = new Particle(position, velocity);
            particles.add(p);
        }
        return particles;
    }
}
