package Thread01;
/*
*    实现线程的两张方法
		* 继承Thread 类 重新run 方法
		* 实现runable 接口 重新 run 方法
		* start 方法执行再内存中分配一片空间 瞬间执行完毕   分配空间完成后 自动调用run 方法
        * start 方法执行再内存中分配一片空间 瞬间执行完毕   分配空间完成后 自动调用run 方法
        * run 方法和start 方法的区别
        * run方法中：只是普通的方法调用 仍会再主线程栈中压栈
        * start 方法  另外起一个线程  再子线程中进行方法的压栈
        * 单线程 cpu  并不是真正意义的多线程，再多个线程之间来回切换 给人一种错觉
        线程的生命周期
        *   new Thread 进入新建装态
        *   调用start 方法进入就绪状态   可以抢夺cpU 执行权
        *   run方法开始执行 意味着 抢夺到cpu 执行权 进入运行状态  当抢夺到的时间片用完后 重新进入 就绪状态 从新抢夺cpu 执行权
        *   阻塞 当运行线程执行遇到阻塞时间 如scanner  进入阻塞状态  释放抢夺到的cpU 执行权    阻塞解除后 重新进入 就绪状态
*           死亡
*
* */
public class Mythread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("子线程--->" + i);
        }
    }
}

class Test {
    public static void main(String[] args) {
        Thread thread = new Mythread();
        thread.start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("主线程-->" + i);
        }
    }
}

class Mythread2 implements Runnable {
    @Override
    public void run() {

    }
}

class TestMythread2 {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println("子线程--->" + i);
                }
            }
        });
        thread.start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("主线程--->" + i);
        }
    }
}
