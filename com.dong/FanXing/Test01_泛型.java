package FanXing;


//使用含有泛型的类: 创建该类对象的时候,确定该类泛型的具体数据类型
//当类中的成员变量或者成员方法的形参类型返回值类型不确定的时候,就可以把该类定义为含有泛型的类
//什么时候定义泛型的类:

import java.util.ArrayList;
import java.util.List;

import static FanXing.MyList.method1;

public class Test01_泛型 {
    public static void main(String[] args) {
        MyList<String> list1 = new MyList<>();
        System.out.println(list1.set(1, "name"));
        System.out.println(method1(100));// 指定泛型的具体数据类型为Integer
        System.out.println(method1("100"));
    }
}

// 成员变量的类型不确定
class MyList<E> {
    E e;

    MyList() {
    }

    public E method(E e) {
        return e;
    }

    public E set(int index, E element) {
        return element;
    }

    // 修饰符 <代表泛型的变量> 返回值类型
    public static <T> String method1(T t) {
        return t + "100";
    }

}


//泛型接口
interface IA<E> {
    abstract void method1(E e);

    default E method2(E e) {
        return e;
    }
}

class Imp1 implements IA<String> {

    @Override
    public void method1(String s) {
        return;
    }

    @Override
    public String method2(String s) {
        return IA.super.method2(s);
    }
}

class Imp2<E> implements IA<E> {
    @Override
    public void method1(E e) {
        System.out.println("实现类 method1");
    }

    @Override
    public E method2(E e) {
        return e;
    }
}

class Test {
    public static void main(String[] args) {
        Imp2<String> stringImp2 = new Imp2<>();
        stringImp2.method1("name");
    }
}

class Test02 {
    public static void main(String[] args) {
        /*
            通配符基本使用:
                泛型的通配符:不知道使用什么类型来接收的时候,此时可以使用?,?表示未知通配符。
                注意: 不能往该集合中存储数据,只能获取数据.
         */
        // 关系:String继承Object,Integer继承Number,Number继承Objec
        ArrayList<Object> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();
        ArrayList<Number> list4 = new ArrayList<>();

        list2.add("itheima");
        method1(list1);
        method1(list2);
        method1(list3);
        method1(list4);

        method2(list1);
        method2(list2);
        method2(list3);
        method2(list4);
     /*   //method1(list1);
        method1(list2);
        //method1(list3);
        //method1(list4);


*/
        // 泛型没有多态
        //ArrayList<Object> list = new ArrayList<String>();// 编译报错
    }

    // 定义一个方法,可以接收以上4个集合
    public static void method1(List list) {
        Object o = list.get(0);
        System.out.println(o);
    }

    public static void method2(List<?> list) {
        Object o = list.get(0);
        System.out.println(o);
    }

  /*  public static void method2(ArrayList<?> list){
        Object obj = list.get(0);
        //list.add("jack");// 编译报错
        System.out.println("obj:"+obj);// itheima
        System.out.println("list:"+list);// [itheima]
    }*/
}




class Test04 {
    public static void main(String[] args) {
        /*
            通配符高级使用----受限泛型:
                上限: <? extends 类名>  只能接收该类类型或者其子类类型
                下限: <? super 类名>   只能接收该类类型或者其父类类型
         */
        // 关系:String继承Object,Integer继承Number,Number继承Objec
        ArrayList<Object> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();
        ArrayList<Number> list4 = new ArrayList<>();

        method1(list1);
        method1(list2);
        method1(list3);
        method1(list4);

        //method2(list1);// 编译报错
        //method2(list2);// 编译报错
        method2(list3);
        method2(list4);


        method3(list1);
        //method3(list2);// 编译报错
        method3(list3);
        method3(list4);
    }
    // 1  Object  2 String 3 Integer 4 Number
    // 定义一个方法,只可以接收以上list3和list4集合
    public static void method2(ArrayList <? extends   Number> list){

    }

    // 定义一个方法,只可以接收以上list3和list4,list1集合
    public static void method3(ArrayList <? super   Integer> list){

    }
      // 1  Object  2 String 3 Integer 4 Number
  // 定义一个方法,可以接收以上4个集合
    public static void method1(ArrayList<?> list){

    }
    // 定义一个方法,可以接收以上4个集合
    public static void method(ArrayList list){

    }
}










