package com.github.jakobwilms.weatherdb.we;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.stream.IntStream;

public record MinMaxMedium(float min, float max, float medium) {

    @Contract("_ -> new")
    public static @NotNull MinMaxMedium minMaxMedium(float @NotNull [] values) {
        final float[] min = {Float.MAX_VALUE};
        final float[] max = {Float.MIN_VALUE};
        final float[] sum = {0};

        IntStream.range(0, values.length)
                .forEach(i -> {
                    if (values[i] < min[0]) min[0] = values[i];
                    if (values[i] > max[0]) max[0] = values[i];
                    sum[0] += values[i];
                });
        sum[0] /= values.length;
        return new MinMaxMedium(((float) Math.round(min[0]) * 100) / 100, ((float) Math.round(max[0]) * 100) / 100, ((float) Math.round(sum[0]) * 100) / 100);
    }
}
