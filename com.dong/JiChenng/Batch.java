package JiChenng;

public class Batch {
    public  void process(){}
    public void excute(){
        process();
    }
}
class  Service extends Batch{
    @Override
    public  void  process(){
        System.out.println(111);
    }
}
class  Test{
    public static void main(String[] args) {
        Batch service=new Service();
        service.excute();
    }
}