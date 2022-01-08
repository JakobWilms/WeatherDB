package com.github.jakobwilms.weatherdb.fx;

import eu.hansolo.tilesfx.tools.FlowGridPane;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.layout.*;
import org.jetbrains.annotations.NotNull;

import static com.github.jakobwilms.weatherdb.fx.FXTiles.*;

final class FXPaneUtils {

    static @NotNull FlowGridPane weatherDBPane() {
        FlowGridPane weatherDBPane = new FlowGridPane(1, 1, FXTiles.getWeatherDB());

        weatherDBPane.setAlignment(Pos.CENTER);
        weatherDBPane.setCenterShape(true);
        weatherDBPane.setPadding(new Insets(5));
        weatherDBPane.setMinSize(FXVar.TILE_WIDTH_MENU, FXVar.TILE_HEIGHT_TIME);
        weatherDBPane.setPrefSize(FXVar.TILE_WIDTH_MENU, FXVar.TILE_HEIGHT_TIME);
        weatherDBPane.setMaxSize(FXVar.TILE_WIDTH_MENU, FXVar.TILE_HEIGHT_TIME);
        weatherDBPane.setBackground(FXVar.SCENE_BACKGROUND);

        return weatherDBPane;
    }

    static @NotNull FlowGridPane menuPane() {
        FlowGridPane menuPane = new FlowGridPane(11, 1,
                FXTiles.getMenuOverview(), FXTiles.getMenuCurrent(), FXTiles.getMenuDay(), FXTiles.getMenuMonth(), FXTiles.getMenuYear(),
                FXTiles.getMenuTemp(), FXTiles.getMenuRainfall(), FXTiles.getMenuWind(), FXTiles.getMenuClouds(), FXTiles.getMenuHumidity(),
                FXTiles.getMenuAlone());

        menuPane.setAlignment(Pos.CENTER);
        menuPane.setCenterShape(true);
        menuPane.setPadding(new Insets(5, 2, 5, 2));
        menuPane.setMinSize(FXVar.TILE_WIDTH_MENU, (FXVar.SCREEN_SIZE.height - FXVar.TILE_HEIGHT_TIME));
        menuPane.setPrefSize(FXVar.TILE_WIDTH_MENU, (FXVar.SCREEN_SIZE.height - FXVar.TILE_HEIGHT_TIME));
        menuPane.setMaxSize(FXVar.TILE_WIDTH_MENU, (FXVar.SCREEN_SIZE.height - FXVar.TILE_HEIGHT_TIME));
        menuPane.setBackground(FXVar.SCENE_BACKGROUND);
        menuPane.setVgap(5);
        final RowConstraints rowConstraints = new RowConstraints(
                (double) (FXVar.SCREEN_SIZE.height - FXVar.TILE_HEIGHT_TIME) / 11,
                (double) (FXVar.SCREEN_SIZE.height - FXVar.TILE_HEIGHT_TIME) / 11,
                (double) (FXVar.SCREEN_SIZE.height - FXVar.TILE_HEIGHT_TIME) / 11,
                Priority.ALWAYS, VPos.CENTER, false
        );
        menuPane.getRowConstraints().setAll(
                rowConstraints, rowConstraints, rowConstraints, rowConstraints, rowConstraints,
                rowConstraints, rowConstraints, rowConstraints, rowConstraints, rowConstraints,
                rowConstraints
        );

        return menuPane;
    }

    static @NotNull FlowGridPane timePane() {
        FlowGridPane timePane = new FlowGridPane(5, 1,
                FXTiles.getTimer(), FXTiles.getClock(), FXTiles.getDate(), FXTiles.getCountdown(), FXTiles.getRefreshSwitch());

        timePane.setAlignment(Pos.CENTER);
        timePane.setCenterShape(true);
        timePane.setPadding(new Insets(2, 5, 2, 5));
        timePane.setMinSize(FXVar.SCREEN_SIZE.width - FXVar.TILE_WIDTH_MENU, FXVar.TILE_HEIGHT_TIME);
        timePane.setPrefSize(FXVar.SCREEN_SIZE.width - FXVar.TILE_WIDTH_MENU, FXVar.TILE_HEIGHT_TIME);
        timePane.setMaxSize(FXVar.SCREEN_SIZE.width - FXVar.TILE_WIDTH_MENU, FXVar.TILE_HEIGHT_TIME);
        timePane.setBackground(FXVar.SCENE_BACKGROUND);
        timePane.setCenterShape(true);
        final ColumnConstraints columnConstraints = new ColumnConstraints(
                (double) (FXVar.SCREEN_SIZE.width - FXVar.TILE_WIDTH_MENU) / 5,
                (double) (FXVar.SCREEN_SIZE.width - FXVar.TILE_WIDTH_MENU) / 5,
                (double) (FXVar.SCREEN_SIZE.width - FXVar.TILE_WIDTH_MENU) / 5,
                Priority.ALWAYS, HPos.CENTER, false
        );
        timePane.getColumnConstraints().setAll(
                columnConstraints, columnConstraints, columnConstraints, columnConstraints, columnConstraints
        );

        return timePane;
    }

