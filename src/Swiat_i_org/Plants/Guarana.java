package Swiat_i_org.Plants;

import Additional.Constants;
import Additional.Punkt;
import Swiat_i_org.Roslina;
import Swiat_i_org.Organizm;

import java.awt.*;

public class Guarana extends Roslina{
    public Guarana(Punkt pkt){
        super(pkt,Constants.SILA_ROSLINY_STANDARD);
    }
    @Override
    public Guarana kopia(){
        return new Guarana(pozycja);
    }
    public Guarana(int wiek, Punkt pkt){super(pkt,Constants.SILA_ROSLINY_STANDARD,wiek);}

    @Override
    public String toString(){
        return "GUARANA";
    }

    @Override
    public Color rysowanie(){
        return Constants.KOLOR_GUARANY;
    }
    @Override
    public void reakcjaNaOrg(Organizm org){
        org.setSila(org.getSila()+3);
    }
}
