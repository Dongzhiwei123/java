package DamenTask;

/**
 * Java　中线程分为两张：用户线程　和守护线程　　　典型　：垃圾回收线程
 * 一般是一个死循环　用户线程结束　守护线程自动结束
 * Thread.setDamon 将线程设置为守护线程
 */
public class DaskTask01 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new DamonTask());
        thread.setDaemon(true);
        thread.start();

        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            System.out.println(i);
        }
    }
}

class DamonTask implements Runnable {

    @Override
    public void run() {
        int i = 0;
        while (true) {
            System.out.println("备份--->" + ++i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
