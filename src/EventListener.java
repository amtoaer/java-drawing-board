import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import java.util.List;
import java.util.ArrayList;

// 该类实现了鼠标事件和按钮点击事件的监听
public class EventListener extends MouseInputAdapter implements ActionListener {
    // 使用单例模式
    private static EventListener i;
    // 点击点和落点的坐标
    private int x1, x2, y1, y2;
    // 当前选中的颜色
    private Color selectedColor;
    // 当前使用的操作
    private String operation;
    // 画笔
    private Graphics pen;
    // 所有画过的图
    private List<Shape> history = new ArrayList<>();

    private EventListener() {
        selectedColor = Color.BLACK;
        operation = "铅笔";
    }

    public static EventListener GetInstance() {
        if (i == null) {
            i = new EventListener();
        }
        return i;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton instance = (JButton) e.getSource();
        // 点击的是颜色
        if ("".equals(e.getActionCommand())) {
            selectedColor = instance.getBackground();
            System.out.println(selectedColor);
        } else {
            // 点击的是操作
            operation = instance.getText();
            System.out.println(operation);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        x1 = e.getX();
        y1 = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        x2 = e.getX();
        y2 = e.getY();
        Shape tmp = new MultiShape(x1, y1, x2, y2);
        history.add(tmp);
        tmp.draw(pen);
    }

    public Color getSelectedColor() {
        return this.selectedColor;
    }

    public String getOperation() {
        return this.operation;
    }

    public void setPen(Graphics pen) {
        this.pen = pen;
    }
}
