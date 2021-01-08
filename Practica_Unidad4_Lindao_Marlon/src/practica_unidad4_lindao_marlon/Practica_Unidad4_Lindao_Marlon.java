/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica_unidad4_lindao_marlon;

import java.util.Scanner;

/**
 *
 * @author Estudiante
 */
public class Practica_Unidad4_Lindao_Marlon {
    static Scanner sc = new Scanner(System.in); 

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        boolean control,control2,control3;
        control = control2 = true;
        control3 = false;
        String opcion;
        int lincodreq, duracion,dias;
        System.out.print("Escriba la cantidad de lineas de codigo requeridas por el proyecto: ");
        lincodreq = sc.nextInt();
        System.out.print("Escriba la duracion del proyecto: ");
        duracion = sc.nextInt();
        Proyecto pro = new Proyecto(lincodreq, duracion);
        System.out.println("Ingrese los empleados que intervienen en el proyecto: ");
        sc.skip("\n");
        while (control) {
            System.out.println("¿Desea ingresar empleados?");
            System.out.println("1)Si");
            System.out.println("2)No");
            while (control2) {
                if (control3) {
                    System.out.println("¿Desea ingresar empleados?");
                    System.out.println("1)Si");
                    System.out.println("2)No");
                }
                System.out.print("Ingrese opcion: ");
                opcion = sc.nextLine();
                switch (opcion) {
                    case "1":
                        pro.agregarEmpleado(añadirEmpleado());
                        control3 = true;
                        break;
                    case "2":
                        control = false;
                        control2 = false;
                        break;
                    default:
                        System.out.println("Opcion invalida");
                        control3 = true;
                        break;
                }
            }
        }
       
        dias = pro.hacerproyecto(pro.getEmpleados());
        System.out.println("El proyecto necesita "+dias+" dias para terminarse");
        if(dias <= duracion){
            System.out.println("El proyecto se termino a tiempo");
        } else {
            System.out.println("El proyecto necesito " + (dias - duracion) + " mas para terminarse");
            Proyecto pro2 = new Proyecto(pro);
            boolean controlpr,controlsub;
            controlpr = controlsub = true;
            while (controlpr) {
                control = control2 = true;
                control3 = false;
                while (control) {
                    System.out.println("¿Desea ingresar mas empleados para terminar el proyecto a tiempo?");
                    System.out.println("1)Si");
                    System.out.println("2)No");
                    while (control2) {
                        if (control3) {
                            System.out.println("¿Desea seguir ingresando empleados?");
                            System.out.println("1)Si");
                            System.out.println("2)No");
                        }
                        System.out.print("Ingrese opcion: ");
                        opcion = sc.nextLine();
                        switch (opcion) {
                            case "1":
                                pro2.agregarEmpleado(añadirEmpleado());
                                control3 = true;
                                break;
                            case "2":
                                control = false;
                                control2 = false;
                                break;
                            default:
                                System.out.println("Opcion invalida");
                                control3 = true;
                                break;
                        }
                    }
                }
                dias = pro2.hacerproyecto(pro.getEmpleados());
                System.out.println("Con estos nuevos integrantes, los dias que se necesitan para hacer el proyecto son: "
                        + dias);
                if (dias <= duracion) {
                    System.out.println("Proyecto finalizado dentro del plazo establecido");
                    controlpr = false;
                } else {
                    System.out.println("El proyecto necesito " + (dias - duracion) + " mas para terminarse");
                    System.out.println("¿Desea ingresar otra vez otros empleados?");
                    System.out.println("1) Si");
                    System.out.println("2) No");
                    opcion = sc.nextLine();
                    while(controlsub){
                    switch(opcion){
                        case "1":
                            controlsub = false;
                            break;
                        case "2":
                            controlpr = false;
                            controlsub = false;
                            System.out.println("Bye bye XD");
                            break;
                        default:
                            System.out.println("opcion invalida");
                            break;
                    }
                    }

                }
            }
        }

    }
    
    public static Empleado añadirEmpleado(){
        Empleado e = null;
        String nombre,cedula,opcion;
        boolean control = true;
        System.out.println("Escriba el nombre del empleado: ");
        nombre = sc.nextLine();
        System.out.println("Escriba la cedula del empleado: ");
        cedula = sc.nextLine();
        System.out.println("Indique el perfil del empleado: ");
        System.out.println("1) Programador");
        System.out.println("2) Tester");
        while (control) {
            System.out.print("Ingrese opcion: ");
            opcion = sc.nextLine();
            switch (opcion) {
                case "1":
                    e = new Programador(nombre,cedula);
                    control = false;
                    break;
                case "2":
                    e = new Testers(nombre,cedula);
                    control = false;
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
                

            }
        }
        return e;
        
    }
    
}
