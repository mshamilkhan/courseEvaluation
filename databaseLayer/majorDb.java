package databaseLayer;

import java.sql.*;

public class majorDb {
     public static void majorDB(String majorNameText, String majorWeightText, String courseCode) {
        String[] majorParams = dbController.getMajorParamDb(majorNameText, majorWeightText, courseCode);

        // Call the getMinorParamDb method and get the result

        // Access the minorNameText from the result

        // Print the minorNameText
        System.out.println("minorDb: --> " + majorParams[0]);

        // JDBC URL for MySQL - ensure to replace 'your_database_name' with your
        // database name
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
            String insertQuery = "INSERT INTO major_instrument (major_name, major_weight, course_code) VALUES (?, ?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, majorParams[0]); 
                preparedStatement.setString(2, majorParams[1]); 
                preparedStatement.setString(3, majorParams[2]); 

                int rowsAffected = preparedStatement.executeUpdate();

                System.out.println("Rows affected: " + rowsAffected);
            }

            // System.out.println(resultSet);
            System.out.println("Database Connected");
            // // Iterating through the result set
            // while (resultSet.next()) {
            // // Retrieve data by column name
            // String userName = resultSet.getString("username");
            // // String Password = resultSet.getString("password");
            // // ... retrieve other columns similarly
            // // Process the retrieved data (Here, simply printing)
            // System.out.println("Username: " + userName );
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
