package Swiat_i_org;

import java.util.Random;
import java.util.Vector;
import Additional.*;
import Swiat_i_org.Animals.*;


public class Swiat {
    private final int wysokosc;
    private final int szerokosc;
    Vector<Organizm> organizmy;
    private Komentator kom;
    private Typ typ = Typ.Zwykly;
    public int ruchCzlowieka = 0; //0-stoj 1-gora 2-dol 3-lewo 4-prawo 5-aktywacja mocy

    public enum Typ{
        Zwykly,
        Hex
    }

    public Swiat(int wys, int szer,Typ typ){
        this.wysokosc = wys;
        this.szerokosc = szer;
        organizmy = new Vector<>();
        kom = new Komentator();
        this.typ = typ;
    }

    public boolean wlaczMoc(){
        for(Organizm org : organizmy){
            if(org instanceof Czlowiek){
                if(((Czlowiek) org).ultTury == 0){
                    ((Czlowiek) org).ultTury = 10;
                    return true;
                }
            }
        }
        return false;
    }

    public void setRuchCzlowieka(int rodzaj){
        this.ruchCzlowieka = rodzaj;
    }

    public int getRuchCzlowieka(){
        return ruchCzlowieka;
    }

    public int popRuchCzlowieka(){
        int help = this.ruchCzlowieka;
        ruchCzlowieka = 0;
        return help;
    }


    public void nowaTura(){
        for(Organizm org : organizmy){
            org.czyRozmnozony = false;
        }
    }
    public int getWysokosc(){
        return wysokosc;
    }
    public int getSzerokosc(){
        return szerokosc;
    }
    public void wykonajTure(){
        nowaTura();
        ruchOrg();
        czyscTrupy();
    }
    private void czyscTrupy(){
        for(int i = 0; i < organizmy.size(); i++){
            if(!organizmy.get(i).czyZyje()){
                organizmy.remove(i);
                czyscTrupy();
                break;
            }
        }
    }
    public Typ getTyp(){
        return typ;
    }

    public Organizm kolidOrg(Organizm org){
        for(Organizm org1 : organizmy){
            if(org.getPozycja().equal(org1.getPozycja()) && org != org1 && org.czyZyje()){
                return org1;
            }
        }
        return null;
    }
    public void addOrg(Organizm org){
        org.setSwiat(this);
        organizmy.add(org);
    }



    public Komentator getKom(){
        return kom;
    }

    public static Swiat Baza(Typ typ){
        Swiat world = new Swiat(10,10,typ);
        //world.addOrg(new Czlowiek(new Punkt(5,5)));

        return world;
    }
    public Punkt slabsiObok(Punkt pkt){
        Vector<Punkt> punkty = new Vector<>();
        Punkt pkt1 = pkt.changeNew(new Punkt(1,0));
        Punkt pkt2 = pkt.changeNew(new Punkt(-1,0));
        Punkt pkt3 = pkt.changeNew(new Punkt(0,1));
        Punkt pkt4 = pkt.changeNew(new Punkt(0,-1));
        if(GetOrgNaPoz(pkt1) != null && GetOrgNaPoz(pkt).getSila() >= GetOrgNaPoz(pkt1).getSila()){
            punkty.add(pkt1);
        }
        if(GetOrgNaPoz(pkt2) != null && GetOrgNaPoz(pkt).getSila() >= GetOrgNaPoz(pkt2).getSila()){
            punkty.add(pkt2);
        }
        if(GetOrgNaPoz(pkt3) != null && GetOrgNaPoz(pkt).getSila() >= GetOrgNaPoz(pkt3).getSila()){
            punkty.add(pkt3);
        }
        if(GetOrgNaPoz(pkt4) != null && GetOrgNaPoz(pkt).getSila() >= GetOrgNaPoz(pkt4).getSila()){
            punkty.add(pkt4);
        }
        if(punkty.isEmpty()){
            return null;
        }
        Random rand = new Random();
        int randomNum = rand.nextInt(punkty.size());
        return punkty.get(randomNum);
    }
    public Vector<Punkt> wektorZajetychWokol(Punkt pkt){
        Vector<Punkt> punkty = new Vector<>();
        Punkt pkt1 = pkt.changeNew(new Punkt(1,0));
        Punkt pkt2 = pkt.changeNew(new Punkt(-1,0));
        Punkt pkt3 = pkt.changeNew(new Punkt(0,1));
        Punkt pkt4 = pkt.changeNew(new Punkt(0,-1));
        if(GetOrgNaPoz(pkt1) != null){
            punkty.add(pkt1);
        }
        if(GetOrgNaPoz(pkt2) != null){
            punkty.add(pkt2);
        }
        if(GetOrgNaPoz(pkt3) != null){
            punkty.add(pkt3);
        }
        if(GetOrgNaPoz(pkt4) != null ){
            punkty.add(pkt4);
        }
        return punkty;
    }
    public Punkt wolnePoleObok(Punkt pkt){
        Vector<Punkt> punkty = new Vector<>();
        Punkt pkt1 = pkt.changeNew(new Punkt(1,0));
        Punkt pkt2 = pkt.changeNew(new Punkt(-1,0));
        Punkt pkt3 = pkt.changeNew(new Punkt(0,1));
        Punkt pkt4 = pkt.changeNew(new Punkt(0,-1));
        if(GetOrgNaPoz(pkt1) == null && !pkt1.pozaPolem(this.getWysokosc(),this.getSzerokosc())){
            punkty.add(pkt1);
        }
        if(GetOrgNaPoz(pkt2) == null && !pkt2.pozaPolem(this.getWysokosc(),this.getSzerokosc())){
            punkty.add(pkt2);
        }
        if(GetOrgNaPoz(pkt3) == null && !pkt3.pozaPolem(this.getWysokosc(),this.getSzerokosc())){
            punkty.add(pkt3);
        }
        if(GetOrgNaPoz(pkt4) == null && !pkt4.pozaPolem(this.getWysokosc(),this.getSzerokosc())){
            punkty.add(pkt4);
        }
        if(punkty.isEmpty()){
            return null;
        }
        Random rand = new Random();
        int randomNum = rand.nextInt(punkty.size());
        return punkty.get(randomNum);
    }

    public Organizm GetOrgNaPoz(Punkt pkt){
        Organizm org = null;
        for(Organizm org1 : organizmy){
            if(org1.getPozycja().equal(pkt) && org1.czyZyje()){
                org = org1;
                break;
            }
        }
        return org;
    }
    public Vector<Organizm> getOrganizmy(){
        return organizmy;
    }

    private void ruchOrg(){
        organizmy.sort((Organizm org1, Organizm org2) ->{
            if(org1.getInicjatywa() == org2.getInicjatywa()){
                return org2.getWiek() - org1.getWiek();
            }
            return org2.getInicjatywa() - org1.getInicjatywa();
        });
        for(int i = 0; i < organizmy.size(); i++){
            Organizm org = organizmy.get(i);
            if(org.czyZyje() && org.getWiek() >= 0){
                org.akcja();
                org.kolizja();
            }
            org.starzenie();
        }
    }
}
