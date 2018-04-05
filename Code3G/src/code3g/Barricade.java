/*
   This game is developed by Mucahit Coskun, Jurian van Hoorn and Tarik Sherif, students at The Hague University of Applied Sciences
   If you wish to you use any of this code please refer to the authors or copy this header.
   This is our version of a Maze Game project for Software Engineering 2017-2018 3rd semester.
 */
package code3g;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author jurian
 */
public class Barricade extends Eigenschap implements Melding {

    private int barricadeNummer;

    //constructor
    public Barricade(int xC, int yC, int barricadeNummer) {
        super("hek.png", xC, yC);
        this.barricadeNummer = barricadeNummer;
    }

    //get/set for barricadeNummer which is the value of the barricade (the value determines which key is needed to open)
    public int getBarricadeNummer() {
        return barricadeNummer;
    }

    public void setBarricadeNummer(int barricadeNummer) {
        this.barricadeNummer = barricadeNummer;
    }

//methode die vakSoort moet vervangen..
    public boolean vakEigenschap(Speler speler) {

        // als een sleutel in een barricade past mag speler op vak lopen (return true)
        if (speler.getZak() == barricadeNummer) {
            return true;
        } 
        // anders een melding tonen. aanroepen meldingTonen methode
        //default speler heeft geen sleutel en waarde is dan dus 0. print dat speler geen sleutel bij zich heeft!
        else if (speler.getZak() == 0) {
            meldingTonen("je hebt geen sleutel!");
            return false;
        } //als zak waarde niet overeenkomt met barricade waarde..
        else{
            meldingTonen("Sleutel past niet!");
            return false;
        }
    }
    public boolean vakEigenschap()
    {
        return false;
    }
    
    @Override
    public void meldingTonen(String tekst) {
        JFrame venster = new JFrame();
        JOptionPane.showMessageDialog(venster,tekst);
        
    }
}
