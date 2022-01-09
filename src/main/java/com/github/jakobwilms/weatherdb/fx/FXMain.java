package com.github.jakobwilms.weatherdb.fx;

import com.github.jakobwilms.weatherdb.ut.Utils;
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
        Utils.print("Creating AnimationTimer");
        fxTimer = new FXTimer();
    }

    @Override
    public void start(@NotNull Stage stage) {
        try {
            Utils.print("Initializing FXPanes");
            fxPanes = new FXPanes();

            FXPanes.setSelectedPane(getFxPanes().getWelcomeBox());

            Utils.print("Creating Camera");
            PerspectiveCamera camera = new PerspectiveCamera();
            camera.setFieldOfView(10);

            Utils.print("Creating Scene");
            Scene scene = new Scene(fxPanes.getMainPane());
            scene.setCamera(camera);

            Utils.print("Initializing Stage");
            stage.setTitle("WeatherDB");
            stage.setScene(scene);
            stage.setFullScreen(true);
            stage.setFullScreenExitHint("");
            Utils.print("Showing Stage");
            stage.show();


            Utils.print("Starting AnimationTimer");
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
