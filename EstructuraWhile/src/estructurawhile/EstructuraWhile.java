package estructurawhile;

import java.util.Scanner;

public class EstructuraWhile {
    public static void main(String[] args) {
        Scanner leerDatos = new Scanner(System.in);
        // VARIABLES
        String usuario = ""; String contrasenia = ""; int contador = 1;
        System.out.println("***************************************************");
        System.out.println("                INICIAR SESION");
        System.out.println("***************************************************");
        // WHILE
        /*while(contador >=3){
            System.out.print("- Estimado usuario(a), ingrese su usuario: ");
            usuario = leerDatos.nextLine();
            System.out.print("- Estimado usuario(a), ingrese su contraseña: ");
            contrasenia = leerDatos.nextLine();
            if(usuario.equals("PROG3") && contrasenia.equals("123")){
                System.out.println("BIENVENIDO");
            }else{
                System.out.println("Lo sentimos, usuario y/o clave invalidos");
            }// CIERRE if(usuario.equals("PROG3") || contrasenia.equals("123"))
            contador--;
        }*/
        // DO WHILE
        do{
            System.out.print("- Estimado usuario(a), ingrese su usuario: ");
            usuario = leerDatos.nextLine();
            System.out.print("- Estimado usuario(a), ingrese su contraseña: ");
            contrasenia = leerDatos.nextLine();
            if(usuario.equals("PROG3") && contrasenia.equals("123")){
                System.out.println("BIENVENIDO");
            }else{
                System.out.println("Lo sentimos, usuario y/o clave invalidos");
            }// CIERRE if(usuario.equals("PROG3") || contrasenia.equals("123"))
            contador++;
        }while(contador <=3);
        System.out.println("***************************************************");
        System.out.println("***************************************************");
    }
    
}
