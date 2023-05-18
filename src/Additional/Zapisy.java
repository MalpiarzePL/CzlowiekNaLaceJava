package Additional;


import Swiat_i_org.*;
import Swiat_i_org.Animals.*;
import Swiat_i_org.Plants.*;
import Additional.Constants;

import javax.swing.*;
import java.io.*;
import java.util.Vector;

public class Zapisy {
    public void zapisz(Swiat world){
        String filename = "zapis.txt";
        try{
            File file = new File(filename);
            if(!file.exists()){
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file);
            if(world instanceof SwZwykly){
                fileWriter.write(world.getWysokosc()+" "+ world.getSzerokosc()+" ZWYKLY"+"\n");}
            else{
                fileWriter.write(world.getWysokosc()+" "+ world.getSzerokosc()+" HEX"+"\n");
            }
            for(Organizm org : world.getOrganizmy()){
                fileWriter.write(org.toString()+" "+org.getSila()+" "+org.getWiek()+" "+org.getPozycja().getY()+" "+org.getPozycja().getX());
                if(org instanceof Czlowiek){
                    fileWriter.write(" "+((Czlowiek)org).getUltTury());
                }
                fileWriter.write("\n");
            }
            fileWriter.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public Swiat wczytaj(){
        String filename = "zapis.txt";
        try{
            File file = new File(filename);
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            Swiat world;
            String[] firstLine = reader.readLine().split(" ");
//                Swiat.Typ typ = Swiat.Typ.Zwykly;
//                if(firstLine[2].equals("Hex")){
//                    typ = Swiat.Typ.Hex;
//                }
            ///NAPRAW ZAPISU TU BO SIE BEDZIE LOSOWO TWORZYLO
                Vector<Organizm> orgs = new Vector<>();
            while ((line = reader.readLine()) != null){
                String[] tokens = line.split(" ");
                Organizm org = null;
                if(tokens[0].equals("ANTYLOPA")){
                    org = new Antylopa(Integer.parseInt(tokens[1]),Integer.parseInt(tokens[2]), new Punkt(Integer.parseInt(tokens[3]),Integer.parseInt(tokens[4])));
                }
                if(tokens[0].equals("LIS")){
                    org = new Lis(Integer.parseInt(tokens[1]),Integer.parseInt(tokens[2]), new Punkt(Integer.parseInt(tokens[3]),Integer.parseInt(tokens[4])));
                }
                if(tokens[0].equals("OWCA")){
                    org = new Owca(Integer.parseInt(tokens[1]),Integer.parseInt(tokens[2]), new Punkt(Integer.parseInt(tokens[3]),Integer.parseInt(tokens[4])));
                }
                if(tokens[0].equals("WILK")){
                    org = new Wilk(Integer.parseInt(tokens[1]),Integer.parseInt(tokens[2]), new Punkt(Integer.parseInt(tokens[3]),Integer.parseInt(tokens[4])));
                }
                if(tokens[0].equals("ZOLW")){
                    org = new Zolw(Integer.parseInt(tokens[1]),Integer.parseInt(tokens[2]), new Punkt(Integer.parseInt(tokens[3]),Integer.parseInt(tokens[4])));
                }
                if(tokens[0].equals("BARSZCZ_SOSNOWSKIEGO")){
                    org = new BarszczSosnowskiego(Integer.parseInt(tokens[2]), new Punkt(Integer.parseInt(tokens[3]),Integer.parseInt(tokens[4])));
                }
                 if(tokens[0].equals("GUARANA")){
                    org = new Guarana(Integer.parseInt(tokens[2]), new Punkt(Integer.parseInt(tokens[3]),Integer.parseInt(tokens[4])));
                }
                if(tokens[0].equals("MLECZ")){
                    org = new Mlecz(Integer.parseInt(tokens[2]), new Punkt(Integer.parseInt(tokens[3]),Integer.parseInt(tokens[4])));
                }
                if(tokens[0].equals("TRAWA")){
                    org = new Trawa(Integer.parseInt(tokens[2]), new Punkt(Integer.parseInt(tokens[3]),Integer.parseInt(tokens[4])));
                }
                if(tokens[0].equals("WILCZE_JAGODY")){
                    org = new WilczeJagody(Integer.parseInt(tokens[2]), new Punkt(Integer.parseInt(tokens[3]),Integer.parseInt(tokens[4])));
                }
                 if(tokens[0].equals("CZLOWIEK")){
                    org = new Czlowiek(Integer.parseInt(tokens[1]),Integer.parseInt(tokens[2]), new Punkt(Integer.parseInt(tokens[3]),Integer.parseInt(tokens[4])), Integer.parseInt(tokens[5]));
                }
                orgs.add(org);
            }
            if(firstLine[2].equals("ZWYKLY")){
            world = new SwZwykly(Integer.parseInt(firstLine[0]),Integer.parseInt(firstLine[1]),orgs);
            world.setKom(new Komentator());
                return world;
            }
            if(firstLine[2].equals("HEX")){
                world = new SwHex(Integer.parseInt(firstLine[0]),Integer.parseInt(firstLine[1]),orgs);
                world.setKom(new Komentator());
                return world;
            }

        }
       catch(IOException e){
            e.printStackTrace();
       }


        return null;
    }
}
