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
    public Barricade(boolean beloopbaar, String bestandsNaam, int xC, int yC, int barricadeNummer) {
        super(beloopbaar, bestandsNaam, xC, yC);
    }

    //get/set for barricadeNummer which is the value of the barricade (the value determines which key is needed to open)
    public int getBariccadeNummer() {
        return bariccadeNummer;
    }

    public void setBariccadeNummer(int bariccadeNummer) {
        this.bariccadeNummer = bariccadeNummer;
    }
    
    //selfdestruct when opened by player
    //TODO: barricade needs to check Speler for matching key (Zak int)
    public void vernietigtZichzelf(Speler speler)
    {
        //code here
    }
    
    
    //methode die vakSoort moet vervangen..
    public  void vakEigenschap(){}
}



