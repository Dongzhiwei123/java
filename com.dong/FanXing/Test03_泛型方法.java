package FanXing;

import sun.net.www.protocol.http.ntlm.NTLMAuthentication;

//方法的返回值 或者参数类型不确定
public class Test03_泛型方法 {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        student student = genericMethod(student.class);
        System.out.println(student);
    }
    public static  <T> T genericMethod(Class<T>tClass) throws InstantiationException, IllegalAccessException {
        return tClass.newInstance();
    }

}
class student{

}
