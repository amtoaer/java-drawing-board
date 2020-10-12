import java.awt.Graphics;

public class MultiShape extends Shape {
    public MultiShape(int x1, int y1, int x2, int y2) {
        super(x1, y1, x2, y2);
    }

    public void draw(Graphics p) {
        p.setColor(this.selectedColor);
        switch (this.operation) {
            case "铅笔":
            case "直线":
                p.drawLine(x1, y1, x2, y2);
                break;
            case "矩形":
                p.drawRect(x1, y1, Math.abs(x1 - x2), Math.abs(y1 - y2));
            case "圆":
                p.drawOval(x1, y1, Math.abs(x1 - x2), Math.abs(y1 - y2));
        }
    }
}
