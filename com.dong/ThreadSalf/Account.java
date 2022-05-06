package ThreadSalf;

/**
 * synchronized   同步锁  占有锁的线程才可以继续往下执行代码  Java中任何一个对象都具有一把锁
 *
 * synchronized   加在方法上锁的是同步方法  锁的对象只能是this  ddan'xio'ao'l */
public class Account {
    String accNo;
    double money;


    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Account() {
    }

    public Account(String accNo, double money) {
        this.accNo = accNo;
        this.money = money;
    }
    public synchronized void drowWith(double money) throws InterruptedException {
      //多线程共享对象
            double before = this.money;
            double drow = money;
            Thread.sleep(1000);
            double dorw = before - drow;
            setMoney(dorw);
    }

   /* public void drowWith(double money) throws InterruptedException {
        synchronized (this) {//多线程共享对象
            double before = this.money;
            double drow = money;
            Thread.sleep(1000);
            double dorw = before - drow;
            setMoney(dorw);
        }*/

    }


class DrowMoenyTest {
    public static void main(String[] args) {
        Account account = new Account("001", 10000D);
        Thread t1 = new Thread(new DrowMoney(account));
        Thread t2 = new Thread(new DrowMoney(account));
        t1.start();
        t2.start();

    }
}

class DrowMoney implements Runnable {
    private Account account;

    public DrowMoney(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        try {
            account.drowWith(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("账户：" + account.getAccNo() + "余额" + account.getMoney());


    }
}