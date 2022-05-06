package ComparatorTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Person {
    private String name;
    private int age;

    public Person() {

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
class Test {
    public static void main(String[] args) {
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("ccc", 20));
        list.add(new Person("AAA", 30));
        list.add(new Person("bbb", 30));
        list.add(new Person("ddd", 40));
        /*  Collections.sort(list,  (o1,o2)->{
               if (o1.getAge()==o2.getAge()){
                   return o1.getName().compareTo(o2.getName());
                }else {
                    return  o1.getAge()-o2.getAge();
                }
          });*/
        Collections.sort(list,Comparator.comparing(Person::getAge).thenComparing(Person::getName));



    }
}