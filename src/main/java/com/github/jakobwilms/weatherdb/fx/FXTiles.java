package com.github.jakobwilms.weatherdb.fx;

import eu.hansolo.tilesfx.Tile;
import javafx.scene.control.Button;

final class FXTiles {

    private static Tile timer, clock, date, countdown, refreshSwitch;
    private static Tile tempCurrent, temp24, temp31, temp365, tempAverage;
    private static Tile weatherDB, welcomeTile;
    private static Tile menuOverview, menuCurrent, menuDay, menuMonth, menuYear, menuTemp, menuRainfall, menuWind, menuClouds, menuHumidity;
    private static Tile rainfallCurrent, rainfall24, rainfall31, rainfall365, rainfallAverage;
    private static Tile windCurrent, wind24, wind31, wind365, windAverage;
    private static Tile cloudsCurrent, clouds24, clouds31, clouds365, cloudsAverage;
    private static Tile humidityCurrent, humidity24, humidity31, humidity365, humidityAverage;
    private static Tile tempNow, rainfallNow, windNow, cloudsNow, humidityNow;
    private static Tile tempDay, rainfallDay, windDay, cloudsDay, humidityDay;
    private static Tile tempMonth, rainfallMonth, windMonth, cloudsMonth, humidityMonth;
    private static Tile tempYear, rainfallYear, windYear, cloudsYear, humidityYear;

    private static Button selectedMenuButton;

