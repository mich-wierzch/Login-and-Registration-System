package org.example.Database;

import lombok.Data;

@Data
public class dbConnectionDetails {
    private final String url = "jdbc:postgresql://localhost:5432/Users";
    private final String user = "postgres";
    private final String password = "";
}
