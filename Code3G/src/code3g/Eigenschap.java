/*
   This game is developed by Mucahit Coskun, Jurian van Hoorn and Tarik Sherif, students at The Hague University of Applied Sciences
   If you wish to you use any of this code please refer to the authors or copy this header.
   This is our version of a Maze Game project for Software Engineering 2017-2018 3rd semester.
 */
package code3g;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author jurian
 */
public class Eigenschap {
    
    //uitleg; bestandsnaam voor elke subklasse, bestandsnaam is naam van bijbehorende afbeelding in assets.
    //afbeelding instellen als ImageIcon van die bijbehorende asset..
    private String bestandsNaam;
    private Image afbeelding;
    private int xC;
    private int yC;
    
   
    //constructor
    public Eigenschap(String bestandsNaam, int xC, int yC){

        this.bestandsNaam = bestandsNaam;
        afbeelding = new ImageIcon("src\\Assets\\" + bestandsNaam).getImage();

        this.xC = xC;
        this.yC = yC;
    }

    //methode die vakSoort moet vervangen..
        public  boolean vakEigenschap(Speler speler)
    {
        return false;
    }
     
    //methode die vakSoort moet vervangen..
    public  boolean vakEigenschap()
    {
        return true;
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
