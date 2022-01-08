package com.github.jakobwilms.weatherdb.fx;

import eu.hansolo.tilesfx.Section;
import eu.hansolo.tilesfx.Tile;
import eu.hansolo.tilesfx.TileBuilder;
import eu.hansolo.tilesfx.TimeSectionBuilder;
import eu.hansolo.tilesfx.chart.ChartData;
import eu.hansolo.tilesfx.colors.Bright;
import eu.hansolo.tilesfx.colors.Dark;
import eu.hansolo.tilesfx.tools.Helper;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

final class FXTileUtils {

    static Tile weatherDB() {
        final Button button = new Button("WeatherDB");
        button.setFont(Font.font("arial", FXVar.TILE_WIDTH_TIME / 10.0));
        button.setTextFill(Color.AQUA);
        button.setId("weatherDBButton");
        button.setOnAction(FXEvent.MENU_HANDLER);
        button.setMinSize(FXVar.TILE_WIDTH_MENU - 6, FXVar.TILE_HEIGHT_TIME - 6);
        button.setPrefSize(FXVar.TILE_WIDTH_MENU - 6, FXVar.TILE_HEIGHT_TIME - 6);
        button.setMaxSize(FXVar.TILE_WIDTH_MENU - 6, FXVar.TILE_HEIGHT_TIME - 6);
        button.setBorder(FXVar.MENU_BUTTON_BORDER_DARK);
        button.setBackground(FXVar.SCENE_BACKGROUND_BRIGHTER);
        return TileBuilder.create()
                .skinType(Tile.SkinType.CUSTOM)
                .minSize(FXVar.TILE_WIDTH_MENU, FXVar.TILE_HEIGHT_TIME)
                .prefSize(FXVar.TILE_WIDTH_MENU, FXVar.TILE_HEIGHT_TIME)
                .maxSize(FXVar.TILE_WIDTH_MENU, FXVar.TILE_HEIGHT_TIME)
                .title("")
                .text("")
                .borderColor(Color.AQUA)
                .borderWidth(2)
                .graphic(button)
                .build();
    }

    static Tile menu(String text, String id) {
        Button button = new Button(text);
        button.setTextFill(FXVar.MENU_BUTTON_COLOR_DARK);
        button.setFont(Font.font("arial", FXVar.TILE_WIDTH_MENU / 10.0));
        button.setMinSize(FXVar.TILE_WIDTH_MENU - 6, FXVar.TILE_HEIGHT_MENU - 6);
        button.setPrefSize(FXVar.TILE_WIDTH_MENU - 6, FXVar.TILE_HEIGHT_MENU - 6);
        button.setMaxSize(FXVar.TILE_WIDTH_MENU - 6, FXVar.TILE_HEIGHT_MENU - 6);
        button.setBorder(FXVar.MENU_BUTTON_BORDER_DARK);
        button.setBackground(FXVar.MENU_BUTTON_BACKGROUND);
        button.setAlignment(Pos.CENTER);
        button.setId(id);
        button.setOnAction(FXEvent.MENU_HANDLER);

        return TileBuilder.create()
                .skinType(Tile.SkinType.CUSTOM)
                .minSize(FXVar.TILE_WIDTH_MENU, FXVar.TILE_HEIGHT_MENU + 4)
                .prefSize(FXVar.TILE_WIDTH_MENU, FXVar.TILE_HEIGHT_MENU + 4)
                .maxSize(FXVar.TILE_WIDTH_MENU, FXVar.TILE_HEIGHT_MENU + 4)
                .title("")
                .text("")
                .graphic(button)
                .roundedCorners(true)
                .build();
    }

