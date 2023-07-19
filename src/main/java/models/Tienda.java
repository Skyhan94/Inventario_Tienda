/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author JOHAN VARON
 */
public class Tienda {
    /*//////////////////////////////////////////////
     * ATRIBUTOS
     *//////////////////////////////////////////////

    /*
     * PRIMER PRODUCTO QUE SE VA A COMERCIALIZAR
     */

    private final Producto p1;

    /*
     * SEGUNDO PRODUCTO QUE SE VA A COMERCIALIZAR
     */

    private final Producto p2;

    /*
     * TERCER PRODUCTO QUE SE VA A COMERCIALIZAR
     */

    private final Producto p3;

    /*
     * CUARTO PRODUCTO QUE SE VA A COMERCIALIZAR
     */

    private final Producto p4;

    /*
     * DINERO QUE SE ALMACENA EN CAJA POR LAS VENTAS
     */

    private double dineroEnCaja;

    /*
     * CANTIDAD DE PRODUCTOS VENDIDOS
     */

    private int cantidadVendidaTotal;

    /*
     * GANANCIAS SIN IVA
     */

    private double gananciasTotales;

    /*///////////////////////////////////////////////////////////////////////
     * CONSTRUCTORES
     *//////////////////////////////////////////////////////////////////////

    public Tienda(Producto p1P, Producto p2P, Producto p3P, Producto p4P)
    {
        p1 = p1P;
        p2 = p2P;
        p3 = p3P;
        p4 = p4P;
        dineroEnCaja = 0;
        cantidadVendidaTotal = 0;
        gananciasTotales = 0;
    }

    /*//////////////////////////////////////////////////////////////////////
     * METODOS
     */////////////////////////////////////////////////////////////////////
    
    /*
     * RETORNA PRODUCTO 1
     */

    public Producto getProducto1()
    {
        return p1;
    }

    /*
     * RETORNA PRODUCTO 2
     */

    public Producto getProducto2()
    {
        return p2;
    }

    /*
     * RETORNA PRODUCTO 3
     */

    public Producto getProducto3()
    {
        return p3;
    }

    /*
     * RETORNA PRODUCTO 4
     */

    public Producto getProducto4()
    {
        return p4;
    }

    /*
     * RETORNA EL DINERO EN CAJA
     */
    public double getDineroEnCaja()
    {
        return dineroEnCaja;
    }

    /*
     * RETORNA LAS GANANCIAS TOTALES SIN IVA
     */

    public double getGananciasTotales()
    {
        return gananciasTotales;
    }
    
    /*
     * RETORNA LA CANTIDAD TOTAL VENDIDA
     */
    public int getCantidadVendida()
    {
        return cantidadVendidaTotal;
    }

    /*
     * METODO PARA VENDER PRODUCTOS
     */

    public int venderProducto (String nombreProducto, int cantidad)
    {
        int cantidadVendida = 0;
        if(p1.getNombre().equals(nombreProducto))
        {
            cantidadVendida = p1.Vender(cantidad);
            dineroEnCaja += cantidadVendida * p1.calcularPrecioFinal();
            cantidadVendidaTotal += cantidadVendida;
            gananciasTotales += cantidadVendida * p1.getValorUnitario();
        }
        else if(p2.getNombre().equals(nombreProducto))
        {
            cantidadVendida = p2.Vender(cantidad);
            dineroEnCaja += cantidadVendida * p2.calcularPrecioFinal();
            cantidadVendidaTotal += cantidadVendida;
            gananciasTotales += cantidadVendida * p2.getValorUnitario();
        }
        else if(p3.getNombre().equals(nombreProducto))
        {
            cantidadVendida = p3.Vender(cantidad);
            dineroEnCaja += cantidadVendida * p3.calcularPrecioFinal();
            cantidadVendidaTotal += cantidadVendida;
            gananciasTotales += cantidadVendida * p3.getValorUnitario();
        }
        else if(p4.getNombre().equals(nombreProducto))
        {
            cantidadVendida = p4.Vender(cantidad);
            dineroEnCaja += cantidadVendida * p4.calcularPrecioFinal();
            cantidadVendidaTotal += cantidadVendida;
            gananciasTotales += cantidadVendida * p4.getValorUnitario();
        }

        return cantidadVendida;
    }

    /*
     * METODO PARA REALIZAR PEDIDO
     */

    public boolean realizarPedido(String nombreProducto, int cantidad)
    {
        boolean hizoPedido = false;
        if (p1.getNombre().equals(nombreProducto) && p1.esNecesarioHacerPedido())
        {
            p1.hacerPedido(cantidad);
            hizoPedido = true;
        }
        else if (p2.getNombre().equals(nombreProducto) && p2.esNecesarioHacerPedido())
        {
            p2.hacerPedido(cantidad);
            hizoPedido = true;
        }
        else if (p3.getNombre().equals(nombreProducto) && p3.esNecesarioHacerPedido())
        {
            p3.hacerPedido(cantidad);
            hizoPedido = true;
        }   
        else if (p4.getNombre().equals(nombreProducto) && p4.esNecesarioHacerPedido())
        {
            p4.hacerPedido(cantidad);
            hizoPedido = true;
        }

        return hizoPedido;
    }

