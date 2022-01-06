package com.github.jakobwilms.weatherdb.fx;

import eu.hansolo.tilesfx.tools.FlowGridPane;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.layout.*;
import org.jetbrains.annotations.NotNull;

final class FXPanes {

    private static Pane selectedPane;

    private final @NotNull GridPane mainPane;
    private final @NotNull FlowGridPane weatherDBPane, menuPane, timePane;
    private final @NotNull FlowGridPane overviewPane, currentPane, currentPaneBottom, dayPane, dayPaneBottom, monthPane, monthPaneBottom, yearPane, yearPaneBottom,
            tempPane, rainfallPane, windPane, cloudsPane, humidityPane;
    private final @NotNull VBox currentBox,dayBox, monthBox, yearBox;

    private final @NotNull VBox welcomeBox;

    private final @NotNull GridPane tileAlignment;
    private final @NotNull StackPane tilePane;
    public FXPanes() {
        this.weatherDBPane = FXPaneUtils.weatherDBPane();

        this.menuPane = FXPaneUtils.menuPane();
        this.timePane = FXPaneUtils.timePane();

        this.overviewPane = FXPaneUtils.overviewPane();

        this.currentPane = FXPaneUtils.currentPane();
        this.currentPaneBottom = FXPaneUtils.currentPaneBottom();

        this.dayPane = FXPaneUtils.dayPane();
        this.dayPaneBottom = FXPaneUtils.dayPaneBottom();

        this.monthPane = FXPaneUtils.monthPane();
        this.monthPaneBottom = FXPaneUtils.monthPaneBottom();

        this.yearPane = FXPaneUtils.yearPane();
        this.yearPaneBottom = FXPaneUtils.yearPaneBottom();

        this.tempPane = FXPaneUtils.tempPane();
        this.windPane = FXPaneUtils.windPane();
        this.rainfallPane = FXPaneUtils.rainfallPane();
        this.cloudsPane = FXPaneUtils.cloudsPane();
        this.humidityPane = FXPaneUtils.humidityPane();

        this.currentBox = new VBox(5, getCurrentPane(), getCurrentPaneBottom());
        this.dayBox = new VBox(5, getDayPane(), getDayPaneBottom());
        this.monthBox = new VBox(5, getMonthPane(), getMonthPaneBottom());
        this.yearBox = new VBox(5, getYearPane(), getYearPaneBottom());

        this.welcomeBox = FXPaneUtils.welcomeBox();

        this.tilePane = new StackPane(getWelcomeBox(), getOverviewPane(), getCurrentBox(), getDayBox(), getMonthBox(), getYearBox(),
                getTempPane(), getWindPane(), getRainfallPane(), getCloudsPane(), getHumidityPane());
        FXPaneUtils.tilePane(getTilePane());

        StackPane.setAlignment(overviewPane, Pos.CENTER);
        StackPane.setAlignment(currentPane, Pos.CENTER);
        StackPane.setAlignment(dayPane, Pos.CENTER);
        StackPane.setAlignment(monthPane, Pos.CENTER);
        StackPane.setAlignment(yearPane, Pos.CENTER);
        StackPane.setAlignment(tempPane, Pos.CENTER);
        StackPane.setAlignment(windPane, Pos.CENTER);
        StackPane.setAlignment(rainfallPane, Pos.CENTER);
        StackPane.setAlignment(cloudsPane, Pos.CENTER);
        StackPane.setAlignment(humidityPane, Pos.CENTER);

        this.tileAlignment = new GridPane();
        FXPaneUtils.tileAlignment(getTileAlignment(), getTilePane());

        this.mainPane = new GridPane();
        FXPaneUtils.mainPane(getMainPane(), getWeatherDBPane(), getMenuPane(), getTimePane(), getTileAlignment());

        GridPane.setHalignment(getTilePane(), HPos.CENTER);
        GridPane.setValignment(getTilePane(), VPos.CENTER);

        flowGridPane(getOverviewPane(), 1, false);
        getOverviewPane().setHgap(40);

        flowGridPane(getCurrentPane(), 2, true);
        flowGridPane(getCurrentPaneBottom(), 2, true);
        flowGridPane(getDayPane(), 2, true);
        flowGridPane(getDayPaneBottom(), 2, true);
        flowGridPane(getMonthPane(), 2, true);
        flowGridPane(getMonthPaneBottom(), 2, true);
        flowGridPane(getYearPane(), 2, true);
        flowGridPane(getYearPaneBottom(), 2, true);
        flowGridPane(getTempPane(), 1, false);
        flowGridPane(getWindPane(), 1, false);
        flowGridPane(getRainfallPane(), 1, false);
        flowGridPane(getCloudsPane(), 1, false);
        flowGridPane(getHumidityPane(), 1, false);

        vBox(getCurrentBox());
        vBox(getDayBox());
        vBox(getMonthBox());
        vBox(getYearBox());
    }

