import java.awt.Graphics;

// 该类可以根据选择操作操作的不同绘制不同种类的图
public class MultiShape extends Shape {
    public MultiShape(int x1, int y1, int x2, int y2) {
        super(x1, y1, x2, y2);
    }

    @Override
    public void draw(Graphics p) {
        p.setColor(this.selectedColor);
        this.innerDraw(p);
    }

    private void swap() {
        // 保证x1<=x2,y1<=y2，在绘制矩形、圆时需要
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
    }

    private void innerDraw(Graphics p) {
        switch (this.operation) {
            case "铅笔":
            case "直线":
                p.drawLine(x1, y1, x2, y2);
                break;
            case "矩形":
                this.swap();
                p.drawRect(x1, y1, x2 - x1, y2 - y1);
                break;
            case "圆":
                this.swap();
                p.drawOval(x1, y1, x2 - x1, y2 - y1);
                break;
        }
    }
}
