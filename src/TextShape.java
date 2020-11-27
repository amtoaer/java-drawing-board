import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Font;

// 该类可以根据选择操作操作的不同绘制不同种类的图
public class TextShape extends Shape {
    private String content;
    private Font font;
    private int size;

    public TextShape(int x1, int y1) {
        super(x1, y1);
        Toolbar toolbar = Toolbar.getInstance();
        this.content = toolbar.getTextString();
        this.font = toolbar.getSelectedFont();
        this.size = toolbar.getSelectedSize();
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D p = (Graphics2D) g;
        p.setColor(this.selectedColor);
        p.setFont(this.font.deriveFont((float) size));
        p.drawString(this.content, x1, y1);
    }
}