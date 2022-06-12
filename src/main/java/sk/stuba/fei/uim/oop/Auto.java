package sk.stuba.fei.uim.oop;

import lombok.Getter;

import java.awt.*;

@Getter
public class Auto {

    private int x;
    private int y;

    public Auto(){
        this.x = 0;
        this.y = 0;
    }

    public void draw(Graphics g) {

        g.setColor(Color.black);
        g.fillRect(100 + x,100 + y,150,50);
        g.fillRect(100 + x,40 + y,70,70);
        g.fillOval(110 + x,140 + y,30,30);
        g.fillOval(210 + x,140 + y,30,30);
        g.fillOval(135 + x,70 + y,80,80);

    }

    public void brmBrm(int x){

        this.x += x;

    }
    public void dole(int x){

        this.y += x;

    }
    public void hore(int x){

        this.y -= x;

    }
    public void spiatocka(int x){

        this.x -= x;

    }

}
