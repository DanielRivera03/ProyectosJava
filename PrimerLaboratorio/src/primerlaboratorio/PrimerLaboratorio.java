package primerlaboratorio;

import java.util.Scanner;

public class PrimerLaboratorio {
    public static void main(String[] args) throws InterruptedException {
         /*
            -> LECTURA DE DATOS SCANNER
        */
         Scanner leerDatos = new Scanner(System.in);
        /*
            -> VARIABLES GLOBALES
        */
        String usuario=""; String contrasenia = ""; int contador_intentos = 1; int barra_espera = 0; int i = 0; int j = 0;
        int opcion_menuprincipal = 0; boolean salida_menuprincipal = false; int opcion_menusecundario = 0;
        int tablainicial = 0; int tablafinal = 0; int tabla = 0; int tipo_impresion = 0; int conteo_cierresesiones = 1;
        int numeros_evaluar_factoriales = 0; int numero_factorial = 0; int numeros_evaluar_divisores = 0; int numero_divisor = 0;
        int numero_vehiculos = 0; int digito_placa = 0;
        boolean salida_menusecundario = false;
        /*
            -> ACUMULADORES
        */
        int Acum_AutoAmarillo=0; int Acum_AutoRosa=0; int Acum_AutoRojo=0; int Acum_AutoVerde=0; int Acum_AutoAzul=0;
        /*
            -> INICIO TODO EJECUCION DE APLICACION PRINCIPAL
        */
        System.out.println("***************************************************************");
        System.out.println("                       INICIAR SESION");
        System.out.println("***************************************************************");
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
            System.out.print("- Estimado usuario(a), ingrese su nombre de usuario: ");
            usuario = leerDatos.nextLine();
            System.out.print("- Estimado usuario(a), ingrese su nombre de contraseña: ");
            contrasenia = leerDatos.nextLine();
            // EFECTO CARGA ESPERE UN MOMENTO
            System.out.print("- Espere un momento");
            for(barra_espera=0; barra_espera<6; barra_espera++){
                System.out.print(".");
                Thread.sleep(500);
            }
            System.out.println("");
            // VALIDACION USUARIO Y CONTRASEÑA
            if(usuario.equals("PROG3") && contrasenia.equals("123")){
                /*
                    -> MENU PRINCIPAL DEL SISTEMA
                */
                try{
                    do{
                        System.out.println("- Bienvenido(a). Por favor elija una opción:");
                        System.out.println("- 1. Estructura IF-ELSE");
                        System.out.println("- 2. Estructura SWITCH");
                        System.out.println("- 3. Estructura WHILE");
                        System.out.println("- 4. Estructura DO-WHILE");
                        System.out.println("- 5. Estructura FOR");
                        System.out.println("- 6. Acerca de Nosotros");
                        System.out.println("- 7. Cerrar Sesión");
                        System.out.println("- 8. Salir");
                        System.out.print("-         -> Su opción: ");
                        opcion_menuprincipal = leerDatos.nextInt();
                        leerDatos.nextLine();
                        /*
                            -> NAVEGACION EN MENU DE SISTEMA SEGUN OPCION INGRESADA POR USUARIOS
                        */
                        switch(opcion_menuprincipal){
                            /*
                                -> ESTRUCTURA IF - ELSE - ELSEIF {}
                            */
                            case 1:
                                // VALIDACION SOLAMENTE INGRESO DE NUMEROS
                                try{
                                    do{
                                        System.out.println("***************************************************************");
                                        System.out.println("                  ESTRUCTURA IF-ELSE-ELSEIF(){}");
                                        System.out.println("***************************************************************");
                                        System.out.println("- Bienvenido(a). Por favor elija una opción:");
                                        System.out.println("- 1. ");
                                        System.out.println("- 2. ");
                                        System.out.println("- 3. ");
                                        System.out.println("- 4. ");
                                        System.out.println("- 5. ");
                                        System.out.println("- 6. Regresar Al Menú Principal ");
                                        System.out.print("-         -> Su opción: ");
                                        opcion_menusecundario = leerDatos.nextInt();
                                        switch(opcion_menusecundario){
                                            // RETORNAR A MENU PRINCIPAL
                                            case 6:
                                                salida_menusecundario = true;  // SALIR DE MENU SECUNDARIO
                                                salida_menuprincipal = false;  // NO PERMITIR INGRESO A MENU PRINCIPAL
                                                leerDatos.nextLine(); // LIMPIEZA DE BUFER
                                                break;
                                            // OPCION NO VALIDA
                                            default:
                                                System.out.println("- Opción de menú incorrecta. Intente otra vez...");
                                                break;
                                        }// CIERRE switch(opcion_menusecundario)
                                    }while(!salida_menusecundario);// CIERRE do while(!salida_menusecundario);
                                }catch (Exception e){
                                    System.out.println("- Solamente debes ingresar numeros...");
                                    leerDatos.next();
                                }// CIERRE try catch
                            break;
                            /*
                                -> ESTRUCTURA SWITCH() {}
                            */
                            case 2:
                                // VALIDACION SOLAMENTE INGRESO DE NUMEROS
                                try{
                                    do{
                                        System.out.println("***************************************************************");
                                        System.out.println("                  ESTRUCTURA SWITCH(){}");
                                        System.out.println("***************************************************************");
                                        System.out.println("- Bienvenido(a). Por favor elija una opción:");
                                        System.out.println("- 1. ");
                                        System.out.println("- 2. ");
                                        System.out.println("- 3. ");
                                        System.out.println("- 4. ");
                                        System.out.println("- 5. ");
                                        System.out.println("- 6. Regresar Al Menú Principal ");
                                        System.out.print("-         -> Su opción: ");
                                        opcion_menusecundario = leerDatos.nextInt();
                                        switch(opcion_menusecundario){
                                            // RETORNAR A MENU PRINCIPAL
                                            case 6:
                                                salida_menusecundario = true;  // SALIR DE MENU SECUNDARIO
                                                salida_menuprincipal = false;  // NO PERMITIR INGRESO A MENU PRINCIPAL
                                                leerDatos.nextLine(); // LIMPIEZA DE BUFER
                                                break;
                                            // OPCION NO VALIDA
                                            default:
                                                System.out.println("- Opción de menú incorrecta. Intente otra vez...");
                                                break;
                                        }// CIERRE switch(opcion_menusecundario)
                                    }while(!salida_menusecundario);// CIERRE do while(!salida_menusecundario);
                                }catch (Exception e){
                                    System.out.println("- Solamente debes ingresar numeros...");
                                    leerDatos.next();
                                }// CIERRE try catch
                            break;
                            /*
                                -> ESTRUCTURA WHILE(){}
                            */
                            case 3:
                                // VALIDACION SOLAMENTE INGRESO DE NUMEROS
                                try{
                                    do{
                                        System.out.println("***************************************************************");
                                        System.out.println("                  ESTRUCTURA WHILE(){}");
                                        System.out.println("***************************************************************");
                                        System.out.println("- Bienvenido(a). Por favor elija una opción:");
                                        System.out.println("- 1. ");
                                        System.out.println("- 2. ");
                                        System.out.println("- 3. ");
                                        System.out.println("- 4. ");
                                        System.out.println("- 5. ");
                                        System.out.println("- 6. Regresar Al Menú Principal ");
                                        System.out.print("-         -> Su opción: ");
                                        opcion_menusecundario = leerDatos.nextInt();
                                        switch(opcion_menusecundario){
                                            // RETORNAR A MENU PRINCIPAL
                                            case 6:
                                                salida_menusecundario = true;  // SALIR DE MENU SECUNDARIO
                                                salida_menuprincipal = false;  // NO PERMITIR INGRESO A MENU PRINCIPAL
                                                leerDatos.nextLine(); // LIMPIEZA DE BUFER
                                                break;
                                            // OPCION NO VALIDA
                                            default:
                                                System.out.println("- Opción de menú incorrecta. Intente otra vez...");
                                                break;
                                        }// CIERRE switch(opcion_menusecundario)
                                    }while(!salida_menusecundario);// CIERRE do while(!salida_menusecundario);
                                }catch (Exception e){
                                    System.out.println("- Solamente debes ingresar numeros...");
                                    leerDatos.next();
                                }// CIERRE try catch
                            break;
                            /*
                                -> ESTRUCTURA DO{}WHILE();
                            */
                            case 4:
                                // VALIDACION SOLAMENTE INGRESO DE NUMEROS
                                try{
                                    do{
                                        System.out.println("***************************************************************");
                                        System.out.println("                  ESTRUCTURA DO{}WHILE();");
                                        System.out.println("***************************************************************");
                                        System.out.println("- Bienvenido(a). Por favor elija una opción:");
                                        System.out.println("- 1. ");
                                        System.out.println("- 2. ");
                                        System.out.println("- 3. ");
                                        System.out.println("- 4. ");
                                        System.out.println("- 5. ");
                                        System.out.println("- 6. Regresar Al Menú Principal ");
                                        System.out.print("-         -> Su opción: ");
                                        opcion_menusecundario = leerDatos.nextInt();
                                        switch(opcion_menusecundario){
                                            // RETORNAR A MENU PRINCIPAL
                                            case 6:
                                                salida_menusecundario = true;  // SALIR DE MENU SECUNDARIO
                                                salida_menuprincipal = false;  // NO PERMITIR INGRESO A MENU PRINCIPAL
                                                leerDatos.nextLine(); // LIMPIEZA DE BUFER
                                                break;
                                            // OPCION NO VALIDA
                                            default:
                                                System.out.println("- Opción de menú incorrecta. Intente otra vez...");
                                                break;
                                        }// CIERRE switch(opcion_menusecundario)
                                    }while(!salida_menusecundario);// CIERRE do while(!salida_menusecundario);
                                }catch (Exception e){
                                    System.out.println("- Solamente debes ingresar numeros...");
                                    leerDatos.next();
                                }// CIERRE try catch
                            break;
                            /*
                                -> ESTRUCTURA FOR(,,,){}
                            */
                            case 5:
                                // VALIDACION SOLAMENTE INGRESO DE NUMEROS
                                do{
                                    System.out.println("***************************************************************");
                                    System.out.println("                     ESTRUCTURA FOR(,,,){}");
                                    System.out.println("***************************************************************");
                                    System.out.println("- Bienvenido(a). Por favor elija una opción:");
                                    System.out.println("- 1. Generar Tabla Multiplicación [ASC -> DESC");
                                    System.out.println("- 2. Cálculo de Factoriales de N números");
                                    System.out.println("- 3. Cálculo Números Divisores");
                                    System.out.println("- 4. Contador de Vehículos Por Colores (Según Placas)");
                                    System.out.println("- 5. Constructor de Figuras");
                                    System.out.println("- 6. Regresar Al Menú Principal ");
                                    System.out.print("-         -> Su opción: ");
                                    opcion_menusecundario = leerDatos.nextInt();
                                    switch(opcion_menusecundario){
                                        /*
                                            -> EJEMPLO 1 ESTRUCTURA FOR
                                        */
                                        case 1:
                                            System.out.println("***************************************************");
                                            System.out.println("         GENERADOR TABLA MULTIPLICAR");
                                            System.out.println("***************************************************");
                                            System.out.print("- Estimado usuario(a), ingrese el numero de tabla a multiplicar: ");
                                            tabla = leerDatos.nextInt();
                                            System.out.print("- Ahora, ingrese el valor inicial a multiplicar: ");
                                            tablainicial = leerDatos.nextInt();
                                            System.out.print("- Ahora, ingrese el valor final a multiplicar ["+tabla+" X ?]: ");
                                            tablafinal = leerDatos.nextInt();
                                            // VALIDACION DE FACTORES
                                            if(tablafinal > tablainicial){
                                                // VALIDACION NUMEROS MAYORES A CERO
                                                if(tabla > 0 && tablainicial > 0 && tablafinal > 0){
                                                    System.out.println("- ¿De que manera desea visualizarla?");
                                                    System.out.println("- Ingrese 1 [uno] si desea visualizarla de manera ascendente");
                                                    System.out.println("- Ingrese 2 [dos] si desea visualizarla de manera descendente");
                                                    System.out.println("- Ingrese 3 [tres] si desea visualizarla de ambas formas");
                                                    System.out.println("");
                                                    System.out.print(" Respuesta: -> ");
                                                    tipo_impresion = leerDatos.nextInt();
                                                    // EFECTO CARGA ESPERE UN MOMENTO
                                                    System.out.print("- Espere un momento");
                                                    for(barra_espera=0; barra_espera<6; barra_espera++){
                                                        System.out.print(".");
                                                        Thread.sleep(500);
                                                    }
                                                    System.out.println("");
                                                    // VALIDACION OPCIONES DE MENU
                                                    if(tipo_impresion > 0){
                                                        switch (tipo_impresion){
                                                            // FORMA ASCENDENTE
                                                            case 1:
                                                                System.out.printf("|%4s|%n", "ASCENDENTE");
                                                                for(i=tablainicial; i<=tablafinal; i++){
                                                                    System.out.printf("|%4s%4s%2s|%n", tabla + " X ",i + " = ", tabla*i);
                                                                }
                                                            break;
                                                            // FORMA DESCENDENTE
                                                            case 2:
                                                                System.out.printf("|%4s|%n", "DESCENDENTE");
                                                                for(i=tablafinal; i>=tablainicial; i--){
                                                                    System.out.printf("|%4s%4s%2s|%n", tabla + " X ",i + " = ", tabla*i);
                                                                }
                                                            break;
                                                            // AMBAS FORMAS
                                                            case 3:
                                                                // FORMA ASCENDENTE
                                                                System.out.printf("|%4s|%n", "ASCENDENTE");
                                                                for(i=tablainicial; i<=tablafinal; i++){
                                                                    System.out.printf("|%4s%4s%2s|%n", tabla + " X ",i + " = ", tabla*i);
                                                                }
                                                                // FORMA DESCENDENTE
                                                                System.out.printf("|%4s|%n", "DESCENDENTE");
                                                                for(i=tablafinal; i>=tablainicial; i--){
                                                                    System.out.printf("|%4s%4s%2s|%n", tabla + " X ",i + " = ", tabla*i);
                                                                }
                                                                break;
                                                        }// CIERRE switch (tipo_impresion){
                                                    }else{
                                                        System.out.println("- Lo sentimos, no admitimos numeros negativos");
                                                    }// CIERRE if(tipo_impresion > 0){
                                                }else{
                                                    System.out.println("- Lo sentimos, no admitimos numeros negativos.");
                                                } // CIERRE if(tabla > 0 && tablainicial > 0 && tablafinal > 0)
                                            }else{
                                                System.out.println("- Lo sentimos, el rango del primer factor no puede ser mayor al rango del segundo factor");
                                            }
                                            System.out.println("***************************************************");
                                            System.out.println("***************************************************");
                                            salida_menuprincipal = false;  // NO PERMITIR INGRESO A MENU PRINCIPAL
                                            leerDatos.nextLine(); // LIMPIEZA DE BUFER
                                            System.out.println("- Presione cualquier tecla para continuar...");
                                            new java.util.Scanner(System.in).nextLine();
                                            break;
                                        /*
                                            -> EJEMPLO 2 ESTRUCTURA FOR
                                        */
                                        case 2:
                                            System.out.println("***************************************************");
                                            System.out.println("            CALCULADORA DE FACTORIALES");
                                            System.out.println("***************************************************");
                                            System.out.print("- ¿Cuántos números desea procesar? ");
                                            numeros_evaluar_factoriales = leerDatos.nextInt();
                                            if(numeros_evaluar_factoriales > 0){
                                                for(i=1; i<=numeros_evaluar_factoriales; i++){
                                                    System.out.print("- Ingrese un numero: ");
                                                    numero_factorial = leerDatos.nextInt();
                                                    int Factorial = 1;
                                                    for(j=1; j<=numero_factorial; j++){
                                                        Factorial=Factorial*j;
                                                    }// CIERRE for(i=1; i<=numero_factorial; i++)
                                                    System.out.println("- El factorial de "+ numero_factorial + " es: " + Factorial +".");
                                                }// CIERRE for(i=1; i<=numeros_evaluar_factoriales; i++)
                                            }// CIERRE if(numeros_evaluar_factoriales > 0)
                                            salida_menuprincipal = false;  // NO PERMITIR INGRESO A MENU PRINCIPAL
                                            leerDatos.nextLine(); // LIMPIEZA DE BUFER
                                            System.out.println("- Presione cualquier tecla para continuar...");
                                            new java.util.Scanner(System.in).nextLine();
                                            break;
                                        /*
                                            -> EJEMPLO 3 ESTRUCTURA FOR
                                        */
                                        case 3:
                                            System.out.println("***************************************************");
                                            System.out.println("         CALCULADORA DE NUMEROS DIVISORES");
                                            System.out.println("***************************************************");
                                            System.out.print("- ¿Cuántos números desea procesar? ");
                                            numeros_evaluar_divisores = leerDatos.nextInt();
                                            if(numeros_evaluar_divisores > 0){
                                                for(i=1; i<= numeros_evaluar_divisores; i++){
                                                    System.out.print("- Ingrese un numero: ");
                                                    numero_divisor = leerDatos.nextInt();
                                                    if(numero_divisor > 0){
                                                        for(j=1; j<=numero_divisor; j++){
                                                            if(numero_divisor % j == 0){
                                                                System.out.println("- El "+ numero_divisor + " es divisible con "+ j + ".");
                                                            }
                                                        }// CIERRE for(int j=1; j<=numero_divisor; j++)
                                                    }
                                                }
                                            }// CIERRE if(numeros_evaluar_divisores > 0)
                                            salida_menuprincipal = false;  // NO PERMITIR INGRESO A MENU PRINCIPAL
                                            leerDatos.nextLine(); // LIMPIEZA DE BUFER
                                            System.out.println("- Presione cualquier tecla para continuar...");
                                            new java.util.Scanner(System.in).nextLine();
                                            break;
                                        /*
                                            -> EJEMPLO 4 ESTRUCTURA FOR
                                        */
                                        case 4:
                                            System.out.println("***************************************************");
                                            System.out.println("                  VMT EL SALVADOR");
                                            System.out.println("***************************************************");
                                            System.out.println("- CONTADOR DE COLOR DE VEHICULOS SEGUN DIGITO DE PLACA");
                                            System.out.println("- 1 y 2 --> AMARILLO");
                                            System.out.println("- 3 y 4 --> ROSA");
                                            System.out.println("- 5 y 6 --> ROJO");
                                            System.out.println("- 7 y 8 --> VERDE");
                                            System.out.println("- 9 y 0 --> AZUL");
                                            System.out.println("");
                                            System.out.print("- ¿Cuántos vehículos desea procesar? ");
                                            numero_vehiculos = leerDatos.nextInt();
                                            if(numero_vehiculos >= 0){
                                                for(i=1; i <= numero_vehiculos; i++){
                                                    System.out.println("- Vehículo Automotor ["+ i + " / "+ numero_vehiculos +" ]");
                                                    System.out.print("- Ingrese el último dígito de la placa ");
                                                    digito_placa = leerDatos.nextInt();
                                                    // CONTEO DE VEHICULOS SEGUN DIGITO DE PLACA INGRESADO
                                                    if(digito_placa == 1 || digito_placa == 2){
                                                        Acum_AutoAmarillo++;
                                                    }else if(digito_placa == 3 || digito_placa == 4){
                                                        Acum_AutoRosa++;
                                                    }else if(digito_placa == 5 || digito_placa == 6){
                                                        Acum_AutoRojo++;
                                                    }else if(digito_placa == 7 || digito_placa == 8){
                                                        Acum_AutoVerde++;
                                                    }else if(digito_placa == 9 || digito_placa == 0){
                                                        Acum_AutoAzul++;
                                                    }
                                                }// CIERRE for(i=1; i <= numero_vehiculos; i++)
                                                System.out.println("- CONSILIDADO FINAL DE VEHICULOS");
                                                System.out.println("- Total vehículos amarillos: "+ Acum_AutoAmarillo +".");
                                                System.out.println("- Total vehículos rosa: "+ Acum_AutoRosa +".");
                                                System.out.println("- Total vehículos rojos: "+ Acum_AutoRojo +".");
                                                System.out.println("- Total vehículos verdes: "+ Acum_AutoVerde +".");
                                                System.out.println("- Total vehículos azules: "+ Acum_AutoAzul +".");
                                            }// CIERRE if(numero_vehiculos > 0)
                                            salida_menuprincipal = false;  // NO PERMITIR INGRESO A MENU PRINCIPAL
                                            leerDatos.nextLine(); // LIMPIEZA DE BUFER
                                            System.out.println("- Presione cualquier tecla para continuar...");
                                            new java.util.Scanner(System.in).nextLine();
                                            break;
                                        /*
                                            -> EJEMPLO 5 ESTRUCTURA FOR
                                        */
                                        case 5:
                                            System.out.println("***************************************************");
                                            System.out.println("            CONSTRUCTOR DE FIGURAS");
                                            System.out.println("***************************************************");
                                            for(i=1; i<=10; i++){
                                                for(j=1; j<=10; j++){
                                                    if(i==1 || i==10 || j==1 || j==10 || j==i || j==11-i || ((i==3 || i==8) && j>2 && j<9 || (j==3 || j==8) && i>2 && i<9)){
                                                        System.out.print(" *");
                                                    }else{
                                                        System.out.print("  ");
                                                    }
                                                }// CIERRE for(int j=1; j<=10; j++)
                                                System.out.println("");
                                            }// CIERRE for(i=1; i<=10; i++)
                                            System.out.println("");
                                            for(i=1; i<=10; i++){
                                                for(j=1; j<=10; j++){
                                                    if(i<=6 && (j<=i || j>10-i) || (i>6 && (j<12-i || j>-1+i))){
                                                        System.out.print(" *");
                                                    }else{
                                                        System.out.print("  ");
                                                    }
                                                }// CIERRE for(j=1; j<=10; j++)
                                                System.out.println("");
                                            }// CIERRE for(i=1; i<=10; i++)
                                            salida_menuprincipal = false;  // NO PERMITIR INGRESO A MENU PRINCIPAL
                                            leerDatos.nextLine(); // LIMPIEZA DE BUFER
                                            System.out.println("- Presione cualquier tecla para continuar...");
                                            new java.util.Scanner(System.in).nextLine();
                                            break;
                                        /*
                                            -> RETORNAR A MENU PRINCIPAL DE APLICACION
                                        */
                                        case 6:
                                            salida_menusecundario = true;  // SALIR DE MENU SECUNDARIO
                                            salida_menuprincipal = false;  // NO PERMITIR INGRESO A MENU PRINCIPAL
                                            leerDatos.nextLine(); // LIMPIEZA DE BUFER
                                            break;
                                        default:
                                            System.out.println("- Opción de menú incorrecta. Intente otra vez...");
                                            break;
                                    }// CIERRE switch(opcion_menusecundario)
                                }while(!salida_menusecundario); // CIERRE do while(!salida_menusecundario);
                                break;
                            /*
                                -> ACERCA DE NOSOTROS
                            */
                            case 6:
                                // VALIDACION SOLAMENTE INGRESO DE NUMEROS
                                try{
                                    do{
                                        System.out.println("***************************************************************");
                                        System.out.println("                  INTEGRANTES EQUIPO");
                                        System.out.println("***************************************************************");
                                        System.out.println("- Bienvenido(a). Para salir, ingrese la opción 6 [seis] -> ");
                                        System.out.println("- 1. ");
                                        System.out.println("- 2. ");
                                        System.out.println("- 3. ");
                                        System.out.println("- 4. ");
                                        System.out.println("- 5. ");
                                        System.out.println("- 6. Regresar Al Menú Principal ");
                                        System.out.print("-         -> Su opción: ");
                                        opcion_menusecundario = leerDatos.nextInt();
                                        switch(opcion_menusecundario){
                                            // RETORNAR A MENU PRINCIPAL
                                            case 6:
                                                salida_menusecundario = true;  // SALIR DE MENU SECUNDARIO
                                                salida_menuprincipal = false;  // NO PERMITIR INGRESO A MENU PRINCIPAL
                                                leerDatos.nextLine(); // LIMPIEZA DE BUFER
                                                break;
                                            // OPCION NO VALIDA
                                            default:
                                                System.out.println("- Opción de menú incorrecta. Intente otra vez...");
                                                break;
                                        }// CIERRE switch(opcion_menusecundario)
                                    }while(!salida_menusecundario);// CIERRE do while(!salida_menusecundario);
                                }catch (Exception e){
                                    System.out.println("- Solamente debes ingresar numeros...");
                                    leerDatos.next();
                                }// CIERRE try catch
                            break;
                            /*
                                -> CERRAR SESION USUARIOS
                            */
                            case 7: 
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
                    }while(!salida_menuprincipal);
                }catch (Exception e){
                    System.out.println("- Solamente debes ingresar numeros...");
                    leerDatos.next();
                }// CIERRE try catch
            }else{
                System.out.println("- Lo sentimos usuario y/o contraseña inválidos");
            }// CIERRE if(usuario.equals("PROG3") && contrasenia.equals("123"))
        }
        System.out.println("***************************************************************");
        System.out.println("***************************************************************");
    }
}
