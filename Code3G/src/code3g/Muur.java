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
public class Muur extends Eigenschap {
    
    public Muur(boolean beloopbaar, String bestandsNaam, String vakSoort, int xC, int yC) {
        super(beloopbaar, bestandsNaam, xC, yC);
    }
    
    
    //methode die vakSoort moet vervangen..
    @Override
    public  void vakEigenschap(){}
    
    //review this later..
    
}
