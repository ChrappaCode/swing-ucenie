package sk.stuba.fei.uim.oop;

import lombok.Getter;

import java.awt.*;

@Getter
public class Auto {

    private int x;

    public void draw(Graphics g) {

        g.setColor(Color.black);
        g.fillRect(100 + x,100,150,50);
        g.fillOval(110 + x,140,30,30);
        g.fillOval(210 + x,140,30,30);
        g.fillOval(135 + x,70,80,80);

    }

    public void brmBrm(int x){

        this.x += x;

    }
    public void spiatocka(int x){

        this.x -= x;

    }

}
