import java.sql.*;
 
public class SQLDatabaseConnection {
    // Connect to your database.
    // Replace server name, username, and password with your credentials
    public static void main(String[] args) {
 
        String connectionString =
                "jdbc:sqlserver://SERVER_NAME.database.windows.net:1433;"
                        + "database=Local_570;"
                        + "user=sa;"
                        + "password=123;"
                        ;
 
        ResultSet resultSet = null;
 
 
        try (Connection connection = DriverManager.getConnection(connectionString);
             Statement statement = connection.createStatement();) {
            // Code here.
            System.out.println("Connected to Sql Server ! ");
 
            // Create and execute a SELECT SQL statement.
            String selectSql = "SELECT * FROM dp_News";
            resultSet = statement.executeQuery(selectSql);
 
            // Print results from select statement
            while (resultSet.next()) {
                System.out.println("⁄‰Ê«‰ Œ»—: " + resultSet.getString("Title"));
                System.out.println(resultSet.getString(2) + " " + resultSet.getString(6));
            }
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}