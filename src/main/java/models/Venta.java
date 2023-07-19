/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author JOHAN VARON
 */
public class Venta {
    private int Codigo;
    private String Descripcion;
    private int Cantidad;
    private double V_Unitario;
    private double IVA;
    private double V_Total;
    
    public Venta()
    {
        
    }

    public Venta(int Codigo, String Descripcion, int Cantidad, double V_Unitario, double IVA, double V_Total) {
        this.Codigo = Codigo;
        this.Descripcion = Descripcion;
        this.Cantidad = Cantidad;
        this.V_Unitario = V_Unitario;
        this.IVA = IVA;
        this.V_Total = V_Total;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public double getV_Unitario() {
        return V_Unitario;
    }

    public void setV_Unitario(double V_Unitario) {
        this.V_Unitario = V_Unitario;
    }

    public double getIVA() {
        return IVA;
    }

    public void setIVA(double IVA) {
        this.IVA = IVA;
    }

    public double getV_Total() {
        return V_Total;
    }

    public void setV_Total(double V_Total) {
        this.V_Total = V_Total;
    }   
}