    public static void init() {
        weatherDB = FXTileUtils.weatherDB();
        welcomeTile = FXTileUtils.welcome();

        menuOverview = FXTileUtils.menu("\uD83D\uDDB5 Overview", "overviewButton");
        menuCurrent = FXTileUtils.menu("\uD83D\uDDB5 Current", "currentButton");
        menuDay = FXTileUtils.menu("\uD83D\uDDB5 Last 24h", "dayButton");
        menuMonth = FXTileUtils.menu("\uD83D\uDDB5 Last 31d", "monthButton");
        menuYear = FXTileUtils.menu("\uD83D\uDDB5 Last 365d", "yearButton");
        menuTemp = FXTileUtils.menu("\uD83C\uDF21 Temperature", "tempButton");
        menuRainfall = FXTileUtils.menu("\uD83C\uDF27 Rainfall", "rainfallButton");
        menuWind = FXTileUtils.menu("\uD83D\uDCA8 Wind", "windButton");
        menuClouds = FXTileUtils.menu("\u26C5 Clouds", "cloudsButton");
        menuHumidity = FXTileUtils.menu("\uD83C\uDF0A Humidity", "humidityButton");

        timer = FXTileUtils.timer();
        clock = FXTileUtils.clock();
        date = FXTileUtils.date();
        countdown = FXTileUtils.countdown();
        refreshSwitch = FXTileUtils.refreshSwitch();

        tempCurrent = FXTileUtils.tempCurrent("Current Temperature", FXVar.TILE_WIDTH_OVERVIEW, FXVar.TILE_HEIGHT_OVERVIEW);
        temp24 = FXTileUtils.temp("24h Temperature", FXVar.TILE_WIDTH_OVERVIEW, FXVar.TILE_HEIGHT_OVERVIEW);
        temp31 = FXTileUtils.temp("31d Temperature", FXVar.TILE_WIDTH_OVERVIEW, FXVar.TILE_HEIGHT_OVERVIEW);
        temp365 = FXTileUtils.temp("365d Temperature", FXVar.TILE_WIDTH_OVERVIEW, FXVar.TILE_HEIGHT_OVERVIEW);
        tempAverage = FXTileUtils.tempCurrent("Average Lifetime Temperature", FXVar.TILE_WIDTH_OVERVIEW, FXVar.TILE_HEIGHT_OVERVIEW);

        windCurrent = FXTileUtils.windCurrent("Current Wind Speed", FXVar.TILE_WIDTH_OVERVIEW, FXVar.TILE_HEIGHT_OVERVIEW);
        wind24 = FXTileUtils.wind("24h Wind", FXVar.TILE_WIDTH_OVERVIEW, FXVar.TILE_HEIGHT_OVERVIEW);
        wind31 = FXTileUtils.wind("31d Wind", FXVar.TILE_WIDTH_OVERVIEW, FXVar.TILE_HEIGHT_OVERVIEW);
        wind365 = FXTileUtils.wind("365d Wind", FXVar.TILE_WIDTH_OVERVIEW, FXVar.TILE_HEIGHT_OVERVIEW);
        windAverage = FXTileUtils.windCurrent("Average Lifetime Wind Speed", FXVar.TILE_WIDTH_OVERVIEW, FXVar.TILE_HEIGHT_OVERVIEW);

        rainfallCurrent = FXTileUtils.rainfallCurrent("Current Rainfall", FXVar.TILE_WIDTH_OVERVIEW, FXVar.TILE_HEIGHT_OVERVIEW);
        rainfall24 = FXTileUtils.rainfall("24h Rainfall", FXVar.TILE_WIDTH_OVERVIEW, FXVar.TILE_HEIGHT_OVERVIEW);
        rainfall31 = FXTileUtils.rainfall("31d Rainfall", FXVar.TILE_WIDTH_OVERVIEW, FXVar.TILE_HEIGHT_OVERVIEW);
        rainfall365 = FXTileUtils.rainfall("365d Rainfall", FXVar.TILE_WIDTH_OVERVIEW, FXVar.TILE_HEIGHT_OVERVIEW);
        rainfallAverage = FXTileUtils.rainfallCurrent("Average Lifetime Rainfall", FXVar.TILE_WIDTH_OVERVIEW, FXVar.TILE_HEIGHT_OVERVIEW);

        cloudsCurrent = FXTileUtils.cloudsCurrent("Current Clouds", FXVar.TILE_WIDTH_OVERVIEW, FXVar.TILE_HEIGHT_OVERVIEW);
        clouds24 = FXTileUtils.clouds("24h Clouds", FXVar.TILE_WIDTH_OVERVIEW, FXVar.TILE_HEIGHT_OVERVIEW);
        clouds31 = FXTileUtils.clouds("31d Clouds", FXVar.TILE_WIDTH_OVERVIEW, FXVar.TILE_HEIGHT_OVERVIEW);
        clouds365 = FXTileUtils.clouds("365d Clouds", FXVar.TILE_WIDTH_OVERVIEW, FXVar.TILE_HEIGHT_OVERVIEW);
        cloudsAverage = FXTileUtils.cloudsCurrent("Average Lifetime Clouds", FXVar.TILE_WIDTH_OVERVIEW, FXVar.TILE_HEIGHT_OVERVIEW);

        humidityCurrent = FXTileUtils.humidityCurrent("Current Humidity", FXVar.TILE_WIDTH_OVERVIEW, FXVar.TILE_HEIGHT_OVERVIEW);
        humidity24 = FXTileUtils.humidity("24h Humidity", FXVar.TILE_WIDTH_OVERVIEW, FXVar.TILE_HEIGHT_OVERVIEW);
        humidity31 = FXTileUtils.humidity("31d Humidity", FXVar.TILE_WIDTH_OVERVIEW, FXVar.TILE_HEIGHT_OVERVIEW);
        humidity365 = FXTileUtils.humidity("365d Humidity", FXVar.TILE_WIDTH_OVERVIEW, FXVar.TILE_HEIGHT_OVERVIEW);
        humidityAverage = FXTileUtils.humidityCurrent("Average Lifetime Humidity", FXVar.TILE_WIDTH_OVERVIEW, FXVar.TILE_HEIGHT_OVERVIEW);

        tempNow = FXTileUtils.tempCurrent("Current Temperature", FXVar.TILE_WIDTH_SINGLE_VIEW, FXVar.TILE_HEIGHT_SINGLE_VIEW);
        rainfallNow = FXTileUtils.rainfallCurrent("Current Temperature", FXVar.TILE_WIDTH_SINGLE_VIEW, FXVar.TILE_HEIGHT_SINGLE_VIEW);
        windNow = FXTileUtils.windCurrent("Current Temperature", FXVar.TILE_WIDTH_SINGLE_VIEW, FXVar.TILE_HEIGHT_SINGLE_VIEW);
        cloudsNow = FXTileUtils.cloudsCurrent("Current Temperature", FXVar.TILE_WIDTH_SINGLE_VIEW, FXVar.TILE_HEIGHT_SINGLE_VIEW);
        humidityNow = FXTileUtils.humidityCurrent("Current Temperature", FXVar.TILE_WIDTH_SINGLE_VIEW, FXVar.TILE_HEIGHT_SINGLE_VIEW);

        tempDay = FXTileUtils.temp("24h Temperature", FXVar.TILE_WIDTH_SINGLE_VIEW, FXVar.TILE_HEIGHT_SINGLE_VIEW);
        rainfallDay = FXTileUtils.rainfall("24h Rainfall", FXVar.TILE_WIDTH_SINGLE_VIEW, FXVar.TILE_HEIGHT_SINGLE_VIEW);
        windDay = FXTileUtils.wind("24h Wind", FXVar.TILE_WIDTH_SINGLE_VIEW, FXVar.TILE_HEIGHT_SINGLE_VIEW);
        cloudsDay = FXTileUtils.clouds("24h Clouds", FXVar.TILE_WIDTH_SINGLE_VIEW, FXVar.TILE_HEIGHT_SINGLE_VIEW);
        humidityDay = FXTileUtils.humidity("24h Humidity", FXVar.TILE_WIDTH_SINGLE_VIEW, FXVar.TILE_HEIGHT_SINGLE_VIEW);

        tempMonth = FXTileUtils.temp("31d Temperature", FXVar.TILE_WIDTH_SINGLE_VIEW, FXVar.TILE_HEIGHT_SINGLE_VIEW);
        rainfallMonth = FXTileUtils.rainfall("31d Rainfall", FXVar.TILE_WIDTH_SINGLE_VIEW, FXVar.TILE_HEIGHT_SINGLE_VIEW);
        windMonth = FXTileUtils.wind("31d Wind", FXVar.TILE_WIDTH_SINGLE_VIEW, FXVar.TILE_HEIGHT_SINGLE_VIEW);
        cloudsMonth = FXTileUtils.clouds("31d Clouds", FXVar.TILE_WIDTH_SINGLE_VIEW, FXVar.TILE_HEIGHT_SINGLE_VIEW);
        humidityMonth = FXTileUtils.humidity("31d Humidity", FXVar.TILE_WIDTH_SINGLE_VIEW, FXVar.TILE_HEIGHT_SINGLE_VIEW);

        tempYear = FXTileUtils.temp("365d Temperature", FXVar.TILE_WIDTH_SINGLE_VIEW, FXVar.TILE_HEIGHT_SINGLE_VIEW);
        rainfallYear = FXTileUtils.rainfall("365d Rainfall", FXVar.TILE_WIDTH_SINGLE_VIEW, FXVar.TILE_HEIGHT_SINGLE_VIEW);
        windYear = FXTileUtils.wind("365d Wind", FXVar.TILE_WIDTH_SINGLE_VIEW, FXVar.TILE_HEIGHT_SINGLE_VIEW);
        cloudsYear = FXTileUtils.clouds("365d Clouds", FXVar.TILE_WIDTH_SINGLE_VIEW, FXVar.TILE_HEIGHT_SINGLE_VIEW);
        humidityYear = FXTileUtils.humidity("365d Humidity", FXVar.TILE_WIDTH_SINGLE_VIEW, FXVar.TILE_HEIGHT_SINGLE_VIEW);
    }

