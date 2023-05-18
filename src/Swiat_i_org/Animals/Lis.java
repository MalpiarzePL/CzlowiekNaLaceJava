package Swiat_i_org.Animals;

import Additional.Constants;
import Additional.Punkt;
import Swiat_i_org.Zwierze;
import java.awt.*;
import java.util.Random;
import java.util.Vector;

public class Lis extends Zwierze {

    public Lis(Punkt pkt){
        super(pkt,Constants.SILA_LISA,Constants.INICJATYWA_LISA);
    }
    public Lis(int sila,int wiek, Punkt pkt){
        super(pkt,sila,Constants.INICJATYWA_LISA,wiek);
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
        return Constants.KOLOR_LISA;
    }
    @Override
    public void akcja(){
        Vector<Punkt> pkt = new Vector<>();
        if(this.getSwiat().wolnePoleObok(this.pozycja) != null){
            pkt.add(this.getSwiat().wolnePoleObok(this.pozycja));
        }
        if(slabsiObokk(this.pozycja) != null){
            pkt.add(slabsiObokk(this.pozycja));
        }
        if(pkt.isEmpty()) {
            return;
        }
        Random rand = new Random();
        int randomNum = rand.nextInt(pkt.size());
        this.setPoprzedniaPozycja(this.pozycja.getX(),this.pozycja.getY());
        this.setPozycja(pkt.get(randomNum));
    }


    public Punkt slabsiObokk(Punkt pkt){
        Vector<Punkt> punkty = new Vector<>();
        Punkt pkt1 = pkt.changeNew(new Punkt(1,0));
        Punkt pkt2 = pkt.changeNew(new Punkt(-1,0));
        Punkt pkt3 = pkt.changeNew(new Punkt(0,1));
        Punkt pkt4 = pkt.changeNew(new Punkt(0,-1));
        if(this.getSwiat().GetOrgNaPoz(pkt1) != null && this.getSwiat().GetOrgNaPoz(pkt).getSila() >= this.getSwiat().GetOrgNaPoz(pkt1).getSila()){
            punkty.add(pkt1);
        }
        if(this.getSwiat().GetOrgNaPoz(pkt2) != null && this.getSwiat().GetOrgNaPoz(pkt).getSila() >= this.getSwiat().GetOrgNaPoz(pkt2).getSila()){
            punkty.add(pkt2);
        }
        if(this.getSwiat().GetOrgNaPoz(pkt3) != null && this.getSwiat().GetOrgNaPoz(pkt).getSila() >= this.getSwiat().GetOrgNaPoz(pkt3).getSila()){
            punkty.add(pkt3);
        }
        if(this.getSwiat().GetOrgNaPoz(pkt4) != null && this.getSwiat().GetOrgNaPoz(pkt).getSila() >= this.getSwiat().GetOrgNaPoz(pkt4).getSila()){
            punkty.add(pkt4);
        }
        if(punkty.isEmpty()){
            return null;
        }
        Random rand = new Random();
        int randomNum = rand.nextInt(punkty.size());
        return punkty.get(randomNum);
    }

}
