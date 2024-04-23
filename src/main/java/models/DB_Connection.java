package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ghostpatron
 */

public class DB_Connection {
 
        private static String usuario ="ghost";
        private static String contrasena ="1234";
        private static String bd ="SocialSpookBook";
        private static String ip ="localhost";
        private static String puerto ="1433";
        
        /*private static String cadena="jdbc:sqlserver://"+ip+":"+puerto+"/"+bd;*/
        private static String cadena="jdbc:sqlserver://localhost:"+puerto+";"+"databaseName="+bd+";trustServerCertificate=true;";
        public Connection establecerconexion(){
           Connection conectar =null;
           try{
            conectar = DriverManager.getConnection(cadena, usuario, contrasena);
            // Connection successful
            System.out.println("Connected to the database.");
            // Perform database operations here
        } catch (SQLException e) {
            // Connection failed
            System.err.println("Failed to connect to the database.");
            e.printStackTrace();
        }
        return conectar;
    }
    
   public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(cadena,usuario,contrasena);
    }
}
