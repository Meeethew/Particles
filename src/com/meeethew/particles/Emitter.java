package com.meeethew.particles;

import javafx.scene.paint.Paint;

import java.util.List;

public abstract class Emitter {
    public abstract List<Particle> emit(Vector position, Vector velocity);
}
