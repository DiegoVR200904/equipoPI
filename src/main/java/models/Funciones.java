/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ghostpatron
 */
public class Funciones {
    private int currentPosition = -1;
    private ResultSet resultSet;
    
    public Funciones(int id_user) {
        try (Connection connection = DB_Connection.getConnection()){ //Conexion
            String query = "SELECT p.category, p.id_user FROM post AS p, contacts AS c, users AS u"
                    + "WHERE p.id_user = c.id_contact AND u.id_user = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)){
                statement.setInt(1, id_user);
                try(ResultSet resultSetaux = statement.executeQuery()){
                    // Mover al primer registro
                    if (resultSetaux.next()) {
                        currentPosition = 0;
                    }else{
                        System.out.println("No se encontraron las publicaciones");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean haySiguiente() {
        try {
            if (resultSet != null) {
                return resultSet.next();
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean hayAnterior() {
        try {
            if (resultSet != null) {
                return resultSet.previous(); // Método para mover al registro anterior
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean siguienteRegistro() {
        try {
            if (haySiguiente()) {
                resultSet.next();
                currentPosition++;
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean registroAnterior() {
        try {
            if (hayAnterior()) {
                resultSet.previous();
                currentPosition--;
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public ResultSet obtenerRegistroActual() {
        return resultSet;
    }
    
}
