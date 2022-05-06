package JiChenng;

public class Test_继承 {
    public static void main(String[] args) {
        Zi zi =new Zi();
        System.out.println(zi.money);
    }
}

class Fu {
    static int i;
    private int num = 100;//私有成员，只能在父类内部使用。
    int money = 100;

    Fu() {
    }

    Fu(String name, int age) {
    }
    private void method() {
        System.out.println("私有成员方法");
    }

    public void method2() {
        System.out.println("Fu 类中的成员方法method");
    }
}

class Zi extends Fu {
        int money = 200;
}
