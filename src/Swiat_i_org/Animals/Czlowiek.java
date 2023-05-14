package Swiat_i_org.Animals;

import Additional.Punkt;
import Swiat_i_org.Zwierze;

import java.awt.*;
import java.util.Random;

public class Czlowiek extends Zwierze{
    public static final int SILA = 5;
    public static final int INICJATYWA = 4;
    public int ultTury;
    public Czlowiek(Punkt pkt){
        super(pkt,SILA,INICJATYWA);
        ultTury = 0;
    }
    public Czlowiek(int sila,int wiek, Punkt pkt,int tury){
        super(pkt,sila,INICJATYWA,wiek);
        ultTury = tury;
    }
    @Override
    public void akcja(){
        int zasiegRuch;
        if(ultTury == 0){
            zasiegRuch = 1;
        }
        else if(ultTury >=8){
            zasiegRuch = 2;
            ultTury--;
        }
        else if(ultTury >=6){
            Random rand = new Random();
            int randomNum = rand.nextInt(2);
            if(randomNum == 0){
                zasiegRuch = 1;
            }
            else{
                zasiegRuch = 2;
            }
            ultTury--;
        }
        else{
            zasiegRuch = 1;
            ultTury--;
        }
        switch (getSwiat().popRuchCzlowieka()){
            case 1:
                rusz(new Punkt(-zasiegRuch,0));
                break;
            case 2:
                rusz(new Punkt(zasiegRuch,0));
                break;
            case 3:
                rusz(new Punkt(0,-zasiegRuch));
                break;
            case 4:
                rusz(new Punkt(0,zasiegRuch));
                break;
        }
    }

    @Override
    public Czlowiek kopia(){
        return new Czlowiek(pozycja);
    }

    @Override
    public String toString(){
        return "CZLOWIEK";
    }
    @Override
    public Color rysowanie(){
        return new Color (255,0,0);
    }

}
