package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) {
        //JDBC
        // Java database connectivity/connector
        //Steps to complete in order to do this process

        // 1 - import the package (java.sql package)
        // 2 - load and register the driver (dependent upon the SQL/RDBMS you are using MySQL/PGSQL/etc)
        // 3 - establish the connection (instantiate connection interface)
        // 4 - create the statement (normal, prepared, or callable statement)
        // 5 - process/execute the query
        // 6 - process results of the query
        // 7 - close the connection

        String url = "jdbc:postgresql://localhost:5432/Datasets"; // Replace 'testdb' with your database name
        String user = "postgres"; // Replace with your username
        String password = "temp1999"; // Replace with your password

        // SQL query example
        String query = "SELECT * FROM annual_energy_by_source"; // Replace with your table name

        // Connection and query execution
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            // Process the result set
            while (rs.next()) {
                System.out.println("Column1: " + rs.getString("entity")); // Replace with your column names
                System.out.println("Column2: " + rs.getInt("year"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}