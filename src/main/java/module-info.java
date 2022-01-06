module WeatherDB {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires eu.hansolo.tilesfx;
    requires org.jetbrains.annotations;
    requires java.desktop;
    requires java.sql;

    opens com.github.jakobwilms.weatherdb.fx to javafx.fxml;
    exports com.github.jakobwilms.weatherdb.fx;
}