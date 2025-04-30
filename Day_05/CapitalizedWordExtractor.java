import java.util.regex.*;
import java.util.*;

public class CapitalizedWordExtractor {
    public static List<String> extractCapitalizedWords(String text) {
        List<String> capitalizedWords = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\b[A-Z][a-zA-Z]*\\b");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            capitalizedWords.add(matcher.group());
        }

        return capitalizedWords;
    }

    public static void main(String[] args) {
        String text = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";
        List<String> words = extractCapitalizedWords(text);

        for (String word : words) {
            System.out.println(word);
        }
    }
}

