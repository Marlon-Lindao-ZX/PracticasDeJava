/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller7s2;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author CORE I7
 */
public class Main {

    private static Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Boolean B, b, control;
        B = b = true;
        do {
            String nombre;
            System.out.print("Ingrese el nombre del estudiante: ");
            nombre = sc.nextLine();
            Estudiante estudiante = new Estudiante(nombre);
            do {
                try {
                    int calif1, calif2, calif3, calif4, calif5;
                    do {
                        System.out.print("Ingrese la primera calificacion del estudiante: ");
                        calif1 = esUnNumeroValido();
                    } while (calif1 < 0);
                    do {
                        System.out.print("Ingrese la segunda calificacion del estudiante: ");
                        calif2 = esUnNumeroValido();
                    } while (calif2 < 0);
                    do {
                        System.out.print("Ingrese la tercera calificacion del estudiante: ");
                        calif3 = esUnNumeroValido();
                    } while (calif3 < 0);
                    do {
                        System.out.print("Ingrese la cuarta calificacion del estudiante: ");
                        calif4 = esUnNumeroValido();
                    } while (calif4 < 0);
                    do {
                        System.out.print("Ingrese la quinta calificacion del estudiante: ");
                        calif5 = esUnNumeroValido();
                    } while (calif5 < 0);

                    int[] calificaciones = {calif1, calif2, calif3, calif4, calif5};
                    estudiante.setCalificaciones(calificaciones);
                    System.out.println("Calificaciones asignadas correctamente :)");
                    b = false;

                } catch (CalificacionFueraDeRangoException cfre) {
                    System.out.println(cfre.getMessage());
                    b = true;

                } finally {
                    if (b) {
                        control = true;
                        String opcion;
                        System.out.println("¿Desea tratar de asignar las calificaciones a este estudiante? (S/N) ");
                        sc.skip("\n");
                        do {
                            System.out.print("Digite su opcion: ");
                            opcion = sc.nextLine();
                            switch (opcion) {
                                case "S":
                                    control = false;
                                    break;
                                case "N":
                                    b = false;
                                    control = false;
                                    break;
                                default:
                                    break;
                            }
                        } while (control);
                    }

                }
            } while (b);

            control = true;
            String opcion;
            System.out.println("¿Desea continuar con la ejecucion del programa? (S/N) ");
            sc.skip("\n");
            do {
                System.out.print("Digite su opcion: ");
                opcion = sc.nextLine();
                switch (opcion) {
                    case "S":
                        control = false;
                        break;
                    case "N":
                        B = false;
                        control = false;
                        break;
                    default:
                        break;
                }
            } while (control);

        } while (B);
        System.out.println("Bye Bye XD!!!");
    }

    public static int esUnNumeroValido() {

        try {
            int num = sc.nextInt();
            if (num < 0) {
                System.out.println("La calificacion no puede ser negativa!!!");
            }
            return num;
        } catch (InputMismatchException ime) {
            System.out.println("Cuidado!!, dato ingresado no es un numero");
            System.out.println("Solo puede ingresar numero");
            return -1;
        }
    }
}
