package ThreadSalf;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest02 {
    public static void main(String[] args) {
        BaoZi baoZi = new BaoZi();
        Thread laoban = new Thread(new laoban(baoZi));
        laoban.setName("laoban");
        Thread baozi = new Thread(new chihuo(baoZi));
        baozi.setName("baozi");
        laoban.start();
        baozi.start();
    }
}

class BaoZi {
    Lock lock = new ReentrantLock();
    boolean flag = true;
}

class laoban implements Runnable {
    BaoZi baoZi;

    laoban(BaoZi baoZi) {
        this.baoZi = baoZi;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (baoZi.lock) {
                if (baoZi.flag == true) { //有 进入等待
                    try {
                        System.out.println("老板有包子进入等待");
                        baoZi.lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    baoZi.lock.notifyAll();
                    System.out.println("老板没包子 开始唤醒 做包子");
                    System.out.println("老板包子做好了");
                    baoZi.flag = true;
                }
            }
        }


    }
}

class chihuo implements Runnable {
    BaoZi baoZi;

    chihuo(BaoZi baoZi) {
        this.baoZi = baoZi;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (baoZi.lock) {
                if (baoZi.flag == false) { //无 进入等待
                    try {
                        System.out.println("没包子顾客进入等待");
                        baoZi.lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    baoZi.lock.notifyAll();
                    System.out.println("有包子 开始唤醒顾客 吃包子");
                    System.out.println("顾客包子吃完了");
                    baoZi.flag = false;
                }
            }

        }

    }
}

