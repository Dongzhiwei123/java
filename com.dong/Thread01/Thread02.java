package Thread01;

/**
 * 获取当前线程的名子
 * Thread.currentThread.getName 静态方法谁调用线程名称就是谁
 * 线程休眠：sleep 方法 让线程进入阻塞 状态  并归还抢夺到的cpu 时间片
 * 终止线程的休眠：t.interrupt 强行终止线程休眠
 */
public class Thread02 {
    public static void main(String[] args) {
        Thread thread = new Thread(new Threa03());
        System.out.println("主线程名称-->:" + Thread.currentThread().getName());
        thread.setName("thread-zi");
        thread.start();
        thread.interrupt();

    }
}

class Threa03 implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("子线程名称-->:" + Thread.currentThread().getName());
            Thread.sleep(1000 * 60 * 60 * 24);
            System.out.println("线程休眠");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("子线程名称-->:" + Thread.currentThread().getName() + i);
        }
    }
}



