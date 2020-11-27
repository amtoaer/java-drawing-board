import java.awt.BorderLayout;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.Font;

// 该类用于构建工具栏
public class Toolbar extends JPanel {
    // 单例模式
    private static Toolbar tb;
    static final long serialVersionUID = 12345;

    // 文本输入文本框
    private JTextField jtf1 = new JTextField("Input Content Here", 20);
    // “前景色”单选框
    JRadioButton fore;
    // 字体选择器
    JComboBox<String> fontChooser = new JComboBox<>();
    // 字号选择器
    JComboBox<Integer> sizeChooser = new JComboBox<>();

    private Toolbar() {
        JPanel northPanel = new JPanel();
        JPanel southPanel = new JPanel();
        this.setLayout(new BorderLayout());

        EventListener el = EventListener.getInstance();
        String[] shapeArray = { "铅笔", "直线", "矩形", "圆", "文本", "橡皮擦", "帮助" };
        // 添加所有的按钮并添加按钮点击事件监听
        for (String item : shapeArray) {
            JButton tmp = new JButton(item);
            tmp.addActionListener(el);
            northPanel.add(tmp);
        }
        // 添加颜色列表
        northPanel.add(new Colorlist());
        // 用于判断设置前景色还是设置背景色
        ButtonGroup bg = new ButtonGroup();
        fore = new JRadioButton("前景色", true);
        JRadioButton back = new JRadioButton("背景色");
        // 加入到同一个按钮组
        bg.add(fore);
        bg.add(back);
        // 添加单选框
        northPanel.add(fore);
        northPanel.add(back);
        // 添加线条粗细调整到toolbar的第二行
        southPanel.add(new Linewidth());
        // 添加字体选择器到toolbar的第二行
        setComboBox(Utils.getSystemFonts());
        southPanel.add(fontChooser);
        // 添加字号选择器到toolbar的第二行
        for (int i = 9; i <= 72; i++) {
            sizeChooser.addItem(Integer.valueOf(i));
        }
        sizeChooser.setSelectedIndex(7);
        southPanel.add(sizeChooser);
        // 添加文本框到toolbar的第二行
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

    public void setComboBox(List<String> list) {
        for (var item : list) {
            this.fontChooser.addItem(item);
        }
    }

    public Font getSelectedFont() {
        return Utils.map.get(this.fontChooser.getSelectedItem());
    }

    public int getSelectedSize() {
        return (Integer) this.sizeChooser.getSelectedItem();
    }
}
