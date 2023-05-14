package Swiat_i_org.Plants;

import Additional.Punkt;
import Swiat_i_org.Organizm;
import Swiat_i_org.Roslina;

import java.awt.*;
import java.util.Random;

public class WilczeJagody extends Roslina{
    public static final int SILA = 99;
    public WilczeJagody(Punkt pkt){
        super(pkt,SILA);
    }
    @Override
    public WilczeJagody kopia(){
        return new WilczeJagody(pozycja);
    }

    @Override
    public String toString(){
        return "WILCZE_JAGODY";
    }

    @Override
    public Color rysowanie(){
        return new Color (148, 0, 211);
    }
    @Override
    public void reakcjaNaOrg(Organizm org){
        org.zabij();
    }
    @Override
    public void akcja(){
        Random rand = new Random();
        int randomNum = rand.nextInt(5);
        if(randomNum == 1)
            super.akcja();
    }
}