    static @NotNull FlowGridPane overviewPane() {
        return new FlowGridPane(5, 5,
                FXTiles.getTempCurrent(), FXTiles.getWindCurrent(), FXTiles.getRainfallCurrent(), FXTiles.getCloudsCurrent(), FXTiles.getHumidityCurrent(),
                FXTiles.getTemp24(), FXTiles.getWind24(), FXTiles.getRainfall24(), FXTiles.getClouds24(), FXTiles.getHumidity24(),
                FXTiles.getTemp31(), FXTiles.getWind31(), FXTiles.getRainfall31(), FXTiles.getClouds31(), FXTiles.getHumidity31(),
                FXTiles.getTemp365(), FXTiles.getWind365(), FXTiles.getRainfall365(), FXTiles.getClouds365(), FXTiles.getHumidity365(),
                FXTiles.getTempAverage(), FXTiles.getWindAverage(), FXTiles.getRainfallAverage(), FXTiles.getCloudsAverage(), FXTiles.getHumidityAverage());
    }

    static @NotNull FlowGridPane currentPane() {
        return new FlowGridPane(3, 1,
                FXTiles.getTempNow(), FXTiles.getWindNow(), FXTiles.getRainfallNow());
    }

    static @NotNull FlowGridPane currentPaneBottom() {
        return new FlowGridPane(2, 1,
                FXTiles.getCloudsNow(), FXTiles.getHumidityNow());
    }

    static @NotNull FlowGridPane dayPane() {
        return new FlowGridPane(3, 1,
                FXTiles.getTempDay(), FXTiles.getWindDay(), FXTiles.getRainfallDay());
    }

    static @NotNull FlowGridPane dayPaneBottom() {
        return new FlowGridPane(2, 1,
                FXTiles.getCloudsDay(), FXTiles.getHumidityDay());
    }

    static @NotNull FlowGridPane monthPane() {
        return new FlowGridPane(3, 1,
                FXTiles.getTempMonth(), FXTiles.getWindMonth(), FXTiles.getRainfallMonth());
    }

    static @NotNull FlowGridPane monthPaneBottom() {
        return new FlowGridPane(2, 1,
                FXTiles.getCloudsMonth(), FXTiles.getHumidityMonth());
    }

    static @NotNull FlowGridPane yearPane() {
        return new FlowGridPane(3, 1,
                FXTiles.getTempYear(), FXTiles.getWindYear(), FXTiles.getRainfallYear());
    }

    static @NotNull FlowGridPane yearPaneBottom() {
        return new FlowGridPane(2, 1,
                FXTiles.getCloudsYear(), FXTiles.getHumidityYear());
    }

    static @NotNull FlowGridPane tempPane() {
        return new FlowGridPane(2, 2,
                FXTiles.getTempNowSingle(), FXTiles.getTempDaySingle(),
                FXTiles.getTempMonthSingle(), FXTiles.getTempYearSingle());
    }

    static @NotNull FlowGridPane windPane() {
        return new FlowGridPane(2, 2,
                FXTiles.getWindNowSingle(), FXTiles.getWindDaySingle(),
                FXTiles.getWindMonthSingle(), FXTiles.getWindYearSingle());
    }

    static @NotNull FlowGridPane rainfallPane() {
        return new FlowGridPane(2, 2,
                FXTiles.getRainfallNowSingle(), FXTiles.getRainfallDaySingle(),
                FXTiles.getRainfallMonthSingle(), FXTiles.getRainfallYearSingle());
    }

    static @NotNull FlowGridPane cloudsPane() {
        return new FlowGridPane(2, 2,
                FXTiles.getCloudsNowSingle(), FXTiles.getCloudsDaySingle(),
                FXTiles.getCloudsMonthSingle(), FXTiles.getCloudsYearSingle());
    }

