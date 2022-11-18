package laboratoriodos;

import java.util.ArrayList;

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
    
    // ELIMINAR REGISTROS DE USUARIOS
    public void setUsuariosEliminar(String correos, String nombres, String apellidos, String clave, int niveles, int indice){
        // ELIMINAR INFORMACION A LOS DIFERENTES ARRAYS -> SEGUN LA POSICION INDICADA POR USUARIOS
        this.correos.remove(indice);
        this.nombres.remove(indice);
        this.apellidos.remove(indice);
        this.clave.remove(indice);
        this.niveles.remove(indice);
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
    
    // RETORNAR CANTIDAD DE ELEMENTOS GUARDADOS EN ARRAY
    public int getCantidadUsuarios(){
        return correos.size();
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
}
