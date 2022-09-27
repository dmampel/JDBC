/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.Persistencia;

import tienda.Entidades.Fabricante;

/**
 *
 * @author Delfina
 */
public final class FabricanteDAO extends DAO {
    
    public void ingresarFabricante(Fabricante f) throws Exception{
        
        try {
            if(f == null){
                throw new Exception("El fabricante no puede ser nulo");
            }
            String sql = "INSERT INTO fabricante (codigo, nombre) VALUES ( " + f.getCodigo() + ", '" + f.getNombre() + "')";
            manipularBase(sql);
        } catch (Exception e) {
            throw e; 
        }
    }
    
    public void eliminarFabricante(int codigo) throws Exception{
        
        try {
            String sql = "DELETE FROM fabricante WHERE codigo = " +codigo;
            manipularBase(sql);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Fabricante buscarPorCodigo(int codigo) throws Exception{
        try {
            String sql = "SELECT * FROM producto WHERE codigo = " + codigo;
            consultarBase(sql);

            Fabricante f = null;

            while (resultado.next()) {
                f = new Fabricante();
                f.setCodigo(resultado.getInt(1));
                f.setNombre(resultado.getString(2));
                
            }
            desconectarBase();
            return f;

        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }
}
