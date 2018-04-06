/*
   This game is developed by Mucahit Coskun, Jurian van Hoorn and Tarik Sherif, students at The Hague University of Applied Sciences
   If you wish to you use any of this code please refer to the authors or copy this header.
   This is our version of a Maze Game project for Software Engineering 2017-2018 3rd semester.
 */
package code3g;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
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
public class SpelerTest {

    public SpelerTest() {
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
     * Test of getxC method, of class Speler.
     */
    @Test
    public void testGetxC() {
        System.out.println("getxC");
        Speler instance = new Speler(10, 10);
        int expResult = 10; //haal xC op, is 10 in dit geval
        int result = instance.getxC();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setxC method, of class Speler.
     */
    @Test
    public void testSetxC() {
        System.out.println("setxC");
        int xC = 20; //updates xC van 10 naar 20, test met println
        Speler instance = new Speler(10, 10);
        instance.setxC(xC);
        System.out.println(instance.getxC());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getyC method, of class Speler.
     */
    @Test
    public void testGetyC() {
        System.out.println("getyC");
        Speler instance = new Speler(10, 10);
        int expResult = 10; //haal yC op, is 10 in dit geval
        int result = instance.getyC();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setyC method, of class Speler.
     */
    @Test
    public void testSetyC() {
        System.out.println("setyC");
        int yC = 50; //updates yC van 20 naar 50, test met println
        Speler instance = new Speler(10, 20);
        instance.setyC(yC);
        System.out.println(instance.getyC());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getZak method, of class Speler.
     */
    @Test
    public void testGetZak() {
        System.out.println("getZak");
        Speler instance = new Speler(10, 10);
        instance.setZak(500); //omdat je waarde aan zak moet geven anders is deze test useless
        int expResult = 500; //we verwachten 500 omdat dit net is ingesteld
        int result = instance.getZak();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setZak method, of class Speler.
     */
    @Test
    public void testSetZak() {
        System.out.println("setZak");
        int zak = 20;
        Speler instance = new Speler(10, 10);
        instance.setZak(zak);
        System.out.println(instance.getZak()); //println om te kijken of setZak daadwerkelijk iets ingevuld heeft
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of lopen method, of class Speler.
     */
    @Test
    public void testLopen() {
        System.out.println("lopen");
        Speelveld speelveld = new Speelveld();
        //pijl omlaag is gedrukt.
        KeyEvent e = new KeyEvent(speelveld, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_LEFT, 'Z');

        ArrayList<Eigenschap> eigenschappen = new ArrayList<Eigenschap>();
        Speler speler = new Speler(2, 1);
        
        int[][] normaleMap3 = new int[][]{
            {0, 1, 1, 1, 4, 1, 1, 1, 1, 1}, 
            {0, 3, 2, 1, 2, 1, 0, 0, 0, 1},
            {1, 0, 2, 1, 2, 1, 0, 0, 3, 1},
            {1, 0, 2, 1, 2, 1, 2, 1, 1, 1},
            {1, 0, 2, 1, 0, 1, 0, 1, 0, 1},
            {1, 0, 2, 0, 0, 0, 0, 1, 3, 1},
            {1, 0, 2, 0, 0, 0, 0, 1, 0, 1},
            {1, 0, 2, 0, 0, 0, 0, 2, 0, 1},
            {1, 0, 2, 0, 0, 0, 0, 2, 0, 1},
            {1, 1, 1, 1, 3, 1, 1, 1, 1, 1}
        };

        int[][] normaleMapNummer3 = new int[][]{
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 100, 110, 0, 300, 0, 0, 0, 0, 0},
            {0, 0, 100, 0, 200, 0, 0, 0, 200, 0},
            {0, 0, 100, 0, 200, 0, 100, 0, 0, 0},
            {0, 0, 300, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 80, 0, 0, 0, 0, 0, 300, 0},
            {0, 0, 100, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 200, 0, 0, 0, 0, 300, 0, 0},
            {0, 0, 200, 0, 0, 0, 0, 200, 0, 0},
            {0, 0, 1, 0, 200, 0, 0, 0, 0, 0}
        };

        for (int i = 0; i < normaleMap3.length; i++) {
            for (int j = 0; j < normaleMap3[i].length; j++) {

                if (normaleMap3[i][j] == 1) {
                    eigenschappen.add(new Muur(i, j));
                }

                if (normaleMap3[i][j] == 2) {
                    //  System.out.println(map[i][j]);
                    eigenschappen.add(new Barricade(i, j, normaleMapNummer3[i][j]));
                }

                if (normaleMap3[i][j] == 3) {
                    eigenschappen.add(new Sleutel(i, j, normaleMapNummer3[i][j]));
                }

                if (normaleMap3[i][j] == 4) {
                    eigenschappen.add(new Eindbestemming(i, j));
                }
            }

            Vak[][] allVak = new Vak[10][10];
            
            for (int row = 0; row < 10; row++)// for loop om alle vakken te tonen
            {
                for (int col = 0; col < 10; col++) // for loop alle kolommen
                {
                    allVak[row][col] = new Vak("#B9E6F0");// object aanmaken met kleur parameter (hex-code)
                }
            }
            for (Eigenschap eigenschap : eigenschappen) {
                allVak[eigenschap.getxC()][eigenschap.getyC()].addEigenschap(eigenschap);
            }

            Speler instance = speler;
            instance.lopen(e, allVak);
            // TODO review the generated test code and remove the default call to fail.
            //fail("The test case is a prototype.");
        }
    }

}
