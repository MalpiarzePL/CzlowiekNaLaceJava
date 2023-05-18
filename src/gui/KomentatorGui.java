package gui;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;
import Additional.Constants;

import Swiat_i_org.Swiat;
import Additional.Komentator;

public class KomentatorGui extends JPanel {
    private int szerokosc;
    private int wysokosc;
    private Komentator kom;
    public KomentatorGui(int wysokosc, int szerokosc, Komentator k){
        this.szerokosc = szerokosc;
        this.wysokosc = wysokosc;
        kom =k;
        setPreferredSize(new Dimension(szerokosc,wysokosc));
    }
    public void setKom(Komentator k){
        kom = k;
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(50,0,szerokosc,wysokosc);
        wypiszKomentarze(g);
    }

    public void wypiszKomentarze(Graphics g){
        int y = 11;
        int counter = 0;
        g.setColor(Constants.KOLOR_NAPISOW);
            for (String str : kom.getKomentarze()) {
                if(counter == 34){
                    break;
                }
                g.drawString(str, 55, y);
                y += 15;
                counter++;
            }
            kom.czysc();
    }
}
