import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;

// 该类可以根据选择操作操作的不同绘制不同种类的图
public class TextShape extends Shape {
    private String content;

    public TextShape(int x1, int y1) {
        super(x1, y1);
        this.content = Toolbar.getTextString();
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D p = (Graphics2D) g;
        p.setColor(this.selectedColor);
        p.setStroke(new BasicStroke(this.width));
        p.drawString(this.content, x1, y1);
    }
}