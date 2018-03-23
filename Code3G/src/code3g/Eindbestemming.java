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
public class Eindbestemming extends Eigenschap implements Melding {
    
    public Eindbestemming(boolean beloopbaar, String bestandsNaam, String vakSoort, int xC, int yC) {
        super(beloopbaar, bestandsNaam, xC, yC);
    }
    
    //methode die vakSoort moet vervangen..
    public  void vakEigenschap(){}
    
    
    //insert something that happens when Speler steps on eindbestemming..
    
}
