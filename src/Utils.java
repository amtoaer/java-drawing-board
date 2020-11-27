import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

class Utils {
    // 字符串到字体的映射（本来考虑直接在下拉框中存字体，但字体类的toString()返回内容过长，故使用映射实现）
    static Map<String, Font> map = new HashMap<>();

    public static List<String> getSystemFonts() {
        Font[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts();
        List<Font> fontList = Arrays.asList(fonts);
        // 按照fontfamily进行去重
        Set<Font> set = new TreeSet<>((first, second) -> first.getFamily().compareTo(second.getFamily()));
        set.addAll(fontList);
        // 使用映射
        for (var item : set) {
            map.put(item.getFamily(), item);
        }
        // 返回字体的family
        return set.stream().map(item -> item.getFamily()).collect(Collectors.toList());
    }

    public static String getHelpMessage() {
        // 帮助信息
        return """
                1、快捷键使用说明
                CtrlZ 撤销上一个操作；
                CtrlQ 将当前画板清空；
                CtrlO 打开图片文件，文件扩展名为.jpg或.png；
                CtrlS 保存图片文件，文件扩展名为.jpg或.png;
                CtrlH 帮助。
                2、画板功能使用说明
                1）新建一个图形文件；
                2）打开、保存一个图形文件->分别通过快捷键“CtrlO”、“CtrlS”实现；
                3）绘制直线、矩形、圆等图形->分别通过点击按钮“直线”、“矩形”、“圆”，在画板中点击鼠标并按住拖动实现；
                4）实现铅笔功能->通过点击按钮“铅笔”，在画板中点击鼠标并按住拖动实现实时绘制；
                5）实现橡皮擦功能->通过点击按钮“橡皮擦”，在画板中点击鼠标并按住拖动实现；
                6）实现添加文字功能->通过在文本框中输入内容，点击“文本”按钮，在画板中点击鼠标实现；
                7）实现撤销操作功能->通过快捷键“CtrlZ”实现；
                8）修改线条粗细、橡皮大小->均通过拖动“线条粗细”滑块实现；
                9）修改线条、文字颜色->通过直接选中颜色按钮或选中最后一个按钮在选色板中自定义颜色；
                10）设置文字字体、字号->分别通过、字体下拉框、字号下拉框选择实现；
                11）修改画板前景色、背景色->通过点击“前景色”或“背景色按钮”，选中颜色按钮实现；
                12）显示操作使用说明->通过点击“帮助”按钮或快捷键“CtrlH”实现。
                3、注意事项
                1）最后一个颜色按钮是自定义颜色，点击弹出自定义颜色对话框；
                2）如遇快捷键失效问题，可尝试点击绘图区域使焦点返回。
                """;
    }
}
