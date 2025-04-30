import java.util.regex.*;
import java.util.*;

public class LanguageExtractor {
    public static List<String> extractLanguages(String text) {
        List<String> languages = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\b(Java|Python|JavaScript|Go)\\b");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            languages.add(matcher.group());
        }

        return languages;
    }

    public static void main(String[] args) {
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";
        List<String> languages = extractLanguages(text);

        for (String language : languages) {
            System.out.println(language);
        }
    }
}

