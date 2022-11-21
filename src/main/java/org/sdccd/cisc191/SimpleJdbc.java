package org.sdccd.cisc191;

import java.sql.*;

public class SimpleJdbc {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
     // Load the JDBC driver
     Class.forName("com.mysql.cj.jdbc.Driver");
      System.out.println("Driver loaded");

      // Connect to a database
      Connection connection = DriverManager.getConnection
        ("jdbc:mysql://localhost/testdb", "test", "Pa$$word");
      System.out.println("Database connected");

      // Create a statement
      Statement statement = connection.createStatement();

      // Execute a statement
      ResultSet resultSet = statement.executeQuery
        ("select * from Course;");

      // Iterate through the result and print info
      while (resultSet.next())
        System.out.println(resultSet.getString(1) + "\t" +
          resultSet.getString(2) + "\t" + resultSet.getString(3)
        + resultSet.getString(4) + "\t" + resultSet.getString(5));

      // Close the connection
      connection.close();
    }
  }