    static @NotNull Tile welcome() {
        final Text text = new Text("Welcome!");
        text.setFont(Font.font("arial", (FXVar.SCREEN_SIZE.width - FXVar.TILE_WIDTH_MENU) / 10.0));
        text.setFill(Color.AQUA);
        final Tile tile = TileBuilder.create()
                .skinType(Tile.SkinType.CUSTOM)
                .minSize((FXVar.SCREEN_SIZE.width - FXVar.TILE_WIDTH_MENU) / 1.2, (FXVar.SCREEN_SIZE.height - FXVar.TILE_HEIGHT_TIME) / 2.0)
                .prefSize((FXVar.SCREEN_SIZE.width - FXVar.TILE_WIDTH_MENU) / 1.2, (FXVar.SCREEN_SIZE.height - FXVar.TILE_HEIGHT_TIME) / 2.0)
                .maxSize((FXVar.SCREEN_SIZE.width - FXVar.TILE_WIDTH_MENU) / 1.2, (FXVar.SCREEN_SIZE.height - FXVar.TILE_HEIGHT_TIME) / 2.0)
                .title("")
                .text("")
                .graphic(text)
                .build();
        tile.setBorder(FXVar.WELCOME_BORDER);
        return tile;
    }

    static @NotNull Tile timer() {
        final Tile tile = TileBuilder.create()
                .skinType(Tile.SkinType.CLOCK)
                .prefSize(FXVar.TILE_WIDTH_TIME, FXVar.TILE_HEIGHT_TIME)
                .titleAlignment(TextAlignment.CENTER)
                .titleColor(Color.AQUA)
                .textSize(Tile.TextSize.BIGGER)
                .title("Clock")
                .text("")
                .dateVisible(false)
                .locale(Locale.getDefault())
                .running(true)
                .build();
        tile.setBorder(FXVar.TILE_BORDER);
        return tile;
    }

    static @NotNull Tile clock() {
        final Tile tile = TileBuilder.create()
                .skinType(Tile.SkinType.TIMER_CONTROL)
                .prefSize(FXVar.TILE_WIDTH_TIME, FXVar.TILE_HEIGHT_TIME)
                .titleAlignment(TextAlignment.CENTER)
                .titleColor(Color.AQUA)
                .textSize(Tile.TextSize.BIGGER)
                .title("Time")
                .text("")
                .secondsVisible(true)
                .dateVisible(false)
                .alarmsVisible(false)
                .timeSections(TimeSectionBuilder.create()
                        .start(LocalTime.now().plusSeconds(20))
                        .stop(LocalTime.now().plusHours(1))
                        .color(Tile.GRAY)
                        .highlightColor(Tile.RED)
                        .build())
                .running(true)
                .build();
        tile.setBorder(FXVar.TILE_BORDER);
        return tile;
    }

    static @NotNull Tile date() {
        final Tile tile = TileBuilder.create()
                .skinType(Tile.SkinType.DATE)
                .prefSize(FXVar.TILE_WIDTH_TIME, FXVar.TILE_HEIGHT_TIME)
                .titleAlignment(TextAlignment.CENTER)
                .titleColor(Color.AQUA)
                .textSize(Tile.TextSize.BIGGER)
                .title("Date")
                .text("")
                .build();
        tile.setBorder(FXVar.TILE_BORDER);
        return tile;
    }

    static @NotNull Tile countdown() {
        final Tile tile = TileBuilder.create()
                .skinType(Tile.SkinType.COUNTDOWN_TIMER)
                .prefSize(FXVar.TILE_WIDTH_TIME, FXVar.TILE_HEIGHT_TIME)
                .titleAlignment(TextAlignment.CENTER)
                .titleColor(Color.AQUA)
                .textSize(Tile.TextSize.BIGGER)
                .title("Refresh in:")
                .description("")
                .text("")
                .barColor(Bright.ORANGE_RED)
                .timePeriod(Duration.ofSeconds(FXTimer.waitSeconds))
                .build();
        tile.setBorder(FXVar.TILE_BORDER);
        return tile;
    }

    static @NotNull Tile refreshSwitch() {
        final Tile tile = TileBuilder.create()
                .skinType(Tile.SkinType.SWITCH)
                .prefSize(FXVar.TILE_WIDTH_TIME, FXVar.TILE_HEIGHT_TIME)
                .titleAlignment(TextAlignment.CENTER)
                .titleColor(Color.AQUA)
                .textSize(Tile.TextSize.BIGGER)
                .title("Refresh")
                .text("")
                .build();
        tile.setBorder(FXVar.TILE_BORDER);
        return tile;
    }

