/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code3g;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
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

    
    private int gekozenMoeilijkheidsgraad = 1;
    private int onthoudRestartMap;
    
    private JButton[] speelveldButton = new JButton[]{
        new JButton("Start"),
        new JButton("Restart"),
        new JButton("Stoppen")
    };
    private Speelveld speelveld;

    public enum MoeilijkheidsGraad { // bron: https://stackoverflow.com/questions/3978654/best-way-to-create-enum-of-strings
        makkelijk, normaal, moeilijk
    } // moeilijkheidsGraad in enum datatype.

    public StartScherm(Speelveld speelveld) {

        new JFrame();
        this.speelveld = speelveld;
        this.setLayout(new BorderLayout(3,1));
        
        //JPanel voor image bovenin aanmaken..
        //bron: https://stackoverflow.com/questions/11243724/java-adding-imageicon-to-jlabel
        JPanel afbeeldingPanel1 = new JPanel();
        ImageIcon image = new ImageIcon("src\\Assets\\header.png");
        JLabel imagelabel = new JLabel(image);
        afbeeldingPanel1.add(imagelabel);
        add(afbeeldingPanel1, BorderLayout.NORTH);
        
        
        JPanel BottomPanel = new JPanel();// Paneel voor 3 knoppen aanmaken
        BottomPanel.setLayout(new GridLayout(0, 3));
        //JPanel voor text in midden aanmaken
        JLabel text = new JLabel("kies moeilijkheidsgraad");
        text.setFont(new Font("Serif", Font.BOLD, 18));
        text.setForeground(Color.DARK_GRAY);// bron: http://www.asjava.com/swing/set-jlabel-font-size-and-color/
        JPanel menuTekstPanel = new JPanel(new GridBagLayout());
        //menuTekstPanel.setBackground(Color.red);
        menuTekstPanel.add(text);
        add(menuTekstPanel, BorderLayout.CENTER);
        
        button[0].setPreferredSize(new Dimension(50,50));
        BottomPanel.add(button[0]);
        BottomPanel.add(button[1]);
        BottomPanel.add(button[2]);
        add(BottomPanel, BorderLayout.SOUTH);

        //knop makkelijk
        button[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                gekozenMoeilijkheidsgraad = 1;
                setVisible(false);
                openSpeelveld();
            }
        }
        );

        //knop makkelijk
        button[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                gekozenMoeilijkheidsgraad = 2;
                setVisible(false);
                openSpeelveld();
            }
        }
        );

        //knop moeilijk
        button[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                gekozenMoeilijkheidsgraad = 3;
                setVisible(false);
                openSpeelveld();
            }
        }
        );
    }

    //moeilijkheidsgraad meegeven
    public void openSpeelveld() {

        JFrame f = new JFrame();
        f.add(speelveld);
        JPanel BottomPanel = new JPanel();// Paneel voor 3 knoppen aanmaken
        BottomPanel.setLayout(new GridLayout(1, 3));

        BottomPanel.add(speelveldButton[0]);
        BottomPanel.add(speelveldButton[1]);
        BottomPanel.add(speelveldButton[2]);
        f.add(BottomPanel, BorderLayout.SOUTH);

        //knop start
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

        //knop restarten met zelfde map
        speelveldButton[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.out.println(speelveldButton[0].getText());
                f.dispose(); //destroys and cleans up the JFrame it is attached to.
                speelveld = new Speelveld(); //create new speelveld a.k.a restart the game by creating a new speelveld
                openSpeelveld(); //maakt nieuwe frame "restarts"
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

        /////////////////////////////////
        int[][] makkelijkMap1;
        int[][] makkelijkMapNummer1;

        int[][] makkelijkMap2;
        int[][] makkelijkMapNummer2;

        int[][] makkelijkMap3;
        int[][] makkelijkMapNummer3;

        /////////////////////////////////
        int[][] normaleMap1;
        int[][] normaleMapNummer1;

        int[][] normaleMap2;
        int[][] normaleMapNummer2;

        int[][] normaleMap3;
        int[][] normaleMapNummer3;

        /////////////////////////////////
        int[][] moeilijkeMap1;
        int[][] moeilijkeMapNummer1;

        int[][] moeilijkeMap2;
        int[][] moeilijkeMapNummer2;

        int[][] moeilijkeMap3;
        int[][] moeilijkeMapNummer3;

        //random array[][] aanmaken
        int[][] randomMap = new int[10][10];
        int[][] randomMapNummer = new int[10][10];

        Random random = new Random();
        int generatedRandomNumber = random.nextInt(3) + 1;
        onthoudRestartMap = generatedRandomNumber;

        /*
        eigenschappen:
        nummer 0 is lege vak;
        nummer 1 is een muur
        nummer 2 is een barricade
        nummer 3 is sleutelvak
        nummer 4 is eindbestemming
         */
        //eerste makkelijke map
        if (gekozenMoeilijkheidsgraad == 1) {
            makkelijkMap1 = new int[][]{
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
            makkelijkMapNummer1 = new int[][]{
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
            makkelijkMap2 = new int[][]{
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

            makkelijkMapNummer2 = new int[][]{
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
            makkelijkMap3 = new int[][]{
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

            makkelijkMapNummer3 = new int[][]{
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
            if (onthoudRestartMap < 4)// nummer 4 bestaat niet. 
            {
                if (onthoudRestartMap == 1) {
                    randomMap = makkelijkMap1;
                    randomMapNummer = makkelijkMap1;

                } else if (onthoudRestartMap == 2) {
                    randomMap = makkelijkMap2;
                    randomMapNummer = makkelijkMap2;

                } else {
                    randomMap = makkelijkMap3;
                    randomMapNummer = makkelijkMap3;
                }
            } else {
                if (generatedRandomNumber == 1) {
                    randomMap = makkelijkMap1;
                    randomMapNummer = makkelijkMap1;

                } else if (generatedRandomNumber == 2) {
                    randomMap = makkelijkMap2;
                    randomMapNummer = makkelijkMap2;

                } else {
                    randomMap = makkelijkMap3;
                    randomMapNummer = makkelijkMap3;
                }
            }
        } else if (gekozenMoeilijkheidsgraad == 2) {
            normaleMap1 = new int[][]{
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

            normaleMapNummer1 = new int[][]{
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

            normaleMap2 = new int[][]{
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

            normaleMapNummer2 = new int[][]{
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

            normaleMap3 = new int[][]{
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

            normaleMapNummer3 = new int[][]{
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

            if (generatedRandomNumber == 1) {
                randomMap = normaleMap1;
                randomMapNummer = normaleMapNummer1;

            } else if (generatedRandomNumber == 2) {
                randomMap = normaleMap2;
                randomMapNummer = normaleMapNummer2;

            } else {
                randomMap = normaleMap3;
                randomMapNummer = normaleMapNummer3;
            }
        } else if (gekozenMoeilijkheidsgraad == 3) {

            moeilijkeMap1 = new int[][]{
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

            moeilijkeMapNummer1 = new int[][]{
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

            moeilijkeMap2 = new int[][]{
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

            moeilijkeMapNummer2 = new int[][]{
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

            moeilijkeMap3 = new int[][]{
                {0, 2, 1, 1, 1, 1, 1, 1, 1, 1},
                {3, 3, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 4},};

            moeilijkeMapNummer3 = new int[][]{
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

            if (generatedRandomNumber == 1) {
                randomMap = moeilijkeMap1;
                randomMapNummer = moeilijkeMapNummer1;

            } else if (generatedRandomNumber == 2) {
                randomMap = moeilijkeMap2;
                randomMapNummer = moeilijkeMap2;

            } else {
                randomMap = moeilijkeMap3;
                randomMapNummer = moeilijkeMapNummer3;
            }
        }
        //onderstaande code vergelijkt waarde uit gemaakte speelveld en bepaald het type eigenschap..
        for (int i = 0; i < randomMap.length; i++) {
            for (int j = 0; j < randomMap[i].length; j++) {

                if (randomMap[i][j] == 1) {
                    eigenschappen.add(new Muur(i, j));
                }

                if (randomMap[i][j] == 2) {
                    //  System.out.println(map[i][j]);
                    eigenschappen.add(new Barricade(i, j, randomMapNummer[i][j]));
                }

                if (randomMap[i][j] == 3) {
                    eigenschappen.add(new Sleutel(i, j, randomMapNummer[i][j]));
                }

                if (randomMap[i][j] == 4) {
                    eigenschappen.add(new Eindbestemming(i, j));
                }
            }
        }
        speelveld.createVakken();
        speelveld.addEigenschap(eigenschappen); //geeft eigenschap door als parameter aan eigenschappen zodat vak weet welke type eigenschap het is
        speelveld.setVisible(true);//open het applicatie/scherm.  
    }

}
