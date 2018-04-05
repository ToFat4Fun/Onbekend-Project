/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code3g;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jurian
 */
public class BarricadeTest {
    
    public BarricadeTest() {
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
     * Test of getBarricadeNummer method, of class Barricade.
     */
    @Test
    public void testGetBarricadeNummer() {
        System.out.println("getBarricadeNummer");
        Barricade instance = new Barricade(10,10,100); //creating barricade with value 100
        int expResult = 100; //expect 100
        int result = instance.getBarricadeNummer(); //call the method
        assertEquals(expResult, result); //compare the result
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setBarricadeNummer method, of class Barricade.
     */
    @Test
    public void testSetBarricadeNummer() {
        System.out.println("setBarricadeNummer");
        int barricadeNummer = 200;
        Barricade instance = new Barricade(10,10, 50);
        instance.setBarricadeNummer(barricadeNummer);
        System.out.println("setBarricade nummer "  + barricadeNummer);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of vakEigenschap method, of class Barricade.
     */
    @Test
    public void testVakEigenschap_Speler() {
        System.out.println("vakEigenschap");
        Speler speler = null;
        Barricade instance = null;
        boolean expResult = false;
        boolean result = instance.vakEigenschap(speler);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of vakEigenschap method, of class Barricade.
     */
    @Test
    public void testVakEigenschap_0args() {
        System.out.println("vakEigenschap");
        Barricade instance = null;
        boolean expResult = false;
        boolean result = instance.vakEigenschap();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of meldingTonen method, of class Barricade.
     */
    @Test
    public void testMeldingTonen() {
        System.out.println("meldingTonen");
        String tekst = "test de method";
        Barricade instance = new Barricade(10,10,200);
        instance.meldingTonen(tekst);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
