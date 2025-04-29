import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class WordFrequencyCounter {

    public static void main(String[] args) {
        String filePath = "sample.txt";  
        Map<String, Integer> wordCount = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                
                String[] words = line.toLowerCase().split("\\W+"); 
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }

            
            List<Entry<String, Integer>> sortedList = new ArrayList<>(wordCount.entrySet());
            sortedList.sort((a, b) -> b.getValue().compareTo(a.getValue()));

           
            System.out.println("Top 5 most frequent words:");
            for (int i = 0; i < Math.min(5, sortedList.size()); i++) {
                Entry<String, Integer> entry = sortedList.get(i);
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

        } catch (IOException e) {
            System.out.println("An error occurred while reading the file:");
            e.printStackTrace();
        }
    }
}

