import java.util.*;
import java.util.stream.*;

class Book {
    String title;
    String author;
    String genre;
    double rating;

    public Book(String title, String author, String genre, double rating) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.rating = rating;
    }
}

class BookRecommendation {
    String title;
    double rating;

    public BookRecommendation(String title, double rating) {
        this.title = title;
        this.rating = rating;
    }

    public String toString() {
        return title + " - Rating: " + rating;
    }
}

public class BookRecommender {

    public static List<List<BookRecommendation>> recommendBooks(List<Book> books) {
        List<BookRecommendation> recommendations = books.stream()
            .filter(b -> b.genre.equals("Science Fiction") && b.rating > 4.0)
            .map(b -> new BookRecommendation(b.title, b.rating))
            .sorted(Comparator.comparingDouble((BookRecommendation br) -> br.rating).reversed())
            .limit(10)
            .collect(Collectors.toList());

        List<List<BookRecommendation>> pages = new ArrayList<>();
        for (int i = 0; i < recommendations.size(); i += 5) {
            pages.add(recommendations.subList(i, Math.min(i + 5, recommendations.size())));
        }
        return pages;
    }

    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
            new Book("Book A", "Author 1", "Science Fiction", 4.5),
            new Book("Book B", "Author 2", "Science Fiction", 4.2),
            new Book("Book C", "Author 3", "Fantasy", 4.8),
            new Book("Book D", "Author 4", "Science Fiction", 3.9),
            new Book("Book E", "Author 5", "Science Fiction", 4.9),
            new Book("Book F", "Author 6", "Science Fiction", 4.3),
            new Book("Book G", "Author 7", "Science Fiction", 4.6),
            new Book("Book H", "Author 8", "Science Fiction", 4.1),
            new Book("Book I", "Author 9", "Science Fiction", 4.7),
            new Book("Book J", "Author 10", "Science Fiction", 4.4),
            new Book("Book K", "Author 11", "Science Fiction", 4.0),
            new Book("Book L", "Author 12", "Science Fiction", 4.85)
        );

        List<List<BookRecommendation>> paginated = recommendBooks(books);

        for (int i = 0; i < paginated.size(); i++) {
            System.out.println("Page " + (i + 1) + ":");
            paginated.get(i).forEach(System.out::println);
            System.out.println();
        }
    }
}

