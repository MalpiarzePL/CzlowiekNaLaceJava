package Swiat_i_org.Animals;

import Additional.Constants;
import Additional.Punkt;
import Swiat_i_org.Zwierze;

import java.awt.*;

public class Owca extends Zwierze {
    public Owca(Punkt pkt){
        super(pkt,Constants.SILA_OWCY,Constants.INICJATYWA_OWCY);
    }
    public Owca(int sila,int wiek, Punkt pkt){
        super(pkt,sila,Constants.INICJATYWA_OWCY,wiek);
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
        return Constants.KOLOR_OWCY;
    }
}
