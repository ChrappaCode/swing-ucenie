package sk.stuba.fei.uim.oop;

import lombok.Getter;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Logika extends Adapter{

    private final Auto auto;
    @Getter
    private final PanelNaKreslenie panelNaKreslenie;
    @Getter
    private final JLabel pocetLabel;
    @Getter
    private final JLabel farbaLabel;

    private final JSlider slider;

    private int sliderInt;


    private Color color;
    private final JFrame okno;

    public Logika(JFrame okno , JSlider slider) {

        this.auto = new Auto();
        this.slider = slider;
        this.sliderInt = slider.getValue();
        this.panelNaKreslenie = new PanelNaKreslenie(auto);
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

    private Line createLine(int angle) {
        return new Line(auto.getX() + 104, 130, sliderInt, angle, this.color);
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
        else if (e.getSource() instanceof JComboBox) {
            int x = (int) ((JComboBox) e.getSource()).getSelectedItem();
            okno.setSize(x,x);
            slider.setValue(x);
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

    @Override
    public void stateChanged(ChangeEvent e) {

        System.out.println(((JSlider) e.getSource()).getValue());
        sliderInt = ((JSlider) e.getSource()).getValue();


    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            panelNaKreslenie.pridajCiaru(createLine(180));
            auto.brmBrm(sliderInt);
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            panelNaKreslenie.pridajCiaru(createLine(180));
            auto.spiatocka(sliderInt);
        }
        panelNaKreslenie.repaint();

    }

}


