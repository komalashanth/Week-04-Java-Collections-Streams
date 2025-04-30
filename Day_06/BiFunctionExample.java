import java.util.function.*;

public class BiFunctionExample {
    public static void main(String[] args) {
        BiFunction<String, String, String> concatenateWithSpace = (s1, s2) -> s1 + " " + s2;

        String str1 = "Hello";
        String str2 = "World";

        String result = concatenateWithSpace.apply(str1, str2);

        System.out.println("Concatenated string: " + result);
    }
}

