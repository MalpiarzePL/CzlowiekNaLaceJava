package gui;

import javax.swing.*;
import java.awt.*;

public class Legenda extends JPanel{
    public int szerokosc;
    public int wysokosc;

    public Legenda(int wysokosc, int szerokosc){
        this.szerokosc = szerokosc;
        this.wysokosc = wysokosc;
        setPreferredSize(new Dimension(szerokosc,wysokosc));
    }
    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0,0,szerokosc,wysokosc);
        pokazLegende(g);
    }
    public void pokazLegende(Graphics g){
        g.setColor(new Color(255,255,255));
        g.setFont(new Font(Font.DIALOG,Font.PLAIN,23));
        g.drawString("Poruszanie - strzalki",0,35);
        g.drawString("Moc - r",0,70);

        g.setColor(new Color(255,0,0));
        g.fillRect(0,80,30,30);
        g.setColor(new Color(255,255,255));
        g.drawString("Czlowiek",35,105);

        g.setColor(new Color(197, 127, 48));
        g.fillRect(0,115,30,30);
        g.setColor(new Color(255,255,255));
        g.drawString("Antylopa",35,140);

        g.setColor(new Color(255, 140, 0));
        g.fillRect(0,150,30,30);
        g.setColor(new Color(255,255,255));
        g.drawString("Lis",35,175);

        g.setColor(new Color(255, 255, 255));
        g.fillRect(0,185,30,30);
        g.setColor(new Color(255,255,255));
        g.drawString("Owca",35,210);

        g.setColor(new Color(128,128,128));
        g.fillRect(0,220,30,30);
        g.setColor(new Color(255,255,255));
        g.drawString("Wilk",35,245);

        g.setColor(new Color(30, 100, 0));
        g.fillRect(0,255,30,30);
        g.setColor(new Color(255,255,255));
        g.drawString("Zolw",35,280);

        g.setColor(new Color(120, 255, 130));
        g.fillRect(0,290,30,30);
        g.setColor(new Color(255,255,255));
        g.drawString("Barszcz Sosnowskiego",35,315);

        g.setColor(new Color(139, 69, 19));
        g.fillRect(0,325,30,30);
        g.setColor(new Color(255,255,255));
        g.drawString("Guarana",35,350);

        g.setColor(new Color(255, 255, 0));
        g.fillRect(0,360,30,30);
        g.setColor(new Color(255,255,255));
        g.drawString("Mlecz",35,385);

        g.setColor(new Color(0,240,0));
        g.fillRect(0,395,30,30);
        g.setColor(new Color(255,255,255));
        g.drawString("Trawa",35,420);

        g.setColor(new Color(148, 0, 211));
        g.fillRect(0,430,30,30);
        g.setColor(new Color(255,255,255));
        g.drawString("Wilcze Jagody",35,455);
    }

}
