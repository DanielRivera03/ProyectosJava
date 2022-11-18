package claseobjetos;

import java.util.Scanner;

public class ClaseObjetos {
    public static void main(String[] args) {
        String nombres = "";
        String apellidos = "";
        int edad = 0;
        String dui = "";
        Scanner leerDatos = new Scanner(System.in);
        Personas persona = new Personas();
        System.out.println("- ASIGNACION DATOS CON EL PRIMER METODO");
        persona.AsignarDatos();
        System.out.println("- El nombre es " + persona.getNombres());
        System.out.println("- El apellido es " + persona.getApellidos());
        System.out.println("- La edad es " + persona.getEdad());
        System.out.println("- El dui es " + persona.getDui());
        System.out.println("- ASIGNACION DATOS CON EL SEGUNDO METODO");
        System.out.println("-------------------------------------------------------");
        System.out.print("- Ingrese su nombre: ");
        nombres = leerDatos.nextLine();
        persona.setNombres(nombres);
        System.out.println("- El nombre es: "+ persona.getNombres());
        
        /*
        String nombres = "";
        String apellidos = "";
        int edad = 0;
        String dui = "";
        System.out.print("- Ingrese sus nombres: ");
        persona.nombres = leerDatos.nextLine();
        System.out.print("- Ingrese sus apellidos: ");
        persona.apellidos = leerDatos.nextLine();
        System.out.print("- Ingrese su edad: ");
        persona.edad = leerDatos.nextInt();
        leerDatos.nextLine();
        System.out.print("- Ingrese sus dui: ");
        persona.dui = leerDatos.nextLine();
        System.out.println("\f");
        System.out.println("- Su nombre es: "+persona.nombres + " "+ persona.apellidos+ ".");
        System.out.println("- Su edad es: "+ persona.edad + " años.");
        System.out.println("- Su dui es: "+ persona.dui + ".");*/
    }
    
}
