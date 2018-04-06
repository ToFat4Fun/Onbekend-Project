/*
   This game is developed by Mucahit Coskun, Jurian van Hoorn and Tarik Sherif, students at The Hague University of Applied Sciences
   If you wish to you use any of this code please refer to the authors or copy this header.
   This is our version of a Maze Game project for Software Engineering 2017-2018 3rd semester.
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
    //ik gebruik setZak om te controleren of de methode wel echt werkt aangezien cosntructor van speler geen zak waarde krijgt
    //en deze methode toch zak gaat vergelijken met barricadeNummer. kortom deze methode kijkt of speler wel juiste sleutel heeft om barricade te openen.
    @Test
    public void testVakEigenschap_Speler() {
        System.out.println("vakEigenschap");
        Speler speler = new Speler(10,10);
        speler.setZak(0); //comment dit en zet expResult false voor andere correcte werking of verander waarde en zet result false om andere pop-up bericht te testen.
        Barricade instance = new Barricade(10,20,200); //geef barricade x,y en waarde van barricade
        boolean expResult = false;
        boolean result = instance.vakEigenschap(speler);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of vakEigenschap method, of class Barricade.
     */
    //kijkt alleen of speler op dit type vak mag lopen, zie methode hierboven voor uitbreiding.
    @Test
    public void testVakEigenschap_0args() {
        System.out.println("vakEigenschap 0 args");
        Barricade instance = new Barricade(30,30, 300);
        boolean expResult = false;
        boolean result = instance.vakEigenschap();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
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
