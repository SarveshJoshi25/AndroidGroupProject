package com.example.androidmicroproject.model;

public class Temperature {
     public final double min, max, current;

    public Temperature(double min, double max, double current) {
        this.min = min;
        this.max = max;
        this.current = current;
    }

    @Override
    public String toString() {
        return "Temperature{" +
                "min=" + min +
                ", max=" + max +
                ", current=" + current +
                '}';
    }
}
