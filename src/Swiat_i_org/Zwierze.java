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
            this.getSwiat().getKom().dodajKom(new String(org+" zabija "+this+" na pozycji "+this.getPozycja().toString()));
            this.zabij();
            this.reakcjaNaOrg(org);
        }
        else{
            if(org.czyOdbilAtak(this)){
                cofnijSie();
                return;
            }
            if(org instanceof Roslina) {
                this.getSwiat().getKom().dodajKom(new String(this + " zjada " + org + " na pozycji " + org.getPozycja().toString()));
            }
            else{
                this.getSwiat().getKom().dodajKom(new String(this + " zabija " + org + " na pozycji " + org.getPozycja().toString()));
            }
            org.zabij();
            org.reakcjaNaOrg(this);

        }
    }

    public void rozmnazanie(Zwierze zwierz){
        if(zwierz.getWiek() == 0 || zwierz.stanRozmnozenia() || this.stanRozmnozenia()){
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
            this.getSwiat().getKom().dodajKom(new String("Zwierzeta z gaturnku "+this+" rozmnozyly sie i powstal nowy organizm na polu "+org.getPozycja().toString()));
            this.setRozmnozenie(true);
            zwierz.setRozmnozenie(true);
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
        int bound;
        if(this.getSwiat() instanceof SwZwykly){
            bound = 4;
        }
        else{
            bound = 6;
        }
        int randomNum = rand.nextInt(bound);
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
        if(randomNum == 4){
            wektorRuchu = new Punkt(-zasieg,zasieg);
        }
        if(randomNum == 5){
            wektorRuchu = new Punkt(zasieg,-zasieg);
        }
        rusz(wektorRuchu);
    }

}