    static @NotNull Tile tempCurrent(String text, int width, int height, String id, boolean visible) {
        final Tile tile = TileBuilder.create()
                .skinType(Tile.SkinType.FIRE_SMOKE)
                .prefSize(width, height)
                .title(text)
                .titleAlignment(TextAlignment.CENTER)
                .titleColor(Color.AQUA)
                .textSize(Tile.TextSize.BIGGER)
                .text("")
                .unit("\u00b0C")
                .minValue(-30).maxValue(50)
                .threshold(30)
                .decimals(0)
                .animated(true)
                .build();
        tile.setBorder(FXVar.TILE_BORDER);
        tile.setOnMouseClicked(FXEvent.TILE_HANDLER);
        tile.setId(id);
        tile.setVisible(visible);
        return tile;
    }

    static @NotNull Tile temp(String text, int width, int height, String id, boolean visible) {
        final Tile tile = TileBuilder.create()
                .skinType(Tile.SkinType.SPARK_LINE)
                .prefSize(width, height)
                .titleAlignment(TextAlignment.CENTER)
                .titleColor(Color.AQUA)
                .textSize(Tile.TextSize.BIGGER)
                .title(text)
                .text("")
                .unit("\u00b0C")
                .minValue(-30).maxValue(50)
                .gradientStops(new Stop(0, Tile.GREEN),
                        new Stop(0.5, Tile.YELLOW),
                        new Stop(1.0, Tile.RED))
                .strokeWithGradient(true)
                .smoothing(false)
                .build();
        tile.setBorder(FXVar.TILE_BORDER);
        tile.setOnMouseClicked(FXEvent.TILE_HANDLER);
        tile.setId(id);
        tile.setVisible(visible);
        return tile;
    }

    static @NotNull Tile windCurrent(String text, int width, int height, String id, boolean visible) {
        final Tile tile = TileBuilder.create()
                .skinType(Tile.SkinType.GAUGE2)
                .prefSize(width, height)
                .titleAlignment(TextAlignment.CENTER)
                .titleColor(Color.AQUA)
                .textSize(Tile.TextSize.BIGGER)
                .title(text)
                .text("")
                .unit("km/h")
                .value(0)
                .minValue(0).maxValue(100)
                .gradientStops(new Stop(0, Tile.BLUE),
                        new Stop(0.25, Tile.GREEN),
                        new Stop(0.5, Tile.YELLOW),
                        new Stop(0.75, Tile.ORANGE),
                        new Stop(1, Tile.RED))
                .strokeWithGradient(true)
                .animated(true)
                .build();
        tile.setBorder(FXVar.TILE_BORDER);
        tile.setOnMouseClicked(FXEvent.TILE_HANDLER);
        tile.setId(id);
        tile.setVisible(visible);
        return tile;
    }

    static @NotNull Tile wind(String text, int width, int height, String id, boolean visible) {
        final Tile tile = TileBuilder.create()
                .skinType(Tile.SkinType.SMOOTH_AREA_CHART)
                .prefSize(width, height)
                .minValue(0).maxValue(100)
                .title(text)
                .unit("km/h")
                .text("")
                .tooltipText("")
                .animated(true)
                .chartData(new ChartData("1", 40, Tile.BLUE), new ChartData("2", 70, Tile.BLUE), new ChartData("3", 20, Tile.BLUE))
                .build();
        tile.setBorder(FXVar.TILE_BORDER);
        tile.setOnMouseClicked(FXEvent.TILE_HANDLER);
        tile.setId(id);
        tile.setVisible(visible);
        return tile;
    }

