import java.util.*;
import java.util.function.*;

public class ConsumerExample {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("apple", "banana", "mango");

        Consumer<String> printUpperCase = s -> System.out.println(s.toUpperCase());

        fruits.forEach(printUpperCase);
    }
}

