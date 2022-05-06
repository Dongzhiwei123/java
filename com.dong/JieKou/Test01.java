package JieKou;

 class Test01 {
     public static void main(String[] args) {
         In1Impl in1=new In1Impl();
         System.out.println(In1.i);
         In1.method2();
     }
}
interface In1{
     static int i=1;
    default void mothod1(){
        System.out.println(11);
    };
      static void method2(){
        System.out.println("静态方法 method4");
    }
      void method3();
}
class In1Impl implements  In1{
    @Override
    public void method3() {
        System.out.println("333");
    }
}