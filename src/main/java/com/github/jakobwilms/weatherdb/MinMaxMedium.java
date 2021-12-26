package com.github.jakobwilms.weatherdb;

public record MinMax<T>(T min, T max) {

    public T getMin() {
        return min;
    }

    public T getMax() {
        return max;
    }
}
