package Swiat_i_org.Animals;

import Additional.Punkt;
import Swiat_i_org.Zwierze;
import Swiat_i_org.Organizm;

import java.awt.*;
import java.util.Random;

public class Zolw extends Zwierze{
    public static final int SILA = 2;
    public static final int INICJATYWA = 1;
    public static final int BLOK = 4;

    public Zolw(Punkt pkt){
        super(pkt,SILA,INICJATYWA);
    }
    public Zolw(int sila,int wiek, Punkt pkt){
        super(pkt,sila,INICJATYWA,wiek);
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
        return new Color (30, 100, 0);
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
        if(atakujacy.getSila() >= BLOK){
            return false;
        }
        return true;
    }
}
