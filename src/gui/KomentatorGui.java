package gui;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

import Swiat_i_org.Swiat;
import Additional.Komentator;

public class KomentatorGui extends JPanel {
    public int szerokosc;
    public int wysokosc;
    public Komentator kom;
    public KomentatorGui(int wysokosc, int szerokosc, Komentator k){
        this.szerokosc = szerokosc;
        this.wysokosc = wysokosc;
        kom =k;
        setPreferredSize(new Dimension(szerokosc,wysokosc));
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
        g.setColor(new Color(255,255,255));
            for (String str : kom.komentarze) {
                g.drawString(str, 55, y);
                y += 15;
            }
            kom.czysc();
    }
}