    static @NotNull Tile rainfallCurrent(String text, int width, int height, String id, boolean visible) {
        final Tile tile = TileBuilder.create()
                .skinType(Tile.SkinType.FLUID)
                .prefSize(width, height)
                .titleAlignment(TextAlignment.CENTER)
                .titleColor(Color.AQUA)
                .textSize(Tile.TextSize.BIGGER)
                .title(text)
                .text("")
                .unit("mm/d")
                .decimals(1)
                .gradientStops(new Stop(0, Color.DARKBLUE),
                        new Stop(0.33, Tile.BLUE),
                        new Stop(0.66, Color.LIGHTBLUE),
                        new Stop(1, Color.AQUA))
                .strokeWithGradient(true)
                .animated(true)
                .build();
        tile.setBorder(FXVar.TILE_BORDER);
        tile.setOnMouseClicked(FXEvent.TILE_HANDLER);
        tile.setId(id);
        tile.setVisible(visible);
        return tile;
    }

    static @NotNull Tile rainfall(String text, int width, int height, String id, boolean visible) {
        final Tile tile = TileBuilder.create()
                .skinType(Tile.SkinType.TIMELINE)
                .prefSize(width, height)
                .titleAlignment(TextAlignment.CENTER)
                .titleColor(Color.AQUA)
                .textSize(Tile.TextSize.BIGGER)
                .title(text)
                .unit("mm/d")
                .minValue(0).maxValue(350)
                .smoothing(true)
                .lowerThreshold(70).lowerThresholdColor(Tile.TileColor.RED.color)
                .threshold(240).thresholdColor(Tile.TileColor.RED.color)
                .thresholdVisible(true)
                .tickLabelColor(Helper.getColorWithOpacity(Tile.FOREGROUND, 0.5))
                .sections(new Section(0, 70, "Low", Helper.getColorWithOpacity(Dark.RED, 0.1)),
                        new Section(70, 140, "Ok", Helper.getColorWithOpacity(Bright.GREEN, 0.15)),
                        new Section(140, 350, "High", Helper.getColorWithOpacity(Dark.RED, 0.1)))
                .highlightSections(true).secondsVisible(true)
                .timePeriod(Duration.ofMinutes(1))
                .maxTimePeriod(Duration.ofMinutes(1))
                .timePeriodResolution(TimeUnit.SECONDS)
                .numberOfValuesForTrendCalculation(5)
                .trendVisible(true)
                .gradientStops(new Stop(0, Dark.RED),
                        new Stop(0.15, Dark.RED),
                        new Stop(0.2, Bright.YELLOW_ORANGE),
                        new Stop(0.25, Bright.GREEN),
                        new Stop(0.3, Bright.GREEN),
                        new Stop(0.35, Bright.GREEN),
                        new Stop(0.45, Bright.YELLOW_ORANGE),
                        new Stop(0.5, Bright.ORANGE),
                        new Stop(0.685, Dark.RED),
                        new Stop(1.0, Dark.RED))
                .strokeWithGradient(true)
                .averageVisible(true)
                .averagingPeriod(60)
                .timeoutMs(60000)
                .build();
        tile.setBorder(FXVar.TILE_BORDER);
        tile.setOnMouseClicked(FXEvent.TILE_HANDLER);
        tile.setId(id);
        tile.setVisible(visible);
        return tile;
    }

    static @NotNull Tile cloudsCurrent(String text, int width, int height, String id, boolean visible) {
        final Tile tile = TileBuilder.create()
                .skinType(Tile.SkinType.RADIAL_PERCENTAGE)
                .prefSize(width, height)
                .minValue(0).maxValue(100).unit("%")
                .titleAlignment(TextAlignment.CENTER)
                .titleColor(Color.AQUA)
                .textSize(Tile.TextSize.BIGGER)
                .title(text)
                .text("")
                .description("")
                .animated(true)
                .value(0)
                .barColor(Tile.BLUE)
                .decimals(0)
                .build();
        tile.setBorder(FXVar.TILE_BORDER);
        tile.setOnMouseClicked(FXEvent.TILE_HANDLER);
        tile.setId(id);
        tile.setVisible(visible);
        return tile;
    }

