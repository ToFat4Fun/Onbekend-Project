/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code3g;


import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Ta
 */
public class Speler  {

    
    private Image huidigeAfbeelding;   
    
    private int xC;
    private int yC;
    private int zak;
    private final Image up= new ImageIcon("src\\Assets\\move_up.png").getImage();
    private final Image left= new ImageIcon("src\\Assets\\move_left.png").getImage();
    private final Image right= new ImageIcon("src\\Assets\\move_right.png").getImage();
    private final Image down= new ImageIcon("src\\Assets\\move_down.png").getImage();
    
    
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
    public Image getHuidigeAfbeelding(){
        return huidigeAfbeelding;
    }
    public void setHuidigeAfbeeldingRechts(){
        this.huidigeAfbeelding = right;
    }
    public void setHuidigeAfbeeldingLinks(){
        this.huidigeAfbeelding = left;
    }
    public void setHuidigeAfbeeldingUp(){
        this.huidigeAfbeelding = up;
    }
    public void setHuidigeAfbeeldingDown(){
        this.huidigeAfbeelding = down;
    }
    
    
}


