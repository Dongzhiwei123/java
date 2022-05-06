package StreamLiu;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test_流Test {
    public static void main(String[] args) {
        List<String> one = new ArrayList<>();
        List<String> two = new ArrayList<>();
        Collections.addAll(one, "迪丽热巴", "宋远桥", "苏星河", "老子", "庄子", "孙子", "洪七公");
        Collections.addAll(two, "古力娜扎", "张无忌", "张三丰", "赵丽颖", "张二狗", "张天爱", "张三");
                one.stream().filter(s -> s.length() == 3).forEach(s -> System.out.println(s));

       /* //1. 第一个队伍只要名字为3个字的成员姓名；
        one.stream().filter(s -> s.length() == 3).forEach(s -> System.out.println(s));
        //2. 第一个队伍筛选之后只要前3个人；
        one.stream().limit(3).forEach(s -> System.out.println(s));
        //3. 第二个队伍只要姓张的成员姓名；
        two.stream().filter(s -> s.startsWith("张")).forEach(s -> System.out.println(s));
        //4. 第二个队伍筛选之后不要前2个人；
        two.stream().skip(2).forEach(s -> System.out.println(s));*/
        //5. 将两个队伍合并为一个队伍；
        Stream.concat(two.stream(),one.stream()).map((String name)->{
            return new Person(name);
        }).forEach(person -> System.out.println(person.toString()));
        //6. 根据姓名创建`Person`对象；

        //7. 打印整个队伍的Person对象信息。
        List<Person> collect = Stream.concat(two.stream(), one.stream()).map((String name) -> {
            return new Person(name);
        }).collect(Collectors.toList());


    }
}
 class Person {
        public String name;

        public Person(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