    private void flowGridPane(@NotNull FlowGridPane pane, float div, boolean visible) {
        GridPane.setHalignment(pane, HPos.CENTER);
        GridPane.setValignment(pane, VPos.CENTER);
        pane.setHgap(5);
        pane.setVgap(5);
        pane.setCenterShape(true);
        pane.setPadding(new Insets(5));
        pane.setMinSize(FXVar.STACK_PANE_CONSTRAINTS_WIDTH * FXVar.MUL_CONSTRAINTS, FXVar.STACK_PANE_CONSTRAINTS_HEIGHT * FXVar.MUL_CONSTRAINTS / div);
        pane.setPrefSize(FXVar.STACK_PANE_CONSTRAINTS_WIDTH * FXVar.MUL_CONSTRAINTS, FXVar.STACK_PANE_CONSTRAINTS_HEIGHT * FXVar.MUL_CONSTRAINTS / div);
        pane.setMaxSize(FXVar.STACK_PANE_CONSTRAINTS_WIDTH * FXVar.MUL_CONSTRAINTS, FXVar.STACK_PANE_CONSTRAINTS_HEIGHT * FXVar.MUL_CONSTRAINTS / div);
        pane.setBackground(FXVar.SCENE_BACKGROUND);
        pane.setVisible(visible);
    }

    private void vBox(@NotNull VBox vBox) {
        vBox.setCenterShape(true);
        vBox.setPadding(new Insets(5));
        vBox.setBackground(FXVar.SCENE_BACKGROUND_BRIGHTER);
        vBox.setMinSize(FXVar.STACK_PANE_CONSTRAINTS_WIDTH * FXVar.MUL_CONSTRAINTS, FXVar.STACK_PANE_CONSTRAINTS_HEIGHT * FXVar.MUL_CONSTRAINTS);
        vBox.setPrefSize(FXVar.STACK_PANE_CONSTRAINTS_WIDTH * FXVar.MUL_CONSTRAINTS, FXVar.STACK_PANE_CONSTRAINTS_HEIGHT * FXVar.MUL_CONSTRAINTS);
        vBox.setMaxSize(FXVar.STACK_PANE_CONSTRAINTS_WIDTH * FXVar.MUL_CONSTRAINTS, FXVar.STACK_PANE_CONSTRAINTS_HEIGHT * FXVar.MUL_CONSTRAINTS);
        vBox.setVisible(false);
    }

    public static Pane getSelectedPane() {
        return selectedPane;
    }

    public static void setSelectedPane(Pane selectedPane) {
        FXPanes.selectedPane = selectedPane;
    }

    public @NotNull VBox getWelcomeBox() {
        return welcomeBox;
    }

    public @NotNull FlowGridPane getOverviewPane() {
        return overviewPane;
    }

    public @NotNull FlowGridPane getCurrentPane() {
        return currentPane;
    }

    public @NotNull FlowGridPane getDayPane() {
        return dayPane;
    }

    public @NotNull GridPane getTileAlignment() {
        return tileAlignment;
    }

    public @NotNull FlowGridPane getMonthPane() {
        return monthPane;
    }

    public @NotNull FlowGridPane getYearPane() {
        return yearPane;
    }

    public @NotNull FlowGridPane getTempPane() {
        return tempPane;
    }

    public @NotNull FlowGridPane getRainfallPane() {
        return rainfallPane;
    }

    public @NotNull FlowGridPane getWindPane() {
        return windPane;
    }

    public @NotNull FlowGridPane getCloudsPane() {
        return cloudsPane;
    }

    public @NotNull FlowGridPane getHumidityPane() {
        return humidityPane;
    }

    public @NotNull GridPane getMainPane() {
        return mainPane;
    }

    public @NotNull FlowGridPane getWeatherDBPane() {
        return weatherDBPane;
    }

    public @NotNull FlowGridPane getMenuPane() {
        return menuPane;
    }

    public @NotNull FlowGridPane getTimePane() {
        return timePane;
    }

    public @NotNull StackPane getTilePane() {
        return tilePane;
    }

    public @NotNull FlowGridPane getCurrentPaneBottom() {
        return currentPaneBottom;
    }

    public @NotNull FlowGridPane getDayPaneBottom() {
        return dayPaneBottom;
    }

    public @NotNull FlowGridPane getMonthPaneBottom() {
        return monthPaneBottom;
    }

    public @NotNull FlowGridPane getYearPaneBottom() {
        return yearPaneBottom;
    }

    public @NotNull VBox getCurrentBox() {
        return currentBox;
    }

    public @NotNull VBox getDayBox() {
        return dayBox;
    }

    public @NotNull VBox getMonthBox() {
        return monthBox;
    }

    public @NotNull VBox getYearBox() {
        return yearBox;
    }
}
