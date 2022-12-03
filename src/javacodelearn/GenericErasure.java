package javacodelearn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author foanxi
 */
public class GenericErasure {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List list2 = list;
        // 集合内部存放String类型
        String s = list.get(0);
        // 集合内部存放Object类型
        String o = (String) list2.get(0);
    }
}
