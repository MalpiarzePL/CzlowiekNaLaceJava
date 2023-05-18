package Swiat_i_org;

import Additional.Constants;
import Additional.Punkt;

import java.util.Random;

public abstract class Roslina extends Organizm {
    public Roslina(Punkt pkt, int sila){
        super(pkt,sila, Constants.INICJATYWA_ROSLIN);
    }
    public Roslina(Punkt pkt, int sila,int wiek){
        super(pkt,sila,Constants.INICJATYWA_ROSLIN,wiek);
    }
    @Override
    public void akcja(){
        sianie();
    }

    public void sianie(){
        Random rand = new Random();
        int randomNum = rand.nextInt(10);
        if(randomNum == 1)
            zasiej();
    }

    public void zasiej(){
        if(!stanRozmnozenia()) {
            Punkt pkt = getSwiat().wolnePoleObok(this.pozycja);
            if (pkt == null){
                return;
            }
            Roslina org = (Roslina)this.kopia();
            org.setPozycja(pkt);
            org.setWiek(0);
            org.setRozmnozenie(true);
            getSwiat().addOrg(org);
            this.getSwiat().getKom().dodajKom(new String(this+" rozsialo sie i powstal nowy organizm na polu "+org.getPozycja()));
        }
    }


}
