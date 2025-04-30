import java.util.regex.*;
import java.util.*;

public class BadWordCensor {
    public static String censorBadWords(String text, List<String> badWords) {
        for (String word : badWords) {
            text = text.replaceAll("(?i)\\b" + Pattern.quote(word) + "\\b", "****");
        }
        return text;
    }

    public static void main(String[] args) {
        String input = "This is a damn bad example with some stupid words.";
        List<String> badWords = Arrays.asList("damn", "stupid");

        String censored = censorBadWords(input, badWords);
        System.out.println(censored);
    }
}

