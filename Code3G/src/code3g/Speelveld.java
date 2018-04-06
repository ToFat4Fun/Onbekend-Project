/*
   This game is developed by Mucahit Coskun, Jurian van Hoorn and Tarik Sherif, students at The Hague University of Applied Sciences
   If you wish to you use any of this code please refer to the authors or copy this header.
   This is our version of a Maze Game project for Software Engineering 2017-2018 3rd semester.
 */
package code3g;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.Timer;

/**
 *
 * @author mucis
 */
//extends JComponent om de paar pixels te verfen. panel niet aan te raden.
public class Speelveld extends JComponent implements ActionListener, KeyListener {

    private Timer timer;// delay tijd voor ActionListener aanmaken. bron: https://stackoverflow.com/questions/22366890/java-timer-action-listener
    private Vak[][] vak;// object vak declareren

    private Speler speler;

    private final int ROW = 10;
    private final int COL = 10;

    public Speelveld() {
        vak = new Vak[10][10]; // heeft 100 vakken. 
        speler = new Speler(0, 0); // startpositie 0,0
        createVakken();
        addKeyListener(this);// toetsenbord aan KeyListener koppelen
        setFocusable(true);// deze window/applicatie focusen om keyboard werkend te krijgen.
        timer = new Timer(50, this); // delay this classe voor 50 milieseconden. net als bij Arduino. maar dit heeft te maken met ActionListener
        timer.start();// Activeer Timer. na iedere actie wordt verleng de timer dit programma.
        speler.setHuidigeAfbeeldingRechts();// standaard afbeelding. hoe speler in begint staat..
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
                g.setColor(Color.decode(vak[row][col].getKleur())); // geeft een geselecteerd kleur aan vak. decode omdat kleur een hex-code is..
                g.fillRect(50 * col, 50 * row, 50, 50); //maak een vierkant 50x50 pixels.
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
                vak[row][col] = new Vak("#B9E6F0");// object aanmaken met kleur parameter (hex-code)
            }
        }
    }

    //activeer wanneer er een actie is. als in andere method een repaint wilt toevoegen, dan is dat niet meer nodig.
    @Override
    public void actionPerformed(ActionEvent e) { // wanneer een dit klasse op focus gezet is, dan repaint hij de heletijd.
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        speler.lopen(e, vak);
        // de reden dat vak array is, om een eigenschap op te halen, denk aan muren en eindbestemming.
        //Daarna komt er ook een interactie tussen de speler en het vak.
        // Normaal gesproken staat speler op 1 vak, maar dit is alleen voor een parameter dependency.
        //daarom is KeyListener hier geplaatst.
    }

    @Override // moet implementeren van KeyListener.
    public void keyTyped(KeyEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override //moet implementeren van KeyListener.
    public void keyReleased(KeyEvent e) {
        //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
