import java.awt.BorderLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

// 该类用于构建工具栏
public class Toolbar extends JPanel {
    // 单例模式
    private static Toolbar tb;
    static final long serialVersionUID = 12345;

    private JTextField jtf1 = new JTextField("在此输入文本内容", 20);
    // “前景色”单选框
    JRadioButton fore;

    private Toolbar() {
        JPanel northPanel = new JPanel();
        JPanel southPanel = new JPanel();
        this.setLayout(new BorderLayout());

        EventListener el = EventListener.getInstance();
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
        // 用于判断设置前景色还是设置背景色
        ButtonGroup bg = new ButtonGroup();
        fore = new JRadioButton("前景色", true);
        JRadioButton back = new JRadioButton("背景色");
        // 加入到同一个按钮组
        bg.add(fore);
        bg.add(back);
        // 加入到toolbar的第二行
        southPanel.add(fore);
        southPanel.add(back);
        // 添加文本框
        southPanel.add(jtf1);
        // Toolbar布局
        this.add(northPanel, BorderLayout.NORTH);
        this.add(southPanel, BorderLayout.SOUTH);
    }

    // 获取实例的静态方法
    public static Toolbar getInstance() {
        if (tb == null) {
            tb = new Toolbar();
        }
        return tb;
    }

    // 获取文本
    public String getTextString() {
        return this.jtf1.getText();
    }

    // 当前选中的是否是前景色
    public boolean isForebackgroundSelected() {
        return this.fore.isSelected();
    }
}