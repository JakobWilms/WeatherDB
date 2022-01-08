package com.github.jakobwilms.weatherdb.fx;

import eu.hansolo.tilesfx.Tile;
import javafx.scene.control.Button;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class FXTiles {
    private static final @NotNull Tile weatherDB = FXTileUtils.weatherDB();
    private static final @NotNull Tile welcomeTile = FXTileUtils.welcome();

    private static final @NotNull Tile menuOverview = FXTileUtils.menu("\uD83D\uDDB5 Overview", "overviewButton");
    private static final @NotNull Tile menuCurrent = FXTileUtils.menu("\uD83D\uDDB5 Current", "currentButton");
    private static final @NotNull Tile menuDay = FXTileUtils.menu("\uD83D\uDDB5 Last 24h", "dayButton");
    private static final @NotNull Tile menuMonth = FXTileUtils.menu("\uD83D\uDDB5 Last 31d", "monthButton");
    private static final @NotNull Tile menuYear = FXTileUtils.menu("\uD83D\uDDB5 Last 365d", "yearButton");
    private static final @NotNull Tile menuTemp = FXTileUtils.menu("\uD83C\uDF21 Temperature", "tempButton");
    private static final @NotNull Tile menuRainfall = FXTileUtils.menu("\uD83C\uDF27 Rainfall", "rainfallButton");
    private static final @NotNull Tile menuWind = FXTileUtils.menu("\uD83D\uDCA8 Wind", "windButton");
    private static final @NotNull Tile menuClouds = FXTileUtils.menu("\u26C5 Clouds", "cloudsButton");
    private static final @NotNull Tile menuHumidity = FXTileUtils.menu("\uD83C\uDF0A Humidity", "humidityButton");
    private static final @NotNull Tile menuAlone = FXTileUtils.menu("\uD83D\uDDB5 Single Tile", "aloneButton");

    private static final @NotNull Tile timer = FXTileUtils.timer();
    private static final @NotNull Tile clock = FXTileUtils.clock();
    private static final @NotNull Tile date = FXTileUtils.date();
    private static final @NotNull Tile countdown = FXTileUtils.countdown();
    private static final @NotNull Tile refreshSwitch = FXTileUtils.refreshSwitch();

    private static final @NotNull Tile tempCurrent = FXTileUtils.tempCurrent("Current Temperature", FXVar.TILE_WIDTH_OVERVIEW, FXVar.TILE_HEIGHT_OVERVIEW, "tempCurrent", true);
    private static final @NotNull Tile temp24 = FXTileUtils.temp("24h Temperature", FXVar.TILE_WIDTH_OVERVIEW, FXVar.TILE_HEIGHT_OVERVIEW, "temp24", true);
    private static final @NotNull Tile temp31 = FXTileUtils.temp("31d Temperature", FXVar.TILE_WIDTH_OVERVIEW, FXVar.TILE_HEIGHT_OVERVIEW, "temp31", true);
    private static final @NotNull Tile temp365 = FXTileUtils.temp("365d Temperature", FXVar.TILE_WIDTH_OVERVIEW, FXVar.TILE_HEIGHT_OVERVIEW, "temp365", true);
    private static final @NotNull Tile tempAverage = FXTileUtils.tempCurrent("Average Lifetime Temperature", FXVar.TILE_WIDTH_OVERVIEW, FXVar.TILE_HEIGHT_OVERVIEW, "tempAverage", true);

    private static final @NotNull Tile rainfallCurrent = FXTileUtils.rainfallCurrent("Current Rainfall", FXVar.TILE_WIDTH_OVERVIEW, FXVar.TILE_HEIGHT_OVERVIEW, "rainfallCurrent", true);
    private static final @NotNull Tile rainfall24 = FXTileUtils.rainfall("24h Rainfall", FXVar.TILE_WIDTH_OVERVIEW, FXVar.TILE_HEIGHT_OVERVIEW, "rainfall24", true);
    private static final @NotNull Tile rainfall31 = FXTileUtils.rainfall("31d Rainfall", FXVar.TILE_WIDTH_OVERVIEW, FXVar.TILE_HEIGHT_OVERVIEW, "rainfall31", true);
    private static final @NotNull Tile rainfall365 = FXTileUtils.rainfall("365d Rainfall", FXVar.TILE_WIDTH_OVERVIEW, FXVar.TILE_HEIGHT_OVERVIEW, "rainfall365", true);
    private static final @NotNull Tile rainfallAverage = FXTileUtils.rainfallCurrent("Average Lifetime Rainfall", FXVar.TILE_WIDTH_OVERVIEW, FXVar.TILE_HEIGHT_OVERVIEW, "rainfallAverage", true);

    private static final @NotNull Tile windCurrent = FXTileUtils.windCurrent("Current Wind Speed", FXVar.TILE_WIDTH_OVERVIEW, FXVar.TILE_HEIGHT_OVERVIEW, "windCurrent", true);
    private static final @NotNull Tile wind24 = FXTileUtils.wind("24h Wind", FXVar.TILE_WIDTH_OVERVIEW, FXVar.TILE_HEIGHT_OVERVIEW, "wind24", true);
    private static final @NotNull Tile wind31 = FXTileUtils.wind("31d Wind", FXVar.TILE_WIDTH_OVERVIEW, FXVar.TILE_HEIGHT_OVERVIEW, "wind31", true);
    private static final @NotNull Tile wind365 = FXTileUtils.wind("365d Wind", FXVar.TILE_WIDTH_OVERVIEW, FXVar.TILE_HEIGHT_OVERVIEW, "wind365", true);
    private static final @NotNull Tile windAverage = FXTileUtils.windCurrent("Average Lifetime Wind Speed", FXVar.TILE_WIDTH_OVERVIEW, FXVar.TILE_HEIGHT_OVERVIEW, "windAverage", true);

    private static final @NotNull Tile cloudsCurrent = FXTileUtils.cloudsCurrent("Current Clouds", FXVar.TILE_WIDTH_OVERVIEW, FXVar.TILE_HEIGHT_OVERVIEW, "cloudsCurrent", true);
    private static final @NotNull Tile clouds24 = FXTileUtils.clouds("24h Clouds", FXVar.TILE_WIDTH_OVERVIEW, FXVar.TILE_HEIGHT_OVERVIEW, "clouds24", true);
    private static final @NotNull Tile clouds31 = FXTileUtils.clouds("31d Clouds", FXVar.TILE_WIDTH_OVERVIEW, FXVar.TILE_HEIGHT_OVERVIEW, "clouds31", true);
    private static final @NotNull Tile clouds365 = FXTileUtils.clouds("365d Clouds", FXVar.TILE_WIDTH_OVERVIEW, FXVar.TILE_HEIGHT_OVERVIEW, "clouds365", true);
    private static final @NotNull Tile cloudsAverage = FXTileUtils.cloudsCurrent("Average Lifetime Clouds", FXVar.TILE_WIDTH_OVERVIEW, FXVar.TILE_HEIGHT_OVERVIEW, "cloudsAverage", true);

    private static final @NotNull Tile humidityCurrent = FXTileUtils.humidityCurrent("Current Humidity", FXVar.TILE_WIDTH_OVERVIEW, FXVar.TILE_HEIGHT_OVERVIEW, "humidityCurrent", true);
    private static final @NotNull Tile humidity24 = FXTileUtils.humidity("24h Humidity", FXVar.TILE_WIDTH_OVERVIEW, FXVar.TILE_HEIGHT_OVERVIEW, "humidity24", true);
    private static final @NotNull Tile humidity31 = FXTileUtils.humidity("31d Humidity", FXVar.TILE_WIDTH_OVERVIEW, FXVar.TILE_HEIGHT_OVERVIEW, "humidity31", true);
    private static final @NotNull Tile humidity365 = FXTileUtils.humidity("365d Humidity", FXVar.TILE_WIDTH_OVERVIEW, FXVar.TILE_HEIGHT_OVERVIEW, "humidity365", true);
    private static final @NotNull Tile humidityAverage = FXTileUtils.humidityCurrent("Average Lifetime Humidity", FXVar.TILE_WIDTH_OVERVIEW, FXVar.TILE_HEIGHT_OVERVIEW, "humidityAverage", true);

    private static final @NotNull Tile tempNow = FXTileUtils.tempCurrent("Current Temperature", FXVar.TILE_WIDTH_TIME_VIEW, FXVar.TILE_HEIGHT_TIME_VIEW, "tempNow", true);
    private static final @NotNull Tile rainfallNow = FXTileUtils.rainfallCurrent("Current Temperature", FXVar.TILE_WIDTH_TIME_VIEW, FXVar.TILE_HEIGHT_TIME_VIEW, "rainfallNow", true);
    private static final @NotNull Tile windNow = FXTileUtils.windCurrent("Current Temperature", FXVar.TILE_WIDTH_TIME_VIEW, FXVar.TILE_HEIGHT_TIME_VIEW, "windNow", true);
    private static final @NotNull Tile cloudsNow = FXTileUtils.cloudsCurrent("Current Temperature", FXVar.TILE_WIDTH_TIME_VIEW, FXVar.TILE_HEIGHT_TIME_VIEW, "cloudsNow", true);
    private static final @NotNull Tile humidityNow = FXTileUtils.humidityCurrent("Current Temperature", FXVar.TILE_WIDTH_TIME_VIEW, FXVar.TILE_HEIGHT_TIME_VIEW, "humidityNow", true);

    private static final @NotNull Tile tempNowSingle = FXTileUtils.tempCurrent("Current Temperature", FXVar.TILE_WIDTH_SINGLE_VIEW, FXVar.TILE_HEIGHT_SINGLE_VIEW, "tempNowSingle", true);
    private static final @NotNull Tile rainfallNowSingle = FXTileUtils.rainfallCurrent("Current Temperature", FXVar.TILE_WIDTH_SINGLE_VIEW, FXVar.TILE_HEIGHT_SINGLE_VIEW, "rainfallNowSingle", true);
    private static final @NotNull Tile windNowSingle = FXTileUtils.windCurrent("Current Temperature", FXVar.TILE_WIDTH_SINGLE_VIEW, FXVar.TILE_HEIGHT_SINGLE_VIEW, "windNowSingle", true);
    private static final @NotNull Tile cloudsNowSingle = FXTileUtils.cloudsCurrent("Current Temperature", FXVar.TILE_WIDTH_SINGLE_VIEW, FXVar.TILE_HEIGHT_SINGLE_VIEW, "cloudsNowSingle", true);
    private static final @NotNull Tile humidityNowSingle = FXTileUtils.humidityCurrent("Current Temperature", FXVar.TILE_WIDTH_SINGLE_VIEW, FXVar.TILE_HEIGHT_SINGLE_VIEW, "humidityNowSingle", true);

    private static final @NotNull Tile tempNowAlone = FXTileUtils.tempCurrent("Current Temperature", FXVar.TILE_WIDTH_ALONE, FXVar.TILE_HEIGHT_ALONE, "tempNowAlone", false);
    private static final @NotNull Tile rainfallNowAlone = FXTileUtils.rainfallCurrent("Current Temperature", FXVar.TILE_WIDTH_ALONE, FXVar.TILE_HEIGHT_ALONE, "rainfallNowAlone", false);
    private static final @NotNull Tile windNowAlone = FXTileUtils.windCurrent("Current Temperature", FXVar.TILE_WIDTH_ALONE, FXVar.TILE_HEIGHT_ALONE, "windNowAlone", false);
    private static final @NotNull Tile cloudsNowAlone = FXTileUtils.cloudsCurrent("Current Temperature", FXVar.TILE_WIDTH_ALONE, FXVar.TILE_HEIGHT_ALONE, "cloudsNowAlone", false);
    private static final @NotNull Tile humidityNowAlone = FXTileUtils.humidityCurrent("Current Temperature", FXVar.TILE_WIDTH_ALONE, FXVar.TILE_HEIGHT_ALONE, "humidityNowAlone", false);

    private static final @NotNull Tile tempDay = FXTileUtils.temp("24h Temperature", FXVar.TILE_WIDTH_TIME_VIEW, FXVar.TILE_HEIGHT_TIME_VIEW, "tempDay", true);
    private static final @NotNull Tile rainfallDay = FXTileUtils.rainfall("24h Rainfall", FXVar.TILE_WIDTH_TIME_VIEW, FXVar.TILE_HEIGHT_TIME_VIEW, "rainfallDay", true);
    private static final @NotNull Tile windDay = FXTileUtils.wind("24h Wind", FXVar.TILE_WIDTH_TIME_VIEW, FXVar.TILE_HEIGHT_TIME_VIEW, "windDay", true);
    private static final @NotNull Tile cloudsDay = FXTileUtils.clouds("24h Clouds", FXVar.TILE_WIDTH_TIME_VIEW, FXVar.TILE_HEIGHT_TIME_VIEW, "cloudsDay", true);
    private static final @NotNull Tile humidityDay = FXTileUtils.humidity("24h Humidity", FXVar.TILE_WIDTH_TIME_VIEW, FXVar.TILE_HEIGHT_TIME_VIEW, "humidityDay", true);

    private static final @NotNull Tile tempDaySingle = FXTileUtils.temp("24h Temperature", FXVar.TILE_WIDTH_SINGLE_VIEW, FXVar.TILE_HEIGHT_SINGLE_VIEW, "tempDaySingle", true);
    private static final @NotNull Tile rainfallDaySingle = FXTileUtils.rainfall("24h Rainfall", FXVar.TILE_WIDTH_SINGLE_VIEW, FXVar.TILE_HEIGHT_SINGLE_VIEW, "rainfallDaySingle", true);
    private static final @NotNull Tile windDaySingle = FXTileUtils.wind("24h Wind", FXVar.TILE_WIDTH_SINGLE_VIEW, FXVar.TILE_HEIGHT_SINGLE_VIEW, "windDaySingle", true);
    private static final @NotNull Tile cloudsDaySingle = FXTileUtils.clouds("24h Clouds", FXVar.TILE_WIDTH_SINGLE_VIEW, FXVar.TILE_HEIGHT_SINGLE_VIEW, "cloudsDaySingle", true);
    private static final @NotNull Tile humidityDaySingle = FXTileUtils.humidity("24h Humidity", FXVar.TILE_WIDTH_SINGLE_VIEW, FXVar.TILE_HEIGHT_SINGLE_VIEW, "humidityDaySingle", true);

    private static final @NotNull Tile tempDayAlone = FXTileUtils.temp("24h Temperature", FXVar.TILE_WIDTH_ALONE, FXVar.TILE_HEIGHT_ALONE, "tempDayAlone", false);
    private static final @NotNull Tile rainfallDayAlone = FXTileUtils.rainfall("24h Rainfall", FXVar.TILE_WIDTH_ALONE, FXVar.TILE_HEIGHT_ALONE, "rainfallDayAlone", false);
    private static final @NotNull Tile windDayAlone = FXTileUtils.wind("24h Wind", FXVar.TILE_WIDTH_ALONE, FXVar.TILE_HEIGHT_ALONE, "windDayAlone", false);
    private static final @NotNull Tile cloudsDayAlone = FXTileUtils.clouds("24h Clouds", FXVar.TILE_WIDTH_ALONE, FXVar.TILE_HEIGHT_ALONE, "cloudsDayAlone", false);
    private static final @NotNull Tile humidityDayAlone = FXTileUtils.humidity("24h Humidity", FXVar.TILE_WIDTH_ALONE, FXVar.TILE_HEIGHT_ALONE, "humidityDayAlone", false);

    private static final @NotNull Tile tempMonth = FXTileUtils.temp("31d Temperature", FXVar.TILE_WIDTH_TIME_VIEW, FXVar.TILE_HEIGHT_TIME_VIEW, "tempMonth", true);
    private static final @NotNull Tile rainfallMonth = FXTileUtils.rainfall("31d Rainfall", FXVar.TILE_WIDTH_TIME_VIEW, FXVar.TILE_HEIGHT_TIME_VIEW, "rainfallMonth", true);
    private static final @NotNull Tile windMonth = FXTileUtils.wind("31d Wind", FXVar.TILE_WIDTH_TIME_VIEW, FXVar.TILE_HEIGHT_TIME_VIEW, "windMonth", true);
    private static final @NotNull Tile cloudsMonth = FXTileUtils.clouds("31d Clouds", FXVar.TILE_WIDTH_TIME_VIEW, FXVar.TILE_HEIGHT_TIME_VIEW, "cloudsMonth", true);
    private static final @NotNull Tile humidityMonth = FXTileUtils.humidity("31d Humidity", FXVar.TILE_WIDTH_TIME_VIEW, FXVar.TILE_HEIGHT_TIME_VIEW, "humidityMonth", true);

    private static final @NotNull Tile tempMonthSingle = FXTileUtils.temp("31d Temperature", FXVar.TILE_WIDTH_SINGLE_VIEW, FXVar.TILE_HEIGHT_SINGLE_VIEW, "tempMonthSingle", true);
    private static final @NotNull Tile rainfallMonthSingle = FXTileUtils.rainfall("31d Rainfall", FXVar.TILE_WIDTH_SINGLE_VIEW, FXVar.TILE_HEIGHT_SINGLE_VIEW, "rainfallMonthSingle", true);
    private static final @NotNull Tile windMonthSingle = FXTileUtils.wind("31d Wind", FXVar.TILE_WIDTH_SINGLE_VIEW, FXVar.TILE_HEIGHT_SINGLE_VIEW, "windMonthSingle", true);
    private static final @NotNull Tile cloudsMonthSingle = FXTileUtils.clouds("31d Clouds", FXVar.TILE_WIDTH_SINGLE_VIEW, FXVar.TILE_HEIGHT_SINGLE_VIEW, "cloudsMonthSingle", true);
    private static final @NotNull Tile humidityMonthSingle = FXTileUtils.humidity("31d Humidity", FXVar.TILE_WIDTH_SINGLE_VIEW, FXVar.TILE_HEIGHT_SINGLE_VIEW, "humidityMonthSingle", true);

    private static final @NotNull Tile tempMonthAlone = FXTileUtils.temp("31d Temperature", FXVar.TILE_WIDTH_ALONE, FXVar.TILE_HEIGHT_ALONE, "tempMonthAlone", false);
    private static final @NotNull Tile rainfallMonthAlone = FXTileUtils.rainfall("31d Rainfall", FXVar.TILE_WIDTH_ALONE, FXVar.TILE_HEIGHT_ALONE, "rainfallMonthAlone", false);
    private static final @NotNull Tile windMonthAlone = FXTileUtils.wind("31d Wind", FXVar.TILE_WIDTH_ALONE, FXVar.TILE_HEIGHT_ALONE, "windMonthAlone", false);
    private static final @NotNull Tile cloudsMonthAlone = FXTileUtils.clouds("31d Clouds", FXVar.TILE_WIDTH_ALONE, FXVar.TILE_HEIGHT_ALONE, "cloudsMonthAlone", false);
    private static final @NotNull Tile humidityMonthAlone = FXTileUtils.humidity("31d Humidity", FXVar.TILE_WIDTH_ALONE, FXVar.TILE_HEIGHT_ALONE, "humidityMonthAlone", false);

    private static final @NotNull Tile tempYear = FXTileUtils.temp("365d Temperature", FXVar.TILE_WIDTH_TIME_VIEW, FXVar.TILE_HEIGHT_TIME_VIEW, "tempYear", true);
    private static final @NotNull Tile rainfallYear = FXTileUtils.rainfall("365d Rainfall", FXVar.TILE_WIDTH_TIME_VIEW, FXVar.TILE_HEIGHT_TIME_VIEW, "rainfallYear", true);
    private static final @NotNull Tile windYear = FXTileUtils.wind("365d Wind", FXVar.TILE_WIDTH_TIME_VIEW, FXVar.TILE_HEIGHT_TIME_VIEW, "windYear", true);
    private static final @NotNull Tile cloudsYear = FXTileUtils.clouds("365d Clouds", FXVar.TILE_WIDTH_TIME_VIEW, FXVar.TILE_HEIGHT_TIME_VIEW, "cloudsYear", true);
    private static final @NotNull Tile humidityYear = FXTileUtils.humidity("365d Humidity", FXVar.TILE_WIDTH_TIME_VIEW, FXVar.TILE_HEIGHT_TIME_VIEW, "humidityYear", true);

    private static final @NotNull Tile tempYearSingle = FXTileUtils.temp("365d Temperature", FXVar.TILE_WIDTH_SINGLE_VIEW, FXVar.TILE_HEIGHT_SINGLE_VIEW, "tempYearSingle", true);
    private static final @NotNull Tile rainfallYearSingle = FXTileUtils.rainfall("365d Rainfall", FXVar.TILE_WIDTH_SINGLE_VIEW, FXVar.TILE_HEIGHT_SINGLE_VIEW, "rainfallYearSingle", true);
    private static final @NotNull Tile windYearSingle = FXTileUtils.wind("365d Wind", FXVar.TILE_WIDTH_SINGLE_VIEW, FXVar.TILE_HEIGHT_SINGLE_VIEW, "windYearSingle", true);
    private static final @NotNull Tile cloudsYearSingle = FXTileUtils.clouds("365d Clouds", FXVar.TILE_WIDTH_SINGLE_VIEW, FXVar.TILE_HEIGHT_SINGLE_VIEW, "cloudsYearSingle", true);
    private static final @NotNull Tile humidityYearSingle = FXTileUtils.humidity("365d Humidity", FXVar.TILE_WIDTH_SINGLE_VIEW, FXVar.TILE_HEIGHT_SINGLE_VIEW, "humidityYearSingle", true);

    private static final @NotNull Tile tempYearAlone = FXTileUtils.temp("365d Temperature", FXVar.TILE_WIDTH_ALONE, FXVar.TILE_HEIGHT_ALONE, "tempYearAlone", false);
    private static final @NotNull Tile rainfallYearAlone = FXTileUtils.rainfall("365d Rainfall", FXVar.TILE_WIDTH_ALONE, FXVar.TILE_HEIGHT_ALONE, "rainfallYearAlone", false);
    private static final @NotNull Tile windYearAlone = FXTileUtils.wind("365d Wind", FXVar.TILE_WIDTH_ALONE, FXVar.TILE_HEIGHT_ALONE, "windYearAlone", false);
    private static final @NotNull Tile cloudsYearAlone = FXTileUtils.clouds("365d Clouds", FXVar.TILE_WIDTH_ALONE, FXVar.TILE_HEIGHT_ALONE, "cloudsYearAlone", false);
    private static final @NotNull Tile humidityYearAlone = FXTileUtils.humidity("365d Humidity", FXVar.TILE_WIDTH_ALONE, FXVar.TILE_HEIGHT_ALONE, "humidityYearAlone", false);

    private static @Nullable Button selectedMenuButton;

    public static @Nullable Button getSelectedMenuButton() {
        return selectedMenuButton;
    }

    public static void setSelectedMenuButton(@Nullable Button selectedMenuButton) {
        FXTiles.selectedMenuButton = selectedMenuButton;
    }

    static void init() {

    }

    public static @NotNull Tile getTempNowAlone() {
        return tempNowAlone;
    }

    public static @NotNull Tile getRainfallNowAlone() {
        return rainfallNowAlone;
    }

    public static @NotNull Tile getWindNowAlone() {
        return windNowAlone;
    }

    public static @NotNull Tile getCloudsNowAlone() {
        return cloudsNowAlone;
    }

    public static @NotNull Tile getHumidityNowAlone() {
        return humidityNowAlone;
    }

    public static @NotNull Tile getTempDayAlone() {
        return tempDayAlone;
    }

    public static @NotNull Tile getRainfallDayAlone() {
        return rainfallDayAlone;
    }

    public static @NotNull Tile getWindDayAlone() {
        return windDayAlone;
    }

    public static @NotNull Tile getCloudsDayAlone() {
        return cloudsDayAlone;
    }

    public static @NotNull Tile getHumidityDayAlone() {
        return humidityDayAlone;
    }

    public static @NotNull Tile getTempMonthAlone() {
        return tempMonthAlone;
    }

    public static @NotNull Tile getRainfallMonthAlone() {
        return rainfallMonthAlone;
    }

    public static @NotNull Tile getWindMonthAlone() {
        return windMonthAlone;
    }

    public static @NotNull Tile getCloudsMonthAlone() {
        return cloudsMonthAlone;
    }

    public static @NotNull Tile getHumidityMonthAlone() {
        return humidityMonthAlone;
    }

    public static @NotNull Tile getTempYearAlone() {
        return tempYearAlone;
    }

    public static @NotNull Tile getRainfallYearAlone() {
        return rainfallYearAlone;
    }

    public static @NotNull Tile getWindYearAlone() {
        return windYearAlone;
    }

    public static @NotNull Tile getCloudsYearAlone() {
        return cloudsYearAlone;
    }

    public static @NotNull Tile getHumidityYearAlone() {
        return humidityYearAlone;
    }

    public static @NotNull Tile getTempNow() {
        return tempNow;
    }

    public static @NotNull Tile getRainfallNow() {
        return rainfallNow;
    }

    public static @NotNull Tile getWindNow() {
        return windNow;
    }

    public static @NotNull Tile getCloudsNow() {
        return cloudsNow;
    }

    public static @NotNull Tile getHumidityNow() {
        return humidityNow;
    }

    public static @NotNull Tile getTempDay() {
        return tempDay;
    }

    public static @NotNull Tile getRainfallDay() {
        return rainfallDay;
    }

    public static @NotNull Tile getWindDay() {
        return windDay;
    }

    public static @NotNull Tile getCloudsDay() {
        return cloudsDay;
    }

    public static @NotNull Tile getHumidityDay() {
        return humidityDay;
    }

    public static @NotNull Tile getTempMonth() {
        return tempMonth;
    }

    public static @NotNull Tile getRainfallMonth() {
        return rainfallMonth;
    }

    public static @NotNull Tile getWindMonth() {
        return windMonth;
    }

    public static @NotNull Tile getCloudsMonth() {
        return cloudsMonth;
    }

    public static @NotNull Tile getHumidityMonth() {
        return humidityMonth;
    }

    public static @NotNull Tile getHumidityAverage() {
        return humidityAverage;
    }

    public static @NotNull Tile getTempYear() {
        return tempYear;
    }

    public static @NotNull Tile getRainfallYear() {
        return rainfallYear;
    }

    public static @NotNull Tile getWindYear() {
        return windYear;
    }

    public static @NotNull Tile getCloudsYear() {
        return cloudsYear;
    }

    public static @NotNull Tile getHumidityYear() {
        return humidityYear;
    }

    public static @NotNull Tile getMenuOverview() {
        return menuOverview;
    }

    public static @NotNull Tile getMenuCurrent() {
        return menuCurrent;
    }

    public static @NotNull Tile getMenuDay() {
        return menuDay;
    }

    public static @NotNull Tile getMenuMonth() {
        return menuMonth;
    }

    public static @NotNull Tile getMenuYear() {
        return menuYear;
    }

    public static @NotNull Tile getMenuTemp() {
        return menuTemp;
    }

    public static @NotNull Tile getMenuRainfall() {
        return menuRainfall;
    }

    public static @NotNull Tile getMenuWind() {
        return menuWind;
    }

    public static @NotNull Tile getMenuClouds() {
        return menuClouds;
    }

    public static @NotNull Tile getMenuHumidity() {
        return menuHumidity;
    }

    public static @NotNull Tile getTimer() {
        return timer;
    }

    public static @NotNull Tile getClock() {
        return clock;
    }

    public static @NotNull Tile getDate() {
        return date;
    }

    public static @NotNull Tile getCountdown() {
        return countdown;
    }

    public static @NotNull Tile getRefreshSwitch() {
        return refreshSwitch;
    }

    public static @NotNull Tile getRainfallCurrent() {
        return rainfallCurrent;
    }

    public static @NotNull Tile getRainfall24() {
        return rainfall24;
    }

    public static @NotNull Tile getRainfall31() {
        return rainfall31;
    }

    public static @NotNull Tile getRainfall365() {
        return rainfall365;
    }

    public static @NotNull Tile getWindCurrent() {
        return windCurrent;
    }

    public static @NotNull Tile getWind24() {
        return wind24;
    }

    public static @NotNull Tile getWind31() {
        return wind31;
    }

    public static @NotNull Tile getWind365() {
        return wind365;
    }

    public static @NotNull Tile getCloudsCurrent() {
        return cloudsCurrent;
    }

    public static @NotNull Tile getClouds24() {
        return clouds24;
    }

    public static @NotNull Tile getClouds31() {
        return clouds31;
    }

    public static @NotNull Tile getClouds365() {
        return clouds365;
    }

    public static @NotNull Tile getHumidityCurrent() {
        return humidityCurrent;
    }

    public static @NotNull Tile getHumidity24() {
        return humidity24;
    }

    public static @NotNull Tile getHumidity31() {
        return humidity31;
    }

    public static @NotNull Tile getHumidity365() {
        return humidity365;
    }

    public static @NotNull Tile getTempAverage() {
        return tempAverage;
    }

    public static @NotNull Tile getRainfallAverage() {
        return rainfallAverage;
    }

    public static @NotNull Tile getWindAverage() {
        return windAverage;
    }

    public static @NotNull Tile getCloudsAverage() {
        return cloudsAverage;
    }

    public static @NotNull Tile getTempCurrent() {
        return tempCurrent;
    }

    public static @NotNull Tile getTemp24() {
        return temp24;
    }

    public static @NotNull Tile getTemp31() {
        return temp31;
    }

    public static @NotNull Tile getTemp365() {
        return temp365;
    }

    public static @NotNull Tile getWeatherDB() {
        return weatherDB;
    }

    public static @NotNull Tile getWelcomeTile() {
        return welcomeTile;
    }

    public static @NotNull Tile getTempNowSingle() {
        return tempNowSingle;
    }

    public static @NotNull Tile getRainfallNowSingle() {
        return rainfallNowSingle;
    }

    public static @NotNull Tile getWindNowSingle() {
        return windNowSingle;
    }

    public static @NotNull Tile getCloudsNowSingle() {
        return cloudsNowSingle;
    }

    public static @NotNull Tile getHumidityNowSingle() {
        return humidityNowSingle;
    }

    public static @NotNull Tile getTempDaySingle() {
        return tempDaySingle;
    }

    public static @NotNull Tile getRainfallDaySingle() {
        return rainfallDaySingle;
    }

    public static @NotNull Tile getWindDaySingle() {
        return windDaySingle;
    }

    public static @NotNull Tile getCloudsDaySingle() {
        return cloudsDaySingle;
    }

    public static @NotNull Tile getHumidityDaySingle() {
        return humidityDaySingle;
    }

    public static @NotNull Tile getTempMonthSingle() {
        return tempMonthSingle;
    }

    public static @NotNull Tile getRainfallMonthSingle() {
        return rainfallMonthSingle;
    }

    public static @NotNull Tile getWindMonthSingle() {
        return windMonthSingle;
    }

    public static @NotNull Tile getCloudsMonthSingle() {
        return cloudsMonthSingle;
    }

    public static @NotNull Tile getHumidityMonthSingle() {
        return humidityMonthSingle;
    }

    public static @NotNull Tile getTempYearSingle() {
        return tempYearSingle;
    }

    public static @NotNull Tile getRainfallYearSingle() {
        return rainfallYearSingle;
    }

    public static @NotNull Tile getWindYearSingle() {
        return windYearSingle;
    }

    public static @NotNull Tile getCloudsYearSingle() {
        return cloudsYearSingle;
    }

    public static @NotNull Tile getHumidityYearSingle() {
        return humidityYearSingle;
    }

    public static @NotNull Tile getMenuAlone() {
        return menuAlone;
    }
}
