package FanXing;

import java.util.ArrayList;
import java.util.List;

public class Test05_未知通配符 {
    public static void main(String[] args) {
        List<Object> objects = new ArrayList<>();
        List<String> strings = new ArrayList<>();
        List<Integer> integers = new ArrayList<>();
        List<Number> numbers = new ArrayList<>();
        method1(objects);
        method1(strings);
        method1(integers);
        method1(numbers);

        method12(objects);
        method12(integers);
        method12(numbers);
        method12(integers);
    }
    public static void method1(List list){

    }
    public static void method12(List<?> list){
    }
    /*objects integers numbers */
    public  static  void  method3(List<? super Integer> list){}
    public  static  void  method4(List<? extends Number> list){}

}
