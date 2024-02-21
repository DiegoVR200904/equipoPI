/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.DriverManager;

/**
 *
 * @author ghostpatron
 */
public class Connection_DB {
    Connection conectar = null;
    Statement sentencia = null;
    ResultSet resultado = null;
    
    public Connection_DB(){
        try{   
            String path = "jdbc:ucanaccess://" + ".\\SB_DB.accdb";
            String url = "jdbcucanacces://"+path;
            conectar = DriverManager.getConnection(url);
            sentencia = conectar.createStatement();
            System.out.println("Conectado");
            String query = "INSERT INTO Users VALUES('Luis','Nunez','elluis@cosa.com','28-10-2002','mamon','15')";
            sentencia.executeUpdate(query);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error al conectar la Base de Datos"+e);
            System.exit(0);
        }
    }
            
    
}
