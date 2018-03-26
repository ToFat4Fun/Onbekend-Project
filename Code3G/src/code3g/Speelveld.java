/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code3g;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author mucis
 */
public class Speelveld extends JFrame {

    private Vak[][] vak;// object vak declareren

    private Speler speler;
    
    
    private final int ROW = 10;
    private final int COL = 10; 


    @Override
    public void paint(Graphics g) {
        super.paint(g);// paint constructeren
        g.translate(100, 100); // geeft een positie van een aangemaakt paint

        for (int row = 0; row < 10; row++)// for loop om alle vakken te tonen
        {
            for (int col = 0; col < 10; col++) // for loop alle kolommen
            {
                vak[row][col] = new Vak("#a90a08");

                Color color; // kleur object van een vak declareren

                g.setColor(Color.decode(vak[row][col].getKleur())); // geeft een geselecteerd kleur aan vak
                g.fillRect(50 * col, 50 * row, 50, 50); //maak een vierkant 30x30 pixels.
                g.setColor(Color.BLACK); // kleur van een rand is zwart
                g.drawRect(50 * col, 50 * row, 50, 50); // teken randen om een vak heen
            }
        }
        
        
        g.drawImage(speler.getHuidigeAfbeelding(), speler.getxC() * 50, speler.getyC() * 50, 49, 49, rootPane);

        //voor spelers:: binnenkort
        //g.setColor(Color.decode("#176b08")); // kleur van een speler
        // g.fillOval(pathX * 30, pathY *30, 30, 30); // speler positioneren van een aangevende coordinaten
    }
    
    public void createVakken()
    {
        
    }
    public Speelveld() {
        vak = new Vak[10][10];
        speler = new Speler(0,0);
        speler.setHuidigeAfbeeldingRechts();
        setTitle("Test");// naam van het scherm
        setSize(700, 700);// breedte en hoogte instellen
        setLocationRelativeTo(null);// zet in het midden van het scherm
        setResizable(false);// de grootte van het scherm niet wijzigen.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// zet scherm afsluiten als een standaard
        setVisible(true);//open het applicatie/scherm.
    }

    @Override
    protected void processKeyEvent(KeyEvent e) // toetsenbord actie
    {
        if (e.getID() != KeyEvent.KEY_PRESSED) // als een actie van een knop niet gedrukt, dan gebeurt er niks
        {
            return;
        }
        int x = speler.getxC();// locatie van huidige pathX
        int y = speler.getyC(); // locatie van huidige pathY
        switch (e.getKeyCode()) { // haalt waarde van toetsenbord op

            case KeyEvent.VK_RIGHT: // als recht, dan eentje opzij
                speler.setHuidigeAfbeeldingRechts();
                x += 1;
                break;
            case KeyEvent.VK_LEFT:// eentje terug naar links
                speler.setHuidigeAfbeeldingLinks();
                x -= 1;
                break;
            case KeyEvent.VK_DOWN:// naar benenden
                speler.setHuidigeAfbeeldingDown();
                y += 1;
                break;
            case KeyEvent.VK_UP: // naar boven
                speler.setHuidigeAfbeeldingUp();
                y -= 1;
                break;
            default:
                break;
        }
        
        
        if (x >= 0 && x <=9 && y >= 0 && y <=9){
            
        speler.setxC(x); //update x en y coordinaat van de speler
        speler.setyC(y);
        repaint();
        }
    }
        /*
            if(vak[y][x].getCoordinatesOfEigenschap == 1) // als de aangevende positie van vak een muur bevat, dan een  melding tonen.
            {
                  System.out.println("Maze waarde is: "+ Vak[pathX][pathY]);
                System.out.println("muur!");

            }
            else
            {     changePosition(y,x); // pas de positie van speler aan.
                  repaint(); // repaint
                  System.out.println("Maze waarde is: "+ Vak[pathX][pathY]);
                  
                  if(Vak[y][x] == 9) // als een speler op eindbestemming heeft bereikt, dan is het spel uitgespeeld.
                  {
                      System.out.println("Game Finished!");
                  }
            }
         */
    
    //voorspeler

    
    public void Start(){}
    public void Restart(){}
    public void End(){}
}
