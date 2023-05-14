package gui;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Swiat_i_org.*;
import Swiat_i_org.Animals.*;
import Swiat_i_org.Plants.*;
import Additional.*;

public class Interfejs extends JPanel implements KeyListener, MouseListener {
    private static final Color KOLOR_TLA = new Color(0,0,0);
    private static final Color KOLOR_INFO = new Color(255,200,200);
    private Swiat swiat;
    private int wysokosc;
    private int szerokosc;
    private int wysokoscOkna;
    private int rozmiarZwierzecia;
    private Punkt nowePolozenie;
    public KomentatorGui kom;
    private JPopupMenu nowyOrgMenu;
    public boolean mocCzlowieka;
    public Interfejs(int wysokoscOkna, Swiat swiat){
        this.wysokosc = swiat.getWysokosc();
        this.szerokosc = swiat.getSzerokosc();
        this.wysokoscOkna = wysokoscOkna;
        this.swiat = swiat;
        this.nowePolozenie = new Punkt(0,0);
        setPreferredSize(new Dimension(wysokoscOkna,wysokoscOkna));
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(true);
        PopupMenu();
    }
    public void setKom(KomentatorGui k){
        kom = k;
    }
    public Swiat getSwiat(){
        return this.swiat;
    }
    public void setSwiat(Swiat world){
        this.swiat = world;
        this.szerokosc = swiat.getSzerokosc();
        this.wysokosc = swiat.getWysokosc();

        paint(this.getGraphics());
    }
    public void nastepnaTura() {

        swiat.wykonajTure();
        paint(this.getGraphics());
        kom.paint(kom.getGraphics());
        requestFocus();
    }
    private void PopupMenu(){
        nowyOrgMenu = new JPopupMenu();
        Punkt pkt0 = new Punkt(0,0);
        Organizm[] organizms = {
                new Wilk(pkt0),
                new Owca(pkt0),
                new Antylopa(pkt0),
                new Zolw(pkt0),
                new Lis(pkt0),
                new Trawa(pkt0),
                new Mlecz(pkt0),
                new Guarana(pkt0),
                new WilczeJagody(pkt0),
                new BarszczSosnowskiego(pkt0)
        };
        for(Organizm org : organizms){
            JMenuItem orgMenu = new JMenuItem(org.toString());
            orgMenu.setBackground(org.rysowanie());
            orgMenu.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    PutOrg(org);
                }
            });
            nowyOrgMenu.add(orgMenu);
        }
    }
    private void PutOrg(Organizm org){
        Organizm kolizja = swiat.GetOrgNaPoz(nowePolozenie);
        if(kolizja == null){
            org.setPozycja(nowePolozenie);
            swiat.addOrg(org.kopia());
            paint(getGraphics());
        }
    }
    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

        int x = mouseEvent.getX();
        int y = mouseEvent.getY();

        nowePolozenie = new Punkt(y/rozmiarZwierzecia,x/rozmiarZwierzecia);
        if(!nowePolozenie.pozaPolem(swiat.getWysokosc(),swiat.getSzerokosc())) {
            nowyOrgMenu.show(this, x, y);
        }

    }
    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
    @Override
    public void keyPressed(KeyEvent keyEvent){

        switch(keyEvent.getKeyCode()){
            case KeyEvent.VK_UP:
                swiat.setRuchCzlowieka(1);
                break;
            case KeyEvent.VK_DOWN:
                swiat.setRuchCzlowieka(2);
                break;
            case KeyEvent.VK_LEFT:
                swiat.setRuchCzlowieka(3);
                break;
            case KeyEvent.VK_RIGHT:
                swiat.setRuchCzlowieka(4);
                break;
            case KeyEvent.VK_R:
                mocCzlowieka = swiat.wlaczMoc();
                swiat.setRuchCzlowieka(5);
                break;
        }

        paint(getGraphics());
    }
    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }
    @Override
    public void paint(Graphics g){

        g.setColor(KOLOR_TLA);

        rozmiarZwierzecia = wysokoscOkna/wysokosc;
        g.fillRect(0,0,szerokosc * rozmiarZwierzecia,wysokosc * rozmiarZwierzecia);




        for(int y = 0; y < wysokosc; y++){

            for(int x = 0; x < szerokosc; x++){

                Organizm org = swiat.GetOrgNaPoz(new Punkt(y,x));

                if(org != null){

                    g.setColor(org.rysowanie());

                    if(swiat.getTyp() == Swiat.Typ.Zwykly){

                        g.fillRect(x* rozmiarZwierzecia,y* rozmiarZwierzecia, rozmiarZwierzecia, rozmiarZwierzecia);

                    } else {

                        int[] xPoints = new int[6];
                        int[] yPoints = new int[6];

                        double xtemp = x;

                        if(y %2 == 0){

                            xtemp = x + 0.5;

                        }

                        for (int i = 0; i < 6; i++) {
                            int xval = (int) (xtemp * rozmiarZwierzecia + rozmiarZwierzecia/2
                                    * Math.sin(i * 2 * Math.PI / 6D));
                            int yval = (int) (y * rozmiarZwierzecia + rozmiarZwierzecia/2
                                    * Math.cos(i * 2 * Math.PI / 6D));

                            xPoints[i] = xval;
                            yPoints[i] = yval;

                        }

                        g.fillPolygon(xPoints, yPoints, yPoints.length);

                    }

                }

            }

        }

        statusCzlowieka(g);


    }
    public void statusCzlowieka(Graphics graph){
        graph.setColor(new Color(255,255,255));
        String str = "Czlowiek: ";
        switch(swiat.getRuchCzlowieka()){
            case 1:
                str += "gora";
                break;
            case 2:
                str += "dol";
                break;
            case 3:
                str += "lewo";
                break;
            case 4:
                str += "prawo";
                break;
            case 5:
                if(mocCzlowieka){
                    str+="aktywowano moc (nacisnij strzalke aby wybrac ruch)";
                }
                else{
                    str+="nie mozna aktywowac mocy (nacisnij strzalke aby wybrac ruch)";
                }
                break;
        }
        graph.drawString(str,0,10);
    }

}
