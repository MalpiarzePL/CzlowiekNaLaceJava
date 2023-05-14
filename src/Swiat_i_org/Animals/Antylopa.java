package Swiat_i_org.Animals;

import Additional.Punkt;
import Swiat_i_org.Zwierze;

import java.awt.*;
import java.util.Random;

public class Antylopa extends Zwierze{
    public static final int SILA = 4;
    public static final int INICJATYWA = 4;

    public Antylopa(Punkt pkt){
        super(pkt,SILA,INICJATYWA);
    }
    public Antylopa(int sila,int wiek, Punkt pkt){
        super(pkt,sila,INICJATYWA,wiek);
    }
    @Override
    public Antylopa kopia(){
        return new Antylopa(pozycja);
    }

    @Override
    public String toString(){
        return "ANTYLOPA";
    }
    @Override
    public Color rysowanie(){
        return new Color (197, 127, 48);
    }
    @Override
    public void akcja(){
        ruchLos(2);
    }
    @Override
    public boolean czyUcieka(){
        Random rand = new Random();
        int randomNum = rand.nextInt(2);
        if(randomNum == 0){
            return false;
        }
        return true;
    }
}
