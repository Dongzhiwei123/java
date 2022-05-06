package JieKou;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class Test02_冲突 {
    public static void main(String[] args) {
              System.out.println(C.NUM2);
    }
}
interface A{
    public static final int NUM1 = 10;
}
interface B{
    public static final int NUM1 = 20;
    public static final int NUM2 = 30;
}
interface C extends A,B{

}


interface A1{
    void method();
}
interface B1{
    void method();
}
interface C1 extends A1,B1{
}
class Imp implements C1{
    @Override
    public void method() {
        System.out.println("实现接口的抽象方法");
    }
}

 class Test1 {
     public static void main(String[] args) {
        /*
            公有抽象方法的冲突:子接口只会继承一个有冲突的抽象方法
         */
         B1 imp = new Imp();
         imp.method();
     }
 }


  class Fu{
      void method(){
          System.out.println("fu11111");
      };
}
interface A11{
     void method();
}
class Zi extends Fu implements A11{
    @Override
    public void method() {
        System.out.println("Zi 重写有冲突的抽象方法");
    }
}
 class Test {
    public static void main(String[] args) {
        /*
            公有抽象方法的冲突:子类必须重写一次有冲突的抽象方法
         */
        Fu zi = new Zi();
        zi.method();
    }
}

class Test111{
    public static void main(String[] args) throws ParseException {
     Calendar calendar=Calendar.getInstance();
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH));
        System.out.println(calendar);
         int[] arr1 = {1,2,3,4,5,6,7,8};
        int[] arr2 = {10,20,30,40,50,60,70,80};
        // 需求:把arr1中的3,4,5,6,7元素拷贝到arr2数组中,使得arr2数组变成{10,3,4,5,6,7,70,80};
        System.arraycopy(arr1,2,arr2,1,5);
        System.out.println(Arrays.toString(arr2));
        String s="111";
        String b="111";
        System.out.println(s==b);

        SimpleDateFormat sd=new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        Date parse = sd.parse("2022:02:01 01:01:01");
        String format = sd.format(new Date());
        System.out.println(parse+format);
        int i = Integer.parseInt(s);
    }
}
















