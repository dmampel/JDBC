/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.Persistencia;

import java.util.ArrayList;
import java.util.Collection;
import tienda.Entidades.Producto;

/**
 *
 * @author Delfina
 */
public final class ProductoDAO extends DAO {

    public void ingresarProducto(Producto p) throws Exception {

        try {
            if (p == null) {
                throw new Exception("El producto no puede ser nulo.");
            }
            String sql = "INSERT INTO producto (codigo, nombre, precio, codigo_fabricante) VALUES ( " + p.getCodigo() + ", '" + p.getNombre() + "', " + p.getPrecio() + ", " + p.getCodigoFabricante() + ")";
            manipularBase(sql);

        } catch (Exception e) {
            throw e;

        }
    }

    public void modificarProducto(int codigo) throws Exception {
        try {
            
            System.out.println("Indicá el atributo a modificar.");
            System.out.println("1- Nombre.");
            System.out.println("2- Precio.");
            System.out.println("(Ni código del producto ni el código del fabricante pueden ser modificados)");
            int respuesta = leer.nextInt();
            switch (respuesta) {
                case 1:
                    System.out.println("Indique el nuevo nombre.");
                    String nuevoNombre = leer.next();
                    String sql1 = "UPDATE producto SET nombre = '" + nuevoNombre + "' WHERE codigo = " +codigo;
                    manipularBase(sql1);
                    break;
                case 2:
                    System.out.println("Indique el nuevo precio.");
                    double nuevoPrecio = leer.nextDouble();
                    String sql2 = "UPDATE producto SET precio = " + nuevoPrecio + "WHERE codigo = " +codigo;
                    manipularBase(sql2);
                    break;
            }

        } catch (Exception e) {
            throw e;
        }

    }

    public void eliminarProducto(Producto p) throws Exception {
        try {
            if (p == null) {
                throw new Exception("El producto no puede ser nulo.");
            }
            String sql = "DELETE FROM producto WHERE codigo = '" + p.getCodigo() + "'";
            manipularBase(sql);
        } catch (Exception e) {
            throw e;
        }
    }

    public Producto buscarPorCodigo(int codigo) throws Exception {

        try {
            String sql = "SELECT * FROM producto WHERE codigo = " + codigo;
            consultarBase(sql);

            Producto p = null;

            while (resultado.next()) {
                p = new Producto();
                p.setCodigo(resultado.getInt(1));
                p.setNombre(resultado.getString(2));
                p.setPrecio(resultado.getDouble(3));
                p.setCodigoFabricante(resultado.getInt(4));
            }
            desconectarBase();
            return p;

        } catch (Exception e) {
            desconectarBase();
            throw e;
        }

    }

    public Collection<String> listarPorNombre(String sql) throws Exception {

        try {
            consultarBase(sql);
            Producto p = null;
            Collection<String> nombres = new ArrayList();
            
            while (resultado.next()) {
                p = new Producto();
                p.setNombre(resultado.getString("nombre"));
                nombres.add(p.getNombre());
            }

            desconectarBase();
            return nombres;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }
    
    public Collection<Producto> listarPorNombreYPrecio(String sql) throws Exception {

        try {
            consultarBase(sql);
            Producto p = null;
            Collection<Producto> nombresYPrecio = new ArrayList();
            
            while (resultado.next()) {
                p = new Producto();
                p.setNombre(resultado.getString(1));
                p.setPrecio(resultado.getDouble(2));
                nombresYPrecio.add(p);
            }

            desconectarBase();
            return nombresYPrecio;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }
    
    public Collection<Producto> listarPorPrecio(String sql) throws Exception{
        
         try {
            consultarBase(sql);
            Producto p = null;
            Collection<Producto> nombresYPrecio = new ArrayList();
            
            while (resultado.next()) {
                p = new Producto();
                p.setNombre(resultado.getString("nombre"));
                p.setPrecio(resultado.getDouble("precio"));
                nombresYPrecio.add(p);
            }

            desconectarBase();
            return nombresYPrecio;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }
    
    public Collection<Producto> listarPortatiles(String sql) throws Exception{
        
         try {
            consultarBase(sql);
            Producto p = null;
            Collection<Producto> portatiles = new ArrayList();
            
            while (resultado.next()) {
                p = new Producto();
                p.setNombre(resultado.getString("nombre"));
                portatiles.add(p);
            }

            desconectarBase();
            return portatiles;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }
            

  

}
