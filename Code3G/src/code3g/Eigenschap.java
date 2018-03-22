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
    private String afbeelding;
    private final vakSoort vakSoort;
    private int xC;
    private int yC;
    
    public enum vakSoort { leeg, sleutel, muur, eindBestemming, barricade }
    
   
    //constructor
    public Eigenschap(boolean beloopbaar, String afbeelding, vakSoort vakSoort, int xC, int yC){
        this.beloopbaar = beloopbaar;
        this.afbeelding = afbeelding;
        this.vakSoort = vakSoort;
        this.xC = xC;
        this.yC = yC;
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
        return afbeelding;
    }

    public void setAfbeelding(String afbeelding) {
        this.afbeelding = afbeelding;
    }

    

    //get for vakSoort
    public vakSoort getVakSoort() {
        return vakSoort;
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
