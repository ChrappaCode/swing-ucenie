package sk.stuba.fei.uim.oop;

import lombok.Getter;

import java.awt.*;

@Getter
public class Objekt {

    private final int x;
    private final int y;
    private final Color color;

    public Objekt(int x, int y , Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public void draw(Graphics g) {

        g.setColor(color);
        g.fillRect(x,y,60,60);

    }


}
