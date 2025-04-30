import java.util.*;
import java.util.stream.Collectors;

public class FilterStrings {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Andrew", "Mark", "Angela", "Steve");

        List<String> filtered = names.stream()
            .filter(name -> !name.startsWith("A"))
            .collect(Collectors.toList());

        System.out.println("Filtered list (excluding names starting with 'A'): " + filtered);
    }
}

