import java.io.*;

public class UppercaseToLowercaseConverter {

    public static void main(String[] args) {
        String inputFile = "input.txt";     // Replace with your input file
        String outputFile = "output.txt";

        try (
            // Reader and Writer with character encoding (UTF-8)
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(new FileInputStream(inputFile), "UTF-8"));
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream(outputFile), "UTF-8"))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toLowerCase());
                writer.newLine(); // maintain line breaks
            }

            System.out.println("File successfully converted to lowercase and saved to " + outputFile);

        } catch (IOException e) {
            System.out.println("An error occurred during file processing:");
            e.printStackTrace();
        }
    }
}

