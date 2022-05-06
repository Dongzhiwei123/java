package DamenTask;


public class TaskWaitTest2 {
    public static void main(String[] args) {
        Integer i = 0;
        Thread t1 = new Thread(new Procuder2(i));
        t1.setName("t1");
        t1.start();
        Thread t2 = new Thread(new Consumer2(i));
        t2.setName("t2");
        t2.start();
    }
}

class Procuder2 implements Runnable {
    Integer i;

    Procuder2(Integer i) {
        this.i = i;
    }

    //                    System.out.println("偶数线程" + Thread.currentThread().getName() + "--->" + i);
    //                    System.out.println("奇数线程" + Thread.currentThread().getName() + "--->" + i);
    @Override
    public void run() {

        while (true) {
            synchronized (i) {
                if (i % 2 == 0) {
                    try {
                        i.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    i.notify();
                    i=i+1;
                    System.out.println("奇数线程" + Thread.currentThread().getName() + "--->" + i);
                }

            }
        }
    }
}

class Consumer2 implements Runnable {
    Integer i;

    Consumer2(Integer i) {
        this.i = i;
    }

    @Override
    public void run() {

        while (true) {
            synchronized (i) {
                if (i % 2 != 0) {//奇数
                      try {
                        i.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    i.notify();
                    i=i+1;
                    System.out.println("偶数线程" + Thread.currentThread().getName() + "--->" + i);
                }
            }
        }
    }
}

class test {
    public static void main(String[] args) {
        int i = 0;
        while (true) {
            i = i++;
        }
    }
}