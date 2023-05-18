package gui;

import javax.swing.*;
import Additional.Constants;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OknoPoczatkowe extends JFrame {
    private JTextField szerokoscMapy;
    private JTextField wysokoscMapy;
    private JTextField rodzajMapy;
    public OknoPoczatkowe(){
        setPreferredSize(new Dimension(400,200));
        setSize(new Dimension(1000,200));
        setTitle("PODAJ WYMIARY");
        JPanel mainPanel = new JPanel();
        setLayout(new FlowLayout());
        mainPanel.setLayout(new FlowLayout());
        JLabel labelSzerokosc = new JLabel("SZEROKOSC");
        szerokoscMapy = new JTextField(7);
        JLabel labelWysokosc = new JLabel("WYSOKOSC");
        wysokoscMapy = new JTextField(7);
        JLabel labelRodzaj = new JLabel("1-Kartezjanski 2-Hex");
        rodzajMapy = new JTextField(2);
        mainPanel.add(labelSzerokosc);
        mainPanel.add(szerokoscMapy);
        mainPanel.add(labelWysokosc);
        mainPanel.add(wysokoscMapy);
        mainPanel.add(labelRodzaj);
        mainPanel.add(rodzajMapy);
        JButton startButton = new JButton("ROZPOCZNIJ GRE");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int szerokosc = Integer.parseInt(szerokoscMapy.getText());
                int wysokosc = Integer.parseInt(wysokoscMapy.getText());
                int rodzaj = Integer.parseInt(rodzajMapy.getText());
                Gra game = new Gra(Constants.WYSOKOSC_OKNA,Constants.SZEROKOSC_OKNA,szerokosc,wysokosc,rodzaj);
                game.graj();
                dispose();
            }
        });
        add(mainPanel);
        add(startButton);
    }
    public void foo(){
        setVisible(true);
    }
}
