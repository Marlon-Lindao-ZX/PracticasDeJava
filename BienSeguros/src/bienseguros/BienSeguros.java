/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bienseguros;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *Clase main del proyecto 
 * @author 
 */
public class BienSeguros {
    ArrayList<PlanSeguro> planes=  new ArrayList<PlanSeguro>();
    ArrayList<Empleado> empleados=  new ArrayList<Empleado>();
    ArrayList<Venta> ventas=  new ArrayList<Venta>();  
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       BienSeguros agencia = new BienSeguros();

       agencia.crearPlanes();
       agencia.crearEmpleados();
       agencia.registrarVentas();
       agencia.calcularComisionVendedores();
       agencia.mostrarSueldos();        
    }

    /***
     * metodo que crea 4 planes y lo agrega a la lista planes
     */
    public void crearPlanes(){
       //creación de paquetes de turismo que los vendedores deben ubicar
       planes.add(new PlanSeguro("AT1001", "Seguro de vida y accidentes","Cubren los riesgos que puedan afectar\n" +
                                        "la existencia y la integridad física o la salud",10000.00f,200.00f) );
       planes.add(new PlanSeguro("AT1002", "Seguro de salud y medicina prepagada"," atención medica personalizada para la\n" +
"protección integral de tu grupo familiar",1200.00f,100.00f) );
       planes.add(new PlanSeguro("AT1003", "Seguro de automóviles","Cobertura y valores agregados relacionados a tu vehículo",1200.00f,100.00f) );
       planes.add(new PlanSeguro("AT1004", "Seguro multiriesgo","coberturas contra posibles\n" +
"daños o pérdidas que puedan afectar la operación ",3000.00f,150.00f) );
               
    }
    
    /***
     * metodo que crea 4 empleados, dos administrativos y dos vendedores, y se agrega a la lista empleados
     */
    public void crearEmpleados(){
       //crear 4 empleados
//     descomentar
//       empleados administrativos
       
       empleados.add(new Administrativo("0917586814","Silvia Patricia", "Orellana Castro",500.00f,true));
       empleados.add(new Administrativo("1256896565","Maria Leticia", "Pérez Ortiz",200.00f,false));
//       empleados vendedores
       empleados.add(new Vendedor("0924865687","Antonio José", "Arias Centeno",300.00f));
       empleados.add(new Vendedor("0956881256","Andrea Cecilia", "Méndez López",300.00f));
       for (Empleado empleado : empleados){
           System.out.println(empleado.toString());
       }
       
       
    }
    
    /***
     * metodo que requiere ingresar datos de 5 ventas y que se agrega a la lista Ventas
     * ademas busca en la lista empleados, el vendedor asociado a la lista y a esa variable
     * de tipo empleado se hace un downcasting para que se comporte como un vendedor y poder 
     * usarla para instanciar la variable venta
     */
    public void registrarVentas(){
       //puedes usar los siguientes datos
       //cedula vendedor, codigo plan, cantidad
       //0924865687,AT1001,2
       //0924865687,AT1002,10
       //0956881256,AT1001,1
       //0956881256,AT1002,15
       //0924865687,AT1004,5
       System.out.println("Ingresando datos de venta ...");
       Scanner sc = new Scanner(System.in);
       //pedir ingreso de 5 ventas
       
       for (int i=0;i<5;i++)
       {
           String cedula,codigo;
           int cantidad;
           Vendedor vendedor = null;
           PlanSeguro plan = null;
           //solicitar cédula del vendedor y buscar en lista
           System.out.print("Ingrese cedula del vendedor: ");
           cedula = sc.nextLine();
           for (Empleado empleado : empleados) {
               if (empleado instanceof Vendedor){
                   if (cedula.equals(empleado.getCedula())){
                       vendedor = (Vendedor) empleado;
                       break;
                   }
               }
           }
               
           
           //solicitar còdigo del plan y buscar en lista
           System.out.print("Ingrese el codigo del plan: ");
           codigo = sc.nextLine();
           for (PlanSeguro planSeguro : planes){
               if (planSeguro.getCodigo().equals(codigo)){
                   plan = planSeguro;
                   break;
               }
               
           }
           //solicitar cantidad vendida
           System.out.print("Ingrese la cantidad vendida: ");
           cantidad = sc.nextInt();
           sc.skip("\n");
           
           //agregar la venta a la lista
           ventas.add(new Venta(vendedor,plan,cantidad));
            
       }        
    }
    
    /***
     * metodo que busca en la lista empleados, a todos los vendedores, y a cada variable empleado que es instancia
     * de Vendedor se hace un downcasting para asi poder actualizar el atributo valorComision del objeto Vendedor
     */
    public void calcularComisionVendedores(){
        for (Empleado empleado: empleados){
            if (empleado instanceof Vendedor){
                Vendedor vendedor = (Vendedor) empleado;
                vendedor.calcularComision(ventas);
            }
            
        }
    }
    
    /***
     * metodo que ordena la lista empleados por el atributo apellidos, y que despues presenta la lista 
     * ya ordenadas
     */
    public void mostrarSueldos(){
        Collections.sort(empleados);
        for(Empleado empleado : empleados){
            System.out.println(empleado.toString());
        }
        
    }    
    
}
