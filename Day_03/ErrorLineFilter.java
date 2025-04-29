import java.io.*;

public class ErrorLineFilter {

    public static void main(String[] args) {
        String filePath = "largefile.txt";  

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int count = 0;

            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains("error")) {
                    System.out.println(line);
                    count++;
                }
            }

            System.out.println("\nTotal lines containing 'error': " + count);

        } catch (IOException e) {
            System.out.println("An error occurred while reading the file:");
            e.printStackTrace();
        }
    }
}

