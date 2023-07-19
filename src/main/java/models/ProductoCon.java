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
import javax.swing.JOptionPane;

/**
 *
 * @author JOHAN VARON
 */
public class ProductoCon {
    Conexion con = new Conexion();
    Connection cn;
    PreparedStatement st;
    ResultSet rs;
    
    public boolean RegistrarProducto(Producto p){
        String sql = "INSERT INTO Productos (Tipo, Codigo, Nombre, Precio, Cantidad, Minimo) values (?,?,?,?,?,?)";
        
        try {
            cn = con.getConexion();
            st = cn.prepareStatement(sql);
            st.setString(1, p.getTipo());
            st.setInt(2, p.getCodigo());
            st.setString(3, p.getNombre());
            st.setDouble(4, p.getValorUnitario());
            st.setInt(5, p.getCantidadBodega());
            st.setInt(6, p.getCantidadMinima());
            st.execute();
            return true;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        } finally{
            try {
                cn.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }   
    }
    
    public List ListarProductos()
    {
        List<Producto> ListaP = new ArrayList();
        String sql = "SELECT * FROM Productos";
        try {
            cn = con.getConexion();
            st = cn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {                
                Producto p = new Producto();
                p.setTipo(rs.getString("Tipo"));
                p.setCodigo(rs.getInt("Codigo"));
                p.setNombre(rs.getString("Nombre"));
                p.setValorUnitario(rs.getDouble("Precio"));
                p.setCantidadBodega(rs.getInt("Cantidad"));
                p.setCantidadMinima(rs.getInt("Minimo"));
                ListaP.add(p);
            }
            
        } catch (SQLException e) 
        {
            System.out.println(e.toString());
        }
        return ListaP;
    }
    
    public boolean EliminarProducto(int codigo)
    {
        String sql = "DELETE FROM Productos WHERE Codigo = ?";
        try {
            st = cn.prepareCall(sql);
            st.setInt(1, codigo);
            st.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }finally{
            try {
                cn.close();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
    }
    
    public Producto BuscarProductos(int Codigo)
    {
        Producto producto = new Producto();
        String sql = "SELECT * FROM Productos WHERE Codigo = ?";
        try {
            cn = con.getConexion();
            st = cn.prepareStatement(sql);
            st.setInt(1, Codigo);
            rs = st.executeQuery();
            if (rs.next()) {
                producto.setTipo(rs.getString("Tipo"));
                producto.setNombre(rs.getString("Nombre"));
                producto.setValorUnitario(rs.getDouble("Precio"));
                producto.setCantidadBodega(rs.getInt("Cantidad"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        
        return producto;
    }
    
    public boolean ActualizarStock(int cantidad, int codigo)
    {
        String sql = "UPDATE Productos SET Cantidad = ? WHERE Codigo = ?";
       
        try {
            cn = con.getConexion();
            st = cn.prepareStatement(sql);
            st.setInt(1, cantidad);
            st.setInt(2, codigo);
            st.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }finally{
            try {
                cn.close();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
    }
    
    
}      
    
