package Swiat_i_org;

import Additional.Punkt;

import java.util.Random;

public abstract class Roslina extends Organizm {
    public final static int INICJATYWA_ROSLINA = 0;
    public Roslina(Punkt pkt, int sila){
        super(pkt,sila,INICJATYWA_ROSLINA);
    }
    public Roslina(Punkt pkt, int sila,int wiek){
        super(pkt,sila,INICJATYWA_ROSLINA,wiek);
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
        if(!czyRozmnozony) {
            Punkt pkt = getSwiat().wolnePoleObok(this.pozycja);
            if (pkt == null){
                return;
            }
            Roslina org = (Roslina)this.kopia();
            org.setPozycja(pkt);
            org.setWiek(0);
            getSwiat().addOrg(org);
            czyRozmnozony = true;
        }
    }


}
