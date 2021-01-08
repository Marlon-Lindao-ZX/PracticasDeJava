/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;


public class Calculadora {
    public Calculadora(){
        
    }
    
    public double Suma(double number1, double number2, double number3, double number4){
        double tmp = number1+ number2+number3+number4;
        return tmp;
    }
    
    public double Resta(double number1, double number2, double number3, double number4){
        double tmp1 = number1 -number4;
        double tmp2 = number2 - number3;
        double tmp = tmp1+ tmp2;
        return tmp;
    }
    
    public double multiplicacion(double number1, double number2, double number3, double number4){
        if(number1 == 0 || number2 == 0 || number3 == 0 || number4 == 0){
            return 0;
        }else {
            double tmp = number1*number2*number3*number4;
            return tmp;
        }
    }
    
    public double division(double number1, double number2, double number3, double number4) throws Exception {
        if(number3 == 0 || number4 == 0 ||number2 == 0){
            throw new Exception("\"Acaso quieres que el universo explote? :v\"");
        }else if(number1 == 0 ){
            return 0 ;
        }else {
            double tmp1 = number1/number4;
            double tmp2 = number2/number3;
            return tmp1/tmp2;
        }
        
    }
        
    

    
}
