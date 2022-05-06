package FanXing;

public class Test04_泛型接口 {
    public static void main(String[] args) {
        Generator generator=new GeneratorImpl01<String>();
        Object next = generator.next();
        GeneratorImpl02 generatorImpl02 = new GeneratorImpl02();
        String next1 = generatorImpl02.next();
    }
}
interface Generator<T>{
    T next();
}
class GeneratorImpl01<T> implements Generator<T>{
    @Override
    public T next() {
        return null;
    }
}
class GeneratorImpl02 implements Generator<String>{
    @Override
    public String next() {
        return "1111";
    }
}