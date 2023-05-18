package Swiat_i_org;

import java.util.Random;
import java.util.Vector;
import Additional.*;
import Swiat_i_org.Animals.*;
import Swiat_i_org.Plants.*;


abstract public class Swiat {
    private final int wysokosc;
    private final int szerokosc;
    Vector<Organizm> organizmy;
    private Komentator kom;
    public int ruchCzlowieka = 0; //0-stoj 1-gora 2-dol 3-lewo 4-prawo 5-aktywacja mocy 6,7- ruchy hexowe



    public Swiat(int wys,int szer, Vector<Organizm>orgs){
        this.wysokosc = wys;
        this.szerokosc = szer;
        this.organizmy = orgs;
        kom = new Komentator();
        for(Organizm org : organizmy){
            org.setSwiat(this);
        }
    }

    public void setKom(Komentator kom){
        this.kom=kom;
    }
    public Swiat(int wys, int szer){
        organizmy = new Vector<>();
        this.wysokosc = wys;
        this.szerokosc = szer;
        kom = new Komentator();
//        this.typ = Typ.Zwykly;
        Random rand = new Random();
        for(int y = 0; y < wys; y++){
            for(int x = 0; x < szer; x++){
                int randomNum = rand.nextInt(27);
                switch(randomNum) {
                    case 0:
                        organizmy.add(new Antylopa(new Punkt(y,x)));
                        break;
                    case 1:
                        organizmy.add(new BarszczSosnowskiego(new Punkt(y,x)));
                        break;
                    case 2:
                        organizmy.add(new Guarana(new Punkt(y,x)));
                        break;
                    case 3:
                        organizmy.add(new Lis(new Punkt(y,x)));
                        break;
                    case 4:
                        organizmy.add(new Mlecz(new Punkt(y,x)));
                        break;
                    case 5:
                        organizmy.add(new Owca(new Punkt(y,x)));
                        break;
                    case 6:
                        organizmy.add(new Trawa(new Punkt(y,x)));
                        break;
                    case 7:
                        organizmy.add(new WilczeJagody(new Punkt(y,x)));
                        break;
                    case 8:
                        organizmy.add(new Wilk(new Punkt(y,x)));
                        break;
                    case 9:
                        organizmy.add(new Zolw(new Punkt(y,x)));
                        break;
                    default:
                        break;
                }
            }
        }
        int czlowiekX = rand.nextInt(szer-1);
        int czlowiekY = rand.nextInt(wys-1);
        Organizm help = GetOrgNaPoz(new Punkt(czlowiekY,czlowiekX));
        if(help != null) {
            for (Organizm org : organizmy) {
                if (org == help) {
                    organizmy.remove(org);
                    break;
                }
            }
        }
        organizmy.add(new Czlowiek(new Punkt(czlowiekY,czlowiekX)));
        for(Organizm org : organizmy){
            org.setSwiat(this);
        }
    }

    public boolean wlaczMoc(){
        for(Organizm org : organizmy){
            if(org instanceof Czlowiek){
                if(((Czlowiek) org).getUltTury() == 0){
                    ((Czlowiek) org).setUltTury(10);
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
            org.setRozmnozenie(false);
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
//    public Typ getTyp(){
//        return typ;
//    }

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
    abstract public Vector<Punkt> wektorZajetychWokol(Punkt pkt);
   abstract public Punkt wolnePoleObok(Punkt pkt);

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
