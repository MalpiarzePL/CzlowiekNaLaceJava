package Additional;


import Swiat_i_org.*;
import Swiat_i_org.Animals.*;
import Swiat_i_org.Plants.*;

import javax.swing.*;
import java.io.*;

public class Zapisy {
    public void zapisz(Swiat world){
        String filename = "zapis.txt";
        try{
            File file = new File(filename);
            if(!file.exists()){
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(world.getWysokosc()+" "+ world.getSzerokosc()+" "+world.getTyp()+"\n");
            for(Organizm org : world.getOrganizmy()){
                fileWriter.write(org.toString()+" "+org.getSila()+" "+org.getWiek()+" "+org.getPozycja().getY()+" "+org.getPozycja().getX());
                if(org instanceof Czlowiek){
                    fileWriter.write(" "+((Czlowiek)org).ultTury);
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
                Swiat.Typ typ = Swiat.Typ.Zwykly;
                if(firstLine[2].equals("Hex")){
                    typ = Swiat.Typ.Hex;
                }
                world = new Swiat(Integer.parseInt(firstLine[0]),Integer.parseInt(firstLine[1]), typ);
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
               /* if(tokens[0].equals("BARSZCZ_SOSNOWSKIEGO")){
                    org = new BarszczSosnowskiego(Integer.parseInt(tokens[1]),Integer.parseInt(tokens[2]), new Punkt(Integer.parseInt(tokens[3]),Integer.parseInt(tokens[4])));
                }
                if(tokens[0].equals("ANTYLOPA")){
                    org = new Antylopa(Integer.parseInt(tokens[1]),Integer.parseInt(tokens[2]), new Punkt(Integer.parseInt(tokens[3]),Integer.parseInt(tokens[4]));
                }
                if(tokens[0].equals("ANTYLOPA")){
                    org = new Antylopa(Integer.parseInt(tokens[1]),Integer.parseInt(tokens[2]), new Punkt(Integer.parseInt(tokens[3]),Integer.parseInt(tokens[4]));
                }
                if(tokens[0].equals("ANTYLOPA")){
                    org = new Antylopa(Integer.parseInt(tokens[1]),Integer.parseInt(tokens[2]), new Punkt(Integer.parseInt(tokens[3]),Integer.parseInt(tokens[4]));
                }
                if(tokens[0].equals("ANTYLOPA")){
                    org = new Antylopa(Integer.parseInt(tokens[1]),Integer.parseInt(tokens[2]), new Punkt(Integer.parseInt(tokens[3]),Integer.parseInt(tokens[4]));
                }
                if(tokens[0].equals("ANTYLOPA")){
                    org = new Antylopa(Integer.parseInt(tokens[1]),Integer.parseInt(tokens[2]), new Punkt(Integer.parseInt(tokens[3]),Integer.parseInt(tokens[4]));
                }*/
                world.addOrg(org);
            }
            return world;
        }
       catch(IOException e){
            e.printStackTrace();
       }


        return null;
    }
}
