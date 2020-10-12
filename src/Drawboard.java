import javax.swing.JPanel;

import javax.swing.JFrame;
import java.awt.*;

public class Drawboard extends JPanel {
    static final long serialVersionUID = 1357997531;
    private final JFrame window = new JFrame();

    public Drawboard() {
        this.setBackground(Color.WHITE);
        this.drawUI();
        this.bindEvent();
    }

    private void drawUI() {
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(new BorderLayout());
        window.add(new Toolbar(), BorderLayout.NORTH);
        window.add(this, BorderLayout.CENTER);
        window.setVisible(true);
    }

    private void bindEvent() {
        EventListener el = EventListener.GetInstance();
        this.addMouseListener(el);
        el.setPen(this.getGraphics());
    }
}
