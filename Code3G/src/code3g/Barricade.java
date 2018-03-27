/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code3g;

/**
 *
 * @author jurian
 */
public class Barricade extends Eigenschap implements Melding {
    
    private int bariccadeNummer;
    
    //constructor
    public Barricade( int xC, int yC, int barricadeNummer) {
        super(true,"hek.png", xC, yC);
    }

    //get/set for barricadeNummer which is the value of the barricade (the value determines which key is needed to open)
    public int getBariccadeNummer() {
        return bariccadeNummer;
    }

    public void setBariccadeNummer(int bariccadeNummer) {
        this.bariccadeNummer = bariccadeNummer;
    }
    
    
    //methode die vakSoort moet vervangen..
    public  boolean vakEigenschap(){
    
    return true;
    }

    @Override
    public void meldingTonen() {
        //code for melding tonen toevoegen
    }
}



