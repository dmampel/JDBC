/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.Servicios;

import java.util.Collection;
import java.util.Scanner;
import tienda.Entidades.Fabricante;
import tienda.Entidades.Producto;
import tienda.Persistencia.ProductoDAO;

/**
 *
 * @author Delfina
 */
public class ProductoServicio {

    public final ProductoDAO dao = new ProductoDAO();
    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public Producto crearEIngresarProducto() throws Exception {

        try {
            System.out.println("Vamos a ingresar un producto a nuestra base de datos.");
            System.out.println("Ingresá la siguiente información por favor.");
            System.out.println("Código de producto");
            int codigo = leer.nextInt();
            if (dao.buscarPorCodigo(codigo) != null) {
                throw new Exception("Ya existe un producto con ese código.");
            }
            System.out.println("Nombre del producto.");
            String nombre = leer.next();
            System.out.println("Precio.");
            double precio = leer.nextDouble();
            System.out.println("Código de fabricante.");
            int codigoFabricante = leer.nextInt();

            Producto p = new Producto();
            p.setCodigo(codigo);
            p.setNombre(nombre);
            p.setPrecio(precio);
            p.setCodigoFabricante(codigoFabricante);
            dao.ingresarProducto(p);

            return p;
        } catch (Exception e) {
            throw e;
        }

    }

    public void modificarProducto(int codigo) throws Exception {
        dao.modificarProducto(codigo);

    }

    public void consulta1() throws Exception {

        try {

            String sql = "SELECT nombre FROM producto";
            Collection<String> nombres = dao.listarPorNombre(sql);
            System.out.println("LISTA DE NOMBRES DE TODOS LOS PRODUCTOS");
            nombres.forEach((aux) -> {
                System.out.println(aux);
            });

        } catch (Exception e) {
            throw e;
        }

    }

    public void consulta2() throws Exception {

        try {
            String sql = "SELECT nombre, precio FROM producto";
            Collection<Producto> nombresYPrecio = dao.listarPorNombreYPrecio(sql);
            System.out.println("NOMBRE Y PRECIO DE TODOS LOS PRODUCTOS");
            nombresYPrecio.forEach((aux) -> {
                System.out.println(aux.getNombre() + ", $" + aux.getPrecio() + "");
            });
        } catch (Exception e) {
            throw e;
        }

    }

    public void consulta3(double min, double max) throws Exception {

        try {
            String sql = "SELECT * FROM producto WHERE precio BETWEEN " + min + " AND " + max;
            Collection<Producto> filtroPrecios = dao.listarPorPrecio(sql);
            System.out.println("PRODUCTOS CUYOS PRECIOS OSCILAN ENTRE " + min + " y " + max);
            filtroPrecios.forEach((aux) -> {
                System.out.println(aux.getNombre() + ", $" + aux.getPrecio() + "");
            });
        } catch (Exception e) {
            throw e;
        }

    }

    public void consulta4() throws Exception {

        try {
            String sql = "SELECT nombre FROM producto WHERE nombre LIKE ('%portatil%')";
            Collection<Producto> portatiles = dao.listarPortatiles(sql);
            System.out.println("PRODUCTOS PORTÁTILES.");
            portatiles.forEach((aux) -> {
                System.out.println(aux.getNombre());
            });
        } catch (Exception e) {
            throw e;
        }

    }

    public void consulta5() throws Exception {

        try {
            String sql = "SELECT nombre, MIN(precio) FROM producto";
            Collection<Producto> nombresYPrecio = dao.listarPorNombreYPrecio(sql);
            System.out.println("NOMBRE Y PRECIO DE TODOS LOS PRODUCTOS");
            nombresYPrecio.forEach((aux) -> {
                System.out.println(aux.getNombre() + ", $" + aux.getPrecio() + "");
            });

        } catch (Exception e) {
            throw e;
        }

    }

    public void menu() throws Exception {

        try {
            int respuesta;
            do {

                System.out.println("MENÚ de la Tienda.");
                System.out.println("1- Crear e ingresar un producto a la base de datos.");
                System.out.println("2- Modificar un producto existente.");
                System.out.println("3- Listar el nombre de todos los productos que hay en la tabla producto. ");
                System.out.println("4- Listar los nombres y los precios de todos los productos de la tabla producto.");
                System.out.println("5- Listar productos mediante un precio minimo y uno máximo. Los valores los ingresa usted.");
                System.out.println("6- Buscar y listar todos los Portátiles de la tabla producto.");
                System.out.println("7- Listar el nombre y el precio del producto más barato.");
                System.out.println("8- Ingresar un nuevo fabricante. ");
                System.out.println("9- No quiero hacer nada, salir.");
                System.out.println("¿Qué operación deseas realizar?");
                respuesta = leer.nextInt();

                switch (respuesta) {
                    case 1:
                        crearEIngresarProducto();
                        break;
                    case 2:
                        System.out.println("Ingresá el código del producto que querés modificar.");
                        int codigo = leer.nextInt();
                        modificarProducto(codigo);
                        break;
                    case 3:
                        consulta1();
                        break;
                    case 4:
                        consulta2();
                        break;
                    case 5:
                        System.out.println("Indique el precio mínimo.");
                        double min = leer.nextDouble();
                        System.out.println("Ahora el máximo.");
                        double max = leer.nextDouble();
                        consulta3(min, max);
                        break;
                    case 6:
                        consulta4();
                        break;
                    case 7:
                        consulta5();
                        break;
                    case 8:
                        FabricanteServicio fs = new FabricanteServicio();
                        Fabricante f = fs.crearEIngresarFabricante();
                        break;
                    case 9:
                        System.out.println("Ok, saliendo...");
                        break;
                    default:
                        System.out.println("NO hay operaciones para esta opción.");
                        break;

                }

            } while (respuesta != 9);

        } catch (Exception e) {
            throw e;
        }

    }

}
