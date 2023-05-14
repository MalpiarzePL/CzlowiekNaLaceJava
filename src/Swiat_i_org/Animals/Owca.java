package Swiat_i_org.Animals;

import Additional.Punkt;
import Swiat_i_org.Zwierze;

import java.awt.*;

public class Owca extends Zwierze {
    public static final int SILA = 4;
    public static final int INICJATYWA = 4;
    public Owca(Punkt pkt){
        super(pkt,SILA,INICJATYWA);
    }
    public Owca(int sila,int wiek, Punkt pkt){
        super(pkt,sila,INICJATYWA,wiek);
    }
    @Override
    public Owca kopia(){
        return new Owca(pozycja);
    }

    @Override
    public String toString(){
        return "OWCA";
    }
    @Override
    public Color rysowanie(){
        return new Color (255, 255, 255);
    }
}
