package sk.stuba.fei.uim.oop;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class GUI extends JFrame {

    public GUI(){

        super("Ucim sa swing");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(600,600);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        try {
            setIconImage(ImageIO.read(Objects.requireNonNull(GUI.class.getResourceAsStream("/srdiecko.png"))));
        }
        catch (IOException e) {
            System.out.println("Obrazok sa nepodarilo načítať");
            System.exit(0);
        }

        JPanel menu = new JPanel();
        Logika logika = new Logika();

        JButton tlacidlo = new JButton("VYPNI");
        tlacidlo.setBackground(new Color(211, 153, 238));
        tlacidlo.setFont((new Font("Serif",Font.BOLD, 30)));
        tlacidlo.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
        tlacidlo.setFocusable(false);
        tlacidlo.addActionListener(logika);

        JButton tlacidlo2 = new JButton("FARBA");
        tlacidlo2.setBackground(new Color(211, 153, 238));
        tlacidlo2.setFont((new Font("Serif",Font.BOLD, 30)));
        tlacidlo2.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
        tlacidlo2.setFocusable(false);
        tlacidlo2.addActionListener(logika);

        menu.setLayout(new GridLayout(1,1));

        menu.add(tlacidlo);
        menu.add(tlacidlo2);

        this.add(menu,BorderLayout.PAGE_END);

        this.setFocusable(true);
        this.setVisible(true);

    }

}