    static @NotNull FlowGridPane humidityPane() {
        return new FlowGridPane(2, 2,
                FXTiles.getHumidityNowSingle(), FXTiles.getHumidityDaySingle(),
                FXTiles.getHumidityMonthSingle(), FXTiles.getHumidityYearSingle());
    }

    static @NotNull VBox welcomeBox() {
        final VBox welcomeBox = new VBox(FXVar.VBOX_SPACING, getWelcomeTile());

        welcomeBox.setAlignment(Pos.CENTER);
        welcomeBox.setMinSize(FXVar.SCREEN_SIZE.width - FXVar.TILE_WIDTH_MENU, FXVar.SCREEN_SIZE.height - FXVar.TILE_HEIGHT_TIME);
        welcomeBox.setPrefSize(FXVar.SCREEN_SIZE.width - FXVar.TILE_WIDTH_MENU, FXVar.SCREEN_SIZE.height - FXVar.TILE_HEIGHT_TIME);
        welcomeBox.setMaxSize(FXVar.SCREEN_SIZE.width - FXVar.TILE_WIDTH_MENU, FXVar.SCREEN_SIZE.height - FXVar.TILE_HEIGHT_TIME);
        welcomeBox.setBorder(FXVar.MENU_BUTTON_BORDER_LIGHT);
        welcomeBox.setBackground(FXVar.SCENE_BACKGROUND_BRIGHTER);
        welcomeBox.setVisible(true);

        return welcomeBox;
    }

    static void tilePane(@NotNull StackPane tilePane) {
        tilePane.getChildren().addAll(
                FXTiles.getTempNowAlone(), FXTiles.getRainfallNowAlone(), FXTiles.getWindNowAlone(), FXTiles.getCloudsNowAlone(), FXTiles.getHumidityNowAlone(),
                FXTiles.getTempDayAlone(), FXTiles.getRainfallDayAlone(), FXTiles.getWindDayAlone(), FXTiles.getCloudsDayAlone(), FXTiles.getHumidityDayAlone(),
                FXTiles.getTempMonthAlone(), FXTiles.getRainfallMonthAlone(), FXTiles.getWindMonthAlone(), FXTiles.getCloudsMonthAlone(), FXTiles.getHumidityMonthAlone(),
                FXTiles.getTempYearAlone(), FXTiles.getRainfallYearAlone(), FXTiles.getWindYearAlone(), FXTiles.getCloudsYearAlone(), FXTiles.getHumidityYearAlone()
        );
        tilePane.setMinSize(FXVar.STACK_PANE_CONSTRAINTS_WIDTH * FXVar.MUL_CONSTRAINTS, FXVar.STACK_PANE_CONSTRAINTS_HEIGHT * FXVar.MUL_CONSTRAINTS);
        tilePane.setPrefSize(FXVar.STACK_PANE_CONSTRAINTS_WIDTH * FXVar.MUL_CONSTRAINTS, FXVar.STACK_PANE_CONSTRAINTS_HEIGHT * FXVar.MUL_CONSTRAINTS);
        tilePane.setMaxSize(FXVar.STACK_PANE_CONSTRAINTS_WIDTH * FXVar.MUL_CONSTRAINTS, FXVar.STACK_PANE_CONSTRAINTS_HEIGHT * FXVar.MUL_CONSTRAINTS);
    }

