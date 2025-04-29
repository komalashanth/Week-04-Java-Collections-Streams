import java.util.*;

public class InvertMap {
    public static void main(String[] args) {
        Map<String, Integer> original = new HashMap<>();
        original.put("A", 1);
        original.put("B", 2);
        original.put("C", 1);

        Map<Integer, List<String>> inverted = new HashMap<>();

        for (Map.Entry<String, Integer> entry : original.entrySet()) {
            int value = entry.getValue();
            String key = entry.getKey();
            inverted.computeIfAbsent(value, k -> new ArrayList<>()).add(key);
        }

        System.out.println(inverted);
    }
}

