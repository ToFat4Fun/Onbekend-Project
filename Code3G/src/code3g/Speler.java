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
 * @author Tarik
 */
public class Speler {

    private Image huidigeAfbeelding;
    private Vak vak;
    private int xC;
    private int yC;
    private int zak;

    //4 afbeeldingen die wij gebruiken voor Speler..
    private final Image up = new ImageIcon("src\\Assets\\move_up.png").getImage();
    private final Image left = new ImageIcon("src\\Assets\\move_left.png").getImage();
    private final Image right = new ImageIcon("src\\Assets\\move_right.png").getImage();
    private final Image down = new ImageIcon("src\\Assets\\move_down.png").getImage();

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
    public Image getHuidigeAfbeelding() {
        return huidigeAfbeelding;
    }

    //4 methoden om huidige afbeelding me in te stellen, zie speelveld en key events...
    public void setHuidigeAfbeeldingRechts() {
        this.huidigeAfbeelding = right;
    }

    public void setHuidigeAfbeeldingLinks() {
        this.huidigeAfbeelding = left;
    }

    public void setHuidigeAfbeeldingUp() {
        this.huidigeAfbeelding = up;
    }

    public void setHuidigeAfbeeldingDown() {
        this.huidigeAfbeelding = down;
    }

    public void lopen(KeyEvent e, Vak[][] allVak) {

        //wanneer een toetsenbord gedrukt is, voert deze methode uit
        if (e.getID() != KeyEvent.KEY_PRESSED) // als een actie van een knop niet gedrukt is, dan gebeurt er niks
        {
            return;
        }
        // als een gebruiker op een toets drukt, behalve pijltoetsen. dan gebeurt er niks.
        if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_UP) 
        {        //x en y aanmaken om te controleren of speler niet buiten bounds gaat...
            int x = this.xC;// locatie van huidige pathX
            int y = this.yC; // locatie van huidige pathY
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
            //set de bounds. speler mag alleen verplaatsen als hij zich op een van de vakken bevindt. controleer met x en y
            //zouden x en y out of bounds gaan dan wordt xC en xY van Speler niet geupdate en kan Speler niet 'out of map' gaan..
            if (x >= 0 && x <= 9 && y >= 0 && y <= 9) {
                //als een vak muur heeft, dan kan de speler niet verder lopen.
                if (allVak[y][x].getEigenschap() instanceof Muur) {
                } else {
                    this.vak = allVak[y][x];//speler staat op geselecteerd vak.

                    //interactie tussen de speler en het vak
                    if (vak.tellVakEigenschap(this)) {// als er een interactie geweest is, dan worden een speelobject/eigenschap leeggegooid.
                        if (vak.getEigenschap() instanceof Eindbestemming) { // eindbestemming mag niet leeggegooid worden.
                        } else {
                            vak.emptyEigenschap(); // Eigenschap in vak leeggooien.
                        }
                        //coordinaten van de speler updaten en vervolgens staat de speler op een nieuwe vak
                        this.xC = x;
                        this.yC = y;
                    }
                }
            }
        }
    }
}
