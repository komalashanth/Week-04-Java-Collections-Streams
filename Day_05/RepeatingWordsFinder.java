import java.util.regex.*;
import java.util.*;

public class RepeatingWordsFinder {
    public static List<String> findRepeatingWords(String text) {
        List<String> repeatingWords = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\b(\\w+)\\b");
        Matcher matcher = pattern.matcher(text);
        
        Set<String> words = new HashSet<>();
        Set<String> repeatedWords = new HashSet<>();

        while (matcher.find()) {
            String word = matcher.group(1).toLowerCase();
            if (!words.add(word)) {
                repeatedWords.add(word);
            }
        }

        repeatingWords.addAll(repeatedWords);
        return repeatingWords;
    }

    public static void main(String[] args) {
        String text = "This is is a repeated repeated word test.";
        List<String> repeatingWords = findRepeatingWords(text);

        for (String word : repeatingWords) {
            System.out.println(word);
        }
    }
}

