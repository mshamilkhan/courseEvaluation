package databaseLayer;
import java.sql.*;

import domainLayer.minorValidation;

public class minorDb {
    public static void minorDb() {
         String[] minorParams = dbController.getMinorParamDb(null, null, null);
        // JDBC URL for MySQL - ensure to replace 'your_database_name' with your database name
        String jdbcUrl = "jdbc:mysql://localhost:3306/courseEvaluationdb";
        String username = "root";
        String password = "QwertyQwerty11,";
        Connection connection = null;
         Statement statement = null;
        ResultSet resultSet = null;
        try {
            
            // Establishing the connection
            connection = DriverManager.getConnection(jdbcUrl, username, password);

            // Creating a statement
            statement = connection.createStatement();

            // Executing a simple query
            resultSet = statement.executeQuery("SELECT username FROM CE");
            System.out.println("Database Connected");
            // // Iterating through the result set
            // while (resultSet.next()) {
            //     // Retrieve data by column name
            //     String userName = resultSet.getString("username");
            //     // String Password = resultSet.getString("password");
            //     // ... retrieve other columns similarly

            //     // Process the retrieved data (Here, simply printing)
            //     System.out.println("Username: " + userName );
            // }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Closing the resources in a finally block to ensure they're always closed
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
