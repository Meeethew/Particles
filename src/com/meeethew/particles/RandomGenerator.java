package com.meeethew.particles;

import java.util.Random;

public class RandomGenerator {

    public double generateDouble(double lowerLimit, double upperLimit) {
        return lowerLimit + new Random().nextDouble() * (upperLimit - lowerLimit);
    }

}

