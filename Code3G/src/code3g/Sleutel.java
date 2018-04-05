/*
   This game is developed by Mucahit Coskun, Jurian van Hoorn and Tarik Sherif, students at The Hague University of Applied Sciences
   If you wish to you use any of this code please refer to the authors or copy this header.
   This is our version of a Maze Game project for Software Engineering 2017-2018 3rd semester.
 */
package code3g;

/**
 *
 * @author jurian
 */
public class Sleutel extends Eigenschap {

    private int sleutelNummer;

    //constructor
    public Sleutel(int xC, int yC, int sleutelNummer) {
        super("sleutel.png", xC, yC);
        this.sleutelNummer = sleutelNummer;
    }

    //get/set for sleutelNummer
    public int getSleutelNummer() {
        return sleutelNummer;
    }

    public void setSleutelNummer(int sleutelNummer) {
        this.sleutelNummer = sleutelNummer;
    }

    //geef Zak de waarde van sleutel die Speler opgepakt heeft..
    public boolean vakEigenschap(Speler speler) {
        speler.setZak(sleutelNummer);
        return true;
    }
//geef Zak de waarde van sleutel die Speler opgepakt heeft..

    public boolean vakEigenschap() {
        return false;
    }
}
