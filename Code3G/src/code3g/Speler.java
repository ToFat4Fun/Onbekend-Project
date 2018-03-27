/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code3g;


import java.awt.Image;
import java.awt.event.KeyEvent;
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
    //4 afbeeldingen die wij gebruiken voor Speler..
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
    
    //methode om huidige afbeelding op te halen
    public Image getHuidigeAfbeelding(){
        return huidigeAfbeelding;
    }
    //4 methoden om huidige afbeelding me in te stellen, zie speelveld en key events...
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
    
    public void lopen(KeyEvent e)
    {
        //wanneer een toetsenbord gedrukt is, voert dit methode uit
            if (e.getID() != KeyEvent.KEY_PRESSED) // als een actie van een knop niet gedrukt, dan gebeurt er niks
            {
                return;
            }
            int x = getxC();// locatie van huidige pathX
            int y = getyC(); // locatie van huidige pathY
            switch (e.getKeyCode()) { // haalt waarde van toetsenbord op

                //setHuidigeAfbeelding: verander de huidige afbeelding naar respectieve selectie van een toetsenbord.
                case KeyEvent.VK_RIGHT: // als recht, dan eentje opzij
                    setHuidigeAfbeeldingRechts();
                    System.out.println("Speler beweegt naar rechts");
                    x += 1;
                    break;
                case KeyEvent.VK_LEFT:// eentje terug naar links
                    setHuidigeAfbeeldingLinks();
                    System.out.println("Speler beweegt naar links");
                    x -= 1;
                    break;
                case KeyEvent.VK_DOWN:// naar benenden
                    setHuidigeAfbeeldingDown();
                    System.out.println("Speler beweegt naar beneden");
                    y += 1;
                    break;
                case KeyEvent.VK_UP: // naar boven
                    setHuidigeAfbeeldingUp(); 
                    System.out.println("Speler beweegt naar boven");
                    y -= 1;
                    break;
                default:
                    break;
            }
            //set de bounds. speler mag alleen verplaatsen als hij zich op een van de vakken bevindt. als hij er buiten zou komen gebeurt er niets..
            if (x >= 0 && x <= 9 && y >= 0 && y <= 9) {
                setxC(x); //update x coordinaat van de speler
                setyC(y); //update y coordinaat van de speler
            }
        }
    
    
}


