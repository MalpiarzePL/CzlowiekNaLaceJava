package Swiat_i_org.Animals;

import Additional.Constants;
import Swiat_i_org.Zwierze;
import java.awt.*;
import Additional.Punkt;



public class Wilk extends Zwierze{


    public Wilk(Punkt pkt){
        super(pkt,Constants.SILA_WILKA,Constants.INICJATYWA_WILKA);
    }
    public Wilk(int sila,int wiek, Punkt pkt){
        super(pkt,sila,Constants.INICJATYWA_WILKA,wiek);
    }
    @Override
    public Wilk kopia(){
        return new Wilk(pozycja);
    }

    @Override
    public String toString(){
        return "WILK";
    }
    @Override
    public Color rysowanie(){
        return Constants.KOLOR_WILKA;
    }
}
