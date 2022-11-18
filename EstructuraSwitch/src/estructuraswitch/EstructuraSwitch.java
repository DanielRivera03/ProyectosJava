package estructuraswitch;

import java.util.Scanner;

public class EstructuraSwitch {
    public static void main(String[] args) throws InterruptedException {
        /*
        Scanner leerDatos = new Scanner(System.in);
        int dia_semana = 0;
        System.out.print("Por favor ingrese un número [Entre 1 a 7]: ");
        dia_semana = leerDatos.nextInt();
        switch(dia_semana){
            case 1:
                System.out.println("LUNES");
                break;
            case 2:
                System.out.println("MARTES");
                break;
            case 3:
                System.out.println("MIERCOLES");
                break;
            case 4:
                System.out.println("JUEVES");
                break;
            case 5:
                System.out.println("VIERNES");
                break;
            case 6:
                System.out.println("SABADO");
                break;
            case 7:
                System.out.println("DOMINGO");
                break;
            default:
                System.out.println("Lo sentimos, "+ dia_semana + " no corresponde al rango solicitado...");
                break;
        }
        switch(dia_semana){
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                System.out.println("DIA DE SEMANA");
                break;
            case 6:
            case 7:
                System.out.println("FIN DE SEMANA");
                break;
        }      */  
        
        Scanner leerDatos = new Scanner(System.in);
        // VARIABLES
        String nombre_usuario = ""; int mes = 0; int i = 0;
        System.out.println("***************************************************");
        System.out.println("     CALCULADOR MESES / TRIMESTRE / SEMESTRE");
        System.out.println("***************************************************");
        System.out.print("- Estimado usuario(a), ingrese su nombre: ");
        nombre_usuario = leerDatos.nextLine();
        System.out.print("- " + nombre_usuario+ " ingrese un numero entre el rango 1 a 12: ");
        mes = leerDatos.nextInt();
        // EFECTO CARGA ESPERE UN MOMENTO
        System.out.print("Espere un momento");
        for(i=0; i<6; i++){
            System.out.print(".");
            Thread.sleep(500);
        }
        System.out.println("");
        System.out.println("***************************************************");
        if(mes >=1 && mes <=12){
            System.out.print("- "+ nombre_usuario + " el rango ["+ mes +"] corresponde al mes de: ");
            // VALIDACION DE MES CORRELATIVO
            switch(mes){
                case 1:
                    System.out.println("ENERO");
                    break;
                case 2:
                    System.out.println("FEBRERO");
                    break;
                case 3:
                    System.out.println("MARZO");
                    break;
                case 4:
                    System.out.println("ABRIL");
                    break;
                case 5:
                    System.out.println("MAYO");
                    break;
                case 6:
                    System.out.println("JUNIO");
                    break;
                case 7:
                    System.out.println("JULIO");
                    break;
                case 8:
                    System.out.println("AGOSTO");
                    break;
                case 9:
                    System.out.println("SEPTIEMBRE");
                    break;
                case 10:
                    System.out.println("OCTUBRE");
                    break;
                case 11:
                    System.out.println("NOVIEMBRE");
                    break;
                case 12:
                    System.out.println("DICIEMBRE");
                    break;
            }
            // VALIDACION DE SEMESTRE
            if(mes <=3){
                System.out.println("- Primer Trimestre");
            }else if(mes >=4 && mes <= 6){
                System.out.println("- Segundo Trimestre");
            }else if(mes >=7 && mes <= 9){
                System.out.println("- Tercer Trimestre");
            }else{
                System.out.println("- Cuarto Trimestre");
            }
            // VALIDACION DE BIMESTRE
            if(mes >=1 && mes<=6){
                System.out.println("- Primer Bimestre");
            }else{
                System.out.println("- Segundo Bimestre");
            }
        }else{
            System.out.println("- "+ nombre_usuario + " lo sentimos, ["+ mes +"] no corresponde al rango solicitado. intende nuevamente...");
        }
        System.out.println("***************************************************");
        System.out.println("***************************************************");
        
    }
    
}
