import java.awt.Color;
import java.awt.Graphics;

public class Eraser extends Shape {

    public Eraser(int x1, int y1) {
        super(x1, y1, Color.WHITE);
    }

    @Override
    public void draw(Graphics p) {
        p.setColor(this.selectedColor);
        p.fillOval(x1, y1, 30, 30);
    }
}
