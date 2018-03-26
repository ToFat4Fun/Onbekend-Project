/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code3g;

import java.util.ArrayList;

/**
 *
 * @author mucis
 */
public class Code3G {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ArrayList<Eigenschap> eigenschappen = new ArrayList<Eigenschap>();

        //test
        Speelveld speelveld = new Speelveld();
        
        /*
        eigenschappen:
        nummer 0 is lege vak;
        nummer 1 is een muur
        nummer 2 is een barricade
        nummer 3 is sleutelvak
        nummer 4 is eindbestemming
        */
        int[][] map = new int[][]{
            {0, 1, 2, 0, 0, 0, 0, 2, 2, 2},
            {0, 0, 0, 0, 3, 3, 0, 2, 2, 2},
            {0, 0, 2, 0, 0, 0, 0, 2, 2, 3},
            {0, 1, 2, 0, 0, 0, 0, 2, 2, 2},
            {0, 1, 2, 2, 1, 1, 1, 2, 2, 2},
            {0, 2, 2, 0, 0, 0, 1, 2, 2, 0},
            {0, 1, 2, 1, 1, 2, 1, 1, 0, 0},
            {0, 1, 2, 2, 2, 2, 0, 0, 0, 0},
            {3, 1, 2, 2, 0, 0, 0, 1, 0, 0},
            {0, 1, 2, 2, 0, 0, 0, 1, 0, 4}
        };
        //codenummer voor alle vakken
        int[][] mapNummer = new int[][]{
            {0, 0, 100, 0, 0, 0, 0, 30, 70, 90},
            {0, 0, 0, 0, 100, 300, 0, 90, 40, 90},
            {0, 0, 100, 0, 0, 0, 0, 300, 300, 100},
            {0, 0, 100, 0, 0, 0, 0, 190, 80, 90},
            {0, 0, 100, 100, 0, 0, 0, 220, 100, 50},
            {0, 200, 100, 0, 0, 0, 0, 100, 360, 0},
            {0, 0, 100, 0, 0, 300, 0, 0, 0, 0},
            {0, 0, 100, 900, 500, 100, 0, 0, 0, 0},
            {200, 0, 100, 50, 0, 0, 0, 0, 0},
            {0, 0, 100, 150, 0, 0, 0, 0, 0, 0}
        };

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                
                if (map[i][j] == 1) {
                    eigenschappen.add(new Muur(i, j));
                }

                if (map[i][j] == 2) {
                    //  System.out.println(map[i][j]);
                    eigenschappen.add(new Barricade(i, j, mapNummer[i][j]));
                }

                if (map[i][j] == 3) {
                    eigenschappen.add(new Sleutel(i, j, mapNummer[i][j]));
                }

                if (map[i][j] == 4) {
                    eigenschappen.add(new Eindbestemming(i, j));
                }
            }
        }
        speelveld.createVakken();
        //speelveld.addEigenschappenForVakken(eigenschappen);
        speelveld.repaint();
        speelveld.setVisible(true);//open het applicatie/scherm.  

    }
    
}
