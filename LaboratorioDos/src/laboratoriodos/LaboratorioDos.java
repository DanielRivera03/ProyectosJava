package laboratoriodos;

import java.util.Scanner;

public class LaboratorioDos {
     public static void main(String[] args) throws InterruptedException {
        /*
            -> LECTURA DE DATOS SCANNER
        */
         Scanner leerDatos = new Scanner(System.in);
        /*
            -> VARIABLES GLOBALES
        */
        String usuario="", contrasenia = "", correo_usuarios = "", nombre_usuarios = "", apellido_usuarios="", clave_usuarios="", correoBusqueda = "";
        int tiporolusuario = 0,  contador_intentos = 1, conteo_cierresesiones = 1, barra_espera = 0, opcion_menuprincipal = 0, indice = 0, nivel_usuarios = 0;
        boolean salida_menuprincipal = false, retorno_errores = false, estadoCorreo = false, encontrado=false;
        // INSTANCIA DE CLASE USUARIOS
        Usuarios usuarios = new Usuarios();
        /*
            -> INICIO TODO EJECUCION DE APLICACION PRINCIPAL
        */
        try{
            System.out.println("***************************************************************");
            System.out.println("                       INICIAR SESION");
            System.out.println("***************************************************************");
            System.out.println("- Estimado usuario, por favor elija su rol de usuario");
            System.out.println("- 1. Usuario");
            System.out.println("- 2. Asistente");
            System.out.println("- 3. Administrador");
            System.out.print("      -> Su opción: ");
            tiporolusuario = leerDatos.nextInt(); // CAPTURAMOS EL TIPO DE ROL DE USUARIO
            leerDatos.nextLine(); // LIMPIEZA DE BUFER
            if(tiporolusuario >=1 && tiporolusuario<=3){
                
                /*
                    -> ROL DE ACCESO USUARIO
                */
                
                
                if(tiporolusuario==1){
                  // INGRESO DE CREDENCIALES USUARIOS
                    for(contador_intentos = 1; contador_intentos < 4; contador_intentos++){
                        // CONTADOR DE CIERRE DE SESIONES
                        /*
                            ***********************************************************************************************
                            -> ESTO CON EN FIN DE REESTABLECER EL VALOR DEL CONTADOR DE INTENTOS MIENTRAS NO SEA IGUAL A 3
                               CASO CONTRARIO EL SISTEMA ESTA VALIDADO PARA FINALIZAR LA EJECUCION AL MOMENTO DE CERRAR
                               SESION SI EL CONTADOR DE INTENTOS ES IGUAL A TRES [3]
                            ***********************************************************************************************
                        */
                        if(conteo_cierresesiones > 1){
                            contador_intentos = 1;
                        } // CIERRE if(conteo_cierresesiones > 1)
                        System.out.printf("|%4s%2s%2s|%n", "INTENTO --> ", contador_intentos, " / 3");
                        System.out.print("- Estimado usuario(a), ingrese su correo de usuario: ");
                        usuario = leerDatos.nextLine();
                        System.out.print("- Estimado usuario(a), ingrese su contraseña: ");
                        contrasenia = leerDatos.nextLine();
                        boolean ValidarCredenciales = usuarios.IniciarSesion(usuario, contrasenia);
                        // EFECTO CARGA ESPERE UN MOMENTO
                        System.out.print("- Espere un momento");
                        for(barra_espera=0; barra_espera<6; barra_espera++){
                            System.out.print(".");
                            Thread.sleep(500);
                        }
                        System.out.println("");
                        if(ValidarCredenciales){ // SI CREDENCIALES SON COINCIDENTES A REGISTROS = TRUE [INICIO DE SESION EXITOSO]
                            try{
                                do{
                                    retorno_errores = true;
                                    System.out.println("***************************************************************");
                                    System.out.println("                  PORTAL USUARIO");
                                    System.out.println("***************************************************************");
                                    System.out.println("- Bienvenido(a). Por favor elija una opción:");
                                    System.out.println("- 1. Listado de Usuarios ");
                                    System.out.println("- 2. Buscar Usuarios ");
                                    System.out.println("- 3. Listado de Usuarios Nivel Usuario ");
                                    System.out.println("- 4. Listado de Usuarios Nivel Asistente ");
                                    System.out.println("- 5. Listado de Usuarios Nivel Administradores ");
                                    System.out.println("- 6. Acerca De ");
                                    System.out.println("- 7. Cerrar Sesion ");
                                    System.out.println("- 8. Salir del Sistema ");
                                    System.out.print("-         -> Su opción: ");
                                    opcion_menuprincipal = leerDatos.nextInt();
                                    leerDatos.nextLine(); // LIMPIEZA DE BUFER
                                    /*
                                        -> NAVEGACION EN MENU DE SISTEMA SEGUN OPCION INGRESADA POR USUARIOS
                                    */
                                    switch(opcion_menuprincipal){
                                        /*
                                            -> LISTADO DE USUARIOS REGISTRADOS [GENERAL]
                                        */
                                        case 1:
                                            System.out.println("***************************************************************");
                                            System.out.println("                  PORTAL USUARIO");
                                            System.out.println("***************************************************************");
                                            System.out.println("- Listado de usuarios registrados");
                                            // IMPRIMIR USUARIOS
                                            for(indice = 0; indice < usuarios.getCantidadUsuarios(); indice++){
                                                int valorusuario = indice+1;
                                                //if(usuarios.getNiveles(indice) == 3){
                                                System.out.println("---------------------------------------------------");
                                                System.out.println("- USUARIO "+ valorusuario +" / "+usuarios.getCantidadUsuarios());
                                                System.out.println("---------------------------------------------------");
                                                System.out.println("- Nombres: "+usuarios.getNombres(indice));
                                                System.out.println("- Apellidos: "+usuarios.getApellidos(indice));
                                                System.out.println("- Correo: "+usuarios.getCorreos(indice));
                                                System.out.println("- Clave: "+usuarios.getClave(indice));
                                                System.out.println("- Nivel: "+usuarios.getNiveles(indice));
                                                System.out.println("---------------------------------------------------");
                                                System.out.println("---------------------------------------------------");
                                                //}
                                            }// CIERRE for(indice = 0; indice < usuarios.getCantidadUsuarios(); indice++){
                                            System.out.println("█████████████████████████████████████");
                                            System.out.println("█ ACCION FINALIZADA CON EXITO ");
                                            System.out.println("█ Presione ENTER para continuar...");
                                            System.out.println("█████████████████████████████████████");
                                            new java.util.Scanner(System.in).nextLine();
                                            salida_menuprincipal = false; // NO PERMITIR SALIR A MENU PRINCIPAL
                                            break;
                                        /*
                                            -> BUSQUEDA DE USUARIOS REGISTRADOS
                                        */
                                        case 2:
                                            System.out.println("***************************************************************");
                                            System.out.println("                  PORTAL USUARIO");
                                            System.out.println("***************************************************************");
                                            System.out.println("- Busqueda de usuarios registrados");
                                            System.out.print("- Ingrese el correo de la persona a buscar: ");
                                            correoBusqueda = leerDatos.nextLine();
                                            encontrado = false;
                                            for(indice = 0; indice < usuarios.getCantidadUsuarios(); indice++){
                                                // BUSCAR COINCIDENCIAS DE USUARIOS REGISTRADOS -> SEGUN EL CORREO INGRESADO
                                                if(correoBusqueda.equals(usuarios.getCorreos(indice))){
                                                    encontrado = true;
                                                    System.out.println("---------------------------------------------------");
                                                    System.out.println("- DATOS DE USUARIO SELECCIONADO");
                                                    System.out.println("---------------------------------------------------");
                                                    System.out.println("- Nombres: "+usuarios.getNombres(indice));
                                                    System.out.println("- Apellidos: "+usuarios.getApellidos(indice));
                                                    System.out.println("- Correo: "+usuarios.getCorreos(indice));
                                                    System.out.println("- Clave: "+usuarios.getClave(indice));
                                                    System.out.println("- Nivel: "+usuarios.getNiveles(indice));
                                                    System.out.println("---------------------------------------------------");
                                                    System.out.println("---------------------------------------------------");
                                                }
                                            }// CIERRE for(indice = 0; indice < usuarios.getCantidadUsuarios(); indice++)
                                            if(encontrado == false){
                                                System.out.println("- Lo sentimos, no hemos encontrado datos coincidentes");
                                            }
                                            System.out.println("█████████████████████████████████████");
                                            System.out.println("█ ACCION FINALIZADA CON EXITO ");
                                            System.out.println("█ Presione ENTER para continuar...");
                                            System.out.println("█████████████████████████████████████");
                                            new java.util.Scanner(System.in).nextLine();
                                            salida_menuprincipal = false; // NO PERMITIR SALIR A MENU PRINCIPAL
                                            break;
                                        /*
                                            -> LISTADO DE USUARIOS REGISTRADOS [NIVEL ROL DE ACCESO USUARIO]
                                        */
                                        case 3:
                                            System.out.println("***************************************************************");
                                            System.out.println("                  PORTAL USUARIO");
                                            System.out.println("***************************************************************");
                                            System.out.println("- Listado de usuarios registrados [ROL USUARIO]");
                                            // IMPRIMIR USUARIOS
                                            for(indice = 0; indice < usuarios.getCantidadUsuarios(); indice++){
                                                int valorusuario = indice+1; // PARA IGUALAR CONTADOR VISTA USUARIOS [CASO CONTRARIO INICIA CONTEO EN CERO [0]]
                                                if(usuarios.getNiveles(indice) == 1){
                                                    System.out.println("---------------------------------------------------");
                                                    System.out.println("- USUARIO "+ valorusuario +" / "+usuarios.getCantidadUsuarios());
                                                    System.out.println("---------------------------------------------------");
                                                    System.out.println("- Nombres: "+usuarios.getNombres(indice));
                                                    System.out.println("- Apellidos: "+usuarios.getApellidos(indice));
                                                    System.out.println("- Correo: "+usuarios.getCorreos(indice));
                                                    System.out.println("- Clave: "+usuarios.getClave(indice));
                                                    System.out.println("- Nivel: "+usuarios.getNiveles(indice));
                                                    System.out.println("---------------------------------------------------");
                                                    System.out.println("---------------------------------------------------");
                                                }// CIERRE if(usuarios.getNiveles(indice) == 1)
                                            }// CIERRE for(indice = 0; indice < usuarios.getCantidadUsuarios(); indice++){
                                            System.out.println("█████████████████████████████████████");
                                            System.out.println("█ ACCION FINALIZADA CON EXITO ");
                                            System.out.println("█ Presione ENTER para continuar...");
                                            System.out.println("█████████████████████████████████████");
                                            new java.util.Scanner(System.in).nextLine();
                                            salida_menuprincipal = false; // NO PERMITIR SALIR A MENU PRINCIPAL
                                            break;
                                        /*
                                            -> LISTADO DE USUARIOS REGISTRADOS [NIVEL ROL DE ACCESO ASISTENTE]
                                        */
                                        case 4:
                                            System.out.println("***************************************************************");
                                            System.out.println("                  PORTAL USUARIO");
                                            System.out.println("***************************************************************");
                                            System.out.println("- Listado de usuarios registrados [ROL ASISTENTE]");
                                            // IMPRIMIR USUARIOS
                                            for(indice = 0; indice < usuarios.getCantidadUsuarios(); indice++){
                                                int valorusuario = indice+1; // PARA IGUALAR CONTADOR VISTA USUARIOS [CASO CONTRARIO INICIA CONTEO EN CERO [0]]
                                                if(usuarios.getNiveles(indice) == 2){
                                                    System.out.println("---------------------------------------------------");
                                                    System.out.println("- USUARIO "+ valorusuario +" / "+usuarios.getCantidadUsuarios());
                                                    System.out.println("---------------------------------------------------");
                                                    System.out.println("- Nombres: "+usuarios.getNombres(indice));
                                                    System.out.println("- Apellidos: "+usuarios.getApellidos(indice));
                                                    System.out.println("- Correo: "+usuarios.getCorreos(indice));
                                                    System.out.println("- Clave: "+usuarios.getClave(indice));
                                                    System.out.println("- Nivel: "+usuarios.getNiveles(indice));
                                                    System.out.println("---------------------------------------------------");
                                                    System.out.println("---------------------------------------------------");
                                                }// CIERRE if(usuarios.getNiveles(indice) == 2)
                                            }// CIERRE for(indice = 0; indice < usuarios.getCantidadUsuarios(); indice++){
                                            System.out.println("█████████████████████████████████████");
                                            System.out.println("█ ACCION FINALIZADA CON EXITO ");
                                            System.out.println("█ Presione ENTER para continuar...");
                                            System.out.println("█████████████████████████████████████");
                                            new java.util.Scanner(System.in).nextLine();
                                            salida_menuprincipal = false; // NO PERMITIR SALIR A MENU PRINCIPAL
                                            break;
                                        /*
                                            -> LISTADO DE USUARIOS REGISTRADOS [NIVEL ROL DE ACCESO ADMINISTRADORES]
                                        */
                                        case 5:
                                            System.out.println("***************************************************************");
                                            System.out.println("                  PORTAL USUARIO");
                                            System.out.println("***************************************************************");
                                            System.out.println("- Listado de usuarios registrados [ROL ADMINISTRADORES]");
                                            // IMPRIMIR USUARIOS
                                            for(indice = 0; indice < usuarios.getCantidadUsuarios(); indice++){
                                                int valorusuario = indice+1; // PARA IGUALAR CONTADOR VISTA USUARIOS [CASO CONTRARIO INICIA CONTEO EN CERO [0]]
                                                if(usuarios.getNiveles(indice) == 3){
                                                    System.out.println("---------------------------------------------------");
                                                    System.out.println("- USUARIO "+ valorusuario +" / "+usuarios.getCantidadUsuarios());
                                                    System.out.println("---------------------------------------------------");
                                                    System.out.println("- Nombres: "+usuarios.getNombres(indice));
                                                    System.out.println("- Apellidos: "+usuarios.getApellidos(indice));
                                                    System.out.println("- Correo: "+usuarios.getCorreos(indice));
                                                    System.out.println("- Clave: "+usuarios.getClave(indice));
                                                    System.out.println("- Nivel: "+usuarios.getNiveles(indice));
                                                    System.out.println("---------------------------------------------------");
                                                    System.out.println("---------------------------------------------------");
                                                }// CIERRE if(usuarios.getNiveles(indice) == 3)
                                            }// CIERRE for(indice = 0; indice < usuarios.getCantidadUsuarios(); indice++){
                                            System.out.println("█████████████████████████████████████");
                                            System.out.println("█ ACCION FINALIZADA CON EXITO ");
                                            System.out.println("█ Presione ENTER para continuar...");
                                            System.out.println("█████████████████████████████████████");
                                            new java.util.Scanner(System.in).nextLine();
                                            salida_menuprincipal = false; // NO PERMITIR SALIR A MENU PRINCIPAL
                                            break;
                                        /*
                                            -> ACERCA DE NOSOTROS
                                        */
                                        case 6:
                                            System.out.println("***************************************************************");
                                            System.out.println("                  PORTAL USUARIO");
                                            System.out.println("***************************************************************");
                                            System.out.println("- ACERCA DE NOSOTROS");
                                            System.out.println("- Elias Daniel Martinez Rivera | 27-0077-2019");
                                            System.out.println("- Harold Osmany Garcia Osegueda | 25-3146-2020");
                                            System.out.println("- Roberto Andres Mendez Ortiz | 25-1578-2020");
                                            System.out.println("- Luis Felipe Ramirez Cuellas | 25-2324-2001");
                                            System.out.println("- Eldin Okely Rosales Garcia | 25-4113-2020");
                                            System.out.println("█████████████████████████████████████");
                                            System.out.println("█ ACCION FINALIZADA CON EXITO ");
                                            System.out.println("█ Presione ENTER para continuar...");
                                            System.out.println("█████████████████████████████████████");
                                            new java.util.Scanner(System.in).nextLine();
                                            salida_menuprincipal = false; // NO PERMITIR SALIR A MENU PRINCIPAL
                                            break;
                                        /*
                                            -> CERRAR SESION USUARIOS
                                        */
                                        case 7: 
                                            leerDatos.nextLine(); // LIMPIEZA DE BUFER
                                            salida_menuprincipal = true; // SALIR A MENU PRINCIPAL
                                            conteo_cierresesiones++; // CONTADOR DE CIERRE DE SESIONES
                                            // SI CONTADOR DE INTENTOS ES IGUAL A TRES [3] -> POR SEGURIDAD FINALIZA EJECUCION DE SISTEAMA AL CERRAR SESION
                                            if(contador_intentos == 3){
                                                System.out.println("***************************************************************");
                                                System.out.println("***************************************************************");
                                                System.out.println("- Usted ha tenido dos errores al momento de iniciar sesión en");
                                                System.out.println("  nuestro sistema. Por seguridad hemos finalizado la ejecución");
                                                System.out.println("  de la aplicación. No se preocupe puede iniciarla nuevamente");
                                                System.out.println("  e ingresar sus credenciales.");
                                            }// CIERRE if(contador_intentos == 3)
                                            break;
                                        /*
                                            -> SALIR COMPLETAMENTE DE LA APLICACION
                                        */
                                        case 8:
                                            System.exit(0);
                                            break;
                                        /*
                                            -> OPCIONES INVALIDAS -> MENSAJE ERROR
                                        */
                                        default:
                                            System.out.println("- Opción de menú incorrecta. Intente otra vez...");
                                            break;
                                    }// CIERRE switch(opcion_menuprincipal)
                                }while(!salida_menuprincipal); // CIERRE }while(!salida_menuprincipal);
                            }catch(Exception e){
                                System.out.println("- Solamente debe ingresar valores numericos...");
                                salida_menuprincipal = false; // NO PERMITIR SALIR A MENU PRINCIPAL
                                leerDatos.nextLine(); // LIMPIEZA DE BUFER
                                break; // SI INGRESA UN VALOR DIFERENTE AL ESTABLECIDO, SIMPLEMENTE TERMINA EJECUCION
                            } // CIERRE TRY CATCH
                        }else{
                            System.out.println("- Lo sentimos usuario y/o contraseña inválidos... Intente otra vez.");
                        }
                    }// CIERRE for(contador_intentos = 1; contador_intentos < 4; contador_intentos++)      
                }// CIERRE if(tiporolusuario==1)
                
                
                /*
                    -> ROL DE ACCESO ASISTENTE
                */
                
                if(tiporolusuario==2){
                    // INGRESO DE CREDENCIALES USUARIOS
                    for(contador_intentos = 1; contador_intentos < 4; contador_intentos++){
                        // CONTADOR DE CIERRE DE SESIONES
                        /*
                            ***********************************************************************************************
                            -> ESTO CON EN FIN DE REESTABLECER EL VALOR DEL CONTADOR DE INTENTOS MIENTRAS NO SEA IGUAL A 3
                               CASO CONTRARIO EL SISTEMA ESTA VALIDADO PARA FINALIZAR LA EJECUCION AL MOMENTO DE CERRAR
                               SESION SI EL CONTADOR DE INTENTOS ES IGUAL A TRES [3]
                            ***********************************************************************************************
                        */
                        if(conteo_cierresesiones > 1){
                            contador_intentos = 1;
                        } // CIERRE if(conteo_cierresesiones > 1)
                        System.out.printf("|%4s%2s%2s|%n", "INTENTO --> ", contador_intentos, " / 3");
                        System.out.print("- Estimado usuario(a), ingrese su correo de usuario: ");
                        usuario = leerDatos.nextLine();
                        System.out.print("- Estimado usuario(a), ingrese su contraseña: ");
                        contrasenia = leerDatos.nextLine();
                        boolean ValidarCredenciales = usuarios.IniciarSesion(usuario, contrasenia);
                        // EFECTO CARGA ESPERE UN MOMENTO
                        System.out.print("- Espere un momento");
                        for(barra_espera=0; barra_espera<6; barra_espera++){
                            System.out.print(".");
                            Thread.sleep(500);
                        }
                        System.out.println("");
                        if(ValidarCredenciales){ // SI CREDENCIALES SON COINCIDENTES A REGISTROS = TRUE [INICIO DE SESION EXITOSO]
                            try{
                                do{
                                    retorno_errores = true;
                                    System.out.println("***************************************************************");
                                    System.out.println("                  PORTAL ASISTENTES");
                                    System.out.println("***************************************************************");
                                    System.out.println("- Bienvenido(a). Por favor elija una opción:");
                                    System.out.println("- 1. Listado de Usuarios ");
                                    System.out.println("- 2. Buscar Usuarios ");
                                    System.out.println("- 3. Editar Usuarios ");
                                    System.out.println("- 4. Cambiar Contraseña de Usuarios ");
                                    System.out.println("- 5. Cambiar Niveles de Usuarios ");
                                    System.out.println("- 6. Listado de Usuarios Nivel Usuario ");
                                    System.out.println("- 7. Listado de Usuarios Nivel Asistente ");
                                    System.out.println("- 8. Listado de Usuarios Nivel Administradores ");
                                    System.out.println("- 9. Acerca De ");
                                    System.out.println("- 10. Cerrar Sesion ");
                                    System.out.println("- 11. Salir del Sistema ");
                                    System.out.print("-         -> Su opción: ");
                                    opcion_menuprincipal = leerDatos.nextInt();
                                    leerDatos.nextLine(); // LIMPIEZA DE BUFER
                                    /*
                                        -> NAVEGACION EN MENU DE SISTEMA SEGUN OPCION INGRESADA POR USUARIOS
                                    */
                                    switch(opcion_menuprincipal){
                                        /*
                                            -> LISTADO DE USUARIOS REGISTRADOS [GENERAL]
                                        */
                                        case 1:
                                            System.out.println("***************************************************************");
                                            System.out.println("                  PORTAL ASISTENTES");
                                            System.out.println("***************************************************************");
                                            System.out.println("- Listado de usuarios registrados");
                                            // IMPRIMIR USUARIOS
                                            for(indice = 0; indice < usuarios.getCantidadUsuarios(); indice++){
                                                int valorusuario = indice+1;
                                                //if(usuarios.getNiveles(indice) == 3){
                                                System.out.println("---------------------------------------------------");
                                                System.out.println("- USUARIO "+ valorusuario +" / "+usuarios.getCantidadUsuarios());
                                                System.out.println("---------------------------------------------------");
                                                System.out.println("- Nombres: "+usuarios.getNombres(indice));
                                                System.out.println("- Apellidos: "+usuarios.getApellidos(indice));
                                                System.out.println("- Correo: "+usuarios.getCorreos(indice));
                                                System.out.println("- Clave: "+usuarios.getClave(indice));
                                                System.out.println("- Nivel: "+usuarios.getNiveles(indice));
                                                System.out.println("---------------------------------------------------");
                                                System.out.println("---------------------------------------------------");
                                                //}
                                            }// CIERRE for(indice = 0; indice < usuarios.getCantidadUsuarios(); indice++){
                                            System.out.println("█████████████████████████████████████");
                                            System.out.println("█ ACCION FINALIZADA CON EXITO ");
                                            System.out.println("█ Presione ENTER para continuar...");
                                            System.out.println("█████████████████████████████████████");
                                            new java.util.Scanner(System.in).nextLine();
                                            salida_menuprincipal = false; // NO PERMITIR SALIR A MENU PRINCIPAL
                                            break;
                                        /*
                                            -> BUSQUEDA DE USUARIOS REGISTRADOS
                                        */
                                        case 2:
                                            System.out.println("***************************************************************");
                                            System.out.println("                  PORTAL ASISTENTES");
                                            System.out.println("***************************************************************");
                                            System.out.println("- Busqueda de usuarios registrados");
                                            System.out.print("- Ingrese el correo de la persona a buscar: ");
                                            correoBusqueda = leerDatos.nextLine();
                                            encontrado = false;
                                            for(indice = 0; indice < usuarios.getCantidadUsuarios(); indice++){
                                                // BUSCAR COINCIDENCIAS DE USUARIOS REGISTRADOS -> SEGUN EL CORREO INGRESADO
                                                if(correoBusqueda.equals(usuarios.getCorreos(indice))){
                                                    encontrado = true;
                                                    System.out.println("---------------------------------------------------");
                                                    System.out.println("- DATOS DE USUARIO SELECCIONADO");
                                                    System.out.println("---------------------------------------------------");
                                                    System.out.println("- Nombres: "+usuarios.getNombres(indice));
                                                    System.out.println("- Apellidos: "+usuarios.getApellidos(indice));
                                                    System.out.println("- Correo: "+usuarios.getCorreos(indice));
                                                    System.out.println("- Clave: "+usuarios.getClave(indice));
                                                    System.out.println("- Nivel: "+usuarios.getNiveles(indice));
                                                    System.out.println("---------------------------------------------------");
                                                    System.out.println("---------------------------------------------------");
                                                }
                                            }// CIERRE for(indice = 0; indice < usuarios.getCantidadUsuarios(); indice++)
                                            if(encontrado == false){
                                                System.out.println("- Lo sentimos, no hemos encontrado datos coincidentes");
                                            }
                                            System.out.println("█████████████████████████████████████");
                                            System.out.println("█ ACCION FINALIZADA CON EXITO ");
                                            System.out.println("█ Presione ENTER para continuar...");
                                            System.out.println("█████████████████████████████████████");
                                            new java.util.Scanner(System.in).nextLine();
                                            salida_menuprincipal = false; // NO PERMITIR SALIR A MENU PRINCIPAL
                                            break;
                                        /*
                                            -> MODIFICAR USUARIOS REGISTRADOS
                                        */
                                        case 3:
                                            System.out.println("***************************************************************");
                                            System.out.println("                  PORTAL ASISTENTES");
                                            System.out.println("***************************************************************");
                                            System.out.println("- Modificar datos de usuarios registrados");
                                            System.out.println("");
                                            System.out.print("- Ingrese el correo de la persona a modificar: ");
                                            correoBusqueda = leerDatos.nextLine();
                                            encontrado = false;
                                            for(indice = 0; indice < usuarios.getCantidadUsuarios(); indice++){
                                                // BUSCAR COINCIDENCIAS DE USUARIOS REGISTRADOS -> SEGUN EL CORREO INGRESADO
                                                if(correoBusqueda.equals(usuarios.getCorreos(indice))){
                                                    encontrado = true;
                                                    System.out.println("- DATOS ACTUALES");
                                                    System.out.println("- Nombres: "+usuarios.getNombres(indice));
                                                    System.out.println("- Apellidos: "+usuarios.getApellidos(indice));
                                                    System.out.println("- Correo: "+usuarios.getCorreos(indice));
                                                    System.out.println("- Clave: "+usuarios.getClave(indice));
                                                    System.out.println("- Nivel: "+usuarios.getNiveles(indice));
                                                    System.out.println("---------------------------------------------------");
                                                    System.out.println("---------------------------------------------------");
                                                    System.out.println("-");
                                                    System.out.print("- Ingrese el correo del usuario: ");
                                                    correo_usuarios = leerDatos.nextLine();
                                                    // VALIDAR SI CORREO YA EXISTE
                                                    estadoCorreo = usuarios.ValidarCorreo(correo_usuarios);
                                                    if(estadoCorreo){
                                                        System.out.println("- Lo sentimos, este correo ya se encuentra registrado.");
                                                    }else{
                                                        System.out.print("- Ingrese los nombre del usuario: ");
                                                        nombre_usuarios = leerDatos.nextLine();
                                                        System.out.print("- Ingrese los apellidos del usuario: ");
                                                        apellido_usuarios = leerDatos.nextLine();
                                                        System.out.print("- Ingrese la clave del usuario: ");
                                                        clave_usuarios = leerDatos.nextLine();
                                                        System.out.print("- Ingrese la clave nuevamente para confirmar: ");
                                                        String clave_usuarios_confirmar = leerDatos.nextLine();
                                                        int CompararClaves = clave_usuarios.compareTo(clave_usuarios_confirmar);
                                                        if(CompararClaves == 0){
                                                            System.out.println("- NIVELES:");
                                                            System.out.println("- 1. Usuario");
                                                            System.out.println("- 2. Asistente");
                                                            System.out.println("- 1. Administrador");
                                                            System.out.print("- Ingrese el nivel del usuario: ");
                                                            nivel_usuarios = leerDatos.nextInt();
                                                            leerDatos.nextLine();
                                                            if(nivel_usuarios >=1 && nivel_usuarios<=3){
                                                                usuarios.setUsuariosModificar(correo_usuarios, nombre_usuarios, apellido_usuarios, clave_usuarios, nivel_usuarios, indice);
                                                            }else{
                                                                System.out.println("- Lo sentimos, opcion no valida");
                                                            }
                                                        }else{
                                                            System.out.println("- Lo sentimos, las claves ingresadas no coinciden");
                                                        } // CIERRE if(CompararClaves == 0)
                                                    } // CIERRE if(estadoCorreo)
                                                }// CIERRE if(correoBusqueda.equals(usuarios.getCorreos(indice)))                        
                                            }// CIERRE for(indice = 0; indice < usuarios.getCantidadUsuarios(); indice++){
                                            if(encontrado == false){
                                                System.out.println("- Lo sentimos, ese correo no existe");
                                            }
                                            System.out.println("█████████████████████████████████████");
                                            System.out.println("█ ACCION FINALIZADA CON EXITO ");
                                            System.out.println("█ Presione ENTER para continuar...");
                                            System.out.println("█████████████████████████████████████");
                                            new java.util.Scanner(System.in).nextLine();
                                            salida_menuprincipal = false; // NO PERMITIR SALIR A MENU PRINCIPAL
                                            break;
                                        /*
                                            -> MODIFICAR CONTRASEÑAS DE USUARIOS REGISTRADOS
                                        */
                                        case 4:
                                            System.out.println("***************************************************************");
                                            System.out.println("                  PORTAL ASISTENTES");
                                            System.out.println("***************************************************************");
                                            System.out.println("- Modificar clave de acceso de usuarios registrados");
                                            System.out.println("");
                                            System.out.print("- Ingrese el correo de la persona a modificar: ");
                                            correoBusqueda = leerDatos.nextLine();
                                            encontrado = false;
                                            for(indice = 0; indice < usuarios.getCantidadUsuarios(); indice++){
                                                // BUSCAR COINCIDENCIAS DE USUARIOS REGISTRADOS -> SEGUN EL CORREO INGRESADO
                                                if(correoBusqueda.equals(usuarios.getCorreos(indice))){
                                                    encontrado = true;
                                                    System.out.println("- DATOS USUARIO SELECCIONADO");
                                                    System.out.println("- Nombres: "+usuarios.getNombres(indice));
                                                    System.out.println("- Apellidos: "+usuarios.getApellidos(indice));
                                                    System.out.println("- Correo: "+usuarios.getCorreos(indice));
                                                    System.out.println("- Clave: "+usuarios.getClave(indice));
                                                    System.out.println("- Nivel: "+usuarios.getNiveles(indice));
                                                    System.out.println("---------------------------------------------------");
                                                    System.out.println("---------------------------------------------------");
                                                    System.out.print("- Ingrese la clave del usuario: ");
                                                    clave_usuarios = leerDatos.nextLine();
                                                    System.out.print("- Ingrese la clave nuevamente para confirmar: ");
                                                    String clave_usuarios_confirmar = leerDatos.nextLine();
                                                    int CompararClaves = clave_usuarios.compareTo(clave_usuarios_confirmar);
                                                    if(CompararClaves == 0){
                                                        usuarios.setUsuariosModificarClave(clave_usuarios, indice);   
                                                    }else{
                                                        System.out.println("- Lo sentimos, las claves ingresadas no coinciden");
                                                    }// CIERRE if(CompararClaves == 0)
                                                }// CIERRE if(correoBusqueda.equals(usuarios.getCorreos(indice)))
                                            }// CIERRE for(indice = 0; indice < usuarios.getCantidadUsuarios(); indice++)
                                            if(encontrado == false){
                                                System.out.println("- Lo sentimos, ese correo no existe");
                                            }
                                            System.out.println("█████████████████████████████████████");
                                            System.out.println("█ ACCION FINALIZADA CON EXITO ");
                                            System.out.println("█ Presione ENTER para continuar...");
                                            System.out.println("█████████████████████████████████████");
                                            new java.util.Scanner(System.in).nextLine();
                                            salida_menuprincipal = false; // NO PERMITIR SALIR A MENU PRINCIPAL
                                            break;
                                        /*
                                            -> MODIFICAR NIVELES DE USUARIOS REGISTRADOS [ROL DE ACCESO]
                                        */
                                        case 5:
                                            System.out.println("***************************************************************");
                                            System.out.println("                  PORTAL ASISTENTES");
                                            System.out.println("***************************************************************");
                                            System.out.println("- Modificar nivel de acceso de usuarios registrados");
                                            System.out.println("");
                                            System.out.print("- Ingrese el correo de la persona a modificar: ");
                                            correoBusqueda = leerDatos.nextLine();
                                            encontrado = false;
                                            for(indice = 0; indice < usuarios.getCantidadUsuarios(); indice++){
                                                // BUSCAR COINCIDENCIAS DE USUARIOS REGISTRADOS -> SEGUN EL CORREO INGRESADO
                                                if(correoBusqueda.equals(usuarios.getCorreos(indice))){
                                                    encontrado = true;
                                                    System.out.println("- DATOS USUARIO SELECCIONADO");
                                                    System.out.println("- Nombres: "+usuarios.getNombres(indice));
                                                    System.out.println("- Apellidos: "+usuarios.getApellidos(indice));
                                                    System.out.println("- Correo: "+usuarios.getCorreos(indice));
                                                    System.out.println("- Clave: "+usuarios.getClave(indice));
                                                    System.out.println("- Nivel: "+usuarios.getNiveles(indice));
                                                    System.out.println("---------------------------------------------------");
                                                    System.out.println("---------------------------------------------------");
                                                    System.out.print("- Ingrese el nivel del usuario: ");
                                                    nivel_usuarios = leerDatos.nextInt();
                                                    leerDatos.nextLine();
                                                    if(nivel_usuarios >=1 && nivel_usuarios<=3){
                                                        usuarios.setUsuariosModificarRoles(nivel_usuarios, indice);
                                                    }else{
                                                        System.out.println("- Lo sentimos, opcion no valida");
                                                    } // CIERRE if(nivel_usuarios >=1 && nivel_usuarios<=3)
                                                }// CIERRE if(correoBusqueda.equals(usuarios.getCorreos(indice)))
                                            }// CIERRE for(indice = 0; indice < usuarios.getCantidadUsuarios(); indice++)
                                            if(encontrado == false){
                                                System.out.println("- Lo sentimos, ese correo no existe");
                                            }
                                            System.out.println("█████████████████████████████████████");
                                            System.out.println("█ ACCION FINALIZADA CON EXITO ");
                                            System.out.println("█ Presione ENTER para continuar...");
                                            System.out.println("█████████████████████████████████████");
                                            new java.util.Scanner(System.in).nextLine();
                                            salida_menuprincipal = false; // NO PERMITIR SALIR A MENU PRINCIPAL
                                            break;
                                        /*
                                            -> LISTADO DE USUARIOS REGISTRADOS [NIVEL ROL DE ACCESO USUARIO]
                                        */
                                        case 6:
                                            System.out.println("***************************************************************");
                                            System.out.println("                  PORTAL ASISTENTES");
                                            System.out.println("***************************************************************");
                                            System.out.println("- Listado de usuarios registrados [ROL USUARIO]");
                                            // IMPRIMIR USUARIOS
                                            for(indice = 0; indice < usuarios.getCantidadUsuarios(); indice++){
                                                int valorusuario = indice+1; // PARA IGUALAR CONTADOR VISTA USUARIOS [CASO CONTRARIO INICIA CONTEO EN CERO [0]]
                                                if(usuarios.getNiveles(indice) == 1){
                                                    System.out.println("---------------------------------------------------");
                                                    System.out.println("- USUARIO "+ valorusuario +" / "+usuarios.getCantidadUsuarios());
                                                    System.out.println("---------------------------------------------------");
                                                    System.out.println("- Nombres: "+usuarios.getNombres(indice));
                                                    System.out.println("- Apellidos: "+usuarios.getApellidos(indice));
                                                    System.out.println("- Correo: "+usuarios.getCorreos(indice));
                                                    System.out.println("- Clave: "+usuarios.getClave(indice));
                                                    System.out.println("- Nivel: "+usuarios.getNiveles(indice));
                                                    System.out.println("---------------------------------------------------");
                                                    System.out.println("---------------------------------------------------");
                                                }// CIERRE if(usuarios.getNiveles(indice) == 1)
                                            }// CIERRE for(indice = 0; indice < usuarios.getCantidadUsuarios(); indice++){
                                            System.out.println("█████████████████████████████████████");
                                            System.out.println("█ ACCION FINALIZADA CON EXITO ");
                                            System.out.println("█ Presione ENTER para continuar...");
                                            System.out.println("█████████████████████████████████████");
                                            new java.util.Scanner(System.in).nextLine();
                                            salida_menuprincipal = false; // NO PERMITIR SALIR A MENU PRINCIPAL
                                            break;
                                        /*
                                            -> LISTADO DE USUARIOS REGISTRADOS [NIVEL ROL DE ACCESO ASISTENTE]
                                        */
                                        case 7:
                                            System.out.println("***************************************************************");
                                            System.out.println("                  PORTAL ASISTENTES");
                                            System.out.println("***************************************************************");
                                            System.out.println("- Listado de usuarios registrados [ROL ASISTENTE]");
                                            // IMPRIMIR USUARIOS
                                            for(indice = 0; indice < usuarios.getCantidadUsuarios(); indice++){
                                                int valorusuario = indice+1; // PARA IGUALAR CONTADOR VISTA USUARIOS [CASO CONTRARIO INICIA CONTEO EN CERO [0]]
                                                if(usuarios.getNiveles(indice) == 2){
                                                    System.out.println("---------------------------------------------------");
                                                    System.out.println("- USUARIO "+ valorusuario +" / "+usuarios.getCantidadUsuarios());
                                                    System.out.println("---------------------------------------------------");
                                                    System.out.println("- Nombres: "+usuarios.getNombres(indice));
                                                    System.out.println("- Apellidos: "+usuarios.getApellidos(indice));
                                                    System.out.println("- Correo: "+usuarios.getCorreos(indice));
                                                    System.out.println("- Clave: "+usuarios.getClave(indice));
                                                    System.out.println("- Nivel: "+usuarios.getNiveles(indice));
                                                    System.out.println("---------------------------------------------------");
                                                    System.out.println("---------------------------------------------------");
                                                }// CIERRE if(usuarios.getNiveles(indice) == 2)
                                            }// CIERRE for(indice = 0; indice < usuarios.getCantidadUsuarios(); indice++){
                                            System.out.println("█████████████████████████████████████");
                                            System.out.println("█ ACCION FINALIZADA CON EXITO ");
                                            System.out.println("█ Presione ENTER para continuar...");
                                            System.out.println("█████████████████████████████████████");
                                            new java.util.Scanner(System.in).nextLine();
                                            salida_menuprincipal = false; // NO PERMITIR SALIR A MENU PRINCIPAL
                                            break;
                                        /*
                                            -> LISTADO DE USUARIOS REGISTRADOS [NIVEL ROL DE ACCESO ADMINISTRADORES]
                                        */
                                        case 8:
                                            System.out.println("***************************************************************");
                                            System.out.println("                  PORTAL ASISTENTES");
                                            System.out.println("***************************************************************");
                                            System.out.println("- Listado de usuarios registrados [ROL ADMINISTRADORES]");
                                            // IMPRIMIR USUARIOS
                                            for(indice = 0; indice < usuarios.getCantidadUsuarios(); indice++){
                                                int valorusuario = indice+1; // PARA IGUALAR CONTADOR VISTA USUARIOS [CASO CONTRARIO INICIA CONTEO EN CERO [0]]
                                                if(usuarios.getNiveles(indice) == 3){
                                                    System.out.println("---------------------------------------------------");
                                                    System.out.println("- USUARIO "+ valorusuario +" / "+usuarios.getCantidadUsuarios());
                                                    System.out.println("---------------------------------------------------");
                                                    System.out.println("- Nombres: "+usuarios.getNombres(indice));
                                                    System.out.println("- Apellidos: "+usuarios.getApellidos(indice));
                                                    System.out.println("- Correo: "+usuarios.getCorreos(indice));
                                                    System.out.println("- Clave: "+usuarios.getClave(indice));
                                                    System.out.println("- Nivel: "+usuarios.getNiveles(indice));
                                                    System.out.println("---------------------------------------------------");
                                                    System.out.println("---------------------------------------------------");
                                                }// CIERRE if(usuarios.getNiveles(indice) == 3)
                                            }// CIERRE for(indice = 0; indice < usuarios.getCantidadUsuarios(); indice++){
                                            System.out.println("- Presione ENTER para continuar...");
                                            new java.util.Scanner(System.in).nextLine();
                                            salida_menuprincipal = false; // NO PERMITIR SALIR A MENU PRINCIPAL
                                            break;
                                        /*
                                            -> ACERCA DE NOSOTROS
                                        */
                                        case 9:
                                            System.out.println("***************************************************************");
                                            System.out.println("                  PORTAL ASISTENTES");
                                            System.out.println("***************************************************************");
                                            System.out.println("- ACERCA DE NOSOTROS");
                                            System.out.println("- Elias Daniel Martinez Rivera | 27-0077-2019");
                                            System.out.println("- Harold Osmany Garcia Osegueda | 25-3146-2020");
                                            System.out.println("- Roberto Andres Mendez Ortiz | 25-1578-2020");
                                            System.out.println("- Luis Felipe Ramirez Cuellas | 25-2324-2001");
                                            System.out.println("- Eldin Okely Rosales Garcia | 25-4113-2020");
                                            System.out.println("█████████████████████████████████████");
                                            System.out.println("█ ACCION FINALIZADA CON EXITO ");
                                            System.out.println("█ Presione ENTER para continuar...");
                                            System.out.println("█████████████████████████████████████");
                                            new java.util.Scanner(System.in).nextLine();
                                            salida_menuprincipal = false; // NO PERMITIR SALIR A MENU PRINCIPAL
                                            break;
                                        /*
                                            -> CERRAR SESION USUARIOS
                                        */
                                        case 10: 
                                            leerDatos.nextLine(); // LIMPIEZA DE BUFER
                                            salida_menuprincipal = true; // SALIR A MENU PRINCIPAL
                                            conteo_cierresesiones++; // CONTADOR DE CIERRE DE SESIONES
                                            // SI CONTADOR DE INTENTOS ES IGUAL A TRES [3] -> POR SEGURIDAD FINALIZA EJECUCION DE SISTEAMA AL CERRAR SESION
                                            if(contador_intentos == 3){
                                                System.out.println("***************************************************************");
                                                System.out.println("***************************************************************");
                                                System.out.println("- Usted ha tenido dos errores al momento de iniciar sesión en");
                                                System.out.println("  nuestro sistema. Por seguridad hemos finalizado la ejecución");
                                                System.out.println("  de la aplicación. No se preocupe puede iniciarla nuevamente");
                                                System.out.println("  e ingresar sus credenciales.");
                                            }// CIERRE if(contador_intentos == 3)
                                            break;
                                        /*
                                            -> SALIR COMPLETAMENTE DE LA APLICACION
                                        */
                                        case 11:
                                            System.exit(0);
                                            break;
                                        /*
                                            -> OPCIONES INVALIDAS -> MENSAJE ERROR
                                        */
                                        default:
                                            System.out.println("- Opción de menú incorrecta. Intente otra vez...");
                                            break;
                                    }// CIERRE switch(opcion_menuprincipal)
                                }while(!salida_menuprincipal); // CIERRE }while(!salida_menuprincipal);
                            }catch(Exception e){
                                System.out.println("- Solamente debe ingresar valores numericos...");
                                salida_menuprincipal = false; // NO PERMITIR SALIR A MENU PRINCIPAL
                                leerDatos.nextLine(); // LIMPIEZA DE BUFER
                                break; // SI INGRESA UN VALOR DIFERENTE AL ESTABLECIDO, SIMPLEMENTE TERMINA EJECUCION
                            } // CIERRE TRY CATCH
                        }else{
                            System.out.println("- Lo sentimos usuario y/o contraseña inválidos... Intente otra vez.");
                        }
                    }// CIERRE for(contador_intentos = 1; contador_intentos < 4; contador_intentos++)
                }// CIERRE if(tiporolusuario==2)
                
                
                /*
                    -> ROL DE ACCESO ADMINISTRADORES
                */
                
                
                if(tiporolusuario==3){
                    // INGRESO DE CREDENCIALES USUARIOS
                    for(contador_intentos = 1; contador_intentos < 4; contador_intentos++){
                        // CONTADOR DE CIERRE DE SESIONES
                        /*
                            ***********************************************************************************************
                            -> ESTO CON EN FIN DE REESTABLECER EL VALOR DEL CONTADOR DE INTENTOS MIENTRAS NO SEA IGUAL A 3
                               CASO CONTRARIO EL SISTEMA ESTA VALIDADO PARA FINALIZAR LA EJECUCION AL MOMENTO DE CERRAR
                               SESION SI EL CONTADOR DE INTENTOS ES IGUAL A TRES [3]
                            ***********************************************************************************************
                        */
                        if(conteo_cierresesiones > 1){
                            contador_intentos = 1;
                        } // CIERRE if(conteo_cierresesiones > 1)
                        System.out.printf("|%4s%2s%2s|%n", "INTENTO --> ", contador_intentos, " / 3");
                        System.out.print("- Estimado usuario(a), ingrese su correo de usuario: ");
                        usuario = leerDatos.nextLine();
                        System.out.print("- Estimado usuario(a), ingrese su contraseña: ");
                        contrasenia = leerDatos.nextLine();
                        boolean ValidarCredenciales = usuarios.IniciarSesion(usuario, contrasenia);
                        // EFECTO CARGA ESPERE UN MOMENTO
                        System.out.print("- Espere un momento");
                        for(barra_espera=0; barra_espera<6; barra_espera++){
                            System.out.print(".");
                            Thread.sleep(500);
                        }
                        System.out.println("");
                        if(ValidarCredenciales){ // SI CREDENCIALES SON COINCIDENTES A REGISTROS = TRUE [INICIO DE SESION EXITOSO]
                            try{
                                do{
                                    retorno_errores = true;
                                    System.out.println("***************************************************************");
                                    System.out.println("                  PORTAL ADMINISTRADORES");
                                    System.out.println("***************************************************************");
                                    System.out.println("- Bienvenido(a). Por favor elija una opción:");
                                    System.out.println("- 1. Listado de Usuarios ");
                                    System.out.println("- 2. Agregar Usuarios ");
                                    System.out.println("- 3. Buscar Usuarios ");
                                    System.out.println("- 4. Eliminar Usuarios ");
                                    System.out.println("- 5. Editar Usuarios ");
                                    System.out.println("- 6. Cambiar Contraseña de Usuarios ");
                                    System.out.println("- 7. Cambiar Niveles de Usuarios ");
                                    System.out.println("- 8. Listado de Usuarios Nivel Usuario ");
                                    System.out.println("- 9. Listado de Usuarios Nivel Asistente ");
                                    System.out.println("- 10. Listado de Usuarios Nivel Administradores ");
                                    System.out.println("- 11. Acerca De ");
                                    System.out.println("- 12. Cerrar Sesion ");
                                    System.out.println("- 13. Salir del Sistema ");
                                    System.out.print("-         -> Su opción: ");
                                    opcion_menuprincipal = leerDatos.nextInt();
                                    leerDatos.nextLine(); // LIMPIEZA DE BUFER
                                    /*
                                        -> NAVEGACION EN MENU DE SISTEMA SEGUN OPCION INGRESADA POR USUARIOS
                                    */
                                    switch(opcion_menuprincipal){
                                        /*
                                            -> LISTADO DE USUARIOS REGISTRADOS [GENERAL]
                                        */
                                        case 1:
                                            System.out.println("***************************************************************");
                                            System.out.println("                  PORTAL ADMINISTRADORES");
                                            System.out.println("***************************************************************");
                                            System.out.println("- Listado de usuarios registrados");
                                            // IMPRIMIR USUARIOS
                                            for(indice = 0; indice < usuarios.getCantidadUsuarios(); indice++){
                                                int valorusuario = indice+1;
                                                //if(usuarios.getNiveles(indice) == 3){
                                                System.out.println("---------------------------------------------------");
                                                System.out.println("- USUARIO "+ valorusuario +" / "+usuarios.getCantidadUsuarios());
                                                System.out.println("---------------------------------------------------");
                                                System.out.println("- Nombres: "+usuarios.getNombres(indice));
                                                System.out.println("- Apellidos: "+usuarios.getApellidos(indice));
                                                System.out.println("- Correo: "+usuarios.getCorreos(indice));
                                                System.out.println("- Clave: "+usuarios.getClave(indice));
                                                System.out.println("- Nivel: "+usuarios.getNiveles(indice));
                                                System.out.println("---------------------------------------------------");
                                                System.out.println("---------------------------------------------------");
                                                //}
                                            }// CIERRE for(indice = 0; indice < usuarios.getCantidadUsuarios(); indice++){
                                            System.out.println("█████████████████████████████████████");
                                            System.out.println("█ ACCION FINALIZADA CON EXITO ");
                                            System.out.println("█ Presione ENTER para continuar...");
                                            System.out.println("█████████████████████████████████████");
                                            new java.util.Scanner(System.in).nextLine();
                                            salida_menuprincipal = false; // NO PERMITIR SALIR A MENU PRINCIPAL
                                            break;
                                        /*
                                            -> REGISTRO DE NUEVOS USUARIOS
                                        */
                                        case 2:
                                            System.out.println("***************************************************************");
                                            System.out.println("                  PORTAL ADMINISTRADORES");
                                            System.out.println("***************************************************************");
                                            System.out.println("- Registro de nuevos usuarios");
                                            System.out.print("- Ingrese el correo del usuario: ");
                                            correo_usuarios = leerDatos.nextLine();
                                            // VALIDAR SI CORREO YA EXISTE
                                            estadoCorreo = usuarios.ValidarCorreo(correo_usuarios);
                                            if(estadoCorreo){
                                                System.out.println("- Lo sentimos, este correo ya se encuentra registrado.");
                                            }else{
                                                System.out.print("- Ingrese los nombre del usuario: ");
                                                nombre_usuarios = leerDatos.nextLine();
                                                System.out.print("- Ingrese los apellidos del usuario: ");
                                                apellido_usuarios = leerDatos.nextLine();
                                                System.out.print("- Ingrese la clave del usuario: ");
                                                clave_usuarios = leerDatos.nextLine();
                                                System.out.print("- Ingrese la clave nuevamente para confirmar: ");
                                                String clave_usuarios_confirmar = leerDatos.nextLine();
                                                int CompararClaves = clave_usuarios.compareTo(clave_usuarios_confirmar);
                                                if(CompararClaves == 0){
                                                    System.out.println("- NIVELES:");
                                                    System.out.println("- 1. Usuario");
                                                    System.out.println("- 2. Asistente");
                                                    System.out.println("- 3. Administrador");
                                                    System.out.print("- Ingrese el nivel del usuario: ");
                                                    nivel_usuarios = leerDatos.nextInt();
                                                    leerDatos.nextLine();
                                                    if(nivel_usuarios >=1 && nivel_usuarios<=3){
                                                        usuarios.setRegistroNuevosUsuarios(correo_usuarios, nombre_usuarios, apellido_usuarios, clave_usuarios, nivel_usuarios);
                                                    }else{
                                                        System.out.println("- Lo sentimos, opcion no valida");
                                                    }// CIERRE if(CompararClaves == 0)
                                                }else{
                                                    System.out.println("- Lo sentimos, las claves ingresadas no coinciden");
                                                }
                                            }// CIERRE if(estadoCorreo)
                                            System.out.println("█████████████████████████████████████");
                                            System.out.println("█ ACCION FINALIZADA CON EXITO ");
                                            System.out.println("█ Presione ENTER para continuar...");
                                            System.out.println("█████████████████████████████████████");
                                            new java.util.Scanner(System.in).nextLine();
                                            salida_menuprincipal = false; // NO PERMITIR SALIR A MENU PRINCIPAL
                                            break;
                                        /*
                                            -> BUSQUEDA DE USUARIOS REGISTRADOS
                                        */
                                        case 3:
                                            System.out.println("***************************************************************");
                                            System.out.println("                  PORTAL ADMINISTRADORES");
                                            System.out.println("***************************************************************");
                                            System.out.println("- Busqueda de usuarios registrados");
                                            System.out.print("- Ingrese el correo de la persona a buscar: ");
                                            correoBusqueda = leerDatos.nextLine();
                                            encontrado = false;
                                            for(indice = 0; indice < usuarios.getCantidadUsuarios(); indice++){
                                                // BUSCAR COINCIDENCIAS DE USUARIOS REGISTRADOS -> SEGUN EL CORREO INGRESADO
                                                if(correoBusqueda.equals(usuarios.getCorreos(indice))){
                                                    encontrado = true;
                                                    System.out.println("---------------------------------------------------");
                                                    System.out.println("- DATOS DE USUARIO SELECCIONADO");
                                                    System.out.println("---------------------------------------------------");
                                                    System.out.println("- Nombres: "+usuarios.getNombres(indice));
                                                    System.out.println("- Apellidos: "+usuarios.getApellidos(indice));
                                                    System.out.println("- Correo: "+usuarios.getCorreos(indice));
                                                    System.out.println("- Clave: "+usuarios.getClave(indice));
                                                    System.out.println("- Nivel: "+usuarios.getNiveles(indice));
                                                    System.out.println("---------------------------------------------------");
                                                    System.out.println("---------------------------------------------------");
                                                }
                                            }// CIERRE for(indice = 0; indice < usuarios.getCantidadUsuarios(); indice++)
                                            if(encontrado == false){
                                                System.out.println("- Lo sentimos, no hemos encontrado datos coincidentes");
                                            }
                                            System.out.println("█████████████████████████████████████");
                                            System.out.println("█ ACCION FINALIZADA CON EXITO ");
                                            System.out.println("█ Presione ENTER para continuar...");
                                            System.out.println("█████████████████████████████████████");
                                            new java.util.Scanner(System.in).nextLine();
                                            salida_menuprincipal = false; // NO PERMITIR SALIR A MENU PRINCIPAL
                                            break;
                                         /*
                                            -> ELIMINAR USUARIOS REGISTRADOS
                                        */
                                        case 4:
                                            System.out.println("***************************************************************");
                                            System.out.println("                  PORTAL ADMINISTRADORES");
                                            System.out.println("***************************************************************");
                                            System.out.println("- Eliminar usuarios registrados");
                                            System.out.print("- Ingrese el correo de la persona a eliminar: ");
                                            correoBusqueda = leerDatos.nextLine();
                                            encontrado = false;
                                            for(indice = 0; indice < usuarios.getCantidadUsuarios(); indice++){
                                                // BUSCAR COINCIDENCIAS DE USUARIOS REGISTRADOS -> SEGUN EL CORREO INGRESADO
                                                if(correoBusqueda.equals(usuarios.getCorreos(indice))){
                                                    encontrado = true;
                                                    usuarios.setUsuariosEliminar(correo_usuarios, nombre_usuarios, apellido_usuarios, clave_usuarios, nivel_usuarios, indice);
                                                }// CIERRE if(correoBusqueda.equals(usuarios.getCorreos(indice)))
                                            }// CIERRE for(indice = 0; indice < usuarios.getCantidadUsuarios(); indice++)
                                            if(encontrado == false){
                                                System.out.println("- Lo sentimos, no hemos encontrado datos coincidentes");
                                            }
                                            System.out.println("█████████████████████████████████████");
                                            System.out.println("█ ACCION FINALIZADA CON EXITO ");
                                            System.out.println("█ Presione ENTER para continuar...");
                                            System.out.println("█████████████████████████████████████");
                                            new java.util.Scanner(System.in).nextLine();
                                            salida_menuprincipal = false; // NO PERMITIR SALIR A MENU PRINCIPAL
                                            break;
                                        /*
                                            -> MODIFICAR USUARIOS REGISTRADOS
                                        */
                                        case 5:
                                            System.out.println("***************************************************************");
                                            System.out.println("                  PORTAL ADMINISTRADORES");
                                            System.out.println("***************************************************************");
                                            System.out.println("- Modificar datos de usuarios registrados");
                                            System.out.println("");
                                            System.out.print("- Ingrese el correo de la persona a modificar: ");
                                            correoBusqueda = leerDatos.nextLine();
                                            encontrado = false;
                                            for(indice = 0; indice < usuarios.getCantidadUsuarios(); indice++){
                                                // BUSCAR COINCIDENCIAS DE USUARIOS REGISTRADOS -> SEGUN EL CORREO INGRESADO
                                                if(correoBusqueda.equals(usuarios.getCorreos(indice))){
                                                    encontrado = true;
                                                    System.out.println("- DATOS ACTUALES");
                                                    System.out.println("- Nombres: "+usuarios.getNombres(indice));
                                                    System.out.println("- Apellidos: "+usuarios.getApellidos(indice));
                                                    System.out.println("- Correo: "+usuarios.getCorreos(indice));
                                                    System.out.println("- Clave: "+usuarios.getClave(indice));
                                                    System.out.println("- Nivel: "+usuarios.getNiveles(indice));
                                                    System.out.println("---------------------------------------------------");
                                                    System.out.println("---------------------------------------------------");
                                                    System.out.println("-");
                                                    System.out.print("- Ingrese el correo del usuario: ");
                                                    correo_usuarios = leerDatos.nextLine();
                                                    // VALIDAR SI CORREO YA EXISTE
                                                    estadoCorreo = usuarios.ValidarCorreo(correo_usuarios);
                                                    if(estadoCorreo){
                                                        System.out.println("- Lo sentimos, este correo ya se encuentra registrado.");
                                                    }else{
                                                        System.out.print("- Ingrese los nombre del usuario: ");
                                                        nombre_usuarios = leerDatos.nextLine();
                                                        System.out.print("- Ingrese los apellidos del usuario: ");
                                                        apellido_usuarios = leerDatos.nextLine();
                                                        System.out.print("- Ingrese la clave del usuario: ");
                                                        clave_usuarios = leerDatos.nextLine();
                                                        System.out.print("- Ingrese la clave nuevamente para confirmar: ");
                                                        String clave_usuarios_confirmar = leerDatos.nextLine();
                                                        int CompararClaves = clave_usuarios.compareTo(clave_usuarios_confirmar);
                                                        if(CompararClaves == 0){
                                                            System.out.println("- NIVELES:");
                                                            System.out.println("- 1. Usuario");
                                                            System.out.println("- 2. Asistente");
                                                            System.out.println("- 1. Administrador");
                                                            System.out.print("- Ingrese el nivel del usuario: ");
                                                            nivel_usuarios = leerDatos.nextInt();
                                                            leerDatos.nextLine();
                                                            if(nivel_usuarios >=1 && nivel_usuarios<=3){
                                                                usuarios.setUsuariosModificar(correo_usuarios, nombre_usuarios, apellido_usuarios, clave_usuarios, nivel_usuarios, indice);
                                                            }else{
                                                                System.out.println("- Lo sentimos, opcion no valida");
                                                            }
                                                        }else{
                                                            System.out.println("- Lo sentimos, las claves ingresadas no coinciden");
                                                        } // CIERRE if(CompararClaves == 0)
                                                    } // CIERRE if(estadoCorreo)
                                                }// CIERRE if(correoBusqueda.equals(usuarios.getCorreos(indice)))                        
                                            }// CIERRE for(indice = 0; indice < usuarios.getCantidadUsuarios(); indice++){
                                            if(encontrado == false){
                                                System.out.println("- Lo sentimos, ese correo no existe");
                                            }
                                            System.out.println("█████████████████████████████████████");
                                            System.out.println("█ ACCION FINALIZADA CON EXITO ");
                                            System.out.println("█ Presione ENTER para continuar...");
                                            System.out.println("█████████████████████████████████████");
                                            new java.util.Scanner(System.in).nextLine();
                                            salida_menuprincipal = false; // NO PERMITIR SALIR A MENU PRINCIPAL
                                            break;
                                        /*
                                            -> MODIFICAR CONTRASEÑAS DE USUARIOS REGISTRADOS
                                        */
                                        case 6:
                                            System.out.println("***************************************************************");
                                            System.out.println("                  PORTAL ADMINISTRADORES");
                                            System.out.println("***************************************************************");
                                            System.out.println("- Modificar clave de acceso de usuarios registrados");
                                            System.out.println("");
                                            System.out.print("- Ingrese el correo de la persona a modificar: ");
                                            correoBusqueda = leerDatos.nextLine();
                                            encontrado = false;
                                            for(indice = 0; indice < usuarios.getCantidadUsuarios(); indice++){
                                                // BUSCAR COINCIDENCIAS DE USUARIOS REGISTRADOS -> SEGUN EL CORREO INGRESADO
                                                if(correoBusqueda.equals(usuarios.getCorreos(indice))){
                                                    encontrado = true;
                                                    System.out.println("- DATOS USUARIO SELECCIONADO");
                                                    System.out.println("- Nombres: "+usuarios.getNombres(indice));
                                                    System.out.println("- Apellidos: "+usuarios.getApellidos(indice));
                                                    System.out.println("- Correo: "+usuarios.getCorreos(indice));
                                                    System.out.println("- Clave: "+usuarios.getClave(indice));
                                                    System.out.println("- Nivel: "+usuarios.getNiveles(indice));
                                                    System.out.println("---------------------------------------------------");
                                                    System.out.println("---------------------------------------------------");
                                                    System.out.print("- Ingrese la clave del usuario: ");
                                                    clave_usuarios = leerDatos.nextLine();
                                                    System.out.print("- Ingrese la clave nuevamente para confirmar: ");
                                                    String clave_usuarios_confirmar = leerDatos.nextLine();
                                                    int CompararClaves = clave_usuarios.compareTo(clave_usuarios_confirmar);
                                                    if(CompararClaves == 0){
                                                        usuarios.setUsuariosModificarClave(clave_usuarios, indice);   
                                                    }else{
                                                        System.out.println("- Lo sentimos, las claves ingresadas no coinciden");
                                                    }// CIERRE if(CompararClaves == 0)
                                                }// CIERRE if(correoBusqueda.equals(usuarios.getCorreos(indice)))
                                            }// CIERRE for(indice = 0; indice < usuarios.getCantidadUsuarios(); indice++)
                                            if(encontrado == false){
                                                System.out.println("- Lo sentimos, ese correo no existe");
                                            }
                                            System.out.println("█████████████████████████████████████");
                                            System.out.println("█ ACCION FINALIZADA CON EXITO ");
                                            System.out.println("█ Presione ENTER para continuar...");
                                            System.out.println("█████████████████████████████████████");
                                            new java.util.Scanner(System.in).nextLine();
                                            salida_menuprincipal = false; // NO PERMITIR SALIR A MENU PRINCIPAL
                                            break;
                                        /*
                                            -> MODIFICAR NIVELES DE USUARIOS REGISTRADOS [ROL DE ACCESO]
                                        */
                                        case 7:
                                            System.out.println("***************************************************************");
                                            System.out.println("                  PORTAL ADMINISTRADORES");
                                            System.out.println("***************************************************************");
                                            System.out.println("- Modificar nivel de acceso de usuarios registrados");
                                            System.out.println("");
                                            System.out.print("- Ingrese el correo de la persona a modificar: ");
                                            correoBusqueda = leerDatos.nextLine();
                                            encontrado = false;
                                            for(indice = 0; indice < usuarios.getCantidadUsuarios(); indice++){
                                                // BUSCAR COINCIDENCIAS DE USUARIOS REGISTRADOS -> SEGUN EL CORREO INGRESADO
                                                if(correoBusqueda.equals(usuarios.getCorreos(indice))){
                                                    encontrado = true;
                                                    System.out.println("- DATOS USUARIO SELECCIONADO");
                                                    System.out.println("- Nombres: "+usuarios.getNombres(indice));
                                                    System.out.println("- Apellidos: "+usuarios.getApellidos(indice));
                                                    System.out.println("- Correo: "+usuarios.getCorreos(indice));
                                                    System.out.println("- Clave: "+usuarios.getClave(indice));
                                                    System.out.println("- Nivel: "+usuarios.getNiveles(indice));
                                                    System.out.println("---------------------------------------------------");
                                                    System.out.println("---------------------------------------------------");
                                                    System.out.print("- Ingrese el nivel del usuario: ");
                                                    nivel_usuarios = leerDatos.nextInt();
                                                    leerDatos.nextLine();
                                                    if(nivel_usuarios >=1 && nivel_usuarios<=3){
                                                        usuarios.setUsuariosModificarRoles(nivel_usuarios, indice);
                                                    }else{
                                                        System.out.println("- Lo sentimos, opcion no valida");
                                                    } // CIERRE if(nivel_usuarios >=1 && nivel_usuarios<=3)
                                                }// CIERRE if(correoBusqueda.equals(usuarios.getCorreos(indice)))
                                            }// CIERRE for(indice = 0; indice < usuarios.getCantidadUsuarios(); indice++)
                                            if(encontrado == false){
                                                System.out.println("- Lo sentimos, ese correo no existe");
                                            }
                                            System.out.println("█████████████████████████████████████");
                                            System.out.println("█ ACCION FINALIZADA CON EXITO ");
                                            System.out.println("█ Presione ENTER para continuar...");
                                            System.out.println("█████████████████████████████████████");
                                            new java.util.Scanner(System.in).nextLine();
                                            salida_menuprincipal = false; // NO PERMITIR SALIR A MENU PRINCIPAL
                                            break;
                                        /*
                                            -> LISTADO DE USUARIOS REGISTRADOS [NIVEL ROL DE ACCESO USUARIO]
                                        */
                                        case 8:
                                            System.out.println("***************************************************************");
                                            System.out.println("                  PORTAL ADMINISTRADORES");
                                            System.out.println("***************************************************************");
                                            System.out.println("- Listado de usuarios registrados [ROL USUARIO]");
                                            // IMPRIMIR USUARIOS
                                            for(indice = 0; indice < usuarios.getCantidadUsuarios(); indice++){
                                                int valorusuario = indice+1; // PARA IGUALAR CONTADOR VISTA USUARIOS [CASO CONTRARIO INICIA CONTEO EN CERO [0]]
                                                if(usuarios.getNiveles(indice) == 1){
                                                    System.out.println("---------------------------------------------------");
                                                    System.out.println("- USUARIO "+ valorusuario +" / "+usuarios.getCantidadUsuarios());
                                                    System.out.println("---------------------------------------------------");
                                                    System.out.println("- Nombres: "+usuarios.getNombres(indice));
                                                    System.out.println("- Apellidos: "+usuarios.getApellidos(indice));
                                                    System.out.println("- Correo: "+usuarios.getCorreos(indice));
                                                    System.out.println("- Clave: "+usuarios.getClave(indice));
                                                    System.out.println("- Nivel: "+usuarios.getNiveles(indice));
                                                    System.out.println("---------------------------------------------------");
                                                    System.out.println("---------------------------------------------------");
                                                }// CIERRE if(usuarios.getNiveles(indice) == 1)
                                            }// CIERRE for(indice = 0; indice < usuarios.getCantidadUsuarios(); indice++){
                                            System.out.println("█████████████████████████████████████");
                                            System.out.println("█ ACCION FINALIZADA CON EXITO ");
                                            System.out.println("█ Presione ENTER para continuar...");
                                            System.out.println("█████████████████████████████████████");
                                            new java.util.Scanner(System.in).nextLine();
                                            salida_menuprincipal = false; // NO PERMITIR SALIR A MENU PRINCIPAL
                                            break;
                                        /*
                                            -> LISTADO DE USUARIOS REGISTRADOS [NIVEL ROL DE ACCESO ASISTENTE]
                                        */
                                        case 9:
                                            System.out.println("***************************************************************");
                                            System.out.println("                  PORTAL ADMINISTRADORES");
                                            System.out.println("***************************************************************");
                                            System.out.println("- Listado de usuarios registrados [ROL ASISTENTE]");
                                            // IMPRIMIR USUARIOS
                                            for(indice = 0; indice < usuarios.getCantidadUsuarios(); indice++){
                                                int valorusuario = indice+1; // PARA IGUALAR CONTADOR VISTA USUARIOS [CASO CONTRARIO INICIA CONTEO EN CERO [0]]
                                                if(usuarios.getNiveles(indice) == 2){
                                                    System.out.println("---------------------------------------------------");
                                                    System.out.println("- USUARIO "+ valorusuario +" / "+usuarios.getCantidadUsuarios());
                                                    System.out.println("---------------------------------------------------");
                                                    System.out.println("- Nombres: "+usuarios.getNombres(indice));
                                                    System.out.println("- Apellidos: "+usuarios.getApellidos(indice));
                                                    System.out.println("- Correo: "+usuarios.getCorreos(indice));
                                                    System.out.println("- Clave: "+usuarios.getClave(indice));
                                                    System.out.println("- Nivel: "+usuarios.getNiveles(indice));
                                                    System.out.println("---------------------------------------------------");
                                                    System.out.println("---------------------------------------------------");
                                                }// CIERRE if(usuarios.getNiveles(indice) == 2)
                                            }// CIERRE for(indice = 0; indice < usuarios.getCantidadUsuarios(); indice++){
                                            System.out.println("█████████████████████████████████████");
                                            System.out.println("█ ACCION FINALIZADA CON EXITO ");
                                            System.out.println("█ Presione ENTER para continuar...");
                                            System.out.println("█████████████████████████████████████");
                                            new java.util.Scanner(System.in).nextLine();
                                            salida_menuprincipal = false; // NO PERMITIR SALIR A MENU PRINCIPAL
                                            break;
                                        /*
                                            -> LISTADO DE USUARIOS REGISTRADOS [NIVEL ROL DE ACCESO ADMINISTRADORES]
                                        */
                                        case 10:
                                            System.out.println("***************************************************************");
                                            System.out.println("                  PORTAL ADMINISTRADORES");
                                            System.out.println("***************************************************************");
                                            System.out.println("- Listado de usuarios registrados [ROL ADMINISTRADORES]");
                                            // IMPRIMIR USUARIOS
                                            for(indice = 0; indice < usuarios.getCantidadUsuarios(); indice++){
                                                int valorusuario = indice+1; // PARA IGUALAR CONTADOR VISTA USUARIOS [CASO CONTRARIO INICIA CONTEO EN CERO [0]]
                                                if(usuarios.getNiveles(indice) == 3){
                                                    System.out.println("---------------------------------------------------");
                                                    System.out.println("- USUARIO "+ valorusuario +" / "+usuarios.getCantidadUsuarios());
                                                    System.out.println("---------------------------------------------------");
                                                    System.out.println("- Nombres: "+usuarios.getNombres(indice));
                                                    System.out.println("- Apellidos: "+usuarios.getApellidos(indice));
                                                    System.out.println("- Correo: "+usuarios.getCorreos(indice));
                                                    System.out.println("- Clave: "+usuarios.getClave(indice));
                                                    System.out.println("- Nivel: "+usuarios.getNiveles(indice));
                                                    System.out.println("---------------------------------------------------");
                                                    System.out.println("---------------------------------------------------");
                                                }// CIERRE if(usuarios.getNiveles(indice) == 3)
                                            }// CIERRE for(indice = 0; indice < usuarios.getCantidadUsuarios(); indice++){
                                            System.out.println("█████████████████████████████████████");
                                            System.out.println("█ ACCION FINALIZADA CON EXITO ");
                                            System.out.println("█ Presione ENTER para continuar...");
                                            System.out.println("█████████████████████████████████████");
                                            new java.util.Scanner(System.in).nextLine();
                                            salida_menuprincipal = false; // NO PERMITIR SALIR A MENU PRINCIPAL
                                            break;
                                        /*
                                            -> ACERCA DE NOSOTROS
                                        */
                                        case 11:
                                            System.out.println("***************************************************************");
                                            System.out.println("                  PORTAL ASISTENTES");
                                            System.out.println("***************************************************************");
                                            System.out.println("- ACERCA DE NOSOTROS");
                                            System.out.println("- Elias Daniel Martinez Rivera | 27-0077-2019");
                                            System.out.println("- Harold Osmany Garcia Osegueda | 25-3146-2020");
                                            System.out.println("- Roberto Andres Mendez Ortiz | 25-1578-2020");
                                            System.out.println("- Luis Felipe Ramirez Cuellas | 25-2324-2001");
                                            System.out.println("- Eldin Okely Rosales Garcia | 25-4113-2020");
                                            System.out.println("█████████████████████████████████████");
                                            System.out.println("█ ACCION FINALIZADA CON EXITO ");
                                            System.out.println("█ Presione ENTER para continuar...");
                                            System.out.println("█████████████████████████████████████");
                                            new java.util.Scanner(System.in).nextLine();
                                            salida_menuprincipal = false; // NO PERMITIR SALIR A MENU PRINCIPAL
                                            break;
                                        /*
                                            -> CERRAR SESION USUARIOS
                                        */
                                        case 12: 
                                            leerDatos.nextLine(); // LIMPIEZA DE BUFER
                                            salida_menuprincipal = true; // SALIR A MENU PRINCIPAL
                                            conteo_cierresesiones++; // CONTADOR DE CIERRE DE SESIONES
                                            // SI CONTADOR DE INTENTOS ES IGUAL A TRES [3] -> POR SEGURIDAD FINALIZA EJECUCION DE SISTEAMA AL CERRAR SESION
                                            if(contador_intentos == 3){
                                                System.out.println("***************************************************************");
                                                System.out.println("***************************************************************");
                                                System.out.println("- Usted ha tenido dos errores al momento de iniciar sesión en");
                                                System.out.println("  nuestro sistema. Por seguridad hemos finalizado la ejecución");
                                                System.out.println("  de la aplicación. No se preocupe puede iniciarla nuevamente");
                                                System.out.println("  e ingresar sus credenciales.");
                                            }// CIERRE if(contador_intentos == 3)
                                            break;
                                        /*
                                            -> SALIR COMPLETAMENTE DE LA APLICACION
                                        */
                                        case 13:
                                            System.exit(0);
                                            break;
                                        /*
                                            -> OPCIONES INVALIDAS -> MENSAJE ERROR
                                        */
                                        default:
                                            System.out.println("- Opción de menú incorrecta. Intente otra vez...");
                                            salida_menuprincipal = false; // NO PERMITIR SALIR A MENU PRINCIPAL
                                            break;
                                    }// CIERRE switch(opcion_menuprincipal)
                                }while(!salida_menuprincipal); // CIERRE }while(!salida_menuprincipal);
                            }catch(Exception e){
                                System.out.println("- Solamente debe ingresar valores numericos...");
                                salida_menuprincipal = false; // NO PERMITIR SALIR A MENU PRINCIPAL
                                leerDatos.nextLine(); // LIMPIEZA DE BUFER
                                break; // SI INGRESA UN VALOR DIFERENTE AL ESTABLECIDO, SIMPLEMENTE TERMINA EJECUCION
                            } // CIERRE TRY CATCH
                        }else{
                            System.out.println("- Lo sentimos usuario y/o contraseña inválidos... Intente otra vez.");
                        }
                    }// CIERRE for(contador_intentos = 1; contador_intentos < 4; contador_intentos++)
                }// CIERRE if(tiporolusuario==3)
            }else{
                System.out.println("- Lo sentimos, rol de usuario no valido...");
            }// CIERRE if(tiporolusuario >=1 && tiporolusuario<=3)
        }catch(Exception e){
            System.out.println("- Solamente debe ingresar valores numericos...");
        }// CIERRE TRY CATCH
    } // CIERRE public static void main(String[] args)
}// CIERRE public class LaboratorioDos
