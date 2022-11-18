/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratoriotres;

import java.util.ArrayList;

/**
 *
 * @author dany_
 */
public class Usuarios {
     // ARRAYLIST
    private ArrayList correos;
    private ArrayList nombres;
    private ArrayList apellidos;
    private ArrayList clave;
    private ArrayList niveles;
    
    // CONSTRUCTOR
    public Usuarios(){
        correos = new ArrayList();
        nombres = new ArrayList();
        apellidos = new ArrayList();
        clave = new ArrayList();
        niveles = new ArrayList();
        int nivel = 1;
        // LLENADO POR DEFECTO DE USUARIOS
        for (int indice=4; indice>=1; indice--){
            this.correos.add("lorem"+indice+"@dominio.com");
            this.nombres.add("Lorem de Ipsum"+indice);
            this.apellidos.add("Dolor"+indice);
             this.clave.add("123"+indice);
            this.niveles.add(nivel);
            nivel++;
            if( nivel == 4){
                nivel = 1;
            }
        }
    }
    
    // VALIDAR SI LOGIN ES EXITOSO
    public boolean IniciarSesion(String usuario, String claves){
        boolean estadoUsuario = correos.contains(usuario);
        boolean estadoClave = clave.contains(claves);
        if(estadoUsuario && estadoClave){
            return true;
        }
        else{
            return false;
        }        
    }
    
    // VALIDAR SI CORREO A REGISTRAR EXISTE
    public boolean ValidarCorreo(String correo){
        if(correos.contains(correo)){
            return true;
        }
        else{
            return false;
        }      
    }
    
    // REGISTRO DE NUEVOS USUARIOS
    public void setRegistroNuevosUsuarios(String correos, String nombres, String apellidos, String clave, int niveles){
        // GUARDAR INFORMACION A LOS DIFERENTES ARRAYS
        this.correos.add(correos);
        this.nombres.add(nombres);
        this.apellidos.add(apellidos);
        this.clave.add(clave);
        this.niveles.add(niveles);
    }
    
    // MODIFICAR REGISTROS DE USUARIOS
    public void setUsuariosModificar(String correos, String nombres, String apellidos, String clave, int niveles, int indice){
        // MODIFICAR INFORMACION A LOS DIFERENTES ARRAYS -> SEGUN LA POSICION INDICADA POR USUARIOS
        this.correos.set(indice,correos);
        this.nombres.set(indice,nombres);
        this.apellidos.set(indice,apellidos);
        this.clave.set(indice,clave);
        this.niveles.set(indice,niveles);
    }
   
    // MODIFICAR CLAVES DE ACCESO
    public void setUsuariosModificarClave(String clave, int indice){
        // MODIFICAR INFORMACION A LOS DIFERENTES ARRAYS -> SEGUN LA POSICION INDICADA POR USUARIOS
        this.clave.set(indice,clave);
    }
    
    // MODIFICAR NIVELES [ROLES] DE ACCESO
    public void setUsuariosModificarRoles(int nivel, int indice){
        // MODIFICAR INFORMACION A LOS DIFERENTES ARRAYS -> SEGUN LA POSICION INDICADA POR USUARIOS
        this.niveles.set(indice,nivel);
    }
    
    // ELIMINAR USUARIOS
    public boolean borrarUsuario (int indiceCorreoBorrar){
        try {
            correos.remove(indiceCorreoBorrar);
            nombres.remove(indiceCorreoBorrar);
            apellidos.remove(indiceCorreoBorrar);
            clave.remove(indiceCorreoBorrar);
            niveles.remove(indiceCorreoBorrar);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    // MODIFICAR USUARIOS
    public void ActualizarUsuario(int indice, String NombresNuevo, String ApellidosNuevo, String ClaveNueva, int NivelNuevo){
        nombres.set(indice,NombresNuevo);
        apellidos.set(indice,ApellidosNuevo);
        clave.set(indice,ClaveNueva);
        niveles.set(indice,NivelNuevo);
    }
    
    // RETORNAR CANTIDAD DE ELEMENTOS GUARDADOS EN ARRAY
    public int getCantidadUsuarios(){
        return correos.size();
    }
    
    public int getIndice(String correo){
        return correos.indexOf(correo);
    }
    public String getCorreos(int indice){
        return correos.get(indice).toString();
    }
    public String getNombres(int indice){
        return nombres.get(indice).toString();
    }
    public String getApellidos(int indice){
        return apellidos.get(indice).toString();
    }
    public String getClave(int indice){
        return clave.get(indice).toString();
    }
    public int getNiveles(int indice){
        return Integer.valueOf(niveles.get(indice).toString());
    }
    
    // CONVERSION DE CODIGO UNICO NIVEL DE USUARIO -> HACIA DESCRIPCION DE NIVEL DE USUARIO
    public String getNombreNiveles(int indice){
        String NombreNivel = "";
        if(Integer.valueOf(niveles.get(indice).toString()) == 1){
            NombreNivel = "Usuario";
        }else if(Integer.valueOf(niveles.get(indice).toString()) == 2){
            NombreNivel = "Asistente";
        }else{
            NombreNivel = "Administrador";
        }
        return NombreNivel;
    }
}
