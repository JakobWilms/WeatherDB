package com.github.jakobwilms.weatherdb;

import com.github.jakobwilms.weatherdb.ut.Utils;
import org.jetbrains.annotations.NotNull;

public class Arguments {

    private final String username, password, host, database, port;
    private final boolean gui, measure, server;


    public Arguments(String @NotNull [] args) {
        String username = "user", password = "password", host = "localhost", database = "weatherDB", port = "3306";
        boolean gui = false, measure = false, server = false;


        for (int i = 0; i < args.length; i++) {
            boolean b = true;
            switch (args[i]) {
                case "-u", "--username" -> username = args[i + 1];
                case "-p", "--password" -> password = args[i + 1];
                case "-h", "--host" -> host = args[i + 1];
                case "-P", "--port" -> port = args[i + 1];
                case "-d", "--database" -> database = args[i + 1];
                case "-g", "--gui" -> gui = true;
                case "-m", "--measure" -> measure = true;
                case "-s", "--server" -> server = true;
                case "-H", "--help" -> {
                    help();
                    b = false;
                }
                default -> {
                    Utils.print("Unknown Argument: " + args[i]);
                    System.out.println("To show help, execute WeatherDB-$VERSION.jar --help");
                    b = false;
                }
            }
            if (b) i++;
        }

        this.username = username;
        this.password = password;
        this.host = host;
        this.database = database;
        this.gui = gui;
        this.port = port;
        this.server = server;
        this.measure = measure;
    }

    private void help() {
        System.out.println("""
                    Usage: WeatherDB-$VERSION.jar [OPTION]...
                    Start the WeatherDB Program.
                    
                    OPTION              DEFAULT         TYPE        DESCRIPTION
                    -u, --username      username        String      The username to use to access MySql-Database
                    -p, --password      password        String      The password to use to access MySql-Database
                    -h, --host          localhost       String      The hostname to use to connect MySql-Database
                    -P, --port          3306            String      The port to use to connect to MySql-Database
                    -d, --database      weatherDB       String      The database name to use to read / write data
                    -g, --gui           false           n.a.        Whether the GUI should be started
                    -m, --measure       false           n.a.        Whether data should be measured
                    -s, --server        false           n.a.        Whether this device is the server for the database
                    -H, --help          false           n.a.        Whether this message should be shown
                    
                    DEFAULT EXECUTION:
                    WeatherDB-$VERSION.jar --username username --password password --host localhost --port 3306 --database weatherDB
                    
                    EXAMPLE EXECUTIONS:
                    WeatherDB-$VERSION.jar --username myCoolUsername -p securePassword -P 1234 -m --gui
                    -> Use custom username & password & port, measure data & start gui
                    
                    EXIT STATUS:
                    0   if  OK,
                    1   if  minor problems,
                    2   if  serious trouble
                    
                    GitHub-Repository:
                """);
        System.out.println(0);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getHost() {
        return host;
    }

    public String getDatabase() {
        return database;
    }

    public boolean isGui() {
        return gui;
    }

    public boolean isMeasure() {
        return measure;
    }

    public String getPort() {
        return port;
    }

    public boolean isServer() {
        return server;
    }
}
