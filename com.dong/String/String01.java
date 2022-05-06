package String;

public class String01 {
    public static void main(String[] args) {
        String a=new String("1111");
        String b="1231";
        String c="1111";
        System.out.println(b.substring(0, 1));
        System.out.println(b.substring(0, b.length()));
        System.out.println(c==b);

    }
}
