@FunctionalInterface
interface SumFunction {
    int apply(int a, int b);
}

public class SumDemo {
    public static void main(String[] args) {
        SumFunction sum = (a, b) -> a + b;
        int result = sum.apply(10, 25);
        System.out.println("Sum: " + result);
    }
}

