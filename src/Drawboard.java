import javax.swing.JPanel;

import javax.swing.JFrame;
import java.awt.*;

// 画图区域（窗口也是在该类中创建的）
public class Drawboard extends JPanel {
    static final long serialVersionUID = 1357997531;
    // 同样使用单例模式
    private static Drawboard db;

    // 获得实例的静态函数
    public static Drawboard getInstance() {
        if (db == null) {
            db = new Drawboard();
        }
        return db;
    }

    private Drawboard() {
        // 为画图区域添加背景色
        this.setBackground(Color.WHITE);
        // 绘制窗口，设置布局，将工具栏、绘图区域（this）加入到window中并显示
        this.drawUI();
        // 为绘图区域添加鼠标/键盘监听
        this.bindEvent();
    }

    private void drawUI() {
        JFrame window = new JFrame("画板");
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(new BorderLayout());
        window.add(new Toolbar(), BorderLayout.NORTH);
        window.add(this, BorderLayout.CENTER);
        window.setVisible(true);
    }

    private void bindEvent() {
        // 得到监听器实例
        EventListener el = EventListener.GetInstance();
        // 添加鼠标/鼠标移动/键盘的监听器
        // （因为el实现了鼠标MouseListener、鼠标移动MouseMotionListener、键盘KeyListener的接口，所以可以这样写）
        this.addMouseListener(el);
        this.addMouseMotionListener(el);
        this.addKeyListener(el);
        // 将绘图区域的“笔”传给监听器，在监听器内进行绘制
        el.setPen(this.getGraphics());
    }

    public void paint(Graphics p) {
        // 该函数是窗口大小变化时自动调用的函数，其中的p默认是this.getGraphics()（也就是绘图区域的画笔）
        // 为父类重新绘制（即添加背景色）
        super.paint(p);
        EventListener el = EventListener.GetInstance();
        // 遍历绘图历史，绘制该图形
        for (Shape item : el.getHistory()) {
            item.draw(p);
        }
    }

}
