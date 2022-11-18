
package practicaarrays;

import java.util.ArrayList;

/**
 *
 * @author dany_
 */
public class Usuarios {
   // CONSTRUCTOR
    public Usuarios(){
        correos = new ArrayList();
        nombres = new ArrayList();
        apellidos = new ArrayList();
        clave = new ArrayList();
        niveles = new ArrayList();
        int nivel = 1;
        // LLENADO POR DEFECTO DE USUARIOS
        for (int indice=1; indice<=5; indice++){
            this.correos.add("lorem"+indice+"@utec");
            this.nombres.add("ipsum"+indice);
            this.apellidos.add("dolor"+indice);
             this.clave.add("123"+indice);
            this.niveles.add(nivel);
            nivel++;
            if( nivel == 4){
                nivel = 1;
            }
        }
    }
   
    
    // VALIDAR SI LOGIN ES VALIDO
    public boolean Login(String usuario, String claves){
        boolean estadoUsuario = correos.contains(usuario);
        boolean estadoClave = clave.contains(claves);
        if(estadoUsuario && estadoClave){
            return true;
        }
        else{
            return false;
        }        
    }
    
    // VALIDAR SI CORREO EXISTE
    public boolean ValidarCorreo(String correo){
        if(correos.contains(correo)){
            return true;
        }
        else{
            return false;
        }      
    }
    
    
    // ARRAYLIST
    private ArrayList correos;
    private ArrayList nombres;
    private ArrayList apellidos;
    private ArrayList clave;
    private ArrayList niveles;
    
    // AGREGAR DATOS A LOS ARRAY
    public void setUsuarios(String correos, String nombres, String apellidos, String clave, int niveles){
        // GUARDAR INFORMACION A LOS DIFERENTES ARRAYS
        this.correos.add(correos);
        this.nombres.add(nombres);
        this.apellidos.add(apellidos);
        this.clave.add(clave);
        this.niveles.add(niveles);
    }
    
    // MODIFICAR DATOS A LOS ARRAY
    public void setUsuariosModificar(String correos, String nombres, String apellidos, String clave, int niveles, int indice){
        // MODIFICAR INFORMACION A LOS DIFERENTES ARRAYS -> SEGUN LA POSICION INDICADA POR USUARIOS
        this.correos.set(indice,correos);
        this.nombres.set(indice,nombres);
        this.apellidos.set(indice,apellidos);
        this.clave.set(indice,clave);
        this.niveles.set(indice,niveles);
    }
    
    // ELIMINAR DATOS A LOS ARRAY
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
