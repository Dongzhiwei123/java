package ThreadSalf;



public class MyThread extends Thread {
   static  volatile  boolean flag = false;

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("修改后flag的值为" + flag);
    }
}
/**
 *1  主内存中开辟了共享变量 a
 * 2  主线程 和 子线程 分别拷贝 主内存 到自己内存 中进行 运算 互不干扰
 * 3  当运算完成后 重新写回 共享变量 a 中
 * 4 当主线程重新获取flag 的值的时候 可能
 *
 *
 * */
class Test {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();
        while (true) {
            if (MyThread.flag) {
                System.out.println("死循环结束");
                break;
            }
        }
    }
}
class  YuanZi extends  Thread{
      static volatile int a = 0;

    @Override
  public void run() {
        // 任务:对共享变量a自增10万次
      for (int i = 0; i < 100000; i++) {
            a++;
        }
        System.out.println("子线程执行完毕!");
    }
}
/**
 * a++ 1  自增  2 写如变量副本  3 同步到共享变量
 *  子线程 执行了 a++ 操作 0--1  写入到了 变量副本  但是未来的及写入 共享变量    0---->1
 *  主线程 执行了 a++ 操作 0---> 写入到了 变量副本 共享变量  0--->1
 *  两次操作只将变量写到了1
 * */
class YuanZiTest {
    public static void main(String[] args) throws InterruptedException {
        YuanZi mt = new YuanZi();
        // 启动线程
        mt.start();

        // 主线程对共享变量a自增10万次
        for (int i = 0; i < 100000; i++) {
            YuanZi.a++;
        }

        // 暂停,保证主线程和子线程都对共享变量a自增完了10万次,再统计a的结果
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 打印最终共享变量a的值
        System.out.println("最终:" + YuanZi.a);// 最终:162243

    }
}

