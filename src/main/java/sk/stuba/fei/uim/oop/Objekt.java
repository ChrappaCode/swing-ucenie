package sk.stuba.fei.uim.oop;

import java.awt.*;

public class Objekt {

    private int x;
    private int y;

    public Objekt(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g) {

        g.setColor(Color.GREEN);
        g.fillRect(x,y,60,60);

    }



}
