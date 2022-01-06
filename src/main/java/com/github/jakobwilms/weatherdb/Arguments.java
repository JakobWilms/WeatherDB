package com.github.jakobwilms.weatherdb;

import org.jetbrains.annotations.NotNull;

public class Arguments {

    private final String username, password, host, database;
    private final boolean gui, measure;


    public Arguments(String @NotNull [] args) {
        String username = "user", password = "password", host = "localhost", database = "weatherDB";
        boolean gui = false, measure = false;

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-u", "--username" -> username = args[i + 1];
                case "-p", "--password" -> password = args[i + 1];
                case "-h", "--host" -> host = args[i + 1];
                case "-d", "--database" -> database = args[i + 1];
                case "-g", "--gui" -> gui = Boolean.parseBoolean(args[i + 1]);
                case "-m", "--measure" -> measure = Boolean.parseBoolean(args[i + 1]);
            }
        }

        this.username = username;
        this.password = password;
        this.host = host;
        this.database = database;
        this.gui = gui;
        this.measure = measure;
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
}
