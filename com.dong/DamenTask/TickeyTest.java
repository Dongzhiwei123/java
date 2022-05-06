package DamenTask;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TickeyTest {
    public static void main(String[] args) {
        SellTicket sellTicket = new SellTicket();
        Thread t1 = new Thread(sellTicket, "t1");
        Thread t2 = new Thread(sellTicket, "t2");
        Thread t3 = new Thread(sellTicket, "t3");
        t1.start();
        t2.start();
        t3.start();
    }
}
class SellTicket extends Thread {
    Lock lock = new ReentrantLock();
    private int tickey = 100;
    @Override
    public void run() {
        while (true) {
            lock.lock();
            try {
                if (tickey > 0) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    /*
                     * 1 2 3 同时休眠在这里
                     * 1  醒来 执行 sout 未来得及执行 tickey---  2 拿到了 执行权  重复买票
                     * 1  醒来 执行到了 tickey--  没来的及退出  2 拿到了执行权  出售 0 张票
                     * 2  执行了tic--  3 拿到了执行权 出售-1 张票
                     * */
                    System.out.println("线程" + Thread.currentThread().getName() + "出售--->" + tickey + "票");
                    tickey--;
                }
            }finally {
                lock.unlock();
            }
        }


    }
}

