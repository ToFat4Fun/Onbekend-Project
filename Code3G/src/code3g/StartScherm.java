/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code3g;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author jurian
 */
public class StartScherm extends JFrame {

    ArrayList<Eigenschap> eigenschappen = new ArrayList<Eigenschap>();
    private MoeilijkheidsGraad moeilijkheidsGraad; // moeilijkheidsgraad declareren
    private JButton[] button = new JButton[]{
        new JButton(MoeilijkheidsGraad.makkelijk.name()), //bron :https://stackoverflow.com/questions/3978654/best-way-to-create-enum-of-strings
        new JButton(MoeilijkheidsGraad.normaal.name()),
        new JButton(MoeilijkheidsGraad.moeilijk.name())
    };

    private JButton[] speelveldButton = new JButton[]{
        new JButton("Start"),
        new JButton("Restart"),
        new JButton("Stoppen")
    };

    public enum MoeilijkheidsGraad { // bron: https://stackoverflow.com/questions/3978654/best-way-to-create-enum-of-strings
        makkelijk, normaal, moeilijk
    } // moeilijkheidsGraad in enum datatype.

    public StartScherm(Speelveld speelveld) {

        new JFrame();

        JPanel BottomPanel = new JPanel();// Paneel voor 3 knoppen aanmaken
        JLabel text = new JLabel("  kies moeilijkheidsgraad"); //beetje spatie toevoegen
        BottomPanel.setLayout(new GridLayout(1, 3));

        BottomPanel.add(button[0]);
        BottomPanel.add(button[1]);
        BottomPanel.add(button[2]);

        add(text, BorderLayout.CENTER);
        add(BottomPanel, BorderLayout.SOUTH);

        button[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.out.println(button[0].getText());
                setVisible(false);
                OpenSpeelveld("test", speelveld);
            }
        }
        );
    }

    //moeilijkheidsgraad meegeven
    public void OpenSpeelveld(String Graad, Speelveld speelveld) {

        JFrame f = new JFrame();
        f.add(speelveld);
        JPanel BottomPanel = new JPanel();// Paneel voor 3 knoppen aanmaken
        BottomPanel.setLayout(new GridLayout(1, 3));
        
        BottomPanel.add(speelveldButton[0]);
        BottomPanel.add(speelveldButton[1]);
        BottomPanel.add(speelveldButton[2]);
        f.add(BottomPanel, BorderLayout.SOUTH);
        speelveldButton[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.out.println(speelveldButton[0].getText());
                speelveldButton[0].setFocusable(false);
                speelveldButton[1].setFocusable(false);
                speelveldButton[2].setFocusable(false);
                speelveld.setFocusable(true);// this applicatie focuseren, om een toetsenbord werken te krijgen.

            }
        }
        );

        f.setTitle("BarricadeSleutel spel door groep 3.5.7 2018");// naam van het scherm
        f.setSize(700, 800);// breedte en hoogte instellen
        f.setLocationRelativeTo(null);// zet in het midden van een windows OS.
        f.setResizable(false);// de grootte van het scherm niet wijzigen.
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// zet scherm afsluiten als een standaard
        f.setVisible(true);//open het applicatie/scherm.

        /*
        eigenschappen:
        nummer 0 is lege vak;
        nummer 1 is een muur
        nummer 2 is een barricade
        nummer 3 is sleutelvak
        nummer 4 is eindbestemming
         */
        //eerste makkelijke map
        //TIJDLELIJKE NAAM makkelijk1 omdat het anders nog niet werkt..
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
//tweede makkelijke map
        int[][] MakkelijkMap2 = new int[][]{
            {0, 0, 0, 3, 1, 2, 2, 2, 2, 2},
            {0, 1, 1, 2, 0, 0, 0, 1, 1, 0},
            {0, 1, 0, 1, 0, 0, 1, 2, 3, 0},
            {0, 2, 0, 0, 0, 0, 0, 1, 2, 0},
            {0, 0, 0, 0, 1, 2, 3, 0, 0, 0},
            {1, 0, 1, 1, 0, 0, 0, 3, 0, 0},
            {0, 1, 0, 0, 1, 1, 0, 2, 2, 0},
            {2, 1, 1, 1, 0, 3, 2, 2, 2, 2},
            {0, 0, 1, 1, 1, 1, 1, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 4}
        };

        int[][] MakkelijkMapNummer2 = new int[][]{
            {0, 0, 0, 100, 0, 100, 100, 100, 100, 100},
            {0, 0, 0, 100, 0, 0, 0, 0, 0, 0,},
            {0, 0, 0, 0, 0, 0, 0, 100, 100, 0},
            {0, 100, 0, 0, 0, 0, 0, 0, 100, 0},
            {0, 0, 0, 0, 0, 100, 100, 0, 0, 0,},
            {0, 0, 0, 0, 0, 0, 0, 200, 0, 0,},
            {0, 0, 0, 0, 0, 0, 0, 200, 200, 0,},
            {200, 0, 0, 0, 0, 200, 200, 200, 200, 200,},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},};


        //derde makkelijke map
        int[][] MakkelijkMap3 = new int[][]{
            {0, 3, 2, 2, 2, 2, 2, 2, 2, 2},
            {3, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 3},
            {3, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 3},
            {3, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 1, 1, 3, 1, 1, 1, 1, 1, 1},
            {2, 1, 2, 2, 2, 2, 2, 2, 2, 1},
            {2, 2, 2, 1, 1, 1, 1, 1, 2, 1},
            {2, 3, 1, 1, 1, 1, 1, 1, 1, 4}
        };

        int[][] MakkelijkMapNummer3 = new int[][]{
            {0, 200, 200, 200, 200, 200, 200, 200, 200, 200},
            {300, 200, 200, 200, 200, 200, 200, 200, 200, 200},
            {300, 300, 300, 300, 300, 300, 300, 300, 300, 400},
            {500, 400, 400, 400, 400, 400, 400, 400, 400, 400},
            {500, 500, 500, 500, 500, 500, 500, 500, 500, 600},
            {700, 600, 600, 600, 600, 600, 600, 600, 600, 600},
            {700, 0, 0, 900, 0, 0, 0, 0, 0, 0},
            {700, 0, 800, 800, 800, 800, 800, 800, 800, 0},
            {700, 800, 800, 0, 0, 0, 0, 0, 900, 0},
            {700, 800, 0, 0, 0, 0, 0, 0, 0, 0}
        };

