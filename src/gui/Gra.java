package gui;


import Swiat_i_org.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Additional.Constants;
import Additional.Zapisy;


public class Gra  extends JFrame{

    private Zapisy zapisy;
    private JButton tura;
    private Interfejs interfejs;
    private Legenda legenda;
    private KomentatorGui komentator;
    private JMenuItem PustyZwyklyMenu;
    private JMenuItem PustyHexMenu;
    private JMenuItem WczytajMenu;
    private JMenuItem ZapiszMenu;

    public void graj(){
        setVisible(true);
    }

    public Gra(int wysOkna, int szerOkna, int szerokosc, int wysokosc, int rodzaj){
        setSize(szerOkna,wysOkna);
        setMinimumSize(new Dimension(szerOkna,wysOkna));
        zapisy = new Zapisy();
        revalidate();

        setTitle("ADAM BIAŁEK 193677");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        if(rodzaj == 1) {
            interfejs = new Interfejs(Constants.WYSOKOSC_INTERFACE, new SwZwykly(wysokosc, szerokosc));
        } else if (rodzaj == 2) {
            interfejs = new Interfejs(Constants.WYSOKOSC_INTERFACE, new SwHex(wysokosc, szerokosc));
        }
        legenda = new Legenda(Constants.WYSOKOSC_INTERFACE,Constants.SZEROKOSC_LEGENDY);
        komentator = new KomentatorGui(Constants.WYSOKOSC_INTERFACE, Constants.SZEROKOSC_KOMENTATORA,interfejs.getSwiat().getKom());
        interfejs.setKom(komentator);
        inicjujMenuGorne();
        tworzGUI();
    }

    private void inicjujMenuGorne(){

        JMenuBar menuBar = new JMenuBar();

        JMenu pusteSwiaty = new JMenu("Puste");
        JMenu obslugaZapisu = new JMenu("Plik");

        tworzPrzyciskiGorne();

        pusteSwiaty.add(PustyZwyklyMenu);
        pusteSwiaty.add(PustyHexMenu);

        obslugaZapisu.add(WczytajMenu);
        obslugaZapisu.add(ZapiszMenu);

        menuBar.add(pusteSwiaty);
        menuBar.add(obslugaZapisu);

        setJMenuBar(menuBar);

    }
    private void tworzPrzyciskiGorne() {

        PustyZwyklyMenu = new JMenuItem("Pusty_zwykly");
        PustyHexMenu = new JMenuItem("Pusty_hex");
        WczytajMenu = new JMenuItem("wczytaj");
        ZapiszMenu = new JMenuItem("zapisz");

        ZapiszMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zapisy.zapisz(interfejs.getSwiat());
            }
        });
        WczytajMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Swiat world = zapisy.wczytaj();
                interfejs.setSwiat(world);
                komentator.setKom(world.getKom());
                interfejs.setWysokosc(world.getWysokosc());
                interfejs.setSzerokosc(world.getSzerokosc());
                interfejs.setWymiarPolaX(interfejs.getWysokoscOkna()/interfejs.getSzerokosc());
                interfejs.setWymiarPolaY(interfejs.getWysokoscOkna()/interfejs.getWysokosc());
                interfejs.setWymiarPola(((interfejs.getWymiarPolaX()>interfejs.getWymiarPolaY())?interfejs.getWymiarPolaX():interfejs.getWymiarPolaY())*0.67);
                paint(getGraphics());
            }
        });

        PustyZwyklyMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                interfejs.setSwiat(SwZwykly.Baza());
                komentator.setKom(interfejs.getSwiat().getKom());
                interfejs.setWysokosc(SwZwykly.Baza().getWysokosc());
                interfejs.setSzerokosc(SwZwykly.Baza().getSzerokosc());
                interfejs.setWymiarPolaX(interfejs.getWysokoscOkna()/interfejs.getSzerokosc());
                interfejs.setWymiarPolaY(interfejs.getWysokoscOkna()/interfejs.getWysokosc());
                interfejs.setWymiarPola(((interfejs.getWymiarPolaX()>interfejs.getWymiarPolaY())?interfejs.getWymiarPolaX():interfejs.getWymiarPolaY())*0.67);
                paint(getGraphics());
                paint(getGraphics());
            }

        });


        PustyHexMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                interfejs.setSwiat(SwHex.Baza());
                komentator.setKom(interfejs.getSwiat().getKom());
                interfejs.setWysokosc(SwHex.Baza().getWysokosc());
                interfejs.setSzerokosc(SwHex.Baza().getSzerokosc());
                interfejs.setWymiarPolaX(interfejs.getWysokoscOkna()/interfejs.getSzerokosc());
                interfejs.setWymiarPolaY(interfejs.getWysokoscOkna()/interfejs.getWysokosc());
                interfejs.setWymiarPola(((interfejs.getWymiarPolaX()>interfejs.getWymiarPolaY())?interfejs.getWymiarPolaX():interfejs.getWymiarPolaY())*0.67);
                paint(getGraphics());

                paint(getGraphics());
            }
        });
    }
    private void tworzGUI(){


        tworzNastepnaTuraBtn();

        JPanel panelGuziki = new JPanel();



        GridLayout layout = new GridLayout(0,1);
        panelGuziki.setLayout(layout);

        panelGuziki.add(tura);




        JSplitPane splitPane = new JSplitPane();

        splitPane.setEnabled(false);
        splitPane.setDividerLocation(Constants.WYSOKOSC_INTERFACE);
        splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);

        splitPane.addMouseListener(interfejs);

        JPanel mainPanel = new JPanel(new BorderLayout());



        mainPanel.add(legenda, BorderLayout.EAST);
        mainPanel.add(interfejs, BorderLayout.WEST);
        mainPanel.add(komentator, BorderLayout.CENTER);
        splitPane.setTopComponent(mainPanel);
        splitPane.setBottomComponent(panelGuziki);

        add(splitPane);


    }
    private void tworzNastepnaTuraBtn() {

        tura = new JButton("NASTEPNA TURA");


        tura.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                interfejs.nastepnaTura();

            }

        });
    }
}
