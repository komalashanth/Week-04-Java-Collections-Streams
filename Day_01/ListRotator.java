import java.util.*;

public class ListRotator {
    public static List<Integer> rotateList(List<Integer> list, int k) {
        int n = list.size();
        k = k % n;  // Handle rotation greater than list size
        List<Integer> rotated = new ArrayList<>();

        rotated.addAll(list.subList(k, n));
        rotated.addAll(list.subList(0, k));

        return rotated;
    }

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(10, 20, 30, 40, 50);
        int k = 2;
        List<Integer> result = rotateList(input, k);
        System.out.println(result);
    }
}

