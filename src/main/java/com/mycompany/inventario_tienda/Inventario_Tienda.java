/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.inventario_tienda;

import java.sql.Connection;
import java.sql.SQLException;
import models.Conexion;

/**
 *
 * @author JOHAN VARON
 */
public class Inventario_Tienda {
    public static void main(String[] args) throws SQLException {

        /*/////////////////////////////////////////////////////////////////////////////////////////////////////////////
         * CONEXION BASE DE DATOS
         *////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        Connection conn = null;
        Conexion conx = new Conexion();
        conn = conx.getConexion();
        conx.ejecutarStatement("", conn);      
    }
}


