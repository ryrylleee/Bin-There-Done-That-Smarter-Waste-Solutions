package Utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/delosreyes_bintheredonethat"; 
    private static final String USER = "root";      
    private static final String PASSWORD = "vinsmokesanji_143"; 

    public static Connection connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("=========================================================================");
            System.out.println("\tDatabase connection established successfully.");
            System.out.println("=========================================================================");
            return connection;
        } catch (ClassNotFoundException e) {
            System.out.println("=========================================================================");
            System.err.println("JDBC Driver not found. Make sure to include the MySQL Connector JAR in the project.");
            System.out.println("=========================================================================");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("=========================================================================");
            System.err.println("Error connecting to the database. Please verify your credentials and database configuration.");
            System.out.println("=========================================================================");
            e.printStackTrace();
        }
        return null;
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("=========================================================================");
                System.out.println("\t\tDatabase connection closed successfully.");
                System.out.println("=========================================================================");
            } catch (SQLException e) {
                System.out.println("=========================================================================");
                System.err.println("\t\tError closing the database connection.");
                System.out.println("=========================================================================");
                e.printStackTrace();
            }
        }
    }
}
