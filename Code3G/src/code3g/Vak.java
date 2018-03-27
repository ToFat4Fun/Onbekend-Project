/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code3g;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author mucis
 */
public class Vak implements Melding {

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
    
    public int getVakNummer()
    {
        return eigenschap instanceof Sleutel ? ((Sleutel) eigenschap).getSleutelNummer() : ((Barricade) eigenschap).getBarricadeNummer(); 
    }
    //tekent de afbeelding die aan vak is toegewezen via eigenschap
    public Image tekenVakAfbeelding() {
        return eigenschap.getAfbeelding();

    }

    public void meldingTonen() {
        JFrame melding = new JFrame();
        JOptionPane optionpane = new JOptionPane("Je hebt gewonnen!");
    }
}
