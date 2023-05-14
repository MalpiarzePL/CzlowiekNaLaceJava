package Swiat_i_org.Animals;

import Additional.Punkt;
import Swiat_i_org.Zwierze;

import java.awt.*;
import java.util.Random;
import java.util.Vector;

public class Lis extends Zwierze {
    public static final int SILA = 3;
    public static final int INICJATYWA = 7;
    public Lis(Punkt pkt){
        super(pkt,SILA,INICJATYWA);
    }
    public Lis(int sila,int wiek, Punkt pkt){
        super(pkt,sila,INICJATYWA,wiek);
    }
    @Override
    public Lis kopia(){
        return new Lis(pozycja);
    }

    @Override
    public String toString(){
        return "LIS";
    }
    @Override
    public Color rysowanie(){
        return new Color (255, 140, 0);
    }
    @Override
    public void akcja(){
        Vector<Punkt> pkt = new Vector<>();
        if(this.getSwiat().wolnePoleObok(this.pozycja) != null){
            pkt.add(this.getSwiat().wolnePoleObok(this.pozycja));
        }
        if(this.getSwiat().slabsiObok(this.pozycja) != null){
            pkt.add(this.getSwiat().slabsiObok(this.pozycja));
        }
        if(pkt.isEmpty()) {
            return;
        }
        Random rand = new Random();
        int randomNum = rand.nextInt(pkt.size());
        this.setPoprzedniaPozycja(this.pozycja.getX(),this.pozycja.getY());
        this.setPozycja(pkt.get(randomNum));
    }

}