    public static Tile getTempNow() {
        return tempNow;
    }

    public static Tile getRainfallNow() {
        return rainfallNow;
    }

    public static Tile getWindNow() {
        return windNow;
    }

    public static Tile getCloudsNow() {
        return cloudsNow;
    }

    public static Tile getHumidityNow() {
        return humidityNow;
    }

    public static Tile getTempDay() {
        return tempDay;
    }

    public static Tile getRainfallDay() {
        return rainfallDay;
    }

    public static Tile getWindDay() {
        return windDay;
    }

    public static Tile getCloudsDay() {
        return cloudsDay;
    }

    public static Tile getHumidityDay() {
        return humidityDay;
    }

    public static Tile getTempMonth() {
        return tempMonth;
    }

    public static Tile getRainfallMonth() {
        return rainfallMonth;
    }

    public static Tile getWindMonth() {
        return windMonth;
    }

    public static Tile getCloudsMonth() {
        return cloudsMonth;
    }

    public static Tile getHumidityMonth() {
        return humidityMonth;
    }

    public static Tile getHumidityAverage() {
        return humidityAverage;
    }

    public static Tile getTempYear() {
        return tempYear;
    }

    public static Tile getRainfallYear() {
        return rainfallYear;
    }

    public static Tile getWindYear() {
        return windYear;
    }

