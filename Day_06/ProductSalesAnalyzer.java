import java.util.*;
import java.util.stream.*;

class Sale {
    String productId;
    int quantity;
    double price;

    public Sale(String productId, int quantity, double price) {
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }
}

class ProductSales {
    String productId;
    double totalRevenue;

    public ProductSales(String productId, double totalRevenue) {
        this.productId = productId;
        this.totalRevenue = totalRevenue;
    }

    public String toString() {
        return productId + " - $" + totalRevenue;
    }
}

public class ProductSalesAnalyzer {

    public static void analyzeSales(List<Sale> sales) {
        List<ProductSales> topProducts = sales.stream()
            .filter(s -> s.quantity > 10)
            .map(s -> new ProductSales(s.productId, s.quantity * s.price))
            .collect(Collectors.groupingBy(ps -> ps.productId, Collectors.summingDouble(ps -> ps.totalRevenue)))
            .entrySet().stream()
            .map(entry -> new ProductSales(entry.getKey(), entry.getValue()))
            .sorted(Comparator.comparingDouble(ps -> -ps.totalRevenue))
            .limit(5)
            .collect(Collectors.toList());

        System.out.println("Top 5 Products by Total Revenue:");
        topProducts.forEach(System.out::println);
    }

    public static void main(String[] args) {
        List<Sale> sales = Arrays.asList(
            new Sale("P1", 15, 10.0),
            new Sale("P2", 5, 25.0),
            new Sale("P3", 12, 20.0),
            new Sale("P1", 8, 10.0),
            new Sale("P4", 20, 5.0),
            new Sale("P5", 30, 3.0),
            new Sale("P6", 50, 2.0),
            new Sale("P7", 9, 100.0)
        );

        analyzeSales(sales);
    }
}

