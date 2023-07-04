package org.example;

import lombok.Getter;
import org.example.Database.dbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

@Getter
public class Users {
    HashMap<String, String> loginInfo = new HashMap<>();

    Users(){
        try {
            String query = "SELECT username, password FROM public.\"Users\"";
            Connection connection = dbConnection.connectToDatabase();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
                while (result.next()){
                    String username = result.getString("username");
                    String password = result.getString("password");
                    loginInfo.put(username, password);
                }
        } catch (SQLException e ) {
            throw new RuntimeException();
        }

    }



}
