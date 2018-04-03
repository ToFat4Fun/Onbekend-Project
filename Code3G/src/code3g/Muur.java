/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
