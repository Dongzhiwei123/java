package ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPool01 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        // 空线程池  调用submit 自动创建线程  用完归还至线程池
        executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName() + "1");
        });
        Thread.sleep(1000);//1 线程执行完毕归还线程到线程池
        executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName() + "2");

        });
        executorService.shutdown();
    }
}
 class ThreadPool02{
     public static void main(String[] args) throws InterruptedException {
         ExecutorService executorService = Executors.newFixedThreadPool(10);//指定线程最大数目
         ThreadPoolExecutor t=(ThreadPoolExecutor) executorService;
         System.out.println(t.getPoolSize());

           executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName() + "1");
        });
        Thread.sleep(10000);//1 线程执行完毕归还线程到线程池
        executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName() + "2");

        });
         System.out.println(t.getPoolSize());
        executorService.shutdown();
     }
 }
