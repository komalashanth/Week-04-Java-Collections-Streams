import java.util.*;

interface Category {}

class BookCategory implements Category {}
class ClothingCategory implements Category {}
class GadgetCategory implements Category {}

class Product<T extends Category> {
    String name;
    double price;
    T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public void applyDiscount(double percentage) {
        price -= price * (percentage / 100);
    }

    public double getPrice() { return price; }
    public String getName() { return name; }
    public T getCategory() { return category; }
}

// Example subclasses if needed (not strictly necessary, but helpful for real apps)
class BookProduct extends Product<BookCategory> {
    public BookProduct(String name, double price) {
        super(name, price, new BookCategory());
    }
}

class ClothingProduct extends Product<ClothingCategory> {
    public ClothingProduct(String name, double price) {
        super(name, price, new ClothingCategory());
    }
}

class GadgetProduct extends Product<GadgetCategory> {
    public GadgetProduct(String name, double price) {
        super(name, price, new GadgetCategory());
    }
}

class Marketplace {
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        product.applyDiscount(percentage);
        System.out.println("Discount applied to " + product.getName() + ". New price: " + product.getPrice());
    }
}

public class Main1 {
    public static void main(String[] args) {
        BookProduct book = new BookProduct("Java Programming", 500);
        ClothingProduct shirt = new ClothingProduct("T-Shirt", 300);
        GadgetProduct phone = new GadgetProduct("Smartphone", 15000);

        System.out.println("Before Discount:");
        System.out.println(book.getName() + ": " + book.getPrice());
        System.out.println(shirt.getName() + ": " + shirt.getPrice());
        System.out.println(phone.getName() + ": " + phone.getPrice());

        System.out.println("\nApplying Discounts...");
        Marketplace.applyDiscount(book, 10);
        Marketplace.applyDiscount(shirt, 15);
        Marketplace.applyDiscount(phone, 5);
    }
}

