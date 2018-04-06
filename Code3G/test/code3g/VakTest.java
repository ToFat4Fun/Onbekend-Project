/*
   This game is developed by Mucahit Coskun, Jurian van Hoorn and Tarik Sherif, students at The Hague University of Applied Sciences
   If you wish to you use any of this code please refer to the authors or copy this header.
   This is our version of a Maze Game project for Software Engineering 2017-2018 3rd semester.
 */
package code3g;

import java.awt.Image;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tarik
 */
public class VakTest {
    
    public VakTest() {
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
     * Test of setKleur method, of class Vak.
     */
    @Test
    public void testSetKleur() {
        System.out.println("setKleur");
        String gekozenKleur = "";
        Vak instance = null;
        instance.setKleur(gekozenKleur);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getKleur method, of class Vak.
     */
    @Test
    public void testGetKleur() {
        System.out.println("getKleur");
        Vak instance = null;
        String expResult = "";
        String result = instance.getKleur();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getEigenschap method, of class Vak.
     */
    @Test
    public void testGetEigenschap() {
        System.out.println("getEigenschap");
        Vak instance = null;
        Eigenschap expResult = null;
        Eigenschap result = instance.getEigenschap();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
 
    }

    /**
     * Test of addEigenschap method, of class Vak.
     */
    @Test
    public void testAddEigenschap() {
        System.out.println("addEigenschap");
        Eigenschap e = null;
        Vak instance = null;
        instance.addEigenschap(e);
        // TODO review the generated test code and remove the default call to fail.
   
    }

    /**
     * Test of emptyEigenschap method, of class Vak.
     */
    @Test
    public void testEmptyEigenschap() {
        System.out.println("emptyEigenschap");
        Vak instance = null;
        instance.emptyEigenschap();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of requestVakEigenschap method, of class Vak.
     */
    @Test
    public void testRequestVakEigenschap() {
        
        Speelveld s = new Speelveld();
        System.out.println("requestVakEigenschap");
        Speler speler = new Speler(2,2);
        Vak instance = new Vak("#FFFFFFF");
        boolean expResult = true;
        boolean result = instance.requestVakEigenschap(speler);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of getVakNummer method, of class Vak.
     */
    @Test
    public void testGetVakNummer() {
        System.out.println("getVakNummer");
        Vak instance = null;
        int expResult = 0;
        int result = instance.getVakNummer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
     
    }

    /**
     * Test of tekenVakAfbeelding method, of class Vak.
     */
    @Test
    public void testTekenVakAfbeelding() {
        System.out.println("tekenVakAfbeelding");
        Vak instance = null;
        Image expResult = null;
        Image result = instance.tekenVakAfbeelding();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
           }
    
}
