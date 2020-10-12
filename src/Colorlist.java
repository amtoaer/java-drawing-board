import javax.swing.*;
import java.awt.*;

public class Colorlist extends JPanel {
    static final long serialVersionUID = 1471001741;

    public Colorlist() {
        EventListener el = EventListener.GetInstance();
        this.setLayout(new GridLayout(2, 4, 2, 2));
        Color[] colorArray = { Color.BLACK, Color.BLUE, Color.CYAN, Color.GREEN, Color.PINK, Color.RED, Color.CYAN };
        for (Color item : colorArray) {
            JButton tmp = new JButton();
            tmp.setBackground(item);
            tmp.addActionListener(el);
            this.add(tmp);
        }
        JButton customColor = new JButton();
        customColor.setBackground(Color.WHITE);
        customColor.addActionListener(el);
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
