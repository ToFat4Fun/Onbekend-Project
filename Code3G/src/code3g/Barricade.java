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

    private int barricadeNummer;

    //constructor
    public Barricade(int xC, int yC, int barricadeNummer) {
        super(true, "hek.png", xC, yC);
        this.barricadeNummer = barricadeNummer;
    }

    //get/set for barricadeNummer which is the value of the barricade (the value determines which key is needed to open)
    public int getBarricadeNummer() {
        return barricadeNummer;
    }

    public void setBarricadeNummer(int barricadeNummer) {
        this.barricadeNummer = barricadeNummer;
    }

    //methode die vakSoort moet vervangen..
    public boolean vakEigenschap(Speler speler) {

        // als een sleutel in een barricade past.
        if (speler.getZak() == barricadeNummer) {
            System.out.println("Sleutel past!");
            return true;
        } else {// anders een melding tonen.
            meldingTonen();
            return false;
        }
    }
    
    @Override
    public void meldingTonen() {
        //code for melding tonen toevoegen
    System.out.println("Sleutel past niet!");
    }
}
