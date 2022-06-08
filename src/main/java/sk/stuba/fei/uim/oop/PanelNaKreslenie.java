package sk.stuba.fei.uim.oop;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class PanelNaKreslenie extends JPanel {

    @Getter
    private List<Objekt> objekty;
    private Objekt kocka;

    public PanelNaKreslenie() {
        super();
        setBackground(Color.cyan);
        this.objekty = new ArrayList<>();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        objekty.forEach(l -> l.draw(g));

    }

    public void pridajKocku(MouseEvent e, Color c) {
        this.kocka = new Objekt(e.getX() - 35, e.getY() - 60, c);
        this.objekty.add(kocka);
        this.repaint();
    }


}
