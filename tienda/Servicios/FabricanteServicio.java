/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.Servicios;

import java.util.Scanner;
import tienda.Entidades.Fabricante;
import tienda.Persistencia.FabricanteDAO;

/**
 *
 * @author Delfina
 */
public class FabricanteServicio {

    public final FabricanteDAO dao = new FabricanteDAO();
    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public Fabricante crearEIngresarFabricante() throws Exception {
        try {
            Fabricante f = new Fabricante();
            System.out.println("Ingrese el código.");
            int codigo = leer.nextInt();
            if(dao.buscarPorCodigo(codigo)!= null){
                throw new Exception("El código ya está registrado.");
            }
            System.out.println("Ingrese el nombre.");
            String nombre = leer.next();
            f.setCodigo(codigo);
            f.setNombre(nombre);
            dao.ingresarFabricante(f);
            return f;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void eliminarFabricante(int codigo) throws Exception{
        dao.eliminarFabricante(codigo);
    }
}
