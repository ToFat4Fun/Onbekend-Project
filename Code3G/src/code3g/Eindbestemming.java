/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code3g;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author jurian
 */
public class Eindbestemming extends Eigenschap implements Melding {

    public Eindbestemming(int xC, int yC) {

        super( "finish2.png", xC, yC);
    }

    //methode die vakSoort moet vervangen..
    public boolean vakEigenschap() {
        meldingTonen("je hebt gewonnen");
        // hier komt binnenkort extra functie als direct startscherm tonen.
        return true;
    }

     //methode die vakSoort moet vervangen..
    public boolean vakEigenschap(Speler speler) {
        return false;
    }
    //----------------insert something that happens when Speler steps on eindbestemming..
    public void meldingTonen(String tekst) {
        JFrame venster = new JFrame();
        JOptionPane.showMessageDialog(venster,"Je hebt gewonnen!");
        // binnenkort uitbreiden
    }

    public void meldingTonen() {
        //...
    }
}
