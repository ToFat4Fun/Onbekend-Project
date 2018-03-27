/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code3g;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.Timer;

/**
 *
 * @author mucis
 */
//extends JComponent om de paar pixels te verfen. panel niet aan te raden.
public class Speelveld extends JComponent implements ActionListener {

    private Timer timer;// delay tijd voor ActionListener aanmaken. bron: https://stackoverflow.com/questions/22366890/java-timer-action-listener
    private Vak[][] vak;// object vak declareren

    private Speler speler;

    private final int ROW = 10;
    private final int COL = 10;

    public Speelveld() {
        vak = new Vak[10][10]; // heeft 100 vakken. 
        speler = new Speler(0, 0); // startpositie 0,0
        addKeyListener(new Toetsenbord());// toetsenbord aan KeyListener koppelen
        setFocusable(true);// this applicatie focuseren, om een toetsenbord werken te krijgen.
        timer = new Timer(50, this); // delay this classe voor 25 milieseconden. net als bij Arduino
        timer.start();// Activeer Timer. na iedere actie wordt verleng de timer dit programma.
        speler.setHuidigeAfbeeldingRechts();// standaard afbeelding
    }

    //voeg hier eigenschap toe aan corresponding vak. 
    public void addEigenschap(ArrayList<Eigenschap> e) {

        for (Eigenschap eigenschap : e) {
            vak[eigenschap.getxC()][eigenschap.getyC()].addEigenschap(eigenschap);
        }
    }

    @Override
    public void paint(Graphics g
    ) {
        g.translate(100, 100); // geeft een positie van een aangemaakt paint

        for (int row = 0; row < ROW; row++)// for loop om alle vakken te tonen
        {
            for (int col = 0; col < COL; col++) // for loop alle kolommen
            {

                Color color; // kleur object van een vak declareren
                g.setColor(Color.decode(vak[row][col].getKleur())); // geeft een geselecteerd kleur aan vak
                g.fillRect(50 * col, 50 * row, 50, 50); //maak een vierkant 30x30 pixels.
                g.setColor(Color.BLACK); // kleur van een rand is zwart
                g.drawRect(50 * col, 50 * row, 50, 50); // teken randen om een vak heen

                //controleer of corresponding vak wel een afbeelding bevat. is dit waar teken dan de afbeelding van betreffende vak
                if (vak[row][col].getEigenschap() != null) {
                    g.drawImage(vak[row][col].tekenVakAfbeelding(), 50 * col, 50 * row, 50, 50, null);

                    //nummer toevoegen als het vak een sleutel of een barricade is.
                    if (vak[row][col].getEigenschap() instanceof Sleutel || vak[row][col].getEigenschap() instanceof Barricade) {
                        g.setFont(new Font("default", Font.BOLD, 20)); // font aanpassen en in dikgedrukt weergeven    
                        g.setColor(Color.decode("#F")); // zwart kleur

                        g.drawString(vak[row][col].getVakNummer() + "", 50 * col + 10 - 1, 50 * row + 45 - 1); // een stapje terug om de outlijn te tonen

                        g.setColor(Color.decode("#FFFFFF")); // witte kleur
                        g.drawString(vak[row][col].getVakNummer() + "", 50 * col + 10, 50 * row + 45);// toon nummer, maar dan onderaan van iedere geselecteerde vakken.

                    }
                }

            }

        }
        //teken de speler (sprites), beweeg speler steeds met 50 pixels (grootte van vak), +1 om hem aligned te krijgen.
        g.drawImage(speler.getHuidigeAfbeelding(), (speler.getxC() * 50) + 1, (speler.getyC() * 50) + 1, 49, 49, this);
    }

    //Vak initiliseren
    public void createVakken() {

        for (int row = 0; row < ROW; row++)// for loop om alle vakken te tonen
        {
            for (int col = 0; col < COL; col++) // for loop alle kolommen
            {
                vak[row][col] = new Vak("#B9E6F0");// object aanmaken met 
            }
        }
    }

    //activeer wanneer er een actie is. als in andere method een repaint wilt toevoegen, dan is dat niet meer nodig.
    public void actionPerformed(ActionEvent e) { // wanneer een dit klasse op focus gezet is, dan repaint hij de heletijd.
        repaint();
    }

    //inner class creeren, omdat keyAdapter beter is dan interface KeyListener, omdat KeyPressed methode alleen nodig is.
    //daardoor hoef je de andere methoden niet te implementeren.
    public class Toetsenbord extends KeyAdapter {

        //wanneer een toetsenbord gedrukt is, voert dit methode uit
        public void keyPressed(KeyEvent e) {
            //wanneer een toetsenbord gedrukt is, voert dit methode uit
            if (e.getID() != KeyEvent.KEY_PRESSED) // als een actie van een knop niet gedrukt, dan gebeurt er niks
            {
                return;
            }
            int x = speler.getxC();// locatie van huidige pathX
            int y = speler.getyC(); // locatie van huidige pathY
            switch (e.getKeyCode()) { // haalt waarde van toetsenbord op

                //setHuidigeAfbeelding: verander de huidige afbeelding naar respectieve selectie van een toetsenbord.
                case KeyEvent.VK_RIGHT: // als recht, dan eentje opzij
                    speler.setHuidigeAfbeeldingRechts();
                    System.out.println("Speler beweegt naar rechts");
                    x += 1;
                    break;
                case KeyEvent.VK_LEFT:// eentje terug naar links
                    speler.setHuidigeAfbeeldingLinks();
                    System.out.println("Speler beweegt naar links");
                    x -= 1;
                    break;
                case KeyEvent.VK_DOWN:// naar benenden
                    speler.setHuidigeAfbeeldingDown();
                    System.out.println("Speler beweegt naar beneden");
                    y += 1;
                    break;
                case KeyEvent.VK_UP: // naar boven
                    speler.setHuidigeAfbeeldingUp();
                    System.out.println("Speler beweegt naar boven");
                    y -= 1;
                    break;
                default:
                    break;
            }
            //set de bounds. speler mag alleen verplaatsen als hij zich op een van de vakken bevindt. als hij er buiten zou komen gebeurt er niets..
            if (x >= 0 && x <= 9 && y >= 0 && y <= 9) {
                //als een vak muur heeft, dan kan de speler niet verder lopen.
                if (vak[y][x].getEigenschap() instanceof Muur) {
                } else {
                    speler.lopen(x, y, vak[y][x]); 
                    //coordinaten van de speler updaten en vervolgens staat de speler op een nieuwe vak
                }

            }
        }

    }

}
