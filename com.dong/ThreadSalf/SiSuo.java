package ThreadSalf;

public class SiSuo {
    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();
        Thread t1 = new Thread01(o1, o2);
        t1.setName("t1");
        Thread t2 = new Thread02(o1, o2);
        t1.start();
        t2.setName("t2");
        t2.start();
        System.out.println(1111);

    }
}

class Thread01 extends Thread {
    Object o1;
    Object o2;

    Thread01(Object o1, Object o2) {
        this.o1 = o1;
        this.o2 = o2;
    }

    @Override
    public void run() {
        synchronized (o1) {
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o2) {
            }
        }
    }
}

class Thread02 extends Thread {
    Object o1;
    Object o2;

    Thread02(Object o1, Object o2) {
        this.o1 = o1;
        this.o2 = o2;
    }

    @Override
    public void run() {
        synchronized (o2) {
            try {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o1) {
            }
        }
    }
}

class SiSuo02 {
    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();
        new Thread(() -> {
            while (true) {
                synchronized (o1) {
                    //a 线程走到了这  锁住了o1 b线程获得了cpu 执行权力 锁住了02
                    //俩个线程互相
                    synchronized (o2) {
                        System.out.println("thread01");
                    }
                }

            }
        }).start();

        new Thread(() -> {
            while (true) {
                synchronized (o2) {
                    //b线程获得了cpu 执行权力
                    synchronized (o1) {
                        System.out.println("thread02");
                    }
                }
            }

        }).start();


    }
}