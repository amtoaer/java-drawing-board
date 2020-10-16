import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

// 静态方法类
public class Utils {
    public static void savePanelAsImage(Drawboard panel) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setSelectedFile(new File("saved.png"));
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int result = fileChooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            // String.split的参数是正则表达式，为了匹配纯文本的.需要把参数用方括号括起来
            String[] tmp = file.getName().split("[.]");
            if (tmp.length <= 1) {
                JOptionPane.showMessageDialog(null, "保存文件没有拓展名，保存失败...");
                return;
            }
            String extension = tmp[tmp.length - 1];
            // HELP:文档内说imageio支持jpg，但本地测试保存无反应
            if (!extension.equals("png") && !extension.equals("jpg")) {
                JOptionPane.showMessageDialog(null, "拓展名非法（允许使用：png/jpg），保存失败...");
                return;
            }
            Dimension imageSize = panel.getSize();
            BufferedImage image = new BufferedImage(imageSize.width, imageSize.height, BufferedImage.TYPE_INT_ARGB);
            Graphics2D graphics = image.createGraphics();
            panel.paint(graphics);
            graphics.dispose();
            try {
                ImageIO.write(image, extension, file);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // TODO: 从文件中加载图片到Panel（打开文件）
    public static void loadImageToPanel() {
    }
}
