import java.util.*;

public class SymmetricDifference {
    public static Set<Integer> findSymmetricDifference(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = new HashSet<>(set1);
        Set<Integer> temp = new HashSet<>(set2);

        result.removeAll(set2);
        temp.removeAll(set1);

        result.addAll(temp);
        return result;
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5));

        Set<Integer> result = findSymmetricDifference(set1, set2);
        System.out.println(result);
    }
}

