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
public class Vak{

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

    public void emptyEigenschap() {
        eigenschap = null;
    }

    public boolean tellVakEigenschap(Speler speler) {
        if (eigenschap instanceof Barricade) {
            return ((Barricade) eigenschap).vakEigenschap(speler); // vakeigenschap van barricade aanroepen 
        }
        if (eigenschap instanceof Sleutel) {
            return ((Sleutel) eigenschap).vakEigenschap(speler); // zelfde als van barricade.
        } else if (eigenschap instanceof Eindbestemming) {
            return ((Eindbestemming) eigenschap).vakEigenschap(); // zelfde als van hierboven
        }
        return true;
    }

    public int getVakNummer() {
        //hiermee kan ik kijken of de klasse eigenschap een specifieke subklas is. 
        return eigenschap instanceof Sleutel ? ((Sleutel) eigenschap).getSleutelNummer()
                : ((Barricade) eigenschap).getBarricadeNummer(); // ((Barricade) eigenschap) hiermee kan ik de operaties van Barricade ook gebruiken..
    }

    //tekent de afbeelding die aan vak is toegewezen via eigenschap
    public Image tekenVakAfbeelding() {
        return eigenschap.getAfbeelding(); // haalt afbeelding voor speelveld op. het is soort een via via associatie.

    }
}
