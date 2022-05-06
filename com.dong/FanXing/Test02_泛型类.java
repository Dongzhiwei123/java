package FanXing;
//成员变量 或这成员方法的返回值不确定
public class Test02_泛型类 {
    public static void main(String[] args) {
        Generic<String> generic=new Generic<>("001");
        generic.getKey();
    }
}
class Generic<T> {
    private  T key;
    Generic(T key){
        this.key=key;
    }
    public  T getKey(){
        return  key;
    }
}
