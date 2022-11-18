/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema;

import java.util.Scanner;

/**
 *
 * @author dany_
 */
public class Sistema {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner objEntrada = new Scanner(System.in);
        String nombre; int edad; double salario; boolean estado;
        nombre = ""; edad =0; salario =0.0; estado = false;
        System.out.println("Ingrese el nombre del usuario");
        nombre = objEntrada.nextLine();
        System.out.println("Ingrese la edad del usuario");
        edad = objEntrada.nextInt();
        System.out.println("Ingrese su salario");
        salario = objEntrada.nextDouble();
        System.out.println("Ingrese el estado del usuario");
        estado = objEntrada.nextBoolean();
        System.out.println("▓▓▓▓▓▓▓ DATOS DEL USUARIO ▓▓▓▓▓▓▓▓▓");
        System.out.println("▓▓ Nombre: "+nombre);
        System.out.println("▓▓ Edad: "+edad);
        System.out.println("▓▓ Salario $: "+salario);
        System.out.println("▓▓ Estado: "+estado);
        System.out.println("▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓");
    }
    
}
