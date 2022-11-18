package clasearraylist;

import java.util.Scanner;

public class ClaseArraylist {
    public static void main(String[] args) {
        /*
            -> LECTURA DE DATOS SCANNER
        */
         Scanner leerDatos = new Scanner(System.in);
         Usuarios usuarios = new Usuarios();
         // VARIABLES
         String usuario = ""; String claves = "";
         int contador = 1;
         do {            
            System.out.print("Ingrese el usuario: ");
            usuario = leerDatos.nextLine();
            System.out.print("Ingrese la clave: ");
            claves = leerDatos.nextLine();
            boolean estadoLogin = usuarios.Login(usuario, claves);
            if(estadoLogin){
                int menuOpciones = 0;
                System.out.println("▓▓▓ Bienvenido al sistema ▓▓▓");
                do{
                    System.out.println("1- Listado de usuarios");
                    System.out.println("2- Agregar usuarios");
                    System.out.println("3- Eliminar usuarios");
                    System.out.println("4- Editar usuarios");
                    System.out.println("5- Buscar usuarios");
                    System.out.println("6- Cambiar clave");
                    System.out.println("7- Cambiar nivel");
                    System.out.println("8- Acerca de...");
                    System.out.println("9- Cerrar sesión");
                    System.out.println("10- Salir del sisetema");
                    System.out.println("");
                    System.out.println("Ingrese opción del menú");
                    menuOpciones = leerDatos.nextInt();
                    leerDatos.nextLine();
                    switch(menuOpciones){
                        case 1:
                            System.out.println("Listado de usuarios");
                            // IMPRIMIR USUARIOS
                            for(int indice = 0; indice < usuarios.getCantidadUsuarios(); indice++){
                                System.out.println("- Nombres: "+usuarios.getNombres(indice));
                                System.out.println("- Apellidos: "+usuarios.getApellidos(indice));
                                System.out.println("- Correo: "+usuarios.getCorreos(indice));
                                System.out.println("- Clave: "+usuarios.getClave(indice));
                                System.out.println("- Nivel: "+usuarios.getNiveles(indice));
                                System.out.println("*************************************************");
                                System.out.println("*************************************************");
                                System.out.println("");
                            }
                        break;
                        case 2:
                            System.out.println("Agregar usuarios");
                            System.out.print("- Ingrese el correo del usuario: ");
                            String correo_usuarios = leerDatos.nextLine();
                            // VALIDAR SI CORREO YA EXISTE
                            boolean estadoCorreo = usuarios.ValidarCorreo(correo_usuarios);
                            if(estadoCorreo){
                                System.out.println("- Correo ya existente.");
                            }else{
                                System.out.print("- Ingrese los nombre del usuario: ");
                                String nombre_usuarios = leerDatos.nextLine();
                                System.out.print("- Ingrese los apellidos del usuario: ");
                                String apellido_usuarios = leerDatos.nextLine();
                                System.out.print("- Ingrese la clave del usuario: ");
                                String clave_usuarios = leerDatos.nextLine();
                                System.out.print("- Ingrese la clave nuevamente para confirmar: ");
                                String clave_usuarios_confirmar = leerDatos.nextLine();
                                int CompararClaves = clave_usuarios.compareTo(clave_usuarios_confirmar);
                                if(CompararClaves == 0){
                                    System.out.println("- NIVELES:");
                                    System.out.println("- 1. Usuario");
                                    System.out.println("- 2. Asistente");
                                    System.out.println("- 1. Administrador");
                                    System.out.print("- Ingrese el nivel del usuario: ");
                                    int nivel_usuarios = leerDatos.nextInt();
                                    leerDatos.nextLine();
                                    if(nivel_usuarios >=1 && nivel_usuarios<=3){
                                        usuarios.setUsuarios(correo_usuarios, nombre_usuarios, apellido_usuarios, clave_usuarios, nivel_usuarios);
                                    }else{
                                        System.out.println("- Lo sentimos, opcion no valida");
                                    }
                                }else{
                                    System.out.println("- Lo sentimos, las claves ingresadas no coinciden");
                                }
                            }
                        break;
                       case 3:
                            System.out.println("Eliminar usuarios");
                        break;
                       case 4:
                            System.out.println("Editar usuario");
                        break;
                    }
                    leerDatos.nextLine();
                }while(menuOpciones <= 8);
                break;
            }
            else{
                System.out.println("Error, usuario y/o clave no existe");
            }
            contador++;
        } while (contador <= 3);
    }
    
}
