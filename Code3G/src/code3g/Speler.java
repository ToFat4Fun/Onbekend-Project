/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code3g;


import java.awt.event.KeyEvent;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Graphics;
/**
 *
 * @author Ta
 */
public class Speler extends JFrame  {

    
    private Image huidigeAfbeelding;   
    
    private int xC;
    private int yC;
    private int zak;
    private Image up= new ImageIcon("move_up.png").getImage();
    private Image left= new ImageIcon("move_left.png").getImage();
    private Image right= new ImageIcon("move_right.png").getImage();
    private Image down= new ImageIcon("move_down.png").getImage();
    
    
    //constructor
    public Speler(int xC, int yC, int zak) {
        this.xC = xC;
        this.yC = yC;
        this.zak = zak;
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
    
    

    
    @Override
    protected void processKeyEvent(KeyEvent e) // toetsenbord actie
    {
        if (e.getID() != KeyEvent.KEY_PRESSED) // als een actie van een knop niet gedrukt, dan gebeurt er niks
        {
            return;
        }

        int x = 1;// locatie van huidige pathX
        int y = 1; // locatie van huidige pathY
        switch (e.getKeyCode()) { // haalt waarde van toetsenbord op

            case KeyEvent.VK_RIGHT: // als recht, dan eentje opzij
                huidigeAfbeelding = right;
                x += 1;
                break;
            case KeyEvent.VK_LEFT:
                huidigeAfbeelding = left;
                x -= 1;
                break;
            case KeyEvent.VK_DOWN:
                huidigeAfbeelding = down;
                y += 1;
                break;
            case KeyEvent.VK_UP: 
                huidigeAfbeelding = up;
                y -= 1;
                break;
            default:
                break;
        }
        setxC(x);
        setyC(y);
        repaint();
    }
    
    
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.drawImage(huidigeAfbeelding, xC, yC, rootPane);
        repaint();
    }
}   

