public class ExceptionPropagationDemo {

    // Method 1: Throws ArithmeticException
    public static void method1() {
        int result = 10 / 0; // Will throw ArithmeticException
    }

    // Method 2: Calls method1()
    public static void method2() {
        method1();
    }

    // Main method: Calls method2() and handles the exception
    public static void main(String[] args) {
        try {
            method2();
        } catch (ArithmeticException e) {
            System.out.println("Handled exception in main");
        }
    }
}

