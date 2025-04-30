@FunctionalInterface
interface SquareCalculator {
    int calculate(int number);

    default void printMessage(int number) {
        System.out.println("The square of " + number + " is: " + calculate(number));
    }
}

public class CustomFunctionalInterface {
    public static void main(String[] args) {
        SquareCalculator squareCalculator = (n) -> n * n;

        int number = 5;
        squareCalculator.printMessage(number);
    }
}

