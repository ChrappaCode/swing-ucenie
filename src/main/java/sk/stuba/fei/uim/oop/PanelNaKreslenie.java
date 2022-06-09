package sk.stuba.fei.uim.oop;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class PanelNaKreslenie extends JPanel {

    @Getter
    private final List<Objekt> objekty;
    private final List<Line> lines;
    private Objekt kocka;

    private final Auto auto;

    public PanelNaKreslenie(Auto auto) {
        super();
        this.auto = auto;
        setBackground(Color.cyan);
        this.objekty = new ArrayList<>();
        this.lines = new ArrayList<>();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        objekty.forEach(l -> l.draw(g));
        lines.forEach(l -> l.draw(g));
        auto.draw(g);

    }

    public void pridajCiaru(Line line) {
        this.lines.add(line);
    }

    public void pridajKocku(MouseEvent e, Color color) {
        this.kocka = new Objekt(e.getX() - 35, e.getY() - 60, color);
        this.objekty.add(kocka);
        this.repaint();
    }


}
