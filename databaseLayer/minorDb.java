package databaseLayer;
import java.sql.*;


public class minorDb {
    public static void minorDB(String minorNameText, String minorMarksText, String minorWeightText) {
        String[] minorParams = dbController.getMinorParamDb(minorNameText, minorMarksText, minorWeightText);

                // Call the getMinorParamDb method and get the result
       

        // Access the minorNameText from the result

        // Print the minorNameText
        System.out.println("minorDb: --> " + minorParams[0]);

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
            resultSet = statement.executeQuery("INSERT 2 TO minor_instrument");
            System.out.println(resultSet);
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





// // import domainLayer.minorValidation;

// public class minorDb {
//     public static void minorDB(String minorNameText, String minorMarksText,String minorWeightText) {
//         // Call the getMinorParamDb method and get the result
//         String[] minorParams = dbController.getMinorParamDb(minorNameText,minorMarksText, minorWeightText);

//         // Access the minorNameText from the result

//         // Print the minorNameText
//         System.out.println("minorDb: --> " + minorParams[0]);

//         // JDBC URL for MySQL - ensure to replace 'your_database_name' with your database name
//         String jdbcUrl = "jdbc:mysql://localhost:3306/courseEvaluationdb";
//         String username = "root";
//         String password = "QwertyQwerty11,";
//         Connection connection = null;
//          Statement statement = null;
//         ResultSet resultSet = null;
//         try {
            
//             // Establishing the connection
//             connection = DriverManager.getConnection(jdbcUrl, username, password);

//             // Creating a statement
//             statement = connection.createStatement();

//             // Executing a simple query
//             resultSet = statement.executeQuery("SELECT username FROM CE");
//             System.out.println("Database Connected");
//             // // Iterating through the result set
//             // while (resultSet.next()) {
//             //     // Retrieve data by column name
//             //     String userName = resultSet.getString("username");
//             //     // String Password = resultSet.getString("password");
//             //     // ... retrieve other columns similarly

//             //     // Process the retrieved data (Here, simply printing)
//             //     System.out.println("Username: " + userName );
//             // }
//         } catch (SQLException e) {
//             e.printStackTrace();
//         } finally {
//             // Closing the resources in a finally block to ensure they're always closed
//             try {
//                 if (resultSet != null) {
//                     resultSet.close();
//                 }
//                 if (statement != null) {
//                     statement.close();
//                 }
//                 if (connection != null) {
//                     connection.close();
//                 }
//             } catch (SQLException e) {
//                 e.printStackTrace();
//             }
//         }
//     }
//     }

