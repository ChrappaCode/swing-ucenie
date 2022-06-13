package sk.stuba.fei.uim.oop.objekty;

import java.awt.*;

public class Kurzor {

    private int x;
    private int y;

    public Kurzor(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g) {

        g.setColor(Color.lightGray);
        g.fillRect(x,y,60,60);

    }

    public void pohyb(int x , int y){

        this.x = x;
        this.y = y;

    }

}
