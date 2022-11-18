package estructuraif;

import java.util.Scanner;

public class EstructuraIF {

    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        // VARIABLES
        /*
        String usuario = "", clave = "";
        Scanner objEntrada = new Scanner(System.in);
        System.out.println("****************************************");
        System.out.print("Ingrese su nombre: ");
        usuario = objEntrada.nextLine();
        System.out.print("Ingrese su clave: ");
        clave = objEntrada.nextLine();
        if(usuario.equals("PROG3") && clave.equals("123")){ // .equals para comparar CADENAS solo en java
            System.out.println("BIENVENIDO");
        }else{
            System.out.println("ERROR");
        }
        System.out.println("****************************************");*/
        Scanner objEntrada = new Scanner(System.in);
        double nota_usuario; int i;
        System.out.println("****************************************");
        System.out.print("Ingrese su calificacion final: ");
        nota_usuario = objEntrada.nextDouble();
        // EFECTO CARGA ESPERE UN MOMENTO
        System.out.print("Espere un momento");
        for(i=0; i<6; i++){
            System.out.print(".");
            Thread.sleep(500);
        }
        System.out.println("");
        if(nota_usuario >=0 && nota_usuario <=10){
            // COMPROBACION MENSAJE USUARIO
            if(nota_usuario >= 8){
                System.out.println("EXCELENTE");
            }else if(nota_usuario >= 6){
                System.out.println("MUY BUENO");
            }else if(nota_usuario >= 4){
                System.out.println("REGULAR");
            }else if(nota_usuario >= 2){
                System.out.println("NECESITA MEJORAR");
            }else{
                System.out.println("NECESITA UN MILAGRO");
            }
            // COMPROBACION ESTADO
            if(nota_usuario >=6){
                System.out.println("APROBADO");
            }else{
                System.out.println("REPROBADO");
            }   
        }else{
            System.out.println("Lo sentimos, su nota final debe estar entre 0 y 10 ");   
        }
        System.out.println("****************************************");
    }
}
