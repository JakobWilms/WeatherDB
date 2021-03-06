package com.github.jakobwilms.weatherdb.we;

public record SimpleWeather(float temperature, float rainfall, float humidity, float wind, float clouds) {
    SimpleWeather() {
        this(0, 0, 0, 0, 0);
    }
}
