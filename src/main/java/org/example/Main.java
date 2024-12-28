package org.example;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //JDBC
        // Java database connectivity/connector
        //Steps to complete in order to do this process

        // 1 - import the package (java.sql package)
        // 2 - load and register the driver (dependent upon the SQL/RDBMS you are using MySQL/PGSQL/etc)
        // 3 - establish the connection (instantiate connection interface)
        // 4 - create the statement (normal, prepared, or callable statement)
        // 5 - process/execute the selectQuery
        // 6 - process results of the selectQuery
        // 7 - close the connection

        Scanner Scanner = new Scanner(System.in);
        String url = "jdbc:postgresql://localhost:5432/Datasets"; // Replace 'testdb' with your database name
        String user = "postgres"; // Replace with your username
        System.out.println("Enter password for PostgreSQL server");
        String password = Scanner.nextLine();

        // SQL selectQuery example
        String selectQuery = "SELECT * FROM annual_energy_by_source"; // Replace with your table name

        // Connection and selectQuery execution
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(selectQuery);
             ResultSet rs = pstmt.executeQuery()) {

            // Process the result set
            while (rs.next()) {
                System.out.println("Entity: " + rs.getString("entity") + " | Year: " + rs.getInt("year"));
            }
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


        // SQL insertQuery example
        String insertQuery = "INSERT into annual_total_generation (entity, code, year, total_generation__twh) VALUES (?,?,?,?)"; // Replace with your table name

        // Connection and selectQuery execution
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(insertQuery)){

            // Set values for the placeholders
            pstmt.setString(1, "Test"); // Set value for 'entity'
            pstmt.setString(2, "TST");  // Set value for 'code'
            pstmt.setInt(3, 2025);      // Set value for 'year'
            pstmt.setDouble(4, 11111);  // Set value for 'total_generation_twh'

            // Execute the insert statement
            int count = pstmt.executeUpdate();
            System.out.println(count + " rows affected");

            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //TIMESTAMP 1:00:07

    }
}