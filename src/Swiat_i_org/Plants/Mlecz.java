package Swiat_i_org.Plants;

import Additional.Punkt;
import Swiat_i_org.Roslina;

import java.awt.*;

public class Mlecz extends Roslina {
    public static final int SILA = 0;
    public Mlecz(Punkt pkt){
        super(pkt,SILA);
    }
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
        return new Color (255, 255, 0);
    }
    @Override
    public void akcja(){
        for(int i = 0; i < 3; i++){
            zasiej();
        }
    }
}
