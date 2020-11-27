import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

// 该类用于构建工具栏
public class Toolbar extends JPanel {
    // 单例模式
    private static Toolbar tb;
    static final long serialVersionUID = 12345;
    private static JTextField jtf1 = new JTextField("在此输入文本内容", 20);

    private Toolbar() {
        JPanel northPanel = new JPanel();
        JPanel southPanel = new JPanel();
        this.setLayout(new BorderLayout());

        EventListener el = EventListener.GetInstance();
        String[] shapeArray = { "铅笔", "直线", "矩形", "圆", "文本", "橡皮擦" };
        // 添加所有的按钮并添加按钮点击事件监听
        for (String item : shapeArray) {
            JButton tmp = new JButton(item);
            tmp.addActionListener(el);
            northPanel.add(tmp);
        }
        // 添加线条粗细调整
        northPanel.add(new Linewidth());
        // 添加颜色列表
        northPanel.add(new Colorlist());
        // 添加文本框
        southPanel.add(jtf1);
        // Toolbar布局
        this.add(northPanel, BorderLayout.NORTH);
        this.add(southPanel, BorderLayout.SOUTH);

    }

    // 获取实例的静态方法
    public static Toolbar GetInstance() {
        if (tb == null) {
            tb = new Toolbar();
        }
        return tb;
    }

    // 获取文本
    public static String getTextString() {
        return jtf1.getText();
    }
}