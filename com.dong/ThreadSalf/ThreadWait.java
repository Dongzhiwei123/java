package ThreadSalf;

public class ThreadWait {
    static Object lock = new Object();

    public static void main(String[] args) {
        new Thread(()->{
            synchronized (lock){
                System.out.println("无限等待线程:准备进入无限等待状态...");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("无限等待状态被唤醒");
            }

        }).start();
        new Thread(()->{
            synchronized (lock){
                System.out.println("唤醒线程: 准备唤醒无限等待线程...");
                lock.notify();
                System.out.println("唤醒线程: 唤醒完毕");
            }
        }).start();
    }
}
