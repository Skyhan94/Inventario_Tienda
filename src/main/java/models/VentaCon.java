/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;
/**
 *
 * @author JOHAN VARON
 */
public class VentaCon {
    Conexion con = new Conexion();
    Connection cn;
    PreparedStatement st;
    ResultSet rs;
    int r;
    
    public int RegistrarVenta(Venta v)
    {
        String sql = "INSERT INTO Ventas(Codigo, Descripcion, Cantidad, V_Unitario, IVA, V_Total) values (?,?,?,?,?,?)";
        try {
            cn = con.getConexion();
            st = cn.prepareStatement(sql);
            st.setInt(1, v.getCodigo());
            st.setString(2, v.getDescripcion());
            st.setInt(3, v.getCantidad());
            st.setDouble(4, v.getV_Unitario());
            st.setDouble(5, v.getIVA());
            st.setDouble(6, v.getV_Total());
            st.execute();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return r;
    }
    
        public List ListarVentas()
    {
        List<Venta> ListaV = new ArrayList();
        String sql = "SELECT * FROM Ventas";
        try {
            cn = con.getConexion();
            st = cn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {                
                Venta v = new Venta();
                v.setCodigo(rs.getInt("Codigo"));
                v.setDescripcion(rs.getString("Descripcion"));
                v.setCantidad(rs.getInt("Cantidad"));
                v.setV_Unitario(rs.getDouble("V_Unitario"));
                v.setIVA(rs.getDouble("IVA"));
                v.setV_Total(rs.getDouble("V_Total"));
                ListaV.add(v);
            }
            
        } catch (SQLException e) 
        {
            System.out.println(e.toString());
        }
        return ListaV;
    }
}
