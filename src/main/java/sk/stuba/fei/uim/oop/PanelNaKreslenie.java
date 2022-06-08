package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PanelNaKreslenie extends JPanel {

    private List<Objekt> objekty;

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


}
