import java.util.LinkedList;
import java.util.ListIterator;

public class NthFromEndFinder {
    public static String findNthFromEnd(LinkedList<String> list, int n) {
        ListIterator<String> fast = list.listIterator();
        ListIterator<String> slow = list.listIterator();

        // Move fast pointer n steps ahead
        for (int i = 0; i < n; i++) {
            if (fast.hasNext()) {
                fast.next();
            } else {
                return null; // N is larger than list size
            }
        }

        // Move both pointers until fast reaches the end
        while (fast.hasNext()) {
            fast.next();
            slow.next();
        }

        return slow.next();
    }

    public static void main(String[] args) {
        LinkedList<String> input = new LinkedList<>();
        input.add("A");
        input.add("B");
        input.add("C");
        input.add("D");
        input.add("E");

        int N = 2;
        String result = findNthFromEnd(input, N);
        System.out.println(result); // Output: D
    }
}

