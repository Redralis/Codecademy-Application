package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    private final String url;
    private Connection con;

    public DatabaseConnection() {
        this.url = "jdbc:sqlserver://localhost;databaseName=Codecademy;integratedSecurity=true;";
        this.con = null;
    }

    public Connection connect() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            this.con = DriverManager.getConnection(url);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return this.con;
    }

}