    static @NotNull Tile clouds(String text, int width, int height, String id, boolean visible) {
        final Tile tile = TileBuilder.create()
                .skinType(Tile.SkinType.TIMELINE)
                .prefSize(width, height)
                .titleAlignment(TextAlignment.CENTER)
                .titleColor(Color.AQUA)
                .textSize(Tile.TextSize.BIGGER)
                .title(text)
                .unit("%")
                .minValue(0).maxValue(100)
                .smoothing(true)
                .lowerThreshold(20).lowerThresholdColor(Tile.TileColor.RED.color)
                .threshold(80).thresholdColor(Tile.TileColor.RED.color)
                .thresholdVisible(true)
                .tickLabelColor(Helper.getColorWithOpacity(Tile.FOREGROUND, 0.5))
                .sections(new Section(0, 33, "Low", Helper.getColorWithOpacity(Dark.RED, 0.1)),
                        new Section(33, 66, "Ok", Helper.getColorWithOpacity(Bright.GREEN, 0.15)),
                        new Section(66, 100, "High", Helper.getColorWithOpacity(Dark.RED, 0.1)))
                .highlightSections(true).secondsVisible(true)
                .timePeriod(Duration.ofMinutes(1))
                .maxTimePeriod(Duration.ofMinutes(1))
                .timePeriodResolution(TimeUnit.SECONDS)
                .numberOfValuesForTrendCalculation(5)
                .trendVisible(true)
                .gradientStops(new Stop(0, Dark.RED),
                        new Stop(0.15, Dark.RED),
                        new Stop(0.2, Bright.YELLOW_ORANGE),
                        new Stop(0.25, Bright.GREEN),
                        new Stop(0.3, Bright.GREEN),
                        new Stop(0.35, Bright.GREEN),
                        new Stop(0.45, Bright.YELLOW_ORANGE),
                        new Stop(0.5, Bright.ORANGE),
                        new Stop(0.685, Dark.RED),
                        new Stop(1.0, Dark.RED))
                .strokeWithGradient(true)
                .averageVisible(true)
                .averagingPeriod(60)
                .timeoutMs(60000)
                .build();
        tile.setBorder(FXVar.TILE_BORDER);
        tile.setOnMouseClicked(FXEvent.TILE_HANDLER);
        tile.setId(id);
        tile.setVisible(visible);
        return tile;
    }

    static @NotNull Tile humidityCurrent(String text, int width, int height, String id, boolean visible) {
        final Tile tile = TileBuilder.create()
                .skinType(Tile.SkinType.RADIAL_PERCENTAGE)
                .prefSize(width, height)
                .minValue(0).maxValue(100).unit("%")
                .titleAlignment(TextAlignment.CENTER)
                .titleColor(Color.AQUA)
                .textSize(Tile.TextSize.BIGGER)
                .title(text)
                .text("")
                .description("")
                .animated(true)
                .value(0)
                .barColor(Tile.BLUE)
                .decimals(0)
                .build();
        tile.setBorder(FXVar.TILE_BORDER);
        tile.setOnMouseClicked(FXEvent.TILE_HANDLER);
        tile.setId(id);
        tile.setVisible(visible);
        return tile;
    }

    static @NotNull Tile humidity(String text, int width, int height, String id, boolean visible) {
        final Tile tile = TileBuilder.create()
                .skinType(Tile.SkinType.SPARK_LINE)
                .prefSize(width, height)
                .titleAlignment(TextAlignment.CENTER)
                .titleColor(Color.AQUA)
                .textSize(Tile.TextSize.BIGGER)
                .title(text)
                .text("")
                .unit("%")
                .minValue(0).maxValue(100)
                .gradientStops(new Stop(0, Tile.GREEN),
                        new Stop(0.5, Tile.YELLOW),
                        new Stop(1.0, Tile.RED))
                .strokeWithGradient(true)
                .smoothing(false)
                .build();
        tile.setBorder(FXVar.TILE_BORDER);
        tile.setOnMouseClicked(FXEvent.TILE_HANDLER);
        tile.setId(id);
        tile.setVisible(visible);
        return tile;
    }
}
