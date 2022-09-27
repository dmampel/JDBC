/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda;

import java.util.Collection;
import tienda.Entidades.Producto;
import tienda.Servicios.ProductoServicio;

/**
 *
 * @author Delfina
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        ProductoServicio ps = new ProductoServicio();
//        Producto p = ps.crearProducto(14, "TECLADO HYPER X", 1564, 8);
//        ps.ingresarProducto(p);
//        ps.modificarProducto(p);
        
//        Producto p14 = ps.dao.buscarPorCodigo(14);
//        System.out.println(p14.getCodigo());
//        System.out.println(p14.getNombre());
//        ps.consulta1();
//        ps.consulta2();
//        ps.consulta3(120, 220);
////        ps.consulta4();
//ps.consulta5();

        ps.menu();

    }
    
}
