package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection {

    private static final String USERNAME = "dbuser";
    private static final String PASSWORD = "dbpassword";
    private static final String CONN = "jdbc:mysql://localhost/login";
    private static final String SQCONN = "jdbc:sqlite:/Users/andreasgut/Documents/Uni Bern/Informatik/YatziGUIFX3.0/sql/database.db";

    public static Connection getConnection()  throws SQLException {

        try{
            Class.forName("org.sqlite.JDBC");
            System.out.println("get Connection works");
            return DriverManager.getConnection(SQCONN);

        }
        catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return null;

    }
}
