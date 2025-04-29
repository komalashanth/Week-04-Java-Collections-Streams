import java.io.*;

public class Main {
    public static void main(String[] args) {
        String sourceFile = "source.txt";
        String destinationFile = "destination.txt";

        File inputFile = new File(sourceFile);
        File outputFile = new File(destinationFile);

        if (!inputFile.exists()) {
            System.out.println("Source file does not exist: " + sourceFile);
            return;
        }

        try (
            FileInputStream fis = new FileInputStream(inputFile);
            FileOutputStream fos = new FileOutputStream(outputFile)
        ) {
            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }
            System.out.println("File copied successfully to: " + destinationFile);
        } catch (IOException e) {
            System.out.println("An error occurred while processing the file: " + e.getMessage());
        }
    }
}
