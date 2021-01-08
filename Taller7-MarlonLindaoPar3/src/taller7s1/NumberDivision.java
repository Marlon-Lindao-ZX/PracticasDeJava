/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller7s1;

import java.util.Scanner;

/**
 *
 * @author CORE I7
 */
public class NumberDivision {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        boolean b, control;
        b = true;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                String str1, str2;
                int num;
                System.out.print("Ingrese un valor numerico: ");
                str1 = sc.nextLine();
                System.out.print("Ingrese otro valor numerico: ");
                str2 = sc.nextLine();
                num = dividir(str1, str2);
                System.out.println("Resultado de la division: " + num);

            } catch (NumberFormatException nfe) {
                System.out.println("Uno de los dos string ono contiene valores numericos!!!"
                        + "\n" + "Dato ingresado incorrecto");

            } catch (ArithmeticException ae) {
                System.out.println("Division para cero!!!" + "\n"
                        + "Segundo dato ingresado no puede ser cero!!!");

            } finally {
                control = true;
                String opcion;
                System.out.println("¿Desea continuar con la ejecucion del programa? (S/N) ");
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

        } while (b);
        System.out.println("Bye Bye XD!!!");

    }

    public static int dividir(String str1, String str2) throws NumberFormatException, ArithmeticException {
        int num1, num2, num3;
        num1 = Integer.parseInt(str1);
        num2 = Integer.parseInt(str2);
        num3 = num1 / num2;

        return num3;
    }

}