    public static Tile getCloudsYear() {
        return cloudsYear;
    }

    public static Tile getHumidityYear() {
        return humidityYear;
    }

    public static Tile getMenuOverview() {
        return menuOverview;
    }

    public static Tile getMenuCurrent() {
        return menuCurrent;
    }

    public static Tile getMenuDay() {
        return menuDay;
    }

    public static Tile getMenuMonth() {
        return menuMonth;
    }

    public static Tile getMenuYear() {
        return menuYear;
    }

    public static Tile getMenuTemp() {
        return menuTemp;
    }

    public static Tile getMenuRainfall() {
        return menuRainfall;
    }

    public static Tile getMenuWind() {
        return menuWind;
    }

    public static Tile getMenuClouds() {
        return menuClouds;
    }

    public static Tile getMenuHumidity() {
        return menuHumidity;
    }

    public static Tile getTimer() {
        return timer;
    }

    public static Tile getClock() {
        return clock;
    }

    public static Tile getDate() {
        return date;
    }

    public static Tile getCountdown() {
        return countdown;
    }

    public static Tile getRefreshSwitch() {
        return refreshSwitch;
    }

    public static Tile getRainfallCurrent() {
        return rainfallCurrent;
    }

    public static Tile getRainfall24() {
        return rainfall24;
    }

    public static Tile getRainfall31() {
        return rainfall31;
    }

    public static Tile getRainfall365() {
        return rainfall365;
    }

    public static Tile getWindCurrent() {
        return windCurrent;
    }

    public static Tile getWind24() {
        return wind24;
    }

    public static Tile getWind31() {
        return wind31;
    }

    public static Tile getWind365() {
        return wind365;
    }

    public static Tile getCloudsCurrent() {
        return cloudsCurrent;
    }

    public static Tile getClouds24() {
        return clouds24;
    }

    public static Tile getClouds31() {
        return clouds31;
    }

    public static Tile getClouds365() {
        return clouds365;
    }

    public static Tile getHumidityCurrent() {
        return humidityCurrent;
    }

    public static Tile getHumidity24() {
        return humidity24;
    }

    public static Tile getHumidity31() {
        return humidity31;
    }

    public static Tile getHumidity365() {
        return humidity365;
    }

    public static Tile getTempAverage() {
        return tempAverage;
    }

    public static Tile getRainfallAverage() {
        return rainfallAverage;
    }

    public static Tile getWindAverage() {
        return windAverage;
    }

    public static Tile getCloudsAverage() {
        return cloudsAverage;
    }

    public static Tile getTempCurrent() {
        return tempCurrent;
    }

    public static Tile getTemp24() {
        return temp24;
    }

    public static Tile getTemp31() {
        return temp31;
    }

    public static Tile getTemp365() {
        return temp365;
    }

    public static Tile getWeatherDB() {
        return weatherDB;
    }

    public static Button getSelectedMenuButton() {
        return selectedMenuButton;
    }

    public static void setSelectedMenuButton(Button selectedMenuButton) {
        FXTiles.selectedMenuButton = selectedMenuButton;
    }

    public static Tile getWelcomeTile() {
        return welcomeTile;
    }
}