    static void tileAlignment(@NotNull final GridPane tileAlignment, @NotNull final StackPane tilePane) {
        tileAlignment.getChildren().add(tilePane);
        GridPane.setColumnIndex(tilePane, 1);
        GridPane.setRowIndex(tilePane, 1);
        final ColumnConstraints columnConstraints = new ColumnConstraints(
                FXVar.STACK_PANE_CONSTRAINTS_WIDTH, FXVar.STACK_PANE_CONSTRAINTS_WIDTH, FXVar.STACK_PANE_CONSTRAINTS_WIDTH,
                Priority.ALWAYS, HPos.CENTER, false);
        final RowConstraints rowConstraints = new RowConstraints(
                FXVar.STACK_PANE_CONSTRAINTS_HEIGHT, FXVar.STACK_PANE_CONSTRAINTS_HEIGHT, FXVar.STACK_PANE_CONSTRAINTS_HEIGHT,
                Priority.ALWAYS, VPos.CENTER, false
        );
        tileAlignment.setMinSize(FXVar.SCREEN_SIZE.width - FXVar.TILE_WIDTH_MENU, FXVar.SCREEN_SIZE.height - FXVar.TILE_HEIGHT_MENU);
        tileAlignment.setPrefSize(FXVar.SCREEN_SIZE.width - FXVar.TILE_WIDTH_MENU, FXVar.SCREEN_SIZE.height - FXVar.TILE_HEIGHT_MENU);
        tileAlignment.setMaxSize(FXVar.SCREEN_SIZE.width - FXVar.TILE_WIDTH_MENU, FXVar.SCREEN_SIZE.height - FXVar.TILE_HEIGHT_MENU);
        tileAlignment.getColumnConstraints().setAll(
                columnConstraints,
                new ColumnConstraints(
                        FXVar.STACK_PANE_CONSTRAINTS_WIDTH * FXVar.MUL_CONSTRAINTS, FXVar.STACK_PANE_CONSTRAINTS_WIDTH * FXVar.MUL_CONSTRAINTS, FXVar.STACK_PANE_CONSTRAINTS_WIDTH * FXVar.MUL_CONSTRAINTS,
                        Priority.ALWAYS, HPos.CENTER, false
                ),
                columnConstraints
        );
        tileAlignment.getRowConstraints().setAll(
                rowConstraints,
                new RowConstraints(
                        FXVar.STACK_PANE_CONSTRAINTS_HEIGHT * FXVar.MUL_CONSTRAINTS, FXVar.STACK_PANE_CONSTRAINTS_HEIGHT * FXVar.MUL_CONSTRAINTS, FXVar.STACK_PANE_CONSTRAINTS_HEIGHT * FXVar.MUL_CONSTRAINTS,
                        Priority.ALWAYS, VPos.CENTER, false
                ),
                rowConstraints
        );
    }

    static void mainPane(@NotNull final GridPane mainPane, @NotNull final FlowGridPane weatherDBPane, @NotNull final FlowGridPane menuPane, @NotNull FlowGridPane timePane, @NotNull GridPane tileAlignment) {
        mainPane.getChildren().addAll(weatherDBPane, menuPane, timePane, tileAlignment);
        GridPane.setColumnIndex(weatherDBPane, 0);
        GridPane.setRowIndex(weatherDBPane, 0);
        GridPane.setColumnIndex(menuPane, 0);
        GridPane.setRowIndex(menuPane, 1);
        GridPane.setColumnIndex(timePane, 1);
        GridPane.setRowIndex(timePane, 0);
        GridPane.setColumnIndex(tileAlignment, 1);
        GridPane.setRowIndex(tileAlignment, 1);

        mainPane.getColumnConstraints().setAll(
                new ColumnConstraints(
                        FXVar.TILE_WIDTH_MENU, FXVar.TILE_WIDTH_MENU, FXVar.TILE_WIDTH_MENU,
                        Priority.ALWAYS, HPos.CENTER, false
                ),
                new ColumnConstraints(
                        FXVar.SCREEN_SIZE.width - FXVar.TILE_WIDTH_MENU, FXVar.SCREEN_SIZE.width - FXVar.TILE_WIDTH_MENU, FXVar.SCREEN_SIZE.width - FXVar.TILE_WIDTH_MENU,
                        Priority.ALWAYS, HPos.CENTER, false
                )
        );
        mainPane.getRowConstraints().setAll(
                new RowConstraints(
                        FXVar.TILE_HEIGHT_TIME, FXVar.TILE_HEIGHT_TIME, FXVar.TILE_HEIGHT_TIME,
                        Priority.ALWAYS, VPos.CENTER, false
                ),
                new RowConstraints(
                        FXVar.SCREEN_SIZE.height - FXVar.TILE_HEIGHT_TIME, FXVar.SCREEN_SIZE.height - FXVar.TILE_HEIGHT_TIME, FXVar.SCREEN_SIZE.height - FXVar.TILE_HEIGHT_TIME,
                        Priority.ALWAYS, VPos.CENTER, false
                )
        );

        mainPane.setAlignment(Pos.CENTER);
        mainPane.setCenterShape(true);
        mainPane.setPadding(new Insets(5));
        mainPane.setMinSize(FXVar.SCREEN_SIZE.width, FXVar.SCREEN_SIZE.height);
        mainPane.setPrefSize(FXVar.SCREEN_SIZE.width, FXVar.SCREEN_SIZE.height);
        mainPane.setMaxSize(FXVar.SCREEN_SIZE.width, FXVar.SCREEN_SIZE.height);
        mainPane.setBackground(FXVar.SCENE_BACKGROUND);
    }


}
