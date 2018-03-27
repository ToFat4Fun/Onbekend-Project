/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code3g;

import java.awt.Color;
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
                if(vak[row][col].getEigenschap() != null){
                g.drawImage(vak[row][col].tekenVakAfbeelding(), 50 * col, 50 * row, 50, 50, null);
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
            speler.lopen(e);

        }
        
 
    }
    
   
}
            

