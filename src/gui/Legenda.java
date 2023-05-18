package gui;

import javax.swing.*;
import java.awt.*;
import Additional.Constants;

public class Legenda extends JPanel{
    private int szerokosc;
    private int wysokosc;

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
    public void pokazLegende(Graphics g) {
        g.setColor(Constants.KOLOR_NAPISOW);
        g.setFont(new Font(Font.DIALOG, Font.PLAIN, 20));

        int startY = 20;
        g.drawString("Poruszanie - strzalki", 0, startY);
        g.drawString("Moc - r", 0, startY + 20);
        g.drawString("Poruszanie Hex - i,k,m,n,h,u", 0, startY+40);
        int rectY = startY + 65;

        g.setColor(Constants.KOLOR_CZLOWIEKA);
        g.fillRect(0, rectY, 30, 20);
        g.setColor(Constants.KOLOR_NAPISOW);
        g.drawString("Czlowiek", 35, rectY + 20);

        rectY += 35;

        g.setColor(Constants.KOLOR_ANTYLOPY);
        g.fillRect(0, rectY, 30, 20);
        g.setColor(Constants.KOLOR_NAPISOW);
        g.drawString("Antylopa", 35, rectY + 20);

        rectY += 35;

        g.setColor(Constants.KOLOR_LISA);
        g.fillRect(0, rectY, 30, 20);
        g.setColor(Constants.KOLOR_NAPISOW);
        g.drawString("Lis", 35, rectY + 20);

        rectY += 35;

        g.setColor(Constants.KOLOR_OWCY);
        g.fillRect(0, rectY, 30, 20);
        g.setColor(Constants.KOLOR_NAPISOW);
        g.drawString("Owca", 35, rectY + 20);

        rectY += 35;

        g.setColor(Constants.KOLOR_WILKA);
        g.fillRect(0, rectY, 30, 20);
        g.setColor(Constants.KOLOR_NAPISOW);
        g.drawString("Wilk", 35, rectY + 20);

        rectY += 35;

        g.setColor(Constants.KOLOR_ZOLWIA);
        g.fillRect(0, rectY, 30, 20);
        g.setColor(Constants.KOLOR_NAPISOW);
        g.drawString("Zolw", 35, rectY + 20);

        rectY += 35;

        g.setColor(Constants.KOLOR_BARSZCZU);
        g.fillRect(0, rectY, 30, 20);
        g.setColor(Constants.KOLOR_NAPISOW);
        g.drawString("Barszcz Sosnowskiego", 35, rectY + 20);

        rectY += 35;

        g.setColor(Constants.KOLOR_GUARANY);
        g.fillRect(0, rectY, 30, 20);
        g.setColor(Constants.KOLOR_NAPISOW);
        g.drawString("Guarana", 35, rectY + 20);

        rectY += 35;

        g.setColor(Constants.KOLOR_MLECZA);
        g.fillRect(0, rectY, 30, 20);
        g.setColor(Constants.KOLOR_NAPISOW);
        g.drawString("Mlecz", 35, rectY + 20);

        rectY += 35;

        g.setColor(Constants.KOLOR_TRAWY);
        g.fillRect(0, rectY, 30, 20);
        g.setColor(Constants.KOLOR_NAPISOW);
        g.drawString("Trawa", 35, rectY + 20);

        rectY += 35;

        g.setColor(Constants.KOLOR_JAGOD);
        g.fillRect(0, rectY, 30, 20);
        g.setColor(Constants.KOLOR_NAPISOW);
        g.drawString("Wilcze Jagody", 35, rectY + 20);
    }


}
