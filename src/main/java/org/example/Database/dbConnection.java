package org.example.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection {
    public static Connection connectToDatabase(){
        dbConnectionDetails dbConnectionDetails = new dbConnectionDetails();
        String url = dbConnectionDetails.getUrl();
        String user = dbConnectionDetails.getUser();
        String password = dbConnectionDetails.getPassword();

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("connected");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
