import java.awt.Color;
import java.awt.Graphics;

// 基本图形的抽象类（橡皮擦类和多图形类都从该类继承）
public abstract class Shape {
    protected int x1, y1;
    protected static final EventListener el = EventListener.getInstance();
    protected Color selectedColor;
    protected String operation;
    protected int width;

    public Shape(int x1, int y1) {
        selectedColor = el.getSelectedColor();
        operation = el.getOperation();
        width = el.getWidth();
        this.x1 = x1;
        this.y1 = y1;
    }

    public Shape(int x1, int y1, Color customColor) {
        this(x1, y1);
        selectedColor = customColor;
    }

    public abstract void draw(Graphics p);

    public void refresh() {
    }

}
