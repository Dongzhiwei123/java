package ThreadPool;

public class Test {
    public static void main(String[] args) {
        System.out.println(method1());// 30
        System.out.println(method2());// 20
    }

    public static int method1() {
        int num = 10;
        try {
            System.out.println(1 / 0);
        } catch (ArithmeticException e) {
            num = 20;
            return num;
        } finally {
            num = 30;
            return num;
        }
    }

    public static int method2() {
        int num = 10;
        try {
            System.out.println(1 / 0);
        } catch (ArithmeticException e) {
            num = 20;
            // catch中的return会做2件事:1.先记录要返回的值,然后执行finally中的代码,2.最后把记录的值返回
            return num;// 记录要返回的值:20
        } finally {
            num = 30;
        }
        return num;
    }
}
