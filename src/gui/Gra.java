package gui;


import Swiat_i_org.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import Additional.Zapisy;

public class Gra  extends JFrame{

    Zapisy zapisy;
    public static final int DOMYSLNA_WYSOKOSC = 600;
    public static final int DOMYSLNA_SZEROKOSC = 1500;

    private JButton tura;
    private final Interfejs interfejs;
    private final Legenda legenda;
    private final KomentatorGui komentator;
    private JMenuItem menuItemBazowy;

    private JMenuItem menuItemBazowyHex;

    private JMenuItem menuItemWczytaj;
    private JMenuItem menuItemZapisz;

    public void graj(){
        setVisible(true);
    }
    public Gra(int wysokosc, int szerokosc){
        setSize(szerokosc,wysokosc);
        setMinimumSize(new Dimension(szerokosc,wysokosc));
        zapisy = new Zapisy();
        revalidate();

        setTitle("CZLOWIEK NA LACE");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        interfejs = new Interfejs(DOMYSLNA_WYSOKOSC *8/10,Swiat.Baza(Swiat.Typ.Zwykly));
        legenda = new Legenda(DOMYSLNA_WYSOKOSC *8/10,275);
        komentator = new KomentatorGui(DOMYSLNA_WYSOKOSC *8/10, 500,interfejs.getSwiat().getKom());
        interfejs.setKom(komentator);
        inicjujMenuGorne();
        inicjujPanelGlowny();
    }
    private void inicjujLegende(){

    }
    private void inicjujMenuGorne(){

        JMenuBar menuBar = new JMenuBar();

        JMenu menuNowy = new JMenu("Nowy");
        JMenu menuPlik = new JMenu("Plik");

        inicjujGuzikiMenuGornego();

        menuNowy.add(menuItemBazowy);
        menuNowy.add(menuItemBazowyHex);

        menuPlik.add(menuItemWczytaj);
        menuPlik.add(menuItemZapisz);

        menuBar.add(menuNowy);
        menuBar.add(menuPlik);

        setJMenuBar(menuBar);

    }
    private void inicjujGuzikiMenuGornego() {

        menuItemBazowy = new JMenuItem("bazowy_kartezjanski");
        menuItemBazowyHex = new JMenuItem("bazowy_hex");
        menuItemWczytaj = new JMenuItem("wczytaj");
        menuItemZapisz = new JMenuItem("zapisz");

        menuItemZapisz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zapisy.zapisz(interfejs.getSwiat());
            }
        });
        menuItemWczytaj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Swiat world = zapisy.wczytaj();
                interfejs.setSwiat(world);
            }
        });

        menuItemBazowy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                interfejs.setSwiat(Swiat.Baza(Swiat.Typ.Zwykly));

            }

        });


        menuItemBazowyHex.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                interfejs.setSwiat(Swiat.Baza(Swiat.Typ.Hex));

            }
        });
    }
    private void inicjujPanelGlowny(){


        inicjujGuziki();

        JPanel panelGuziki = new JPanel();



        GridLayout layout = new GridLayout(0,2);
        panelGuziki.setLayout(layout);

        panelGuziki.add(tura);




        JSplitPane splitPane = new JSplitPane();

        splitPane.setEnabled(false);
        splitPane.setDividerLocation( DOMYSLNA_WYSOKOSC * 8 / 10);
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
    private void inicjujGuziki() {

        tura = new JButton("nastepna tura");
        //dziennikButton = new JButton("dziennik");


        tura.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                interfejs.nastepnaTura();

            }

        });
    }
}
