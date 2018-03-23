/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code3g;

/**
 *
 * @author Ta
 */
public class Speler {
    
    
    private int xC;
    private int yC;
    private int zak;
    
    //constructor
    public Speler(int xC, int yC) {
        this.xC = xC;
        this.yC = yC;
    }

    
     public int getxC() {
        return xC;
    }

    public void setxC(int xC) {
        this.xC = xC;
    }

    
    public int getyC() {
        return yC;
    }

    public void setyC(int yC) {
        this.yC = yC;
    }

    
    public int getZak() {
        return zak;
    }
    
    public void setZak(int zak) {
        this.zak = zak;
    }
    
    
    //methods for moving the Speler..
    public void moveRight() {
    }

    public void moveLeft() {
    }

    public void moveUp() {
    }

    public void moveDown() {
    }
}   

