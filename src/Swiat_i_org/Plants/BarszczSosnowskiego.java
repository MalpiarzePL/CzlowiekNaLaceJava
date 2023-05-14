package Swiat_i_org.Plants;

import Additional.Punkt;
import Swiat_i_org.Organizm;
import Swiat_i_org.Roslina;
import Swiat_i_org.Zwierze;

import java.awt.*;
import java.util.Random;
import java.util.Vector;

public class BarszczSosnowskiego extends Roslina {

    public static final int SILA = 10;
    public BarszczSosnowskiego(Punkt pkt){
        super(pkt,SILA);
    }
    @Override
    public BarszczSosnowskiego kopia(){
        return new BarszczSosnowskiego(pozycja);
    }

    @Override
    public String toString(){
        return "BARSZCZ_SOSNOWSKIEGO";
    }

    @Override
    public Color rysowanie(){
        return new Color (120, 255, 130);
    }
    @Override
    public void reakcjaNaOrg(Organizm org){
        org.zabij();
    }
    @Override
    public void akcja(){
        Vector<Punkt> punkty = this.getSwiat().wektorZajetychWokol(this.pozycja);
        if(!punkty.isEmpty()){
            for(int i = 0; i < punkty.size();i++){
                if(this.getSwiat().GetOrgNaPoz(punkty.get(i)) instanceof Zwierze){
                    this.getSwiat().GetOrgNaPoz(punkty.get(i)).zabij();
                }
            }
        }
        Random rand = new Random();
        int randomNum = rand.nextInt(7);
        if(randomNum == 1)
            super.akcja();
    }
}
