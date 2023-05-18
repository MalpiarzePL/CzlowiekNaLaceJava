package Swiat_i_org;

import Additional.Punkt;
import java.util.Random;
import java.util.Vector;

public class SwHex extends Swiat{
    public SwHex(int wys,int szer, Vector<Organizm> orgs){
        super(wys,szer,orgs);
    }

    public SwHex(int wys,int szer){
        super(wys,szer);
    }

    @Override
    public Vector<Punkt> wektorZajetychWokol(Punkt pkt){
        Vector<Punkt> punkty = new Vector<>();
        Punkt pkt1 = pkt.changeNew(new Punkt(1,0));
        Punkt pkt2 = pkt.changeNew(new Punkt(-1,0));
        Punkt pkt3 = pkt.changeNew(new Punkt(0,1));
        Punkt pkt4 = pkt.changeNew(new Punkt(0,-1));
        Punkt pkt5 = pkt.changeNew(new Punkt(1,-1));
        Punkt pkt6 = pkt.changeNew(new Punkt(-1,1));
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
        if(GetOrgNaPoz(pkt5) != null ){
            punkty.add(pkt5);
        }
        if(GetOrgNaPoz(pkt6) != null ){
            punkty.add(pkt6);
        }
        return punkty;
    }
    @Override
    public Punkt wolnePoleObok(Punkt pkt){
        Vector<Punkt> punkty = new Vector<>();
        Punkt pkt1 = pkt.changeNew(new Punkt(1,0));
        Punkt pkt2 = pkt.changeNew(new Punkt(-1,0));
        Punkt pkt3 = pkt.changeNew(new Punkt(0,1));
        Punkt pkt4 = pkt.changeNew(new Punkt(0,-1));
        Punkt pkt5 = pkt.changeNew(new Punkt(1,-1));
        Punkt pkt6 = pkt.changeNew(new Punkt(-1,1));
        if(!pkt1.pozaPolem(this.getWysokosc(),this.getSzerokosc())&& GetOrgNaPoz(pkt1) == null){
            punkty.add(pkt1);
        }
        if(!pkt2.pozaPolem(this.getWysokosc(),this.getSzerokosc())&& GetOrgNaPoz(pkt2) == null){
            punkty.add(pkt2);
        }
        if(!pkt3.pozaPolem(this.getWysokosc(),this.getSzerokosc())&& GetOrgNaPoz(pkt3) == null){
            punkty.add(pkt3);
        }
        if(!pkt4.pozaPolem(this.getWysokosc(),this.getSzerokosc())&& GetOrgNaPoz(pkt4) == null){
            punkty.add(pkt4);
        }
        if(!pkt5.pozaPolem(this.getWysokosc(),this.getSzerokosc())&& GetOrgNaPoz(pkt5) == null){
            punkty.add(pkt5);
        }
        if(!pkt6.pozaPolem(this.getWysokosc(),this.getSzerokosc())&& GetOrgNaPoz(pkt6) == null){
            punkty.add(pkt6);
        }
        if(punkty.isEmpty()){
            return null;
        }
        Random rand = new Random();
        int randomNum = rand.nextInt(punkty.size());
        return punkty.get(randomNum);
    }
    public static SwHex Baza(){
        Vector<Organizm> orgs = new Vector<>();
        SwHex world = new SwHex(10,10,orgs);


        return world;
    }
}
