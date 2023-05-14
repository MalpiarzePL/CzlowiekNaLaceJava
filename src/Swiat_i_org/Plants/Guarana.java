package Swiat_i_org.Plants;

import Additional.Punkt;
import Swiat_i_org.Roslina;
import Swiat_i_org.Organizm;

import java.awt.*;

public class Guarana extends Roslina{
    public static final int SILA = 0;
    public Guarana(Punkt pkt){
        super(pkt,SILA);
    }
    @Override
    public Guarana kopia(){
        return new Guarana(pozycja);
    }

    @Override
    public String toString(){
        return "GUARANA";
    }

    @Override
    public Color rysowanie(){
        return new Color (139, 69, 19);
    }
    @Override
    public void reakcjaNaOrg(Organizm org){
        org.setSila(org.getSila()+3);
    }
}
