/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code3g;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

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


        StartScherm startScherm = new StartScherm();
        startScherm.setTitle("StartScherm BarricadeSleutel spel door groep 3.5.7 2018");// naam van het scherm
        startScherm.setSize(300, 100);// breedte en hoogte instellen
        startScherm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// zet scherm afsluiten als een standaard

        startScherm.setVisible(true);
    }

}
