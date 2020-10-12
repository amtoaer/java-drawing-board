import java.awt.Graphics;

public class MultiShape extends Shape {
    public MultiShape(int x1, int y1, int x2, int y2) {
        super(x1, y1, x2, y2);
    }

    public void draw(Graphics p) {
        p.setColor(this.selectedColor);
        // 始终保证x1<=x2,y1<=y2
        if (x1 > x2) {
            int tmp = x1;
            x1 = x2;
            x2 = tmp;
        }
        if (y1 > y2) {
            int tmp = y1;
            y1 = y2;
            y2 = tmp;
        }
        switch (this.operation) {
            case "铅笔":
            case "直线":
                p.drawLine(x1, y1, x2, y2);
                break;
            case "矩形":
                p.drawRect(x1, y1, x2 - x1, y2 - y1);
            case "圆":
                p.drawOval(x1, y1, x2 - x1, y2 - y1);
        }
    }
}
