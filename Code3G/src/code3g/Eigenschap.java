/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code3g;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author jurian
 */
public class Eigenschap {
    
    private boolean beloopbaar;// binnenkort niet meer nodig vanwege "instanceof" 
    //uitleg; bestandsnaam voor elke subklasse, bestandsnaam is naam van bijbehorende afbeelding in assets.
    //afbeelding instellen als ImageIcon van die bijbehorende asset..
    private String bestandsNaam;
    private Image afbeelding;
    private int xC;
    private int yC;
    
   
    //constructor
    public Eigenschap(boolean beloopbaar, String bestandsNaam, int xC, int yC){
        this.beloopbaar = beloopbaar;
        this.bestandsNaam = bestandsNaam;
        afbeelding = new ImageIcon("src\\Assets\\" + bestandsNaam).getImage();

        this.xC = xC;
        this.yC = yC;
    }

    //methode die vakSoort moet vervangen..
    public boolean vakEigenschap()
    {
        return false;
    }
            
            
    //get/set for beloopbaar
    public boolean getBeloopbaar() {
        return beloopbaar;
    }

    public void setBeloopbaar(boolean isBeloopBaar) {
        this.beloopbaar = beloopbaar;
    }
    
    public Image getAfbeelding(){
        return afbeelding;
    }
    
    //get/set for Afbeelding
    public String getBestandsNaam() {
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
