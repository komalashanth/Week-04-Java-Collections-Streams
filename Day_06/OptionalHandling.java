import java.util.*;
import java.util.stream.*;

public class OptionalHandling {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);

        Optional<Integer> max = numbers.stream()
            .max(Integer::compareTo);

        max.ifPresentOrElse(
            value -> System.out.println("Maximum value: " + value),
            () -> System.out.println("The list is empty")
        );
    }
}

