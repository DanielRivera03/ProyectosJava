package parcialdos;

import java.util.Scanner;

public class ParcialDos {
    public static void main(String[] args) throws InterruptedException {
        /*
            -> LECTURA DE DATOS SCANNER
        */
         Scanner leerDatos = new Scanner(System.in);
        /*
            -> VARIABLES GLOBALES
        */
        String usuario="", contrasenia = "", correo_usuarios = "", nombre_usuarios = "", apellido_usuarios="", clave_usuarios="", correoBusqueda = "";
        int tiporolusuario = 0,  contador_intentos = 1, conteo_cierresesiones = 1, barra_espera = 0, opcion_menuprincipal = 0, indice = 0, nivel_usuarios = 0, respuesta_salida=0;
        boolean salida_menuprincipal = false, retorno_errores = false, estadoCorreo = false, encontrado=false;
        // INSTANCIA DE CLASE USUARIOS
        Usuarios usuarios = new Usuarios();
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
                                   System.out.println("***************************************************************");
                                    System.out.println("                  PORTAL USUARIO");
                                    System.out.println("***************************************************************");
                                    System.out.println("- Bienvenido(a)" + correo_usuarios + " Por favor elija una opción:");
                                    System.out.println("- 1. Listado de Usuarios [DESC]");
                                    System.out.println("- 2. Registrar Usuarios ");
                                    System.out.println("- 3. Buscar Usuarios");
                                    System.out.println("- 4. Salir del Sistema Completamente");
                                    System.out.print("-         -> Su opción: ");
                                    opcion_menuprincipal = leerDatos.nextInt();
                                    leerDatos.nextLine(); // LIMPIEZA DE BUFER 
                                    /*
                                        -> NAVEGACION EN MENU DE SISTEMA SEGUN OPCION INGRESADA POR USUARIOS
                                    */
                                    switch(opcion_menuprincipal){
                                        /*
                                            -> LISTADO DE USUARIOS
                                        */
                                        case 1:
                                            System.out.println("***************************************************************");
                                            System.out.println("                  PORTAL USUARIO");
                                            System.out.println("***************************************************************");
                                            System.out.println("- Listado de usuarios registrados");
                                            // IMPRIMIR USUARIOS
                                            for(indice = 0; indice < usuarios.getCantidadUsuarios(); indice++){
                                            //for(indice = usuarios.getCantidadUsuarios(); indice >= usuarios.getCantidadUsuarios(); indice--){
                                                int valorusuario = indice;
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
                                            -> REGISTRAR USUARIOS
                                        */
                                        case 2:
                                            System.out.println("***************************************************************");
                                            System.out.println("                  PORTAL USUARIO");
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
                                            -> BUSCAR USUARIOS
                                        */
                                        case 3:
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
                                            -> SALIR DEL SISTEMA
                                        */
                                        case 4:
                                            System.out.println("***************************************************************");
                                            System.out.println("                  PORTAL USUARIO");
                                            System.out.println("***************************************************************");
                                            System.out.println("- Realmente desea salir del sistema");
                                            System.out.println("- Digite 1 [UNO] para salir");
                                            System.out.println("- Digite cualquier valor para regresar");
                                            System.out.print("-         -> Su opción: ");
                                            respuesta_salida = leerDatos.nextInt();
                                            if(respuesta_salida == 1){
                                                System.exit(0);
                                            }else{
                                                salida_menuprincipal = false; // NO PERMITIR SALIR A MENU PRINCIPAL
                                            }
                                            break;
                                    }// CIERRE switch(opcion_menuprincipal)
                                }while(!salida_menuprincipal); // CIERRE }while(!salida_menuprincipal);
                            }catch(Exception e){
                                System.out.println("- Solamente debe ingresar valores numericos...");
                                salida_menuprincipal = false; // NO PERMITIR SALIR A MENU PRINCIPAL
                                leerDatos.nextLine(); // LIMPIEZA DE BUFER
                                break; // SI INGRESA UN VALOR DIFERENTE AL ESTABLECIDO, SIMPLEMENTE TERMINA EJECUCION
                            }
                        }
                    }// CIERRE for(contador_intentos = 1; contador_intentos < 4; contador_intentos++)
                }// CIERRE if(tiporolusuario==1)
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
                                   System.out.println("***************************************************************");
                                    System.out.println("                  PORTAL USUARIO");
                                    System.out.println("***************************************************************");
                                    System.out.println("- Bienvenido(a)" + correo_usuarios + " Por favor elija una opción:");
                                    System.out.println("- 1. Listado de Usuarios [DESC]");
                                    System.out.println("- 2. Registrar Usuarios ");
                                    System.out.println("- 3. Buscar Usuarios");
                                    System.out.println("- 4. Salir del Sistema Completamente");
                                    System.out.print("-         -> Su opción: ");
                                    opcion_menuprincipal = leerDatos.nextInt();
                                    leerDatos.nextLine(); // LIMPIEZA DE BUFER 
                                    /*
                                        -> NAVEGACION EN MENU DE SISTEMA SEGUN OPCION INGRESADA POR USUARIOS
                                    */
                                    switch(opcion_menuprincipal){
                                        /*
                                            -> LISTADO DE USUARIOS
                                        */
                                        case 1:
                                            System.out.println("***************************************************************");
                                            System.out.println("                  PORTAL USUARIO");
                                            System.out.println("***************************************************************");
                                            System.out.println("- Listado de usuarios registrados");
                                            // IMPRIMIR USUARIOS
                                            for(indice = 0; indice < usuarios.getCantidadUsuarios(); indice++){
                                            //for(indice = usuarios.getCantidadUsuarios(); indice >= usuarios.getCantidadUsuarios(); indice--){
                                                int valorusuario = indice;
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
                                            -> REGISTRAR USUARIOS
                                        */
                                        case 2:
                                            System.out.println("***************************************************************");
                                            System.out.println("                  PORTAL USUARIO");
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
                                            -> BUSCAR USUARIOS
                                        */
                                        case 3:
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
                                            -> SALIR DEL SISTEMA
                                        */
                                        case 4:
                                            System.out.println("***************************************************************");
                                            System.out.println("                  PORTAL USUARIO");
                                            System.out.println("***************************************************************");
                                            System.out.println("- Realmente desea salir del sistema");
                                            System.out.println("- Digite 1 [UNO] para salir");
                                            System.out.println("- Digite cualquier valor para regresar");
                                            System.out.print("-         -> Su opción: ");
                                            respuesta_salida = leerDatos.nextInt();
                                            if(respuesta_salida == 1){
                                                System.exit(0);
                                            }else{
                                                salida_menuprincipal = false; // NO PERMITIR SALIR A MENU PRINCIPAL
                                            }
                                            break;
                                    }// CIERRE switch(opcion_menuprincipal)
                                }while(!salida_menuprincipal); // CIERRE }while(!salida_menuprincipal);
                            }catch(Exception e){
                                System.out.println("- Solamente debe ingresar valores numericos...");
                                salida_menuprincipal = false; // NO PERMITIR SALIR A MENU PRINCIPAL
                                leerDatos.nextLine(); // LIMPIEZA DE BUFER
                                break; // SI INGRESA UN VALOR DIFERENTE AL ESTABLECIDO, SIMPLEMENTE TERMINA EJECUCION
                            }
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
                                   System.out.println("***************************************************************");
                                    System.out.println("                  PORTAL ASISTENTE");
                                    System.out.println("***************************************************************");
                                    System.out.println("- Bienvenido(a)" + correo_usuarios + " Por favor elija una opción:");
                                    System.out.println("- 1. Listado de Usuarios [DESC]");
                                    System.out.println("- 2. Registrar Usuarios ");
                                    System.out.println("- 3. Buscar Usuarios");
                                    System.out.println("- 4. Salir del Sistema Completamente");
                                    System.out.print("-         -> Su opción: ");
                                    opcion_menuprincipal = leerDatos.nextInt();
                                    leerDatos.nextLine(); // LIMPIEZA DE BUFER 
                                    /*
                                        -> NAVEGACION EN MENU DE SISTEMA SEGUN OPCION INGRESADA POR USUARIOS
                                    */
                                    switch(opcion_menuprincipal){
                                        /*
                                            -> LISTADO DE USUARIOS
                                        */
                                        case 1:
                                            System.out.println("***************************************************************");
                                            System.out.println("                  PORTAL ASISTENTE");
                                            System.out.println("***************************************************************");
                                            System.out.println("- Listado de usuarios registrados");
                                            // IMPRIMIR USUARIOS
                                            for(indice = 0; indice < usuarios.getCantidadUsuarios(); indice++){
                                            //for(indice = usuarios.getCantidadUsuarios(); indice >= usuarios.getCantidadUsuarios(); indice--){
                                                int valorusuario = indice;
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
                                            -> REGISTRAR USUARIOS
                                        */
                                        case 2:
                                            System.out.println("***************************************************************");
                                            System.out.println("                  PORTAL ASISTENTE");
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
                                            -> BUSCAR USUARIOS
                                        */
                                        case 3:
                                            System.out.println("***************************************************************");
                                            System.out.println("                  PORTAL ASISTENTE");
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
                                            -> SALIR DEL SISTEMA
                                        */
                                        case 4:
                                            System.out.println("***************************************************************");
                                            System.out.println("                  PORTAL ASISTENTE");
                                            System.out.println("***************************************************************");
                                            System.out.println("- Realmente desea salir del sistema");
                                            System.out.println("- Digite 1 [UNO] para salir");
                                            System.out.println("- Digite cualquier valor para regresar");
                                            System.out.print("-         -> Su opción: ");
                                            respuesta_salida = leerDatos.nextInt();
                                            if(respuesta_salida == 1){
                                                System.exit(0);
                                            }else{
                                                salida_menuprincipal = false; // NO PERMITIR SALIR A MENU PRINCIPAL
                                            }
                                            break;
                                    }// CIERRE switch(opcion_menuprincipal)
                                }while(!salida_menuprincipal); // CIERRE }while(!salida_menuprincipal);
                            }catch(Exception e){
                                System.out.println("- Solamente debe ingresar valores numericos...");
                                salida_menuprincipal = false; // NO PERMITIR SALIR A MENU PRINCIPAL
                                leerDatos.nextLine(); // LIMPIEZA DE BUFER
                                break; // SI INGRESA UN VALOR DIFERENTE AL ESTABLECIDO, SIMPLEMENTE TERMINA EJECUCION
                            }
                        }
                    }// CIERRE for(contador_intentos = 1; contador_intentos < 4; contador_intentos++)
                }// CIERRE if(tiporolusuario==2)
                
                /*
                    -> ROL DE ACCESO ADMINISTRADOR
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
                                   System.out.println("***************************************************************");
                                    System.out.println("                  PORTAL ADMINISTRADOR");
                                    System.out.println("***************************************************************");
                                    System.out.println("- Bienvenido(a)" + correo_usuarios + " Por favor elija una opción:");
                                    System.out.println("- 1. Listado de Usuarios [DESC]");
                                    System.out.println("- 2. Registrar Usuarios ");
                                    System.out.println("- 3. Buscar Usuarios");
                                    System.out.println("- 4. Salir del Sistema Completamente");
                                    System.out.print("-         -> Su opción: ");
                                    opcion_menuprincipal = leerDatos.nextInt();
                                    leerDatos.nextLine(); // LIMPIEZA DE BUFER 
                                    /*
                                        -> NAVEGACION EN MENU DE SISTEMA SEGUN OPCION INGRESADA POR USUARIOS
                                    */
                                    switch(opcion_menuprincipal){
                                        /*
                                            -> LISTADO DE USUARIOS
                                        */
                                        case 1:
                                            System.out.println("***************************************************************");
                                            System.out.println("                  PORTAL ADMINISTRADOR");
                                            System.out.println("***************************************************************");
                                            System.out.println("- Listado de usuarios registrados");
                                            // IMPRIMIR USUARIOS
                                            for(indice = 0; indice < usuarios.getCantidadUsuarios(); indice++){
                                            //for(indice = usuarios.getCantidadUsuarios(); indice >= usuarios.getCantidadUsuarios(); indice--){
                                                int valorusuario = indice;
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
                                            -> REGISTRAR USUARIOS
                                        */
                                        case 2:
                                            System.out.println("***************************************************************");
                                            System.out.println("                  PORTAL ADMINISTRADOR");
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
                                            -> BUSCAR USUARIOS
                                        */
                                        case 3:
                                            System.out.println("***************************************************************");
                                            System.out.println("                  PORTAL ADMINISTRADOR");
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
                                            -> SALIR DEL SISTEMA
                                        */
                                        case 4:
                                            System.out.println("***************************************************************");
                                            System.out.println("                  PORTAL ADMINISTRADOR");
                                            System.out.println("***************************************************************");
                                            System.out.println("- Realmente desea salir del sistema");
                                            System.out.println("- Digite 1 [UNO] para salir");
                                            System.out.println("- Digite cualquier valor para regresar");
                                            System.out.print("-         -> Su opción: ");
                                            respuesta_salida = leerDatos.nextInt();
                                            leerDatos.nextLine();
                                            if(respuesta_salida == 1){
                                                System.exit(0);
                                            }else{
                                                salida_menuprincipal = false; // NO PERMITIR SALIR A MENU PRINCIPAL
                                            }
                                            salida_menuprincipal = false; // NO PERMITIR SALIR A MENU PRINCIPAL
                                            break;
                                    }// CIERRE switch(opcion_menuprincipal)
                                }while(!salida_menuprincipal); // CIERRE }while(!salida_menuprincipal);
                            }catch(Exception e){
                                System.out.println("- Solamente debe ingresar valores numericos...");
                                salida_menuprincipal = false; // NO PERMITIR SALIR A MENU PRINCIPAL
                                leerDatos.nextLine(); // LIMPIEZA DE BUFER
                                break; // SI INGRESA UN VALOR DIFERENTE AL ESTABLECIDO, SIMPLEMENTE TERMINA EJECUCION
                            }
                        }
                    }// CIERRE for(contador_intentos = 1; contador_intentos < 4; contador_intentos++)
                }// CIERRE if(tiporolusuario==3)
                
            }// CIERRE if(tiporolusuario >=1 && tiporolusuario<=3)
        
        }catch(Exception e){
            System.out.println("- Solamente debe ingresar valores numericos...");
        }// CIERRE TRY CATCH
        
    }
    
}