    /*
     * METODO PARA CALCULAR EL PRODUCTO MAS VENDIDO
     */
    public Producto getProductoMasVendido()
    {
        System.out.println("\nPRODUCTO MAS VENDIDO\n-------------------------------------------------------------------");
        Producto productoMasVendido = p1;

            if(p1.getProductosVendidos()>=p2.getProductosVendidos())
            {
                if(p1.getProductosVendidos() >= p3.getProductosVendidos())
                {
                    if(p1.getProductosVendidos()>= p4.getProductosVendidos())
                    {
                        productoMasVendido = p1;
                    }

                    else
                    {
                        productoMasVendido = p4;
                    }
                }

                else if(p3.getProductosVendidos() >= p4.getProductosVendidos())
                {
                    productoMasVendido = p3;
                }

                else
                {
                    productoMasVendido = p4;
                }
            }
            else if (p2.getProductosVendidos() >= p3.getProductosVendidos())
            {
                if(p2.getProductosVendidos() >= p4.getProductosVendidos())
                {
                    productoMasVendido = p2;
                }

                else if(p3.getProductosVendidos()>= p4.getProductosVendidos())
                {
                    productoMasVendido = p3;
                }

                else
                {
                    productoMasVendido = p4;
                }
            }

            else
            {
                productoMasVendido = p4;
            }
            
        return productoMasVendido;
    }

    /*
     * METODO PARA CALCULAR EL PRODUCTO MENOS VENDIDO
     */

    public Producto getProductoMenosVendido()
    {
        System.out.println("\nPRODUCTO MENOS VENDIDO\n-------------------------------------------------------------------");
        Producto productoMenosVendido = p1;

            if(p1.getProductosVendidos() <= p2.getProductosVendidos())
            {
                if(p1.getProductosVendidos() <= p3.getProductosVendidos())
                {
                    if(p1.getProductosVendidos() <= p4.getProductosVendidos())
                    {
                        productoMenosVendido = p1;
                    }

                    else
                    {
                        productoMenosVendido = p4;
                    }
                }

                else if(p3.getProductosVendidos() <= p4.getProductosVendidos())
                {
                    productoMenosVendido = p3;
                }

                else
                {
                    productoMenosVendido = p4;
                }

            }
            else if (p2.getProductosVendidos() <= p3.getProductosVendidos())
            {
                if(p2.getProductosVendidos() <= p4.getProductosVendidos())
                {
                    productoMenosVendido = p2;
                }
            
                else if(p3.getProductosVendidos() <= p4.getProductosVendidos())
                {
                    productoMenosVendido = p3;
                }

                else
                {
                    productoMenosVendido = p4;
                }
            }

            else
            {
                productoMenosVendido = p4;
            }
            
        return productoMenosVendido ;
    }

    /*
     * METODO PARA MOSTRAR EL PROMEDIO DE LAS VENTAS
     */

    public double promedioVentas()
    {
        System.out.println("\nPROMEDIO DE VENTAS\n---------------------------------------------------");
        double promedio;

        promedio = cantidadVendidaTotal/4;

        return promedio;
    }
    
    /*
     * METODO PARA MOSTRAR PRECIO TOTAL DE CADA PRODUCTO
     */

    public void precioTotalProductos()
    {
        System.out.println(
            "PRECIO TOTAL PRODUCTOS\n--------------------------------" +
            "\nNombre: " + p1.getNombre() + "\nValor Total (c/u): " + p1.calcularPrecioFinal() + "\n--------------------------------" +
            "\nNombre: " + p2.getNombre() + "\nValor Total (c/u): " + p2.calcularPrecioFinal() + "\n--------------------------------" + 
            "\nNombre: " + p3.getNombre() + "\nValor Total (c/u): " + p3.calcularPrecioFinal() + "\n--------------------------------" + 
            "\nNombre: " + p4.getNombre() + "\nValor Total (c/u): " + p4.calcularPrecioFinal() + "\n--------------------------------");
    }

    public void estadoPedidos()
    {
        System.out.println(
            "\nPRODUCTOS QUE NECESITAN PEDIDO\n-----------------------------------------------------------" +
            "\nNombre: " + p1.getNombre() + "\nEs necesario hacer pedido: " + p1.esNecesarioHacerPedido() + "\n---------------------------------------------\n" +
            "\nNombre: " + p2.getNombre() + "\nEs necesario hacer pedido: " + p2.esNecesarioHacerPedido() + "\n---------------------------------------------\n" +
            "\nNombre: " + p3.getNombre() + "\nEs necesario hacer pedido: " + p3.esNecesarioHacerPedido() + "\n---------------------------------------------\n" +
            "\nNombre: " + p4.getNombre() + "\nEs necesario hacer pedido: " + p4.esNecesarioHacerPedido() + "\n---------------------------------------------\n" 
            );
    }
}




