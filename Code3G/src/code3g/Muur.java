/*
   This game is developed by Mucahit Coskun, Jurian van Hoorn and Tarik Sherif, students at The Hague University of Applied Sciences
   If you wish to you use any of this code please refer to the authors or copy this header.
   This is our version of a Maze Game project for Software Engineering 2017-2018 3rd semester.
 */
package code3g;

/**
 *
 * @author jurian
 */
public class Muur extends Eigenschap {
    
    public Muur( int xC, int yC) {
        super("muur.png", xC, yC);
    }
    
     public  boolean vakEigenschap()
    {
        return false;
        // Speler mag niet op het veld lopen.
    }
}