int[][] NormaleMap1 = new int[][]{
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {3, 2, 2, 2, 2, 2, 2, 2, 3, 1},
            {0, 2, 1, 0, 1, 0, 1, 2, 2, 1},
            {0, 2, 1, 0, 0, 0, 1, 2, 2, 1},
            {0, 2, 1, 0, 3, 0, 1, 1, 2, 1},
            {0, 2, 1, 0, 2, 0, 1, 1, 0, 1},
            {0, 2, 1, 2, 1, 2, 2, 1, 3, 1},
            {0, 0, 1, 0, 0, 2, 2, 1, 1, 1},
            {2, 1, 1, 3, 0, 2, 2, 2, 1, 1},
            {3, 1, 1, 1, 1, 1, 1, 2, 2, 4}
        };

        int[][] NormaleMapNummer1 = new int[][]{
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {100, 200, 200, 200, 200, 200, 200, 200, 100, 0},
            {0, 200, 0, 0, 0, 0, 0, 300, 100, 0},
            {0, 40, 0, 0, 0, 0, 0, 200, 100, 0},
            {0, 10, 0, 0, 300, 0, 0, 0, 300, 0},
            {0, 200, 0, 0, 300, 0, 0, 0, 0, 0},
            {0, 100, 0, 200, 0, 300, 300, 100, 100, 0},
            {0, 0, 0, 0, 0, 100, 300, 200, 0, 0},
            {100, 0, 0, 200, 0, 200, 100, 100, 0, 0},
            {200, 0, 0, 0, 0, 0, 0, 100, 100, 0}
        };

        int[][] NormaleMap2 = new int[][]{
            {0, 0, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 2, 2, 0, 2, 3, 1},
            {1, 0, 0, 0, 2, 2, 0, 2, 2, 1},
            {1, 0, 3, 1, 1, 1, 1, 0, 0, 1},
            {1, 0, 1, 1, 2, 4, 1, 0, 0, 1},
            {1, 0, 2, 1, 0, 1, 1, 2, 0, 1},
            {1, 1, 2, 1, 0, 1, 3, 2, 0, 1},
            {1, 0, 2, 1, 2, 3, 2, 2, 0, 1},
            {1, 0, 0, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 2, 0, 3, 1}
        };

        int[][] NormaleMapNummer2 = new int[][]{
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 300, 300, 0, 100, 200, 0},
            {0, 0, 0, 0, 0, 100, 70, 300, 300, 0},
            {0, 0, 300, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 200, 0, 0, 0, 0, 0},
            {0, 0, 200, 0, 0, 0, 0, 100, 0, 0},
            {0, 0, 200, 0, 0, 0, 200, 50, 0, 0},
            {0, 0, 200, 0, 100, 300, 200, 200, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 300, 0, 100, 0}
        };

        int[][] NormaleMap3 = new int[][]{
            {0, 1, 1, 1, 4, 1, 1, 1, 1, 1},
            {0, 3, 2, 1, 2, 1, 0, 0, 0, 1},
            {1, 0, 2, 1, 2, 1, 0, 0, 3, 1},
            {1, 0, 2, 1, 2, 1, 2, 1, 1, 1},
            {1, 0, 2, 1, 0, 1, 0, 1, 0, 1},
            {1, 0, 2, 0, 0, 0, 0, 1, 3, 1},
            {1, 0, 2, 0, 0, 0, 0, 1, 0, 1},
            {1, 0, 2, 0, 0, 0, 0, 2, 0, 1},
            {1, 0, 2, 0, 0, 0, 0, 2, 0, 1},
            {1, 1, 1, 1, 3, 1, 1, 1, 1, 1}
        };

        int[][] NormaleMapNummer3 = new int[][]{
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 100, 110, 0, 300, 0, 0, 0, 0, 0},
            {0, 0, 100, 0, 200, 0, 0, 0, 200, 0},
            {0, 0, 100, 0, 200, 0, 100, 0, 0, 0},
            {0, 0, 300, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 80, 0, 0, 0, 0, 0, 300, 0},
            {0, 0, 100, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 200, 0, 0, 0, 0, 300, 0, 0},
            {0, 0, 200, 0, 0, 0, 0, 200, 0, 0},
            {0, 0, 1, 0, 200, 0, 0, 0, 0, 0}
        };

        int[][] MoeilijkeMap1 = new int[][]{
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 4}
        };

        int[][] MoeilijkeMapNummer1 = new int[][]{
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        int[][] MoeilijkeMap2 = new int[][]{
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 4}
        };
        int[][] MoeilijkeMapNummer2 = new int[][]{
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        int[][] MoeilijkeMap3 = new int[][]{
            {0, 2, 1, 1, 1, 1, 1, 1, 1, 1},
            {3, 3, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 4},
        };

        int[][] MoeilijkeMapNummer3 = new int[][]{
            {0, 9999999, 0, 0, 0, 0, 0, 0, 0, 0},
            {9999999, 9999999, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 4}
        };
               
        //onderstaande code vergelijkt waarde uit gemaakte speelveld en bepaald het type eigenschap..
        for (int i = 0; i < NormaleMap1.length; i++) {
            for (int j = 0; j < NormaleMap1[i].length; j++) {

                if (NormaleMap3[i][j] == 1) {
                    eigenschappen.add(new Muur(i, j));
                }

                if (NormaleMap3[i][j] == 2) {
                    //  System.out.println(map[i][j]);
                    eigenschappen.add(new Barricade(i, j, NormaleMapNummer3[i][j]));
                }

                if (NormaleMap3[i][j] == 3) {
                    eigenschappen.add(new Sleutel(i, j, NormaleMapNummer3[i][j]));
                }

                if (NormaleMap3[i][j] == 4) {
                    eigenschappen.add(new Eindbestemming(i, j));
                }
            }
        }
        speelveld.createVakken();
        speelveld.addEigenschap(eigenschappen); //geeft eigenschap door als parameter aan eigenschappen zodat vak weet welke type eigenschap het is
        speelveld.setVisible(true);//open het applicatie/scherm.  
    }

}
