package Swiat_i_org;

import Additional.*;
import java.util.Random;

public abstract class Zwierze extends Organizm {
    public Punkt poprzedniaPozycja;
    public Zwierze(Punkt pkt, int sila, int inicjatywa){
        super(pkt,sila,inicjatywa);
    }
    public Zwierze(Punkt pkt, int sila, int inicjatywa,int wiek){
        super(pkt,sila,inicjatywa,wiek);
    }
    @Override
    public void akcja(){
        ruchLos(1);
    }
    public void cofnijSie(){
        this.setPozycja(poprzedniaPozycja);
    }
    public void setPoprzedniaPozycja(int x, int y){
        poprzedniaPozycja = new Punkt(x,y);
    }

    @Override
    public void kolizja(){
        Organizm kolidujacy = this.getSwiat().kolidOrg(this);
        if(kolidujacy == null) {
            return;
        }
        if(kolidujacy.toString().equals(this.toString())){
            rozmnazanie((Zwierze)kolidujacy);
        }
        else{
            walka(kolidujacy);
        }
    }
    public void walka(Organizm org){
        if(this.ucieczka() || org.ucieczka()){
            return;
        }
        if(this.getSila() < org.getSila()){
            if(this.czyOdbilAtak(org)){
                cofnijSie();
                return;
            }
            this.zabij();
            this.reakcjaNaOrg(org);
            this.getSwiat().getKom().dodajKom(new String(org.toString()+" zabija "+this.toString()+" na pozycji "+this.getPozycja().toString()));
        }
        else{
            if(org.czyOdbilAtak(this)){
                cofnijSie();
                return;
            }
            org.zabij();
            org.reakcjaNaOrg(this);
            this.getSwiat().getKom().dodajKom(new String(this.toString()+" zabija "+org.toString()+" na pozycji "+org.getPozycja().toString()));
        }
    }

    public void rozmnazanie(Zwierze zwierz){
        if(zwierz.getWiek() == 0 || zwierz.czyRozmnozony || this.czyRozmnozony){
            cofnijSie();
            return;
        }
        Organizm org = kopia();
        cofnijSie();
        Punkt pkt = getSwiat().wolnePoleObok(zwierz.getPozycja());
        if(pkt == null){
            pkt = getSwiat().wolnePoleObok(pozycja);
        }
        if(pkt != null) {
            org.setPozycja(pkt);
            org.setWiek(-1);
            this.getSwiat().addOrg(org);
            this.czyRozmnozony = true;
            zwierz.czyRozmnozony = true;
        }
    }
    public void rusz(Punkt pkt){
        if(!(this.getPozycja().changeNew(pkt)).pozaPolem(this.getSwiat().getWysokosc(),this.getSwiat().getSzerokosc())){
            poprzedniaPozycja = new Punkt(pozycja.getY(), pozycja.getX());
            pozycja.change(pkt);
        }
    }

    public void ruchLos(int zasieg){
        Random rand = new Random();
        int randomNum = rand.nextInt(4);
        Punkt wektorRuchu = new Punkt(0,0);
        if(randomNum == 0){
            wektorRuchu = new Punkt(zasieg,0);
        }
        if(randomNum == 1){
            wektorRuchu = new Punkt(-zasieg,0);
        }
        if(randomNum == 2){
            wektorRuchu = new Punkt(0,zasieg);
        }
        if(randomNum == 3){
            wektorRuchu = new Punkt(0,-zasieg);
        }
        rusz(wektorRuchu);
    }

}
