/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author JOHAN VARON
 */
public class Conexion {
    private final String usuario = "johan";
    private final String contrasenia = "root";
    private final String urlconexion = "jdbc:sqlserver://DESKTOP-LT8JBCT\\MSSQL:1433;databaseName=Tienda;encrypt=true;trustServerCertificate=true;";
    
    private Connection cconexion;
    Statement stm;
    ResultSet rs;
    
    public Connection getConexion() throws SQLException
    {
        try 
        {
            cconexion = DriverManager.getConnection(urlconexion, usuario, contrasenia);
            System.out.println("Conexion establecida");
            
        } catch (SQLException e) 
        {
            System.out.println("Error al conectarse a la base de datos: Error: " + e.toString());
        }
        return cconexion;
    }
    
    public void ejecutarStatement(String query, Connection cconexion)throws SQLException
    {
        try 
        {
            stm =  cconexion.createStatement();
            rs = stm.executeQuery(query);
        } catch (SQLException ex) {
        }finally{
            if (rs != null) try {rs.close();} catch (SQLException e){}
            if (stm != null) try {stm.close();} catch (SQLException e){}
            if (cconexion != null) try {cconexion.close();} catch (SQLException e){}
        }
    }
}
