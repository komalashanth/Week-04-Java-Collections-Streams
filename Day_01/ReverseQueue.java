import java.util.LinkedList;
import java.util.Queue;

public class ReverseQueue {
    public static Queue<Integer> reverse(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            return queue;
        }
        int item = queue.remove();
        reverse(queue);
        queue.add(item);
        return queue;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);

        System.out.println("Original Queue: " + queue);
        reverse(queue);
        System.out.println("Reversed Queue: " + queue);
    }
}

