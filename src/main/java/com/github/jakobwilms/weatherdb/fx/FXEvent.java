package com.github.jakobwilms.weatherdb.fx;

import eu.hansolo.tilesfx.Tile;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import org.jetbrains.annotations.NotNull;

final class FXEvent {

    public static final EventHandler<ActionEvent> MENU_HANDLER = FXEvent::menuHandler;

    public static final EventHandler<MouseEvent> TILE_HANDLER = FXEvent::tileHandler;

    private static void menuHandler(@NotNull ActionEvent event) {
        Button source = (Button) event.getSource();
        if (FXTiles.getSelectedMenuButton() == source) {
            source.setBorder(FXVar.MENU_BUTTON_BORDER_DARK);
            source.setTextFill(FXVar.MENU_BUTTON_COLOR_DARK);
            FXPanes.getSelectedPane().setVisible(false);
            final Button button = (Button) FXTiles.getWeatherDB().getGraphic();
            FXTiles.setSelectedMenuButton(button);
            FXPanes.setSelectedPane(FXMain.getFxPanes().getWelcomeBox());
            FXMain.getFxPanes().getWelcomeBox().setVisible(true);
            button.setBorder(FXVar.MENU_BUTTON_BORDER_LIGHT);
            button.setTextFill(FXVar.MENU_BUTTON_COLOR_LIGHT);
        } else if (source != FXTiles.getMenuAlone().getGraphic()) {
            if (FXTiles.getSelectedMenuButton() != null) {
                FXTiles.getSelectedMenuButton().setBorder(FXVar.MENU_BUTTON_BORDER_DARK);
                FXTiles.getSelectedMenuButton().setTextFill(FXVar.MENU_BUTTON_COLOR_DARK);
            }
            FXTiles.setSelectedMenuButton(source);
            source.setBorder(FXVar.MENU_BUTTON_BORDER_LIGHT);
            source.setTextFill(FXVar.MENU_BUTTON_COLOR_LIGHT);
            if (FXPanes.getSelectedPane() != null)
                FXPanes.getSelectedPane().setVisible(false);
            final Pane pane;
            final FXPanes fxPanes = FXMain.getFxPanes();
            switch (source.getId()) {
                case "overviewButton" -> pane = fxPanes.getOverviewPane();
                case "currentButton" -> pane = fxPanes.getCurrentBox();
                case "dayButton" -> pane = fxPanes.getDayBox();
                case "monthButton" -> pane = fxPanes.getMonthBox();
                case "yearButton" -> pane = fxPanes.getYearBox();
                case "tempButton" -> pane = fxPanes.getTempPane();
                case "rainfallButton" -> pane = fxPanes.getRainfallPane();
                case "windButton" -> pane = fxPanes.getWindPane();
                case "cloudsButton" -> pane = fxPanes.getCloudsPane();
                case "humidityButton" -> pane = fxPanes.getHumidityPane();
                case "weatherDBButton" -> pane = fxPanes.getWelcomeBox();
                default -> pane = null;
            }
            if (pane != null) {
                pane.setVisible(true);
                FXPanes.setSelectedPane(pane);
            }
        }
    }

    private static void tileHandler(@NotNull MouseEvent event) {
        Tile source = (Tile) event.getSource();
        String id = source.getId();
        if (FXTiles.getSelectedMenuButton() != null) {
            FXTiles.getSelectedMenuButton().setBorder(FXVar.MENU_BUTTON_BORDER_DARK);
            FXTiles.getSelectedMenuButton().setTextFill(FXVar.MENU_BUTTON_COLOR_DARK);
        }
        Button menuAlone = (Button) FXTiles.getMenuAlone().getGraphic();
        menuAlone.setBorder(FXVar.MENU_BUTTON_BORDER_LIGHT);
        menuAlone.setTextFill(FXVar.MENU_BUTTON_COLOR_LIGHT);
        FXTiles.setSelectedMenuButton(menuAlone);
        if (FXPanes.getSelectedPane() != null) {
            FXPanes.getSelectedPane().setVisible(false);
        }
        final Tile tile;
        if (id.contains("tempCurrent") || id.contains("tempNow")) {
            tile = FXTiles.getTempNowAlone();
        } else if (id.contains("rainfallCurrent") || id.contains("rainfallNow")) {
            tile = FXTiles.getRainfallNowAlone();
        } else if (id.contains("windCurrent") || id.contains("windNow")) {
            tile = FXTiles.getWindNowAlone();
        } else if (id.contains("cloudsCurrent") || id.contains("cloudsNow")) {
            tile = FXTiles.getCloudsNowAlone();
        } else if (id.contains("humidityCurrent") || id.contains("humidityNow")) {
            tile = FXTiles.getHumidityNowAlone();
        } else if (id.contains("temp24") || id.contains("tempDay")) {
            tile = FXTiles.getTempDayAlone();
        } else if (id.contains("rainfall24") || id.contains("rainfallDay")) {
            tile = FXTiles.getRainfallDayAlone();
        } else if (id.contains("wind24") || id.contains("windDay")) {
            tile = FXTiles.getWindDayAlone();
        } else if (id.contains("clouds24") || id.contains("cloudsDay")) {
            tile = FXTiles.getCloudsDayAlone();
        } else if (id.contains("humidity24") || id.contains("humidityDay")) {
            tile = FXTiles.getHumidityDayAlone();
        } else if (id.contains("temp31") || id.contains("tempMonth")) {
            tile = FXTiles.getTempMonthAlone();
        } else if (id.contains("rainfall31") || id.contains("rainfallMonth")) {
            tile = FXTiles.getRainfallMonthAlone();
        } else if (id.contains("wind31") || id.contains("windMonth")) {
            tile = FXTiles.getWindMonthAlone();
        } else if (id.contains("clouds31") || id.contains("cloudsMonth")) {
            tile = FXTiles.getCloudsMonthAlone();
        } else if (id.contains("humidity31") || id.contains("humidityMonth")) {
            tile = FXTiles.getHumidityMonthAlone();
        } else if (id.contains("rainfall365") || id.contains("rainfallYear")) {
            tile = FXTiles.getRainfallYearAlone();
        } else if (id.contains("wind365") || id.contains("windYear")) {
            tile = FXTiles.getWindYearAlone();
        } else if (id.contains("clouds365") || id.contains("cloudsYear")) {
            tile = FXTiles.getCloudsYearAlone();
        } else if (id.contains("humidity365") || id.contains("humidityYear")) {
            tile = FXTiles.getHumidityYearAlone();
        } else {
            tile = null;
        }

        if (tile != null) {
            tile.setVisible(true);
            FXPanes.setSelectedPane(tile);
        }
    }
}
