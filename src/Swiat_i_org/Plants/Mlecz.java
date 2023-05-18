package Swiat_i_org.Plants;

import Additional.Constants;
import Additional.Punkt;
import Swiat_i_org.Roslina;

import java.awt.*;

public class Mlecz extends Roslina {
    public Mlecz(Punkt pkt){
        super(pkt,Constants.SILA_ROSLINY_STANDARD);
    }
    public Mlecz(int wiek, Punkt pkt){super(pkt,Constants.SILA_ROSLINY_STANDARD,wiek);}
    @Override
    public Mlecz kopia(){
        return new Mlecz(pozycja);
    }

    @Override
    public String toString(){
        return "MLECZ";
    }

    @Override
    public Color rysowanie(){
        return Constants.KOLOR_MLECZA;
    }
    @Override
    public void akcja(){
        for(int i = 0; i < 3; i++){
            sianie();
        }
    }
}
