/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package claseobjetos;

/**
 *
 * @author dany_
 */
public class Personas {
    String nombres, apellidos, dui;
    int edad;
    
    // CREAR UN METODO QUE ASIGNE DATOS A LAS VARIABLES
    public void AsignarDatos(){
        nombres="lorem"; apellidos="ipsum"; dui="123";
        edad=34;   
    }
    // CREAR UN METODO QUE ASIGNE DATOS A LAS VARIABLES DESDE LA CLASE PRINCIPAL
    public void AsignarDatos(String nombres, String apellidos, int edad, String dui){
     this.nombres = nombres;
     this.apellidos = apellidos;
     this.edad = edad;
     this.dui = dui;
    }
    // CREAR PARA CADA VARIABLE DE CLASE UN METODO QUE ASIGNE DATOS DESDE LA CLASE PRINCIPAL
    public void setNombres(String nombres){
        this.nombres = nombres;
    }
    public void setApellidos(String apellidos){
        this.apellidos = apellidos;
    }
    public void setDui(String dui){
        this.dui = dui;
    }
    public void setEdad(int edad){
        this.edad = edad;
    }
    // CREAR PARA CADA VARIABLE DE CLASE UN METODO QUE RETORNE SU VALOR
    public String getNombres(){
        return nombres;
    }
    public String getApellidos(){
        return apellidos;
    }
    public String getDui(){
        return dui;
    }
    public int getEdad(){
        return edad;
    }
}
