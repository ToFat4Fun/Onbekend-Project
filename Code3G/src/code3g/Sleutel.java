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
    public Sleutel( int xC, int yC, int sleutelNummer) 
    {
        super(true,"sleutel.png", xC, yC);
    }

    //get/set for sleutelNummer
    public int getSleutelNummer() 
    {
        return sleutelNummer;
    }

    public void setSleutelNummer(int sleutelNummer) 
    {
        this.sleutelNummer = sleutelNummer;
    }
    
    //methode die vakSoort moet vervangen..
    public boolean vakEigenschap()
    {
        return true;
    }
}
