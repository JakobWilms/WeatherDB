# WeatherDB

[Java](https://www.java.com/) - Program to read & write Weather Data to a MySQL-Database and view it through a modern Dashboard-Like GUI.

## INSTALLATION

### DEPENDENCIES
Run the following command to install all required dependencies:
```shell
sudo apt install openjdk-17-jdk mysql-server mysql-client --install-suggests --install-recommends -y
```

### MYSQL
Setup [MySQL](https://www.mysql.com/) using the following command:
```shell
sudo mysql_secure_installation
```
Change the root password, then answer everything with 'y'.

### INSTALL
[Download](https://raw.githubusercontent.com/JakobWilms/WeatherDB/master/install)
the [INSTALLATION FILE](https://github.com/JakobWilms/WeatherDB/blob/master/install)  
Make it executable:
```shell
sudo chmod +x path/to/downloaded/file
```
Run it:
```shell
./path/to/downloaded/file
```

## USAGE
Run the program with the following command:
```shell
weatherdb
```

### SYNTAX
weatherdb [OPTION]...
### OPTIONS
<pre>
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
</pre>
### DEFAULT EXECUTION
<pre>
weatherdb --username username --password password --host localhost --port 3306 --database weatherDB
</pre>
### EXAMPLE EXECUTIONS
<pre>
WeatherDB-$VERSION.jar --username myCoolUsername -p securePassword -P 1234 -m --gui
</pre>
-> *Use custom username & password & port, measure data & start gui*
                    
### EXIT STATUS
<pre>
0   if  OK,
1   if  MINOR PROBLEMS,
2   if  SERIOUS TROUBLE
</pre>
                    
### GITHUB
[Repository](https://github.com/JakobWilms/WeatherDB)  
[Open Issue](https://github.com/JakobWilms/WeatherDB/issues)  
[ReadMe](https://github.com/JakobWilms/WeatherDB/blob/master/README.md)  
[Wiki](https://github.com/JakobWilms/WeatherDB/wiki)