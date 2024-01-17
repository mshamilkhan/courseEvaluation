package databaseLayer;
import java.sql.*;
public class majorDelDb {
    public static void MDDb(String major){
        String majorParams = dbController.getMajorDelParamDb(major);
        System.out.println("major Edit Db: --> " + majorParams);
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
            String insertQuery = "DELETE FROM major_instrument WHERE major_name = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, majorParams); 
                
                 

                int rowsAffected = preparedStatement.executeUpdate();

                System.out.println("Rows affected: " + rowsAffected);
            }
            System.out.println("Database Connected");
           
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
