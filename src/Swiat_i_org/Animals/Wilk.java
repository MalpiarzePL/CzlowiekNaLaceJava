package Swiat_i_org.Animals;

import Swiat_i_org.Zwierze;

import java.awt.*;
import Additional.Punkt;



public class Wilk extends Zwierze{
    public static final int SILA = 900;
    public static final int INICJATYWA = 5;

    public Wilk(Punkt pkt){
        super(pkt,SILA,INICJATYWA);
    }
    public Wilk(int sila,int wiek, Punkt pkt){
        super(pkt,sila,INICJATYWA,wiek);
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
        return new Color (128,128,128);
    }
}
