import javax.swing.JButton;
import javax.swing.JPanel;

// 该类用于构建工具栏
public class Toolbar extends JPanel {
    static final long serialVersionUID = 12345;

    public Toolbar() {
        EventListener el = EventListener.GetInstance();
        String[] shapeArray = { "铅笔", "直线", "矩形", "圆", "橡皮擦" };
        // 添加所有的按钮并添加按钮点击事件监听
        for (String item : shapeArray) {
            JButton tmp = new JButton(item);
            tmp.addActionListener(el);
            this.add(tmp);
        }
        // 添加颜色列表
        this.add(new Colorlist());
    }
}