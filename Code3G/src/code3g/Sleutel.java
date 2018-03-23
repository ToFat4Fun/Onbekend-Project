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
public class Sleutel extends Eigenschap {
    
    private int sleutelNummer;
    
    //constructor
    public Sleutel(boolean beloopbaar, String afbeelding, String vakSoort, int xC, int yC, int sleutelNummer) {
        super(beloopbaar, afbeelding, vakSoort, xC, yC);
    }

    
    //get/set for sleutelNummer
    public int getSleutelNummer() {
        return sleutelNummer;
    }

    public void setSleutelNummer(int sleutelNummer) {
        this.sleutelNummer = sleutelNummer;
    }
    
    
    //when Speler picks up key, key is added to Speler Zak and key destroys itself
    public void vernietigtZichzelf(Speler speler)
    {
        
    }
    
}
