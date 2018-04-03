/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code3g;

import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * 5
 *
 * @author mucis
 */
public class Vak {

    private String kleur;
    private Eigenschap eigenschap;  //sla eigenschap hier in op

    public Vak(String gekozenKleur) // verwacht een hexCode kleur
    {
        this.kleur = gekozenKleur;
    }

    public void setKleur(String gekozenKleur) {
        this.kleur = kleur;
    }

    public String getKleur() {
        return this.kleur;
    }

    public Eigenschap getEigenschap() {
        return eigenschap;
    }

    public void addEigenschap(Eigenschap e) {
        this.eigenschap = e;
    }

    //maak vak leeg..
    public void emptyEigenschap() {
        eigenschap = null;
    }
    //deze methode controleert of speler op een vak mag lopen
    public boolean requestVakEigenschap(Speler speler) {

        if (eigenschap != null) {
            // alleen bij barricade en sleutel een instanceof gebruiken. omdat deze twee andere operatie heeft
            if (eigenschap.vakEigenschap(speler)) {
                //natuurlijk een object leeggooien
                eigenschap = null;
                return true; // vakeigenschap van barricade aanroepen 
                
            } else {
                return eigenschap.vakEigenschap(); // zelfde als van hierboven
            }
        }
        return true;
    }

    public int getVakNummer() {
        //hiermee kan ik kijken of de klasse eigenschap een specifieke subklas is. 
        // operaties casten.
        return eigenschap instanceof Sleutel
                ? ((Sleutel) eigenschap).getSleutelNummer() // eigenschap subclass sleutel is dan een operatie van een sleutel gebruiken anders barricade
                : ((Barricade) eigenschap).getBarricadeNummer(); // ((Barricade) eigenschap) hiermee kan ik de operaties van Barricade ook gebruiken..
    }

    //tekent de afbeelding die aan vak is toegewezen via eigenschap
    public Image tekenVakAfbeelding() {
        return eigenschap.getAfbeelding(); // haalt afbeelding voor speelveld op. het is soort een via via associatie.

    }
}
