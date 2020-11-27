import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

// 调整线宽
public class Linewidth extends JPanel {
    private static final long serialVersionUID = 15100151;

    public Linewidth() {
        this.add(new JLabel("线条粗细"));
        JSlider slider = new JSlider(1, 9, 1);
        slider.setMajorTickSpacing(4);
        slider.setMinorTickSpacing(1);
        slider.setPaintTicks(true);
        EventListener el = EventListener.getInstance();
        slider.addChangeListener(el);
        this.add(slider);
    }
}
