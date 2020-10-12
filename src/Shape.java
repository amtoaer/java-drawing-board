import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape {
    protected int x1, x2, y1, y2;
    private static final EventListener el = EventListener.GetInstance();
    protected Color selectedColor;
    protected String operation;

    public Shape(int x1, int y1, int x2, int y2) {
        selectedColor = el.getSelectedColor();
        operation = el.getOperation();
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    public abstract void draw(Graphics p);

    public abstract void draw(Graphics p, Color customColor);
}
