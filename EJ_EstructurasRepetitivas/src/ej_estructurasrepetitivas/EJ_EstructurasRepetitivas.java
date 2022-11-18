package ej_estructurasrepetitivas;

import java.util.Scanner;

public class EJ_EstructurasRepetitivas {
    // LIMPIAR BUFER - LUEGO DE INGRESAR NUMERICO Y POSTERIOR CADENA leerDatos.nextLine()
    public static void main(String[] args) throws InterruptedException {
        Scanner leerDatos = new Scanner(System.in);
        // VARIABLES
        String usuario = ""; String contrasenia = ""; int contador_intentos = 1; int contador = 1; int numero_estudiantes = 0;
        double notas_estudiantes = 0; int contador_estudiantes_aprobados = 0; int contador_estudiantes_reprobados = 0; int i = 0;  
        System.out.println("***************************************************");
        System.out.println("                INICIAR SESION");
        System.out.println("***************************************************");
        do{
            System.out.print("- Estimado usuario(a), ingrese su usuario: ");
            usuario = leerDatos.nextLine();
            System.out.print("- Estimado usuario(a), ingrese su contraseña: ");
            contrasenia = leerDatos.nextLine();
            // EFECTO CARGA ESPERE UN MOMENTO
            System.out.print("- Espere un momento");
            for(i=0; i<6; i++){
                System.out.print(".");
                Thread.sleep(500);
            }
            System.out.println("");
            if(usuario.equals("PROG3") && contrasenia.equals("123")){
                System.out.print("- ¿Cuantos estudiantes desea procesar?  ");
                numero_estudiantes = leerDatos.nextInt();
                while(contador <= numero_estudiantes){
                    System.out.println("***************************************************");
                    System.out.println("         ESTUDIANTE NUMERO "+ contador);
                    System.out.println("***************************************************");
                    System.out.print("- Ingrese la nota final del estudiante ["+ contador +"] ");
                    notas_estudiantes = leerDatos.nextDouble();
                    if(notas_estudiantes >=0 && notas_estudiantes<=10){
                        // VALIDACION DE ESTADO SEGUN NOTA INGRESADA
                        if(notas_estudiantes >= 8){
                            System.out.println("- EXCELENTE");
                        }else if(notas_estudiantes >= 6){
                            System.out.println("- MUY BUENO");
                        }else if(notas_estudiantes >= 4){
                            System.out.println("- REGULAR");
                        }else if(notas_estudiantes >= 2){
                            System.out.println("- NECESITA MEJORAR");
                        }else{
                            System.out.println("- RETIRE LA MATERIA");
                        }
                        // COMPROBACION ESTADO
                        if(notas_estudiantes >=6){
                            System.out.println("- APROBADO");
                            contador_estudiantes_aprobados++;
                        }else{
                            System.out.println("- REPROBADO");
                            contador_estudiantes_reprobados++;
                        }   
                    }else{
                        System.out.println("- Lo sentimos, el rango de calificaciones debe ser entre 1 y 10");
                    }
                    contador++;
                }// CIERRE while(contador <= numero_estudiantes)
                break;
            }else{
                System.out.println("Lo sentimos, usuario y/o clave invalidos");
            }// CIERRE if(usuario.equals("PROG3") || contrasenia.equals("123"))
            contador_intentos++;
        }while(contador_intentos <=3);
        // EFECTO CARGA ESPERE UN MOMENTO
        System.out.print("Espere un momento");
        for(i=0; i<6; i++){
            System.out.print(".");
            Thread.sleep(500);
        }
        // RESULTADO FINAL
        System.out.println("***************************************************");
        System.out.println("***************************************************");
        System.out.println("- DETALLE FINAL DE ESTUDIANTES");
        System.out.println("- Numero de estudiantes procesados: "+ numero_estudiantes + ".");
        System.out.println("- Numero de estudiantes aprobados: "+ contador_estudiantes_aprobados + ".");
        System.out.println("- Numero de estudiantes reprobabos: "+ contador_estudiantes_reprobados + ".");
        System.out.println("***************************************************");
        System.out.println("***************************************************");   
    }
}
