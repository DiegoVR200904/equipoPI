package models;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ghostpatron
 */

public class DB_Connection {
    /*private static final String JDBC_URL = "jdbc:mysql://sql5.freesqldatabase.com:3306/sql5687497?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private static final String USER = "sql5687497";
    private static final String PASSWORD = "sS5SNl9tCA";
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
    }*/
    
    private static final String JDBC_URL = "jdbc:ucanaccess://SB_DB.accdb";
    
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL);
    }
}
