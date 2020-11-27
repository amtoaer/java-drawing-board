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
}