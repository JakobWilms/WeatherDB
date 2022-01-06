package com.github.jakobwilms.weatherdb.fx;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

final class FXEvent {

    public static final EventHandler<ActionEvent> MENU_HANDLER = event -> {
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
        } else {
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
    };


}
