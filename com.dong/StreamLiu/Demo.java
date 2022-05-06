package StreamLiu;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        // 传统方式操作集合:
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "张无忌", "周芷若", "赵敏", "张杰", "张三丰");
        list.stream().filter(e -> e.startsWith("张"))
                .filter(e -> e.length() == 3)
                .forEach(e -> System.out.println(e));

    }
}