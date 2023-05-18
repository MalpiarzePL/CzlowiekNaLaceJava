package Swiat_i_org.Plants;

import Additional.Constants;
import Additional.Punkt;
import Swiat_i_org.Organizm;
import Swiat_i_org.Roslina;

import java.awt.*;
import java.util.Random;

public class WilczeJagody extends Roslina{
    public WilczeJagody(Punkt pkt){
        super(pkt,Constants.SILA_JAGOD);
    }
    public WilczeJagody(int wiek, Punkt pkt){super(pkt,Constants.SILA_JAGOD,wiek);}
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
        return Constants.KOLOR_JAGOD;
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
