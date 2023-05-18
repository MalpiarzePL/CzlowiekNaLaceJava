package gui;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Swiat_i_org.*;
import Swiat_i_org.Animals.*;
import Swiat_i_org.Plants.*;
import Additional.*;
import Additional.Constants;

public class Interfejs extends JPanel implements KeyListener, MouseListener {

    private Swiat swiat;
    private int wysokosc;
    private int szerokosc;
    private int wysokoscOkna;
    private int wymiarPolaY;
    private int wymiarPolaX;
    private double wymiarPola;
    private Punkt nowePolozenie;
    private KomentatorGui kom;
    private JPopupMenu nowyOrgMenu;
    private boolean mocCzlowieka;
    public Interfejs(int wysokoscOkna, Swiat swiat){
        this.wysokosc = swiat.getWysokosc();
        this.szerokosc = swiat.getSzerokosc();
        this.wysokoscOkna = wysokoscOkna;
        wymiarPolaX = wysokoscOkna/szerokosc;
        wymiarPolaY = wysokoscOkna/wysokosc;
        wymiarPola = ((wymiarPolaX>wymiarPolaY)?wymiarPolaY:wymiarPolaX)*0.67;
        this.swiat = swiat;
        this.nowePolozenie = new Punkt(0,0);
        setPreferredSize(new Dimension(wysokoscOkna,wysokoscOkna));
        setSize(new Dimension(wysokoscOkna,wysokoscOkna));
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(true);
        PopupMenu();
    }
    public int getWysokosc(){
        return wysokosc;
    }
    public int getSzerokosc(){
        return szerokosc;
    }
    public int getWysokoscOkna(){
        return wysokoscOkna;
    }
    public int getWymiarPolaY(){
        return wymiarPolaY;
    }
    public int getWymiarPolaX(){
        return wymiarPolaX;
    }
    public double getWymiarPola(){
        return wymiarPola;
    }
    public void setWysokosc(int wys){
        this.wysokosc = wys;
    }
    public void setSzerokosc(int szer){
        this.szerokosc = szer;
    }
    public void setWysokoscOkna(int wys){
        this.wysokoscOkna = wys;
    }
    public void setWymiarPolaY(int wymY){
        this.wymiarPolaY = wymY;
    }
    public void setWymiarPolaX(int wymX){
        this.wymiarPolaX = wymX;
    }
    public void setWymiarPola(double wym){
        this.wymiarPola = wym;
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
        Punkt pkt = new Punkt(0,0);
        Organizm[] organizms = {
                new Wilk(pkt),
                new Owca(pkt),
                new Antylopa(pkt),
                new Zolw(pkt),
                new Lis(pkt),
                new Trawa(pkt),
                new Mlecz(pkt),
                new Guarana(pkt),
                new WilczeJagody(pkt),
                new BarszczSosnowskiego(pkt),
                new Czlowiek(pkt)
        };
        for(Organizm org : organizms){
            JMenuItem orgMenu = new JMenuItem(org.toString());
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
        if (org instanceof Czlowiek) {
            for(Organizm org1 : swiat.getOrganizmy()){
                if(org1 instanceof Czlowiek){
                    return;
                }
            }
        }
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
        if(swiat instanceof SwZwykly) {
            nowePolozenie = new Punkt(y / wymiarPolaY, x / wymiarPolaX);
        }
        else{
            int newX = (int)(x-(0.5*(y/wymiarPola)*wymiarPola+0.5*wymiarPola)-(int)0.8*wymiarPola);
            nowePolozenie = new Punkt((int)(y / wymiarPola),(int)(newX/wymiarPola));
        }
        if(!nowePolozenie.pozaPolem(swiat.getWysokosc(),swiat.getSzerokosc())) {
            nowyOrgMenu.show(this, x, y);
        }

    }

    @Override
    public void keyPressed(KeyEvent keyEvent){
        if(swiat instanceof SwZwykly) {
            switch (keyEvent.getKeyCode()) {

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
        }
        else{
            switch (keyEvent.getKeyCode()) {

                case KeyEvent.VK_U:
                    swiat.setRuchCzlowieka(1);
                    break;
                case KeyEvent.VK_M:
                    swiat.setRuchCzlowieka(2);
                    break;
                case KeyEvent.VK_H:
                    swiat.setRuchCzlowieka(3);
                    break;
                case KeyEvent.VK_K:
                    swiat.setRuchCzlowieka(4);
                    break;
                case KeyEvent.VK_R:
                    mocCzlowieka = swiat.wlaczMoc();
                    swiat.setRuchCzlowieka(5);
                    break;
                case KeyEvent.VK_I:
                    swiat.setRuchCzlowieka(6);
                    break;
                case KeyEvent.VK_N:
                    swiat.setRuchCzlowieka(7);
                    break;

            }
        }

        paint(getGraphics());
    }

    @Override
    public void paint(Graphics g){
        g.setColor(Constants.KOLOR_TLA);
        g.fillRect(0,0,szerokosc * wymiarPolaX,wysokosc * wymiarPolaY);
        for(int y = 0; y < wysokosc; y++){
            for(int x = 0; x < szerokosc; x++){
                Organizm org = swiat.GetOrgNaPoz(new Punkt(y,x));
                    if(swiat instanceof SwZwykly) {
                        if(org != null) {
                            g.setColor(org.rysowanie());
                            g.fillRect(x * wymiarPolaX, y * wymiarPolaY, wymiarPolaX, wymiarPolaY);
                        }
                        else{
                            g.setColor(Color.GRAY);
                            g.drawRect(x * wymiarPolaX, y * wymiarPolaY, wymiarPolaX, wymiarPolaY);
                        }
                    }
                    else {
                        int[] wspX = new int[6];
                        int[] wspY = new int[6];
                        double helpX =x+y*0.5;
                        double helpY = y+0.5;
                        helpX+=1;

                        for (int i = 0; i < 6; i++) {
                            int xval = (int) (helpX * wymiarPola + wymiarPola /2
                                    * Math.sin(i * 2 * Math.PI / 6D));
                            int yval = (int) (helpY * wymiarPola + wymiarPola /2
                                    * Math.cos(i * 2 * Math.PI / 6D));

                            wspX[i] = xval;
                            wspY[i] = yval;

                        }
                        if(org != null){
                            g.setColor(org.rysowanie());
                            g.fillPolygon(wspX, wspY, wspY.length);
                        }
                        else{
                            g.setColor(Color.GRAY);
                            g.drawPolygon(wspX, wspY, wspY.length);

                        }


                   }

            }

        }

        statusCzlowieka(g);


    }
    public void statusCzlowieka(Graphics graph){
        graph.setColor(new Color(255,255,255));
        String str = "Czlowiek: ";
        boolean zyje = false;
        for(Organizm org : swiat.getOrganizmy()){
            if(org instanceof Czlowiek){
                zyje = true;
                break;
            }
        }
        if(zyje) {
            if (swiat instanceof SwZwykly) {
                switch (swiat.getRuchCzlowieka()) {
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
                        if (mocCzlowieka) {
                            str += "aktywowano moc (nacisnij strzalke aby wybrac ruch)";
                        } else {
                            str += "nie mozna aktywowac mocy (nacisnij strzalke aby wybrac ruch)";
                        }
                        break;
                }
            } else {
                switch (swiat.getRuchCzlowieka()) {
                    case 1:
                        str += "lewy gorny";
                        break;
                    case 2:
                        str += "prawy dolny";
                        break;
                    case 3:
                        str += "lewo";
                        break;
                    case 4:
                        str += "prawo";
                        break;
                    case 5:
                        if (mocCzlowieka) {
                            str += "aktywowano moc (nacisnij strzalke aby wybrac ruch)";
                        } else {
                            str += "nie mozna aktywowac mocy (nacisnij strzalke aby wybrac ruch)";
                        }
                        break;
                    case 6:
                        str += "prawy gorny";
                        break;
                    case 7:
                        str += "lewy dolny";
                        break;
                }
            }
        }
        else{
            str+="nie zyje";
        }
        int x = 1;
        int y = 11;
        graph.setFont(new Font(Font.DIALOG,Font.PLAIN,10));
        graph.setColor(Color.black);
        graph.drawString(str, x + 1, y - 1);
        graph.drawString(str, x + 1, y + 1);
        graph.drawString(str, x - 1, y - 1);
        graph.drawString(str, x - 1, y + 1);

        graph.setColor(new Color(200,200,200));
        graph.drawString(str, x, y);
    }
    @Override
    public void keyReleased(KeyEvent keyEvent) {

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

}
