import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class PredicateComposition {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("subject", "apple", "submarine", "test", "submission");

        Predicate<String> lengthGreaterThan5 = s -> s.length() > 5;
        Predicate<String> containsSub = s -> s.contains("sub");

        List<String> filteredWords = words.stream()
            .filter(lengthGreaterThan5.and(containsSub))
            .collect(Collectors.toList());

        System.out.println("Filtered list based on conditions: " + filteredWords);
    }
}

