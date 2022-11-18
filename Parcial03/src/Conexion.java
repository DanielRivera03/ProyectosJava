
import java.sql.Connection;
import java.sql.DriverManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dany_
 */
public class Conexion {
    private Connection conexion;
    
    public Conexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/parcial04", "root", "");
            System.out.println("SE HA CONECTADO");
        }catch (Exception e){
            System.out.println("NO SE HA CONECTADO");
        }
    }
    
    public Connection getConexion(){
            return conexion;
        }
}
