import java.util.*;

class Person {
    String name;
    int age;
    double salary;

    public Person(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return name + " | Age: " + age + " | Salary: " + salary;
    }
}

public class SortPersonList {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
            new Person("John", 28, 30000),
            new Person("Emma", 22, 40000),
            new Person("Mike", 35, 25000),
            new Person("Anna", 30, 35000)
        );

        people.sort(Comparator.comparingInt(p -> p.age));

        System.out.println("Sorted by age (ascending):");
        people.forEach(System.out::println);
    }
}

