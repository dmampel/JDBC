/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.Persistencia;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author Delfina
 */
public abstract class DAO {
    
    Scanner leer = new Scanner(System.in);
    
    protected Connection conexion = null;
    protected ResultSet resultado = null;
    protected Statement sentencia = null;
    private final String USER = "root";
    private final String PASSWORD = "root";
    private final String DATABASE = "tienda";
    private final String DRIVER = "com.mysql.jdbc.Driver";
    
    protected void conectarBase() throws Exception{
        
        try {
            Class.forName(DRIVER);
            String url = "jdbc:mysql://localhost:3306/" + DATABASE +"?useSSL=false";
            conexion = DriverManager.getConnection(url, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }
    }
    
    protected void desconectarBase() throws Exception{
        try {
            if (resultado != null) {
                resultado.close();
            }
            if (sentencia != null) {
                sentencia.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        } catch (SQLException e) {
            throw e;
            
        }
    }
    
    protected void manipularBase(String sql) throws Exception{
        try {
            conectarBase();
            sentencia = conexion.createStatement();
            sentencia.executeUpdate(sql);
            
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }finally{
            desconectarBase();
        }
        
    }
    
    protected void consultarBase(String sql) throws Exception{
        try {
            conectarBase();
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(sql);
        
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }
        
    }
    
   
    
}
