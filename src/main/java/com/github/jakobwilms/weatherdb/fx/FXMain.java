package com.github.jakobwilms.weatherdb.fx;

import javafx.application.Application;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

public class FXMain extends Application {


    private FXTimer fxTimer;
    private static FXPanes fxPanes;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void init() {
        FXTiles.init();

        fxTimer = new FXTimer();
    }

    @Override
    public void start(@NotNull Stage stage) {
        try {
            fxPanes = new FXPanes();

            FXPanes.setSelectedPane(getFxPanes().getWelcomeBox());

            PerspectiveCamera camera = new PerspectiveCamera();
            camera.setFieldOfView(10);

            Scene scene = new Scene(fxPanes.getMainPane());
            scene.setCamera(camera);

            stage.setTitle("WeatherDB");
            stage.setScene(scene);
            stage.setFullScreen(true);
            stage.setFullScreenExitHint("");
            stage.show();

            fxTimer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stop() {
        fxTimer.stop();
        FXTiles.getTimer().stop();
        FXTiles.getClock().stop();
        FXTiles.getDate().stop();
        FXTiles.getCountdown().stop();
        System.exit(0);

    }

    FXTimer getFxTimer() {
        return fxTimer;
    }

    static FXPanes getFxPanes() {
        return fxPanes;
    }
}
