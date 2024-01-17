package databaseLayer;
import java.sql.*;
public class minorEditDb {
    public static void MinEDb(String majorWeight, String majSelected){
        String[] majorParams = dbController.getMajorEditParamDb(majorWeight, majSelected );
        System.out.println("major Edit Db: --> " + majorParams[0] + majorParams[1]);
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
            String insertQuery = "UPDATE minor_instrument SET minor_weight = ? WHERE major_name = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, majorParams[1]); 
                preparedStatement.setString(2, majorParams[0]); 
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
