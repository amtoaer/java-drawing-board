import javax.swing.*;
import java.awt.*;

// 颜色选择列表
public class Colorlist extends JPanel {
    static final long serialVersionUID = 1471001741;

    public Colorlist() {
        // 得到监听器实例
        EventListener el = EventListener.getInstance();
        // 为列表使用二行四列的栅格布局
        this.setLayout(new GridLayout(2, 4, 2, 2));
        // 通过颜色数组快速构建前七个按钮
        Color[] colorArray = { Color.BLACK, Color.BLUE, Color.YELLOW, Color.GREEN, Color.PINK, Color.RED, Color.CYAN };
        for (Color item : colorArray) {
            JButton tmp = new JButton();
            tmp.setBackground(item);
            // 为该按钮添加点击监听，详见EventListener->actionPerformed
            tmp.addActionListener(el);
            this.add(tmp);
        }
        // 最后一个按钮是自定义颜色
        JButton customColor = new JButton();
        customColor.setBackground(Color.WHITE);
        // 为该按钮加入与其它按钮相同的监听
        customColor.addActionListener(el);
        // 点击弹出颜色对话框，将选中颜色设置为背景色
        // 注意：经过测试，多个ActionListener的情况下会优先执行后添加的
        customColor.addActionListener(e -> {
            Color selectedColor = JColorChooser.showDialog(null, "自定义颜色", Color.BLACK);
            if (selectedColor == null) {
                selectedColor = Color.WHITE;
            }
            customColor.setBackground(selectedColor);
        });
        this.add(customColor);
    }
}
