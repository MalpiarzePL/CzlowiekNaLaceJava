package Swiat_i_org.Plants;
import Additional.*;
import Swiat_i_org.Animals.Wilk;
import Swiat_i_org.Roslina;

import java.awt.*;

public class Trawa extends Roslina {
    public static final int SILA = 0;
    public Trawa(Punkt pkt){
        super(pkt,SILA);
    }
    @Override
    public Trawa kopia(){
        return new Trawa(pozycja);
    }

    @Override
    public String toString(){
        return "TRAWA";
    }

    @Override
    public Color rysowanie(){
        return new Color (0,240,0);
    }
}
