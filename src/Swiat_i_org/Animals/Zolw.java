package Swiat_i_org.Animals;

import Additional.Constants;
import Additional.Punkt;
import Swiat_i_org.Zwierze;
import Swiat_i_org.Organizm;

import java.awt.*;
import java.util.Random;

public class Zolw extends Zwierze{
    public static final int BLOK = 4;

    public Zolw(Punkt pkt){
        super(pkt,Constants.SILA_ZOLWIA,Constants.INICJATYWA_ZOLWIA);
    }
    public Zolw(int sila,int wiek, Punkt pkt){
        super(pkt,sila,Constants.INICJATYWA_ZOLWIA,wiek);
    }
    @Override
    public Zolw kopia(){
        return new Zolw(pozycja);
    }

    @Override
    public String toString(){
        return "ZOLW";
    }
    @Override
    public Color rysowanie(){
        return Constants.KOLOR_ZOLWIA;
    }
    @Override
    public void akcja(){
        Random rand = new Random();
        int randomNum = rand.nextInt(4);
        if(randomNum == 0) {
            ruchLos(1);
        }
    }
    @Override
    public boolean czyOdbilAtak(Organizm atakujacy){
        if(atakujacy.getSila() > BLOK){
            return false;
        }
        return true;
    }
}
