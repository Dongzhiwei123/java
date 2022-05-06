package Thread01;

/**
 * 强行终止某一线程  stop 容易丢失内存中没有保存的数据
 * 2 打flag 标记
 * 线程不安全  并发条件下 对共享数据的修改
 *          线程排队执行 不能并发 线程同步执行   牺牲效率  换取数据的安全
 * 同步编程模型 ： t1 和 t2 之间 各自执行各自的 互补等待
 * 异步编程模型    t1 和 t2 之间 执行顺序有严格要求  发生了等待关系
 */
public class Thread03 {
    public static void main(String[] args) {
        Thread05 thread05=new Thread05();
        Thread t = new Thread(thread05);
        thread05.flag=false;
    }
}

class Thread04 implements Runnable {

    @Override
    public void run() {

        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(1000);
                System.out.println("子线程->" + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }
}

class Thread05 implements Runnable {
    boolean flag = true;

    @Override
    public void run() {
        if (flag) {
            try {
                for (int i = 0; i < 10; i++) {
                    Thread.sleep(1000);
                    System.out.println("子线程->" + Thread.currentThread().getName());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            return;
        }

    }
}