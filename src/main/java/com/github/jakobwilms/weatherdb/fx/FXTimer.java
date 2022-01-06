package com.github.jakobwilms.weatherdb.fx;

import javafx.animation.AnimationTimer;

import java.time.Duration;

final class FXTimer extends AnimationTimer {

    public static final long waitSeconds = 5;
    private static boolean refresh = true;
    private long lastTimerCall;

    public FXTimer() {
        FXTiles.getRefreshSwitch().setActive(true);
        FXTiles.getRefreshSwitch().setOnSwitchReleased(e -> changeRefresh());
        FXTiles.getCountdown().setRunning(false);
        this.lastTimerCall = System.currentTimeMillis();
        refresh();
    }

    public static boolean isRefresh() {
        return refresh;
    }

    public static void changeRefresh() {
        FXTimer.refresh = !refresh;
    }

    @Override
    public void handle(long now) {
        now = System.currentTimeMillis();
        if (now >= lastTimerCall + waitSeconds * 1000 && isRefresh()) {
            lastTimerCall = now;
            refresh();
        }
    }

    private void refresh() {
        FXTiles.getTempCurrent().setValue(30);
        FXTiles.getTemp24().setValue(30);
        FXTiles.getTemp31().setValue(35);
        FXTiles.getTemp365().setValue(10);
        FXTiles.getTempAverage().setValue(-10);

        FXTiles.getCountdown().setTimePeriod(Duration.ofSeconds(waitSeconds));
        FXTiles.getCountdown().setRunning(true);

        FXTiles.getWindCurrent().setValue(40);
        FXTiles.getWind24().setValue(70);
        FXTiles.getWind31().setValue(20);
        FXTiles.getWind365().setValue(60);
        FXTiles.getWindAverage().setValue(39);

        FXTiles.getRainfallCurrent().setValue(50);
        FXTiles.getRainfall24().setValue(30);
        FXTiles.getRainfall31().setValue(50);
        FXTiles.getRainfall365().setValue(250);
        FXTiles.getRainfallAverage().setValue(60);
    }
}
