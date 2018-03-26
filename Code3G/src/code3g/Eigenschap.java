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
public class Eigenschap {
    
    private boolean beloopbaar;
    private String bestandsNaam;
    private int xC;
    private int yC;
    
   
    //constructor
    public Eigenschap(boolean beloopbaar, String bestandsNaam, int xC, int yC){
        this.beloopbaar = beloopbaar;
        this.bestandsNaam = bestandsNaam;
        this.xC = xC;
        this.yC = yC;
    }

    //methode die vakSoort moet vervangen..
    public  boolean vakEigenschap()
    {
        return true;
    }
            
            
    //get/set for beloopbaar
    public boolean getBeloopbaar() {
        return beloopbaar;
    }

    public void setBeloopbaar(boolean isBeloopBaar) {
        this.beloopbaar = beloopbaar;
    }
    
    //get/set for Afbeelding
    public String getAfbeelding() {
        return bestandsNaam;
    }

    public void setBestandsNaam(String bestandsNaam) {
        this.bestandsNaam = bestandsNaam;
    }

    
    //get/set for xC
    public int getxC() {
        return xC;
    }

    public void setxC(int inputXC) {
        this.xC = xC;
    }
    
    
    //get/set for yC
    public int getyC() {
        return yC;
    }

    public void setyC(int inputYC) {
        this.yC = yC;
    }
    
    
    
}
