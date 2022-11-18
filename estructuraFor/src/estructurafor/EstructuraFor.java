package estructurafor;

import java.util.Scanner;

public class EstructuraFor {
    public static void main(String[] args) throws InterruptedException {
        Scanner leerDatos = new Scanner(System.in);
        int tablainicial = 0; int tablafinal = 0; int tabla = 0; int tipo_impresion = 0; int i = 0;
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
                for(i=0; i<6; i++){
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
        
        
    }// CIERRE public static void main(String[] args) throws InterruptedException 
    
}
