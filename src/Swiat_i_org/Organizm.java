package Swiat_i_org;

import Additional.*;
import java.awt.*;

public abstract class Organizm {
    private int sila;
    private int inicjatywa;
    private int wiek;
    private boolean zyje;
    private Swiat swiat;
    protected Punkt pozycja;
    public boolean czyRozmnozony;

    Organizm(Punkt pkt, int sila, int inicjatywa){
        this.pozycja = pkt;
        this.sila = sila;
        this.inicjatywa = inicjatywa;
        this.zyje = true;
        this.wiek = 0;
    }
    Organizm(Punkt pkt, int sila, int inicjatywa, int wiek){
        this.pozycja = pkt;
        this.sila = sila;
        this.inicjatywa = inicjatywa;
        this.zyje = true;
        this.wiek = wiek;
    }

    public abstract void akcja();
    public abstract Color rysowanie();
    public abstract Organizm kopia();
    public void kolizja(){}
    public void setPozycja(Punkt pkt){
        this.pozycja = pkt;
    }

    public int getSila(){
        return sila;
    }
    public int getInicjatywa(){
        return inicjatywa;
    }
    public Punkt getPozycja(){
        return pozycja;
    }
    public boolean czyZyje(){
        return zyje;
    }
    public int getWiek(){
        return wiek;
    }
    public void setWiek(int wiek){
        this.wiek = wiek;
    }
    public void setSila(int sil){
        this.sila = sil;
    }
    public void zabij(){
        //dodaj komentatora
        this.zyje = false;
    }
    public Swiat getSwiat(){return swiat;}
    public boolean czyUcieka(){
        return false;
    }
    public void cofnijSie(){};
    public boolean ucieczka(){
        boolean wynik = czyUcieka();
        if(wynik){
            Punkt pkt = this.getSwiat().wolnePoleObok(this.pozycja);
            if(pkt == null)
                return false;
            else{
                this.setPozycja(pkt);
                return true;
            }
        }
        return false;
    }
    public void starzenie(){
        wiek++;
    }
    public void setSwiat(Swiat world){
        this.swiat = world;
    }
    protected boolean dobryWech(){
        return false;
    }
    public void reakcjaNaOrg(Organizm org){}
    public boolean czyOdbilAtak(Organizm atakujacy){
        return false;
    }
}
