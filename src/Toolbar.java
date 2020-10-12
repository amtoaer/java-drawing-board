import javax.swing.JButton;
import javax.swing.JPanel;

public class Toolbar extends JPanel {
    static final long serialVersionUID = 12345;

    public Toolbar() {
        EventListener el = EventListener.GetInstance();
        String[] shapeArray = { "铅笔", "直线", "矩形", "圆", "橡皮擦" };
        for (String item : shapeArray) {
            JButton tmp = new JButton(item);
            tmp.addActionListener(el);
            this.add(tmp);
        }
        this.add(new Colorlist());
    }
}