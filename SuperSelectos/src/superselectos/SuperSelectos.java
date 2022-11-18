
package superselectos;

import java.util.Scanner;

public class SuperSelectos {
    public static void main(String[] args) {
        /*
            -> LECTURA DE DATOS SCANNER
        */
         Scanner leerDatos = new Scanner(System.in);
        /*
            -> VARIABLES GLOBALES
        */
        double monto_compra = 0, total_compra = 0;
        int edad_cliente = 0, contador_clientes = 0;
        String respuesta_caja = "";
         try{
            do{
                contador_clientes++; // CONTADOR DE CLIENTES
                System.out.println("***************************************************************");
                System.out.println("                       SUPER SELECTOS");
                System.out.println("***************************************************************");
                System.out.print("- Ingrese el monto final de la compra: ");
                monto_compra = leerDatos.nextDouble();
                System.out.print("- Ingrese la edad del cliente: ");
                edad_cliente = leerDatos.nextInt();
                if(monto_compra > 0 && edad_cliente > 0){
                    if(monto_compra >=500){
                        total_compra = monto_compra-(monto_compra*.3);
                        if(edad_cliente >=50){
                            total_compra = monto_compra-(monto_compra*.3)-(monto_compra*.1);
                        }// CIERRE if(edad_cliente >=50
                        System.out.println("- Usted es acreedor de un descuento del 30%");
                    }// CIERRE if(monto_compra >=500)
                    if(monto_compra >=300 && monto_compra <500){
                        total_compra = monto_compra-(monto_compra*.2);
                        if(edad_cliente >=50){
                                total_compra = monto_compra-(monto_compra*.2)-(monto_compra*.1);
                            }// CIERRE if(edad_cliente >=50
                        System.out.println("- Usted es acreedor de un descuento del 20%");
                    }// CIERRE (monto_compra >=300 && monto_compra <500)
                    if(monto_compra <300){
                            total_compra = monto_compra-(monto_compra*.1);
                            if(edad_cliente >=50){
                                total_compra = monto_compra-(monto_compra*.1)-(monto_compra*.1);
                            }// CIERRE if(edad_cliente >=50
                            System.out.println("- Usted es acreedor de un descuento del 10%");
                    }// CIERRE if(monto_compra <300)
                    // IMPRESION DESCUENTO ADICIONAL
                    if(edad_cliente >=50){System.out.println("- Por su edad, usted ha recibido 10% de descuento adicional");}
                    /*
                        -> IMPRESION DATOS
                    */
                    System.out.println("- El monto de su compra es de $"+monto_compra+"USD.");
                    System.out.println("- Monto final a cancelar: $"+total_compra+" USD.");
                    System.out.println("***************************************************************");
                    System.out.println("- Digite cualquier tecla para continuar...");
                    System.out.println("- Digite n/N para salir");
                    System.out.print("- Su respuesta -> ");
                    leerDatos.nextLine();
                    respuesta_caja = leerDatos.nextLine();
                    if(respuesta_caja.equals("N") || respuesta_caja.equals("n")){
                        System.out.println("- Proceso "+contador_clientes+" clientes.");
                        System.exit(0);
                    } // CIERRE if(respuesta_caja.equals("N") || respuesta_caja.equals("n"))
                }else{
                    System.out.println("- Lo sentimos. No procesamos negativos y ceros");
                }// CIERRE if(monto_compra > 0 && edad_cliente > 0)
            }while(respuesta_caja!="S");
        }catch (Exception e){
            System.out.println("- Solamente debes ingresar S/N...");
            leerDatos.next();
       }// CIERRE try catch
    }
    
}
