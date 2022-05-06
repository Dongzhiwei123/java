import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ComparatorTest {
    public static void main(String[] args) {
 
        Employee e1 = new Employee("John", 25, 3000, 9922001);
        Employee e2 = new Employee("Ace", 22, 2000, 5924001);
        Employee e3 = new Employee("Keith", 35, 4000, 3924401);
 
        List<Employee> employees = new ArrayList<>();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        List<Employee> collect = employees.stream().sorted(Comparator.comparing(Employee::getAge)
                .thenComparing(Employee::getSalary)
                .thenComparing(Employee::getName)
        ).collect(Collectors.toList());
        System.out.println(collect);
    }
}
 

class Employee {
    String name;
    int age;
    double salary;
    long mobile;
 
    // constructors, getters & setters
 
 
    public Employee(String name, int age, double salary, long mobile) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.mobile = mobile;
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
 
    public double getSalary() {
        return salary;
    }
 
    public void setSalary(double salary) {
        this.salary = salary;
    }
 
    public long getMobile() {
        return mobile;
    }
 
    public void setMobile(long mobile) {
        this.mobile = mobile;
    }
 
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Employee{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", salary=").append(salary);
        sb.append(", mobile=").append(mobile);
        sb.append('}');
        return sb.toString();
    }
}