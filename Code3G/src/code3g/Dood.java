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
 * @author mucis
 */
public class Dood  extends Eigenschap implements Melding {
    
    private StartScherm startscherm;
    
    public Dood(int xC, int yC, StartScherm startscherm) {

        super( "dood.png", xC, yC);
        this.startscherm = startscherm;
    }

    //methode die vakSoort moet vervangen..
    public boolean vakEigenschap() {
        meldingTonen("Helaas, je viel in het vak. Dus je bent dood!.");
        // hier komt binnenkort extra functie als direct startscherm tonen.
        
        startscherm.heropenStartscherm();// heropen startscherm
        return true;
    }

     //methode die vakSoort moet vervangen..
    public boolean vakEigenschap(Speler speler) {
        return false;
    }
    //----------------insert something that happens when Speler steps on eindbestemming..
    public void meldingTonen(String tekst) {
        JFrame venster = new JFrame();
        JOptionPane.showMessageDialog(venster,tekst);
        // binnenkort uitbreiden
    }
}
