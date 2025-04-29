public class CircularBuffer {
    private int[] buffer;
    private int size;
    private int start;
    private int count;

    public CircularBuffer(int size) {
        this.size = size;
        this.buffer = new int[size];
        this.start = 0;
        this.count = 0;
    }

    public void insert(int value) {
        int end = (start + count) % size;
        buffer[end] = value;
        if (count < size) {
            count++;
        } else {
            start = (start + 1) % size; // Overwrite oldest
        }
    }

    public void display() {
        System.out.print("Buffer Elements: ");
        for (int i = 0; i < count; i++) {
            System.out.print(buffer[(start + i) % size] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(3);
        cb.insert(1);
        cb.insert(2);
        cb.insert(3);
        cb.display(); // 1 2 3
        cb.insert(4);
        cb.display(); // 2 3 4
        cb.insert(5);
        cb.display(); // 3 4 5
    }
}

