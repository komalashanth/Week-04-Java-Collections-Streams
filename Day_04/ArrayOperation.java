import java.util.Scanner;

public class ArrayOperation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // You can set this to null to test the NullPointerException case
        int[] numbers = {10, 20, 30, 40, 50}; // or set to null for testing

        try {
            System.out.print("Enter index to retrieve: ");
            int index = scanner.nextInt();

            int value = numbers[index];
            System.out.println("Value at index " + index + ": " + value);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        } catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        }

        scanner.close();
    }
}

