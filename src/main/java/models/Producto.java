/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author JOHAN VARON
 */
public class Producto {
    /*//////////////////////////////////////
     * Constantes
     *//////////////////////////////////////

    /*
     * CONSTANTE PARA CALCULAR EL IVA DE LOS PRODUCTOS DE PAPELERIA
     */
    private static final double IVA_PAPEL = 0.16;

    /*
     * CONSTANTE PARA CALCULAR EL IVA DE LOS PRODUCTOS DE SUPERMERCADO
     */
    private static final double IVA_SUPER = 0.04;

    /*
     * CONSTANTE PARA CALCULAR EL IVA DE LOS PRODUCTOS DE DROGUERIA
     */
    private static final double IVA_DROGUE = 0.12;

    /*///////////////////////////////////////////////////////////
     * ATRIBUTOS
     *///////////////////////////////////////////////////////////

    /*
     * TIPO DE PRODUCTO
     */
    private String tipo;
    
    /*
     * CODIGO DE PRODUCTO
     */

    private int codigo;
    
    /*
     * NOMBRE DE PRODUCTO
     */
    private String nombre;

    /*
     * VALOR UNITARIO DE CADA PRODUCTO
     */
    private double valorUnitario;

    /*
     * CANTIDAD EN BODEGA DE CADA PRODUCTO
     */
    private int cantidadBodega;

    /*
     * CANTIDAD MINIMA EN BODEGA DE CADA PRODUCTO
     */
    private int cantidadMinima;

    /*
     * TOTAL DE PRODUCTOS VENDIDOS
     */
    private int totalProductosVendidos;

    /*//////////////////////////////////////////////////////////////
     * CONSTRUCTORES
     */////////////////////////////////////////////////////////////
    
    /*
     * PRODUCTO CON INFORMACION BASICA
     */
    public Producto (String tipo, int codigo, String nombre, double valorUnitario, int cantidadBodega, int cantidadMinima)
    {
        this.tipo = tipo;
        this.codigo = codigo;
        this.nombre = nombre;
        this.valorUnitario = valorUnitario;
        this.cantidadBodega = cantidadBodega;
        this.cantidadMinima = cantidadMinima;
    } 

    public Producto() {
        
    }

    /*/////////////////////////////////////////////////////////////
     * METODOS
     */////////////////////////////////////////////////////////////
    
    /*
     * RETORNA LA CANTIDAD EN BODEGA
     */
    public int getCantidadBodega() 
    {
        return cantidadBodega;
    }
    
    public void setCantidadBodega(int cantidadBodega)
    {
        this.cantidadBodega = cantidadBodega;
    }

    /*
     * RETORNA LA CANTIDAD MINIMA
     */
    public int getCantidadMinima()
    {
        return cantidadMinima;
    }
    
    public void setCantidadMinima(int cantidadMinima)
    {
        this.cantidadMinima = cantidadMinima;
    }

    /*
     * RETORNA LOS PRODUCTOS VENDIDOS
     */
    public String getTipo()
    {
        return tipo;
    }
    
    public void setTipo(String tipo)
    {
        this.tipo = tipo;
    }
    
    /*
     * RETORNA EL CODIGO DEL PRODUCTO
     */
    
    public int getCodigo()
    {
        return codigo;
    }
    
    public void setCodigo(int codigo)
    {
        this.codigo = codigo;
    }
    
    /*
     * RETORNA EL NOMBRE DEL PRODUCTO
     */
    public String getNombre()
    {
        return nombre;
    }
    
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    /*
     * RETORNA EL VALOR UNITARIO
     */
    public double getValorUnitario()
    {
        return valorUnitario;
    }
    
    public void setValorUnitario(double valorUnitario)
    {
        this.valorUnitario = valorUnitario;
    }

    /*
     * RETORNA LOS PRODUCTOS VENDIDOS
     */
    public int getProductosVendidos()
    {
        return totalProductosVendidos;
    }
    
    /*
     * METODO PARA LAS VENTAS
     */

    public int Vender(int cantidad)
    {
        if (cantidad <= cantidadBodega)
        {
            totalProductosVendidos = totalProductosVendidos + cantidad;
            cantidadBodega = cantidadBodega - cantidad;
        }
        else if(cantidad == 0)
        {
            System.out.println("Debe ingresar una cantidad mayor a 0");
        }
        else if(cantidad > cantidadBodega)
        {
            cantidad = cantidadBodega;
            totalProductosVendidos = totalProductosVendidos + cantidad;
            cantidadBodega = cantidadBodega - cantidad;
        }

        return cantidad;
    }

    /*
     * METODO PARA EL IVA
     */

    public double getIVA()
    {
        return switch (tipo) {
            case "PAPELERIA" -> IVA_PAPEL;
            case "SUPERMERCADO" -> IVA_SUPER;
            case "DROGUERIA" -> IVA_DROGUE;
            default -> 0;
        };
    }

    /*
     * METODO PAR CALCULAR EL PRECIO FINAL
     */

    public double calcularPrecioFinal()
    {
        return valorUnitario * (1 + getIVA());
    }

    /*
     * FUNCION PARA SABER SI ES NECESARIO HACER PEDIDO
     */

    public boolean esNecesarioHacerPedido()
    {
        boolean esNecesario = false;
        if (cantidadBodega <= cantidadMinima)
        {
            esNecesario = true;
        }

        return esNecesario;
    }

    /*
     * METODO PARA REALIZAR PEDIDO
     */

    public int hacerPedido(int cantidad)
    {
        cantidadBodega = cantidadBodega + cantidad;

        return cantidadBodega;
        
    }
    
    /*
     * METODO QUE ARROJA LA INFORMACION DEL PRODUCTO.
     */

    @Override
    public String toString()
    {
        return 
            "\nTipo: " + getTipo() + 
            "\nNombre: " + getNombre() + 
            "\nValor Unitario: " + getValorUnitario() + 
            "\nCantidad en Bodega: " + getCantidadBodega() + 
            "\nCantidad minima: " + getCantidadMinima() + 
            "\n-------------------------------------------------------------------\n";
    }

}

