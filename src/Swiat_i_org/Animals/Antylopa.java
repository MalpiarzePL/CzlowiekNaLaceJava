package Swiat_i_org.Animals;

import Additional.Constants;
import Additional.Punkt;
import Swiat_i_org.Zwierze;

import java.awt.*;
import java.util.Random;

public class Antylopa extends Zwierze{

    public Antylopa(Punkt pkt){
        super(pkt,Constants.SILA_ANTYLOPY,Constants.INICJATYWA_ANTYLOPY);
    }
    public Antylopa(int sila,int wiek, Punkt pkt){
        super(pkt,sila,Constants.INICJATYWA_ANTYLOPY,wiek);
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
        return Constants.KOLOR_ANTYLOPY;
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
