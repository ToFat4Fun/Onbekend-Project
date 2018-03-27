/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code3g;

import javax.swing.JFrame;

/**
 *
 * @author mucis
 */
public class Code3G {

    /**
     * @param args the command line arguments even updaten
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Speelveld speelveld = new Speelveld();
        StartScherm startScherm = new StartScherm(speelveld);
        startScherm.setTitle("StartScherm BarricadeSleutel spel door groep 3.5.7 2018");// naam van het scherm
        startScherm.setSize(300, 100);// breedte en hoogte instellen
        startScherm.setLocationRelativeTo(null);
        startScherm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// zet scherm afsluiten als een standaard

        startScherm.setVisible(true);
    }

}
