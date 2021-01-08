/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author CORE I7
 */
public class CalculadoraTest {
    
    public CalculadoraTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of Suma method, of class Calculadora.
     */
    @Test
    public void testSuma() {
        System.out.println("Suma");
        double number1 = -2.0;
        double number2 = -3.0;
        double number3 = -4.0;
        double number4 = -5.0;
        Calculadora instance = new Calculadora();
        double expResult = -14.0;
        double result = instance.Suma(number1, number2, number3, number4);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of Resta method, of class Calculadora.
     */
    @Test
    public void testResta() {
        System.out.println("Resta");
        double number1 = -2.0;
        double number2 = -3.0;
        double number3 = -4.0;
        double number4 = -5.0;
        Calculadora instance = new Calculadora();
        double expResult = 4.0;
        double result = instance.Resta(number1, number2, number3, number4);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of multiplicacion method, of class Calculadora.
     */
    @Test
    public void testMultiplicacion() {
        System.out.println("multiplicacion");
        double number1 = -2.0;
        double number2 = -3.0;
        double number3 = -4.0;
        double number4 = -5.0;
        Calculadora instance = new Calculadora();
        double expResult = 120.0;
        double result = instance.multiplicacion(number1, number2, number3, number4);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of division method, of class Calculadora.
     */
    @Test
    public void testDivision() throws Exception {
        System.out.println("division");
        double number1 = -4.0;
        double number2 = -6;
        double number3 = -3.0;
        double number4 = -2.0;
        Calculadora instance = new Calculadora();
        double expResult = 1.0;
        double result = instance.division(number1, number2, number3, number4);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
