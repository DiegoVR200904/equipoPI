/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author ghostpatron
 */
public class ConexionLogin {
    public static boolean verificarCredenciales(String username, String password) {
        try (Connection connection = DB_Connection.getConnection()) { //conexion
            String query = "SELECT * FROM users WHERE email = ? AND password = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, username);
                statement.setString(2, password);
                
                try (ResultSet resultSet = statement.executeQuery()) {
                    return resultSet.next(); // Retorna true si las credenciales son válidas
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public static boolean insertarUsuario(String username, String lastname, String email, String birthday, String password, int pic_p) {
        try (Connection connection = DB_Connection.getConnection()) {
            String query = "INSERT INTO Users (first_name, last_name, email, password, birthdate, "
                    + "profile_image_id) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, username);
                statement.setString(2, lastname);
                statement.setString(3, email);
                statement.setString(4, password);
                statement.setString(5, birthday);
                statement.setInt(6, pic_p);
                //statement.setInt(7, pic_c);

                int filasAfectadas = statement.executeUpdate();
                return filasAfectadas > 0; // Retorna true si se insertó al menos una fila
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }  
    
}
