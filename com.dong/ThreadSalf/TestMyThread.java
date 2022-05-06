package ThreadSalf;


public class TestMyThread {
    public static void main(String[] args) throws InterruptedException {
        MyClass myClass = new MyClass();
        MyClass myClass2 = new MyClass();

        Thread t1 = new MyThred(myClass);
        t1.setName("T1");
        Thread t2 = new MyThred(myClass2);
        t2.setName("T2");
        t1.start();
        t2.start();



    }
}

class MyThred extends Thread {
    MyClass myClass;

    public MyThred() {
    }


    public MyThred(MyClass myClass) {
        this.myClass = myClass;
    }

    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("T1")) {
            try {
                myClass.doSome();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            myClass.doOther();
        }
    }
}


class MyClass {
    public synchronized  static  void doSome() throws InterruptedException {
        System.out.println("doSome begin");
        try {
            Thread.sleep(1000 * 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("doSome end");
    }

    public synchronized static void doOther() {
        System.out.println("doOther begin");
        System.out.println("doOther end");
    }
}

