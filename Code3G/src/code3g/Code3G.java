/*
   This game is developed by Mucahit Coskun, Jurian van Hoorn and Tarik Sherif, students at The Hague University of Applied Sciences
   If you wish to you use any of this code please refer to the authors or copy this header.
   This is our version of a Maze Game project for Software Engineering 2017-2018 3rd semester.
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
        startScherm.setTitle("BarricadeSleutel spel groep 3.5.7 2018");// naam van het scherm
        startScherm.setSize(500, 400);// breedte en hoogte instellen
        startScherm.setLocationRelativeTo(null);
        startScherm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// zet scherm afsluiten als een standaard

        startScherm.setVisible(true);
    }

}
