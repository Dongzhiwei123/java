package DamenTask;

import java.util.ArrayList;
import java.util.List;

public class TaskWaitTest {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        Thread t1 = new Thread(new Procuder(list));
        t1.setName("procuder");
        Thread t2 = new Thread(new Consumer(list));
        t2.setName("consumer");

        t1.start();
        t2.start();
    }
}

class Procuder implements Runnable {
    List<Object> list;

    Procuder(List list) {
        this.list = list;
    }
    //     System.out.println("生产线程" + Thread.currentThread().getName() + "生产--->" + o);

    @Override
    public void run() {
        while (true) {
            synchronized (list) {
                if (list.size() > 0) {
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    list.notify();
                    Object o = new Object();
                    list.add(o);
                    System.out.println("生产线程" + Thread.currentThread().getName() + "生产--->" + o);
                }
            }
        }
    }
}

class Consumer implements Runnable {
    List<Object> list;

    Consumer(List list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (list) {
                if (list.size() == 0) {
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    list.notify();
                    Object remove = list.remove(0);
                    System.out.println("消费线程" + Thread.currentThread().getName() + "消费--->" + remove);

                }
            }
        }
    }
}
