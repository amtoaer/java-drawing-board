import java.awt.event.*;
import javax.swing.event.*;

import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import java.util.Deque;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

// 该类实现了鼠标事件和按钮点击事件的监听
public class EventListener extends MouseInputAdapter implements ActionListener, KeyListener {
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
    private final List<Shape> history = new ArrayList<>();
    private final Deque<Integer> stack = new LinkedList<>();

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
        } else {
            // 点击的是操作
            operation = instance.getText();
        }
        Drawboard.getInstance().requestFocus();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        x1 = e.getX();
        y1 = e.getY();
        x2 = e.getX();
        y2 = e.getY();
        Shape tmp = new MultiShape(x1, y1, x2, y2);
        history.add(tmp);
        tmp.draw(pen);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        x2 = e.getX();
        y2 = e.getY();
        // 撤销上一张图
        revert();
        // 增加新的图
        Shape tmp = new MultiShape(x1, y1, x2, y2);
        history.add(tmp);
        tmp.draw(pen);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        x2 = e.getX();
        y2 = e.getY();
        // 撤销上一张图
        revert();
        // 增加新的图
        Shape tmp = new MultiShape(x1, y1, x2, y2);
        history.add(tmp);
        tmp.draw(pen);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Ctrl + Z ，触发撤销操作
        if (stack.size() >= 1 && stack.peek() == 17 && e.getKeyCode() == 90) {
            revert();
        }
        stack.push(e.getKeyCode());
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        stack.pop();
    }

    public void revert() {
        if (history.size() >= 1) {
            // 移除最后一次绘图
            history.remove(history.size() - 1);
            // 重新绘制
            Drawboard.getInstance().repaint();
        }
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

    public List<Shape> getHistory() {
        return this.history;
    }
}
