package com.github.jakobwilms.weatherdb;

import org.jetbrains.annotations.NotNull;

public class Arguments {

    private String username, password, host, database, port;
    private boolean gui, measure, server;
    private boolean initialized;

    Arguments() {
        this(new String[0], true);
    }

    Arguments(String @org.jetbrains.annotations.NotNull [] args) {
        this(args, false);
    }

    private Arguments(String @NotNull [] args, boolean internal) {
        initialized = false;
        _parseArgs(args, internal);
    }

    public void parseArgs(String @org.jetbrains.annotations.NotNull [] args) {
        _parseArgs(args, false);
    }

    private void _parseArgs(String @NotNull [] args, boolean internal) {
        if (args.length == 0) {
            if (!internal) {
                this.initialized = true;
            }
            return;
        }
        if (initialized)
            throw new IllegalStateException("Arguments have been passed already!");

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
                    com.github.jakobwilms.weatherdb.ut.Utils.print("Unknown Argument: " + args[i]);
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

        this.initialized = true;
    }

    private void help() {
        System.out.println("""
                    USAGE:
                    WeatherDB-$VERSION.jar [OPTION]...
                    
                    INFO:
                    Start the WeatherDB Program, custom options may be appended.
                    
                    OPTION              DEFAULT         TYPE        DESCRIPTION
                    -u, --username      username        String      The username to use to access MySql-Database.
                    -p, --password      password        String      The password to use to access MySql-Database.
                    -h, --host          localhost       String      The hostname to use to connect MySql-Database.
                    -P, --port          3306            String      The port to use to connect to MySql-Database.
                    -d, --database      weatherDB       String      The database name to use to read / write data.
                    -g, --gui           false           n.a.        Whether the GUI should be started.
                    -m, --measure       false           n.a.        Whether data should be measured.
                    -s, --server        false           n.a.        Whether this device is the server for the database.
                    -H, --help          false           n.a.        Whether this message should be shown.
                    
                    DEFAULT EXECUTION:
                    WeatherDB-$VERSION.jar --username username --password password --host localhost --port 3306 --database weatherDB
                    
                    EXAMPLE EXECUTIONS:
                    WeatherDB-$VERSION.jar --username myCoolUsername -p securePassword -P 1234 -m --gui
                    -> Use custom username & password & port, measure data & start gui
                    
                    EXIT STATUS:
                    0   if  OK,
                    1   if  minor problems,
                    2   if  serious trouble
                    
                    GITHUB:
                    Repository:     https://github.com/JakobWilms/WeatherDB
                    Open Issue:     https://github.com/JakobWilms/WeatherDB/issues
                    ReadMe:         https://github.com/JakobWilms/WeatherDB/blob/master/README.md
                    Wiki:           https://github.com/JakobWilms/WeatherDB/wiki
                """);
        System.exit(0);
    }

    private void checkInitialized() {
        if (!isInitialized())
            throw new IllegalStateException("Not initialized yet!");
    }

    public String getUsername() {
        checkInitialized();
        return username;
    }

    public String getPassword() {
        checkInitialized();
        return password;
    }

    public String getHost() {
        checkInitialized();
        return host;
    }

    public String getDatabase() {
        checkInitialized();
        return database;
    }

    public boolean isGui() {
        checkInitialized();
        return gui;
    }

    public boolean isMeasure() {
        checkInitialized();
        return measure;
    }

    public String getPort() {
        checkInitialized();
        return port;
    }

    public boolean isServer() {
        checkInitialized();
        return server;
    }

    public boolean isInitialized() {
        return initialized;
    }
}
