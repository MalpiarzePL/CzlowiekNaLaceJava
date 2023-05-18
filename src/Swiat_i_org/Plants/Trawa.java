package Swiat_i_org.Plants;
import Additional.*;
import Swiat_i_org.Roslina;

import java.awt.*;

public class Trawa extends Roslina {
    public Trawa(Punkt pkt){
        super(pkt,Constants.SILA_ROSLINY_STANDARD);
    }
    public Trawa(int wiek, Punkt pkt){super(pkt,Constants.SILA_ROSLINY_STANDARD,wiek);}
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
        return Constants.KOLOR_TRAWY;
    }
}
