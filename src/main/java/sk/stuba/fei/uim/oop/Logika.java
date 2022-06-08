package sk.stuba.fei.uim.oop;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

public class Logika extends Adapter{

    @Getter
    private final PanelNaKreslenie panelNaKreslenie;
    @Getter
    private final JLabel pocetLabel;
    @Getter
    private final JLabel farbaLabel;

    private Color color;
    private final JFrame okno;

    public Logika(JFrame okno) {

        this.panelNaKreslenie = new PanelNaKreslenie();
        this.color = Color.GREEN;
        this.pocetLabel = new JLabel();
        pocetLabel.setFont(new Font("Serif",Font.BOLD, 30));
        pocetLabel.setBorder(BorderFactory.createLineBorder(Color.yellow));
        pocetLabel.setForeground(Color.black);
        this.farbaLabel = new JLabel("Zelena" , SwingConstants.CENTER);
        farbaLabel.setBorder(BorderFactory.createLineBorder(Color.yellow));
        farbaLabel.setFont(new Font("Serif",Font.BOLD, 30));
        farbaLabel.setForeground(color);
        this.okno = okno;
        this.updateLabel();

    }

    private void updateLabel() {
        this.pocetLabel.setText("Počet kociek : " + panelNaKreslenie.getObjekty().size());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(GUI.FARBA)) {
            farbaSet();
        }
        else if (e.getActionCommand().equals(GUI.VYPNI)) {
            okno.dispose();
        }
    }

    private void farbaSet() {
        if (this.color == Color.RED) {
            this.color = Color.GREEN;
            this.farbaLabel.setText("Zelena");
            farbaLabel.setForeground(color);
        } else if (this.color == Color.GREEN) {
            this.color = Color.BLUE;
            this.farbaLabel.setText("Modra");
            farbaLabel.setForeground(color);
        } else {
            this.color = Color.RED;
            this.farbaLabel.setText("Cervena");
            farbaLabel.setForeground(color);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        panelNaKreslenie.pridajKocku(e, color);
        panelNaKreslenie.repaint();
        updateLabel();


    }
}


