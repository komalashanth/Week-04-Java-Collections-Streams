import java.util.function.*;

public class CircleArea {
    public static void main(String[] args) {
        Function<Double, Double> areaCalculator = radius -> Math.PI * radius * radius;

        double radius = 5.0;
        double area = areaCalculator.apply(radius);

        System.out.println("Area of circle with radius " + radius + ": " + area);
    }
}

