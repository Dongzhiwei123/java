package StreamLiu;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class Test01_获取流的方式 {
    public static void main(String[] args) {
        //根据Collection获取流

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "java");
        map.put(2, "php");
        map.put(3, "c");
        map.put(4, "c++");
        map.put(5, "Python");
        Set<Integer> integers = map.keySet();
        Stream<Integer> stream = integers.stream();
        Stream<Map.Entry<Integer, String>> stream1 = map.entrySet().stream();
        Stream<String> stream2 = map.values().stream();
        //根据数组获取流
        Stream<Integer> integerStream = Stream.of(1, 2, 4, 5, 6);
        integerStream.filter((Integer i)->{ return  i>0;}).forEach((Integer i)->{
            System.out.println(i);
        });

        Stream<String> stream11 = Stream.of("10", "20", "30", "40");
        /*
            map方法:
                <R> Stream<R> map(Function<? super T, ? extends R> mapper);
                参数Function<T, R>: 函数式接口,抽象方法 R apply(T t);
                Function<T, R>其实就是一个类型转换接口(T和R的类型可以一致,也可以不一致)
         */
        stream11.map((String s)->{ return  Integer.valueOf(s);}).forEach((s)->{
            System.out.println(s);
        });

          // 获取流
        Stream<String> stream111 = Stream.of("10", "20", "30", "40");

        // 获取Stream流
        Stream<String> stream21 = Stream.of("张三丰", "张无忌", "灭绝师太", "周芷若", "张翠山", "殷素素");
        Stream<String> concat = Stream.concat(stream21, stream111);
        concat.forEach(s -> System.out.println(s));


    }

}
