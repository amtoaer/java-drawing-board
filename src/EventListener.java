import java.awt.event.*;
import javax.swing.event.*;

import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import java.util.Deque;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

// 该类实现了鼠标事件、键盘事件和按钮点击事件的监听
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
    // 保存实时按键的栈
    private final Deque<Integer> stack = new LinkedList<>();

    private EventListener() {
        // 默认画笔为黑色，选中操作为铅笔
        selectedColor = Color.BLACK;
        operation = "铅笔";
    }

    // 获取实例的静态方法
    public static EventListener GetInstance() {
        if (i == null) {
            i = new EventListener();
        }
        return i;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton instance = (JButton) e.getSource();
        // 点击的是颜色（因为颜色按钮没有文字）
        if ("".equals(e.getActionCommand())) {
            selectedColor = instance.getBackground();
        } else {
            // 点击的是操作
            operation = instance.getText();
        }
        // 将焦点还给绘图区域（没有焦点没有办法响应键盘事件）
        Drawboard.getInstance().requestFocus();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // 按下鼠标时调用的函数
        x1 = e.getX();
        y1 = e.getY();
        x2 = e.getX();
        y2 = e.getY();
        // 原地画点，为了和mouseDragged协作实现动态拖拽的效果
        addShape();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        x2 = e.getX();
        y2 = e.getY();
        // 撤销上一张图
        revert();
        // 添加新的图
        addShape();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        x2 = e.getX();
        y2 = e.getY();
        // 撤销上一张图
        revert();
        // 增加新的图
        addShape();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Ctrl + Z ，触发撤销操作
        if (stack.size() >= 1 && stack.peek() == 17 && e.getKeyCode() == 90) {
            revert();
        }
        // 将按键码压栈
        stack.push(e.getKeyCode());
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // 松开按键则弹栈
        stack.pop();
    }

    public void revert() {
        if (history.size() >= 1) {
            // 移除最后一次绘图
            history.remove(history.size() - 1);
            // 重新绘制（repaint实质调用的是paint()函数）
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

    private void addShape() {
        // 添加新图
        Shape tmp = new MultiShape(x1, y1, x2, y2);
        // 加入历史
        history.add(tmp);
        // 用pen将tmp画在图上
        tmp.draw(pen);
    }
}
